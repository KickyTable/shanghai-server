package com.gfilangeri.shanghai.repositories;

import com.gfilangeri.shanghai.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
