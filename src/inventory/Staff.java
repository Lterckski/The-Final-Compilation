package inventory;

import characters.Character;
import utils.RandomUtil;

public class Staff extends Weapon{
    private final int confuseChance;
    private final int lifestealPercent;

    public Staff(String name, String rarity, int atkBuff, int confuseChance, int lifestealPercent){
        super(name,rarity,atkBuff);
        this.confuseChance = confuseChance;
        this.lifestealPercent = lifestealPercent;
    }

    @Override
    public void displayInfo() {
        System.out.println("-----------------------------");
        System.out.println("🔮 " + getName() + " [" + getRarity() + "]");
        System.out.println("+ " + getAtkBuff() + " ATK");

        if (confuseChance > 0) {
            System.out.println("🌀 " + confuseChance + "% chance to confuse enemy");
        }

        if (lifestealPercent > 0) {
            System.out.println("💖 Restores " + lifestealPercent + "% HP of damage dealt");
        }

        System.out.println("-----------------------------");
    }

    @Override
    public boolean applyEffects(Character target, int damage) {
        // Confuse target
        if(RandomUtil.chance(confuseChance)){
            target.getEffects().applyConfuse();
        }

        // Lifesteal
        if (lifestealPercent > 0) {
            int heal = (int)(damage * lifestealPercent / 100.0);
            System.out.println("💖 " + getName() + " restores " + heal + " HP!");
            target.heal(heal);
        }

        return true; // not really used for anything (boolean just for consistency)
    }

}
