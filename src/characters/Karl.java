package characters;

import enemies.Enemy;
import utils.ColorUtil;
import utils.InputUtil;
import utils.PrintUtil;
import utils.RandomUtil;

public class Karl extends Character{

    public Karl() {
        super("Karl Clover Dior IV", "Archer", 80, 3, 24, 12);
    }

    @Override
    public void displaySkills() {
        System.out.println();
        System.out.println(ColorUtil.boldBrightCyan("┌────────────────────────────────────── 🏹 KARL'S SKILLS 🏹 ───────────────────────────────────────┐"));

        // Passive
        System.out.println("  " + ColorUtil.boldBrightYellow("✨ Passive – Hunter’s Instinct"));
        System.out.println("  " + ColorUtil.cyan("Deal ") + ColorUtil.boldBrightYellow("+20%") + ColorUtil.cyan(" damage to enemies below 30% HP.\n"));

        // Skill 1 – Piercing Arrow
        System.out.println("  " + ColorUtil.boldBrightYellow("🏹 Skill 1 – Piercing Arrow (➶ 1 Arrow)"));
        System.out.println("  " + ColorUtil.cyan("📜 Description: Fires an arrow that slices through armor and flesh alike."));
        System.out.println("  " + ColorUtil.cyan("💥 Damage: (") + ColorUtil.boldBrightYellow((int)(attack * 1.10) + " — " + (int)(attack * 1.25)) + ColorUtil.cyan(")"));
        System.out.println("  " + ColorUtil.cyan("⚡ Effects:"));
        System.out.println("    - " + ColorUtil.cyan("🛡️ Ignores 30% of the target’s Defense"));
        System.out.println("    - " + ColorUtil.cyan("🩸 30% chance to inflict Bleed (2 turns)\n"));

        // Skill 2 – Bullseye
        System.out.println("  " + ColorUtil.boldBrightYellow("🎯 Skill 2 – Bullseye (➶ 1 Heavy Arrow ═ 3 Arrows)"));
        System.out.println("  " + ColorUtil.cyan("📜 Description: Karl steadies his breath and fires a deadly precise shot."));
        System.out.println("  " + ColorUtil.cyan("💥 Damage: (") + ColorUtil.boldBrightYellow((int)(attack * 1.25) + " — " + (int)(attack * 1.50)) + ColorUtil.cyan(")"));
        System.out.println("  " + ColorUtil.cyan("⚡ Effects:"));
        System.out.println("    - " + ColorUtil.cyan("🎯 Guaranteed Critical Hit (×1.5 multiplier)"));
        System.out.println("    - " + ColorUtil.cyan("🛡️ 30% chance to apply Weakness (-30% DEF, 2 turns)\n"));

        // Ultimate – Rain of a Thousand Arrows
        System.out.println("  " + ColorUtil.boldBrightYellow("🌩️ Ultimate – Rain of a Thousand Arrows (➶ 5 Arrows)"));
        System.out.println("  " + ColorUtil.cyan("📜 Description: Karl releases a rapid flurry of arrows, overwhelming his opponent."));
        System.out.println("  " + ColorUtil.cyan("💥 Damage: 5 hits, each dealing (") + ColorUtil.boldBrightYellow((int)(attack * 1.20) + " — " + (int)(attack * 1.80)) + ColorUtil.cyan(")"));
        System.out.println("  " + ColorUtil.cyan("⚡ Effects:"));
        System.out.println("    - " + ColorUtil.cyan("🏃 Grants Nimble (increased dodge chance)"));
        System.out.println("    - " + ColorUtil.cyan("💪 Grants Strengthen (+20% ATK for 2 turns)"));

        System.out.println(ColorUtil.boldBrightCyan("└───────────────────────────────────────────────────────────────────────────────────────────────────┘"));
        System.out.println();
    }

