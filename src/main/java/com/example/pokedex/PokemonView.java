package com.example.pokedex;

public class PokemonView {

    public String toString(Pokemon pokemon) {
        String string = "Pokemon Id : " + pokemon.getId() + "\n"
                +"Pokemon Name : " + pokemon.getName() + "\n"
                +"Pokemon Height : " + pokemon.getHeight() + "\n"
                +"Pokemon Weight : " + pokemon.getWeight() + "\n";
        if (pokemon.getDescription().length() > 0) string = string +"Pokemon Description : " + pokemon.getDescription();
        return string;
    }

    public void print(Pokemon pokemon) {
        System.out.println("================================");
        System.out.println(toString(pokemon));
        System.out.println("================================");
    }
}
