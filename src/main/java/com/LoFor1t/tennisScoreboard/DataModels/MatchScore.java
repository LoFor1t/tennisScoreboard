package com.LoFor1t.tennisScoreboard.DataModels;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatchScore extends Match{
    private int player1Score;
    private int player2Score;
    private int player1GameWins;
    private int player2GameWins;
    private int player1SetWins;
    private int player2SetWins;

    public MatchScore(Player player1, Player player2) {
        super(player1, player2);
    }
}
