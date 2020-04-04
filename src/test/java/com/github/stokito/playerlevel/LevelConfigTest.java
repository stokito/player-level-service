package com.github.stokito.playerlevel;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;

class LevelConfigTest {
    @Test
    void setLevels() {
        LevelConfig levelConfig = new LevelConfig();
        LinkedHashMap<Integer, Integer> levels = new LinkedHashMap<>(2);
        levels.put(1, 0);
        levels.put(10, 100);
        levelConfig.setLevels(levels);
    }

    @Test
    void setLevelsWrongOrder() {
        LevelConfig levelConfig = new LevelConfig();
        LinkedHashMap<Integer, Integer> levels = new LinkedHashMap<>(2);
        levels.put(10, 0);
        levels.put(1, 100);

        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> levelConfig.setLevels(levels));
        assertEquals("Incorrect level order 1: previous level is 10", thrown.getMessage());
    }

    @Test
    void setLevelsWrongOrderExp() {
        LevelConfig levelConfig = new LevelConfig();
        LinkedHashMap<Integer, Integer> levels = new LinkedHashMap<>(2);
        levels.put(1, 100);
        levels.put(10, 0);

        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> levelConfig.setLevels(levels));
        assertEquals("Incorrect level experience for 10: exp is 0, previous level exp is 100", thrown.getMessage());
    }
}