package com.Campus.Campus.form;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.Campus.Campus.entity.School;
import com.Campus.Campus.entity.User;

public class StudentForm {

    private User userId;
    @NotNull
    private School schoolId;
    @NotNull
    private String studentName;
    private Date dob;
    private String address;
    private String contact;
    private String email;


    
    public User getUserId() {
        return userId;
    }
    public void setUserId(User userId) {
        this.userId = userId;
    }
    public School getSchoolId() {
        return schoolId;
    }
    public void setSchoolId(School schoolId) {
        this.schoolId = schoolId;
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

    
}
