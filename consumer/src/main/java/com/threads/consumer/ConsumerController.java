package com.threads.consumer;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class ConsumerController {

    @Autowired
    ClientService clientService;

    @GetMapping("/consume")
    public ResponseEntity getInfo(RequestEntity requestEntity){
        String response = clientService.getDataFromProducer();
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("/process")
    public ResponseEntity getDelayedInfo(RequestEntity requestEntity){
        String response = "This is sample data processing!!!";
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
