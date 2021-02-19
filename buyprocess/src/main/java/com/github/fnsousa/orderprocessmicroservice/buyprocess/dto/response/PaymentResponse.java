package com.github.fnsousa.orderprocessmicroservice.buyprocess.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse {

    private String message;
    private boolean approved;

}
