package com.fmi.demo.infra.jpa;

import com.fmi.demo.domain.model.Donation;
import com.fmi.demo.domain.repository.DonationsRepository;
import com.fmi.demo.infra.jpa.mapper.DonationJPAMapper;
import com.fmi.demo.infra.repository.jpa.DonationJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Optional;


@Transactional
@RequiredArgsConstructor
@Repository
public class DonationsRepositoryImpl implements DonationsRepository {

    private final DonationJPARepository donationJPARepository;

    private final DonationJPAMapper donationJPAMapper;

    @Override
    public String save(Donation donation){

        DonationJPA donationJPA = donationJPAMapper.toDto(donation);

        if(StringUtils.hasText(donation.getId())){
            donationJPA.setId(donation.getId());
        }
        return donationJPARepository.save(donationJPA).getId();
    }

    @Override
    public void delete(String id){
        donationJPARepository.delete(donationJPARepository.getById(id));
    }

    @Override
    public Optional<Donation> getById(String id){

        Optional<DonationJPA> donationJPAOptional = donationJPARepository.findById(id);

        if(donationJPAOptional.isEmpty()){
            return Optional.empty();
        }

        else{
            return Optional.of(donationJPAMapper.toDomain(donationJPAOptional.get()));
        }
    }

    @Override
    public boolean existsById(String id){

        Optional<DonationJPA> donationJPAOptional = donationJPARepository.findById(id);

        if(donationJPAOptional.isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }
}
