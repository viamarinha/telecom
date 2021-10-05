package com.viamarinha.telecom.models;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

public class Building {

    @NonNull
    private int id;
    @NonNull
    private String shortName;
    @NonNull
    private int adressId;
    private List<Onu> onuList;
}
