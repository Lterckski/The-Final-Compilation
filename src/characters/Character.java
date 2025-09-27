package characters;

import java.util.Random;

public abstract class Character {
    protected String name;
    protected int level;
    protected int hp;
    protected int maxHp;           // track max HP for healing
    protected int defense;
    protected int energy;
    protected int maxEnergy;       // track max energy
    protected int attackMin;
    protected int attackMax;

    private Random random = new Random();

    public Character(String name, int hp, int defense, int energy, int attackMin, int attackMax) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.defense = defense;
        this.energy = energy;
        this.maxEnergy = energy;
        this.attackMin = attackMin;
        this.attackMax = attackMax;
        this.level = 1; // default starting level
    }

    public int basicAttack() {
        return random.nextInt((attackMax - attackMin) + 1) + attackMin;
    }

    public void showStats() {
        System.out.println("=========== Stats ============");
        System.out.println("Name    : " + name);
        System.out.println("Level   : " + level);
        System.out.println("Health  : " + hp + "/" + maxHp);
        System.out.println("Energy  : " + energy + "/" + maxEnergy);
        System.out.println("Defense : " + defense);
        System.out.println("Attack  : " + attackMin + " - " + attackMax);
        System.out.println("==============================");
    }

}
