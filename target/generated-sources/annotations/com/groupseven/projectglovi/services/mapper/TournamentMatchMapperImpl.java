package com.groupseven.projectglovi.services.mapper;

import com.groupseven.projectglovi.entities.Tournament;
import com.groupseven.projectglovi.entities.TournamentMatch;
import com.groupseven.projectglovi.entities.User;
import com.groupseven.projectglovi.services.dtos.requests.TournamentMatchAddRequest;
import com.groupseven.projectglovi.services.dtos.responses.TournamentMatchGetResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-03T03:00:51+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
@Component
public class TournamentMatchMapperImpl implements TournamentMatchMapper {

    @Override
    public TournamentMatch matchFromTournamentMatchAddRequest(TournamentMatchAddRequest request) {
        if ( request == null ) {
            return null;
        }

        TournamentMatch tournamentMatch = new TournamentMatch();

        tournamentMatch.setFirstPlayer( tournamentMatchAddRequestToUser( request ) );
        tournamentMatch.setSecondPlayer( tournamentMatchAddRequestToUser1( request ) );
        tournamentMatch.setWinnerPlayer( tournamentMatchAddRequestToUser2( request ) );
        tournamentMatch.setTournament( tournamentMatchAddRequestToTournament( request ) );
        tournamentMatch.setGameType( request.getGameType() );
        tournamentMatch.setGameStatus( request.getGameStatus() );
        tournamentMatch.setStartTime( request.getStartTime() );
        tournamentMatch.setEndTime( request.getEndTime() );
        tournamentMatch.setName( request.getName() );
        tournamentMatch.setMatchOrder( request.getMatchOrder() );

        return tournamentMatch;
    }

    @Override
    public TournamentMatchGetResponse tournamentMatchGetResponseFromTournamentMatch(TournamentMatch match) {
        if ( match == null ) {
            return null;
        }

        TournamentMatchGetResponse tournamentMatchGetResponse = new TournamentMatchGetResponse();

        tournamentMatchGetResponse.setFirstPlayer( match.getFirstPlayer() );
        tournamentMatchGetResponse.setSecondPlayer( match.getSecondPlayer() );
        tournamentMatchGetResponse.setWinnerPlayer( match.getWinnerPlayer() );
        tournamentMatchGetResponse.setGameType( match.getGameType() );
        tournamentMatchGetResponse.setName( match.getName() );
        tournamentMatchGetResponse.setMatchOrder( match.getMatchOrder() );
        tournamentMatchGetResponse.setGameStatus( match.getGameStatus() );
        tournamentMatchGetResponse.setStartTime( match.getStartTime() );
        tournamentMatchGetResponse.setEndTime( match.getEndTime() );

        return tournamentMatchGetResponse;
    }

    protected User tournamentMatchAddRequestToUser(TournamentMatchAddRequest tournamentMatchAddRequest) {
        if ( tournamentMatchAddRequest == null ) {
            return null;
        }

        User user = new User();

        user.setId( tournamentMatchAddRequest.getFirstPlayerId() );

        return user;
    }

    protected User tournamentMatchAddRequestToUser1(TournamentMatchAddRequest tournamentMatchAddRequest) {
        if ( tournamentMatchAddRequest == null ) {
            return null;
        }

        User user = new User();

        user.setId( tournamentMatchAddRequest.getSecondPlayerId() );

        return user;
    }

    protected User tournamentMatchAddRequestToUser2(TournamentMatchAddRequest tournamentMatchAddRequest) {
        if ( tournamentMatchAddRequest == null ) {
            return null;
        }

        User user = new User();

        user.setId( tournamentMatchAddRequest.getWinnerPlayerId() );

        return user;
    }

    protected Tournament tournamentMatchAddRequestToTournament(TournamentMatchAddRequest tournamentMatchAddRequest) {
        if ( tournamentMatchAddRequest == null ) {
            return null;
        }

        Tournament tournament = new Tournament();

        tournament.setId( tournamentMatchAddRequest.getTournamentId() );

        return tournament;
    }
}
