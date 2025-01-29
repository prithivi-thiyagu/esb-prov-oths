package com.bandhanbank.esb.prov.oths.controller;


import com.bandhanbank.esb.common.util.ExceptionHandler.Exceptions.CustomExceptions.ReplyCodeNotZeroException;
import com.bandhanbank.esb.common.util.Logger.Components.LogEnvelopeParameters;
import com.bandhanbank.esb.common.util.Logger.Services.RequestLoggingService;
import com.bandhanbank.esb.common.util.Logger.Services.ResponseLoggingService;
import com.bandhanbank.esb.common.util.Logger.Services.SetLogEnvelopeParameterService;
import com.bandhanbank.esb.prov.oths.ESBBaseDTOs.FCCAlterRegisterDeRegister.RequestDTO.ESBAlertRegisterDeRegisterRequest;
import com.bandhanbank.esb.prov.oths.ESBBaseDTOs.FCCAlterRegisterDeRegister.ResponseDTO.ESBAlertRegisterDeRegisterResponse;

import com.bandhanbank.esb.prov.oths.ProviderBaseDTOs.FCCAlertRegisterDeRegister.RequestDTOs.FCCAlertRegisterDeRegisterRequest;
import com.bandhanbank.esb.prov.oths.mapper.CustomMapping;

import com.bandhanbank.esb.prov.oths.service.FCCAlterRegisterDeRegisterService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/prov/fcc")
public class AppController {

    private final SetLogEnvelopeParameterService setLogEnvelopeParameterService;
    private final RequestLoggingService requestLoggingService;
    private final ResponseLoggingService responseLoggingService;
    private final FCCAlterRegisterDeRegisterService service;
    private final CustomMapping customMapping;
    private final ObjectMapper objectMapper;

    @Autowired
    public AppController(SetLogEnvelopeParameterService setLogEnvelopeParameterService, RequestLoggingService requestLoggingService, ResponseLoggingService responseLoggingService, CustomMapping customMapping, FCCAlterRegisterDeRegisterService service, ObjectMapper objectMapper)
    {
        this.setLogEnvelopeParameterService = setLogEnvelopeParameterService;
        this.requestLoggingService = requestLoggingService;
        this.responseLoggingService = responseLoggingService;
        this.customMapping = customMapping;
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @PostMapping(path="/v1/others/fcalertregisterderegister",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> fccAlertRegisterDeRegister(@Valid @RequestBody ESBAlertRegisterDeRegisterRequest esbRequest , @RequestHeader  Map<String,String> headers,

                                                             @RequestParam Map<String, String> queryParameters) throws IOException {


               if (!headers.containsKey("x-session-id") || headers.get("x-session-id").isEmpty())
                   headers.put("x-session-id", UUID.randomUUID().toString());

               LogEnvelopeParameters logEnvelopeParameters = setLogEnvelopeParameterService.
                       setLogEnveloperParameters(esbRequest, headers, queryParameters, "V1",
                               "fcalertregisterderegister", "others", "ESB RQ", "INFO");

               requestLoggingService.log(logEnvelopeParameters);

               FCCAlertRegisterDeRegisterRequest fccRequest = customMapping.esbToFccRequest(esbRequest);
               ESBAlertRegisterDeRegisterResponse esbResponse = service.fccAlertRegisterDeRegisterInvoke(fccRequest, headers, queryParameters);

               if(!esbResponse.getTransactionStatus().getReplyCode().equals("0"))
               {
                 throw new ReplyCodeNotZeroException(objectMapper.writeValueAsString(esbResponse));
               }
               // log ESB response
               logEnvelopeParameters.setBody(esbResponse);
               logEnvelopeParameters.setLogType("ESB RS");
               responseLoggingService.log(logEnvelopeParameters);

               return new ResponseEntity<String>(objectMapper.writeValueAsString(esbResponse), HttpStatus.OK);

    }

}
