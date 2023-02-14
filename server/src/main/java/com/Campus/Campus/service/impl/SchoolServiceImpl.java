package com.Campus.Campus.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Campus.Campus.entity.School;
import com.Campus.Campus.exception.NotFoundException;
import com.Campus.Campus.form.SchoolForm;
import com.Campus.Campus.repository.SchoolRepository;
import com.Campus.Campus.service.SchoolService;
import com.Campus.Campus.view.SchoolView;



@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public SchoolView add(SchoolForm school) {
        return new SchoolView(schoolRepository.save(new School(school.getUserId(),school.getSchoolName(),school.getPlace(),school.getAddress(),school.getContact(),school.getEmail(),school.getPrincipal())));
    }
    
    // list All schools
    @Override
    public List<SchoolView>list()
    {
        List<SchoolView>schoolViews = new ArrayList<>();
        List<School>schools = schoolRepository.findAll();
        schools.forEach(school ->{
            schoolViews.add(new SchoolView(school));
        });
        return schoolViews;
    }

    @Override
    @Transactional
    public void delete(Integer schoolId) throws NotFoundException {
        schoolRepository.delete(
            schoolRepository.findBySchoolId(schoolId)
                        .orElseThrow(NotFoundException::new)
        );
    }

    @Override
    public SchoolView get(Integer schoolId) throws NotFoundException{
        return schoolRepository.findBySchoolId(schoolId).map((school)->{
            return new SchoolView(school);
        }).orElseThrow(NotFoundException::new);
    }

    @Override
    @Transactional
    public SchoolView update(Integer schoolId, SchoolForm form) throws NotFoundException {
        System.out.println("hellow");
        return schoolRepository.findBySchoolId(schoolId)
                .map((school) -> {

                    return new SchoolView(schoolRepository.save(school.update(form)));
                }).orElseThrow(NotFoundException::new);
    }

    // search
    @Override
    public List<School>getSchoolSearch(String keyword){
    System.out.println("hellow");
    List<School> pagedResult = schoolRepository.findByName(keyword);
    return pagedResult;
    }
}
