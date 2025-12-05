package characters;

import battle.Effects;
import enemies.FinalBoss;
import inventory.Armor;
import inventory.Inventory;
import inventory.Potions;
import inventory.Weapon;
import storyEngine.StoryEngine;
import utils.ColorUtil;
import utils.InputUtil;
import utils.PrintUtil;
import utils.RandomUtil;

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

    protected boolean reviveUsed = false;
    protected int soulShards;

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
        soulShards = 0;
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
    public int getBaseDefense() { return baseDefense; }
    public int getAttack() { return attack; }
    public int getBaseAttack() { return baseAttack; }
    public int getMaxHP() { return maxHP; }
    public int getMaxEnergy() { return maxEnergy; }
    public int getEnergy() { return energy; }
    public int getSoulShards() { return soulShards; }

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
    public void setBaseAttack(int baseAttack){ this.baseAttack = baseAttack; }
    public void setDefense(int defense){ this.defense = defense; }
    public void setBaseDefense(int baseDefense){ this.baseDefense = baseDefense; }
    public void setHp(int hp){ this.hp = hp; }
    public void setMaxHP(int maxHP){ this.maxHP = maxHP; }
    public void setEnergy(int energy) {
        if (energy < 0) energy = 0;
        if (energy > maxEnergy) energy = maxEnergy;
        this.energy = energy;
    }
    public void setMaxEnergy(int maxEnergy){ this.maxEnergy = maxEnergy; }
    public boolean hasUsedReviveTrial() {
        return reviveUsed;
    }
    public void setReviveUsed(boolean reviveUsed) {
        this.reviveUsed = reviveUsed;
    }
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
        String energyLabel;

        int weaponAtkBonus = (getWeapon() != null) ? getWeapon().getAtkBuff() : 0;
        int armorDefBonus  = (getArmor() != null) ? getArmor().getDefBuff() : 0;

        int effectAtkMod = attack - (baseAttack + weaponAtkBonus);
        int effectDefMod = defense - (baseDefense + armorDefBonus);

        String atkLabel = (effectAtkMod >= 0) ? "Buff" : "Debuff";
        String defLabel = (effectDefMod >= 0) ? "Buff" : "Debuff";

        // Choose header emoji based on class
        String classEmoji;
        if (classType.equalsIgnoreCase("Mage")) {
            classEmoji = "🔮"; // Staff / magic emoji
        } else if (classType.equalsIgnoreCase("Archer")) {
            classEmoji = "🏹"; // Bow / archer emoji
        } else {
            classEmoji = "🛡️"; // Default warrior/shield
        }

        // Print the header
        System.out.println();
        System.out.println(ColorUtil.boldBrightCyan("┌─────────────────── " + classEmoji + " PLAYER STATS " + classEmoji +" ───────────────────┐"));

        // Determine energy type
        if (classType.equalsIgnoreCase("Mage")) {
            energyLabel = " 💧 Mana    ";
        } else if (classType.equalsIgnoreCase("Archer")) {
            energyLabel = " 🏹 Arrows  ";
        } else {
            energyLabel = " 🔋 Stamina ";
        }

        System.out.println(ColorUtil.boldBrightCyan(" 👤 Name/Class  :  ") + ColorUtil.boldBrightYellow(name + " (" + classType + ")"));

        if (level == 30) {
            System.out.println(ColorUtil.boldBrightCyan(" 🏆 Level       :  ") + ColorUtil.boldBrightYellow("MAX"));
            System.out.println(ColorUtil.boldBrightCyan(" ✨ EXP         :  ") + ColorUtil.boldBrightYellow("MAX"));
        } else {
            System.out.println(ColorUtil.boldBrightCyan(" 🏆 Level       :  ") + ColorUtil.boldBrightYellow(String.valueOf(level)));
            System.out.println(ColorUtil.boldBrightCyan(" ✨ EXP         :  ") + ColorUtil.boldBrightYellow(exp + " / " + nextLevelExp));
        }

        System.out.println(ColorUtil.boldBrightCyan(" 💚 HP          :  ") + ColorUtil.boldBrightYellow(hp + " / " + maxHP));
        System.out.println(ColorUtil.boldBrightCyan(energyLabel + "    :  ") + ColorUtil.boldBrightYellow(energy + " / " + maxEnergy));

        System.out.println(ColorUtil.boldBrightCyan(" ⚔️ Attack      :  ") +
                ColorUtil.boldBrightYellow(attack +
                        " (Base " + baseAttack +
                        " | Weapon " + String.format("%+d", weaponAtkBonus) +
                        " | " + atkLabel + " " + String.format("%+d", effectAtkMod) + ")"));

        System.out.println(ColorUtil.boldBrightCyan(" 🛡️ Defense     :  ") +
                ColorUtil.boldBrightYellow(defense +
                        " (Base " + baseDefense +
                        " | Armor " + String.format("%+d", armorDefBonus) +
                        " | " + defLabel + " " + String.format("%+d", effectDefMod) + ")"));

        System.out.println(ColorUtil.boldBrightCyan("└───────────────────────────────────────────────────────────┘"));
        System.out.println();
    }



    public abstract void displaySkills();
    public abstract void turn (Character target);

    public void displayMenu(Character player, Character enemy){
        boolean goBack = false;

        while(!goBack){
            System.out.println("[1] \uD83C\uDF92 Open Inventory");
            System.out.println("[2] \uD83E\uDDD1 Show Player Stats");
            System.out.println("[3] \uD83D\uDCD6 Show Player Skills Overview");
            System.out.println("[4] \uD83D\uDC79 Show Enemy Stats");
            System.out.println("[5] \uD83D\uDCDD Show Enemy Skills Overview");
            System.out.println("[6] ❌ Quit Game");
            System.out.println("[0] \uD83D\uDD19 Go back");

            System.out.print("Enter choice: ");
            int choice = InputUtil.scanInput();
            PrintUtil.line();

            switch (choice){
                case 1 -> player.getInventory().openInventory();
                case 2 -> player.displayStats();
                case 3 ->  player.displaySkills();
                case 4 -> enemy.displayStats();
                case 5 -> enemy.displaySkills();
                case 6 -> StoryEngine.quitGame();
                case 0 -> goBack = true;
                default -> System.out.println("❌ Invalid input! Please select a valid option.");
            }
        }
    }

    public void displayMenu(Character player){
        boolean goBack = false;

        while(!goBack){
            System.out.println("[1] \uD83C\uDF92 Open Inventory");
            System.out.println("[2] \uD83E\uDDD1 Show Player Stats");
            System.out.println("[3] \uD83D\uDCD6 Show Player Skills Overview");
            System.out.println("[4] ❌ Quit Game");
            System.out.println("[0] \uD83D\uDD19 Go back");

            System.out.print("Enter choice: ");
            int choice = InputUtil.scanInput();
            PrintUtil.line();

            switch (choice){
                case 1 -> player.getInventory().openInventory();
                case 2 -> player.displayStats();
                case 3 ->  player.displaySkills();
                case 4 -> StoryEngine.quitGame();
                case 0 -> goBack = true;
                default -> System.out.println("❌ Invalid input! Please select a valid option.");
            }
        }
    }

    public int calculateDamage(Character target, int damage) {
        int reduced = damage;

        // Critical hit check using your utility
        if (RandomUtil.chance(15)) { // 20% crit chance
            reduced = (int)(reduced * 1.5);
            System.out.println(ColorUtil.brightMagenta("💥 Critical hit! Damage multiplied by 1.5x"));
        }

        // FinalBoss shield logic
        if (target instanceof FinalBoss fb && fb.getShield() > 0) {
            if (reduced >= fb.getShield()) {
                int absorbed = fb.getShield();
                fb.reduceShield(absorbed); // triggers shieldBroken
                reduced -= absorbed;
            } else {
                fb.reduceShield(reduced); // just reduce shield
                reduced = 0; // all damage absorbed
            }
        }

        // Apply defense
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
            case "Swordsman" -> restoreAmount = 10;
            case "Archer" -> restoreAmount = 3;
            case "Mage" -> restoreAmount = 20;
            default -> restoreAmount = 15;
        }

        int oldHp = hp;
        int oldEnergy = energy;

        energy += restoreAmount;
        if (energy > maxEnergy) energy = maxEnergy;

        hp += (int)(maxHP * 0.05);
        if (hp > maxHP) hp = maxHP;

        System.out.println("✨ Turn skipped! Restored a bit of HP and " + getEnergyName() + ".");
        PrintUtil.pause(800);
        System.out.println("💖 HP: " + oldHp + " → " + hp + " | " + getEnergyEmoji() + " " + getEnergyName() + ": " + oldEnergy + " → " + energy);
        PrintUtil.pause(800);

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
        System.out.println(ColorUtil.brightYellow("  ✨ Gained " + amount + " XP!"));
        System.out.println(ColorUtil.boldBrightYellow("┴───────────────────────────────────┴"));
        InputUtil.pressEnterToContinue();
        System.out.println();

        while(level < XP_TABLE.length && exp >= nextLevelExp){
            levelUp();
        }
    }

    public void levelUp() {
        if(level < 30){
            level++;
            PrintUtil.hr();
            PrintUtil.specialCyan("✨ LEVEL UP! You are now Level " + level + "! ✨");
            PrintUtil.specialCyan("25% of 💖 HP & " + getEnergyEmoji() + " " + getEnergyName() + " Restored!");

            int oldHp = maxHP;
            int oldAtk = baseAttack;
            int oldDef = baseDefense;

            switch (classType) {
                case "Swordsman" -> {
                    maxHP += 90 + (int)(maxHP * 0.01);
                    baseAttack += 2 + StoryEngine.getCurrWorldLevel();
                    baseDefense += 2;
                }
                case "Archer" -> {
                    maxHP += 70 + (int)(maxHP * 0.01);
                    baseAttack += 3 + StoryEngine.getCurrWorldLevel();
                    baseDefense += 1;
                }
                case "Mage" -> {
                    maxHP += 50 + (int)(maxHP * 0.01);
                    baseAttack += 4 + StoryEngine.getCurrWorldLevel();
                    baseDefense += 1;
                }
            }

            hp += (int)(maxHP * 0.25);
            if (hp > maxHP) hp = maxHP;

            energy += (int)(maxEnergy * 0.25);
            if (energy > maxEnergy) energy = maxEnergy;

            exp -= nextLevelExp;
            if (level < XP_TABLE.length) nextLevelExp = XP_TABLE[level];

            recalculateBuffs();

            PrintUtil.specialCyan(String.format("%-8s : +%d → %d%n", "💚 HP", (maxHP - oldHp), maxHP));
            PrintUtil.specialCyan(String.format("%-8s : +%d → %d%n", "⚔️ ATK", (baseAttack - oldAtk), attack));
            PrintUtil.specialCyan(String.format("%-8s  : +%d → %d%n", "🛡️ DEF", (baseDefense - oldDef), defense));
            PrintUtil.hr();
            System.out.println();
            PrintUtil.pause(800);
        }
    }

    public void recalculateBuffs(){
        attack = baseAttack + getWeapon().getAtkBuff();
        defense = baseDefense + getArmor().getDefBuff() + getArmor().getAddDefBuff();
    }

    public void lootSoulShards(int dropped) {
        System.out.println(ColorUtil.brightYellow("  💠 " + dropped + " Soul Shard" + (dropped > 1 ? "s" : "")));
        soulShards += dropped;
    }

    public void subtractSoulShards(int amount) {
        if (amount <= 0) return; // nothing to subtract
        if (soulShards < amount) soulShards = 0; // prevent negative
        else soulShards -= amount;
    }


}
