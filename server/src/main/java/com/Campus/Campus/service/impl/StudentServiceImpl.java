package com.Campus.Campus.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Campus.Campus.entity.Student;
import com.Campus.Campus.exception.NotFoundException;
import com.Campus.Campus.form.StudentForm;
import com.Campus.Campus.repository.StudentRepository;
import com.Campus.Campus.security.util.SecurityUtil;
import com.Campus.Campus.service.StudentService;
import com.Campus.Campus.view.StudentView;

@Service
public class StudentServiceImpl implements StudentService {
    
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentView add(StudentForm form) {
        return new StudentView(studentRepository.save(new Student(SecurityUtil.getCurrentUserId(),form.getSchoolId(),form.getStudentName(),form.getDob(),form.getAddress(),form.getContact(),form.getEmail())));
    }
    
    @Override
    public List<StudentView>list()
    {
        List<StudentView>studentViews = new ArrayList<>();
        List<Student>students = studentRepository.findAll();
        students.forEach(student ->{
            studentViews.add(new StudentView(student));
        });
        return studentViews;
    }

    @Override
    @Transactional
    public void delete(Integer studentId) throws NotFoundException {
        studentRepository.delete(
            studentRepository.findByStudentId(studentId)
                        .orElseThrow(NotFoundException::new)
        );  
    }

    @Override
    public StudentView get(Integer studentId) throws NotFoundException{
        return studentRepository.findByStudentId(studentId).map((student)->{
            return new StudentView(student);
        }).orElseThrow(NotFoundException::new);
    }

    @Override
    @Transactional
    public StudentView update(Integer studentId, StudentForm form) throws NotFoundException {
        // if(studentRepository.findByStudentId(studentId).isPresent()){
        //     System.out.println("helow");
        // }
        return studentRepository.findByStudentId(studentId)
                .map((student) -> {
                    System.out.println("helllllow"+student.getStudentId());
                    return new StudentView(studentRepository.save(student.update(form)));
                }).orElseThrow(NotFoundException::new);
    }

    @Override
    public List< StudentView> get() throws NotFoundException {
          List<StudentView>studentViews=studentRepository.findByUserUserId(SecurityUtil.getCurrentUserId())
                .stream().map(StudentView::new).collect(Collectors.toList());
                return studentViews;
    }
}
