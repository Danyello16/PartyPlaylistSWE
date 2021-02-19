package com.party.playlist.battle.controller;

import com.party.playlist.battle.http.RequestContext;
import com.party.playlist.battle.util.Constants;

public class GameController {
    private final RequestContext context;

    public GameController(RequestContext context) {
        this.context = context;
        mapHttpMethods();
    }

    /**
     * user send request in battle ->  15sec tournament  -> online_user_show
     *
     */

    private void mapHttpMethods() {
        String method = this.context.getMethod();
        if (method.equals(Constants.POST)) {
            if (context.getPath().contains("game/user/battle")) {
            }
        } else if (method.equals(Constants.GET)) {

        }

    }
}
