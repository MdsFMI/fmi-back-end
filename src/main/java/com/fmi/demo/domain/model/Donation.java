package com.fmi.demo.domain.model;


import com.fmi.demo.infra.jpa.BasicEntityJPA;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Donation{

    private String id;
    private LocalDate dateOfDonation;
    private Double ammount;
    private String message;
    private boolean isAnnonymous;
}
