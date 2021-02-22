package com.party.playlist.battle.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
    /**
     * Singleton
     */


    private static DatabaseConnection single_instance = null;



    private DatabaseConnection() {
    }
	

    public static DatabaseConnection getInstance() {
		
        if (single_instance == null) {
			
            single_instance = new DatabaseConnection();
        }
        return single_instance;
    }


    public Connection createDbConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/ppb_db", "daniel", "daniel");
    }


}
