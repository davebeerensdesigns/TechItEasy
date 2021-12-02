package com.techiteasy.techiteasy.Dtos;

import com.techiteasy.techiteasy.model.WallBracket;

public class WallBracketDto {

    public long id;
    public String size;
    public Boolean adjustable;
    public String name;
    public Double price;

    public static WallBracketDto fromWallBracket(WallBracket wallbracket) {

        var dto = new WallBracketDto();

        dto.id = wallbracket.getId();
        dto.size = wallbracket.getSize();
        dto.adjustable = wallbracket.getAdjustable();
        dto.name = wallbracket.getName();
        dto.price = wallbracket.getPrice();

        return dto;
    }

}
