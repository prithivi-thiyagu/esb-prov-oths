package com.bandhanbank.esb.prov.oths.service;

import com.bandhanbank.esb.common.util.BaseDTOs.ESBBaseDTOs.ESBTransactionStatusBaseDTO;
import com.bandhanbank.esb.common.util.BaseDTOs.ProviderBaseDTOs.FCCArgsZeroBaseDTO;
import com.bandhanbank.esb.common.util.Logger.Components.LogEnvelopeParameters;
import com.bandhanbank.esb.common.util.Logger.Services.RequestLoggingService;
import com.bandhanbank.esb.common.util.Logger.Services.ResponseLoggingService;
import com.bandhanbank.esb.prov.oths.ESBBaseDTOs.FCCAlterRegisterDeRegister.ResponseDTO.ESBAlertRegisterDeRegisterResponse;
import com.bandhanbank.esb.prov.oths.ProviderBaseDTOs.FCCAlertRegisterDeRegister.RequestDTOs.FCCAlertRegisterDeRegisterRequest;
import com.bandhanbank.esb.prov.oths.ProviderBaseDTOs.FCCAlertRegisterDeRegister.ResponseDTOs.FCCAlertRegisterDeRegisterResponse;
import com.bandhanbank.esb.prov.oths.mapper.CustomMapping;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Service
public class FCCAlterRegisterDeRegisterService {

    @Autowired
    Environment environment;

    @Value("${fcalterregisterderegister.url}")
    private String url;

    @Value("${alRegDereg.bankCode}")
    private Integer bankCode;
    @Value("${alRegDereg.transactionBranch}")
    private Integer transactionBranch;
    @Value("${alRegDereg.userNo}")
    private Long userNo;
    @Value("${alRegDereg.channel}")
    private String channel;
    @Value("${alRegDereg.userId}")
    private String userId;
    @Value("${alRegDereg.serviceCode}")
    private String serviceCode;


//    private final RestTemplate restTemplate;

    private final LogEnvelopeParameters logEnvelopeParameters;
    private final RequestLoggingService requestLoggingService;
    private final ResponseLoggingService responseLoggingService;
    private final CustomMapping customMapping;
    private final RestTemplate restTemplate;

    @Autowired
    public FCCAlterRegisterDeRegisterService(LogEnvelopeParameters logEnvelopeParameters,
                                             RequestLoggingService requestLoggingService,
                                             ResponseLoggingService responseLoggingService,
                                             CustomMapping customMapping, RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
        this.logEnvelopeParameters = logEnvelopeParameters;
        this.requestLoggingService = requestLoggingService;
        this.responseLoggingService = responseLoggingService;
        this.customMapping = customMapping;
        this.restTemplate = restTemplate;
    }

    public ESBAlertRegisterDeRegisterResponse fccAlertRegisterDeRegisterInvoke(
            FCCAlertRegisterDeRegisterRequest provRequest,
            Map<String, String> headers,
            Map<String, String> queryParameters) throws IOException {

        providerRequestValidation(provRequest, headers);

        HttpHeaders headers1 = new HttpHeaders();
        headers1.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<FCCAlertRegisterDeRegisterRequest> httpEntity = new HttpEntity<>(provRequest, headers1);

        // log provider request
        logEnvelopeParameters.setBody(provRequest);
        logEnvelopeParameters.setLogType("PROV RQ");
        requestLoggingService.log(logEnvelopeParameters);

        ESBAlertRegisterDeRegisterResponse esbResponse = new ESBAlertRegisterDeRegisterResponse();
        //FCCAlertRegisterDeRegisterResponse fccResponse = new ObjectMapper().readValue(new File(url), FCCAlertRegisterDeRegisterResponse.class);
        ResponseEntity<FCCAlertRegisterDeRegisterResponse> fccResponse = restTemplate.postForEntity(url, httpEntity, FCCAlertRegisterDeRegisterResponse.class);

        //log provider response
        logEnvelopeParameters.setBody(fccResponse);
        logEnvelopeParameters.setLogType("PROV RS");
        responseLoggingService.log(logEnvelopeParameters);

        ESBTransactionStatusBaseDTO esbTransaction = customMapping.fccTOEsbTransaction(fccResponse.getBody().getTransactionStatus());
        esbResponse.setTransactionStatus(esbTransaction);

        return esbResponse;

    }

    private void providerRequestValidation(FCCAlertRegisterDeRegisterRequest provRequest,
                                           Map<String, String> headers) {


        if(provRequest.getArgs0() == null)
            provRequest.setArgs0(new FCCArgsZeroBaseDTO());

        if (provRequest.getArgs0().getExternalReferenceNo() == null)
            provRequest.getArgs0().setExternalReferenceNo(headers.get("x-session-id"));

        if (provRequest.getArgs0().getBankCode() == null)
            provRequest.getArgs0().setBankCode(bankCode);

        if (provRequest.getArgs0().getTransactionBranch() == null)
            provRequest.getArgs0().setTransactionBranch(transactionBranch);

        if (provRequest.getArgs0().getChannel() == null)
            provRequest.getArgs0().setChannel(channel);

        if (provRequest.getArgs0().getUserId() == null)
            provRequest.getArgs0().setUserId(userId);

        if (provRequest.getArgs0().getServiceCode() == null)
            provRequest.getArgs0().setServiceCode(serviceCode);

        if (provRequest.getArgs0().getUserNo() == null)
            provRequest.getArgs0().setUserNo(userNo);

        // List of channels allowed to customize "AlertType" field's value
        String channels = environment.getProperty("alertType.channel.list");
        List<String> channelList = Arrays.asList(channels.split(","));

        // "AlertType" field validation
        if (
                !(  (provRequest.getArgs1().getAlertType() != null) &&
                    !(provRequest.getArgs1().getAlertType().isEmpty()) &&
                    (headers.get("x-channel-id") != null) &&
                    (channelList.contains(headers.get("x-channel-id")))
                )
        )
            provRequest.getArgs1().setAlertType("C");

        // "AlertModeType" field validation
        if(
                !(  (provRequest.getArgs1().getAlertModeType() != null) &&
                    !(provRequest.getArgs1().getAlertModeType().isEmpty())
                )
        )
            provRequest.getArgs1().setAlertModeType("B");

    }

}
