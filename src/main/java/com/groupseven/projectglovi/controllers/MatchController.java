package com.groupseven.projectglovi.controllers;

import com.groupseven.projectglovi.services.abstracts.MatchService;
import com.groupseven.projectglovi.services.dtos.requests.MatchAddRequest;
import com.groupseven.projectglovi.services.dtos.requests.MatchEndRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/match")
@Validated
@RequiredArgsConstructor
public class MatchController {
    private final MatchService matchService;

    @PostMapping("/start")
    public Integer startMatch(@RequestBody MatchAddRequest request){
        return matchService.add(request);
    }

    @PutMapping("/end")
    public void endMatch(@RequestBody MatchEndRequest request){
        matchService.end(request);
    }
}
