package com.techiteasy.techiteasy.services;

import com.techiteasy.techiteasy.Dtos.RemoteControllerDto;
import com.techiteasy.techiteasy.exceptions.RecordNotFoundException;
import com.techiteasy.techiteasy.model.RemoteController;
import com.techiteasy.techiteasy.repository.RemoteControllerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RemoteControllerService {

    private RemoteControllerRepository remotecontrollerRepository;

    @Autowired
    public RemoteControllerService(RemoteControllerRepository remotecontrollerRepository) {
        this.remotecontrollerRepository = remotecontrollerRepository;
    }

    public List<RemoteControllerDto> getRemoteControllers(){
        var dtos = new ArrayList<RemoteControllerDto>();
        var remotecontrollers = remotecontrollerRepository.findAll();

        for (RemoteController remotecontroller : remotecontrollers) {
            dtos.add(RemoteControllerDto.fromRemoteController(remotecontroller));
        }

        return dtos;
    }

    public RemoteController getRemoteController(long id){
        Optional<RemoteController> optionalRemoteController = remotecontrollerRepository.findById(id);

        if(optionalRemoteController.isPresent()){
            return optionalRemoteController.get();
        } else{
            // exception
            throw new RecordNotFoundException("ID does not exist!");
        }
    }

    public RemoteController addRemoteController(RemoteController remotecontroller){
        return remotecontrollerRepository.save(remotecontroller);
    }

    public void deleteRemoteController(long id){
        remotecontrollerRepository.deleteById(id);
    }

    public void updateRemoteController(long id, RemoteController remotecontroller){
        if (!remotecontrollerRepository.existsById(id)) {
            throw new RecordNotFoundException("ID does not exist!");
        }
        RemoteController existingRemoteController = remotecontrollerRepository.findById(id).orElse(null);

        existingRemoteController.setCompatibleWith(remotecontroller.getCompatibleWith());
        existingRemoteController.setBatteryType(remotecontroller.getBatteryType());
        existingRemoteController.setName(remotecontroller.getName());
        existingRemoteController.setBrand(remotecontroller.getBrand());
        existingRemoteController.setPrice(remotecontroller.getPrice());
        existingRemoteController.setOriginalStock(remotecontroller.getOriginalStock());

        remotecontrollerRepository.save(existingRemoteController);
    }

}