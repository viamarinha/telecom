package com.viamarinha.telecom.models;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Onu {

    @NonNull
    private int id;
    @NonNull
    private int serialNumber;
    @NonNull
    private String shortName;
    @NonNull
    private int buildingId;
    private List<Connector> connectorList;


}
