package com.LoFor1t.tennisScoreboard.DataModels;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatchScore extends Match{
    private PlayerScore player1Score = new PlayerScore();
    private PlayerScore player2Score = new PlayerScore();

    public MatchScore(Player player1, Player player2) {
        super(player1, player2);
    }
}
