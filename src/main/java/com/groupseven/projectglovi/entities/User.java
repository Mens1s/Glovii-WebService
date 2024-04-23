package com.groupseven.projectglovi.entities;

import com.groupseven.projectglovi.core.entities.BaseEntity;
import com.groupseven.projectglovi.enums.EnumGender;
import com.groupseven.projectglovi.enums.EnumRole;
import com.groupseven.projectglovi.enums.EnumUserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Table(name="users")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity implements UserDetails {
    @Column(name="username", nullable = false)
    private String username;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="avatar")
    private String avatar = "default.jpg";

    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;

    @Column(name="gender")
    @Enumerated(EnumType.STRING)
    private EnumGender gender;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private EnumUserStatus status;

    @Column(name="role")
    @Enumerated(EnumType.STRING)
    private EnumRole role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="rank_id", referencedColumnName = "id")
    private Rank rank;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "user_car",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="car_id")
    )
    private Set<Car> cars;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "user_racket",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="racket_id")
    )
    private Set<Racket> rackets;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "user_ball",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="ball_id")
    )
    private Set<Ball> balls;

    @OneToMany(mappedBy = "firstPlayer", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Match> matchesAsFirstPlayer;

    @OneToMany(mappedBy = "secondPlayer", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Match> matchesAsSecondPlayer;

    @OneToMany(mappedBy = "winnerPlayer", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Match> matchesAsWinnerPlayer;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
