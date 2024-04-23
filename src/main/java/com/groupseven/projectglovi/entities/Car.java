package com.groupseven.projectglovi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

@Table(name="cars")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car extends BaseEntity {

    @ManyToMany(mappedBy = "cars")
    @JsonIgnore
    private Set<User> user;

    @Column(name = "model", nullable = false)
    private String model;
}
