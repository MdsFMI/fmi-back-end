package com.fmi.demo.infra.jpa;

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
@Table(name = "requester")
@Entity(name = "Requester")
public class RequesterJPA extends BasicEntityJPA{

    @Column(name="email")
    private String email;

    @Column(name="name")
    private String name;

    @Column(name="birthday")
    private LocalDate birthday;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL , mappedBy ="requester")
    private Set<CampaignJPA> campaigns = new HashSet<>();


}
