package com.fmi.demo.infra.repository.jpa;

import com.fmi.demo.infra.jpa.CampaignJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignJPARepository extends JpaRepository<CampaignJPA,String> {
}
