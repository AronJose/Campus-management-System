package com.Campus.Campus.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.Campus.Campus.form.SchoolForm;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

@Entity
public class School {

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
    private Integer schoolId;
    private String schoolName;
    private String place;
    private String address;
    private String contact;
    private String email;
    private String principal;
    private byte status;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User user;

    public School() {
    }

    public School(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public School(User user, String schoolName, String place, String address, String contact,String email,String principal) {
        this.user = user;
        this.schoolName = schoolName;
        this.place = place;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.principal = principal;
   

        this.status = Status.ACTIVE.value;

        Date dt = new Date();
        this.createDate = dt;
        this.updateDate = dt;

    }


    public School(SchoolForm form) {
        this.user = form.getUserId();
        this.schoolName = form.getSchoolName();
        this.place = form.getPlace();
        this.address = form.getAddress();
        this.contact = form.getContact();
        this.email = form.getEmail();
        this.principal = form.getPrincipal();
        
        this.status = Status.ACTIVE.value;

        Date dt = new Date();
        this.createDate = dt;
        this.updateDate = dt;
    }

    public School update(SchoolForm form) {
        this.user = form.getUserId();
        this.schoolName = form.getSchoolName();
        this.place = form.getPlace();
        this.address = form.getAddress();
        this.contact = form.getContact();
        this.email = form.getEmail();
        this.principal = form.getPrincipal();
        Date dt = new Date();
        this.updateDate = dt;

        return this;
    }


    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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

    public User getUserId() {
        return user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserId(User user) {
        this.user = user;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

   

}
