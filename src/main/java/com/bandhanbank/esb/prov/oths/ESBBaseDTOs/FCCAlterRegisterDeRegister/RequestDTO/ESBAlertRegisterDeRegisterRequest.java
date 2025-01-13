package com.bandhanbank.esb.prov.oths.ESBBaseDTOs.FCCAlterRegisterDeRegister.RequestDTO;


import com.bandhanbank.esb.common.util.BaseDTOs.ESBBaseDTOs.ESBSessionContextBaseDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonRootName("Data")
public class ESBAlertRegisterDeRegisterRequest {
    @JsonProperty("SessionContext")
    protected ESBSessionContextBaseDTO sessionContext;
    @JsonProperty("ValidationFlag")
    protected String validationFlag;
    @JsonProperty("ExternalTaskCode")
    protected String externalTaskCode;
    @JsonProperty("ExternalLocalDateText")
    protected String externalLocalDateText;
    @JsonProperty("ListOfvalidationErrors")
    protected List<CDMValidationError> listOfvalidationErrors;
    @NotEmpty(message = "CustomerNumber cannot be null or blank")
    @JsonProperty("CustomerNumber")
    protected String customerId;
    @JsonProperty("AlertType")
    protected String alertType;
    @JsonProperty("FlgAllAlerts")
    protected String flgAllAlerts;
    @NotEmpty(message = "FlgRegisterDeregister cannot be null or blank")
    @JsonProperty("FlgRegisterDeregister")
    protected String flgRegisterDeregister;
    @JsonProperty("StartTime")
    protected String startTime;
    @JsonProperty("EndTime")
    protected String endTime;
    @JsonProperty("AlertModeType")
    protected String alertModeType;
    @JsonProperty("AccountLevelRegisteredAlertsDTO")
    protected List<CDMAccountLevelRegisteredAlertsDTO> accountLevelRegisteredAlertsDTO;
    @JsonProperty("CustomerLevelRegisteredAlertsDTO")
    protected List<CDMCustomerLevelRegisteredAlertsDTO> customerLevelRegisteredAlertsDTO;
}