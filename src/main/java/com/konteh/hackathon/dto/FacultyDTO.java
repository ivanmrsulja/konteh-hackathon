package com.konteh.hackathon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacultyDTO {

    private String id;

    private String name;

    private LocalTime opens;

    private LocalTime closes;
}
