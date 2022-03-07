package com.konteh.hackathon.service.impl;

import com.konteh.hackathon.dto.CreateDeskDTO;
import com.konteh.hackathon.model.Desk;
import com.konteh.hackathon.repository.DeskRepository;
import com.konteh.hackathon.repository.RoomRepository;
import com.konteh.hackathon.service.DeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DeskServiceImpl implements DeskService {

    private final DeskRepository deskRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public DeskServiceImpl(DeskRepository deskRepository, RoomRepository roomRepository) {
        this.deskRepository = deskRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Desk> findAll() {
        return deskRepository.findAllActive();
    }

    @Override
    public List<Desk> findAllForRoom(String roomId) {
        return deskRepository.findAllForRoom(roomId);
    }

    @Override
    @Transactional
    public Desk createDesk(CreateDeskDTO desk) {
        var newDesk = new Desk();
        var room = roomRepository.findById(desk.getRoomId()).orElseThrow(() -> new NoSuchElementException("There is no room with id: " + desk.getRoomId()));
        int maxOrder = deskRepository.findMaxOrderForRoom(room.getId());
        newDesk.setOrder(maxOrder + 1);
        newDesk.setOccupied(false);
        room.addDesk(newDesk);

        deskRepository.save(newDesk);
        roomRepository.save(room);

        return newDesk;
    }

    @Override
    @Transactional
    public void deleteDesk(String id) {
        var desk = deskRepository.findForUpdate(id).orElseThrow(() -> new NoSuchElementException("There is no desk with id: " + id));
        desk.setIsActive(false);
        deskRepository.save(desk);

        var desks = deskRepository.findAllForRoom(desk.getReadingRoom().getId());
        desks.stream().filter((d) -> d.getOrder() > desk.getOrder()).forEach((d) -> d.setOrder(d.getOrder() - 1));
    }
}
