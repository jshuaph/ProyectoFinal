package com.tap.gestiontorneo.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static ConexionDB instance;

    private static final String URL = "jdbc:mysql://localhost:3306/gestion_torneos";
    private static final String USER = "root";
    private static final String PASSWORD = "Joshu@0210";

    private Connection con;

    private ConexionDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    public static synchronized ConexionDB getInstance() {
        if (instance == null) {
            instance = new ConexionDB();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            if (con == null || con.isClosed()) {
                this.con = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            System.out.println("Error al reabrir conexión: " + e.getMessage());
        }
        return con;
    }
}
