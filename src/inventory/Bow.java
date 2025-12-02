package inventory;

import characters.Character;
import enemies.Enemy;
import utils.ColorUtil;
import utils.InputUtil;
import utils.PrintUtil;
import utils.RandomUtil;

import java.util.Map;

public class Bow extends Weapon{
    private final int attackTwiceChance;

    public static final Bow WOODEN_BOW = new Bow("Wooden Bow","⚪", 0 , 0, 0);
    public static final Bow OAK_LONGBOW = new Bow("Oak Longbow","🟢", 5 , 0, 0);
    public static final Bow TWINSHOT_BOW = new Bow("Twinshot Bow","🔵", 15, 10,0);
    public static final Bow LIFEBLOOM_BOW = new Bow("Lifebloom Bow", "🔵", 15, 0, 3);
    public static final Bow AETHERSTRIKE_BOW = new Bow("Aetherstrike Bow", "🟣", 30, 25, 5);
    public static final Bow GOLDEN_TALON = new Bow("Golden Talon", "🟡", 50, 35, 10);

    public Bow(String name, String rarity, int atkBuff, int twiceAttackChance, int lifestealPercent){
        super(name,rarity,atkBuff);
        this.attackTwiceChance = twiceAttackChance;
        this.setLifestealPercent(lifestealPercent);
    }

    @Override
    public void displayInfo() {
        System.out.println();
        System.out.println(ColorUtil.boldBrightCyan("═════════════════════════════════════"));
        System.out.println(ColorUtil.boldBrightYellow(" 🏹 " + getName() + " [" + getRarity() + "]"));
        System.out.println(ColorUtil.boldBrightYellow("  + " + getAtkBuff() + " ATK"));

        if (getLifestealPercent() > 0) {
            System.out.println(ColorUtil.boldBrightYellow(" 💝 Restores " + getLifestealPercent() + "% HP of damage dealt"));
        }

        if (attackTwiceChance > 0) {
            System.out.println(ColorUtil.boldBrightYellow(" 🎯 " + attackTwiceChance + "% chance to deal extra damage"));
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
                System.out.println("💖 " + this.getName() + " restores " + healAmount + " HP!");
                PrintUtil.pause(800);
                player.heal(healAmount);
            }
        }

        // ☠️ Poison
        if (RandomUtil.chance(getFreezeChance())) {
            enemy.getEffects().applyPoison(2);
        }

        // 🩸 Bleed
        if (RandomUtil.chance(getFreezeChance())) {
            enemy.getEffects().applyBleed(2);
        }

        // ⚡ Extra hit (Double attack)
        if (RandomUtil.chance(attackTwiceChance)) {
            System.out.println(ColorUtil.brightMagenta("⚡ Weapon effect activated! Extra hit triggered!"));
            PrintUtil.pause(800);
            int extraDamage = (int) RandomUtil.range(damage * 0.20, damage * 0.40);
            System.out.println(
                    ColorUtil.brightMagenta("➶ Extra hit from weapon for ")
                            + ColorUtil.boldBrightWhite(extraDamage + "")
                            + ColorUtil.brightMagenta(" damage!")
            );
            PrintUtil.pause(800);
            enemy.takeDamage(extraDamage);
        }

        // ❄️ Freeze
        if (RandomUtil.chance(getFreezeChance())) {
            enemy.getEffects().applyFreeze();
        }

    }

}
