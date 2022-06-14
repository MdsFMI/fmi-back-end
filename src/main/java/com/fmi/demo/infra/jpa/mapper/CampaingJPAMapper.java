package com.fmi.demo.infra.jpa.mapper;

import com.fmi.demo.domain.model.Campaign;
import com.fmi.demo.infra.jpa.CampaignJPA;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        uses={
                RequesterJPAMapper.class
        }
)
public interface CampaingJPAMapper extends GenericMapper<Campaign, CampaignJPA>{
}
