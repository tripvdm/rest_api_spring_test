package org.test_example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import org.test_example.demo.service.SymbolService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ApiControllerTest {

    @Autowired
    private SymbolService symbolService;

    @Test
    void testCheckJsonIfEmpty() {
        final RestTemplate restTemplate = new RestTemplate();
        final String str = "aaabbb22ccc";
        final String response = restTemplate.getForObject("http://localhost:8090/" + str, String.class);
        String json = symbolService.getJson(str);
        assertEquals(json, response);
    }

}