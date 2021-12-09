package com.techiteasy.techiteasy.Dtos;

import com.techiteasy.techiteasy.model.WallBracket;

public class WallBracketDto {

    public long id;
    public String size;
    public Boolean adjustable;
    public String name;
    public Double price;

    public static WallBracketDto fromWallBracket(WallBracket wallBracket) {

        var dto = new WallBracketDto();

        dto.id = wallBracket.getId();
        dto.size = wallBracket.getSize();
        dto.adjustable = wallBracket.getAdjustable();
        dto.name = wallBracket.getName();
        dto.price = wallBracket.getPrice();

        return dto;
    }

}
