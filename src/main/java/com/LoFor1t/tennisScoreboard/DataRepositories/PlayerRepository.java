package com.LoFor1t.tennisScoreboard.DataRepositories;

import com.LoFor1t.tennisScoreboard.DataModels.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
    boolean existsByName(String name);
    Optional<Player> findByName(String name);
}
