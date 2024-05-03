package com.groupseven.projectglovi.services.mapper;

import com.groupseven.projectglovi.entities.Country;
import com.groupseven.projectglovi.services.dtos.requests.CountryAddRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-03T03:00:51+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
@Component
public class CountryMapperImpl implements CountryMapper {

    @Override
    public Country countryFromAddRequest(CountryAddRequest request) {
        if ( request == null ) {
            return null;
        }

        Country country = new Country();

        country.setName( request.getName() );

        return country;
    }
}
