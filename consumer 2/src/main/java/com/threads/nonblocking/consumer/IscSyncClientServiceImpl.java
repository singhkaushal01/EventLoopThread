package com.threads.nonblocking.consumer;

import io.netty.channel.*;
import jakarta.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.http.*;
import org.springframework.http.client.reactive.*;
import org.springframework.stereotype.*;
import org.springframework.web.reactive.function.client.*;
import reactor.core.publisher.*;
import reactor.netty.http.client.*;
import org.springframework.http.ResponseEntity;

import java.time.*;

@Component
public class IscSyncClientServiceImpl<T, R> implements IscSyncClient<T, R> {

    private WebClient webClient;

//    @Value("${rest.connection.timeout}")
//    private int connectionTimeout;
//
//    @Value("${rest.response.timeout}")
//    private long responseTimeout;
//
//    @Value("${webclient.codec.max-in-memory-size}")
//    private int maxCodecSize;

//    @Bean
//    private WebClient getWebClient() {
//        return WebClient.builder().build();
//    }

    @PostConstruct
    private void configureWebClient() {
//        HttpClient client = HttpClient.create().compress(true).responseTimeout(Duration.ofMillis(responseTimeout))
//                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, connectionTimeout);
//
//        int size = maxCodecSize * 1024 * 1024;
//        ExchangeStrategies strategies = ExchangeStrategies.builder()
//                .codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(size)).build();

        webClient = WebClient.builder().build();
    }

    @Override
    public <R> Mono<R> getObject(String serviceUrl, Class<R> type) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        Mono<R> responseEntity = webClient.get().uri("http://localhost:8080"+serviceUrl)
                .headers(webclientHeader -> webclientHeader.addAll(requestHeaders))
                .retrieve()
                .bodyToMono(type);

        return responseEntity;
    }

}
