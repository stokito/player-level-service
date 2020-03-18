package com.example.playerlevel.dto;

public class Player {
    private int id;
    /** Initial level for a new player is 1 */
    private int level = 1;
    /** Experience in points */
    private int exp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public Player(int id) {
        this.id = id;
    }

}
