package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class HelloServiceTest {
    @Test
    void greet_withName_returnsGreeting() {
        HelloService service = new HelloService();
        assertEquals("Hello, Maven!", service.greet("Maven"));
    }

    @Test
    void greet_withBlank_returnsHello() {
        HelloService service = new HelloService();
        assertEquals("Hello", service.greet(" "));
    }
}



