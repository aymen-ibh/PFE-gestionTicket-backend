package com.tn.saasProjectTicket.services;


import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class PowerBITokenService {
	
	private static final String AUTH_URL = "https://login.microsoftonline.com/{604f1a96-cbe8-43f8-abbf-f8eaf5d85730}/oauth2/v2.0/token";
	
	public String getAccessToken() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "client_credentials");
        body.add("client_id", "YOUR_CLIENT_ID");
        body.add("client_secret", "YOUR_CLIENT_SECRET");
        body.add("scope", "https://analysis.windows.net/powerbi/api/.default");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);
        ResponseEntity<Map> response = restTemplate.postForEntity(AUTH_URL, request, Map.class);

        return (String) response.getBody().get("access_token");
    }

}
