package com.techiteasy.techiteasy.controllers;

import com.techiteasy.techiteasy.Dtos.WallBracketDto;
import com.techiteasy.techiteasy.Dtos.WallBracketInputDto;
import com.techiteasy.techiteasy.model.WallBracket;
import com.techiteasy.techiteasy.services.WallBracketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WallBracketController {

    private WallBracketService wallbracketService;

    @Autowired
    public WallBracketController(WallBracketService wallbracketService) {
        this.wallbracketService = wallbracketService;
    }


    @GetMapping("/wallbrackets")
    public List<WallBracketDto> getWallBrackets() {

        return wallbracketService.getWallBrackets();

    }


    @GetMapping("/wallbrackets/{id}")
    public WallBracketDto getWallBracket(@PathVariable("id") long id) {
        var wallbracket = wallbracketService.getWallBracket(id);

        return WallBracketDto.fromWallBracket(wallbracket);
    }

    @PostMapping("/wallbrackets")
    public WallBracketDto addWallBracket(@RequestBody WallBracketInputDto dto) {
        var wallbracket = wallbracketService.addWallBracket(dto.toWallBracket());
        return WallBracketDto.fromWallBracket(wallbracket);
    }


    @DeleteMapping("/wallbrackets/{id}")
    public void deleteWallBracket(@PathVariable("id") Long id) {
        wallbracketService.deleteWallBracket(id);
    }


    @PutMapping("wallbrackets/{id}")
    public WallBracketDto updateWallBracket(@PathVariable("id") Long id, @RequestBody WallBracket wallbracket) {
        wallbracketService.updateWallBracket(id, wallbracket);
        return WallBracketDto.fromWallBracket(wallbracket);
    }


}
