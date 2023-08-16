package com.threads.consumer;

import org.springframework.http.ResponseEntity;

public interface IscSyncClient<T,R> {
    <R> ResponseEntity<R> getObject(String serviceUrl, Class<R> type);

    <T,R> ResponseEntity<R> post(T obj, String serviceUrl, Class<R> type);

    <T,R> ResponseEntity<R> put(T obj, String serviceUrl, Class<R> type);

    <R> ResponseEntity<R> delete(String serviceUrl, Class<R> type);

}

