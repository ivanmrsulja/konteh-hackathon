package com.konteh.hackathon.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "desks")
public class Desk extends BaseEntity{

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "reading_room_id")
    private Room readingRoom;

    @Column(name = "ordinal", nullable = false)
    private Integer order;

    @Column(name = "occupied", nullable = false)
    private Boolean occupied;

    public Desk(Integer order) {
        super();
        this.order = order;
    }
}
