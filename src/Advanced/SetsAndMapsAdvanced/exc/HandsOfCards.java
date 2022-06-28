package Advanced.SetsAndMapsAdvanced.exc;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(": ");
        Map<String, Set<String>> playersAndCards = new LinkedHashMap<>();
        while (!input[0].equals("JOKER")) {
            String name = input[0];
            String[] cards = input[1].split(", ");
            playersAndCards.putIfAbsent(name, new LinkedHashSet<>());
            for (int i = 0; i < cards.length; i++) {
                if (!playersAndCards.get(name).contains(cards[i])) {
                    playersAndCards.get(name).add(cards[i]);
                }
            }
            input = sc.nextLine().split(": ");
        }
        for (var entry : playersAndCards.entrySet()
        ) {
        final int[] sum = {0};

            final int[] result = {0};
                entry.getValue().forEach(x -> {
                    switch (x.charAt(0)) {
                        case '1':
                            result[0]=10;
                            switch (x.charAt((2))){
                                case 'S':
                                    result[0] = result[0] * 4;
                                    break;
                                case 'H':
                                    result[0] = result[0] * 3;
                                    break;
                                case 'D':
                                    result[0] = result[0] * 2;
                                    break;
                                case 'C':
                                    break;
                            }
                            break;
                        case '2':
                            result[0] = 2;
                            break;
                        case '3':
                            result[0] = 3;
                            break;
                        case '4':
                            result[0] = 4;
                            break;
                        case '5':
                            result[0] = 5;
                            break;
                        case '6':
                            result[0] = 6;
                            break;
                        case '7':
                            result[0] = 7;
                            break;
                        case '8':
                            result[0] = 8;
                            break;
                        case '9':
                            result[0] = 9;
                            break;
                        case 'J':
                            result[0] = 11;
                            break;
                        case 'Q':
                            result[0] = 12;
                            break;
                        case 'K':
                            result[0] = 13;
                            break;
                        case 'A':
                            result[0] = 14;
                            break;
                    }
                    switch (x.charAt(1)) {
                        case 'S':
                            result[0] = result[0] * 4;
                            break;
                        case 'H':
                            result[0] = result[0] * 3;
                            break;
                        case 'D':
                            result[0] = result[0] * 2;
                            break;
                        case 'C':
                            break;
                    }
                    sum[0] += result[0];
                    result[0] = 0;
                });


                    System.out.println(entry.getKey() + ": " + sum[0]);

        }
    }
}

