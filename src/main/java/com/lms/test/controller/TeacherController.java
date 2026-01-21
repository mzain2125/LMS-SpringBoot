package com.lms.test.controller;


import com.lms.test.entity.Teacher;
import com.lms.test.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @PostMapping
    public Teacher saveTeacher(@RequestBody Teacher teacher){
        return teacherService.saveTeacher(teacher);
    }

    @GetMapping
    public ResponseEntity<?> getTeachers(){
        List<Teacher> teacher=teacherService.getTeachers();
        if (teacher==null){
           return ResponseEntity.badRequest().body("Teacher Table is Empty");
        }
        return ResponseEntity.ok(teacher);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTeacherByID(@PathVariable Integer id){
        Teacher teacher=teacherService.getTeacherById(id);
        if(teacher==null){
           return ResponseEntity.badRequest().body("This is not available");
        }
        return ResponseEntity.ok(teacher);
    }
}
