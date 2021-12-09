package com.techiteasy.techiteasy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "wallbracket")
public class WallBracket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String size;
    private Boolean adjustable;
    private String name;
    private Double price;

    @OneToMany(mappedBy = "television")
    @JsonIgnore
    List<TelevisionWallbracket> televisionWallbrackets;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getAdjustable() {
        return adjustable;
    }

    public void setAdjustable(Boolean adjustable) {
        this.adjustable = adjustable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<TelevisionWallbracket> getTelevisionWallbrackets() {
        return televisionWallbrackets;
    }
    public void setTelevisionWallbrackets(List<TelevisionWallbracket> televisionWallbrackets) {
        this.televisionWallbrackets = televisionWallbrackets;
    }
}