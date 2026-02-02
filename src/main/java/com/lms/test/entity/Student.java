package com.lms.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lms.test.enums.Grade;
import com.lms.test.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.UnexpectedTypeException;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true,nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime createdAt=LocalDateTime.now();

    @Column(unique = true,nullable = false)
    @Pattern(regexp = "\\d{11,}", message = "Phone number must be at least 11 digits")
    private String phoneNumber;

    private LocalDate dateOfBirth;

    @Column(unique = true,nullable = false)
    private String enrollmentNumber;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    public Student() {
    }

    public Student(Integer id, String name, String email, Status status,
                   LocalDateTime createdAt, String phoneNumber, LocalDate dateOfBirth,
                   String enrollmentNumber, Grade grade) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.status = status;
        this.createdAt = createdAt;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.enrollmentNumber = enrollmentNumber;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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

    public String getEnrollmentNumber() {
        return enrollmentNumber;
    }

    public void setEnrollmentNumber(String enrollmentNumber) {
        this.enrollmentNumber = enrollmentNumber;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
