package com.groupseven.projectglovi.services.mapper;

import com.groupseven.projectglovi.entities.Tournament;
import com.groupseven.projectglovi.services.dtos.requests.TournamentAddRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-03T03:00:51+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
@Component
public class TournamentMapperImpl implements TournamentMapper {

    @Override
    public Tournament tournamentFromTournamentAddRequest(TournamentAddRequest request) {
        if ( request == null ) {
            return null;
        }

        Tournament tournament = new Tournament();

        tournament.setName( request.getName() );
        tournament.setStartDate( request.getStartDate() );
        tournament.setEndDate( request.getEndDate() );
        tournament.setGameType( request.getGameType() );
        tournament.setGameStatus( request.getGameStatus() );

        return tournament;
    }
}
