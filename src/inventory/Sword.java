package inventory;

import characters.Character;
import enemies.Enemy;
import utils.ColorUtil;
import utils.InputUtil;
import utils.PrintUtil;
import utils.RandomUtil;

import java.awt.*;
import java.util.Map;

public class Sword extends Weapon{
    private final int attackTwiceChance;

    public static final Sword OLD_BROADSWORD = new Sword("Old Broadsword", "⚪", 0, 0, 0);
    public static final Sword IRON_SHORTSWORD = new Sword("Iron Shortsword", "🟢", 5, 0, 0);
    public static final Sword TWINSTRIKE_BLADE =  new Sword("Twinstrike Blade", "🔵", 15, 10, 0);
    public static final Sword LIFEBOND_BLADE =  new Sword("Lifebond Blade", "🔵", 15, 0, 3);
    public static final Sword ECLIPSE_GREATSWORD =  new Sword("Eclipse Greatsword", "🟣", 30, 25, 5);
    public static final Sword CELESTIAL_EDGE = new Sword("Celestial Edge", "🟡", 50, 35, 10);

    public Sword(String name, String rarity, int atkBuff, int twiceAttackChance, int lifestealPercent){
        super(name,rarity,atkBuff);
        this.attackTwiceChance = twiceAttackChance;
        this.setLifestealPercent(lifestealPercent);
    }

    @Override
    public void displayInfo() {
        System.out.println();
        System.out.println(ColorUtil.boldBrightCyan("═════════════════════════════════════"));
        System.out.println(ColorUtil.boldBrightYellow(" 🗡️ " + this.getName() + " [" + this.getRarity() + "]"));
        System.out.println(ColorUtil.boldBrightYellow("  + " + this.getAtkBuff() + " ATK"));

        if (getLifestealPercent() > 0) {
            System.out.println(ColorUtil.boldBrightYellow(" 💝 Restores " + getLifestealPercent() + "% HP of damage dealt"));
        }

        if (attackTwiceChance > 0) {
            System.out.println(ColorUtil.boldBrightYellow(" ⚡ " + attackTwiceChance + "% chance to deal extra damage"));
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
            int healAmount = (int) (damage * getLifestealPercent() / 100.0);
            healAmount = Math.min(healAmount, player.getMaxHP() - player.getHp());
            if (healAmount > 0) {
                System.out.println("💖 " + this.getName() + " restores " + healAmount + " HP!");
                PrintUtil.pause(800);
                player.heal(healAmount);
            }
        }

        // ☠️ Poison
        if (RandomUtil.chance(getPoisonChance())) {
            enemy.getEffects().applyPoison(2);
        }

        // 🩸 Bleed
        if (RandomUtil.chance(getBleedChance())) {
            enemy.getEffects().applyBleed(2);
        }

        // ⛓️ Immobilize
        if (RandomUtil.chance(getStunChance())) {
            enemy.getEffects().applyStun();
        }

        // ⚡ Extra hit (Double attack)
        if (RandomUtil.chance(attackTwiceChance)) {
            System.out.println(ColorUtil.brightMagenta("⚡ Weapon effect activated! Extra hit triggered!"));
            PrintUtil.pause(800);
            int extraDamage = (int) RandomUtil.range(damage * 0.20, damage * 0.40);
            System.out.println(
                    ColorUtil.brightMagenta("🗡 Extra hit from weapon for ")
                            + ColorUtil.boldBrightWhite(extraDamage + "")
                            + ColorUtil.brightMagenta(" damage!")
            );
            PrintUtil.pause(800);
            enemy.takeDamage(extraDamage);
        }

    }


}
