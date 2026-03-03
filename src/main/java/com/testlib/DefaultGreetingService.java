package com.testlib;

public class DefaultGreetingService implements GreetingService {

    @Override
    public String greet(String name) {
        return "Hello, " + name + "!";
    }

    @Override
    public String shout(String name) {
        return "HELLO, " + name.toUpperCase() + "!!!";
    }
}