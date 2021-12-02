package com.techiteasy.techiteasy.Dtos;

import com.techiteasy.techiteasy.model.WallBracket;

public class WallBracketInputDto {

    public String size;
    public Boolean adjustable;
    public String name;
    public Double price;

    public WallBracket toWallBracket() {

        var wallbracket = new WallBracket();

        wallbracket.setSize(size);
        wallbracket.setAdjustable(adjustable);
        wallbracket.setName(name);
        wallbracket.setPrice(price);

        return wallbracket;
    }
}