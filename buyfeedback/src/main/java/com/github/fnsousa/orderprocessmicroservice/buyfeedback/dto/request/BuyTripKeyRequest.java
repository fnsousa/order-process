package com.github.fnsousa.orderprocessmicroservice.buyfeedback.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyTripKeyRequest {

    private String key;
    private BuyTripRequest buyTripRequest;
}
