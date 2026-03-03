package com.testlib.simpletestlib;

import com.testlib.GreetingService;
import com.testlib.TestLibAutoConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@Import(TestLibAutoConfiguration.class)
class GreetingServiceTest {

    @Autowired
    GreetingService greetingService;

    @Test
    void testGreet() {
        assertEquals("Hello, John!", greetingService.greet("John"));
    }
}
