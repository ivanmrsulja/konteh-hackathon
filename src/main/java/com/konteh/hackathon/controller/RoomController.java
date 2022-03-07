package com.konteh.hackathon.controller;

import com.konteh.hackathon.dto.RoomDTO;
import com.konteh.hackathon.service.RoomService;
import com.konteh.hackathon.util.RoomFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "rooms")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping(params = {"!faculty"})
    @ResponseStatus(HttpStatus.OK)
    public Collection<RoomDTO> readRooms() {
        var rooms = roomService.findAll();
        return rooms.stream().map(RoomFactory::roomToRoomDTO).collect(Collectors.toList());
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Collection<RoomDTO> readRoomsForFaculty(@RequestParam String faculty) {
        var rooms = roomService.findAllForFaculty(faculty);
        return rooms.stream().map(RoomFactory::roomToRoomDTO).collect(Collectors.toList());
    }
}
