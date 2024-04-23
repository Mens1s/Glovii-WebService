package com.groupseven.projectglovi.entities;

import com.groupseven.projectglovi.core.entities.BaseEntity;
import com.groupseven.projectglovi.enums.EnumGameType;
import com.groupseven.projectglovi.enums.EnumGameStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Table(name="tournaments")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tournament extends BaseEntity {
    @Column(name="name")
    private String name;

    @Column(name="start_date")
    private LocalDateTime startDate;

    @Column(name="end_date")
    private LocalDateTime endDate;

    @Column(name="game_type")
    @Enumerated(EnumType.STRING)
    private EnumGameType gameType;

    @Column(name="game_status")
    @Enumerated(EnumType.STRING)
    private EnumGameStatus gameStatus;

    @OneToMany(mappedBy="tournament")
    private Set<TournamentMatches> matches;
}
