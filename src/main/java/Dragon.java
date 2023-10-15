package main.java;

import java.util.Random;

public class Dragon {
    // Class members
    private String color;
    private int level;
    private int health;
    private int attack;
    private int defense;

     // Method accessible from other classes

    public Dragon(String color, int level) {
        this.color = color;
        this.level = level;
        health = level * 100;
        attack = level * 10;
        defense = level * 5;
    }

    public String getColor() {
        return color;
    }

    public int getLevel() {
        return level;
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

    public void takeDamage(int damage) {
        health -= damage;
    }

    public void attackPlayer(Player player) {
        // Implement attack logic
        System.out.println("The dragon attacked you.");
        player.takeDamage(attack);
    }

    /*public void takeDamage(int damage) {
        health -= damage;
    }*/
    public static Dragon generateRandomDragon(int choice) {
        Random random = new Random();
        int level = random.nextInt(5) + 1;

        switch (choice) {
            case 1:
                return new Dragon("Green", level);
            case 2:
                return new Dragon("Blue", level);
            case 3:
                return new Dragon("Red", level);
            case 4:
                return new Dragon("Black", level);
            case 5:
                return new Dragon("Gold", level);
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return "Dragon Stats: " +
                "Color=" + color +
                ", Level=" + level +
                ", Health=" + health +
                ", Attack=" + attack +
                ", Defense=" + defense;
    }

    public void attack(Player player) {
    }

    public int getStrength() {
        return 0;
    }

   
}
