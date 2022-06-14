package com.fmi.demo.infra.jpa;


import com.fmi.demo.domain.model.Campaign;
import com.fmi.demo.domain.repository.CampaignsRepository;
import com.fmi.demo.infra.jpa.mapper.CampaingJPAMapper;
import com.fmi.demo.infra.repository.jpa.CampaignJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;


@Transactional
@RequiredArgsConstructor
@Repository
public class CampaignsRepositoryImpl implements CampaignsRepository {

    private final CampaignJPARepository campaignJPARepository;
    private final CampaingJPAMapper campaingJPAMapper;

    @Override
    public String save(Campaign campaign) {

        CampaignJPA campaignJPA = campaingJPAMapper.toDto(campaign);

        if(StringUtils.hasText(campaign.getId())){
            campaignJPA.setId(campaign.getId());
        }
        return campaignJPARepository.save(campaignJPA).getId();
    }

    @Override
    public void delete(String id) {
        campaignJPARepository.delete(campaignJPARepository.getById(id));
    }

    @Override
    public Optional<Campaign> getById(String id) {

        Optional<CampaignJPA> campaignJPAOptional = campaignJPARepository.findById(id);

        if(campaignJPAOptional.isEmpty()){
            return Optional.empty();
        }

        else{
            return Optional.of(campaingJPAMapper.toDomain(campaignJPAOptional.get()));
        }
    }

    @Override
    public boolean existsById(String id) {

        Optional<CampaignJPA> campaignJPAOptional = campaignJPARepository.findById(id);

        if(campaignJPAOptional.isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public List<Campaign> getAll() {
     return  campaignJPARepository.findAll().stream().map(x->campaingJPAMapper.toDomain(x)).toList();
    }
}
