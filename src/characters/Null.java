package characters;

import utils.ColorUtil;
import utils.InputUtil;
import utils.PrintUtil;

public class Null extends Character {

    public Null() {
        super("Null", "Mage",
                99999,
                1,
                9999,
                999
        );
    }

    @Override
    public void displaySkills() {
        System.out.println();
        System.out.println(ColorUtil.boldBrightCyan("┌────────────────────────────── ⚡ NULL'S SKILLS ⚡ ──────────────────────────────┐"));
        // Skill 1
        System.out.println("  " + ColorUtil.boldBrightYellow("💥 Skill 1 – Direct Hit (⚡ 5 Energy)"));
        System.out.println("  " + ColorUtil.cyan("💥 Damage: ") + ColorUtil.boldBrightYellow(String.valueOf(attack)) + ColorUtil.cyan("\n"));

        // Skill 2
        System.out.println("  " + ColorUtil.boldBrightYellow("🔥 Skill 2 – Obliterate (⚡ 10 Energy)"));
        System.out.println("  " + ColorUtil.cyan("💥 Damage: ") + ColorUtil.boldBrightYellow(String.valueOf(attack * 2)) + ColorUtil.cyan("\n"));

        // Ultimate
        System.out.println("  " + ColorUtil.boldBrightYellow("🌌 Ultimate – World End (⚡ 20 Energy)"));
        System.out.println("  " + ColorUtil.cyan("💥 Damage: ") + ColorUtil.boldBrightYellow(String.valueOf(attack * 3)) + ColorUtil.cyan(""));

        System.out.println(ColorUtil.boldBrightCyan("└─────────────────────────────────────────────────────────────────────────────┘"));
        System.out.println();
    }


    @Override
    public void turn(Character target) {
        boolean isValid = false;

        while (!isValid) {
            System.out.println(ColorUtil.boldBrightGreen("[1]") + " " + ColorUtil.green("💥 Skill 1   -  Direct Hit (⚡ 5 Energy)"));
            System.out.println(ColorUtil.boldBrightGreen("[2]") + " " + ColorUtil.green("🔥 Skill 2   -  Obliterate (⚡ 10 Energy)"));
            System.out.println(ColorUtil.boldBrightGreen("[3]") + " " + ColorUtil.green("🌌 Ultimate  -  World End (⚡ 20 Energy) "));
            System.out.println(ColorUtil.boldBrightGreen("[4]") + " " + ColorUtil.green("🛡️ Skip Turn -  Restore 10% Max HP & 20 Energy"));
            System.out.println(ColorUtil.boldBrightGreen("[5]") + " " + ColorUtil.green("📜 Show Menu"));
            System.out.print(ColorUtil.boldBrightWhite("Choose your action: "));

            int choice = InputUtil.scanInput();
            PrintUtil.shortLine();

            switch (choice) {
                case 1 -> { directHit(target); isValid = true; }
                case 2 -> { obliterate(target); isValid = true; }
                case 3 -> { worldEnd(target); isValid = true; }
                case 4 -> { skipTurn(); isValid = true; }
                case 5 -> displayMenu(this, target);
                default -> {
                    System.out.println(ColorUtil.boldBrightRed("❌ Invalid action! Null skips the turn."));
                    PrintUtil.pause(500);
                    isValid = true;
                }
            }
        }
    }

