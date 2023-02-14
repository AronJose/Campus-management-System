package com.Campus.Campus.view;

import com.Campus.Campus.entity.School;

public class SchoolView {
    
    private Integer schoolId;
    private Integer userId;
    private String fullName;
    private String  schoolName;
    private String place;
    private String address;
    private String contact;
    private String email;
   
    

    public SchoolView(School school){
        this.schoolId = school.getSchoolId();
        this.userId = school.getUserId().getUserId();
        this.fullName = school.getUserId().getFullName();
        this.schoolName = school.getSchoolName();
        this.place = school.getPlace();
        this.address = school.getAddress();
        this.contact = school.getContact();
        this.email = school.getEmail();
    }


    public Integer getSchoolId() {
        return schoolId;
    }


    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }


    public Integer getUserId() {
        return userId;
    }


    public void setUserId(Integer userId) {
        this.userId = userId;
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


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }




    public String getFullName() {
        return fullName;
    }


    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    
}
