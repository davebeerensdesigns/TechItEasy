package com.techiteasy.techiteasy.services;

import com.techiteasy.techiteasy.exceptions.RecordNotFoundException;
import com.techiteasy.techiteasy.model.RemoteController;
import com.techiteasy.techiteasy.repository.RemoteControllerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RemoteControllerService {

    private RemoteControllerRepository remotecontrollerRepository;

    @Autowired
    public RemoteControllerService(RemoteControllerRepository remotecontrollerRepository) {
        this.remotecontrollerRepository = remotecontrollerRepository;
    }

    public List<RemoteController> getRemoteControllers(){
        return remotecontrollerRepository.findAll();
    }

    public RemoteController getRemoteController(long id){
        Optional<RemoteController> remoteController = remotecontrollerRepository.findById(id);

        if(remoteController.isPresent()){
            return remoteController.get();
        } else{
            // exception
            throw new RecordNotFoundException("No remotecontroller found");
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
            throw new RecordNotFoundException("No remotecontroller found");
        }
        RemoteController storedRemoteController = remotecontrollerRepository.findById(id).orElse(null);

        storedRemoteController.setId(remotecontroller.getId());
        storedRemoteController.setCompatibleWith(remotecontroller.getCompatibleWith());
        storedRemoteController.setBatteryType(remotecontroller.getBatteryType());
        storedRemoteController.setName(remotecontroller.getName());
        storedRemoteController.setPrice(remotecontroller.getPrice());
        storedRemoteController.setBrand(remotecontroller.getBrand());
        storedRemoteController.setOriginalStock(remotecontroller.getOriginalStock());

        remotecontrollerRepository.save(storedRemoteController);
    }

}