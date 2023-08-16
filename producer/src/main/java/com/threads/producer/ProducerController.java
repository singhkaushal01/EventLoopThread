package com.threads.producer;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProducerController {

    @Autowired
    DataService service;

    @GetMapping("/produceData")
    public ResponseEntity getData(RequestEntity requestEntity){

        ResponseEntity responseEntity = new ResponseEntity<>(service.generateData(), HttpStatus.OK);
        return responseEntity;
    }
}
