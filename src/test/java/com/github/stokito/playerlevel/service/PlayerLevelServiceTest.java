package com.github.stokito.playerlevel.service;

import com.github.stokito.playerlevel.LevelConfig;
import com.github.stokito.playerlevel.dto.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;

class PlayerLevelServiceTest {
    private PlayerLevelService playerLevelService;

    @BeforeEach
    void setUp() {
        LevelConfig levelConfig = new LevelConfig();
        LinkedHashMap<Integer, Integer> levels = new LinkedHashMap<>(11);
        levels.put(1, 0);
        levels.put(10, 100);
        levels.put(20, 110);
        levels.put(30, 120);
        levels.put(40, 150);
        levels.put(50, 190);
        levels.put(60, 240);
        levels.put(70, 300);
        levels.put(80, 370);
        levels.put(90, 450);
        levels.put(100, 540);
        levelConfig.setLevels(levels);
        playerLevelService = new PlayerLevelService(levelConfig);
    }

    @Test
    void addExp() {
        playerLevelService.addExp(1, 1);
        assertLevel(1, 1);
        playerLevelService.addExp(1, 99);
        assertLevel(10, 100);
        playerLevelService.addExp(1, 440);
        assertLevel(100, 540);
    }

    private void assertLevel(int level, int exp) {
        Player player = playerLevelService.getPlayer(1);
        assertEquals(1, player.getId());
        assertEquals(level, player.getLevel());
        assertEquals(exp, player.getExp());
    }

    @Test
    void lookupLevel() {
        assertEquals(1, playerLevelService.lookupLevel(0));
        assertEquals(1, playerLevelService.lookupLevel(1));
        assertEquals(1, playerLevelService.lookupLevel(99));
        assertEquals(10, playerLevelService.lookupLevel(100), "Switch to next level");
        assertEquals(90, playerLevelService.lookupLevel(450));
        assertEquals(100, playerLevelService.lookupLevel(540), "Switch to last level");
        assertEquals(100, playerLevelService.lookupLevel(Integer.MAX_VALUE));
    }
}