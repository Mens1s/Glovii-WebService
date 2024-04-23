package com.groupseven.projectglovi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="tournament_matches")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TournamentMatches extends Match{
    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name="tournament_id")
    private Tournament tournament;

    @Column(name = "match_order")
    private Integer matchOrder;
}
