package com.groupseven.projectglovi.services.mapper;

import com.groupseven.projectglovi.entities.Ball;
import com.groupseven.projectglovi.entities.Car;
import com.groupseven.projectglovi.entities.Racket;
import com.groupseven.projectglovi.entities.User;
import com.groupseven.projectglovi.services.dtos.requests.UserRegisterRequest;
import com.groupseven.projectglovi.services.dtos.responses.UserGetResponse;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-03T03:30:10+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User userFromRegisterRequest(UserRegisterRequest request) {
        if ( request == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( request.getUsername() );
        user.setFirstName( request.getFirstName() );
        user.setLastName( request.getLastName() );
        user.setEmail( request.getEmail() );
        user.setPassword( request.getPassword() );
        user.setGender( request.getGender() );
        user.setStatus( request.getStatus() );
        user.setCars( mapCarIdsToCars( request.getCars() ) );
        user.setRackets( mapRacketIdsToRackets( request.getRackets() ) );
        user.setBalls( mapBallIdsToBalls( request.getBalls() ) );

        user.setCountry( mapCountryIdToCountry(request.getCountryId()) );

        return user;
    }

    @Override
    public UserGetResponse userGetResponseFromUser(User user) {
        if ( user == null ) {
            return null;
        }

        UserGetResponse userGetResponse = new UserGetResponse();

        if ( user.getId() != null ) {
            userGetResponse.setId( user.getId().longValue() );
        }
        userGetResponse.setUsername( user.getUsername() );
        userGetResponse.setFirstName( user.getFirstName() );
        userGetResponse.setLastName( user.getLastName() );
        userGetResponse.setEmail( user.getEmail() );
        userGetResponse.setCountry( user.getCountry() );
        userGetResponse.setGender( user.getGender() );
        userGetResponse.setStatus( user.getStatus() );
        Set<Car> set = user.getCars();
        if ( set != null ) {
            userGetResponse.setCars( new LinkedHashSet<Car>( set ) );
        }
        Set<Racket> set1 = user.getRackets();
        if ( set1 != null ) {
            userGetResponse.setRackets( new LinkedHashSet<Racket>( set1 ) );
        }
        Set<Ball> set2 = user.getBalls();
        if ( set2 != null ) {
            userGetResponse.setBalls( new LinkedHashSet<Ball>( set2 ) );
        }

        return userGetResponse;
    }
}
