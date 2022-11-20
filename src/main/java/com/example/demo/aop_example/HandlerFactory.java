package com.example.demo.aop_example;

public class HandlerFactory {

    public static Handler getHandler() {
        Boundary boundary = new Boundary();
        boundary.setHandler(new ExampleHandler());
        return boundary;
    }

}
