package com.gfilangeri.shanghai.services;

import com.gfilangeri.shanghai.entities.Game;
import com.gfilangeri.shanghai.exceptions.RecordNotFoundException;
import com.gfilangeri.shanghai.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    private GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game newGame(Game game) {
        gameRepository.save(game);
        return game;
    }

    public Game getGame(Long gameId) {
        Optional<Game> player = gameRepository.findById(gameId);
        if (player.isPresent()) {
            return player.get();
        } else {
            System.out.println("Could not find game with id " + gameId);
            throw new RecordNotFoundException("gameId '" + gameId + "' does not exist");
        }
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Game startGame(Long gameId) {
        Game game = getGame(gameId);
        game.setOpen(false);
        gameRepository.save(game);
        return game;
    }
}
