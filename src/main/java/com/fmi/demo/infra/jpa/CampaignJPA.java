package com.fmi.demo.infra.jpa;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity(name = "Campaign")
@Table(name = "campaign")
public class CampaignJPA extends BasicEntityJPA{


    @Column(name = "description")
    private String descritpion;

    @Column(name = "campaing_goal")
    private Double campaignGoal;

    @Column(name = "current_ammount")
    private Double currentAmmount;

    @ManyToOne
    @JoinColumn(name ="requester_id")
    private RequesterJPA requester;

    @OneToMany(mappedBy = "campaign" , cascade = CascadeType.ALL , orphanRemoval = true)
    private Set<DonationJPA> donations =new HashSet<>();


}
