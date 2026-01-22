package com.lms.test.repository;

import com.lms.test.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    public Teacher getTeacherByEmail(String email);
    public List<Teacher> getTeacherByName(String name);
    public List<Teacher> findByNameAndEmail(String name, String email);
//    public Teacher deleteTeacherById(Integer id);
}
