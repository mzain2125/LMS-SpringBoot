package com.lms.test.controller;

import com.lms.test.entity.Student;
import com.lms.test.entityDto.StudentDto;
import com.lms.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity<?> saveStudent(@RequestBody StudentDto student){
        StudentDto savedStudent = studentService.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Integer id){
        Student student=studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getStudentsByName(@PathVariable String name){
        List<Student> student=studentService.getStudentsByName(name);
        return ResponseEntity.ok(student);
    }

    @GetMapping
    public ResponseEntity<?> getStudents(){
       return ResponseEntity.ok(studentService.getStudents());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer id,@RequestBody Student student){
        Student student1=studentService.updateStudent(id,student);
        return ResponseEntity.ok("Successfully Updated");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchStudent(@PathVariable Integer id,@RequestBody Student student){
        Student student1=studentService.patchStudent(id,student);
        return ResponseEntity.ok("Successfully Updated");
    }

    @DeleteMapping
    public ResponseEntity<?> dltStudents(){
        studentService.dltStudents();
        return ResponseEntity.ok("Successfully Deleted");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> dltStudentById(@PathVariable Integer id){
        studentService.dltStudentById(id);
        return ResponseEntity.ok("Successfully Deleted");
    }
}
