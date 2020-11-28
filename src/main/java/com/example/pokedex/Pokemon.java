package com.example.pokedex;

public class Pokemon {
    private int id;
    private String name;
    private int height;
    private int weight;
    private String description = "";

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pokemon(int id, String name, int height, int weight) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public Pokemon(int id, String name, int height, int weight, String description) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.description = description;
    }

    public boolean equals(Pokemon b) {
        return this.id == b.id & this.name.equals(b.name) & this.height == b.height & this.weight == b.weight & this.description.equals(b.description);
    }
}
