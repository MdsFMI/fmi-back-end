package com.fmi.demo.infra.repository.jpa;

import com.fmi.demo.infra.jpa.RequesterJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequesterJPARepository extends JpaRepository<RequesterJPA,String>
{
}
