package com.groupseven.projectglovi.services.concretes;

import com.groupseven.projectglovi.core.exception.types.BusinessException;
import com.groupseven.projectglovi.entities.Match;
import com.groupseven.projectglovi.entities.User;
import com.groupseven.projectglovi.repositories.MatchRepository;
import com.groupseven.projectglovi.services.abstracts.MatchService;
import com.groupseven.projectglovi.services.dtos.requests.MatchAddRequest;
import com.groupseven.projectglovi.services.dtos.requests.MatchEndRequest;
import com.groupseven.projectglovi.services.mapper.MatchMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MatchServiceImpl implements MatchService {
    private final MatchRepository matchRepository;
    @Override
    public Integer add(MatchAddRequest request) {
        Match match = MatchMapper.INSTANCE.matchFromMatchAddRequest(request);
        matchRepository.save(match);
        return match.getId();
    }

    @Override
    public void end(MatchEndRequest request) {
        Optional<Match> optMatch = matchRepository.findById(request.getMatchId());

        if(optMatch.isEmpty())
            throw new BusinessException("No match found given id!"); // TODO add rules

        Match match = optMatch.get();
        User user = new User();
        user.setId(request.getWinnerPlayerId());

        match.setStartTime(request.getStartTime());
        match.setEndTime(request.getEndTime());
        match.setWinnerPlayer(user);

        matchRepository.save(match);
    }


}
