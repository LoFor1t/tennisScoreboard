package com.LoFor1t.tennisScoreboard.Services;

import com.LoFor1t.tennisScoreboard.DataModels.Match;
import com.LoFor1t.tennisScoreboard.DataModels.Player;
import com.LoFor1t.tennisScoreboard.DataRepositories.MatchRepository;

import java.util.UUID;

public class FinishedMatchService {
    private final MatchRepository matchRepository;

    public FinishedMatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Match saveMatchInDB(UUID matchID, Match match, Player winner) {
        OngoingMatchesService.deleteMatch(matchID);
        match.setWinner(winner);
        matchRepository.save(match);
        return match;
    }
}
