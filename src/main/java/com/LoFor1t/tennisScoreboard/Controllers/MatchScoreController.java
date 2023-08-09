package com.LoFor1t.tennisScoreboard.Controllers;

import com.LoFor1t.tennisScoreboard.DataModels.MatchScore;
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
    @GetMapping
    public String matchScorePage(@RequestParam("uuid") String uuid,  ModelMap model) {
        model.addAttribute("match", OngoingMatchesService.getMatchScoreById(UUID.fromString(uuid)));
        return "match-score";
    }

    @PostMapping
    public String addScoreToPlayer(@RequestParam("player") String player, @RequestParam("uuid") String uuid, ModelMap model) {
        MatchScore matchScore = OngoingMatchesService.getMatchScoreById(UUID.fromString(uuid));
        if (player.equals("player-1-win")) {
            MatchScoreCalculationService.addScore(matchScore.getPlayer1Score());
        } else {
            MatchScoreCalculationService.addScore(matchScore.getPlayer2Score());
        }
        model.addAttribute("match", matchScore);
        return "match-score";
    }
}
