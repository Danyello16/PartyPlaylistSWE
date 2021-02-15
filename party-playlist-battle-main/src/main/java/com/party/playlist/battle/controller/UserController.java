package com.party.playlist.battle.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.party.playlist.battle.http.RequestContext;
import com.party.playlist.battle.util.Constants;

public class UserController {
    private final RequestContext context;

    public UserController(RequestContext context) {
        this.context = context;
        mapHttpMethods();
    }

    private void mapHttpMethods() {
        String method = this.context.getMethod();
        if (method.equals(Constants.POST)) {
            registerUser();
        }

    }

    private void registerUser() {

        try {

            JsonNode requestBody = context.getRequestBody();

        } catch (JsonProcessingException jsonProcessingException) {
            jsonProcessingException.printStackTrace();
        }
    }


}
