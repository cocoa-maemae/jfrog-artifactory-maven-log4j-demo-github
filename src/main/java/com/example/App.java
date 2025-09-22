package com.example;

public class App {
    public static void main(String[] args) {
        HelloService helloService = new HelloService();
        String message = helloService.greet("World");
        System.out.println(message);
    }
}



