package com.konteh.hackathon.service.impl;

import com.konteh.hackathon.model.Faculty;
import com.konteh.hackathon.repository.FacultyRepository;
import com.konteh.hackathon.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public List<Faculty> findAll() {
        return facultyRepository.findAllActive();
    }
}
