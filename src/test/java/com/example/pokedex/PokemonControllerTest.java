package com.example.pokedex;

import org.junit.Assert;
import org.junit.Test;

public class PokemonControllerTest {

    @Test
    public void getPokemonTest() {
        PokemonControllerInterface pokemonController = new PokemonControllerViaMock();
        Pokemon pokemon = pokemonController.getPokemon(1);
        Assert.assertNotNull(pokemon);
    }
}
