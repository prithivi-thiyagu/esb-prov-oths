package com.bandhanbank.esb.prov.oths.ESBBaseDTOs.FCCAlterRegisterDeRegister.RequestDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CDMAccountLevelRegisteredAlertsDTO {
    @JsonProperty("ValidationFlag")
    protected String validationFlag;
    @JsonProperty("ExternalTaskCode")
    protected String externalTaskCode;
    @JsonProperty("ExternalLocalDateText")
    protected String externalLocalDateText;
    @JsonProperty("ListOfvalidationErrors")
    protected List<CDMValidationError> listOfvalidationErrors;
    @JsonProperty("AccountId")
    protected String accountId;
    @JsonProperty("AlertId")
    protected String alertId;
    @JsonProperty("AlertFrequencyType")
    protected String alertFrequencyType;
    @JsonProperty("ThresholdAmount")
    protected double thresholdAmount;
    @JsonProperty("AlertModeType")
    protected String alertModeType;
}