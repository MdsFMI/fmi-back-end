package com.fmi.demo.domain.model;

import lombok.*;

import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Campaign {

    private String id;
    private String descritpion;
    private Double campaignGoal;
    private Double currentAmmount;
    private Requester requester;
    private Set<Donation> donations =new HashSet<>();


}
