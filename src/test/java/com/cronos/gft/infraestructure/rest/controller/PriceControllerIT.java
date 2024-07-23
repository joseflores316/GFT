package com.cronos.gft.infraestructure.rest.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PriceControllerIT {

    @Autowired
    private TestRestTemplate client;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();

    }

    @Test
    @Order(1)
    void gePrice() throws JsonProcessingException {
        ResponseEntity<String> response = client.getForEntity("/api/price?date=2020-06-14 10:00:00&productId=35455&brandId=1", String.class);

        String json = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());

        JsonNode jsonNode = objectMapper.readTree(json);

        assertEquals(9, jsonNode.size());

        assertEquals("35.5", jsonNode.get("price").asText());
    }


}
