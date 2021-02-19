package com.party.playlist.battle.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.party.playlist.battle.domain.User;
import com.party.playlist.battle.http.RequestContext;
import com.party.playlist.battle.util.Constants;
import com.party.playlist.battle.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserController {
    private final RequestContext context;
    private DatabaseConnection connection;

    public UserController(RequestContext context) {
        this.context = context;
    }

    private User mapHttpMethods() {
        String method = this.context.getMethod();
        if (method.equals(Constants.POST)) {
            if (context.getPath().contains("/user/auth")) {
                return authenticate();
            }
            return registerUser();
        }
        return new User();
    }

    private User authenticate() {

        try {

            JsonNode requestBody = context.getRequestBody();
            String username = requestBody.get("Username").asText();
            String password = requestBody.get("Password").asText();
            if (validation(username, password)) {
                User user = new User(username, password);
            }
            return new User();
        } catch (JsonProcessingException jsonProcessingException) {
            jsonProcessingException.printStackTrace();
        }
        return new User();
    }

    private boolean validation(String username, String password) {
        if (username == null || password == null || username.equals("") || password.equals("")) {
            return false;
        }
        return true;
    }

    private User registerUser() {
        try {
            JsonNode requestBody = context.getRequestBody();
            final Connection dbConnection = connection.createDbConnection();
            PreparedStatement statement = dbConnection.prepareStatement("INSERT INTO users (username,password) VALUES(?,?);");
            String username = requestBody.get("Username").asText();
            String password = requestBody.get("Password").asText();
            User user = new User(username, password);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            return new User();
        } catch (JsonProcessingException jsonProcessingException) {
            jsonProcessingException.printStackTrace();
            return new User();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new User();
    }


}
