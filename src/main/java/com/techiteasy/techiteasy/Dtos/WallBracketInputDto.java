package com.techiteasy.techiteasy.Dtos;

import com.techiteasy.techiteasy.model.WallBracket;

public class WallBracketInputDto {

    public String size;
    public Boolean adjustable;
    public String name;
    public Double price;

    public WallBracket toWallBracket() {

        var wallBracket = new WallBracket();

        wallBracket.setSize(size);
        wallBracket.setAdjustable(adjustable);
        wallBracket.setName(name);
        wallBracket.setPrice(price);

        return wallBracket;
    }
}