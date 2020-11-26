After cloning this repository, if you have a Java environment on your machine, you can directly run the commands.


# Build the project

```
./gradlew build
```



# Run the application

```
./gradlew run
```

To run the application with command line arguments :

```
./gradlew run --args="premierArgument secondArgument"
```


# Run the tests

```
./gradlew test
```


# S.O.L.I.D Lab : Pokedex Project

* Author : Alexandre Verdet
* Last update : 26/11/20

The goal of this project is to experiment the *SOLID* method to design application.\
We will therefore make a basic java implementation of a Pokedex, via [PokeApi](https://pokeapi.co/) and / or a SQLite database.

* S : Single-purpose Responsibility
* O : Open-Closed
* L : Liskov Substition
* I : Interface Segregation
* D : Dependency Inversion


## Single-purpose Responsibility

We have to ensure every class and method have and fulfil only one objective.\
In order to do this, I fragmented the communication with the API into two classes: *HTTPRequester* and *PokemonControllerViaApi*. The first one can be used to process any HTTP request while the second creates the *Pokemon* instance from the HTTP response by parsing the received Json file. This fragmentation can be relevant if we want to add new functionalities in the future. [PokeApi](https://pokeapi.co/) provides way more information other than Pokemon (berries, attacks...). 
