package characters;

import battle.Effects;

public abstract class Character {
    protected String name;
    protected int level = 1;
    protected int hp;
    protected int maxHp;           // track max HP for healing
    protected int defense;
    protected int energy;
    protected int maxEnergy;       // track max energy
    protected int attack;

    private final Effects effects;

    public Character(String name, int hp, int defense, int energy, int attack) { // for players
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.defense = defense;
        this.energy = energy;
        this.maxEnergy = energy;
        this.attack = attack;
        this.effects = new Effects(this);
    }

    public Character(String name, int hp, int defense) { // for enemies
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.defense = defense;
        this.effects = new Effects(this);
    }

    // ------------------- GETTERS for player stats -------------------
    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getDefense() { return defense; }
    public int getAttack() { return attack; }
    public int getMaxHp() {return maxHp; }
    // ------------------- SETTERS -------------------
    public void setAttack(int attack){ this.attack = attack; }
    public void setDefense(int defense){ this.defense = defense; }
    public void setHp(int hp){ this.hp = hp; }

    // ------------------- GETTER for Effects class -------------------
    public Effects getEffects(){ return effects; }

    public void showStats() {
        System.out.println("\n=========== Stats ============");
        System.out.println("Name    : " + name);
        System.out.println("Level   : " + level);
        System.out.println("Health  : " + hp + "/" + maxHp);
        System.out.println("Energy  : " + energy + "/" + maxEnergy);
        System.out.println("Defense : " + defense);
        System.out.println("Attack  : " + attack);
        System.out.println("==============================\n");
    }

    public abstract void showSkills();

    public abstract void turn (Character target);

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) hp = 0;
        System.out.println("❤️ " + name + " (HP : " + hp + "/" + maxHp + ")");
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public boolean consumeEnergy(int cost) {
        if (energy < cost) {
            energy = 0;
            return true; // not enough energy
        }
        energy -= cost;
        return false; // successful
    }

    public void skipTurn(){
        energy += (int) (maxEnergy * 0.10);
        if(energy > maxEnergy) energy = maxEnergy;
        System.out.println("Turn skipped! Restored a bit of energy. (Energy: " + energy + "/" + maxEnergy + ")");
    }

}
