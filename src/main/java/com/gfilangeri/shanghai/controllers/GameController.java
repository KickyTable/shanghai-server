package com.gfilangeri.shanghai.controllers;

import com.gfilangeri.shanghai.entities.Game;
import com.gfilangeri.shanghai.entities.Player;
import com.gfilangeri.shanghai.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class GameController {
    private GameService gameService;
    private PlayerController playerController;

    @Autowired
    public GameController(GameService gameService, PlayerController playerController) {
        this.gameService = gameService;
        this.playerController = playerController;
    }


    @PostMapping(value = "/game")
    public Game newGame(@RequestBody Player player) {
        Game newGame = gameService.newGame(new Game());
        player.setGameId(newGame.getId());
        playerController.newPlayer(player);
        return newGame;
    }

    @GetMapping(value = "/game/{gameId}")
    public Game getGame(@PathVariable("gameId") Long gameId) {
        return gameService.getGame(gameId);
    }

    @GetMapping(value = "/games")
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @PutMapping(value = "/game/{gameId}")
    public Game startGame(@PathVariable("gameId") Long gameId) {
        return gameService.startGame(gameId);
    }
}
