package com.konteh.hackathon.controller;

import com.konteh.hackathon.dto.FacultyDTO;
import com.konteh.hackathon.service.FacultyService;
import com.konteh.hackathon.util.FacultyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "faculties")
public class FacultyController {

    private final FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Collection<FacultyDTO> readFaculties() {
        var faculties = facultyService.findAll();
        return faculties.stream().map(FacultyFactory::facultyToFacultyDTO).collect(Collectors.toList());
    }
}
