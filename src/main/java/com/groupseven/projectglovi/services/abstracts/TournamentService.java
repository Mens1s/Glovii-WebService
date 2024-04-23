package com.groupseven.projectglovi.services.abstracts;

import com.groupseven.projectglovi.services.dtos.requests.TournamentAddRequest;
import com.groupseven.projectglovi.services.dtos.responses.TournamentMatchGetResponse;

import java.util.List;

public interface TournamentService {
    List<TournamentMatchGetResponse> create(TournamentAddRequest request);
}
