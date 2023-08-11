package com.LoFor1t.tennisScoreboard;

import com.LoFor1t.tennisScoreboard.DataModels.MatchScore;
import com.LoFor1t.tennisScoreboard.DataModels.MatchStatus;
import com.LoFor1t.tennisScoreboard.DataModels.PlayerScore;
import com.LoFor1t.tennisScoreboard.Services.MatchScoreCalculationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MatchScoreTest {
    PlayerScore firstPlayerScore;
    PlayerScore secondPlayerScore;
    MatchScore matchScore;
    MatchScoreCalculationService matchScoreCalculationService;
    @BeforeEach
    public void init() {
        firstPlayerScore = new PlayerScore();
        secondPlayerScore = new PlayerScore();
        matchScore = new MatchScore();
        matchScoreCalculationService = new MatchScoreCalculationService(firstPlayerScore, secondPlayerScore, matchScore);
    }

    @Test
    public void moreLess() {
        firstPlayerScore.setScore(40);
        secondPlayerScore.setScore(40);
        matchScoreCalculationService.addScore();
        Assertions.assertEquals(MatchStatus.MoreLess, matchScore.getMatchStatus());
    }

    @Test
    public void gameWin() {
        firstPlayerScore.setScore(40);
        matchScoreCalculationService.addScore();
        Assertions.assertEquals(1, firstPlayerScore.getGameWins());
    }

    @Test
    public void tieBrake() {
        firstPlayerScore.setGameWins(5);
        secondPlayerScore.setGameWins(6);
        firstPlayerScore.setScore(40);
        matchScoreCalculationService.addScore();
        Assertions.assertEquals(MatchStatus.TieBrake, matchScore.getMatchStatus());
    }
}
