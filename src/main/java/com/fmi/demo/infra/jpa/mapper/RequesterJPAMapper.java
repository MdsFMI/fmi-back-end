package com.fmi.demo.infra.jpa.mapper;

import com.fmi.demo.domain.model.Requester;
import com.fmi.demo.infra.jpa.RequesterJPA;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        uses = {

        }
)
public interface RequesterJPAMapper extends GenericMapper<Requester, RequesterJPA> {
}
