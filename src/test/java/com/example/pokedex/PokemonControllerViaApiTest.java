package com.example.pokedex;

import org.junit.Assert;
import org.junit.Test;

public class PokemonControllerViaApiTest {

    @Test
    public void PokeControllerViaApiTest() {
        Pokemon hooh = new Pokemon(250, "ho-oh", 38, 1990);
        PokemonControllerViaApi api = new PokemonControllerViaApi();
        Pokemon result = api.getPokemon(250);

        Assert.assertTrue(result.equals(hooh));
    }

}
