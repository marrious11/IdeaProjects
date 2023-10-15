package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    // Class members
    private int health;
    private int attack;
    private int defense;
    private int goldCoins;
    private int experiencePoints;
    private List<String> inventory;

    public Player() {
        health = 100;
        attack = 10;
        defense = 5;
        goldCoins = 0;
        experiencePoints = 0;
        inventory = new ArrayList<>();
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getGoldCoins() {
        return goldCoins;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public List<String> getInventory() {
        return inventory;
    }
    // Method accessible from other classes

    public void equipOrDrinkItem(int itemIndex) {
        // Implement item equip/drink logic
        System.out.println("Item equipped/drank.");
    }

    public void discardItem(int itemIndex) {
        // Implement item discard logic
        System.out.println("Item discarded.");
    }

    public void buyItem(int itemType) {
        // Implement item buy logic
        System.out.println("Item bought.");
    }

    public void sellItem(int itemIndex) {
        // Implement item sell logic
        System.out.println("Item sold.");
    }

    public void attackDragon(Dragon dragon) {
        // Implement attack logic
        System.out.println("You attacked the dragon.");
        dragon.takeDamage(attack);
    }

    public void drinkPotion() {
        // Implement potion drinking logic
        System.out.println("You drank a potion.");
    }

    public boolean flee() {
        // Implement flee logic
        return new Random().nextBoolean();
    }

    public void addGoldCoins(int amount) {
        goldCoins += amount;
    }

    public void addExperiencePoints(int amount) {
        experiencePoints += amount;
    }

    @Override
    public String toString() {
        return "Player Stats: " +
                "Health=" + health +
                ", Attack=" + attack +
                ", Defense=" + defense +
                ", Gold Coins=" + goldCoins +
                ", Experience Points=" + experiencePoints;
    }


    
}
