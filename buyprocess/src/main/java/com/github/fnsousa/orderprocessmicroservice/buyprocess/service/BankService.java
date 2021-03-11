package com.github.fnsousa.orderprocessmicroservice.buyprocess.service;

import com.github.fnsousa.orderprocessmicroservice.buyprocess.dto.request.AddPaymentRequest;
import com.github.fnsousa.orderprocessmicroservice.buyprocess.dto.request.BuyTripKeyRequest;
import com.github.fnsousa.orderprocessmicroservice.buyprocess.dto.response.PaymentResponse;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class BankService {

    @Value("${bank.link}")
    private String linkBank;

    public PaymentResponse pay(BuyTripKeyRequest buyTripKey) throws IOException {

        AddPaymentRequest paymentRequest = new AddPaymentRequest();
        paymentRequest.setCardNumber(buyTripKey.getBuyTripRequest().getCardNumber());
        paymentRequest.setSecurityNumberCode(buyTripKey.getBuyTripRequest().getSecurityNumberCode());
        paymentRequest.setOrderValue(buyTripKey.getBuyTripRequest().getTicketValue());

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AddPaymentRequest> entity = new HttpEntity<>(paymentRequest, httpHeaders);

        try {
            ResponseEntity<PaymentResponse> bankResponse = restTemplate.exchange(linkBank, HttpMethod.POST, entity, PaymentResponse.class);
            return new PaymentResponse(bankResponse.getBody().getMessage(), true);
        }catch(HttpClientErrorException ex){
            if( ex.getStatusCode() == HttpStatus.BAD_REQUEST ) {
                ObjectMapper mapper = new ObjectMapper();
                PaymentResponse obj = mapper.readValue(ex.getResponseBodyAsString(), PaymentResponse.class);
                return new PaymentResponse(obj.getMessage(), false);
            }
            throw ex;
        }catch (RuntimeException ex) {
            throw ex;
        }
    }

}
