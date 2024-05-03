package com.groupseven.projectglovi.services.mapper;

import com.groupseven.projectglovi.entities.Ball;
import com.groupseven.projectglovi.services.dtos.requests.BallAddRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-03T03:30:10+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
@Component
public class BallMapperImpl implements BallMapper {

    @Override
    public Ball ballFromAddRequest(BallAddRequest request) {
        if ( request == null ) {
            return null;
        }

        Ball ball = new Ball();

        ball.setModel( request.getModel() );

        return ball;
    }
}
