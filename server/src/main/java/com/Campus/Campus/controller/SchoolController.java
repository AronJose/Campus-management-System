package com.Campus.Campus.controller;

// import java.net.http.HttpHeaders;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Campus.Campus.entity.School;
import com.Campus.Campus.form.SchoolForm;
import com.Campus.Campus.service.SchoolService;
import com.Campus.Campus.view.SchoolView;

@RestController
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @PostMapping
    public SchoolView add(@Valid @RequestBody SchoolForm form)
    {
        return schoolService.add(form);
    }

    @GetMapping
    public List<SchoolView> schoollist() {
        return schoolService.list();
    }
    
    @DeleteMapping("/{schoolId}")
    public void schooldelete(@PathVariable("schoolId") Integer schoolId) {
        schoolService.delete(schoolId);
    }

    @GetMapping("/{schoolId}")
    public SchoolView get(@PathVariable("schoolId") Integer schoolId) {
        return schoolService.get(schoolId);
    }

    @PutMapping("/{schoolId}")
    public SchoolView update(
            @PathVariable("schoolId") Integer schoolId,
            @Valid @RequestBody SchoolForm form) {
        return schoolService.update(schoolId, form);
    }

    // search
    @GetMapping("/search")
    public ResponseEntity<List<School>>getSchool(
            @RequestParam(defaultValue = "") String keyword)
            {
                System.out.println("hellow");
                List<School> list = schoolService.getSchoolSearch(keyword);
                return new ResponseEntity<List<School>>(list, new HttpHeaders(),
                HttpStatus.OK);
            }
}
