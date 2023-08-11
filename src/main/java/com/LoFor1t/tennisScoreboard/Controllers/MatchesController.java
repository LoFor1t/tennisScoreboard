package com.LoFor1t.tennisScoreboard.Controllers;

import com.LoFor1t.tennisScoreboard.DataModels.Match;
import com.LoFor1t.tennisScoreboard.DataRepositories.MatchRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/matches")
public class MatchesController {
    private final MatchRepository matchRepository;

    public MatchesController(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @GetMapping
    public String getMatches(ModelMap model) {
        Iterable<Match> allMatches = matchRepository.findAll();
        model.addAttribute("matches", allMatches);
        return "matches";
    }
}
