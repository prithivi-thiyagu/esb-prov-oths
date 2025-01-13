package com.bandhanbank.esb.prov.oths.ProviderBaseDTOs.FCCAlertRegisterDeRegister.RequestDTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerLevelRegisteredAlertsDTO {
    @JsonProperty("validationFlag")
    private String validationFlag;
    @JsonProperty("externalTaskCode")
    private String externalTaskCode;
    @JsonProperty("externalLocalDateText")
    private String externalLocalDateText;
    @JsonProperty("listOfvalidationErrors")
    private List<ValidationError> listOfvalidationErrors;
    @JsonProperty("alertId")
    private String alertId;
    @JsonProperty("alertModeType")
    private String alertModeType;
}
