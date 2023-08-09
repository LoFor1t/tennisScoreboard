package com.LoFor1t.tennisScoreboard.Controllers;

import com.LoFor1t.tennisScoreboard.DataModels.Match;
import com.LoFor1t.tennisScoreboard.DataModels.MatchScore;
import com.LoFor1t.tennisScoreboard.DataRepositories.MatchRepository;
import com.LoFor1t.tennisScoreboard.Services.MatchScoreCalculationService;
import com.LoFor1t.tennisScoreboard.Services.OngoingMatchesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequestMapping("/match-score")
public class MatchScoreController {
    private final MatchRepository matchRepository;

    public MatchScoreController(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @GetMapping
    public String matchScorePage(@RequestParam("uuid") String uuid,  ModelMap model) {
        model.addAttribute("match", OngoingMatchesService.getMatchScoreById(UUID.fromString(uuid)));
        return "match-score";
    }

    @PostMapping
    public String addScoreToPlayer(@RequestParam("player") String player, @RequestParam("uuid") String uuid, ModelMap model) {
        MatchScore matchScore = OngoingMatchesService.getMatchScoreById(UUID.fromString(uuid));
        if (player.equals("player-1-win")) {
            new MatchScoreCalculationService(matchScore.getPlayer1Score(), matchScore.getPlayer2Score(), matchScore).addScore();
            if (matchScore.getPlayer1Score().getSetWins() == 2) {
                OngoingMatchesService.deleteMatch(UUID.fromString(uuid));
                Match match = new Match(matchScore.getPlayer1(), matchScore.getPlayer2(), matchScore.getPlayer1());
                matchRepository.save(match);
                model.addAttribute("match", match);
                return "final-score";
            }
        } else {
            new MatchScoreCalculationService(matchScore.getPlayer2Score(), matchScore.getPlayer1Score(), matchScore).addScore();
            if (matchScore.getPlayer2Score().getSetWins() == 2) {
                OngoingMatchesService.deleteMatch(UUID.fromString(uuid));
                Match match = new Match(matchScore.getPlayer1(), matchScore.getPlayer2(), matchScore.getPlayer2());
                matchRepository.save(match);
                model.addAttribute("match", match);
                return "final-score";
            }
        }
        model.addAttribute("match", matchScore);
        return "match-score";
    }
}
