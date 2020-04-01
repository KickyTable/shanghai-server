package com.gfilangeri.shanghai.controllers;

import com.gfilangeri.shanghai.entities.Player;
import com.gfilangeri.shanghai.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PlayerController {
    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping(value = "/players/{gameId}")
    public List<Player> getPlayersInGame(@PathVariable("gameId") Long gameId) {
        return playerService.getPlayersInGame(gameId);
    }

    @PostMapping(value = "/player")
    public void newPlayer(@RequestBody Player player) {

        playerService.newPlayer(player);
    }

    @GetMapping(value = "player/{playerId}")
    public Player getPlayer(@PathVariable("playerId") Long playerId) {
        return playerService.getPlayer(playerId);
    }
}
