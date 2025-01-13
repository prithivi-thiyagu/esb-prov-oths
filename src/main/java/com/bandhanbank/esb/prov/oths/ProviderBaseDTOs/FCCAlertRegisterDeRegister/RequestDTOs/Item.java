package com.bandhanbank.esb.prov.oths.ProviderBaseDTOs.FCCAlertRegisterDeRegister.RequestDTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Item {
    @JsonProperty("objectName")
    protected String objectName;
    @JsonProperty("attributeName")
    protected String attributeName;
    @JsonProperty("attributeValue")
    protected String attributeValue;
    @JsonProperty("errorCode")
    protected String errorCode;
    @JsonProperty("errorMessage")
    protected String errorMessage;
    @JsonProperty("methodName")
    protected String methodName;
    @JsonProperty("applicableAttributes")
    protected String applicableAttributes;
}