    public void showBackstory() {
        System.out.println();
        System.out.println(ColorUtil.boldBrightCyan("┌───────────────────────────── 📘 KARL'S BACKSTORY 📘 ─────────────────────────────┐"));
        System.out.println(ColorUtil.brightYellow  ("  Karl Clover Dior IV was born and raised in the Forest of Silence, a place"));
        System.out.println(ColorUtil.brightYellow  ("  where the air is thick with mist and danger lurks in every shadow."));
        System.out.println(ColorUtil.brightYellow  ("  His father, once a skilled archer, taught him the bow not as a weapon of"));
        System.out.println(ColorUtil.brightYellow  ("  glory but as a means of survival against Rotfang Wolves, Carrion Bats, and"));
        System.out.println(ColorUtil.brightYellow  ("  the twisted Dreadbark Treants that haunted their home."));
        System.out.println();
        System.out.println(ColorUtil.brightYellow  ("  The forest shaped Karl's instincts—quiet, patient, always watching—and his"));
        System.out.println(ColorUtil.brightYellow  ("  arrows rarely missed their mark. When the silence deepened and the Hollow"));
        System.out.println(ColorUtil.brightYellow  ("  Stag began to prowl, Karl realized that the forest itself had become"));
        System.out.println(ColorUtil.brightYellow  ("  corrupted, demanding a hunter strong enough to fight back."));
        System.out.println();
        System.out.println(ColorUtil.brightYellow  ("  Now, with his father's teachings in his heart and the weight of his homeland"));
        System.out.println(ColorUtil.brightYellow  ("  on his shoulders, Karl hunts not just for survival but to restore the balance"));
        System.out.println(ColorUtil.brightYellow  ("  of the place he calls home."));
        System.out.println(ColorUtil.boldBrightCyan("└──────────────────────────────────────────────────────────────────────────────────┘"));
        System.out.println();
    }


    // Passive - Hunter's Instinct
    private int hunterInstincts(int damage, Character target){
       double hpPercent = (double) target.getHp() / target.maxHP;

       if(hpPercent < 0.3){
           damage = (int) (damage * 1.2);
           System.out.println(ColorUtil.brightMagenta("\uD83C\uDFAF Hunter's Instinct is active! Deals extra damage."));
           PrintUtil.pause(800);
       }
       return damage;
    }

    // Skill 1 - Piercing Arrow
    public void piercingArrow(Character target) {
        PrintUtil.type(ColorUtil.boldBrightGreen("                                             \n" +
                "                                   ..                     \n" +
                "                                   .   :                  \n" +
                "                                 .        .               \n" +
                "                               .           .              \n" +
                "                           .  :             .             \n" +
                "                             -@-            :             \n" +
                "                   :@@@%*==***%:----------------:*=..->   \n" +
                "                    .+%@#---::..-#@@+%+*==*%=             \n" +
                "                        +%#=::=*#*+*:.     ..             \n" +
                "                        .#@@%#@@=                         \n" +
                "                         +@@@@@%: .                       \n" +
                "                    =%:  -+*###+   .      .               \n" +
                "                      =+*%@@%**@=   .   .                 \n" +
                "                       +@@@@@-@@@+   :                    \n" +
                "                       +@@@@*##@@@=                       \n" +
                "                       *#*+=*=:-#%@-                      \n" +
                "                      -@@*...   -@@@.                     \n" +
                "                     -@@+        -@@:                     \n" +
                "                    +@%=         -%%=                     \n" +
                "                    %%+          .*%:                     \n" +
                "                   =@*            +@:                     \n" +
                "                  :@%             +@%-                    \n" +
                "                  .:                .::                   \n" +
                "                                                          "));
        int energyCost = 1;
        if (!consumeEnergy(energyCost)) {
            System.out.println(ColorUtil.boldBrightRed("❌ Not enough Arrows to use Piercing Arrow!"));
            PrintUtil.pause(800);
            return;
        }

        System.out.println(ColorUtil.boldBrightWhite("🏹 You used Piercing Arrow on " + target.getName() + " (➶-" + energyCost + " Arrow)"));
        PrintUtil.pause(800);

        if (this.getEffects().checkConfuse()) return;

        int damage = (int) RandomUtil.range(attack * 1.10, attack * 1.25);
        int reduced = hunterInstincts(damage, target);

        System.out.println("💔 Target is hit for " + reduced + " Pure Damage!");
        PrintUtil.pause(800);
        target.takeDamage(reduced);

        // Bleed effect
        if (RandomUtil.chance(30)) {
            target.getEffects().applyBleed(2);
        }

        this.getWeapon().applyEffects(this,target,reduced);
    }

