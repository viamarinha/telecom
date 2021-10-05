package com.viamarinha.telecom.models;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@ToString
public class Address {

    @NonNull
    private int id;
    @NonNull
    private String country;
    @NonNull
    private int  regionId;
    @NonNull
    private String province;
    @NonNull
    private String street;
    @NonNull
    private String civicNumber;

}
