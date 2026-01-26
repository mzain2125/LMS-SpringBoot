package com.lms.test.exception;

public class StudentAlreadyExist extends RuntimeException{
    public StudentAlreadyExist(String massage){
        super(massage);
    }
}
