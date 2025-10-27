package characters;

import battle.Effects;
import enemies.FinalBoss;
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
    protected int maxHP;           // track max HP for healing
    protected int defense;
    protected int energy;
    protected int energyName;
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
        this.maxHP = hp;
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
        this.maxHP = hp;
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
    public int getMaxHP() { return maxHP; }
    public int getMaxEnergy() { return maxEnergy; }
    public int getEnergy() { return energy; }

    public String getEnergyName() {
        return switch (classType) {
            case "Swordsman" -> "Stamina";
            case "Archer" -> "Arrows";
            case "Mage" -> "Mana";
            default -> "Energy";
        };
    }

    public String getEnergyEmoji() {
        return switch (classType) {
            case "Swordsman" -> "🔋";
            case "Archer" -> "➶";
            case "Mage" -> "💧";
            default -> "⚡";
        };
    }
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
        System.out.printf("%-8s: %s (%s)%n", "Name", name, classType);

        if (level == 30) {
            System.out.printf("%-8s: MAX%n", "Level");
            System.out.printf("%-8s: MAX%n", "EXP");
        } else {
            System.out.printf("%-8s: %d%n", "Level", level);
            System.out.printf("%-8s: %d/%d%n", "EXP", exp, nextLevelExp);
        }

        System.out.printf("%-8s: %d/%d%n", "HP", hp, maxHP);
        System.out.printf("%-8s: %d/%d%n", getEnergyName(), energy, maxEnergy);

        String attackStr = baseAttack + ((attack != baseAttack) ?
                (attack > baseAttack ? " (+" + (attack - baseAttack) + ")" : " (-" + (baseAttack - attack) + ")")
                : "");
        System.out.printf("%-8s: %s%n", "Attack", attackStr);

        String defenseStr = baseDefense + ((defense != baseDefense) ?
                (defense > baseDefense ? " (+" + (defense - baseDefense) + ")" : " (-" + (baseDefense - defense) + ")")
                : "");
        System.out.printf("%-8s: %s%n", "Defense", defenseStr);

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

    public int calculateDamage(Character target, int damage) {
        int reduced = damage;

        // If target is FinalBoss with a shield
        if (target instanceof FinalBoss fb && fb.getShield() > 0) {
            // Only break shield if damage >= shield
            if (reduced >= fb.getShield()) {
                int absorbed = fb.getShield();
                fb.reduceShield(absorbed); // will trigger shieldBroken
                reduced -= absorbed;
            } else {
                fb.reduceShield(reduced); // just reduce shield, won't break
                reduced = 0; // all damage absorbed
            }
        }

        // Apply target's defense
        reduced -= target.getDefense();
        if (reduced < 0) reduced = 0;

        return reduced;
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) hp = 0;
    }

    public void displayHp(){
        System.out.println("❤️ " + name + " (HP : " + hp + "/" + maxHP + ")");
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public boolean consumeEnergy(int cost) {
        if (energy < cost) {
            return false; // not enough energy
        }
        energy -= cost;
        if(energy < 0) energy = 0;
        return true; // successful
    }

    public void skipTurn() {
        int restoreAmount;

        // Restore based on class
        switch (classType) {
            case "Swordsman" -> restoreAmount = 20;
            case "Archer" -> restoreAmount = 6;
            case "Mage" -> restoreAmount = 30;
            default -> restoreAmount = 0;
        }

        int oldHp = hp;
        int oldEnergy = energy;

        energy += restoreAmount;
        if (energy > maxEnergy) energy = maxEnergy;

        hp += (int)(maxHP * 0.1);
        if (hp > maxHP) hp = maxHP;

        System.out.println("✨ Turn skipped! Restored a bit of HP and " + getEnergyName() + ".");
        System.out.println("💖 HP: " + oldHp + " → " + hp + " | " + getEnergyEmoji() + " " + getEnergyName() + ": " + oldEnergy + " → " + energy);

    }



    public void heal(int amount){
        hp += amount;
        if(hp > maxHP) hp = maxHP;
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
        if(level < 30){
            level++;
            ScenePrinter.hr();
            System.out.println("✨ LEVEL UP! You are now Level " + level + "! ✨");
            System.out.println("💖 HP & " + getEnergyEmoji() + " " + getEnergyName() + " Restored!");

            int oldHp = maxHP;
            int oldAtk = baseAttack;
            int oldDef = baseDefense;
            int oldEnergy = maxEnergy;

            switch (classType) {
                case "Swordsman" -> {
                    maxHP += 110 + (int)(maxHP * 0.02);
                    baseAttack += 2;
                    baseDefense += 2;
                    maxEnergy += 5;
                }
                case "Archer" -> {
                    maxHP += 80 + (int)(maxHP * 0.02);
                    baseAttack += 4;
                    baseDefense += 1;
                    if (level % 10 == 0) {
                        maxEnergy += 8;
                    }
                }
                case "Mage" -> {
                    maxHP += 70 + (int)(maxHP * 0.015);
                    baseAttack += 5;
                    baseDefense += 1;
                    maxEnergy += 10;
                }
            }

            hp = maxHP;
            energy = maxEnergy;

            exp -= nextLevelExp;
            if (level < XP_TABLE.length) nextLevelExp = XP_TABLE[level];

            recalculateBuffs();

            System.out.println("❤️ HP     : +" + (maxHP - oldHp) + " → " + maxHP);
            System.out.println("⚔️ ATK    : +" + (baseAttack - oldAtk) + " → " + attack);
            System.out.println("🛡️ DEF    : +" + (baseDefense - oldDef) + " → " + defense);
            System.out.println(getEnergyEmoji() + " " + getEnergyName() + " : +" + (maxEnergy - oldEnergy) + " → " + maxEnergy);
            ScenePrinter.hr();
        }
    }



    public void recalculateBuffs(){
        attack = baseAttack + getWeapon().getAtkBuff();
        defense = baseDefense + getArmor().getDefBuff();
    }


}
