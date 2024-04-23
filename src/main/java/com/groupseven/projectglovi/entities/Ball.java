package com.groupseven.projectglovi.entities;

import com.groupseven.projectglovi.core.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Table(name="balls")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ball extends BaseEntity {
    @ManyToMany(mappedBy = "balls")
    private Set<User> user;

    @Column(name = "model")
    private String model;
}