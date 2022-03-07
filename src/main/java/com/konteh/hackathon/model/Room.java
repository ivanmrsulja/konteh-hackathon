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
@Table(name = "rooms")
public class Room extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "readingRoom")
    private Set<Desk> desks;

    public Room(String name) {
        super();
        this.name = name;
    }

    public void addDesk(Desk desk) {
        if(desks == null) {
            desks = new HashSet<>();
        }
        desks.add(desk);
        desk.setReadingRoom(this);
    }

    public void removeDesk(Desk desk) {
        desks.remove(desk);
        desk.setReadingRoom(null);
    }
}
