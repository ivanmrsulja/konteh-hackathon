package com.konteh.hackathon.util;

import com.konteh.hackathon.dto.DeskDTO;
import com.konteh.hackathon.model.Desk;

public class DeskFactory {

    public static DeskDTO deskToDeskDTO(Desk desk) {
        return new DeskDTO(desk.getId(), desk.getOrder(), desk.getOccupied());
    }

    public static Desk deskDToToDesk(DeskDTO deskDTO) {
        return new Desk(deskDTO.getOrder());
    }
}
