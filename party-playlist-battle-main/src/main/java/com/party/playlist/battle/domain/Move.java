package com.party.playlist.battle.domain;

public enum Move {

    ROCK {
        @Override
        public boolean beats(Move other) {
            return other == SCISSOR;
        }
    },
    PAPER {
        @Override
        public boolean beats(Move other) {
            return other == ROCK;
        }
    },
    SCISSOR {
        @Override
        public boolean beats(Move other) {
            return other == PAPER;
        }
    },

    LIZARD {
        @Override
        public boolean beats(Move other) {
            return other == LIZARD;
        }
    },

     SPOCK {
        @Override
        public boolean beats(Move other) {
            return other == SPOCK;
        }
    };

    public static Move parseMove(String value) {
        String move = value.trim().toLowerCase();
        switch (move) {
            case "rock":
                return ROCK;
            case "paper":
                return PAPER;
            case "scissor":
                return SCISSOR;
            case "spock":
                return SPOCK;
            case "lizard":
                return LIZARD;
            default:
                return null;
        }
    }

    public abstract boolean beats(Move other);

    public static Boolean validMove(String move) {
        return move != null && Move.parseMove(move) != null;
    }
}