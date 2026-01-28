package com.lms.test.service;

import com.lms.test.entity.Student;
import com.lms.test.entityDto.StudentDto;
import com.lms.test.exception.StudentAlreadyExist;
import com.lms.test.exception.StudentNotFoundException;
import com.lms.test.exception.TeacherNotFoundException;
import com.lms.test.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public StudentDto saveStudent(StudentDto studentDto) {

        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        student.setCreatedAt(LocalDateTime.now());
//        String email = student.getEmail();
//        if (!email.endsWith("@gmail.com")) {
//            email = email + "@gmail.com";
//            student.setEmail(email);
//        }
//
//        if (studentRepository.existsByEmail(student.getEmail())) {
//            throw new StudentAlreadyExist("This Student Already Exist in Database");
//        }
        studentRepository.save(student);

        StudentDto response = new StudentDto();
        BeanUtils.copyProperties(student, response);

        return response;
    }

    public StudentDto getStudentById(Integer id) {
        Student student = studentRepository.findById(id).
                orElseThrow(() -> new StudentNotFoundException("Not found"));
        StudentDto studentDto = new StudentDto();

        BeanUtils.copyProperties(student, studentDto);
        return studentDto;
    }

//    public Student getStudentById(Integer id) {
//        return studentRepository.findById(id).orElseThrow(
//                () -> new StudentNotFoundException("student not found Exception"));
//
//    }


    public List<StudentDto> getStudentsByName(String name) {
        List<Student> student = studentRepository.findByName(name);
        if (student.isEmpty()) {
            throw new StudentNotFoundException(name + " Not Found in Database");
        }
        List<StudentDto> studentDtoList = new ArrayList<>();
        for (Student student1 : student) {
            StudentDto dto = new StudentDto();
            BeanUtils.copyProperties(student1, dto);
            studentDtoList.add(dto);
        }
        return studentDtoList;
    }

    public List<StudentDto> getStudents() {
        List<Student> student = studentRepository.findAll();
        if (student.isEmpty()) {
            throw new StudentNotFoundException("Database is Empty");
        }
        List<StudentDto> studentDto = new ArrayList<>();
        for (Student student1 : student) {
            StudentDto dto = new StudentDto();
            BeanUtils.copyProperties(student1, dto);
            studentDto.add(dto);
        }
        return studentDto;
    }

    public StudentDto updateStudent(Integer id, StudentDto newStudent) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Not found"));
        BeanUtils.copyProperties(newStudent,student);
        Student updateStudent=studentRepository.save(student);
        StudentDto responseDto=new StudentDto();
        BeanUtils.copyProperties(updateStudent,responseDto);
        return responseDto;
    }

    public Student patchStudent(Integer id, Student newStudent) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw new StudentNotFoundException("Not Found");
        }
        Student student1 = student.get();
        if (newStudent.getName() != null) {
            student1.setName(newStudent.getName());
        }
        if (newStudent.getStatus() != null) {
            student1.setStatus(newStudent.getStatus());
        }
        if (newStudent.getEmail() != null) {
            student1.setEmail(newStudent.getEmail());
        }
        return studentRepository.save(student1);
    }

    public void dltStudents() {
        studentRepository.deleteAll();
    }

    public void dltStudentById(Integer id) {
        studentRepository.deleteById(id);
    }
}
