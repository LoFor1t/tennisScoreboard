package com.LoFor1t.tennisScoreboard.Controllers;

import com.LoFor1t.tennisScoreboard.DataModels.Match;
import com.LoFor1t.tennisScoreboard.DataModels.Player;
import com.LoFor1t.tennisScoreboard.DataRepositories.PlayerRepository;
import com.LoFor1t.tennisScoreboard.Services.OngoingMatchesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/new-match")
public class NewMatchController {

    private final PlayerRepository playerRepository;

    public NewMatchController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping
    public String newMatchPage() {
        return "new-match";
    }

    @PostMapping
    public String createMatch(@RequestParam("player1") String player1Name, @RequestParam("player2") String player2Name) {
        if (!playerRepository.existsByName(player1Name)) {
            playerRepository.save(new Player(player1Name));
        }
        if (!playerRepository.existsByName(player2Name)) {
            playerRepository.save(new Player(player2Name));
        }

        Optional<Player> player1 = playerRepository.findByName(player1Name);
        Optional<Player> player2 = playerRepository.findByName(player2Name);

        Match newMatch = new Match(player1.get(), player2.get());
        UUID newMatchUUID = UUID.randomUUID();
        OngoingMatchesService.addMatch(newMatchUUID, newMatch);
        return "redirect:match-score?uuid=" + newMatchUUID;
    }
}
