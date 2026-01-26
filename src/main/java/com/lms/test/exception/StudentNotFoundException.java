package com.lms.test.exception;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String massage){
        super(massage);
    }
}
