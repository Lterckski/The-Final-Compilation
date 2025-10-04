package characters;

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

    // 1 turn Pre-turn Effects
    private boolean isFrozen = false;
    private boolean isStunned = false;
    private boolean isImmobilized = false;
    private boolean isConfused = false;
    private boolean isFeared  = false;
    private boolean isNimble = false;
    // Multi-Turn Effects
    protected int poisonTurnsLeft = 0;
    protected int bleedTurnsLeft = 0;
    protected int burnTurnsLeft = 0;

    // ATK & DEF Modifiers
    protected int atkBuffModifier = 0;
    protected int atkDebuffModifier = 0;
    protected int defBuffModifier = 0;
    protected int defDebuffModifier = 0;

    protected int atkBuffTurnsLeft = 0;
    protected int atkDebuffTurnsLeft = 0;
    protected int defBuffTurnsLeft = 0;
    protected int defDebuffTurnsLeft = 0;

    public Character(String name, int hp, int defense, int energy, int attack) { // for players
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.defense = defense;
        this.energy = energy;
        this.maxEnergy = energy;
        this.attack = attack;
    }

    public Character(String name, int hp, int defense) { // for enemies
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.defense = defense;
    }

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

    //GETTERS
    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getDefense() { return defense; }
    public int getEnergy() { return energy; }
    public int getLevel() { return level; }

    public abstract void turn (Character target);

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) hp = 0;
        System.out.println("❤\uFE0F " + name + " (HP : " + hp + "/" + maxHp + ")");
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public boolean consumeEnergy(int cost) {
        if (energy < cost) {
            energy = 0;
            return false; // not enough energy
        }
        energy -= cost;
        return true; // successful
    }

    public void skipTurn(){
        energy += (int) (maxEnergy * 0.10);
        if(energy > maxEnergy) energy = maxEnergy;
        System.out.println("Turn skipped! Restored a bit of energy. (Energy: " + energy + "/" + maxEnergy + ")");
    }

    public void applyFreeze() {
        isFrozen = true;
    }
    public void applyStun() {
        isStunned = true;
    }
    public void applyImmobilize() {
        isImmobilized = true;
    }
    public void applyConfuse() {
        isConfused = true;
    }
    public void applyFear() {
        isFeared = true;
        isConfused = true; // fear applies to confuse too
    }

    public void applyNimble(){
        isNimble = true;
    }

    public boolean checkEffects(){
        if(isFrozen){
            System.out.println(name + " is Frozen.");
            InputUtil.pressEnterToContinue();
            isFrozen = false;
            return false;
        } else if(isStunned){
            System.out.println(name + " is Stunned.");
            InputUtil.pressEnterToContinue();
            isStunned = false;
            return false;
        } else if(isImmobilized){
            System.out.println(name + " is Immobilized. Can only regain energy.");
            InputUtil.pressEnterToContinue();
            skipTurn();
            isImmobilized = false;
            return false;
        } else if(isFeared){
            System.out.println(name + " is Feared. Can only regain energy.");
            InputUtil.pressEnterToContinue();
            skipTurn();
            isFeared = false;
            return false;
        }

        return true;
    }

    public boolean checkConfuse(){
        if(isConfused){
            double chance = Math.random();
            if(chance < 0.3){
                System.out.println("You missed the attack due to confusion!");
                return true;
            }
            isConfused = false;
        }
        return false;
    }

    public boolean checkDodge(){
        if(isNimble){
            double chance = Math.random();
            if(chance < 0.3){
                System.out.println("You dodged the attack due to Nimble!");
                isNimble = false;
                return true;
            }
            isNimble = false;
        }
        return false;
    }

    public void updateDoTEffects(){
        if(poisonTurnsLeft > 0){
            takeDamage(5);
            System.out.println("Poison applied! Took 5 damage.");
            poisonTurnsLeft--;
        }
        if(bleedTurnsLeft > 0){
            takeDamage(5);
            System.out.println("Bleed applied! Took 5 damage");
        }
        if(burnTurnsLeft > 0){
            takeDamage(5);
            System.out.println("Burn applied! Took 5 damage.");
        }
    }

    public void applyAttackBuff(int amount, int duration){
        atkBuffModifier = amount;
        attack += atkBuffModifier;
        atkBuffTurnsLeft = duration;
    }
    public void applyAttackDebuff(int amount, int duration){
        atkDebuffModifier = amount;
        attack -= atkDebuffModifier;
        atkDebuffTurnsLeft = duration;
    }
    public void applyDefenseBuff(int amount, int duration){
        defBuffModifier = amount;
        defense += defBuffModifier;
        defBuffTurnsLeft = duration;
    }
    public void applyDefenseDebuff(int amount, int duration){
        defDebuffModifier = amount;
        defense -= defDebuffModifier;
        defDebuffTurnsLeft = duration;
    }

    public void updateModifiers(){
        if(atkBuffTurnsLeft > 0){
            atkBuffTurnsLeft--;
            if(atkBuffTurnsLeft == 0){
                attack -= atkBuffModifier;
                atkBuffModifier = 0;
                System.out.println(name + "'s attack returns to normal.");
            }
        }
        if(atkDebuffTurnsLeft > 0){
            atkDebuffTurnsLeft--;
            if(atkDebuffTurnsLeft == 0){
                attack += atkDebuffModifier;
                atkDebuffModifier = 0;
                System.out.println(name + "'s attack returns to normal.");
            }
        }
        if(defBuffTurnsLeft > 0){
            defBuffTurnsLeft--;
            if(defBuffTurnsLeft == 0){
                defense -= defBuffModifier;
                defBuffModifier = 0;
                System.out.println(name + "'s defense returns to normal.");
            }
        }
        if(defDebuffTurnsLeft > 0){
            defDebuffTurnsLeft--;
            if(defDebuffTurnsLeft == 0){
                defense += defDebuffModifier;
                defDebuffModifier = 0;
                System.out.println(name + "'s defense returns to normal.");
            }
        }
    }

    public void heal(int amount){
        hp += amount;
        if(hp > maxHp) maxHp = hp;
        System.out.println(name + " healed for " + amount + " hp. (HP : " + hp + "/" + maxHp + ")");
    }


}
