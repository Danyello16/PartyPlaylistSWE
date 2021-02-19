package com.party.playlist.battle.domain;

import java.util.List;

public class Player {
    private  User playerName;
    private List<Move> playerMove;


    public Player(User playerName, List<Move> playerMove) {
        this.playerName = playerName;
        this.playerMove = playerMove;
    }

    public User getPlayerName() {
        return playerName;
    }

    public void setPlayerName(User playerName) {
        this.playerName = playerName;
    }

    public List<Move> getPlayerMove() {
        return playerMove;
    }

    public void setPlayerMove(List<Move> playerMove) {
        this.playerMove = playerMove;
    }
}

