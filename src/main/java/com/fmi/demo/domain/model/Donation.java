package com.fmi.demo.domain.model;


import lombok.*;


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
    private Campaign campaign;
}
