package com.party.playlist.battle.domain;




public class Scoreboard {




    private User user;
    private String status;
    private Battle battle;

    public Scoreboard(User user, String status, Battle battle) {
        this.user = user;
        this.status = status;
        this.battle = battle;
    }


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }


    public Battle getGame() {
        return battle;
    }


    public void setGame(Battle battle) {
        this.battle = battle;
    }
}
