package com.fmi.demo.infra.jpa.mapper;

import com.fmi.demo.domain.model.Donation;
import com.fmi.demo.infra.jpa.DonationJPA;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        uses = {
                CampaingJPAMapper.class
        }
)
public interface DonationJPAMapper extends GenericMapper<Donation, DonationJPA> {
}
