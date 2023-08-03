package com.LoFor1t.tennisScoreboard.DataModels;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "players")
@Getter
@Setter
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
}
