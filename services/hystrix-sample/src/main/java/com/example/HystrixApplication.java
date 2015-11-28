package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HystrixApplication {

    public static void main(String[] args) {
        String s = new CommandHelloWorld("Alice").execute();
        System.out.println(s);
    }
}
