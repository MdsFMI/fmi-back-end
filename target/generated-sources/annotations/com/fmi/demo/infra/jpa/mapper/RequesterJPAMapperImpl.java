package com.fmi.demo.infra.jpa.mapper;

import com.fmi.demo.domain.model.Requester;
import com.fmi.demo.infra.jpa.RequesterJPA;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-12T15:27:16+0300",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class RequesterJPAMapperImpl implements RequesterJPAMapper {

    @Override
    public RequesterJPA toDto(Requester domain) {
        if ( domain == null ) {
            return null;
        }

        RequesterJPA.RequesterJPABuilder requesterJPA = RequesterJPA.builder();

        requesterJPA.email( domain.getEmail() );
        requesterJPA.name( domain.getName() );
        requesterJPA.birthday( domain.getBirthday() );

        return requesterJPA.build();
    }

    @Override
    public Requester toDomain(RequesterJPA dto) {
        if ( dto == null ) {
            return null;
        }

        Requester.RequesterBuilder requester = Requester.builder();

        requester.id( dto.getId() );
        requester.email( dto.getEmail() );
        requester.name( dto.getName() );
        requester.birthday( dto.getBirthday() );

        return requester.build();
    }
}
