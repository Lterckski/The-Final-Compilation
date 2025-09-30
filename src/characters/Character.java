package characters;

public abstract class Character {
    protected String name;
    protected int level;
    protected int hp;
    protected int maxHp;           // track max HP for healing
    protected int defense;
    protected int energy;
    protected int maxEnergy;       // track max energy
    protected int attack;

    public Character(String name, int hp, int defense, int energy, int attack) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.defense = defense;
        this.energy = energy;
        this.maxEnergy = energy;
        this.attack = attack;
        this.level = 1; // default starting level
    }

    public Character(String name, int hp, int defense) { // for enemies
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.defense = defense;
    }

    public void showStats() {
        System.out.println("=========== Stats ============");
        System.out.println("Name    : " + name);
        System.out.println("Level   : " + level);
        System.out.println("Health  : " + hp + "/" + maxHp);
        System.out.println("Energy  : " + energy + "/" + maxEnergy);
        System.out.println("Defense : " + defense);
        System.out.println("Attack  : " + attack);
        System.out.println("==============================");
    }

    //GETTERS
    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getDefense() { return defense; }
    public int getEnergy() { return energy; }
    public int getLevel() { return level; }

    public void takeDamage(int damage) {           //0 is passed if defense is ignored
        hp -= damage;
        if (hp < 0) hp = 0;
        System.out.println(name + " HP : " + hp + "/" + maxHp);
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void heal(int amount) {
        hp += amount;
        if (hp > maxHp) hp = maxHp; // clamp to max
        System.out.println("You healed " + amount + " HP. (HP: " + hp + "/" + maxHp + ")");
    }

    public boolean consumeEnergy(int cost) {
        if (energy < cost) {
            energy = 0;
            return false; // not enough energy
        }
        energy -= cost;
        return true; // successful
    }
}
