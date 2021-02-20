package com.github.fnsousa.orderprocessmicroservice.buyprocess.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderFinishedRequest {

    private BuyTripKeyRequest buyTripKey;
    private String message;
    private boolean approved;

}