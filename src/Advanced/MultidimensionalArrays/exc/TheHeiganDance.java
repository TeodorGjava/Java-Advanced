package Advanced.MultidimensionalArrays.exc;

import java.util.Scanner;

public class TheHeiganDance {
   public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            double hsPoints = 3000000.0;
            int playerPoints = 18500;
            int startPlRow = 7;
            int startPlCol = 7;
            String lastSpell = "";
            boolean activeCloud = false;
            double damage = Double.parseDouble(scanner.nextLine());
            while (playerPoints > 0 && hsPoints > 0) {
                hsPoints -= damage;
                if (activeCloud) {
                    playerPoints -= 3500;
                    activeCloud = false;
                    if (playerPoints < 0) {
                        break;
                    }
                }
                if (hsPoints < 0) {
                    break;
                }
                String[] tokens = scanner.nextLine().split("\\s+");

                String spell = tokens[0];
                int row = Integer.parseInt(tokens[1]);
                int col = Integer.parseInt(tokens[2]);

                boolean[][] heiganChamber = new boolean[15][15];
                for (int i = row - 1; i <= row + 1; i++) {
                    if (i >= 0 && i < heiganChamber.length) {
                        for (int j = col - 1; j <= col + 1; j++) {
                            if (j >= 0 && j < heiganChamber[row].length) {
                                heiganChamber[i][j] = true;
                            }
                        }
                    }
                }

                if (heiganChamber[startPlRow][startPlCol]) {
                    if (isRowValid(heiganChamber, startPlRow - 1) && !heiganChamber[startPlRow - 1][startPlCol]) {
                        startPlRow--; // move up
                    } else if (isColValid(heiganChamber, startPlCol + 1) && !heiganChamber[startPlRow][startPlCol + 1]) {
                        startPlCol++; // move right
                    } else if (isRowValid(heiganChamber, startPlRow + 1) && !heiganChamber[startPlRow + 1][startPlCol]) {
                        startPlRow++; // move down
                    } else if (isColValid(heiganChamber, startPlCol - 1) && !heiganChamber[startPlRow][startPlCol - 1]) {
                        startPlCol--; // move left
                    }

                    if (heiganChamber[startPlRow][startPlCol]) {
                        switch (spell) {
                            case "Cloud":
                                playerPoints -= 3500;
                                activeCloud = true;
                                lastSpell = "Plague Cloud";
                                break;
                            case "Eruption":
                                playerPoints -= 6000;
                                lastSpell = spell;
                                break;
                            default:
                                throw new IllegalArgumentException("Invalid spell: " + spell);
                        }
                    }
                }
            }
            if (hsPoints > 0) {
                System.out.printf("Heigan: %.2f%n", hsPoints);
            } else {
                System.out.println("Heigan: Defeated!");
            }
            if (playerPoints > 0) {
                System.out.printf("Player: %d%n", playerPoints);
            } else {
                System.out.println("Player: Killed by " + lastSpell);
            }
            System.out.println("Final position: " + startPlRow + ", " + startPlCol);
        }

        private static boolean isRowValid(boolean[][] heiganChamber, int startPlRow) {
            return startPlRow >= 0 && startPlRow < heiganChamber[startPlRow].length;
        }

        private static boolean isColValid(boolean[][] heiganChamber, int startPlCol) {
            return startPlCol >= 0 && startPlCol < heiganChamber.length;
        }
    }