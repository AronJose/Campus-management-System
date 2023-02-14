package com.Campus.Campus.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.FetchType;
import com.Campus.Campus.form.UserForm;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class User {

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
    private Integer userId;
    private String fullName;
    private Date dob;
    private String phone;
    private String address;
    private String email;
    private String password;
    private Integer role;
    private byte status;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @JoinColumn(name = "school_id", referencedColumnName = "school_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private School school;

    public User(School schoolId,String fullName, String email, String phone, String password, Integer role, Byte status, String address,
            Date dob) {
        this.school = schoolId;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.role = role;
        this.status = Status.ACTIVE.value;
        this.address = address;
        this.dob = dob;
        Date dt = new Date();
        this.createDate = dt;
        this.updateDate = dt;
    }

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    // get values from Form
    public User(UserForm form){
        this.school = form.getSchoolId();
        this.fullName = form.getFullName();
        this.dob = form.getDob();
        this.email = form.getEmail();
        this.phone = form.getPhone();
        this.address = form.getAddress();
        this.password = form.getPassword();
        this.role = form.getRole();
        this.status = Status.ACTIVE.value;
        Date dt = new Date();
        this.createDate = dt;
        this.updateDate = dt;
    }

    public User update(UserForm form) {
        this.school = form.getSchoolId();
        this.fullName = form.getFullName();
        this.dob = form.getDob();
        this.email = form.getEmail();
        this.phone = form.getPhone();
        this.address = form.getAddress();
        this.password = form.getPassword();
        this.role = form.getRole();
        Date dt = new Date();
        this.updateDate = dt;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
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

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

}
