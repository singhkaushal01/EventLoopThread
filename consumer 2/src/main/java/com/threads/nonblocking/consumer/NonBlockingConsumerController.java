package com.threads.nonblocking.consumer;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.*;

@Controller
public class NonBlockingConsumerController {

    @Autowired
    ClientService clientService;

    @GetMapping(value = "/consume")
    public Mono<ResponseEntity<String>> getDependentInfo(RequestEntity requestEntity) {
        return clientService.getDataFromProducer()
                .map(body -> new ResponseEntity<String>(body, HttpStatus.OK));
    }

    @GetMapping(value = "/process")
    public Mono<ResponseEntity<String>> getInfo(RequestEntity requestEntity) {
        String body = "This is sample data processing!!!";
        return Mono.just(new ResponseEntity<String>(body, HttpStatus.OK));
    }

}
