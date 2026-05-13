package uz.brb.webclientmonolith.entity;

import lombok.Data;

@Data
public class AddressEntity {
    private Long id;
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoEntity geo;
}