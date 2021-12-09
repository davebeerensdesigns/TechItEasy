package com.techiteasy.techiteasy.controllers;

import com.techiteasy.techiteasy.Dtos.IdInputDto;
import com.techiteasy.techiteasy.Dtos.TelevisionDto;
import com.techiteasy.techiteasy.Dtos.TelevisionInputDto;
import com.techiteasy.techiteasy.exceptions.BadRequestException;
import com.techiteasy.techiteasy.model.Television;
import com.techiteasy.techiteasy.model.WallBracket;
import com.techiteasy.techiteasy.services.TelevisionService;
import com.techiteasy.techiteasy.services.TelevisionWallBracketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@RestController
public class TelevisionController {

   private TelevisionService televisionService;
   private TelevisionWallBracketService televisionWallBracketService;

   @Autowired
   public TelevisionController(TelevisionService televisionService, TelevisionWallBracketService televisionWallBracketService) {
      this.televisionService = televisionService;
      this.televisionWallBracketService = televisionWallBracketService;
   }


   @GetMapping("/televisions")
   public List<TelevisionDto> getTelevisions(@RequestParam(value = "brand", required = false) String brand) {

      var dtos = new ArrayList<TelevisionDto>();

      List<Television> televisions;

      if(brand != null ){
         televisions = televisionService.getTelevisionsByBrand(brand);
      } else if (brand == null) {
         televisions = televisionService.getTelevisions();
      } else {
         throw new BadRequestException();
      }

      for (Television television : televisions){
         dtos.add(TelevisionDto.fromTelevision(television));
      }

      return dtos;

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

   @PutMapping("televisions/{id}/remotecontroller")
   public void assignRemoteControllerToTelevision(@PathVariable("id") Long id, @RequestBody IdInputDto input) {
      televisionService.assignRemoteControllerToTelevision(id, input.id);
   }

   @PutMapping("televisions/{id}/{ciModuleId}")
   public void assignCIModuleToTelevision(@PathVariable("id") Long id, @PathVariable("ciModuleId") Long ciModuleId) {
      televisionService.assignCIModuleToTelevision(id, ciModuleId);
   }

   @GetMapping("/televisions/wallbrackets/{televisionId}")
   public Collection<WallBracket> getWallBracketsByTelevisionId(@PathVariable("televisionId") Long televisionId){
      return televisionWallBracketService.getTelevisionWallBracketByTelevisionId(televisionId);
   }


}
