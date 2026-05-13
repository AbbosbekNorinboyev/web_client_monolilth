package uz.brb.webclientmonolith.entity;

import lombok.Data;

@Data
public class CompanyEntity {
    private Long id;
    private String name;
    private String catchPhrase;
    private String bs;
}