package com.bandhanbank.esb.prov.oths.mapper;

import com.bandhanbank.esb.common.util.BaseDTOs.ESBBaseDTOs.ESBTransactionStatusBaseDTO;
import com.bandhanbank.esb.common.util.BaseDTOs.ProviderBaseDTOs.FCCTransactionStatusBaseDTO;
import com.bandhanbank.esb.prov.oths.ESBBaseDTOs.FCCAlterRegisterDeRegister.RequestDTO.ESBAlertRegisterDeRegisterRequest;
import com.bandhanbank.esb.prov.oths.ProviderBaseDTOs.FCCAlertRegisterDeRegister.RequestDTOs.FCCAlertRegisterDeRegisterRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomMapping {
    CustomMapping INSTANCE = Mappers.getMapper(CustomMapping.class);

    @Mappings({
            @Mapping(source = "sessionContext", target = "args0"),
            @Mapping(source = "validationFlag", target = "args1.validationFlag"),
            @Mapping(source = "externalTaskCode", target = "args1.externalTaskCode"),
            @Mapping(source = "externalLocalDateText", target = "args1.externalLocalDateText"),
            @Mapping(source = "listOfvalidationErrors", target = "args1.listOfvalidationErrors"),
            @Mapping(source = "customerId", target = "args1.customerId"),
            @Mapping(source = "alertType", target = "args1.alertType"),
            @Mapping(source = "flgAllAlerts", target = "args1.flgAllAlerts"),
            @Mapping(source = "flgRegisterDeregister", target = "args1.flgRegisterDeregister"),
            @Mapping(source = "startTime", target = "args1.startTime"),
            @Mapping(source = "endTime", target = "args1.endTime"),
            @Mapping(source = "alertModeType", target = "args1.alertModeType"),
            @Mapping(source = "accountLevelRegisteredAlertsDTO", target = "args1.accountLevelRegisteredAlertsDTO"),
            @Mapping(source = "customerLevelRegisteredAlertsDTO", target = "args1.customerLevelRegisteredAlertsDTO")
    })
    FCCAlertRegisterDeRegisterRequest esbToFccRequest(ESBAlertRegisterDeRegisterRequest esbRequest);

    ESBTransactionStatusBaseDTO fccTOEsbTransaction(FCCTransactionStatusBaseDTO fccTransactionStatus);
}