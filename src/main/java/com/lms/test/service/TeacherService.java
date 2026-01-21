package com.lms.test.service;


import com.lms.test.entity.Teacher;
import com.lms.test.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    public Teacher saveTeacher(Teacher teacher) {
        String email = teacher.getEmail();
        if (!email.contains("@gmail.com")) {
            email = email + "@gmail.com";
            teacher.setEmail(email);
        }
        return teacherRepository.save(teacher);
    }

    public List<Teacher> getTeachers() {
        List<Teacher> teacher = teacherRepository.findAll();
        if (teacher.isEmpty()) {
            return null;
        }
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(Integer id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (teacher.isPresent()) {
            return teacherRepository.findById(id).get();
        }
        return null;
    }




}
