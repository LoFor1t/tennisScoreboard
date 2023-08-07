package com.LoFor1t.tennisScoreboard.DataModels;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerScore {
    private int score = 0;
    private int gameWins = 0;
    private int setWins = 0;
}
