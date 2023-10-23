package main.java;

import java.util.Scanner;

public class RPGGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();

        System.out.println("Welcome to the RPG Game!");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Inventory");
            System.out.println("2. Shop");
            System.out.println("3. Dragon Cave");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    handleInventory(player, scanner);
                    break;
                case 2:
                    handleShop(player, scanner);
                    break;
                case 3:
                    handleDragonCave(player, scanner);
                    break;
                case 4:
                    System.out.println("Thanks for playing the RPG Game!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }//end main

    public static void handleInventory(Player player, Scanner scanner) {
        System.out.println("\nInventory Menu:");
        System.out.println("Items in inventory: " + player.getInventory());

        while (true) {
            System.out.println("\nSelect an item to manage:");
            System.out.println("1. Equip/Drink");
            System.out.println("2. Discard");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("Enter the item number to equip/drink: ");
                    int itemIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    player.equipOrDrinkItem(itemIndex);
                    break;
                case 2:
                    System.out.println("Enter the item number to discard: ");
                    itemIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    player.discardItem(itemIndex);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void handleShop(Player player, Scanner scanner) {
        System.out.println("\nShop Menu:");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Buy");
            System.out.println("2. Sell");
            System.out.println("3. Exit\n");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("\nSelect an item type to buy:");
                    System.out.println("1. Weapon");
                    System.out.println("2. Armor");
                    System.out.println("3. Potion\n");

                    int itemType = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    player.buyItem(itemType);
                    break;
                case 2:
                    System.out.println("\nItems in inventory: " + player.getInventory());
                    System.out.println("Enter the item number to sell: ");
                    int itemIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    player.sellItem(itemIndex);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void handleDragonCave(Player player, Scanner scanner) {
        System.out.println("\nDragon Cave Menu:");
        System.out.println("Select a dragon cave:");
        System.out.println("1. Green");
        System.out.println("2. Blue");
        System.out.println("3. Red");
        System.out.println("4. Black");
        System.out.println("5. Gold\n");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Dragon dragon = generateRandomDragon(choice);

        System.out.println("\nDragon stats:");
        System.out.println(dragon);

        while (true) {
            System.out.println("\nPlayer stats:");
            System.out.println(player);

            System.out.println("\nSelect an action:");
            System.out.println("1. Attack");
            System.out.println("2. Drink Potion");
            System.out.println("3. Flee");

            int action = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (action) {
                case 1:
                    player.attackDragon(dragon);
                    break;
                case 2:
                    player.drinkPotion();
                    break;
                case 3:
                    if (player.flee()) {
                        System.out.println("You managed to escape from the dragon!");
                        return;
                    } else {
                        System.out.println("You failed to escape and the dragon attacked you!");
                        dragon.attack(player);
                        if (player.getHealth() <= 0) {
                            System.out.println("You were killed by the dragon. Game over!");
                            return;
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            assert dragon != null;
            if (dragon.getHealth() <= 0) {
                System.out.println("Congratulations! You defeated the dragon.");
                int goldCoins = dragon.getLevel() * dragon.getStrength() * 10;
                int experiencePoints = dragon.getLevel() * 100;
                player.addGoldCoins(goldCoins);
                player.addExperiencePoints(experiencePoints);
                System.out.println("You received " + goldCoins + " gold coins and " + experiencePoints + " experience points.");
                return;
            }
        }
    }


    private static Dragon generateRandomDragon(int choice) {
        return null;
    }


}
