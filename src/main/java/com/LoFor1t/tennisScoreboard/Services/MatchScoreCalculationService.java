package com.LoFor1t.tennisScoreboard.Services;

import com.LoFor1t.tennisScoreboard.DataModels.MatchScore;
import com.LoFor1t.tennisScoreboard.DataModels.MatchStatus;
import com.LoFor1t.tennisScoreboard.DataModels.PlayerScore;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MatchScoreCalculationService {
    private PlayerScore winnerPlayerScore;
    private PlayerScore loserPlayerScore;
    private MatchScore matchScore;

    public void addScore() {
        if (matchScore.getMatchStatus() == MatchStatus.Going) {
            switch (winnerPlayerScore.getScore()) {
                case 0 -> winnerPlayerScore.setScore(15);
                case 15 -> winnerPlayerScore.setScore(30);
                case 30 -> winnerPlayerScore.setScore(40);
                case 40 -> addGameWins();
            }
        } else {
            winnerPlayerScore.setScore(winnerPlayerScore.getScore() + 1);
            if (winnerPlayerScore.getScore() - loserPlayerScore.getScore() >= 2) {
                if (matchScore.getMatchStatus() == MatchStatus.MoreLess) {
                    addGameWins();
                } else if (matchScore.getMatchStatus() == MatchStatus.TieBrake && winnerPlayerScore.getScore() >= 7) {
                    addSetWins();
                }
            }
        }
    }

    public void addGameWins() {
        if (winnerPlayerScore.getScore() == 40 && loserPlayerScore.getScore() == 40 && matchScore.getMatchStatus() == MatchStatus.Going) {
            matchScore.setMatchStatus(MatchStatus.MoreLess);
            winnerPlayerScore.setScore(1);
            loserPlayerScore.setScore(0);
        } else if (matchScore.getMatchStatus() == MatchStatus.MoreLess) {
            matchScore.setMatchStatus(MatchStatus.Going);
            addGameWinAndResetScore();
        } else {
            addGameWinAndResetScore();
        }
    }

    public void addGameWinAndResetScore() {
        winnerPlayerScore.setGameWins(winnerPlayerScore.getGameWins() + 1);
        winnerPlayerScore.setScore(0);
        loserPlayerScore.setScore(0);
        addSetWins();
    }

    public void addSetWins() {
        if (winnerPlayerScore.getGameWins() - loserPlayerScore.getGameWins() >= 2 && winnerPlayerScore.getGameWins() >= 6) {
            winnerPlayerScore.setGameWins(0);
            loserPlayerScore.setGameWins(0);
            winnerPlayerScore.setSetWins(winnerPlayerScore.getSetWins() + 1);
        } else if (winnerPlayerScore.getGameWins() == 6 && loserPlayerScore.getGameWins() == 6 && matchScore.getMatchStatus() == MatchStatus.Going) {
            matchScore.setMatchStatus(MatchStatus.TieBrake);
        } else if (matchScore.getMatchStatus() == MatchStatus.TieBrake) {
            matchScore.setMatchStatus(MatchStatus.Going);
            addSetWinAndReset();
        }
    }

    public void addSetWinAndReset() {
        winnerPlayerScore.setGameWins(winnerPlayerScore.getGameWins() + 1);
        winnerPlayerScore.setScore(0);
        loserPlayerScore.setScore(0);
        winnerPlayerScore.setGameWins(0);
        loserPlayerScore.setGameWins(0);
        winnerPlayerScore.setSetWins(winnerPlayerScore.getGameWins() + 1);
    }
}
