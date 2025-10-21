package inventory;

import characters.Character;
import utils.RandomUtil;

public class Sword extends Weapon{
    private final int attackTwiceChance;
    private final int lifestealPercent;

    public static final Sword OLD_BROADSWORD = new Sword("Old Broadsword", "⚪", 0, 0, 0);
    public static final Sword IRON_SHORTSWORD = new Sword("Iron Shortsword", "🟢", 5, 0, 0);
    public static final Sword TWINSTRIKE_BLADE =  new Sword("Twinstrike Blade", "🔵", 15, 10, 0);
    public static final Sword LIFEBOND_BLADE =  new Sword("Lifebond Blade", "🔵", 15, 0, 3);
    public static final Sword ECLIPSE_GREATSWORD =  new Sword("Eclipse Greatsword", "🟣", 30, 25, 5);
    public static final Sword CELESTIAL_EDGE = new Sword("Celestial Edge", "🟡", 50, 35, 10);

    public Sword(String name, String rarity, int atkBuff, int twiceAttackChance, int lifestealPercent){
        super(name,rarity,atkBuff);
        this.attackTwiceChance = twiceAttackChance;
        this.lifestealPercent = lifestealPercent;
    }

    @Override
    public void displayInfo() {
        System.out.println("-----------------------------");
        System.out.println("🗡️ " + getName() + " [" + getRarity() + "]");
        System.out.println("+ " + getAtkBuff() + " ATK");

        if (attackTwiceChance > 0) {
            System.out.println("⚡ " + attackTwiceChance + "% chance to attack twice");
        }

        if (lifestealPercent > 0) {
            System.out.println("💝 Restores " + lifestealPercent + "% HP of damage dealt");
        }

        System.out.println("-----------------------------");
    }

    @Override
    public boolean applyEffects(Character target, int damage) {
        // Double attack
        if (RandomUtil.chance(attackTwiceChance)) {
            System.out.println("⚡ " + getName() + " triggers a second attack!");
            return true;
        }

        // Lifesteal
        if (lifestealPercent > 0) {
            int heal = (int)(damage * lifestealPercent / 100.0);
            System.out.println("💖 " + getName() + " restores " + heal + " HP!");
            target.heal(heal);
        }

        return false; // no second attack is triggered
    }

}
