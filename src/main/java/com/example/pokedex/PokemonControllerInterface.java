package com.example.pokedex;

public interface PokemonControllerInterface {
    /**
     * This method should return a Pokemon instance corresponding to the Pokemon id
     * @param id : requested Pokemon id (int)
     * @return Pokemon instance corresponding to the id
     */
    public Pokemon getPokemon(int id);
}
