package inventory;

import characters.Character;
import enemies.Enemy;
import utils.ColorUtil;
import utils.InputUtil;
import utils.PrintUtil;
import utils.RandomUtil;

import java.util.Map;
import java.util.Random;

public class Staff extends Weapon{
    private final int confuseChance;

    public static final Staff WOODEN_STAFF = new Staff("Wooden Staff", "⚪", 0, 0, 0);
    public static final Staff APPRENTICE_STAFF = new Staff("Apprentice's Staff", "🟢", 5, 0, 0);
    public static final Staff MYSTIC_MIND_STAFF = new Staff("Mystic Mind Staff", "🔵", 15, 30, 0);
    public static final Staff FLAMEHEART_STAFF = new Staff("Flameheart Staff", "🔵", 15, 0, 3);
    public static final Staff AETHERIC_STAFF = new Staff("Aetheric Staff", "🟣", 30, 25, 10);
    public static final Staff CHRONOMANCER_STAFF = new Staff("Chronomancer Staff", "🟡", 50, 35, 10);

    public Staff(String name, String rarity, int atkBuff, int confuseChance, int lifestealPercent){
        super(name,rarity,atkBuff);
        this.confuseChance = confuseChance;
        setLifestealPercent(lifestealPercent);
    }

    @Override
    public void displayInfo() {
        System.out.println();
        System.out.println(ColorUtil.boldBrightCyan("═════════════════════════════════════"));
        System.out.println(ColorUtil.boldBrightYellow(" 🔮 " + getName() + " [" + getRarity() + "]"));
        System.out.println(ColorUtil.boldBrightYellow("  + " + getAtkBuff() + " ATK"));

        if (getLifestealPercent() > 0) {
            System.out.println(ColorUtil.boldBrightYellow(" 💝 Restores " + getLifestealPercent() + "% HP of damage dealt"));
        }

        if (confuseChance > 0) {
            System.out.println(ColorUtil.boldBrightYellow(" 🌀 " + confuseChance + "% chance to confuse enemy"));
        }

        if (!getEnchantments().isEmpty()) {
            System.out.println(ColorUtil.boldBrightYellow(" ✨ Enchantments:"));
            for (Map.Entry<String, String> enchant : getEnchantments().entrySet()) {
                System.out.println(ColorUtil.boldBrightYellow("   - " + enchant.getKey() + " " + enchant.getValue()));
            }
        }

        System.out.println(ColorUtil.boldBrightCyan("═════════════════════════════════════"));
        System.out.println();
    }


    @Override
    public void applyEffects(Character player, Character enemy, int damage) {
        // 💖 Lifesteal
        if (getLifestealPercent() > 0) {
            int healAmount = (int) (damage * (getLifestealPercent()+getAddLifestealPercent()) / 100.0);
            healAmount = Math.min(healAmount, player.getMaxHP() - player.getHp());
            if (healAmount > 0) {
                System.out.println(ColorUtil.boldBrightMagenta("💖 " + this.getName() + " restores " + healAmount + " HP!"));
                PrintUtil.pause(800);
                player.heal(healAmount);
            }
        }

        // ☠️ Poison
        if (RandomUtil.chance(getPoisonChance())) {
            enemy.getEffects().applyPoison(2);
        }

        // ⚡ Arc Surge - Energy boost per attack
        if (getEnergyPerAttack() > 0) {
            int before = player.getEnergy();
            player.restoreEnergy(getEnergyPerAttack());
            int after = player.getEnergy();

            System.out.println(ColorUtil.boldBrightMagenta("✨ Restored " + getEnergyPerAttack() + " Mana! " + "(💧 " + before + " → " + after + ")"));
            PrintUtil.pause(800);
        }

        if(RandomUtil.chance(confuseChance)){
            enemy.getEffects().applyConfuse();
        }

    }

}
