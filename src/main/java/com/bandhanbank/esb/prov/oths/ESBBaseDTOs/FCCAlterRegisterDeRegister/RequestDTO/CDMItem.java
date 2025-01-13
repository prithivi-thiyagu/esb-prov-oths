package com.bandhanbank.esb.prov.oths.ESBBaseDTOs.FCCAlterRegisterDeRegister.RequestDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CDMItem {
    @JsonProperty("ObjectName")
    protected String objectName;
    @JsonProperty("AttributeName")
    protected String attributeName;
    @JsonProperty("AttributeValue")
    protected String attributeValue;
    @JsonProperty("ErrorCode")
    protected String errorCode;
    @JsonProperty("ErrorMessage")
    protected String errorMessage;
    @JsonProperty("MethodName")
    protected String methodName;
    @JsonProperty("ApplicableAttributes")
    protected String applicableAttributes;
}
