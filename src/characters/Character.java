package characters;

import battle.Effects;
import inventory.Armor;
import inventory.Inventory;
import inventory.Potions;
import inventory.Weapon;
import story.ScenePrinter;
import utils.InputUtil;

public abstract class Character {

    protected String name;
    protected String classType;

    protected int level;
    protected int exp;
    protected int nextLevelExp;


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
    private final Inventory inventory;

    private static final int[] XP_TABLE = {
            0, 100, 115, 130, 150, 175, 200, 230, 265, 305, 355,
            405, 465, 535, 615, 720, 875, 1040, 1350, 1650, 2200,
            2500, 2900, 3350, 3800, 4400, 5000, 5800, 6600, 7400
    };

    public Character(String name, String classType, int hp, int defense, int energy, int attack) { // for players
        this.name = name;
        this.classType = classType;
        this.level = 1;
        this.hp = hp;
        this.maxHp = hp;
        this.baseDefense = defense;
        this.defense = defense;
        this.energy = energy;
        this.maxEnergy = energy;
        this.baseAttack = attack;
        this.attack = attack;
        this.effects = new Effects(this);
        this.inventory = new Inventory(this);
        this.exp = 0;
        this.nextLevelExp = XP_TABLE[1];
    }

    public Character(String name, int hp, int defense, int attack) { // for enemies
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.baseDefense = defense;
        this.defense = defense;
        this.baseAttack = attack;
        this.attack = attack;
        this.effects = new Effects(this);
        this.inventory = new Inventory(this);
    }

    // ------------------- GETTERS for player stats -------------------
    public String getName() { return name; }
    public String getClassType(){ return classType; }
    public int getHp() { return hp; }
    public int getDefense() { return defense; }
    public int getAttack() { return attack; }
    public int getMaxHp() { return maxHp; }
    public int getMaxEnergy() { return maxEnergy; }
    public int getEnergy() { return energy; }
    // ------------------- SETTERS -------------------
    public void setAttack(int attack){ this.attack = attack; }
    public void setDefense(int defense){ this.defense = defense; }
    public void setHp(int hp){ this.hp = hp; }
    // ------------------- GETTER for Effects class -------------------
    public Effects getEffects(){ return effects; }

    public Inventory getInventory() { return inventory; }

    public Weapon getWeapon(){
        return this.getInventory().getEquippedWeapon();
    }
    public Armor getArmor(){
        return this.getInventory().getEquippedArmor();
    }
    public Potions getPotions(){
        return this.getInventory().getPotions();
    }

    public void displayStats() {
        System.out.println("\n=========== Stats ============");
        System.out.println("Name    : " + name + " (" + classType + ")");
        System.out.println("Level   : " + level);
        System.out.println("EXP     : " + exp + "/" + nextLevelExp);
        System.out.println("Health  : " + hp + "/" + maxHp);
        System.out.println("Energy  : " + energy + "/" + maxEnergy);

        // Attack
        System.out.print("Attack  : " + baseAttack);
        if (attack > baseAttack) {
            System.out.print(" (+" + (attack - baseAttack) + ")");
        } else if (attack < baseAttack) {
            System.out.print(" (-" + (baseAttack - attack) + ")");
        }
        System.out.println();

        // Defense
        System.out.print("Defense : " + baseDefense);
        if (defense > baseDefense) {
            System.out.print(" (+" + (defense - baseDefense) + ")");
        } else if (defense < baseDefense) {
            System.out.print(" (-" + (baseDefense - defense) + ")");
        }
        System.out.println();

        System.out.println("==============================\n");
    }


    public abstract void displaySkills();
    public abstract void turn (Character target);

    public void displayMenu(Character player, Character enemy){
        boolean goBack = false;

        while(!goBack){
            System.out.println("(1) Open Inventory");
            System.out.println("(2) Show Player Stats");
            System.out.println("(3) Show Player Skills Overview");
            System.out.println("(4) Show Enemy Stats");
            System.out.println("(5) Show Enemy Skills Overview");
            System.out.println("(0) Go back");

            System.out.print("Enter choice: ");
            int choice = InputUtil.scan.nextInt();
            InputUtil.scan.nextLine();
            ScenePrinter.line();

            switch (choice){
                case 1 -> player.getInventory().openInventory();
                case 2 -> player.displayStats();
                case 3 ->  player.displaySkills();
                case 4 -> enemy.displayStats();
                case 5 -> enemy.displaySkills();
                case 0 -> goBack = true;
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
        System.out.println("✨Turn skipped! Restored a bit of energy. (Energy: " + energy + "/" + maxEnergy + ")");
    }

    public void heal(int amount){
        hp += amount;
        if(hp > maxHp) hp = maxHp;
    }

    public void restoreEnergy(int amount){
        energy += amount;
        if(energy > maxEnergy) energy = maxEnergy;
    }

    public void gainExp(int amount){
        exp += amount;
        ScenePrinter.shortLine();
        System.out.println("✨Gained " + amount + " XP!");
        ScenePrinter.shortLine();
        while(level < XP_TABLE.length && exp >= nextLevelExp){
            levelUp();
        }
    }

    public void levelUp() {
        level++;

        System.out.println();
        ScenePrinter.hr();
        System.out.println("✨ LEVEL UP! You are now Level " + level + "! ✨");

        // Store old values before increasing
        int oldHp = maxHp;
        int oldAtk = baseAttack;
        int oldDef = baseDefense;
        int oldEnergy = maxEnergy;

        // Increase stats
        maxHp = (int) Math.ceil(maxHp * 1.13);
        baseAttack = (int) Math.ceil(baseAttack * 1.13);
        baseDefense = (int) Math.ceil(baseDefense * 1.13);
        maxEnergy += 10;

        // Restore HP and Energy
        hp = maxHp;
        energy = maxEnergy;

        // Subtract XP before setting next requirement
        exp -= nextLevelExp;
        if (level < XP_TABLE.length) {
            nextLevelExp = XP_TABLE[level];
        }

        recalculateBuffs();

        // Show detailed stat gains
        System.out.println("💖 HP     : +" + (maxHp - oldHp) + " → " + maxHp);
        System.out.println("⚔️ ATK    : +" + (baseAttack - oldAtk) + " → " + attack);
        System.out.println("🛡️ DEF    : +" + (baseDefense - oldDef) + " → " + defense);
        System.out.println("🔋 Energy : +" + (maxEnergy - oldEnergy) + " → " + maxEnergy);
        ScenePrinter.hr();
        System.out.println();
    }

    public void recalculateBuffs(){
        attack = baseAttack + getWeapon().getAtkBuff();
        defense = baseDefense + getArmor().getDefBuff();
    }

}
