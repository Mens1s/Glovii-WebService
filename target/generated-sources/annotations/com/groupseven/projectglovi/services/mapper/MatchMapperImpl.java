package com.groupseven.projectglovi.services.mapper;

import com.groupseven.projectglovi.entities.Match;
import com.groupseven.projectglovi.entities.User;
import com.groupseven.projectglovi.services.dtos.requests.MatchAddRequest;
import com.groupseven.projectglovi.services.dtos.responses.MatchGetResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-03T03:00:51+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
@Component
public class MatchMapperImpl implements MatchMapper {

    @Override
    public Match matchFromMatchAddRequest(MatchAddRequest request) {
        if ( request == null ) {
            return null;
        }

        Match match = new Match();

        match.setFirstPlayer( matchAddRequestToUser( request ) );
        match.setSecondPlayer( matchAddRequestToUser1( request ) );
        match.setWinnerPlayer( matchAddRequestToUser2( request ) );
        match.setGameType( request.getGameType() );
        match.setGameStatus( request.getGameStatus() );
        match.setStartTime( request.getStartTime() );
        match.setEndTime( request.getEndTime() );

        return match;
    }

    @Override
    public MatchGetResponse matchGetResponseFromMatch(Match match) {
        if ( match == null ) {
            return null;
        }

        MatchGetResponse matchGetResponse = new MatchGetResponse();

        matchGetResponse.setFirstPlayer( match.getFirstPlayer() );
        matchGetResponse.setSecondPlayer( match.getSecondPlayer() );
        matchGetResponse.setWinnerPlayer( match.getWinnerPlayer() );
        matchGetResponse.setGameType( match.getGameType() );
        matchGetResponse.setGameStatus( match.getGameStatus() );
        matchGetResponse.setStartTime( match.getStartTime() );
        matchGetResponse.setEndTime( match.getEndTime() );

        return matchGetResponse;
    }

    protected User matchAddRequestToUser(MatchAddRequest matchAddRequest) {
        if ( matchAddRequest == null ) {
            return null;
        }

        User user = new User();

        user.setId( matchAddRequest.getFirstPlayerId() );

        return user;
    }

    protected User matchAddRequestToUser1(MatchAddRequest matchAddRequest) {
        if ( matchAddRequest == null ) {
            return null;
        }

        User user = new User();

        user.setId( matchAddRequest.getSecondPlayerId() );

        return user;
    }

    protected User matchAddRequestToUser2(MatchAddRequest matchAddRequest) {
        if ( matchAddRequest == null ) {
            return null;
        }

        User user = new User();

        user.setId( matchAddRequest.getWinnerPlayerId() );

        return user;
    }
}
