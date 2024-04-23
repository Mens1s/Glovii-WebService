package com.groupseven.projectglovi.repositories;

import com.groupseven.projectglovi.entities.TournamentMatches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentMatchesRepository extends JpaRepository<TournamentMatches, Integer> {
}