    // Skill 1 – Direct Hit
    private void directHit(Character target) {
        PrintUtil.print(ColorUtil.boldBrightGreen("                                                          \n" +
                "                      .. .-..                             \n" +
                "                     . . .:=-  .    .                     \n" +
                "                   .-+ .::=--:+  .                        \n" +
                "              . .=.:.:**=+##+**=.:-.  ::                  \n" +
                "                 :=#==%@%@@@#%%%*=---.                    \n" +
                "          :   ::..=%%@@@@@@@@#%@%##*=::.                  \n" +
                "              .-*+=%@@@@@@@%@@@@%%#=.-...                 \n" +
                "               .-*%@@@@@@@%@@@@@@%##+-=                   \n" +
                "            . .:+*#%@@@@@@%@@@@@@%*=:-:.                  \n" +
                "            .++++#%@@@@@@@%@@@@%%##*: . .                 \n" +
                "           :#@@@@%@@@@@@%@@@%%@@%%*=-  .          .       \n" +
                "         .%@@@@@@@@@@@@@@@@@@@@%*+-::  .        -=%=      \n" +
                "         *@@@@@@@@@@@@@@%%@@@@*+=-: :         ...-%:      \n" +
                "         :@@@@@@@@@@@@@@%#***=--:..           ...*@+      \n" +
                "        :@@@@@@@@@@@%@@#=:-:.:..              :..%@=      \n" +
                "       .%@@@@@@@@@@@%@@%+-:... .             ...-@@*:     \n" +
                "       *@@@@@@@@@@@#*@@%+:     .             ...#@@@+     \n" +
                "      :%@@@@@@@@@@@@#@@%+:                   ..:%@%%-     \n" +
                "      +@@@@@@@@@@@@#%@@#=.                  .. -@@%#.     \n" +
                "     .#@@@@@@@@@@@@@#@@%=.                  .. ##-@*.     \n" +
                "     -%@@@@@@@@@@@@#*%@%@@%%**+=--+#%###:    -#@:-@#-.    \n" +
                "     +@@@@@@@@@@@@@@@@@@@@%@@###%@@@@@%%%##-      *@#-++. \n" +
                "     *@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%#%%%@@@@@@@@@@@@#+\n" +
                "    .#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
                "    .%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
                "    =@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*#@@\n" +
                "    .#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"));
        int cost = 5;
        if (!consumeEnergy(cost)) {
            System.out.println(ColorUtil.boldBrightRed("❌ Not enough Energy!"));
            return;
        }

        int damage = attack * 2;
        int finalDamage = calculateDamage(target, damage);

        System.out.println(
                ColorUtil.brightGreen("💥 Null used Direct Hit! Dealt ")
                        + ColorUtil.boldBrightWhite(String.valueOf(finalDamage))
                        + ColorUtil.brightGreen(" damage.")
        );

        target.takeDamage(finalDamage);
    }

    // Skill 2 – Obliterate
    private void obliterate(Character target) {
        PrintUtil.print(ColorUtil.boldBrightGreen("                                                          \n" +
                "                          .:.                             \n" +
                "                        .#@@@#                            \n" +
                "                        *@@@@@+                           \n" +
                "                        *@@@@@@*.                         \n" +
                "                        .#@@@@@@@@@@=                     \n" +
                "  .%%%%%%%@%*=-.         .#@@@@@@@@@@%.   .-=*#@@%%%%%%.  \n" +
                "  .%%%#%%%###%%%%@@-@@@@%%@@@@@@@@@@@@@%#%%%%###*#%%@@%.  \n" +
                "  .%%%#########%%%@-#**###%@@@@@@@@@@@@@@###**+=-+#%%@%.  \n" +
                "  .%%%%%%#%%%%%%%%@-%###%*%@@@@@@@@@%*#@@@#%%%%%%%%%@@%.  \n" +
                "  .%%%%%%%%%%#%%%%@-@%%%#%@@@@@@@@@@%#-%@@%%%%%#%%%@@@%.  \n" +
                "   *######%%%%@%%#%=##%@@@@%@@@@@@@@@#-#@@%#%%%#######*.  \n" +
                "  .%@@@%%#**+=---+#+#+=-:--*@@@@@@@@@+.=%@*-=+**#%%@@@%.  \n" +
                "  .%@%%%%%%%%#*########****#@@@@@@@@@#-#%@%*##%%%%%#%%%.  \n" +
                "  .%@@@%%%%%%%%####:#*#####@@@@@@@@@@#-+@%*####+*###%%%.  \n" +
                "  .%@@@%##%%%%%%%%@-@%%%%#@@@@@@@@@@@#-%##%%%##%%%%%%%%.  \n" +
                "  .%%@@%%%%%@@%@@@@-%#%##%@@@@@@@@@@@%-@%%%%%#%@@@@@@@%.  \n" +
                "  .#%%%%@@@@@@@@@@@-@%%%%@@@@@%#%@@@@%-@@@@@@@@@@@@%%%#.  \n" +
                "                       :%@@@@:  .%@@@@.                   \n" +
                "                       :@@@@     =@@@%                    \n" +
                "                       :@@@+      *@@@+                   \n" +
                "                       .#@@*       *@@@:                  \n" +
                "                        *@@*       :%@@#                  \n" +
                "                        *@@=        =@@@.                 \n" +
                "                        *@@=        .%@@=                 \n" +
                "                       .#@@           @@+                 \n" +
                "======================*@@@@+==========@@@=================\n" +
                "@@@@@@@@@@@@@%%%%%%%%@@%%%%#%#%###%%%@@@@%%%%@@@@@@@@%*#@@\n" +
                "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"));
        int cost = 10;
        if (!consumeEnergy(cost)) {
            System.out.println(ColorUtil.boldBrightRed("❌ Not enough Energy!"));
            return;
        }

        int damage = attack * 4;
        int finalDamage = calculateDamage(target, damage);

        System.out.println(
                ColorUtil.brightGreen("🔥 Null used OBLITERATE! Dealt ")
                        + ColorUtil.boldBrightWhite(String.valueOf(finalDamage))
                        + ColorUtil.brightGreen(" damage.")
        );

        target.takeDamage(finalDamage);
    }

