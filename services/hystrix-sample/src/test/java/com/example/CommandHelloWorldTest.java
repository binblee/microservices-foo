package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Future;

import static org.junit.Assert.assertEquals;

/**
 * Created by libin on 11/28/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HystrixApplication.class)
public class CommandHelloWorldTest {

    private static final String RESULT = "Hello World";
    private static final String PARAM = "World";

    @Test
    public void testSynchronous(){
        assertEquals(RESULT,new CommandHelloWorld(PARAM).execute());
    }

    public void testAsynchronos() throws Exception {
        Future<String> fs = new CommandHelloWorld(PARAM).queue();
        assertEquals(RESULT,fs.get());
    }
}
