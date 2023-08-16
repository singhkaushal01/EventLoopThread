package com.threads.producer;

import org.springframework.stereotype.*;

@Service
public class DataService {

    public String generateData() {
        return "Here is the Data!!!";
    }
}
