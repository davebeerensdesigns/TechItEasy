package com.techiteasy.techiteasy.controllers;

import com.techiteasy.techiteasy.Dtos.RemoteControllerDto;
import com.techiteasy.techiteasy.Dtos.RemoteControllerInputDto;
import com.techiteasy.techiteasy.model.RemoteController;
import com.techiteasy.techiteasy.services.RemoteControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RemoteControllerController {

    private final RemoteControllerService remoteControllerService;

    @Autowired
    public RemoteControllerController(RemoteControllerService remoteControllerService) {
        this.remoteControllerService = remoteControllerService;
    }


    @GetMapping("/remotecontrollers")
    public List<RemoteControllerDto> getRemoteControllers() {

        var dtos = new ArrayList<RemoteControllerDto>();

        var remotecontrollers = remoteControllerService.getRemoteControllers();

        for (RemoteController remoteController : remotecontrollers){
            dtos.add(RemoteControllerDto.fromRemoteController(remoteController));
        }

        return dtos;

    }


    @GetMapping("/remotecontrollers/{id}")
    public RemoteControllerDto getRemoteController(@PathVariable("id") long id) {
        var remotecontroller = remoteControllerService.getRemoteController(id);

        return RemoteControllerDto.fromRemoteController(remotecontroller);
    }

    @PostMapping("/remotecontrollers")
    public RemoteControllerDto addRemoteController(@RequestBody RemoteControllerInputDto dto) {
        var remotecontroller = remoteControllerService.addRemoteController(dto.toRemoteController());
        return RemoteControllerDto.fromRemoteController(remotecontroller);
    }


    @DeleteMapping("/remotecontrollers/{id}")
    public void deleteRemoteController(@PathVariable("id") Long id) {
        remoteControllerService.deleteRemoteController(id);
    }


    @PutMapping("remotecontrollers/{id}")
    public RemoteControllerDto updateRemoteController(@PathVariable("id") Long id, @RequestBody RemoteController remotecontroller) {
        remoteControllerService.updateRemoteController(id, remotecontroller);
        return RemoteControllerDto.fromRemoteController(remotecontroller);
    }


}

