package com.Campus.Campus.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.Campus.Campus.entity.Student;

public interface StudentRepository extends Repository<Student,Integer> {
    
    Student save(Student student);
    
    List<Student>findAll();

    void delete(Student orElseThrow);

    Optional<Student> findByStudentId(Integer studentId);

     List<Student>findByUserUserId(Integer userId);
}
