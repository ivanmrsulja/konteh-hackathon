package com.konteh.hackathon.controller;

import com.konteh.hackathon.dto.CreateDeskDTO;
import com.konteh.hackathon.dto.DeskDTO;
import com.konteh.hackathon.service.DeskService;
import com.konteh.hackathon.util.DeskFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "desks")
public class DeskController {

    private final DeskService deskService;

    @Autowired
    public DeskController(DeskService deskService) {
        this.deskService = deskService;
    }

    @GetMapping(params = {"!room"})
    @ResponseStatus(HttpStatus.OK)
    public Collection<DeskDTO> readDesks() {
        var desks = deskService.findAll();
        return desks.stream().map(DeskFactory::deskToDeskDTO).collect(Collectors.toList());
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Collection<DeskDTO> readDesksForRoom(@RequestParam String room) {
        var desks = deskService.findAllForRoom(room);
        return desks.stream().map(DeskFactory::deskToDeskDTO).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDesk(@PathVariable String id) {
        deskService.deleteDesk(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeskDTO createDesk(@Valid @RequestBody CreateDeskDTO desk) {
        var createdDesk = deskService.createDesk(desk);
        return DeskFactory.deskToDeskDTO(createdDesk);
    }
}
