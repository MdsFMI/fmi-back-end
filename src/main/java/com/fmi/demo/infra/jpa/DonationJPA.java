package com.fmi.demo.infra.jpa;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity(name="Donation")
@Table(name="donation")
public class DonationJPA extends BasicEntityJPA{

    @Column(name="date_of_donation")
    private LocalDate dateOfDonation;

    @Column(name="ammount")
    private Double ammount;

    @Column(name="message")
    private String message;

    @Column(name = "is_annonymous")
    private boolean isAnnonymous;

    @ManyToOne
    @JoinColumn(name = "campaign_id")
    private CampaignJPA campaign;
}
