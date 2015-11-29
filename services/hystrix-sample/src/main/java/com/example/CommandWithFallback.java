package com.example;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * Created by libin on 11/29/15.
 */
public class CommandWithFallback extends HystrixCommand<String> {

    private final String name;

    public CommandWithFallback(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
//        return "Hello " + name;
        throw new IllegalArgumentException();
    }

    @Override
    protected String getFallback() {
        return "Hello Fallback!";
    }
}
