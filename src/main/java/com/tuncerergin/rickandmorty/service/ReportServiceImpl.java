package com.tuncerergin.rickandmorty.service;

import com.tuncerergin.rickandmorty.entity.report.Endpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReportServiceImpl implements ReportService {

    private final RestTemplate restTemplate;
    private final String url;

    @Autowired
    public ReportServiceImpl(
            RestTemplate theRestTemplate,
            @Value("http://localhost:8080/actuator/metrics/http.server.requests") String theUrl) {
        restTemplate = theRestTemplate;
        url = theUrl;
    }

    @Override
    public Endpoint getEndpoint(String uri) {
        ResponseEntity<Endpoint> responseEntity =
                restTemplate.exchange(url + uri,
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<Endpoint>() {
                        });
        return responseEntity.getBody();
    }
}
