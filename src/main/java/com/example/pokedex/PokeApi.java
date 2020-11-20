package com.example.pokedex;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.http.HttpResponse;

public class PokeApi implements PokeApiRetriever {

    @Override
    public Pokemon retrievePokemonInfo(int id) {
        Pokemon pokemon = null;

        HTTPRequester requester = new HTTPRequester();
        String url = "https://pokeapi.co/api/v2/pokemon/" + id;
        String result = requester.makeRequest(url);

        try {
            JSONParser parser = new JSONParser();
            Object resultObject = parser.parse(result);
            if (resultObject instanceof JSONObject) {
                JSONObject obj =(JSONObject)resultObject;

                String pokemonName = obj.get("name").toString();
                int pokemonHeight = (int) (long) obj.get("height");
                int pokemonWeight = (int) (long) obj.get("weight");

                pokemon = new Pokemon(id, pokemonName, pokemonHeight, pokemonWeight);
            } else {
                System.err.println("Error, we expected a JSON Object from the API");
            }
        } catch (ParseException e) {
            System.err.println("Could not parse the response given by the API as JSON");
            System.err.println("Response body is :");
            System.err.println(result);
            e.printStackTrace();
        }
        return pokemon;
    }
}
