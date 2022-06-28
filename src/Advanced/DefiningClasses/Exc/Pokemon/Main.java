package Advanced.DefiningClasses.Exc.Pokemon;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] commandLine = sc.nextLine().split(" ");
        Map<String, Trainer> trainerListMap = new LinkedHashMap<>();
        while (!commandLine[0].equals("Tournament")) {
            String trainerName = commandLine[0];
            String pokemonName = commandLine[1];
            String pokemonElement = commandLine[2];
            int pokemonHealth = Integer.parseInt(commandLine[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainerListMap.putIfAbsent(trainerName, new Trainer());
            trainerListMap.get(trainerName).addPokemon(pokemon);
            commandLine = sc.nextLine().split(" ");
        }
        String command = sc.nextLine();
        while (!command.equals("End")) {
            for (Map.Entry<String, Trainer> keyValuePair : trainerListMap.entrySet()) {
                if (keyValuePair.getValue().pokeCollectionSize() > 0) {
                    boolean isPresent = false;
                    for (Pokemon pokemon : keyValuePair.getValue().getPokemons()) {
                        if (pokemon.getElement().equals(command)) {
                            isPresent = true;
                            keyValuePair.getValue().setNumberOfBadges();
                            break;
                        }
                    }
                    if (!isPresent) {
                        keyValuePair.getValue().missingPokemon();
                    }
                }
            }
            command = sc.nextLine();
        }
        trainerListMap.entrySet().stream().sorted((x1, x2) -> Integer.compare(x2.getValue().getNumberOfBadges(), x1.getValue().getNumberOfBadges()))
                .forEach(element ->
                        System.out.printf("%s %s %s%n", element.getKey(), element.getValue().getNumberOfBadges(), element.getValue().pokeCollectionSize()));

    }
}
