package com.lvu2code.demo.rest;

public class StudentNotFoundExcepetion extends RuntimeException{
    public StudentNotFoundExcepetion(String message) {
        super(message);
    }

    public StudentNotFoundExcepetion(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundExcepetion(Throwable cause) {
        super(cause);
    }
}
