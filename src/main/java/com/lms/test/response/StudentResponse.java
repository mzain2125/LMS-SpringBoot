package com.lms.test.response;

import com.lms.test.enums.Grade;
import com.lms.test.enums.Status;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class StudentResponse {

    private Integer id;                  // DB id
    private String name;
    private String email;
    private Status status;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String enrollmentNumber;
    private Grade grade;
    private LocalDateTime createdAt;     // optional, useful to show when created

    public StudentResponse() {
    }

    public StudentResponse(Integer id, String name, String email, Status status,
                           String phoneNumber, LocalDate dateOfBirth,
                           String enrollmentNumber, Grade grade, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.status = status;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.enrollmentNumber = enrollmentNumber;
        this.grade = grade;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getEnrollmentNumber() { return enrollmentNumber; }
    public void setEnrollmentNumber(String enrollmentNumber) { this.enrollmentNumber = enrollmentNumber; }

    public Grade getGrade() { return grade; }
    public void setGrade(Grade grade) { this.grade = grade; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}