    // Skill 2 - Bullseye
    public void bullsEye(Character target) {
        PrintUtil.type(ColorUtil.boldBrightGreen("                                                          \n" +
                "                                         :*%%%%@%+        \n" +
                "                                       .%#: .::  -@+      \n" +
                "                            :         .@= +%*=+%%: #*     \n" +
                "                            .:        ## +#.:*+ -@-:%-    \n" +
                "                               :.     %* #+.#@@= @+.#=    \n" +
                "                                 ..   *@ -%- .  *@.-%:    \n" +
                "                                  .    %# :%@@@@* :@+     \n" +
                "                    .  ::          .    +@+.    :%%:      \n" +
                "              ...   ..-@+          -:     :*%%%%+.        \n" +
                "             -%@@@%+%%#+-.:--::::.:#@.                    \n" +
                "               :+%#-:  ::+@@@=#==-:=-                     \n" +
                "                  *@@@#%@+         .                      \n" +
                "                  .@@@%@@=         .                      \n" +
                "              ==   %@@@@@:        .                       \n" +
                "               --.=%##*+#-      ..                        \n" +
                "                -@%@@@%*@@=    .                          \n" +
                "                 #@@@@+#@@@*  .                           \n" +
                "                :+==*+#*=+*%:                             \n" +
                "                *@@+ +.  =@@@                             \n" +
                "               +@@-       :%@-                            \n" +
                "              +%%:        :*#=                            \n" +
                "             :##=         .#%-                            \n" +
                "             +@=           +@=                            \n" +
                "            -@+            -@@:                           \n" +
                "            :-              .:=-                          \n" +
                "                                                          "));
        int energyCost = 3;
        if (!consumeEnergy(energyCost)) {
            System.out.println(ColorUtil.boldBrightRed("❌ Not enough Arrows to use Bullseye!"));
            PrintUtil.pause(800);
            return;
        }

        System.out.println(ColorUtil.boldBrightWhite("🎯🔥 You used Bullseye on " + target.getName() + " (➶-" + energyCost + " Arrows)"));
        PrintUtil.pause(800);

        if (this.getEffects().checkConfuse()) return;

        int damage = (int) RandomUtil.range(attack * 1.25, attack * 1.50);
        damage = (int) (damage * 1.5); // guaranteed crit
        damage = hunterInstincts(damage, target);
        int reduced = calculateDamage(target, damage);

        System.out.println("💔 Target is hit for " + reduced + " Critical Damage!");
        PrintUtil.pause(800);
        target.takeDamage(reduced);

        if (RandomUtil.chance(30)) {
            target.getEffects().applyDefenseDebuff(30, 2);
        }

        this.getWeapon().applyEffects(this,target,reduced);
    }

    // Ultimate - Rain of a Thousand Arrows
    public void rainOfAThousandArrows(Character target) {
        PrintUtil.type(ColorUtil.boldBrightGreen("                                                          \n" +
                "                                                      ..:> \n" +
                "                            :                  :*- .-=    \n" +
                "                             -         +    .  -=*        \n" +
                "                               :. .:.:  :..::::     :-#* >\n" +
                "                                .:-    **:::-=-=-:-:==   .\n" +
                "                             .:::.:-.::.: .:---:-#*-=+=-=>\n" +
                "                    .  :-  : :::.::=+-:::::--*#-:-*+::=+> \n" +
                "              ...   ..-%#-......:--*+--===*#+-:::::-=>    \n" +
                "             -%@@@%+%%#+-.-+*=+==++#@--.:...:--:::-=::--->\n" +
                "               :+##-:  ::+%@@=#=+=-==+=:.:::::--:::--=+*#>\n" +
                "                  +@@@#%@*...:-::----...:::--:-+#:...-=::>\n" +
                "                   @@@%@@=  ....  .----:---::::::*%+::-:. \n" +
                "              ==   #@@@@@-     .  :-: .::--:.:-:..::::-:  \n" +
                "               --:-%##*+#-      .:. .      .:..:::==. .-> \n" +
                "                -%%@@@%*@@+    .    =.    .. .=  .:-::..::\n" +
                "                 #@@@@+#@@@#  :               ..   ...:>  \n" +
                "                .+==++#*=+*%-                     ... .>  \n" +
                "                +@@* +:  -%@@.                      .>    \n" +
                "               +@@-       :%@=                            \n" +
                "              +%%:        .*#+                            \n" +
                "             :*#+          *%=                            \n" +
                "             +@=           =%+                            \n" +
                "            -@*            :@@-                           \n" +
                "            :-              .:--                          \n" +
                "                                                          "));
        int energyCost = 5;
        if (!consumeEnergy(energyCost)) {
            System.out.println(ColorUtil.boldBrightRed("❌ Not enough Arrows to use Rain of a Thousand Arrows!"));
            PrintUtil.pause(800);
            return;
        }

        System.out.println(ColorUtil.boldBrightWhite("🌧️🏹 You unleash your ultimate: Rain of a Thousand Arrows!" + " (➶-" + energyCost + " Arrows)"));
        PrintUtil.pause(800);

        int totalDamage = 0;

        for (int i = 1; i <= 5; i++) {
            int damage = (int) RandomUtil.range(attack * 1.20, attack * 1.80);
            damage = hunterInstincts(damage, target);
            int reduced = calculateDamage(target, damage);

            if (this.getEffects().checkConfuse()) reduced = 0;
            totalDamage += reduced;

            System.out.println("→💥 Arrow " + i + " fired! 💔 Target is hit for " + reduced + " damage!");
            PrintUtil.pause(800);

        }

        System.out.println("🏹🌧️ Rain of a Thousand Arrows finished! Total damage dealt: " + totalDamage);
        PrintUtil.pause(800);
        target.takeDamage(totalDamage);

        this.getWeapon().applyEffects(this,target,totalDamage);
        this.getEffects().applyNimble();
        this.getEffects().applyAttackBuff(20, 2);

        ultimateCounter = 3;
    }

