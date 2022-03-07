package com.konteh.hackathon.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "faculties")
public class Faculty extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "faculty")
    private Set<Room> rooms;

    @Embedded
    private WorkingHours workingHours;

    public Faculty(String name) {
        super();
        this.name = name;
    }

    public void addRoom(Room room) {
        if(rooms == null) {
            rooms = new HashSet<>();
        }
        rooms.add(room);
        room.setFaculty(this);
    }

    public void removeRoom(Room room) {
        rooms.remove(room);
        room.setFaculty(null);
    }
}
