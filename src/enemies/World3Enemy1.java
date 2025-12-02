package enemies;

import characters.Character;
import inventory.Armor;
import utils.ColorUtil;
import utils.PrintUtil;
import utils.RandomUtil;

public class World3Enemy1 extends Enemy {

    public World3Enemy1() { super("Flame Revenant", 982, 44, 80); }

    public void emberBurst(Character target) {
        PrintUtil.type(ColorUtil.boldBrightRed("                                                          \n" +
                "                             .                            \n" +
                "                           +##*.                          \n" +
                "                          .#%%#.                          \n" +
                "                             .                            \n" +
                "                                     =                    \n" +
                "                                  .-**:                   \n" +
                "                                 =+#*:..                  \n" +
                "                               .=%%%%+=.                  \n" +
                "                              *:=%%%%%-+=                 \n" +
                "                  ...        #%%%%#%%@@@#-                \n" +
                "             .::::.=.    =--#@%@@%%%%%%%%#-:              \n" +
                "           .=*###*+-+. -*%%*-: -#%%%@@+ .=%%-             \n" +
                "          :+#%%%%##=+%#=--: .  .=%%%%+    .-+*.           \n" +
                "           +%%%@@%%* :.       =-#@@@@%#:-.  :=*+          \n" +
                "           .##%%%%#: ...    ..#%@@@@@@@@%=     -          \n" +
                "             :-=-::::       :%%@#=.  =#@%@%-              \n" +
                "                          :+%@%=.       :@@+              \n" +
                "                         :*@%-          =%%-              \n" +
                "                        -%*:             *#.              \n" +
                "                       :#=               +%%*=            \n" +
                "                      =++:                                \n" +
                "                                                          "));
        System.out.println("🔥 " + name + " unleashes Ember Burst!");
        PrintUtil.pause(800);
        if(target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        int damage = (int)RandomUtil.range(attack * 1.00, attack * 1.35);
        int reduced = calculateDamage(target, damage);

        System.out.println("→💔 Ember Burst hits for " + reduced + " damage!");
        PrintUtil.pause(800);
        target.takeDamage(reduced);

        // Armor reflect check
        Armor equippedArmor = target.getInventory().getEquippedArmor();
        if (equippedArmor != null) {
            int reflectDamage = equippedArmor.checkReflectDamage(reduced);
            if (reflectDamage > 0) {
                System.out.println("🪞 " + equippedArmor.getName() + " reflected " + reflectDamage + " damage back to " + name + "!");
                PrintUtil.pause(800);
                this.takeDamage(reflectDamage);
            }
        }

        //Burn effect with immunity check
        if (equippedArmor != null && equippedArmor.checkEffectsImmunity()) {
            System.out.println("✨ " + target.getName() + " resisted Burn 🔥 due to " + equippedArmor.getName() + "!");
            PrintUtil.pause(800);
        } else {
            target.getEffects().applyBurn(2);
        }
    }

    @Override
    public void displaySkills() {
        System.out.println();
        System.out.println(ColorUtil.boldBrightRed("┌────────────────────────────────── 🔥 FLAME REVENANT SKILLS 🔥 ─────────────────────────────────┐"));
        System.out.println(ColorUtil.boldBrightYellow("  🔥 Skill – Flame Blast"));
        System.out.println(ColorUtil.red(" 📜 Description : Flame Revenants hurl blazing fireballs from afar, burning anything in its path."));
        System.out.println(ColorUtil.red(" 💥 Damage : (") + ColorUtil.boldBrightYellow((int)(attack * 1.00) + " — " + (int)(attack * 1.35)) + ColorUtil.red(")"));
        System.out.println(ColorUtil.red(" ✨ Effects :"));
        System.out.println(ColorUtil.red("    - 🔥 Applies Burn for 2 turns"));
        System.out.println(ColorUtil.boldBrightRed("└────────────────────────────────────────────────────────────────────────────────────────────────┘"));
        System.out.println();
    }



    @Override
    public void turn(Character target) { emberBurst(target); }

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
        return RandomUtil.range(510,597);
    }
}
