package uz.brb.webclientmonolith.entity;

import lombok.Data;

@Data
public class UserEntity {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
    private AddressEntity address;
    private CompanyEntity company;
}