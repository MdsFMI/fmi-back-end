package com.fmi.demo.domain.model;

import com.fmi.demo.infra.jpa.BasicEntityJPA;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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
