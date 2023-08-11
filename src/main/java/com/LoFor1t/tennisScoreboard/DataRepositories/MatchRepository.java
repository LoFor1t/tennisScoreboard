package com.LoFor1t.tennisScoreboard.DataRepositories;

import com.LoFor1t.tennisScoreboard.DataModels.Match;
import com.LoFor1t.tennisScoreboard.DataModels.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends CrudRepository<Match, Long> {
    Iterable<Match> findAllByPlayer1OrPlayer2(Player player1, Player player2);
}
