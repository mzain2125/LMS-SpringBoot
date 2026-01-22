package com.lms.test.exception;

public class TeacherNotFoundException extends RuntimeException{
    public TeacherNotFoundException(String massage){
        super(massage);
    }
}
