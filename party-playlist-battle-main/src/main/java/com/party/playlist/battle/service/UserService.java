package com.party.playlist.battle.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.party.playlist.battle.domain.User;
import com.party.playlist.battle.util.DatabaseConnection;

import java.sql.*;

public class UserService {

    public void register(JsonNode userJson) {

        String usernameTemp = userJson.get("Username").asText();
        String passwordTemp = userJson.get("Password").asText();

        User user = new User(usernameTemp, passwordTemp);

        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        try (
                Connection connection = databaseConnection.createDbConnection();
                PreparedStatement statement = connection.prepareStatement("INSERT INTO users (username,password) VALUES(?,?);")
        ) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