    // Ultimate – World End
    private void worldEnd(Character target) {
        PrintUtil.print(ColorUtil.boldBrightGreen("                                                          \n" +
                "                                                          \n" +
                "           .=:                             :-.            \n" +
                "           -@%%%#*+-.               .-+*##%%@-            \n" +
                "           -%**#####%**@%%%###%%%%++###*#%%%@-            \n" +
                "           -@%%#####%**%#+=+*##%%@++%####%%%@-            \n" +
                "   .##-    -@%%%##%##**%%######%%@++%%%%%%%%@-     .+%#.  \n" +
                "   :%%%%%*..+*%@@@%%%**%%%#%%%%%%%++%%%%@%%#+..+%%%%%%%:  \n" +
                "   :%%#=*#@*%%%%%%##+:-+=#@@@@@===::+#%%@@@%#*###*+##%%:  \n" +
                "   :%%#+*%@*%%#++*%##+*#%@@@@@@@#%++#%#@@@@@%*%%###%%%%:  \n" +
                "   :%%%**%%*%######%%+*##%@@@@@@@@**#%#%@@@@%*%%%%%%%%%:  \n" +
                "   :%##%%+#*%%%%%%%%%+*#%##@@@@@@@@@%%#%@@@@%*%%###*###:  \n" +
                "    =+++***=########*=+###***@@@@@@@@%#@@@@@#=*****+++=   \n" +
                "   .+*+=-::.........        .#@@@@@@@@-@@@@%:             \n" +
                "   :@@@@%#*##%@%*%%%#%#%%%%%#@@@@@@@@@@@@@@#.             \n" +
                "   :@@@@@@@%%%%@%%%#%%%%%%%@@@@@@@@@@@@@@@@+              \n" +
                "   :@@@@@@@@@@@@@@%%@@@@@@@@@@@@@@@@@@@@@@@=              \n" +
                "   :@@@@@@@@@@@@@@@@@@@%=:-#%@@@@@@@@@@@@@%:              \n" +
                "   :@@@@@@@@@@@@=   .+*#%@@@@@@@@@@@@@@@@@#.              \n" +
                "   :@@@@@@@@@@#:   +@@@@@@@@@@@@@@@@@@@@@@+               \n" +
                "   :@@@@@@@@@*     #@@@@@@@@@@@@@@@@@@@@@%.               \n" +
                "   :@@@@@@@@@+     %@@@@@@@@@@@@@@@@@@@@@%.               \n" +
                "   :@@@@@@@@@+     @@@@+:#%%%@@@@@@@@@%%*.                \n" +
                "   :@@@@@@@@@+    +@@@#       .-+@*-:.                    \n" +
                "   :@@@@@@@@@*:  -@@@@=         *@*.                      \n" +
                "   :@@@@@@@@@@@*:#@@@%:    . ..-#@#:.                     \n" +
                "   :@@@@@@@@%%%@@@@@@@%##%%%@@@@@@@@@@@@%##**+-.:         \n" +
                ".:=*@@@@%@@@@%@@@@@@@@#*#%@@%#####%%@@%#%%%%%%%#%%%@%%*+-:\n" +
                "@@@@@@@@%%@@@%%%%%@%%#**+*@@%%%%%#%%@@@%%##%##*#%%%%%@%@@@\n" +
                "@@@@@@@@@@@@@@@@@@%%%%###*#%%%@@%%%%%@%%%%#####%%%@@@%**@@\n" +
                "@@@@@@@@@@@@@@@@@@@@@@%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"));
        System.out.println();
        int cost = 20;
        if (!consumeEnergy(cost)) {
            System.out.println(ColorUtil.boldBrightRed("❌ Not enough Energy!"));
            return;
        }

        int damage = attack * 10;
        int finalDamage = calculateDamage(target, damage);

        System.out.println(
                ColorUtil.brightGreen("🌋 Null used WORLD END!!! Massive ")
                        + ColorUtil.boldBrightWhite(String.valueOf(finalDamage))
                        + ColorUtil.brightGreen(" damage!")
        );

        target.takeDamage(finalDamage);
    }
}
