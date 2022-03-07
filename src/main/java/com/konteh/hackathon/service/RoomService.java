package com.konteh.hackathon.service;

import com.konteh.hackathon.model.Room;

import java.util.List;

public interface RoomService {

    List<Room> findAll();

    List<Room> findAllForFaculty(String facultyId);
}
