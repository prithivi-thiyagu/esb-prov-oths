package com.bandhanbank.esb.prov.oths.ESBBaseDTOs.FCCAlterRegisterDeRegister.ResponseDTO;

import com.bandhanbank.esb.common.util.BaseDTOs.ESBBaseDTOs.ESBTransactionStatusBaseDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonRootName("Data")
public class ESBAlertRegisterDeRegisterResponse {
    @JsonProperty("TransactionStatus")
    protected ESBTransactionStatusBaseDTO transactionStatus;
}
