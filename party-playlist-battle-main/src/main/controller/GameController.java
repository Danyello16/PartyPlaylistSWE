package com.party.playlist.battle.controller;








import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.party.playlist.battle.domain.BattleStatus;
import com.party.playlist.battle.http.RequestContext;
import com.party.playlist.battle.util.Constants;










public class GameController {
    private final RequestContext context;

    public GameController(RequestContext context) throws JsonProcessingException {
        this.context = context;
    }

																			/**
																	* user send request in battle ->  15sec tournament  -> online_user_show
																		*/





    public String mapHttpMethods() throws JsonProcessingException {
        String method = this.context.getMethod();
        if (method.equals(Constants.POST)) {
            if (context.getPath().contains("game/user/battle/request")) {
                playTournament();
                return "";
            }
        } else if (method.equals(Constants.GET)) {
            return "";
        }
        return "";
    }
	
	
	
	
	
	
	
	

    private BattleStatus playTournament() throws JsonProcessingException {
        JsonNode requestBody = context.getRequestBody();
        JsonNode actions = requestBody.get("actions");









        return BattleStatus.WIN;
    }
}
