package com.konteh.hackathon.repository;

import com.konteh.hackathon.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

    @Query("select f from Faculty f where f.isActive = true")
    List<Faculty> findAllActive();
}
