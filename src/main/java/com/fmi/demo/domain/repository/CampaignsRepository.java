package com.fmi.demo.domain.repository;

import com.fmi.demo.domain.model.Campaign;

import java.util.Optional;

public interface CampaignsRepository {

    String save(Campaign campaign);

    void delete(String id);

    Optional<Campaign> getById(String id);

    boolean existsById(String id);
}
