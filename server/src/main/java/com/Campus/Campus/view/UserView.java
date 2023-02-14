package com.Campus.Campus.view;

import java.util.Date;

import com.Campus.Campus.entity.User;
import com.Campus.Campus.json.Json;

public class UserView {

    private final Integer userId;
    private  Integer schoolId;
    private final String fullName;
    private final String email;
    @Json.DateFormat
    private final Date dob;
    private final String address;
    private final String phone;
    private final byte status;
    private final Integer role;
    @Json.DateTimeFormat
    private final Date updateDate;
    @Json.DateTimeFormat
    private final Date createDate;

    public UserView(User user) {
    
        this.userId = user.getUserId();
        this.fullName = user.getFullName();
        this.email = user.getEmail();
        this.dob = user.getDob();
        this.address = user.getAddress();
        this.phone = user.getPhone();
        this.status = user.getStatus();
        this.role = user.getRole();
        this.createDate = user.getCreateDate();
        this.updateDate = user.getUpdateDate();
    }

    public Integer getUserId() {
        return userId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }


    public Date getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public byte getStatus() {
        return status;
    }

    public Integer getRole() {
        return role;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    
    }


