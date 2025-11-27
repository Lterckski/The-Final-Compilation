package inventory;

import characters.Character;
import utils.PrintUtil;
import utils.RandomUtil;

public class Staff extends Weapon{
    private final int confuseChance;
    private final int lifestealPercent;

    public static final Staff WOODEN_STAFF = new Staff("Wooden Staff", "⚪", 0, 0, 0);
    public static final Staff APPRENTICE_STAFF = new Staff("Apprentice's Staff", "🟢", 5, 0, 0);
    public static final Staff MYSTIC_MIND_STAFF = new Staff("Mystic Mind Staff", "🔵", 15, 30, 0);
    public static final Staff FLAMEHEART_STAFF = new Staff("Flameheart Staff", "🔵", 15, 0, 3);
    public static final Staff AETHERIC_STAFF = new Staff("Aetheric Staff", "🟣", 30, 25, 10);
    public static final Staff CHRONOMANCER_STAFF = new Staff("Chronomancer Staff", "🟡", 50, 35, 10);

    public Staff(String name, String rarity, int atkBuff, int confuseChance, int lifestealPercent){
        super(name,rarity,atkBuff);
        this.confuseChance = confuseChance;
        this.lifestealPercent = lifestealPercent;
    }

    @Override
    public void displayInfo() {
        System.out.println("╠═══════════════════════════════╣");
        System.out.println(" 🔮 " + getName() + " [" + getRarity() + "]");
        System.out.println("  + " + getAtkBuff() + " ATK");

        if (confuseChance > 0) {
            System.out.println(" 🌀 " + confuseChance + "% chance to confuse enemy");
        }

        if (lifestealPercent > 0) {
            System.out.println(" 💝 Restores " + lifestealPercent + "% HP of damage dealt");
        }

        System.out.println("╩═══════════════════════════════╩");
    }

    @Override
    public boolean applyEffects(Character player, int damage) {
        // Confuse target
        if(RandomUtil.chance(confuseChance)){
            return true;
        }

        // Lifesteal
        if (lifestealPercent > 0) {
            int healAmount = (int)(damage * lifestealPercent / 100.0);
            System.out.println("💖 " + getName() + " restores " + healAmount + " HP!");
            PrintUtil.pause(800);
            player.heal(healAmount);
        }

        return false;
    }

}
