package com.viamarinha.telecom.models;


import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor

@ToString

public class Region {

    @NonNull
    private int id;
    @NonNull
    private String code;
    @NonNull
    private String shortName;
    @NonNull
    private int cityId;

    @Singular
    private List<Address> addressees;

}