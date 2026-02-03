package com.lms.test.controller;

import com.lms.test.entity.Student;
import com.lms.test.entityDto.StudentDto;
import com.lms.test.request.StudentRequest;
import com.lms.test.response.StudentResponse;
import com.lms.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private static final Logger log=LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity<?> saveStudent(@RequestBody StudentRequest student){
        log.info("Post API called with email={}",student.getEmail());
        StudentResponse savedStudent = studentService.saveStudent(student);
        log.info("Student Successfully Created");
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Integer id){
        log.info("Student Called with id={}",id);
        StudentResponse student=studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getStudentsByName(@PathVariable String name){
        List<StudentResponse> student=studentService.getStudentsByName(name);
        log.info("Students found with this name{}={}",name,student.size());
        return ResponseEntity.ok(student);
    }

    @GetMapping
    public ResponseEntity<?> getStudents(){
        List<StudentResponse> responseList=studentService.getStudents();
        if(responseList.isEmpty()){
            log.error("Student list is Empty");
        }
        log.info("Total student={}",responseList.size());
       return ResponseEntity.ok(studentService.getStudents());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer id,@RequestBody StudentRequest student){
        StudentResponse student1=studentService.updateStudent(id,student);
        log.info("The Student is Updated");
        return ResponseEntity.ok(student1);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchStudent(@PathVariable Integer id,@RequestBody StudentRequest student){
        StudentResponse studentRequest=studentService.patchStudent(id,student);
        return ResponseEntity.ok(studentRequest);
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
