package com.threads.consumer;

import jakarta.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.client.*;

import java.util.*;

@Component
public class IscSyncClientServiceImpl<T, R> implements IscSyncClient<T, R> {

    RestTemplate restTemplate;

    @PostConstruct
    public void getRestTemplate() {
        restTemplate =  new RestTemplate();
    }

    @Override
    public <R> ResponseEntity<R> getObject(String serviceUrl, Class<R> type) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<>(headers);

        return restTemplate
                .exchange("http://localhost:8080"+serviceUrl, HttpMethod.GET, entity, type);

    }

    @Override
    public <T,R> ResponseEntity<R> post(T obj, String serviceUrl, Class<R> type) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<T> entity = new HttpEntity<>(obj,headers);

        return restTemplate
                .exchange("http://localhost:8080/products", HttpMethod.POST, entity, type);
    }

    @Override
    public <T,R> ResponseEntity<R> put(T obj, String serviceUrl, Class<R> type) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<T> entity = new HttpEntity<>(obj,headers);

        return restTemplate
                .exchange("http://localhost:8080/products", HttpMethod.PUT, entity, type);
    }

    @Override
    public <R> ResponseEntity<R> delete(String serviceUrl, Class<R> type) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<T> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(
                "http://localhost:8080/products/", HttpMethod.DELETE, entity, type);
    }

}
