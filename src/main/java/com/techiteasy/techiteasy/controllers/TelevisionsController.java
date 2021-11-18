package com.techiteasy.techiteasy.controllers;

import com.techiteasy.techiteasy.exceptions.RecordIsEmptyException;
import com.techiteasy.techiteasy.exceptions.RecordNotFoundException;
import com.techiteasy.techiteasy.model.Television;
import com.techiteasy.techiteasy.repository.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TelevisionsController {
   
   private final List<String> televisions;
   
   public TelevisionsController() {
      this.televisions = new ArrayList<>();
      televisions.add("Television One");
      televisions.add("Television Two");
      televisions.add("Television Three");
      televisions.add("Television Four");
      televisions.add("Television Five");
   }

   @Autowired
   private TelevisionRepository televisionRepository;

   // CREATE
   @PostMapping("/televisions")
   public ResponseEntity<Object> addTelevision(@RequestBody Television television) {

      if (television != null) {
         // add one item
         televisionRepository.save(television);
         URI location = URI.create("/televisions");
         return ResponseEntity.created(location).body(television);
      } else {
         throw new RecordIsEmptyException("Body is empty");
      }
   }

   
   // READ
   @GetMapping("/televisions")
   public ResponseEntity<Object> getAllTelevisions() {
      // get all items
      return ResponseEntity.ok(televisionRepository.findAll(Sort.by(Sort.Direction.ASC, "id"))); // Jackson package - object => json
   }
   
   @GetMapping("/televisions/{id}")
   public ResponseEntity<Object> getTelevision(@PathVariable long id) {

      if (!televisionRepository.existsById(id)) {
         throw new RecordNotFoundException("ID does not exist!");
      } else {
         // get one item by id
         return ResponseEntity.ok(televisionRepository.findById(id)); // Jackson package - object => json
      }
   }


   //UPDATE
   @PutMapping("/televisions/{id}")
   public ResponseEntity<Object> updateTelevision(@PathVariable long id, @RequestBody Television television) {
      if (!televisionRepository.existsById(id)) {
         throw new RecordNotFoundException("ID does not exist!");
      } else {
         long checkId = television.getId();
         if (checkId != id) {
            throw new RecordNotFoundException("ID does not match the given path!");
         } else {
            televisionRepository.save(television);
            return ResponseEntity.ok(televisionRepository.findById(id));
         }
      }
   }

   //PATCH
   @PatchMapping("/televisions/{id}")
   public ResponseEntity<Object> patchTelevision(@PathVariable long id, @RequestBody Television television) {
      if (!televisionRepository.existsById(id)) {
         throw new RecordNotFoundException("ID does not exist!");
      } else {
         long checkId = television.getId();
         if (checkId != id) {
            throw new RecordNotFoundException("ID does not match the given path!");
         } else {
            Television televisionOld = televisionRepository.getById(id);

            if(television.getType() != null){
               televisionOld.setType(television.getType());
            }
            if(television.getBrand() != null){
               televisionOld.setBrand(television.getBrand());
            }
            if(television.getName() != null){
               televisionOld.setName(television.getName());
            }
            if(television.getPrice() != null){
               televisionOld.setPrice(television.getPrice());
            }
            if(television.getAvailableSize() != null){
               televisionOld.setAvailableSize(television.getAvailableSize());
            }
            if(television.getRefreshRate() != null){
               televisionOld.setRefreshRate(television.getRefreshRate());
            }
            if(television.getScreenType() != null){
               televisionOld.setScreenType(television.getScreenType());
            }
            if(television.getScreenQuality() != null){
               televisionOld.setScreenQuality(television.getScreenQuality());
            }
            if(television.getSmartTv() != null){
               televisionOld.setSmartTv(television.getSmartTv());
            }
            if(television.getWifi() != null){
               televisionOld.setWifi(television.getWifi());
            }
            if(television.getVoiceControl() != null){
               televisionOld.setVoiceControl(television.getVoiceControl());
            }
            if(television.getHdr() != null){
               televisionOld.setHdr(television.getHdr());
            }
            if(television.getBluetooth() != null){
               televisionOld.setBluetooth(television.getBluetooth());
            }
            if(television.getAmbiLight() != null){
               televisionOld.setAmbiLight(television.getAmbiLight());
            }
            if(television.getOriginalStock() != null){
               televisionOld.setOriginalStock(television.getOriginalStock());
            }
            if(television.getSold() != null){
               televisionOld.setSold(television.getSold());
            }

            return ResponseEntity.ok(televisionRepository.save(televisionOld));
         }
      }
   }
   
   
   // DELETE
   @DeleteMapping("/televisions/{id}")
   public ResponseEntity<Object> deleteTelevision(@PathVariable long id) {

      if (!televisionRepository.existsById(id)) {
         throw new RecordNotFoundException("ID does not exist!");
      } else {
         televisionRepository.deleteById(id);
         return ResponseEntity.ok("Television(id:" + id + ") has been deleted");
      }
   }
   
}
