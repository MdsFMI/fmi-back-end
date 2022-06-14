package com.fmi.demo.domain.repository;

import com.fmi.demo.domain.model.Donation;

import java.util.Optional;

public interface DonationsRepository {

    String save(Donation donation);

    void delete(String id);

    Optional<Donation> getById(String id);

    boolean existsById(String id);
}


