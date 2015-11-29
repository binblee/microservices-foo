package com.example;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandMetrics;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Future;

import static org.junit.Assert.assertEquals;

/**
 * Created by libin on 11/29/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HystrixApplication.class)
public class CommandWithFallbackTest {

    private final String PARAM = CommandWithFallback.PARAM;
    private final String TIMEOUT_PARAM = CommandWithFallback.TIMEOUT_PARAM;
    private final String GOOD_RESULT = CommandWithFallback.GOOD_RESULT;
    private final String FALLBACK_RESULT = CommandWithFallback.FALLBACK_RESULT;

    @Test
    public void testSynchronosFallback(){
        assertEquals( GOOD_RESULT, new CommandWithFallback(PARAM).execute());
        assertEquals( FALLBACK_RESULT, new CommandWithFallback("").execute());
    }

    @Test
    public void testTimeout(){
        assertEquals( FALLBACK_RESULT, new CommandWithFallback(TIMEOUT_PARAM).execute());
    }

    @Test
    public void testCircuitBreakerPattern(){
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        HystrixCommandMetrics metrics = HystrixCommandMetrics.getInstance(
                HystrixCommandKey.Factory.asKey(CommandWithFallback.class.getSimpleName())
        );

        assertEquals( GOOD_RESULT, new CommandWithFallback(PARAM).execute());
        assertEquals( FALLBACK_RESULT, new CommandWithFallback("").execute());
        assertEquals( GOOD_RESULT, new CommandWithFallback(PARAM).execute());
    }
}
