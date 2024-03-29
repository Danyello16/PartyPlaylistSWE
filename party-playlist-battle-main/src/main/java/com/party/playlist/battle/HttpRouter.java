package com.party.playlist.battle;

import com.party.playlist.battle.controller.GameController;
import com.party.playlist.battle.http.RequestContext;
import com.party.playlist.battle.controller.UserController;

public class HttpRouter {


    HttpRouter(RequestContext context) {

        if (context.getPath().contains("/users")) {
           new UserController(context);
        } else if (context.getPath().contains("/game")) {
            new GameController(context);
        }
    }


}
