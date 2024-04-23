package com.groupseven.projectglovi.services.abstracts;

import com.groupseven.projectglovi.services.dtos.requests.MatchAddRequest;
import com.groupseven.projectglovi.services.dtos.requests.MatchEndRequest;

public interface MatchService {
    Integer add(MatchAddRequest request);
    void end(MatchEndRequest request);
}
