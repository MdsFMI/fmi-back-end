package com.fmi.demo.exposition.ICommand;

import com.fmi.demo.domain.model.Donation;
import com.fmi.demo.domain.repository.DonationsRepository;
import com.fmi.demo.exposition.exceptions.CustomErrorHandler;
import com.fmi.demo.exposition.exceptions.ExceptionEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class DonationIcommandImpl implements ICommand<Donation>{

    private final DonationsRepository donationsRepository;

    @Override
    public String save(Donation body){
        fieldVerification(body);

        return donationsRepository.save(body);
    }

    @Override
    public String update(Donation body, String id){

        if(!StringUtils.hasText(id) ||
            !StringUtils.hasText(body.getId()) ||
            !body.getId().equals(id)){
            throw new CustomErrorHandler(ExceptionEnum.INVALID_FIELD);
        }
        fieldVerification(body);

        return donationsRepository.save(body);
    }

    @Override
    public void delete(String id){
        if(!StringUtils.hasText(id)){
            throw new CustomErrorHandler(ExceptionEnum.OBJECT_NOT_FOUND);
        }
        donationsRepository.delete(id);
    }

    public void fieldVerification(Donation body){

        if(ObjectUtils.isEmpty(body.getAmmount())
                || !StringUtils.hasText(body.getMessage()) || !StringUtils.hasText(body.getCampaign().getId())){
            throw new CustomErrorHandler(ExceptionEnum.EMPTY_FIELD);
        }
    }
}
