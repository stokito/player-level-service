package com.example.playerlevel;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.LinkedHashMap;
import java.util.Map;

@ConfigurationProperties("player")
public class LevelConfig {
    private LinkedHashMap<Integer, Integer> levels = new LinkedHashMap<>();

    public LinkedHashMap<Integer, Integer> getLevels() {
        return levels;
    }

    public void setLevels(LinkedHashMap<Integer, Integer> levels) {
        validateLevelMap(levels);
        this.levels = levels;
    }

    private void validateLevelMap(LinkedHashMap<Integer, Integer> levels) {
        Integer prevLevelNumber = -1;
        Integer prevLevelExp = -1;
        for (Map.Entry<Integer, Integer> levelEntry:  levels.entrySet()) {
            if (levelEntry.getKey() <= prevLevelNumber) {
                throw new IllegalStateException("Incorrect level order " + levelEntry.getKey() + ": previous level is " + prevLevelNumber);
            }
            if (levelEntry.getValue() <= prevLevelExp) {
                throw new IllegalStateException("Incorrect level experience for " + levelEntry.getKey()  + ": exp is " + levelEntry.getValue() + ", previous level exp is " + prevLevelExp);
            }
            prevLevelNumber = levelEntry.getKey();
            prevLevelExp = levelEntry.getValue();
        }
    }

}
