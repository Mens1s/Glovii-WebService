package com.groupseven.projectglovi.services.mapper;

import com.groupseven.projectglovi.entities.Racket;
import com.groupseven.projectglovi.services.dtos.requests.RacketAddRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-03T03:30:10+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
@Component
public class RacketMapperImpl implements RacketMapper {

    @Override
    public Racket racketFromAddRequest(RacketAddRequest request) {
        if ( request == null ) {
            return null;
        }

        Racket racket = new Racket();

        racket.setModel( request.getModel() );

        return racket;
    }
}
