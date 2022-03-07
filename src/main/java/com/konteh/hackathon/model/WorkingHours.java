package com.konteh.hackathon.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class WorkingHours{

    @Column(name = "opens", nullable = false)
    private LocalTime opens;

    @Column(name = "closes", nullable = false)
    private LocalTime closes;
}
