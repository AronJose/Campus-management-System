package com.Campus.Campus.service;

import java.util.List;

import com.Campus.Campus.entity.School;
import com.Campus.Campus.exception.NotFoundException;
import com.Campus.Campus.form.SchoolForm;
import com.Campus.Campus.view.SchoolView;


public interface SchoolService {

    SchoolView add(SchoolForm form);

    // list All schools
    List<SchoolView>list();

    void delete(Integer schoolId) throws NotFoundException;

    SchoolView get(Integer schoolId) throws NotFoundException;

    SchoolView update(Integer schoolId,SchoolForm form) throws NotFoundException;

    // search
    List<School>getSchoolSearch(String keyword);
    
}
