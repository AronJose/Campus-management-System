package com.Campus.Campus.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import com.Campus.Campus.entity.School;


public interface SchoolRepository extends Repository<School,Integer> {
    
    School save(School school);

    List<School>findAll();

    void delete(School orElseThrow);

    Optional<School> findBySchoolId(Integer schoolId);

    @Query(value="SELECT * FROM school WHERE school_name LIKE %?1% ",nativeQuery = true)
    List<School>findByName(String name);
}
