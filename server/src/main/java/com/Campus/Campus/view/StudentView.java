package com.Campus.Campus.view;

import java.util.Date;
import com.Campus.Campus.entity.Student;

public class StudentView {

    private Integer userId;
    private Integer schoolId;
    private String schoolName;
    private Integer studentId;
    private String studentName;
    private Date dob;
    private String address;
    private String contact;
    private String email;

    public StudentView(Student student) {
        this.userId = student.getUser().getUserId();
        this.schoolId = student.getSchool().getSchoolId();
        this.schoolName = student.getSchool().getSchoolName();
        this.studentId = student.getStudentId();
        this.studentName = student.getStudentName();
        this.dob = student.getDob();
        this.address = student.getAddress();
        this.contact = student.getContact();
        this.email = student.getEmail();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

}
