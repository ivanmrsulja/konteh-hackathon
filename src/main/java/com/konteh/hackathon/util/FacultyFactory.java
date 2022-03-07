package com.konteh.hackathon.util;

import com.konteh.hackathon.dto.FacultyDTO;
import com.konteh.hackathon.model.Faculty;
import org.springframework.stereotype.Component;

@Component
public class FacultyFactory {

    public static FacultyDTO facultyToFacultyDTO(Faculty faculty) {
        return new FacultyDTO(faculty.getId(), faculty.getName(), faculty.getWorkingHours().getOpens(), faculty.getWorkingHours().getCloses());
    }
}
