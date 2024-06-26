package com.groupseven.projectglovi.services.concretes;

import com.groupseven.projectglovi.entities.Tournament;
import com.groupseven.projectglovi.enums.EnumGameType;
import com.groupseven.projectglovi.repositories.TournamentRepository;
import com.groupseven.projectglovi.services.abstracts.TournamentMatchService;
import com.groupseven.projectglovi.services.abstracts.TournamentService;
import com.groupseven.projectglovi.services.dtos.requests.TournamentAddRequest;
import com.groupseven.projectglovi.services.dtos.requests.TournamentMatchAddRequest;
import com.groupseven.projectglovi.services.dtos.responses.MatchGetResponse;
import com.groupseven.projectglovi.services.dtos.responses.TournamentMatchGetResponse;
import com.groupseven.projectglovi.services.mapper.TournamentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TournamentServiceImpl implements TournamentService {
    private final TournamentRepository tournamentRepository;
    private final TournamentMatchService tournamentMatchService;

    @Override
    public List<TournamentMatchGetResponse> create(TournamentAddRequest request) {
        Tournament tournament = TournamentMapper.INSTANCE.tournamentFromTournamentAddRequest(request);

        tournament = tournamentRepository.save(tournament);
        List<TournamentMatchGetResponse> result = new ArrayList<>();
        int order = 0;

        for(int index = 0; index < request.getListOfPlayerIds().size()-1; index++){
            for(int innerIndex = index+1; innerIndex < request.getListOfPlayerIds().size(); innerIndex++){
                result.add(tournamentMatchService.add(createRequest(
                        request.getListOfPlayerIds().get(index),
                        request.getListOfPlayerIds().get(innerIndex),
                        request.getGameType(),
                        request.getName(),
                        tournament.getId(),
                        order)));
                order++;
            }
        }

        return result;
    }

    private TournamentMatchAddRequest createRequest(Integer firstPlayerId,
                                                    Integer secondPlayerId,
                                                    EnumGameType gameType,
                                                    String name,
                                                    Integer tournamentId,
                                                    Integer matchOrder){

        TournamentMatchAddRequest tournamentMatchAddRequest = new TournamentMatchAddRequest();
        tournamentMatchAddRequest.setFirstPlayerId(firstPlayerId);
        tournamentMatchAddRequest.setSecondPlayerId(secondPlayerId);
        tournamentMatchAddRequest.setWinnerPlayerId(secondPlayerId); // TODO solve it
        tournamentMatchAddRequest.setGameType(gameType);
        tournamentMatchAddRequest.setName(name);
        tournamentMatchAddRequest.setTournamentId(tournamentId);
        tournamentMatchAddRequest.setMatchOrder(matchOrder);

        return tournamentMatchAddRequest;
    }
}
