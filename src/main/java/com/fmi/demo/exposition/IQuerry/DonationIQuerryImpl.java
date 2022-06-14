package com.fmi.demo.exposition.IQuerry;

import com.fmi.demo.domain.model.Donation;
import com.fmi.demo.domain.repository.DonationsRepository;
import com.fmi.demo.exposition.exceptions.CustomErrorHandler;
import com.fmi.demo.exposition.exceptions.ExceptionEnum;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class DonationIQuerryImpl implements IQuerry<Donation>{

    private final DonationsRepository donationsRepository;

    @Override
    public Donation getById(String id){

        if(!StringUtils.hasText(id)){
            throw new CustomErrorHandler(ExceptionEnum.OBJECT_NOT_FOUND);
        }

        Optional<Donation> donationOptional = donationsRepository.getById(id);
        if(donationOptional.isEmpty()){
            throw new CustomErrorHandler(ExceptionEnum.OBJECT_NOT_FOUND);
        }
        else {
            return donationOptional.get();
        }
    }

    @Override
    public List<Donation> getAll() {
        return null;
    }
}
