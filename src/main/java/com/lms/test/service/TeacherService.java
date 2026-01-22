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

    public Teacher getTeacherByEmail(String email){
        Teacher teacher=teacherRepository.getTeacherByEmail(email);
        if(teacher==null){
            return null;
        }
        return teacherRepository.getTeacherByEmail(email);

    }

    public List<Teacher> getTeacherByName(String name){
        List<Teacher> teacher=teacherRepository.getTeacherByName(name);
        if(teacher.isEmpty()){
            return null;
        }
        return teacherRepository.getTeacherByName(name);

    }

    public Teacher updateTeacherById(Integer id,Teacher newTeacher){
        Optional<Teacher> teacher=teacherRepository.findById(id);
        if(teacher.isEmpty()){
            return null;
        }
        teacher.get().setName(newTeacher.getName());
        teacher.get().setEmail(newTeacher.getEmail());
        teacher.get().setStatus(newTeacher.getStatus());
        teacher.get().setQualification(newTeacher.getQualification());
        teacher.get().setCreatedAt(newTeacher.getCreatedAt());

        return teacherRepository.save(teacher.get());

    }

    public Teacher patchTeacherById(Integer id,Teacher newTeacher){
        Optional<Teacher> teacher=teacherRepository.findById(id);
        if (teacher.isEmpty()){
            return null;
        }
        if(teacher.get().getName()!=null){
            teacher.get().setName(newTeacher.getName());
        }
        if(teacher.get().getCreatedAt()!=null){
            teacher.get().setCreatedAt(newTeacher.getCreatedAt());
        }
        if(teacher.get().getQualification()!=null){
            teacher.get().setQualification(newTeacher.getQualification());
        }
        if(teacher.get().getStatus()!=null){
            teacher.get().setStatus(newTeacher.getStatus());
        }
        if(teacher.get().getEmail()!=null){
            teacher.get().setEmail(newTeacher.getEmail());
        }
        return teacherRepository.save(teacher.get());
    }

    public Teacher deleteTeacherById(Integer id){
        Optional<Teacher> teacher=teacherRepository.findById(id);
        if(teacher.isEmpty()){
            return null;
        }
         teacherRepository.deleteById(id);
        return teacher.get();
    }

    public void deleteAllTeachers(){
        teacherRepository.deleteAll();
    }






}
