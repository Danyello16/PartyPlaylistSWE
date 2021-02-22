package com.party.playlist.battle.service;


import com.fasterxml.jackson.databind.JsonNode;
import com.party.playlist.battle.domain.User;
import com.party.playlist.battle.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;




public class UserService {

    public User authenticate(JsonNode requestBody) {
        String username = requestBody.get("Username").asText();
        String password = requestBody.get("Password").asText();
        if (validation(username, password)) {
            return new User(username, password);
        }
		
		
        return new User();
    }

    
	
	private boolean validation(String username, String password) {
        if (username == null || password == null || username.equals("") || password.equals("")) {
            return false;
        }
        return true;
    }



    public User registerUser(JsonNode requestBody) {
        try {
			
			
            final Connection dbConnection = DatabaseConnection.getInstance().createDbConnection();
            PreparedStatement statement = dbConnection.prepareStatement("INSERT INTO users (username,password) VALUES(?,?);");
            String username = requestBody.get("Username").asText();
            String password = requestBody.get("Password").asText();
            User user = new User(username, password);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            return user;
			
        } catch (SQLException throwables) {
            throwables.printStackTrace();
			
        }
		
		
        return new User();
    }
}
