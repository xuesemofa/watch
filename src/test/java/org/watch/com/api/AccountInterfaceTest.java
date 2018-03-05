package org.watch.com.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.watch.com.Application;

/**
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class AccountInterfaceTest {

    private final static Logger logger = LoggerFactory.getLogger(AccountInterfaceTest.class);


    @Test
    public void test() {
        System.out.println("接口断开");
    }
}