    @Override
    public void turn(Character target) {
        boolean isValid = false;

        while (!isValid) {
            if (ultimateCounter > 0) { // Ultimate on cooldown
                System.out.println(ColorUtil.boldBrightGreen("[1]") + " " + ColorUtil.green("🏹 Skill 1   -  Piercing Arrow (➶ 1 Arrow)"));
                System.out.println(ColorUtil.boldBrightGreen("[2]") + " " + ColorUtil.green("🎯 Skill 2   -  Bullseye (➶ 1 Heavy Arrow ═ 3 Arrows)"));
                System.out.println(ColorUtil.boldBrightGreen("[3]") + " " + ColorUtil.green("🌩️ Ultimate  -  Rain of A Thousand Arrows (➶ 5 Arrows) ")
                        + ColorUtil.red("❌ (Available in " + ultimateCounter + " turns)"));
                System.out.println(ColorUtil.boldBrightGreen("[4]") + " " + ColorUtil.green("\uD83D\uDEE1\uFE0F Skip Turn -  Restore 10% of Max HP and Replenish 6 Arrows"));
                System.out.println(ColorUtil.boldBrightGreen("[5]") + " " + ColorUtil.green("📜 Show Menu"));
                System.out.print(ColorUtil.boldBrightWhite("Choose your action: "));

                int choice = InputUtil.scanInput();
                PrintUtil.shortLine();

                switch (choice) {
                    case 1 -> { piercingArrow(target); isValid = true; ultimateCounter--; }
                    case 2 -> { bullsEye(target); isValid = true; ultimateCounter--; }
                    case 3 -> {
                        System.out.println(ColorUtil.red("❌ Ultimate is on cooldown! Can only be used after " + ultimateCounter + " turns."));
                        PrintUtil.line();
                    }
                    case 4 -> { skipTurn(); isValid = true; ultimateCounter--; }
                    case 5 -> displayMenu(this, target);
                    default -> {
                        System.out.println(ColorUtil.boldBrightRed("❌ Invalid action! You missed your turn."));
                        PrintUtil.pause(800);
                        isValid = true;
                        ultimateCounter--;
                    }
                }

            } else { // Ultimate ready
                System.out.println(ColorUtil.boldBrightGreen("[1]") + " " + ColorUtil.green("🏹 Skill 1   -  Piercing Arrow (➶ 1 Arrow)"));
                System.out.println(ColorUtil.boldBrightGreen("[2]") + " " + ColorUtil.green("🎯 Skill 2   -  Bullseye (➶ 1 Heavy Arrow ═ 3 Arrows)"));
                System.out.println(ColorUtil.boldBrightGreen("[3]") + " " + ColorUtil.green("🌩️ Ultimate  -  Rain of A Thousand Arrows (➶ 5 Arrows)"));
                System.out.println(ColorUtil.boldBrightGreen("[4]") + " " + ColorUtil.green("\uD83D\uDEE1\uFE0F Skip Turn - Restore 10% of Max HP and Replenish 6 Arrows"));
                System.out.println(ColorUtil.boldBrightGreen("[5]") + " " + ColorUtil.green("📜 Show Menu"));
                System.out.print(ColorUtil.boldBrightWhite("Choose your action: "));

                int choice = InputUtil.scanInput();
                PrintUtil.shortLine();

                switch (choice) {
                    case 1 -> { piercingArrow(target); isValid = true; }
                    case 2 -> { bullsEye(target); isValid = true; }
                    case 3 -> { rainOfAThousandArrows(target); isValid = true; }
                    case 4 -> { skipTurn(); isValid = true; }
                    case 5 -> displayMenu(this, target);
                    default -> {
                        System.out.println(ColorUtil.boldBrightRed("❌ Invalid action! You missed your turn."));
                        PrintUtil.pause(800);
                        isValid = true;
                    }
                }
            }
        }
    }

}



