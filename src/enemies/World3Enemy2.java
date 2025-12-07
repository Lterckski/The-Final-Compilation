package enemies;

import characters.Character;
import inventory.Armor;
import utils.ColorUtil;
import utils.PrintUtil;
import utils.RandomUtil;

public class World3Enemy2 extends Enemy {

    public World3Enemy2() { super("Bone Warlock", 1829, 41, 349); }

    public void marrowBolt(Character target) {
        PrintUtil.print(ColorUtil.boldBrightRed("                                                          \n" +
                "                                                          \n" +
                "                          ..      :.                      \n" +
                "                         .:      ..                       \n" +
                "                         .       :. -%@%#:                \n" +
                "                         ...    .  -%=  =*                \n" +
                "                          :    --. =#+ ::                 \n" +
                "                    :  . ..       ==%*:                   \n" +
                "                 +%@#.  :.  =    *%**#.                   \n" +
                "               .*%- .#:.-:.:-  .+*%%@*#.                  \n" +
                "               :*%. :+  .:=   .-  :*@%%#@%***#:           \n" +
                "                +#@#++#%%#:      -%@@*%#=. . =*           \n" +
                "                 .+#+****: .-   :%@%*#-   =--*-           \n" +
                "              .-+*=:   .==+*  .+#%##* ...--=-             \n" +
                "             *#+++#@@#+%@@%:  .++:-..-#@%%##%%:           \n" +
                "            =#=    -#@@@@@+    . :*%@@%*+-  -*%           \n" +
                "            -*-    -@@@##+..=   -*%##=- :+- :%#           \n" +
                "             +*: = +@@%---::=  :-===::: -%**%*.           \n" +
                "              .=#+ :#%%@#+=-.  :-.=#%###+ ..              \n" +
                "                :*.  -#%@@@%-  ..-=: - -*:                \n" +
                "               -*-  .=#+##+     :*=.:*##-                 \n" +
                "                  . .*+*+--:-. .--+#+. . .   .            \n" +
                "                :  .*==#-..:..  .=*+%%=                   \n" +
                "         .   :      :**@%=== - :--#**%- ...               \n" +
                "               :::::.+%**@*.:-.+*#@#%%-.-  .              \n" +
                "          .    ..-=-:+#*++=::.+..+#*#*==-                 \n" +
                "               ..=. .-+-:.=#%*=+-:--.. -+:                \n" +
                "           ..:=*#***#@%%%%%%@@@%##%##%*%%%*=-.            \n" +
                "                ..::--=+++=++++++==-:::..                 \n" +
                "                                                          "));
        System.out.println(ColorUtil.boldBrightRed("💀 " + name + " casts Marrow Bolt!"));
        PrintUtil.pause(800);
        if (target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        int damage = (int) RandomUtil.range(attack * 1.00, attack * 1.25);
        int reduced = calculateDamage(target, damage);

        System.out.println(ColorUtil.brightRed("→💔 Marrow Bolt hits for ")
                + ColorUtil.boldBrightWhite(String.valueOf(reduced))
                + ColorUtil.brightRed(" damage!"));
        PrintUtil.pause(800);
        target.takeDamage(reduced);


        // Armor reflect check
        Armor equippedArmor = target.getInventory().getEquippedArmor();
        if (equippedArmor != null) {
            int reflectDamage = equippedArmor.checkReflectDamage(reduced);
            if (reflectDamage > 0) {
                System.out.println(ColorUtil.brightMagenta("🪞 " + equippedArmor.getName() + " reflected " + reflectDamage + " damage back to " + name + "!"));
                PrintUtil.pause(800);
                this.takeDamage(reflectDamage);
            }
        }

        // 30% chance to apply Weaken (ATK debuff 30% for 2 turns) — check debuff immunity first
        if (RandomUtil.chance(30)) {
            if (equippedArmor != null && equippedArmor.checkDebuffImmunity()) {
                System.out.println(ColorUtil.brightMagenta("✨ " + target.getName() + " resisted Weaken 💢  due to " + equippedArmor.getName() + "!"));
                PrintUtil.pause(800);
            } else {
                target.getEffects().applyAttackDebuff(30, 2);
            }
        }
    }

    @Override
    public void displaySkills() {
        System.out.println();
        System.out.println(ColorUtil.boldBrightRed("┌───────────────────────────── 💀 BONE WARLOCK SKILLS 💀 ────────────────────────────┐"));
        System.out.println(ColorUtil.boldBrightYellow("  💀 Skill – Marrow Bolt"));
        System.out.println(ColorUtil.red(" 📜 Description : Bone Warlock casts Marrow Bolt, reducing the target's attack damage."));
        System.out.println(ColorUtil.red(" 💥 Damage : (") + ColorUtil.boldBrightYellow((int)(attack * 1.00) + " — " + (int)(attack * 1.25)) + ColorUtil.red(")"));
        System.out.println(ColorUtil.red(" ✨ Effects :"));
        System.out.println(ColorUtil.red("    - ⚔️ 30% chance to apply ATK Debuff: reduces target's damage by 30%"));
        System.out.println(ColorUtil.boldBrightRed("└────────────────────────────────────────────────────────────────────────────────────┘"));
        System.out.println();
    }



    @Override
    public void turn(Character target) { marrowBolt(target); }

    @Override
    public void dropLoot(Character player){
        PrintUtil.pause(800);
        System.out.println();
        System.out.println(ColorUtil.boldBrightYellow("┬───────────────────────────────────┬"));
        System.out.println(ColorUtil.brightYellow("  🎁 You received:"));
        player.lootSoulShards(RandomUtil.range(2,4));
        player.getPotions().lootPotions(false);
        player.gainExp(rewardExp());
    }

    @Override
    public int rewardExp(){
        return RandomUtil.range(965,1000);
    }
}
