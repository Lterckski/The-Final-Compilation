package characters;

import battle.Effects;
import utils.InputUtil;

public abstract class Character {
    protected String name;
    protected int level = 1;
    protected int hp;
    protected int maxHp;           // track max HP for healing
    protected int defense;
    protected int energy;
    protected int maxEnergy;       // track max energy
    protected int attack;
    protected int baseAttack;
    protected int baseDefense;
    protected int ultimateCounter = 3;

    private final Effects effects;

    public Character(String name, int hp, int defense, int energy, int attack) { // for players
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.baseDefense = defense;
        this.defense = defense;
        this.energy = energy;
        this.maxEnergy = energy;
        this.baseAttack = attack;
        this.attack = attack;
        this.effects = new Effects(this);
    }

    public Character(String name, int hp, int defense, int attack) { // for enemies
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.defense = defense;
        this.attack = attack;
        this.effects = new Effects(this);
    }

    // ------------------- GETTERS for player stats -------------------
    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getDefense() { return defense; }
    public int getAttack() { return attack; }
    public int getMaxHp() { return maxHp; }
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

        System.out.print("Defense : " + defense);
        if(defense > baseDefense) System.out.print(" + " + (defense - baseDefense));
        System.out.println();

        System.out.print("Attack  : " + baseAttack);
        if(attack > baseAttack) System.out.print(" + " + (attack - baseAttack));
        System.out.println();

        System.out.println("==============================\n");
    }

    public abstract void showSkills();
    public abstract void turn (Character target);

    public void showMenu(Character player, Character enemy){
        boolean goBack = false;

        while(!goBack){
            System.out.println("(1) Open Inventory");
            System.out.println("(2) Show Player Stats");
            System.out.println("(3) Show Player Skills Overview");
            System.out.println("(4) Show Enemy Stats");
            System.out.println("(5) Show Enemy Skills Overview");
            System.out.println("(6) Go back");

            System.out.print("Enter choice: ");
            int choice = InputUtil.scan.nextInt();
            InputUtil.scan.nextLine();

            switch (choice){
                //case 1 ->  openInventory TODO: implement inventory
                case 2 -> player.showStats();
                case 3 ->  player.showSkills();
                case 4 -> enemy.showStats();
                case 5 -> enemy.showSkills();
                case 6 -> goBack = true;
                default -> System.out.println("❌ Invalid choice! Please select a valid option.");
            }
        }
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) hp = 0;
        System.out.println("❤️ " + name + " (HP : " + hp + "/" + maxHp + ")");
    }

    public void displayHp(){
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
