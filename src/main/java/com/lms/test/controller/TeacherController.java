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

    @GetMapping("/email/{email}")
    public ResponseEntity<?> getTeacherByEmail(@PathVariable String email){
        Teacher teacher=teacherService.getTeacherByEmail(email);
        if(teacher==null){
            return ResponseEntity.badRequest().body("Not Found");
        }
        return ResponseEntity.ok(teacher);
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<?> getTeacherByName(@PathVariable String name){
        List<Teacher> teacher=teacherService.getTeacherByName(name);
        if(teacher==null){
            return ResponseEntity.badRequest().body("Not Found");
        }
        return ResponseEntity.ok(teacher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTeacherById(@PathVariable Integer id,
                                               @RequestBody Teacher newTeacher){
        Teacher teacher=teacherService.updateTeacherById(id,newTeacher);
        if(teacher==null){
            return ResponseEntity.badRequest().body("Teacher not Found");
        }
        return ResponseEntity.ok("successfully updated");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchTeacherById(@PathVariable Integer id,
                                              @RequestBody Teacher newTeacher){
        Teacher teacher=teacherService.patchTeacherById(id,newTeacher);
        if(teacher==null){
           return ResponseEntity.badRequest().body("Teacher not Found");
        }
        return ResponseEntity.ok("Given fields successfully updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeacherById(@PathVariable Integer id){
        Teacher teacher=teacherService.deleteTeacherById(id);
        if(teacher==null){
           return ResponseEntity.badRequest().body("Given Id not found");
        }
        return ResponseEntity.ok("Successfully Deleted");
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllTeachers(){
        teacherService.deleteAllTeachers();
        return ResponseEntity.ok("Successfully Deleted");
    }
}
