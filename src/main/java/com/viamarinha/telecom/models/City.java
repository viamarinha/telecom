package com.viamarinha.telecom.models;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(access = AccessLevel.PUBLIC)
@ToString
@RequiredArgsConstructor
public  class City {

    @NonNull
    private int id;
    @NonNull
    private String code;
    @Singular("regions")
    private List<Region> regions;
}
