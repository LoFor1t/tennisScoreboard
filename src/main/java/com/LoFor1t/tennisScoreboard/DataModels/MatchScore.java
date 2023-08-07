package com.LoFor1t.tennisScoreboard.DataModels;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatchScore extends Match{
    private PlayerScore player1Score;
    private PlayerScore player2Score;

    public MatchScore(Player player1, Player player2) {
        super(player1, player2);
    }
}
