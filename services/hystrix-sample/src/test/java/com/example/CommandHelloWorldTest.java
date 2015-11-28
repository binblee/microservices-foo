package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by libin on 11/28/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HystrixApplication.class)
public class CommandHelloWorldTest {

    @Test
    public void testSynchronous(){
        assertEquals("Hello World",new CommandHelloWorld("World").execute());
    }
}
