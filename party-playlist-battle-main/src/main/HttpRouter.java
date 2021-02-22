package com.party.playlist.battle;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.party.playlist.battle.controller.GameController;
import com.party.playlist.battle.controller.UserController;
import com.party.playlist.battle.http.RequestContext;
import com.party.playlist.battle.http.ResponseHandler;








public class HttpRouter {
    private RequestContext context;
    HttpRouter(RequestContext context) {
        this.context = context;

    }

    public String router() {
        try {
			
			
			
            if (context.getPath().contains("/users")) {
                return new UserController(context).mapHttpMethods();
            } else if (context.getPath().contains("/game")) {
                return new GameController(context).mapHttpMethods();
            }
			
        } catch (JsonProcessingException jsonProcessingException) {
            return ResponseHandler.response("Server error", "500", "Server error");
        }
		
		
		
		
		
        return ResponseHandler.response("Server error", "500", "Server error");
    }


}
