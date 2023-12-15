package com.diplock.library.queriesdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MiConexion {

	private static final String host = "monorail.proxy.rlwy.net";
    private static final String databaseName = "railway";
    private static final String user = "root";
    private static final String password = "bB-a55H1-g4H434E614AC2AhA33FDeGD";
    private static final int port = 11372;

    private Connection connection; 

    public MiConexion() throws SQLException {
        String connectionString = "jdbc:mysql://" + host + ":" + port + "/" + databaseName;
        this.connection = DriverManager.getConnection(connectionString, user, password);
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void close() throws SQLException {
        this.connection.close();
    }

}
