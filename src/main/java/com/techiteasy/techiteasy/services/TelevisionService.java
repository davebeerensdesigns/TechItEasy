package com.techiteasy.techiteasy.services;

import com.techiteasy.techiteasy.Dtos.TelevisionDto;
import com.techiteasy.techiteasy.exceptions.RecordNotFoundException;
import com.techiteasy.techiteasy.model.Television;
import com.techiteasy.techiteasy.repository.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TelevisionService {

    @Autowired
    private TelevisionRepository televisionRepository;

    public Iterable<Television> getTelevisions(String name){
        if(name.isEmpty()){
            return televisionRepository.findAll();
        } else {
            return televisionRepository.searchByTitleLike(name);
        }
    }

    public Television getTelevision(long id){
        Optional<Television> optionalTelevision = televisionRepository.findById(id);

        if(optionalTelevision.isPresent()){
            return optionalTelevision.get();
        } else{
            // exception
            throw new RecordNotFoundException("ID does not exist!");
        }
    }

    public long addTelevision(TelevisionDto televisionDto){

        Television television = new Television();

        television.setType(televisionDto.type);
        television.setBrand(televisionDto.brand);
        television.setName(televisionDto.name);
        television.setPrice(televisionDto.price);
        television.setAvailableSize(televisionDto.availableSize);
        television.setRefreshRate(televisionDto.refreshRate);
        television.setScreenType(televisionDto.screenType);
        television.setScreenQuality(televisionDto.screenQuality);
        television.setSmartTv(televisionDto.smartTv);
        television.setWifi(televisionDto.wifi);
        television.setVoiceControl(televisionDto.voiceControl);
        television.setHdr(televisionDto.hdr);
        television.setBluetooth(televisionDto.bluetooth);
        television.setAmbiLight(televisionDto.ambiLight);
        television.setOriginalStock(televisionDto.originalStock);
        television.setSold(televisionDto.sold);

        Television newTelevision = televisionRepository.save(television);

        return newTelevision.getId();
    }

    public void updateTelevision(long id, Television television){
        if (!televisionRepository.existsById(id)) {
            throw new RecordNotFoundException("ID does not exist!");
        } else {
            long checkId = television.getId();
            if (checkId != id) {
                throw new RecordNotFoundException("ID does not match the given path!");
            } else {
                Television existingTelevision = televisionRepository.findById(id).orElse(null);

                existingTelevision.setType(television.getType());
                existingTelevision.setBrand(television.getBrand());
                existingTelevision.setName(television.getName());
                existingTelevision.setPrice(television.getPrice());
                existingTelevision.setAvailableSize(television.getAvailableSize());
                existingTelevision.setRefreshRate(television.getRefreshRate());
                existingTelevision.setScreenType(television.getScreenType());
                existingTelevision.setScreenQuality(television.getScreenQuality());
                existingTelevision.setSmartTv(television.getSmartTv());
                existingTelevision.setVoiceControl(television.getVoiceControl());
                existingTelevision.setHdr(television.getHdr());
                existingTelevision.setBluetooth(television.getBluetooth());
                existingTelevision.setAmbiLight(television.getAmbiLight());
                existingTelevision.setOriginalStock(television.getOriginalStock());
                existingTelevision.setSold(television.getSold());

                televisionRepository.save(existingTelevision);
            }
        }
    }

    public void partialTelevision(long id, Television television){
        if (!televisionRepository.existsById(id)) {
            throw new RecordNotFoundException("ID does not exist!");
        } else {
            long checkId = television.getId();
            if (checkId != id) {
                throw new RecordNotFoundException("ID does not match the given path!");
            } else {
                Television existingTelevision = televisionRepository.findById(id).orElse(null);

                if(television.getType() != null && !television.getType().isEmpty()){
                    existingTelevision.setType(television.getType());
                }
                if(television.getBrand() != null && !television.getBrand().isEmpty()){
                    existingTelevision.setBrand(television.getBrand());
                }
                if(television.getName() != null && !television.getName().isEmpty()){
                    existingTelevision.setName(television.getName());
                }
                if(television.getPrice() != null){
                    existingTelevision.setPrice(television.getPrice());
                }
                if(television.getAvailableSize() != null){
                    existingTelevision.setAvailableSize(television.getAvailableSize());
                }
                if(television.getRefreshRate() != null){
                    existingTelevision.setRefreshRate(television.getRefreshRate());
                }
                if(television.getScreenType() != null && !television.getScreenType().isEmpty()){
                    existingTelevision.setScreenType(television.getScreenType());
                }
                if(television.getScreenQuality() != null && !television.getScreenQuality().isEmpty()){
                    existingTelevision.setScreenQuality(television.getScreenQuality());
                }
                if(television.getSmartTv() != null){
                    existingTelevision.setSmartTv(television.getSmartTv());
                }
                if(television.getWifi() != null){
                    existingTelevision.setWifi(television.getWifi());
                }
                if(television.getVoiceControl() != null){
                    existingTelevision.setVoiceControl(television.getVoiceControl());
                }
                if(television.getHdr() != null){
                    existingTelevision.setHdr(television.getHdr());
                }
                if(television.getBluetooth() != null){
                    existingTelevision.setBluetooth(television.getBluetooth());
                }
                if(television.getAmbiLight() != null){
                    existingTelevision.setAmbiLight(television.getAmbiLight());
                }
                if(television.getOriginalStock() != null){
                    existingTelevision.setOriginalStock(television.getOriginalStock());
                }
                if(television.getSold() != null){
                    existingTelevision.setSold(television.getSold());
                }

                televisionRepository.save(existingTelevision);
            }
        }
    }

    public void deleteTelevision(long id){
        if (!televisionRepository.existsById(id)) {
            throw new RecordNotFoundException("ID does not exist!");
        } else {
            televisionRepository.deleteById(id);
        }
    }

}
