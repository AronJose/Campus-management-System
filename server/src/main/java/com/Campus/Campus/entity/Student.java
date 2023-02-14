package com.Campus.Campus.entity;

import java.util.Date;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.Campus.Campus.form.StudentForm;

import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {

    public static enum Status {
        DELETE((byte) 0),
        ACTIVE((byte) 1);

        public final byte value;

        private Status(byte value) {
            this.value = value;
        }
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    private String studentName;
    private Date dob;
    private String address;
    private String contact;
    private String email;
    private byte status;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;
    @JoinColumn(name = "school_id", referencedColumnName = "school_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private School school;

    public Student(){}

    public Student(Integer studentId){
        this.studentId = studentId;
    }

    public Student(Integer userId,School school,String studentName,Date dob,String address,String contact,String email){
        this.user = new User(userId);
        this.school = school;
        this.studentName = studentName;
        this.dob = dob;
        this.address = address;
        this.contact = contact;
        this.email = email;

        this.status = Status.ACTIVE.value;

        Date dt = new Date();
        this.createDate = dt;
        this.updateDate = dt;

    }

    // save 
    public Student(StudentForm form){
        this.user = form.getUserId();
        this.school =form.getSchoolId();
        this.studentName = form.getStudentName();
        this.dob = form.getDob();
        this.address = form.getAddress();
        this.contact = form.getContact();
        this.email = form.getEmail();

        this.status = Status.ACTIVE.value;

        Date dt = new Date();
        this.createDate = dt;
        this.updateDate = dt;
    }

    public Student update(StudentForm form) {
        this.school =form.getSchoolId();
        this.studentName = form.getStudentName();
        this.dob = form.getDob();
        this.address = form.getAddress();
        this.contact = form.getContact();
        this.email = form.getEmail();
        Date dt = new Date();
        this.updateDate = dt;

        return this;
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
    public byte getStatus() {
        return status;
    }
    public void setStatus(byte status) {
        this.status = status;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Date getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public School getSchool() {
        return school;
    }
    public void setSchool(School school) {
        this.school = school;
    }

    
}
