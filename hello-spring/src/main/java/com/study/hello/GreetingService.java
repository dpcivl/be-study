package com.study.hello;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String makeGreeting(String name) {
        return name + "님, 환영합니다!";
    }
}