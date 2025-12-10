package inventory;

import characters.Character;
import utils.ColorUtil;
import utils.PrintUtil;
import utils.RandomUtil;

import java.util.Map;

public class Sword extends Weapon{
    private final int extraHitChance;

    public static final Sword OLD_BROADSWORD = new Sword("Old Broadsword", "⚪", 5, 0, 0);
    public static final Sword IRON_SHORTSWORD = new Sword("Iron Shortsword", "🟢", 10, 0, 0);
    public static final Sword TWINSTRIKE_BLADE =  new Sword("Twinstrike Blade", "🔵", 20, 20, 0);
    public static final Sword LIFEBOND_BLADE =  new Sword("Lifebond Blade", "🔵", 20, 0, 8);
    public static final Sword ECLIPSE_GREATSWORD =  new Sword("Eclipse Greatsword", "🟣", 35, 25, 12);
    public static final Sword CELESTIAL_EDGE = new Sword("Celestial Edge", "🟡", 50, 30, 15);

    public Sword(String name, String rarity, int atkBuff, int extraHitChance, int lifestealPercent){
        super(name,rarity,atkBuff);
        this.extraHitChance = extraHitChance;
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

        if (extraHitChance > 0) {
            System.out.println(ColorUtil.boldBrightYellow(" ⚡ " + extraHitChance + "% chance to deal extra damage"));
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
                System.out.println(ColorUtil.brightMagenta("💖 " + this.getName() + " restores " + healAmount + " HP!"));
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
        if (RandomUtil.chance(extraHitChance)) {
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
