package com.lms.test.interfaces;

import com.lms.test.request.StudentRequest;
import com.lms.test.response.StudentResponse;

import java.util.List;

public interface Student {
    StudentResponse saveStudent(StudentRequest studentRequest);

    StudentResponse getStudentById(Integer id);

    List<StudentResponse> getStudentsByName(String name);

    List<StudentResponse> getStudents();

    StudentResponse updateStudent(Integer id, StudentRequest newStudent);

    StudentResponse patchStudent(Integer id, StudentRequest newStudent);

    void dltStudents();

    void dltStudentById(Integer id);
}
