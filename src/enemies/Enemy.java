package enemies;

import java.util.Random;

public abstract class Enemy {
    // Properties
    protected String name;
    protected int hp;
    protected int maxHp;
    protected int defense;
    protected Random rand;

    // Constructor
    public Enemy(String name, int hp, int defense) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.defense = defense;
        this.rand = new Random();
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getDefense() {
        return defense;
    }

    // Take damage (damage reduced by defense)
    public void takeDamage(int dmg) {
        int reduced = Math.max(0, dmg - defense);
        hp -= reduced;
        if (hp < 0) hp = 0;
        System.out.println(name + " took " + reduced + " damage. (HP: " + hp + "/" + maxHp + ")");
    }

    // Check if alive
    public boolean isAlive() {
        return hp > 0;
    }

    // Show stats
    public void showStats() {
        System.out.println("===== Enemy Stats =====");
        System.out.println("Name    : " + name);
        System.out.println("HP      : " + hp + "/" + maxHp);
        System.out.println("Defense : " + defense);
        System.out.println("=======================");
    }
}
