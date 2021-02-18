package com.github.fnsousa.orderprocessmicroservice.buytrip.controller.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BuyTripResponse {

    private String message;
    private String keySearch;
}
