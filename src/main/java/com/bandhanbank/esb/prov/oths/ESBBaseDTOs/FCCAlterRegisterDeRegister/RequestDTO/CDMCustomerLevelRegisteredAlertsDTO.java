package com.bandhanbank.esb.prov.oths.ESBBaseDTOs.FCCAlterRegisterDeRegister.RequestDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CDMCustomerLevelRegisteredAlertsDTO {
    @JsonProperty("ValidationFlag")
    private String validationFlag;
    @JsonProperty("ExternalTaskCode")
    private String externalTaskCode;
    @JsonProperty("ExternalLocalDateText")
    private String externalLocalDateText;
    @JsonProperty("ListOfvalidationErrors")
    private List<CDMValidationError> listOfvalidationErrors;
    @JsonProperty("AlertId")
    private String alertId;
    @JsonProperty("AlertModeType")
    private String alertModeType;
}
