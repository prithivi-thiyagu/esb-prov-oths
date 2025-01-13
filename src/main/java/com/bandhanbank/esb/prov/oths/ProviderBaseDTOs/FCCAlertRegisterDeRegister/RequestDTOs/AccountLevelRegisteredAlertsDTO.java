package com.bandhanbank.esb.prov.oths.ProviderBaseDTOs.FCCAlertRegisterDeRegister.RequestDTOs;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountLevelRegisteredAlertsDTO {
    @JsonProperty("validationFlag")
    protected String validationFlag;
    @JsonProperty("externalTaskCode")
    protected String externalTaskCode;
    @JsonProperty("externalLocalDateText")
    protected String externalLocalDateText;
    @JsonProperty("listOfvalidationErrors")
    protected List<ValidationError> listOfvalidationErrors;
    @JsonProperty("accountId")
    protected String accountId;
    @JsonProperty("alertId")
    protected String alertId;
    @JsonProperty("alertFrequencyType")
    protected String alertFrequencyType;
    @JsonProperty("thresholdAmount")
    protected double thresholdAmount;
    @JsonProperty("alertModeType")
    protected String alertModeType;
}
