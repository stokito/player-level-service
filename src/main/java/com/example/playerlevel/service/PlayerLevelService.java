package com.example.playerlevel.service;

import com.example.playerlevel.LevelConfig;
import com.example.playerlevel.dto.Player;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PlayerLevelService {
    private final LevelConfig LevelConfig;

    private final ConcurrentHashMap<Integer, Player> players = new ConcurrentHashMap<>();

    public PlayerLevelService(LevelConfig LevelConfig) {
        this.LevelConfig = LevelConfig;
    }

    public Player getPlayer(int playerId) {
        return players.get(playerId);
    }

    /** Lookup  player by it's id and add experience points to him */
    public Player addExp(int playerId, int expPoints) {
        return players.compute(playerId, (integer, player) -> {
            if (player == null) {
                player = new Player(playerId);
            }
            player.setExp(player.getExp() + expPoints);
            player.setLevel(lookupLevel(player.getExp()));
            return player;
        });
    }

    /** Iterate over level config to determine the player's level based on it's experience  */
    int lookupLevel(int exp) {
        int level = 1;
        for (Map.Entry<Integer, Integer> levelEntry : LevelConfig.getLevels().entrySet()) {
            if (exp < levelEntry.getValue()) {
                return level;
            }
            level = levelEntry.getKey();
        }
        return level;
    }

    /** Reset players experience and level. Needed for test purposes */
    public Player resetPlayer(int playerId) {
        return players.compute(playerId, (integer, player) -> {
            if (player == null) {
                player = new Player(playerId);
            }
            player.setExp(0);
            player.setLevel(1);
            return player;
        });
    }


}
