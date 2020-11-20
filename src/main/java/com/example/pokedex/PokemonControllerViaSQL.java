package com.example.pokedex;

import java.sql.*;

public class PokemonControllerViaSQL  {

    public Pokemon getPokemon(int id, String database) {
        Pokemon pokemon = null;
        /* Connect to the database */
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:"+database;
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
