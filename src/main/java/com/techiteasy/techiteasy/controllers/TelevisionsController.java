package com.techiteasy.techiteasy.controllers;

import com.techiteasy.techiteasy.exceptions.RecordIsEmptyException;
import com.techiteasy.techiteasy.exceptions.RecordNotFoundException;
import com.techiteasy.techiteasy.model.Television;
import com.techiteasy.techiteasy.repository.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

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
      return ResponseEntity.ok(televisionRepository.findAll()); // Jackson package - object => json
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
   public ResponseEntity<Object> updateTelevision(@PathVariable int id,
                                                  @RequestBody String name) {
      if (id < televisions.size()) {
         // get item by id and update the item
         televisions.set(id, name);
         return ResponseEntity.noContent().build();
      } else {
         throw new RecordNotFoundException("ID not found!");
      }
   }
   
   
   // DELETE
   @DeleteMapping("/televisions/{id}")
   public ResponseEntity<Object> deleteTelevision(@PathVariable int id) {
      
      if (id < televisions.size()) {
         // delete item by id
         televisions.remove(id);
         return ResponseEntity.ok(televisions);
      } else {
         throw new RecordNotFoundException("ID not found!");
      }
   }
   
}
