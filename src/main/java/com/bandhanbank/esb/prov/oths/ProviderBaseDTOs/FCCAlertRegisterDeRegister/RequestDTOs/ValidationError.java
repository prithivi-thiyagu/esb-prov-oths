package com.bandhanbank.esb.prov.oths.ProviderBaseDTOs.FCCAlertRegisterDeRegister.RequestDTOs;

import com.bandhanbank.esb.prov.oths.ESBBaseDTOs.FCCAlterRegisterDeRegister.RequestDTO.CDMValidationError;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ValidationError {
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
    @JsonProperty("item")
    protected List<Item> item;
}