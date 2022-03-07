package com.konteh.hackathon.service;

import com.konteh.hackathon.dto.CreateDeskDTO;
import com.konteh.hackathon.model.Desk;

import java.util.List;

public interface DeskService {

    List<Desk> findAll();

    List<Desk> findAllForRoom(String roomId);

    Desk createDesk(CreateDeskDTO desk);

    void deleteDesk(String id);
}
