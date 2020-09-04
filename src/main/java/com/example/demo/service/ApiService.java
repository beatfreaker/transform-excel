package com.example.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

    private static final String URL = "https://e8w3inqq2f.execute-api.us-east-1.amazonaws.com/test/";

    public void callAPI(String jsonData) {
        System.out.println("Executing API");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(URL, jsonData, String.class);
        System.out.println("API Response :: " + response.getBody());
    }
}
