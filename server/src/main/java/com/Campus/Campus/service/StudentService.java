package com.Campus.Campus.service;

import java.util.List;

import com.Campus.Campus.exception.NotFoundException;
import com.Campus.Campus.form.StudentForm;
import com.Campus.Campus.view.StudentView;

public interface StudentService {

    StudentView add(StudentForm form);

    List<StudentView>list();

    void delete(Integer studentId) throws NotFoundException;
    
    StudentView get(Integer studentId) throws NotFoundException;

    StudentView update(Integer studentId,StudentForm form) throws NotFoundException;

    List<StudentView> get() throws NotFoundException;
}
