package com.konteh.hackathon.util;

import com.konteh.hackathon.dto.RoomDTO;
import com.konteh.hackathon.model.Room;

public class RoomFactory {

    public static RoomDTO roomToRoomDTO(Room room) {
        return new RoomDTO(room.getId(), room.getName());
    }
}
