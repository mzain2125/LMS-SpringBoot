package com.lms.test.entityDto;

public class TeacherDto {

    private Integer id;
    private String name;
    private String email;
    private String qualification;
    private String status;
    private String createdAt;

    public TeacherDto() {
    }

    public TeacherDto(Integer id, String name, String email,
                      String qualification, String status, String createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.qualification = qualification;
        this.status = status;
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

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
