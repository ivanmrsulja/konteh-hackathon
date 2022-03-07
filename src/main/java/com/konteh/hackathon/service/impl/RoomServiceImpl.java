package com.konteh.hackathon.service.impl;

import com.konteh.hackathon.model.Room;
import com.konteh.hackathon.repository.RoomRepository;
import com.konteh.hackathon.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomReposiory;

    @Autowired
    public RoomServiceImpl(RoomRepository roomReposiory) {
        this.roomReposiory = roomReposiory;
    }

    @Override
    public List<Room> findAll() {
        return roomReposiory.findAllActive();
    }

    @Override
    public List<Room> findAllForFaculty(String facultyId) {
        return roomReposiory.findAllForFaculty(facultyId);
    }
}
