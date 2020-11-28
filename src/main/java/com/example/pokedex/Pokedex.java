package com.example.pokedex;


public class Pokedex {

    public static void main(String[] args) {
        Pokemon pokemon = null;
        int id = 1;
        PokemonControllerInterface pokemonController = null;

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
        if (args.length > 1) {
            System.out.println("From database");
            //Liskov Substitution
            pokemonController = new PokemonControllerViaSQL(args[1]);
            //pokemon = pokemonController.getPokemon(id);
        }
        else {
            System.out.println("From PokeApi");
            pokemonController = new PokemonControllerViaApi();
            //pokemon = pokemonController.getPokemon(id);
        }

        pokemon = pokemonController.getPokemon(id);
        PokemonView pokemonViewer = new PokemonView();
        pokemonViewer.print(pokemon);

        //SQLLiteExample.run();
        //HTTPRequestExample.run();
    }

    public String getName() {
        return "Hello";
    }
}
