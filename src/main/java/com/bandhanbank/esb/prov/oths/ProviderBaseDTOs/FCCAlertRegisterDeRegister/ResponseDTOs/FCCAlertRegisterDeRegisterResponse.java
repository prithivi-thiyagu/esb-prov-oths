package com.bandhanbank.esb.prov.oths.ProviderBaseDTOs.FCCAlertRegisterDeRegister.ResponseDTOs;

import com.bandhanbank.esb.common.util.BaseDTOs.ProviderBaseDTOs.FCCTransactionStatusBaseDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FCCAlertRegisterDeRegisterResponse {
    @JsonProperty("type")
    protected String type;
    @JsonProperty("postingDate")
    protected String postingDate;
    @JsonProperty("transactionStatus")
    protected FCCTransactionStatusBaseDTO transactionStatus;
}
