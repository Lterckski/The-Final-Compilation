package inventory;

import characters.Character;
import utils.RandomUtil;

public class Bow extends Weapon{
    private final int attackTwiceChance;
    private final int lifestealPercent;

    public static final Bow WOODEN_BOW = new Bow("Wooden Bow","⚪", 0 , 0, 0);
    public static final Bow OAK_LONGBOW = new Bow("Oak Longbow","🟢", 5 , 0, 0);
    public static final Bow TWINSHOT_BOW = new Bow("Twinshot Bow","🔵", 15, 10,0);
    public static final Bow LIFEBLOOM_BOW = new Bow("Lifebloom Bow", "🔵", 15, 0, 3);
    public static final Bow AETHERSTRIKE_BOW = new Bow("Aetherstrike Bow", "🟣", 30, 25, 5);
    public static final Bow GOLDEN_TALON = new Bow("Golden Talon", "🟡", 50, 35, 10);

    public Bow(String name, String rarity, int atkBuff, int twiceAttackChance, int lifestealPercent){
        super(name,rarity,atkBuff);
        this.attackTwiceChance = twiceAttackChance;
        this.lifestealPercent = lifestealPercent;
    }

    @Override
    public void displayInfo() {
        System.out.println("-----------------------------");
        System.out.println("🏹 " + getName() + " [" + getRarity() + "]");
        System.out.println("+ " + getAtkBuff() + " ATK");

        if (attackTwiceChance > 0) {
            System.out.println("🎯 " + attackTwiceChance + "% chance to attack twice");
        }

        if (lifestealPercent > 0) {
            System.out.println("💝 Restores " + lifestealPercent + "% HP of damage dealt");
        }

        System.out.println("-----------------------------");
    }

    @Override
    public boolean applyEffects(Character target, int damage) {
        // Lifesteal
        if (lifestealPercent > 0) {
            int heal = (int)(damage * lifestealPercent / 100.0);
            System.out.println("💖 " + getName() + " restores " + heal + " HP!");
            target.heal(heal);
        }

        // Double attack
        if (RandomUtil.chance(attackTwiceChance)) {
            System.out.println("⚡ " + getName() + " triggers a second attack!");
            return true;
        }

        return false; // no second attack is triggered
    }

}
