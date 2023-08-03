package com.LoFor1t.tennisScoreboard.DataRepositories;

import com.LoFor1t.tennisScoreboard.DataModels.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
}
