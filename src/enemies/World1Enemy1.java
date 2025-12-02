package enemies;

import characters.Character;
import inventory.Armor;
import utils.ColorUtil;
import utils.PrintUtil;
import utils.RandomUtil;

import java.awt.*;

public class World1Enemy1 extends Enemy {
    // Constructor
    public World1Enemy1() { super("Rotfang Wolf", 60, 5, 10); }

    // Skill: Savage Howl (10–15 damage)
    public void savageHowl(Character target) {
        PrintUtil.type(ColorUtil.boldBrightRed("                                                          \n" +
                "                                                          \n" +
                "           .+#@@@@@%#*=.       :-:              ::        \n" +
                "          *@+.       .-*%%*-      :=+-            *=      \n" +
                "         =@.              .+@%+       -*=          **     \n" +
                "         =%    *@%      ..    -#@*.      :+*=.     =@-    \n" +
                "          +=   *@@@*-      .*+   :#@#-            .%%:    \n" +
                "             :%@@@@@@@+        *#:  .*@@%+.     -%@#.     \n" +
                "       :+*=   .#@@@@@@@#         :#%:    =%@@@@@%=        \n" +
                "    .#*        *@@@@@@@@@@=         :%@+                  \n" +
                "   :%-        :%@@@@@@@@%=              =#%%*=-:::-+=     \n" +
                "   +#  .#=*#. :%@@@@@@@@@%-      :-.                      \n" +
                "   =%:  -  +# :%@@@@@@@@@@@*.       .+*+-.                \n" +
                "    +%=...+%- -@@@@@@@@@@@@@@@#:.        .-+##+:          \n" +
                "      -**+-    *@@@@@@@@@@@@@@@@@@@%#+-.       :+*=       \n" +
                "               =@@@@@@@@@@@@@@@@@@@@@@@@%=         =-     \n" +
                "        -:      *@@@@@@@@@@@@@@@@@@@@@@@@@%-    ..   :    \n" +
                "       =-       .%@@@@@@@@@@@@@@@@@@@@@@@@@@%-   .=.      \n" +
                "       #-         *@@@@@@@@@@@@@@@@@@@@@@@@@@@*    =-     \n" +
                "       :%=         %@@@@@@@@@@@@@@@@@@@@@@%%@@@#    :     \n" +
                "         +%*.      =@@@@@@@#.   -@@@%@@@@@%+#@@@%         \n" +
                "            :*+    .@@%+@@@.    .#@@@+@@@@@==@@@@@-       \n" +
                "               +:   @@*:%@#       +@@@:-@@@%:.%@@@@%-     \n" +
                "                    %@=.#@+         #@@  .#@@- ##@@@#.    \n" +
                "                    @@-.#@=         +@@    +@*     ::     \n" +
                "                   -@% :%@-        :%%     :%*            \n" +
                "                 +@@@++%@#:     .=#@%      -%#.           \n" +
                "           :=*%@@@@@@@@@@@@@@@@@@@@@@@@%##%@@#:           \n" +
                "        ::.. .-+***####%%@@@@@@@@@%####%%%#*+===++-.      \n" +
                "                                                          \n" +
                "                                                          "));
        System.out.println("🐺 " + name + " unleashes Savage Howl!");
        PrintUtil.pause(800);
        if (target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        int damage = (int) RandomUtil.range(attack, attack * 1.5);
        int reduced = calculateDamage(target, damage);

        System.out.println("→💔 Savage Howl hits for " + reduced + " damage!");
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
    }

    @Override
    public void displaySkills() {
        System.out.println();
        System.out.println(ColorUtil.boldBrightRed("┌──────────────────────────── 🐺 ROTFANG WOLVES SKILLS 🐺 ──────────────────────────────┐"));
        System.out.println(ColorUtil.boldBrightYellow(" 🐺 Skill – Savage Howl"));
        System.out.println(ColorUtil.red(" 📜 Description : The wolves unleash a feral howl, striking their target with raw power."));
        System.out.println(ColorUtil.red(" 💥 Damage : (") + ColorUtil.boldBrightYellow((int)(attack * 1.00) + " — " + (int)(attack * 1.50)) + ColorUtil.red(")"));
        System.out.println(ColorUtil.red(" ✨ Effects : —"));
        System.out.println(ColorUtil.boldBrightRed("└────────────────────────────────────────────────────────────────────────────────────────┘"));
        System.out.println();
    }


    @Override
    public void turn(Character target) {
        savageHowl(target);
    }

    @Override
    public void dropLoot(Character player){
        PrintUtil.pause(800);
        System.out.println();
        System.out.println(ColorUtil.boldBrightYellow("┬───────────────────────────────────┬"));
        System.out.println(ColorUtil.brightYellow("  🎁 You received:"));
        player.lootSoulShards(RandomUtil.range(1,2));
        player.getPotions().lootPotions(false);
        player.gainExp(rewardExp());
    }

    @Override
    public int rewardExp(){
        return RandomUtil.range(34,36);
    }
}
