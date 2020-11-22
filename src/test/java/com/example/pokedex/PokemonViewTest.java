package com.example.pokedex;

import org.junit.Assert;
import org.junit.Test;

public class PokemonViewTest {

    @Test
    public void PokemonControllerViaApiTest() {
        Pokemon florizarre = new Pokemon(3, "Florizarre", 2, 1000, "Sa plante mûrit en absorbant les rayons du soleil. Il migre souvent vers les endroits ensoleillés");
        String expected = "Pokemon Id : 3\n" +
                "Pokemon Name : Florizarre\n" +
                "Pokemon Height : 2\n" +
                "Pokemon Weight : 1000\n" +
                "Pokemon Description : Sa plante mûrit en absorbant les rayons du soleil. Il migre souvent vers les endroits ensoleillés";
        PokemonView pokemonViewer = new PokemonView();
        String result = pokemonViewer.toString(florizarre);
        Assert.assertTrue(result.equals(expected));
    }
}
