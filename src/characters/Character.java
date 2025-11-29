package characters;

import battle.Effects;
import enemies.FinalBoss;
import inventory.Armor;
import inventory.Inventory;
import inventory.Potions;
import inventory.Weapon;
import utils.InputUtil;
import utils.PrintUtil;

import java.sql.SQLOutput;

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
        System.out.println("\n┌─────────────────── " + classEmoji + " " + "PLAYER STATS " + classEmoji +" ───────────────────┐");



        // Determine energy type
        if (classType.equalsIgnoreCase("Mage")) {
            energyLabel = " 💧 Mana    ";
        } else if (classType.equalsIgnoreCase("Archer")) {
            energyLabel = " 🏹 Arrows  ";
        } else {
            energyLabel = " 🔋 Stamina ";
        }

        if (level == 30) {
            System.out.println("🏆 Level      : MAX");
            System.out.println("✨ EXP        : MAX");
        } else {

        }

        System.out.println(" 👤 Name/Class : " + name + " (" + classType + ")");


        System.out.println(" 🏆 Level      : " + level);
        System.out.println(" ✨ EXP        : " + exp + " / " + nextLevelExp);

        System.out.println(" ❤️ HP         : " + hp + " / " + maxHP);
        System.out.println(energyLabel + "   : " + energy + " / " + maxEnergy);



        System.out.println(" ⚔️ Attack     : " + attack +
                " (Base " + baseAttack +
                " | Weapon " + String.format("%+d", weaponAtkBonus) +
                " | " + atkLabel + " " + String.format("%+d", effectAtkMod) + ")");

        System.out.println(" 🛡️ Defense    : " + defense +
                "  (Base " + baseDefense +
                " | Armor " + String.format("%+d", armorDefBonus) +
                " | " + defLabel + " " + String.format("%+d", effectDefMod) + ")");
            System.out.println("└───────────────────────────────────────────────────────────┘");
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
                case 6 -> player.quitGame();
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
            System.out.println("[0] \uD83D\uDD19 Go back");

            System.out.print("Enter choice: ");
            int choice = InputUtil.scanInput();
            PrintUtil.line();

            switch (choice){
                case 1 -> player.getInventory().openInventory();
                case 2 -> player.displayStats();
                case 3 ->  player.displaySkills();
                case 0 -> goBack = true;
                default -> System.out.println("❌ Invalid input! Please select a valid option.");
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
        System.out.println("  ✨ Gained " + amount + " XP!");
        System.out.println("┴───────────────────────────────────┴");
        InputUtil.pressEnterToContinue();
        while(level < XP_TABLE.length && exp >= nextLevelExp){
            levelUp();
        }
    }

    public void levelUp() {
        if(level < 30){
            level++;
            PrintUtil.hr();
            System.out.println("✨ LEVEL UP! You are now Level " + level + "! ✨");
            System.out.println("💖 HP & " + getEnergyEmoji() + " " + getEnergyName() + " Restored!");

            int oldHp = maxHP;
            int oldAtk = baseAttack;
            int oldDef = baseDefense;
            int oldEnergy = maxEnergy;

            switch (classType) {
                case "Swordsman" -> {
                    maxHP += 100 + (int)(maxHP * 0.02);
                    baseAttack += 2;
                    baseDefense += 2;
                    maxEnergy += 5;
                }
                case "Archer" -> {
                    maxHP += 70 + (int)(maxHP * 0.02);
                    baseAttack += 4;
                    baseDefense += 1;
                    if (level % 10 == 0) {
                        maxEnergy += 8;
                    }
                }
                case "Mage" -> {
                    maxHP += 50 + (int)(maxHP * 0.015);
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

            System.out.printf("%-8s : +%d → %d%n", "💚 HP", (maxHP - oldHp), maxHP);
            System.out.printf("%-8s : +%d → %d%n", "⚔️ ATK", (baseAttack - oldAtk), attack);
            System.out.printf("%-8s : +%d → %d%n", "🛡️ DEF", (baseDefense - oldDef), defense);
            System.out.printf("%-8s : +%d → %d%n", getEnergyEmoji() + " " + getEnergyName(),
                    (maxEnergy - oldEnergy), maxEnergy);
            PrintUtil.hr();
            PrintUtil.pause(800);
        }
    }

    public void recalculateBuffs(){
        attack = baseAttack + getWeapon().getAtkBuff();
        defense = baseDefense + getArmor().getDefBuff();
    }

    public void lootSoulShards(int dropped) {
        System.out.println("  💠 " + dropped + " Soul Shard" + (dropped > 1 ? "s" : ""));
        soulShards += dropped;
    }

    public void subtractSoulShards(int amount) {
        if (amount <= 0) return; // nothing to subtract
        if (soulShards < amount) soulShards = 0; // prevent negative
        else soulShards -= amount;
    }


    // ✅ Quit Game with Confirmation
    public static void quitGame() {
        while (true) {  // Loop until valid confirmation
            System.out.println("\nTo confirm exit, type exactly:");
            System.out.println("\"OBJECT ORIENTED PROGRAMMING\"");
            System.out.println("Or type exactly \"CANCEL\" to return to the game.");
            System.out.print("Enter input: ");

            try {
                String input = InputUtil.scan.nextLine();

                if (input.equals("OBJECT ORIENTED PROGRAMMING")) {  // ✅ Exact match required
                    System.out.println("\n=================================");
                    System.out.println("  Thank you for playing!");
                    System.out.println("  Your journey ends here...");
                    System.out.println("=================================\n");
                    System.exit(0);   // terminate program safely
                }
                else if (input.equals("CANCEL")) {  // ✅ Exact match required
                    System.out.println("Returning to game...");
                    break;  // safely return to game
                }
                else {
                    System.out.println("Invalid input. Please type the exact phrase or CANCEL.\n");
                }

            } catch (Exception e) {
                System.out.println("Input error detected. Exit cancelled for safety.\n");
            }
        }
    }

}
