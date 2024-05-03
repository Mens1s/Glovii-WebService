package com.groupseven.projectglovi.services.mapper;

import com.groupseven.projectglovi.entities.Car;
import com.groupseven.projectglovi.services.dtos.requests.CarAddRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-03T03:30:09+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
@Component
public class CarMapperImpl implements CarMapper {

    @Override
    public Car carFromAddRequest(CarAddRequest request) {
        if ( request == null ) {
            return null;
        }

        Car car = new Car();

        car.setModel( request.getModel() );

        return car;
    }
}
