package com.techiteasy.techiteasy.controllers;

import com.techiteasy.techiteasy.Dtos.TelevisionDto;
import com.techiteasy.techiteasy.Dtos.TelevisionInputDto;
import com.techiteasy.techiteasy.model.Television;
import com.techiteasy.techiteasy.services.TelevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TelevisionController {

   private TelevisionService televisionService;

   @Autowired
   public TelevisionController(TelevisionService televisionService) {
      this.televisionService = televisionService;
   }


   @GetMapping("/televisions")
   public List<TelevisionDto> getTelevisions() {

      return televisionService.getTelevisions();

   }


   @GetMapping("/televisions/{id}")
   public TelevisionDto getTelevision(@PathVariable("id") long id) {
      var television = televisionService.getTelevision(id);

      return TelevisionDto.fromTelevision(television);
   }

   @PostMapping("/televisions")
   public TelevisionDto addTelevision(@RequestBody TelevisionInputDto dto) {
      var television = televisionService.addTelevision(dto.toTelevision());
      return TelevisionDto.fromTelevision(television);
   }


   @DeleteMapping("/televisions/{id}")
   public void deleteTelevision(@PathVariable("id") Long id) {
      televisionService.deleteTelevision(id);
   }


   @PutMapping("televisions/{id}")
   public TelevisionDto updateTelevision(@PathVariable("id") Long id, @RequestBody Television television) {
      televisionService.updateTelevision(id, television);
      return TelevisionDto.fromTelevision(television);
   }


}
