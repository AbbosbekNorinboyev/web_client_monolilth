package uz.brb.webclientmonolith.entity;

import lombok.Data;

@Data
public class GeoEntity {
    private Long id;
    private String lat;
    private String lng;
}