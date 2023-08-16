package com.threads.consumer;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class ClientService {

    @Autowired
    IscSyncClient iscSyncClient;

    public String getDataFromProducer(){

        return iscSyncClient.getObject("/produceData", String.class).getBody().toString();
    }

    public String getDelayedDataFromProducer(){

        return iscSyncClient.getObject("/produceDelayedData", String.class).getBody().toString();
    }

}
