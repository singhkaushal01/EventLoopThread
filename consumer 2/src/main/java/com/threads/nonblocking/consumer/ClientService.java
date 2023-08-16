package com.threads.nonblocking.consumer;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import reactor.core.publisher.*;

@Service
public class ClientService {

    @Autowired
    IscSyncClient iscSyncClient;

    public Mono<String> getDataFromProducer(){

        return iscSyncClient.getObject("/produceData", String.class);
    }

    public Mono<String> getDelayedDataFromProducer(){

        return iscSyncClient.getObject("/produceDelayedData", String.class);
    }
}
