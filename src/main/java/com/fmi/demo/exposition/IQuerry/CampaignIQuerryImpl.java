package com.fmi.demo.exposition.IQuerry;

import com.fmi.demo.domain.model.Campaign;
import com.fmi.demo.domain.repository.CampaignsRepository;
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
public class CampaignIQuerryImpl implements IQuerry<Campaign> {

    private final CampaignsRepository campaignsRepository;

    @Override
    public Campaign getById(String id){

        if(!StringUtils.hasText(id)){
            throw new CustomErrorHandler(ExceptionEnum.OBJECT_NOT_FOUND);
        }

        Optional<Campaign> campaignOptional = campaignsRepository.getById(id);
        if(campaignOptional.isEmpty()){
            throw new CustomErrorHandler(ExceptionEnum.OBJECT_NOT_FOUND);
        }
        else {
            return campaignOptional.get();
        }
    }

    @Override
    public List<Campaign> getAll() {
        return campaignsRepository.getAll();
    }
}
