package com.fmi.demo.infra.jpa.mapper;

import com.fmi.demo.domain.model.Donation;
import com.fmi.demo.infra.jpa.DonationJPA;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-13T22:19:12+0300",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class DonationJPAMapperImpl implements DonationJPAMapper {

    @Override
    public DonationJPA toDto(Donation domain) {
        if ( domain == null ) {
            return null;
        }

        DonationJPA.DonationJPABuilder donationJPA = DonationJPA.builder();

        donationJPA.dateOfDonation( domain.getDateOfDonation() );
        donationJPA.ammount( domain.getAmmount() );
        donationJPA.message( domain.getMessage() );

        return donationJPA.build();
    }

    @Override
    public Donation toDomain(DonationJPA dto) {
        if ( dto == null ) {
            return null;
        }

        Donation.DonationBuilder donation = Donation.builder();

        donation.id( dto.getId() );
        donation.dateOfDonation( dto.getDateOfDonation() );
        donation.ammount( dto.getAmmount() );
        donation.message( dto.getMessage() );

        return donation.build();
    }
}
