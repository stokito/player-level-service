package com.example.playerlevel.controller;

import com.example.playerlevel.dto.Player;
import com.example.playerlevel.service.PlayerLevelService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerLevelController {
    private final PlayerLevelService playerLevelService;

    public PlayerLevelController(PlayerLevelService playerLevelService) {
        this.playerLevelService = playerLevelService;
    }

    @PostMapping("{playerId}")
    public Player add(@PathVariable int playerId, int expPoints) {
        return playerLevelService.addExp(playerId, expPoints);
    }


    @GetMapping("{playerId}")
    public Player get(@PathVariable int playerId) {
        return playerLevelService.getPlayer(playerId);
    }

    @DeleteMapping("{playerId}")
    public Player reset(@PathVariable int playerId) {
        return playerLevelService.resetPlayer(playerId);
    }

}
