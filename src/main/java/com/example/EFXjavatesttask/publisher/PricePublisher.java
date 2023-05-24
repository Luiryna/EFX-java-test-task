package com.example.EFXjavatesttask.publisher;

import com.example.EFXjavatesttask.model.Price;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PricePublisher {
    @Value("${rest.endpoint.url}")
    private String restEndpointUrl;

    public void publishPrice(Price price) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Price> requestEntity = new HttpEntity<>(price, headers);

        ResponseEntity<Void> responseEntity = restTemplate.exchange(
                restEndpointUrl,
                HttpMethod.POST,
                requestEntity,
                Void.class
        );

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("Price published successfully!");
        } else {
            System.err.println("Failed to publish price. Status code: " + responseEntity.getStatusCodeValue());
        }
    }


}
