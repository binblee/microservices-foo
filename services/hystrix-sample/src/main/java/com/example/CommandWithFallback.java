package com.example;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

/**
 * Created by libin on 11/29/15.
 */
public class CommandWithFallback extends HystrixCommand<String> {

    public static final String PARAM = "World";
    public static final String TIMEOUT_PARAM = "Timeout";
    public static final String GOOD_RESULT = "Hello World.";
    public static final String FALLBACK_RESULT = "Hello Fallback.";
    private final String name;

    public CommandWithFallback(String name) {

        // It looks like default timeout value is 1000ms.
        // It is changed to 500ms here.
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                .withExecutionTimeoutInMilliseconds(500)));

        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        if( name.equals(PARAM) ) {
            return GOOD_RESULT;
        }else if (name.equals(TIMEOUT_PARAM)){
            Thread.sleep(500);
            return GOOD_RESULT;
        }
        throw new IllegalArgumentException();
    }

    @Override
    protected String getFallback() {
        return FALLBACK_RESULT;
    }
}
