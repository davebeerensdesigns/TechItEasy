package com.techiteasy.techiteasy.controllers;

import com.techiteasy.techiteasy.Dtos.RemoteControllerDto;
import com.techiteasy.techiteasy.Dtos.RemoteControllerInputDto;
import com.techiteasy.techiteasy.model.RemoteController;
import com.techiteasy.techiteasy.services.RemoteControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RemoteControllerController {

    private RemoteControllerService remotecontrollerService;

    @Autowired
    public RemoteControllerController(RemoteControllerService remotecontrollerService) {
        this.remotecontrollerService = remotecontrollerService;
    }


    @GetMapping("/remotecontrollers")
    public List<RemoteControllerDto> getRemoteControllers() {

        return remotecontrollerService.getRemoteControllers();

    }


    @GetMapping("/remotecontrollers/{id}")
    public RemoteControllerDto getRemoteController(@PathVariable("id") long id) {
        var remotecontroller = remotecontrollerService.getRemoteController(id);

        return RemoteControllerDto.fromRemoteController(remotecontroller);
    }

    @PostMapping("/remotecontrollers")
    public RemoteControllerDto addRemoteController(@RequestBody RemoteControllerInputDto dto) {
        var remotecontroller = remotecontrollerService.addRemoteController(dto.toRemoteController());
        return RemoteControllerDto.fromRemoteController(remotecontroller);
    }


    @DeleteMapping("/remotecontrollers/{id}")
    public void deleteRemoteController(@PathVariable("id") Long id) {
        remotecontrollerService.deleteRemoteController(id);
    }


    @PutMapping("remotecontrollers/{id}")
    public RemoteControllerDto updateRemoteController(@PathVariable("id") Long id, @RequestBody RemoteController remotecontroller) {
        remotecontrollerService.updateRemoteController(id, remotecontroller);
        return RemoteControllerDto.fromRemoteController(remotecontroller);
    }


}

