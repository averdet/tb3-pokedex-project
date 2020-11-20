package com.example.pokedex;

import java.sql.*;

public class PokemonControllerViaSQL implements PokemonControllerInterface {
    private String databaseUrl;

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public void setDatabaseUrl(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    public PokemonControllerViaSQL(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    public Pokemon getPokemon(int id) {
        Pokemon pokemon = null;
        /* Connect to the database */
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:"+this.databaseUrl;
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");

            PreparedStatement stmt  = conn.prepareStatement("SELECT name, description, height, weight FROM pokemons WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs    = stmt.executeQuery();
            rs.next();
            String pokemonName = rs.getString("name");
            String pokemonDescription = rs.getString("description");
            int pokemonHeight = rs.getInt("height");
            int pokemonWeight = rs.getInt("weight");
            pokemon = new Pokemon(id, pokemonName, pokemonHeight, pokemonWeight, pokemonDescription);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return pokemon;
    }
}
