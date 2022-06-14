package com.fmi.demo.domain.model;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Requester {

    private String id;
    private String email;
    private String name;
    private LocalDate birthday;


}
