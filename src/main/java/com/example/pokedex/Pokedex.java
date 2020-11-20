package com.example.pokedex;


public class Pokedex {

    public static void main(String[] args) {
        int id = 1;

        System.out.println("It's working !");
        if (args.length > 0) {
            //System.out.println("Vous avez fourni l'argument " + args[0]);
            System.out.println("Retrieving Pokemon with Id : " + args[0]);
            try {
                id = Integer.parseInt(args[0]);
            } catch (NumberFormatException nfe) {
                System.out.println("The first argument must be an integer.");
                System.exit(1);
            }
        }

        PokemonControllerViaApi pokemonControllerViaApi = new PokemonControllerViaApi();
        Pokemon pokemon = pokemonControllerViaApi.getPokemon(id);
        String pokeInfo = pokemon.toString();
        System.out.println(pokeInfo);

        //SQLLiteExample.run();
        //HTTPRequestExample.run();
    }

    public String getName() {
        return "Hello";
    }
}
