package com.LoFor1t.tennisScoreboard.Controllers;

import com.LoFor1t.tennisScoreboard.DataModels.Match;
import com.LoFor1t.tennisScoreboard.DataModels.Player;
import com.LoFor1t.tennisScoreboard.DataRepositories.MatchRepository;
import com.LoFor1t.tennisScoreboard.DataRepositories.PlayerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/matches")
public class MatchesController {
    private final MatchRepository matchRepository;
    private final PlayerRepository playerRepository;

    public MatchesController(MatchRepository matchRepository, PlayerRepository playerRepository) {
        this.matchRepository = matchRepository;
        this.playerRepository = playerRepository;
    }

    @GetMapping
    public String getMatches(ModelMap model, @RequestParam(value = "filter_by_player_name", required = false) String playerName) {
        Iterable<Match> allMatches;
        if (playerName == null || playerName.isEmpty()) {
            allMatches = matchRepository.findAll();
            model.addAttribute("matches", allMatches);
        } else {
            Optional<Player> player = playerRepository.findByName(playerName);
            if (player.isPresent()) {
                allMatches = matchRepository.findAllByPlayer1OrPlayer2(player.get(), player.get());
                model.addAttribute("matches", allMatches);
            }
        }
        return "matches";
    }
}
