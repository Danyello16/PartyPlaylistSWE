package com.party.playlist.battle.domain;

import java.util.ArrayList;

public class Library {

    private ArrayList<MultiMediaContent> multiMediaContents;
    private User user;

    public Library(ArrayList<MultiMediaContent> multiMediaContents, User user) {
        this.multiMediaContents = multiMediaContents;
        this.user = user;
    }


    public  void add(MultiMediaContent multiMediaContent){

    }

    public void remove(MultiMediaContent multiMediaContent){

    }

}
