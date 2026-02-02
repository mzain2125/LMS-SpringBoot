package com.lms.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lms.test.enums.Department;
import com.lms.test.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true,nullable = false)
    private String email;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(nullable = false)
    private String qualification;
    @Pattern(regexp = "\\d{11,}", message = "Phone Number in this format(01234567890)")
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Department department;
    @Column(nullable = false)
    private String subject;
    private LocalDateTime createdAt =LocalDateTime.now();

    public Teacher() {
    }

    public Teacher(Integer id, String name, String email, Status status, String qualification,
                   String phoneNumber, Department department, String subject, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.status = status;
        this.qualification = qualification;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.subject = subject;
        this.createdAt = createdAt;
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

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
