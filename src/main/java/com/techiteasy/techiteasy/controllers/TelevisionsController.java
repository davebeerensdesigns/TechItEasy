package com.techiteasy.techiteasy.controllers;

import com.techiteasy.techiteasy.Dtos.TelevisionDto;
import com.techiteasy.techiteasy.model.Television;
import com.techiteasy.techiteasy.services.TelevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class TelevisionsController {

   @Autowired
   private TelevisionService televisionService;

   /**
    * addTelevision
    * @param name name of television
    * @return Television
    */
   @GetMapping("/televisions")
   public ResponseEntity<Object> addTelevision(@RequestParam(name = "name", defaultValue = "") String name) {
      return ResponseEntity.ok(televisionService.getTelevisions(name)); // Jackson package - object => json
   }

   /**
    * getTelevision
    * @param id id of television
    * @return Television
    */
   @GetMapping("/televisions/{id}")
   public ResponseEntity<Object> getTelevision(@PathVariable long id) {
      return ResponseEntity.ok(televisionService.getTelevision(id)); // Jackson package - object => json
   }

   /**
    * addTelevision
    * @param television Television object
    * @return void
    */
   @PostMapping(value = "/televisions")
   public ResponseEntity<Object> addTelevision(@RequestBody TelevisionDto television){
      long newId = televisionService.addTelevision(television);

      URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newId).toUri();
      return ResponseEntity.created(location).build();
   }

   /**
    * updateTelevision
    * @param id id of television
    * @param television Television object
    * @return void
    */
   @PutMapping("/televisions/{id}")
   public ResponseEntity<Object> updateTelevision(@PathVariable long id, @RequestBody Television television) {
      televisionService.updateTelevision(id, television);
      return ResponseEntity.noContent().build();
   }

   /**
    * patchTelevision
    * @param id id of television
    * @param television Television object
    * @return void
    */
   @PatchMapping("/televisions/{id}")
   public ResponseEntity<Object> patchTelevision(@PathVariable long id, @RequestBody Television television) {
      televisionService.partialTelevision(id, television);
      return ResponseEntity.noContent().build();
   }

   /**
    * deleteTelevision
    * @param id id of television
    * @return void
    */
   @DeleteMapping("/televisions/{id}")
   public ResponseEntity<Object> deleteTelevision(@PathVariable long id) {
      televisionService.deleteTelevision(id);
      return ResponseEntity.noContent().build();
   }
   
}
