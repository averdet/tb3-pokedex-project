package com.example.pokedex;

import org.junit.Assert;
import org.junit.Test;

public class PokemonControllerViaSQLTest {

    @Test
    public void PokemonControllerViaSQLTest () {
        Pokemon florizarre = new Pokemon(3, "Florizarre", 2, 1000, "Sa plante mûrit en absorbant les rayons du soleil. Il migre souvent vers les endroits ensoleillés");
        PokemonControllerViaSQL sql = new PokemonControllerViaSQL();
        Pokemon result = sql.getPokemon(3, "/tmp/pokemondatabase.sqlite");

        Assert.assertTrue(result.equals(florizarre));
    }
}
