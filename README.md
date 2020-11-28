# S.O.L.I.D Lab : Pokedex Project


* Author : Alexandre Verdet
* Last update : 27/11/20
* Main project : [SOLID Lesson Gitlab Repo](https://gitlab.com/qrichaud/emse_solid_lesson)

## Prerequiries : build, run app, run tests

After cloning this repository, if you have a Java environment on your machine, you can directly run the commands.

### Build the project

```
./gradlew build
```

### Run the application

```
./gradlew run
```

To run the application with command line arguments :

```
./gradlew run --args="premierArgument secondArgument"
```

### Run the tests

```
./gradlew test
```


# Report


The goal of this project is to experiment the *SOLID* method to design applications.\
We will therefore make a basic java implementation of a Pokedex, via [PokeApi](https://pokeapi.co/) and / or a SQLite database.

* S : Single-purpose Responsibility
* O : Open-Closed
* L : Liskov Substition
* I : Interface Segregation
* D : Dependency Inversion


## Single-purpose Responsibility

We have to ensure that every class and method has and fulfills only one objective.\
In order to do this, I fragmented the communication with the API into two classes: *HTTPRequester* and *PokemonControllerViaApi*. The first one can be used to process any HTTP request while the second creates the *Pokemon* instance from the HTTP response by parsing the received Json file. This fragmentation can be relevant if we want to add new functionalities in the future. [PokeApi](https://pokeapi.co/) provides way more information other than Pokemons (berries, attacks...).

*Pokemon* are implemented following the MVC (Model, View, Controller) standard. Therefore, we have several classes, all of which only serves one unique and well defined task.
* `Pokemon` which models the Pokemon object and it's attributes
* `PokemonView` which provides methods such as *toString(Pokemon pokemon)* and *print(Pokemon pokemon)* to format the way Pokemons are displayed in the terminal
* `PokemonController*` classes and interface which are used to create Pokemon instances via *PokeApi* or the *Sqlite* database

## Open-Closed

We used the *Open-Closed* principle to implement the *Sqlite database* functionality on top of the *PokeApi* functionality. `PokemonControllerViaSQL` extends `PokemonControllerViaApi`therefore we can easily call the `PokemonControllerViaApi` methods if we can't retrieve the Pokemon's information from the database :
```java
catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Pokemon not in database, retrieving from PokeApi");
            //Open-Closed : use PokemonControlelrViaApi superclass
            pokemon = super.getPokemon(id);
        }
```

## Liskov Substitution

We represent the *Liskov Substitution* in the *Pokedex* main class by using only one `PokemonControllerInterface` instance called `pokemonController` and initialising it either with `new PokemonControllerViaSQL(db.url)` or `new PokemonControllerViaApi()` whether the user provided a database path in the args.
```java
PokemonControllerInterface pokemonController = null;
// To better represent Liskov Substitution, Could be replaced by
// PokemonControllerViaApi pokemonController = null;
if (args.length > 1) {
            System.out.println("From database");
            //Liskov Substitution
            pokemonController = new PokemonControllerViaSQL(args[1]);
            pokemon = pokemonController.getPokemon(id);
        }
        else {
            System.out.println("From PokeApi");
            pokemonController = new PokemonControllerViaApi();
            pokemon = pokemonController.getPokemon(id);
        }
```


## Dependency Inversion

As we saw previously, the main `Pokedex` class only depends on the `PokemonControllerInterface` and its `getPokemon(int id)` method to create a Pokemon and retrieve its information. It is the main `Pokedex` class which will instanciate the `PokemonControllerInterface` by `PokemonControllerViaApi` or `PokemonControllerViaSQL`, as long as it fulfills the interface.

To represent it, we created a `PokemonControllerViaMock` class which implements the *getPokemon()* method returning a mock Pokemon for testing purposes.


## Interface Segregation

In our case, the `PokemonControllerInterface` is very simple and only requires the implementation of one method *Pokemon getPokemon(int id)*. Therefore, the implementation of this interface isn't too binding.

We will try to describe an example in which the Interface Segregation principle may be useful.\
Let's say we need to rewrite the implementation of the sql communication classes in order to communicate with an exotic type of database. We could create a general interface called `ExoticDatabaseController` requiring us to implement every method to fully communicate with the database (read, write, create table, delete, set primary keys...)

However, if this database represents a filled Pokemon database, the Pokedex doesn't need to write, neither delete or create new tables. We don't need to implement these methods to make the Pokedex work.
Following the *Interface Segregation* principle, we should create several interfaces to split the different possible usages of the database. For instance, create interfaces such as `ExoticDatabaseReader`, `ExoticDatabaseWriter`...
