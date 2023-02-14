package com.Campus.Campus.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Campus.Campus.form.StudentForm;
import com.Campus.Campus.service.StudentService;
import com.Campus.Campus.view.StudentView;

@RestController
@RequestMapping("/student")
public class StudentControlle {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public StudentView add(@Valid @RequestBody StudentForm form) {
        return studentService.add(form);
    }
    
    @GetMapping
    public List<StudentView> list() {
        return studentService.list();
    }

    @DeleteMapping("/{studentId}")
    public void delete(@PathVariable("studentId") Integer studentId) {
        studentService.delete(studentId);
    }

    @GetMapping("/{studentId}")
    public StudentView get(@PathVariable("studentId") Integer studentId) {
        return studentService.get(studentId);
    }

    @PutMapping("/{studentId}")
    public StudentView update(
            @PathVariable("studentId") Integer studentId,
            @Valid @RequestBody StudentForm form) {
        return studentService.update(studentId, form);
    }

    @GetMapping("/current")
    public List <StudentView >get() {
        return studentService.get();
    }
}
