package enemies;

import characters.Character;
import utils.ColorUtil;
import utils.InputUtil;
import utils.PrintUtil;
import utils.RandomUtil;
import inventory.*;

public class World2Miniboss1 extends Enemy{
    public World2Miniboss1(){
        super("The Black Jailer", 1000, 24, 200);
    }

    public void shacklingChains(Character target){
        PrintUtil.print(ColorUtil.boldBrightRed("                                                          \n" +
                "                     .-:::.-=-:-=+=:.                     \n" +
                "                   =+-: .:. .+=  :=+===                   \n" +
                "                 :: .::--:  @@%*=:. =- :=-.               \n" +
                "                -   -:-    :+#@+    .+==.=-               \n" +
                "              =-. -    ::.-.-@%    :-=-+=:.:              \n" +
                "              -::=-    .-+#@@@@%*+. :=.  -.=:             \n" +
                "             :.:-   :=-.=@%+**#@@@+- :.  .. :=:           \n" +
                "            .-:. :-:==-+*#@@@##%###: :   .. .--           \n" +
                "             ==-:.:=:  :%%##%@#*##@-.=    :  =.           \n" +
                "           -+-    -  :.+@%%%**#%@#*++.    -:=-            \n" +
                "           .=-   :.   -*#**@@@@%*+++:-:..:=--:            \n" +
                "           ..:-. :. :--+*+#%#%%@@#*#-:.:--- :             \n" +
                "           :  :. -+-:..*=-*##@@%#++#. .::-:-:             \n" +
                "               -===.   +*+%@%*+*%*=%+=. :..-:             \n" +
                "              .--:.=-.  .=##%-%@%*=-  .=::: :             \n" +
                "              .. .-.=-==-+%@% =##+  -==:=.  -:            \n" +
                "              -:   -=---:+*+*.:@@#=--:=-.    :            \n" +
                "             ..    .   :=+##-:-*##=:  .                   \n" +
                "                   -.    +%#-: +%*-   :.                  \n" +
                "                   +:   :+%%   *@*    =:                  \n" +
                "                  ..     +@*   =@*     -.                 \n" +
                "                         +@=   -@#.                       \n" +
                "                        .*@:   :%*.                       \n" +
                "                      .:*@@+===*@@%=:.                    \n" +
                "                                                          "));
        System.out.println(ColorUtil.boldBrightRed("⛓️ " + name + " used Shackling Chains!"));
        PrintUtil.pause(800);
        if(target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        int damage = (int)RandomUtil.range(attack * 1.00, attack * 1.30);
        int reduced = calculateDamage(target, damage);

        System.out.println(ColorUtil.brightRed("→💔 Shackling Chains hits for ")
                + ColorUtil.boldBrightWhite(String.valueOf(reduced))
                + ColorUtil.brightRed(" damage!"));
        PrintUtil.pause(800);
        target.takeDamage(reduced);


        // Reflect damage check
        Armor equippedArmor = target.getInventory().getEquippedArmor();
        if (equippedArmor != null) {
            int reflectDamage = equippedArmor.checkReflectDamage(reduced);
            if (reflectDamage > 0) {
                System.out.println(ColorUtil.brightMagenta("🪞 " + equippedArmor.getName() + " reflected " + reflectDamage + " damage back to " + name + "!"));
                PrintUtil.pause(800);
                this.takeDamage(reflectDamage);
            }
        }

        // 30% chance to apply Immobilize
        if (RandomUtil.chance(30)) {
            target.getEffects().applyImmobilize();
        }

    }

    public void tormentingLash(Character target){
        PrintUtil.print(ColorUtil.boldBrightRed("                                                          \n" +
                "                                   -#*##-                 \n" +
                "                .*+::==           =-    *#                \n" +
                "               -#.    -.          -.     #+               \n" +
                "               ++    .   .              .@+     .         \n" +
                "        :*%#-  +@:      ==      .+.    .@#    +. :#-      \n" +
                "      :%*   :#= *@%:    *#:#@@@=:%-   %@=    .     *=     \n" +
                "     .#=     :+   #@@.   +@@@@@@%-  .%@.           +*     \n" +
                "     :%=   .-=     -@%.  *@*%@##@=  *@#   =%%@@-  .@+     \n" +
                "      *@-          .@@: .#@@@@@@%:  +@@. .     =@#@#      \n" +
                "       =@@@=       %@@%@@@@@@@@@@@*. #@@=      =@@%       \n" +
                "          =%@#. .%@@@@@@@@@@@@@@@@@@@@@@@-  +@@#::@=      \n" +
                "            +@* .%@@@@@@@@@@@@@@@@@@@@@@%..#@=    @+      \n" +
                "    .*+..+: -@#.-%@@@@@@@@@@@@@@@@@@@@@@= =@*    +@=      \n" +
                "   .*:    -.%@- *@@@@@@@@@@@@@@@@@@@@@@@= :@%:  *@*       \n" +
                "   :#.    .@%- :%@@@%#@@@@@@@@@@@@@@@@@@*  =@@#@@=        \n" +
                "    #*    +@#.*%@@@* .%@@@@@@@@@@@@*#@@@%.  -@@@%:   :    \n" +
                "     +%*. -@@#@@@@%   :@@@@@@@@@@@*  +@@@@* *@#=%@%. .+.  \n" +
                "       =@* -%@@@@@* - -@@@@@@@@@@@=  +@@@@#-*@*  *@#.:+.  \n" +
                "        %%   #@@@@@*.*%@@@@@@@@@@@#.  *@@@#:.#@*  @@%*.   \n" +
                "      -%@:  .*@@=:#@+-@@@@@@@@@@@@@*+  =@@#.  +@@-@@=     \n" +
                "    .#@+  .=.#@@+  @@%@@@@@@@@@@@@@@-   %@@-   +@@@*      \n" +
                "    *@=  *=  *@@@@ :@@@@@@@@@@@@@@@@#  #@@%- .*@@@#       \n" +
                "   .#@- *#  .%@*:#= @@@@@@@@@@@@@@@@@-=%*@@=.#@##@#       \n" +
                "    =@@-*%   =@%=. *@@@@@@@@@@@@@@@@@#. -@%-=@@:@@+.-     \n" +
                "     -%@@@%+.  :.  =@@@@@%%@@@@@@@@@@+.:*#: -@@@@# .+     \n" +
                "       .=*@@@%=    .@@@@@-+@##%:#@@@@=      *@@@*   :*.   \n" +
                "           @@@@+  *#@@@@= =@*:- :%@@@@ .  +@@%#@@*   *-   \n" +
                "    -*-..  @%+@%.=@@@@@* :%@.   .#@@@@** =@%-  -@@* :%:   \n" +
                "   .*.    #@=+@%.#@@@@@* *@:    :@@@@@@. *@#.   +@@@%-    \n" +
                "   :#.   %@-.@@+ *@@@@#. *@.  - :@@@@@%  :@@= -@@@@-      \n" +
                "    *#: *@+ =@@- =@@@#    *@* :+ :%@@@=  .%@++@#=@%:      \n" +
                "     -%@@@* .@@@%%@@@-      =@@:  =@@@= .%@@=#@-@@#       \n" +
                "        :@@@@++@@@@@@@@@@:   :@+  -@@@@@@@%::%@@@@   :    \n" +
                "       .  %@@@%*%@@@@: *@%. #@%  -@@@@@@*:-#@@@@=   -+    \n" +
                "     :=     +@@@@@@@@@@@@@@@@@@%%@@@@@@@@@@@@@-.*@%*:     \n" +
                "      =**#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%+-.      \n" +
                "            :=*+++****+: .-*#%%%%#=-::-+***+=:            \n" +
                "                                                          \n" +
                "                                                          "));
        System.out.println(ColorUtil.boldBrightRed("🩸 " + name + " lashes with Tormenting Lash!"));
        PrintUtil.pause(800);
        if(target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        int damage = (int)RandomUtil.range(attack * 1.30, attack * 1.70);
        int reduced = calculateDamage(target, damage);

        System.out.println(ColorUtil.brightRed("→💔 Tormenting Lash hits for ")
                + ColorUtil.boldBrightWhite(String.valueOf(reduced))
                + ColorUtil.brightRed(" damage!"));
        PrintUtil.pause(800);
        target.takeDamage(reduced);


        // Reflect damage check
        Armor equippedArmor = target.getInventory().getEquippedArmor();
        if (equippedArmor != null) {
            int reflectDamage = equippedArmor.checkReflectDamage(reduced);
            if (reflectDamage > 0) {
                System.out.println(ColorUtil.brightMagenta("🪞 " + equippedArmor.getName() + " reflected " + reflectDamage + " damage back to " + name + "!"));
                PrintUtil.pause(800);
                this.takeDamage(reflectDamage);
            }
        }

        // Bleed — check immunity
        if (equippedArmor != null && equippedArmor.checkEffectsImmunity()) {
            System.out.println(ColorUtil.brightMagenta("✨ " + target.getName() + " resisted Bleed 🩸 due to " + equippedArmor.getName() + "!"));
            PrintUtil.pause(800);
        } else {
            target.getEffects().applyBleed(2);
        }
    }


    @Override
    public void displaySkills() {
        System.out.println();
        System.out.println(ColorUtil.boldBrightRed("┌──────────────────────────── ⛓️ THE BLACK JAILER SKILLS ⛓️ ─────────────────────────────┐"));

        // Skill 1
        System.out.println(ColorUtil.boldBrightYellow("  🔗 Skill 1 – Shackling Chains"));
        System.out.println(ColorUtil.red(" 📜 Description : The Black Jailer swings his chains to bind and cripple his opponent."));
        System.out.println(ColorUtil.red(" 💥 Damage : (") + ColorUtil.boldBrightYellow((int)(attack * 1.00) + " — " + (int)(attack * 1.30)) + ColorUtil.red(")"));
        System.out.println(ColorUtil.red(" ✨ Effects :"));
        System.out.println(ColorUtil.red("    - 🛑 30% chance to Immobilize the target"));
        System.out.println();

        // Skill 2
        System.out.println(ColorUtil.boldBrightYellow("  ⚡ Skill 2 – Tormenting Lash"));
        System.out.println(ColorUtil.red(" 📜 Description : The Black Jailer lashes his whip, leaving his foe bleeding."));
        System.out.println(ColorUtil.red(" 💥 Damage : (") + ColorUtil.boldBrightYellow((int)(attack * 1.30) + " — " + (int)(attack * 1.70)) + ColorUtil.red(")"));
        System.out.println(ColorUtil.red(" ✨ Effects :"));
        System.out.println(ColorUtil.red("    - 🩸 30% chance to inflict Bleed for 2 turns"));

        System.out.println(ColorUtil.boldBrightRed("└───────────────────────────────────────────────────────────────────────────────────────┘"));
        System.out.println();
    }




    @Override
    public void turn(Character target) {
        if (RandomUtil.chance(40)) shacklingChains(target);
        else tormentingLash(target);
    }

    @Override
    public void dropLoot(Character player){
        PrintUtil.pause(800);
        System.out.println();
        System.out.println(ColorUtil.boldBrightYellow("┬───────────────────────────────────┬"));
        System.out.println(ColorUtil.brightYellow("  🎁 You received:"));
        player.lootSoulShards(12);
        player.getPotions().lootPotions(true);
        player.gainExp(rewardExp());

        Armor aegisMail = Armor.AEGIS_MAIL;         // +25 DEF, immune to debuff ↓
        Armor vanguardRobe = Armor.VANGUARD_ROBE;   // +25 DEF, immune to status effects

        System.out.println(ColorUtil.boldBrightCyan(
                "                                                        " + "                                                        \n" +
                        "                                                        " + "                                                        \n" +
                        "                                                        " + "                                                        \n" +
                        "                                                        " + "                                                        \n" +
                        "                                                        " + "                                                        \n" +
                        "              .**.   :#@@@@@@@@@#:    **.               " + "                        .%@@@%:                        \n" +
                        "            .+%%@#-*%%@@@@@@@@@@@@%*-#@%%+:            " + "                       .*#%@%#*.                        \n" +
                        "         .+@%%@@@@@@@@@%%@@@@@%%@@@@@@%@@%%@*.         " + "                     +%@@@%%%@@@%*.                     \n" +
                        "        .*@#*-*@@@@@@@@@%%%%%%%@@@@@@@@@#=*#@*.        " + "                    *@@@##%@%##@@@*.                    \n" +
                        "        -#+#%*@@@@@@@%##@@@%@@@##%@@@@@@@*##+#=        " + "                   :@@@@%#%@%#%@@@@-                    \n" +
                        "       .#@@%@@@@@@@@@%#####@#####%@@@@@@@@@#@@%.       " + "                   *@@@@%##%##%@@@@#                    \n" +
                        "        +@@@@@@@@@@@@@%#@#@@@#%#%@@@@@@@@@@@@@+.       " + "                  =@@@@@@@%@%@@@@@@@+                   \n" +
                        "        +@@@@@#-#@@@@@@%***#***%@@@@@@#-#@@@@@*        " + "                 -@@@@@@@%%@%%@@@@@@@=                  \n" +
                        "        *@@@@%- #@@@@@@%#%#%#%#%@@@@@@# :%@@@@*        " + "                +%@@@@@@@##@%*@@@@@@@%+                \n" +
                        "       :+++=:. -@@@@@@@@%@@@@@@@@@@@@@@= .:=+++:       " + "              .#@%@@@@@@##%@%##@@@@@@%@#.               \n" +
                        "               :#@@@@@@@@%%%%%@@@@@@@@#:               " + "             -#@@@@@@@@@#*@@@*#@@@@@@@@%#-              \n" +
                        "                =%@@@@@@%@@@@*%@@@@@@%=                " + "            .%##%@@@@@@@##@@@##@@@@@@@%*#%:            \n" +
                        "                 *@@@@@@==%@@-+@@@@@@*                 " + "             -%#*%@@@@@%##@@@%##@@@@@%*#%-              \n" +
                        "                 .@@@@@@+#@@@#*@@@@@@.                 " + "              -@###@@@@%*%@@@%*%@@@@###@=               \n" +
                        "                  #@@@@@@@@@@@@@@@@@#                  " + "               =@%*%@@@%*@@@@@#%@@@%*%@+                \n" +
                        "                  %@@@@@#+%@%+*@@@@@%                  " + "                :%%%@@@#*@@@@@*#@@@%%%:                \n" +
                        "                :#@@@@@@#=#@%+*@@@@@@#:                " + "                   %@@@##@@@@@%#@@@@.                   \n" +
                        "                *@@@@@@@@@@@@@@@@@@@@@*                " + "                  =@@@@#%@@@@@%#%@@@=                   \n" +
                        "                :+@@@@@@@@@@@@@@@@@@@*:                " + "                  %@@@%*@@@@@@@*#@@@%.                  \n" +
                        "                   .=#%@@@@@@@@@%#=.                   " + "                 +@@@@#*@@@@@@@*#@@@@+                  \n" +
                        "                        .-*#*-.                         " + "                =%@@@%#*@@@@@@@*#%@@@%=                \n" +
                        "                                                        " + "               -%@@@@%*#@@@@@@@%*%@@@@%-                \n" +
                        "                                                        " + "              -%@@@@@#*%@@@%@@@%*#@@@@@@=               \n" +
                        "                                                        " + "             *@@@@%@%##%@@@%@@@@##%@%@@@@*              \n" +
                        "                                                        " + "           :+**#**=#++#@@@@%@@@@#++#++*#**+-           \n" +
                        "                                                        " + "                :+****##+*%%%%%##*****:..               \n" +
                        "                                                        " + "                                                        \n"
        ));


        System.out.println("[1] " + aegisMail.getName() + " → +25 DEF 🛡️, immune to ATK⬇️ & DEF⬇️");
        PrintUtil.pause(800);
        System.out.println("[2] " + vanguardRobe.getName() + " → +25 DEF 🛡️, immune to Poison ☠️, Burn 🔥, Bleed 🩸");
        PrintUtil.pause(800);
        System.out.println();

        int choice;
        boolean validChoice = false;

        while (!validChoice) {
            System.out.print("Choose an armor to equip (1 = Aegis Mail, 2 = Vanguard Robe): ");
            choice = InputUtil.scanInput();

            if (choice == 1) {
                validChoice = true;
                aegisMail.equip(player);
                System.out.println(ColorUtil.brightRed("The other armor fades away..."));
                PrintUtil.pause(800);
            } else if (choice == 2) {
                validChoice = true;
                vanguardRobe.equip(player);
                System.out.println(ColorUtil.brightRed("The other armor fades away..."));
                PrintUtil.pause(800);
            } else {
                System.out.println(ColorUtil.boldBrightRed("❌ Invalid choice! Please choose 1 or 2."));
                PrintUtil.pause(800);
            }
        }

    }

    @Override
    public int rewardExp(){return 1915;}
}
