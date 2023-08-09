package com.LoFor1t.tennisScoreboard.Services;

import com.LoFor1t.tennisScoreboard.DataModels.PlayerScore;

public class MatchScoreCalculationService {
    public static void addScore(PlayerScore playerScore) {
        switch (playerScore.getScore()) {
            case 0 -> playerScore.setScore(15);
            case 15 -> playerScore.setScore(30);
            case 30 -> playerScore.setScore(40);
            case 40 -> {
                playerScore.setScore(0);
                playerScore.setGameWins(playerScore.getGameWins() + 1);
            }
        }
    }
}
