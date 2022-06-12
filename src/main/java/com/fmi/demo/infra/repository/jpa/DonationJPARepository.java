package com.fmi.demo.infra.repository.jpa;

import com.fmi.demo.infra.jpa.DonationJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationJPARepository extends JpaRepository<DonationJPA,String> {
}
