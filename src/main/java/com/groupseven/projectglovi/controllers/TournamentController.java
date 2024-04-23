package com.groupseven.projectglovi.controllers;

import com.groupseven.projectglovi.services.abstracts.MatchService;
import com.groupseven.projectglovi.services.abstracts.TournamentService;
import com.groupseven.projectglovi.services.dtos.requests.MatchAddRequest;
import com.groupseven.projectglovi.services.dtos.requests.MatchEndRequest;
import com.groupseven.projectglovi.services.dtos.requests.TournamentAddRequest;
import com.groupseven.projectglovi.services.dtos.responses.TournamentMatchGetResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tournament")
@Validated
@RequiredArgsConstructor
public class TournamentController {
    private final TournamentService tournamentService;

    @PostMapping("/start")
    public List<TournamentMatchGetResponse> startTournament(@RequestBody TournamentAddRequest request){
        return tournamentService.create(request);
    }


}
