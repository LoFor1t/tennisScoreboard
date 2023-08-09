package com.LoFor1t.tennisScoreboard.Services;

import com.LoFor1t.tennisScoreboard.DataModels.Match;
import com.LoFor1t.tennisScoreboard.DataModels.MatchScore;
import lombok.Getter;

import java.util.HashMap;
import java.util.UUID;

@Getter
public class OngoingMatchesService {
    private static HashMap<UUID, MatchScore> currentMatches = new HashMap<>();

    public static void addMatch(UUID id, Match match) {
        currentMatches.put(id, new MatchScore(match.getPlayer1(), match.getPlayer2()));
    }

    public static void deleteMatch(UUID id) {
        currentMatches.remove(id);
    }

    public static MatchScore getMatchScoreById(UUID id) {
        return currentMatches.get(id);
    }
}
