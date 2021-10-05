package com.viamarinha.telecom.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Status {

    @NonNull
    private int id;
    private boolean active;
    private boolean inService;
    private boolean functional;

}
