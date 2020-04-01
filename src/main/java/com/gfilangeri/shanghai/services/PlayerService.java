package com.gfilangeri.shanghai.services;

import com.gfilangeri.shanghai.entities.Game;
import com.gfilangeri.shanghai.entities.Player;
import com.gfilangeri.shanghai.exceptions.RecordNotFoundException;
import com.gfilangeri.shanghai.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    private PlayerRepository playerRepository;
    private GameService gameService;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, GameService gameService) {
        this.playerRepository = playerRepository;
        this.gameService = gameService;
    }

    public List<Player> getPlayersInGame(Long gameId) {
        return playerRepository.findByGameId(gameId);
    }

    public void newPlayer(Player player) {
        Game game = gameService.getGame(player.getGameId());
        if (game != null && game.isOpen()) {
            playerRepository.save(player);
        } else {
            System.out.println("Cannot find an available game with id " + player.getGameId());
            throw new RecordNotFoundException("gameId '" + player.getGameId() + "' does not exist");
        }
    }

    public Player getPlayer(Long playerId) {
        Optional<Player> player = playerRepository.findById(playerId);
        if (player.isPresent()) {
            return player.get();
        } else {
            System.out.println("Could not find player with id " + playerId);
            throw new RecordNotFoundException("playerId '" + player + "' does not exist");
        }
    }
}
