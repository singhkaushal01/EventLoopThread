package com.threads.nonblocking.consumer;

import org.springframework.http.ResponseEntity;
import reactor.core.publisher.*;

public interface IscSyncClient<T,R> {
    <R>  Mono<R>  getObject(String serviceUrl, Class<R> type);

//    <T,R> ResponseEntity<R> post(T obj, String serviceUrl, Class<R> type);
//
//    <T,R> ResponseEntity<R> put(T obj, String serviceUrl, Class<R> type);
//
//    <R> ResponseEntity<R> delete(String serviceUrl, Class<R> type);

}

