package com.party.playlist.battle.domain;




public class Battle {
  private Player player;
  private String status;

    public Battle() {
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
