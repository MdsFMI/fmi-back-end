package com.fmi.demo.infra.jpa.mapper;

import com.fmi.demo.domain.model.Campaign;
import com.fmi.demo.domain.model.Donation;
import com.fmi.demo.infra.jpa.CampaignJPA;
import com.fmi.demo.infra.jpa.DonationJPA;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-12T20:19:36+0300",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class CampaingJPAMapperImpl implements CampaingJPAMapper {

    @Autowired
    private DonationJPAMapper donationJPAMapper;
    @Autowired
    private RequesterJPAMapper requesterJPAMapper;

    @Override
    public CampaignJPA toDto(Campaign domain) {
        if ( domain == null ) {
            return null;
        }

        CampaignJPA.CampaignJPABuilder campaignJPA = CampaignJPA.builder();

        campaignJPA.descritpion( domain.getDescritpion() );
        campaignJPA.campaignGoal( domain.getCampaignGoal() );
        campaignJPA.currentAmmount( domain.getCurrentAmmount() );
        campaignJPA.requester( requesterJPAMapper.toDto( domain.getRequester() ) );
        campaignJPA.donations( donationSetToDonationJPASet( domain.getDonations() ) );

        return campaignJPA.build();
    }

    @Override
    public Campaign toDomain(CampaignJPA dto) {
        if ( dto == null ) {
            return null;
        }

        Campaign.CampaignBuilder campaign = Campaign.builder();

        campaign.id( dto.getId() );
        campaign.descritpion( dto.getDescritpion() );
        campaign.campaignGoal( dto.getCampaignGoal() );
        campaign.currentAmmount( dto.getCurrentAmmount() );
        campaign.requester( requesterJPAMapper.toDomain( dto.getRequester() ) );
        campaign.donations( donationJPASetToDonationSet( dto.getDonations() ) );

        return campaign.build();
    }

    protected Set<DonationJPA> donationSetToDonationJPASet(Set<Donation> set) {
        if ( set == null ) {
            return null;
        }

        Set<DonationJPA> set1 = new LinkedHashSet<DonationJPA>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Donation donation : set ) {
            set1.add( donationJPAMapper.toDto( donation ) );
        }

        return set1;
    }

    protected Set<Donation> donationJPASetToDonationSet(Set<DonationJPA> set) {
        if ( set == null ) {
            return null;
        }

        Set<Donation> set1 = new LinkedHashSet<Donation>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( DonationJPA donationJPA : set ) {
            set1.add( donationJPAMapper.toDomain( donationJPA ) );
        }

        return set1;
    }
}
