package com.example.pokedex;

public class PokemonControllerViaMock implements PokemonControllerInterface{

    /**
     * Mock getPokemon(int id) implementation
     * @param id : expected Pokemon id (int)
     * @return Mock Pokemon with id = id, name = "Mock Pokemon", height = 0, weight = 0, description = "Mock description"
     */
    public Pokemon getPokemon(int id) {
        return new Pokemon(id, "Mock Pokemon", 0, 0, "Mock description");
    }
}
