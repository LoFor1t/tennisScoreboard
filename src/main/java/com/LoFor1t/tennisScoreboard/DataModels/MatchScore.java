package com.LoFor1t.tennisScoreboard.DataModels;

public class MatchScore extends Match{
    private int player1SetScore;
    private int player2SetScore;
    private int player1SetWins;
    private int player2SetWins;
    public MatchScore(Player player1, Player player2) {
        super(player1, player2);
    }
}
