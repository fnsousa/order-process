package com.github.fnsousa.orderprocessmicroservice.buytrip.controller.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class BuyTripRequest {

    @NotBlank(message = "Código do ticket é obrigatório.")
    private String ticketCode;
    @NotBlank(message = "Número do Cartão é obrigatório.")
    private String cardNumber;
    @NotBlank(message = "Código de Segurança Cartão é obrigatório.")
    private String securityNumberCode;
    @NotNull(message = "Valor do ticket é obrigatório.")
    private BigDecimal ticketValue;

}
