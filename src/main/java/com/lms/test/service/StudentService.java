package com.lms.test.service;

import com.lms.test.entity.Student;
import com.lms.test.exception.StudentAlreadyExist;
import com.lms.test.exception.StudentNotFoundException;
import com.lms.test.exception.TeacherNotFoundException;
import com.lms.test.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student saveStudent(Student student){

        String email=student.getEmail();
        if(!email.endsWith("@gmail.com")){
            email=email+"@gmail.com";
            student.setEmail(email);
        }

        if(studentRepository.existsByEmail(student.getEmail()))
            throw new StudentAlreadyExist("This Student Already Exist in Database");

        return studentRepository.save(student);

    }

    public Student getStudentById(Integer id) {
        return studentRepository.findById(id).orElseThrow(
                ()->new StudentNotFoundException("student not found Exception"));

    }
}
