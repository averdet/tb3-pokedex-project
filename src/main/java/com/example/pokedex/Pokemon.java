package com.example.pokedex;

public class Pokemon {
    private int id;
    private String name;
    private int height;
    private int weight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Pokemon(int id, String name, int height, int weight) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Pokemon Id : " + this.id + "\n"
                +"Pokemon Name : " + this.name + "\n"
                +"Pokemon Height : " + this.height + "\n"
                +"Pokemon Weight : " + this.weight + "\n";
    }
}
