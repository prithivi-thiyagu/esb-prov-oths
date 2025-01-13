package com.bandhanbank.esb.prov.oths.ProviderBaseDTOs.FCCAlertRegisterDeRegister.RequestDTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArgsOne {
    @JsonProperty("validationFlag")
    protected String validationFlag;
    @JsonProperty("externalTaskCode")
    protected String externalTaskCode;
    @JsonProperty("externalLocalDateText")
    protected String externalLocalDateText;
    @JsonProperty("listOfvalidationErrors")
    protected List<ValidationError> listOfvalidationErrors;
    @JsonProperty("customerId")
    protected String customerId;
    @JsonProperty("alertType")
    protected String alertType;
    @JsonProperty("flgAllAlerts")
    protected String flgAllAlerts;
    @JsonProperty("flgRegisterDeregister")
    protected String flgRegisterDeregister;
    @JsonProperty("startTime")
    protected String startTime;
    @JsonProperty("endTime")
    protected String endTime;
    @JsonProperty("alertModeType")
    protected String alertModeType;
    @JsonProperty("accountLevelRegisteredAlertsDTO")
    protected List<AccountLevelRegisteredAlertsDTO> accountLevelRegisteredAlertsDTO;
    @JsonProperty("customerLevelRegisteredAlertsDTO")
    protected List<CustomerLevelRegisteredAlertsDTO> customerLevelRegisteredAlertsDTO;
}