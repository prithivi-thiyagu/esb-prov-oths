package com.bandhanbank.esb.prov.oths.ProviderBaseDTOs.FCCAlertRegisterDeRegister.RequestDTOs;

import com.bandhanbank.esb.common.util.BaseDTOs.ProviderBaseDTOs.FCCArgsZeroBaseDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FCCAlertRegisterDeRegisterRequest {
    @JsonProperty("args0")
    protected FCCArgsZeroBaseDTO args0;
    @JsonProperty("args1")
    protected ArgsOne args1;
}

