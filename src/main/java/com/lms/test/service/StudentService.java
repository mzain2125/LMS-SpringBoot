package com.lms.test.service;

import com.lms.test.entity.Student;
import com.lms.test.entityDto.StudentDto;
import com.lms.test.exception.StudentAlreadyExist;
import com.lms.test.exception.StudentNotFoundException;
import com.lms.test.exception.TeacherNotFoundException;
import com.lms.test.repository.StudentRepository;
import com.lms.test.request.StudentRequest;
import com.lms.test.response.StudentResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements com.lms.test.interfaces.Student {

    @Autowired
    StudentRepository studentRepository;

    public StudentResponse saveStudent(StudentRequest studentRequest) {

        Student student = new Student();
        BeanUtils.copyProperties(studentRequest, student);
        student.setCreatedAt(LocalDateTime.now());
        studentRepository.save(student);
        StudentResponse response = new StudentResponse();
        BeanUtils.copyProperties(student, response);
        return response;

    }
//        String email = student.getEmail();
//        if (!email.endsWith("@gmail.com")) {
//            email = email + "@gmail.com";
//            student.setEmail(email);
//        }
//
//        if (studentRepository.existsByEmail(student.getEmail())) {
//            throw new StudentAlreadyExist("This Student Already Exist in Database");
//        }

    // Generate Age Calculate
//    public int calculateAge(LocalDate dob){
//            return Period.between(dob,LocalDate.now()).getYears();
//    }
    public StudentResponse getStudentById(Integer id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student Not Found in the Database"));
        StudentResponse studentResponse = new StudentResponse();
        BeanUtils.copyProperties(student, studentResponse);
        return studentResponse;
    }

//    public Student getStudentById(Integer id) {
//        return studentRepository.findById(id).orElseThrow(
//                () -> new StudentNotFoundException("student not found Exception"));
//
//    }


    public List<StudentResponse> getStudentsByName(String name) {
        List<Student> student = studentRepository.findByName(name);
        if (student.isEmpty()) {
            throw new StudentNotFoundException(name + " Not Found in Database");
        }
        List<StudentResponse> studentResponseList = new ArrayList<>();
        for (Student student1 : student) {
            StudentResponse studentResponse = new StudentResponse();
            BeanUtils.copyProperties(student1, studentResponse);
            studentResponseList.add(studentResponse);
        }
        return studentResponseList;
    }

    public List<StudentResponse> getStudents() {
        List<Student> student = studentRepository.findAll();
        if (student.isEmpty()) {
            throw new StudentNotFoundException("Database is Empty");
        }
        List<StudentResponse> studentResponseList = new ArrayList<>();
        for (Student student1 : student) {
            StudentResponse studentResponse = new StudentResponse();
            BeanUtils.copyProperties(student1, studentResponse);
            studentResponseList.add(studentResponse);
        }
        return studentResponseList;
    }

    public StudentResponse updateStudent(Integer id, StudentRequest newStudent) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Not found"));
        BeanUtils.copyProperties(newStudent, student);
        Student updateStudent = studentRepository.save(student);
        StudentResponse studentRequest = new StudentResponse();
        BeanUtils.copyProperties(updateStudent, studentRequest);
        return studentRequest;
    }

    public StudentResponse patchStudent(Integer id, StudentRequest newStudent) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw new StudentNotFoundException("Student Not Found");
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
        if(newStudent.getDateOfBirth()!=null){
            student1.setDateOfBirth(newStudent.getDateOfBirth());
        }
        if(newStudent.getGrade()!=null){
            student1.setGrade(newStudent.getGrade());
        }
        if(newStudent.getPhoneNumber()!=null){
            student1.setPhoneNumber(newStudent.getPhoneNumber());
        }
        studentRepository.save(student1);
        StudentResponse response=new StudentResponse();
        BeanUtils.copyProperties(student1,response);
        return response;
    }

    public void dltStudents() {
        studentRepository.deleteAll();
    }

    public void dltStudentById(Integer id) {
        Student student=studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException("Student Not Found in the DB"));
        studentRepository.deleteById(id);
    }
}
