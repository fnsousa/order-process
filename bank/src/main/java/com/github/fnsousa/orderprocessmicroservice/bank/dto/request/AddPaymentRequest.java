package com.github.fnsousa.orderprocessmicroservice.bank.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class AddPaymentRequest {

    @NotBlank(message = "Número do Cartão é obrigatório.")
    private String cardNumber;
    @NotBlank(message = "Código de Segurança Cartão é obrigatório.")
    private String securityNumberCode;
    @NotNull(message = "Valor da compra é obrigatório.")
    private BigDecimal orderValue;

}
