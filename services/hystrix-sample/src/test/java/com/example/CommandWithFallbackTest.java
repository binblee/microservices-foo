package com.example;

import com.netflix.hystrix.HystrixCommand;
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

    private static final String RESULT = "Hello Fallback!";
    private static final String PARAM = "World";

    @Test
    public void testSynchronosFallback(){
        assertEquals( RESULT, new CommandWithFallback(PARAM).execute());
    }
}
