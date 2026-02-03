package com.lms.test.request;

import com.lms.test.enums.Grade;
import com.lms.test.enums.Status;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public class StudentRequest {
    @NotBlank(message = "Name is Required")
    private String name;
    @Email(message = "Invalid email")
    @NotBlank(message = "Email is Required")
    private String email;
    @NotNull(message = "Status is required")
    private Status status;
    @NotBlank(message = "Phone No is Required")
    @Pattern(regexp = "\\d{11,}",message = "Phone no must be 11 digits")
    private String phoneNumber;
    @NotNull(message = "Date of Birth is Required")
    private LocalDate dateOfBirth;
    @NotNull(message = "Grade is Required")
    private Grade grade;

    public StudentRequest() {
    }

    public StudentRequest(String name, String email, Status status, String phoneNumber, LocalDate dateOfBirth, Grade grade) {
        this.name = name;
        this.email = email;
        this.status = status;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
