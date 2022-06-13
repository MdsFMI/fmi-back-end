package com.fmi.demo.exposition.ICommand;

import com.fmi.demo.domain.model.Campaign;
import com.fmi.demo.domain.repository.CampaignsRepository;
import com.fmi.demo.exposition.exceptions.CustomErrorHandler;
import com.fmi.demo.exposition.exceptions.ExceptionEnum;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomMapEditor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CampaignIcommandImpl implements ICommand<Campaign> {

    private final CampaignsRepository campaignsRepository;

    @Override
    public String save(Campaign body){
        fieldVerification(body);

        return campaignsRepository.save(body);
    }

    @Override
    public String update(Campaign body, String id){

        if(!StringUtils.hasText(id) ||
            !StringUtils.hasText(body.getId()) ||
            !body.getId().equals(id)){
            throw  new CustomErrorHandler(ExceptionEnum.INVALID_FIELD);
        }
        fieldVerification(body);

        return campaignsRepository.save(body);
    }

    @Override
    public void delete(String id){
        if(!StringUtils.hasText(id)){
            throw new CustomErrorHandler(ExceptionEnum.OBJECT_NOT_FOUND);
        }
        campaignsRepository.delete(id);
    }

    //TODO: Vezi pe ce campuri mai faci verificarea
    public void fieldVerification(Campaign body){

        if(!StringUtils.hasText(body.getDescritpion())
            || ObjectUtils.isEmpty(body.getCampaignGoal()))
        {
            throw new CustomErrorHandler(ExceptionEnum.EMPTY_FIELD);
        }
    }

}
