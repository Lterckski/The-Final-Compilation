package characters;

import utils.ColorUtil;
import utils.InputUtil;
import utils.PrintUtil;

public class Null extends Character {

    public Null() {
        super("Null", "Mage",
                99999,   // HP
                9999,    // Attack
                9999,    // Energy
                999      // Defense
        );
    }

    @Override
    public void displaySkills() {
        System.out.println("\n----------- NULL TEST SKILLS -----------");

        System.out.println("Skill 1 – Direct Hit (⚡ 5 Energy)");
        System.out.println("Damage: ATK × 2");

        System.out.println("\nSkill 2 – Obliterate (⚡ 10 Energy)");
        System.out.println("Damage: ATK × 4");

        System.out.println("\nUltimate – World End (⚡ 20 Energy)");
        System.out.println("Damage: ATK × 10");

        System.out.println("\nSkip Turn - Restore 10% Max HP & 20 Energy");
        System.out.println("----------------------------------------");
    }

    @Override
    public void turn(Character target) {
        boolean isValid = false;

        while (!isValid) {
            System.out.println("[1] Skill 1   -  Direct Hit (⚡ 5 Energy)");
            System.out.println("[2] Skill 2   -  Obliterate (⚡ 10 Energy)");
            System.out.println("[3] Ultimate  -  World End (⚡ 20 Energy)");
            System.out.println("[4] Skip Turn -  Restore 10% Max HP & 20 Energy");
            System.out.println("[5] Show Menu");
            System.out.print("Choose your action: ");

            int choice = InputUtil.scanInput();
            PrintUtil.shortLine();

            switch (choice) {
                case 1 -> { directHit(target); isValid = true; }
                case 2 -> { obliterate(target); isValid = true; }
                case 3 -> { worldEnd(target); isValid = true; }
                case 4 -> { skipTurn(); isValid = true; }
                case 5 -> displayMenu(this, target);
                default -> {
                    System.out.println("❌ Invalid action! Null skips the turn.");
                    PrintUtil.pause(500);
                    isValid = true;
                }
            }
        }
    }

    // Skill 1 – Direct Hit
    private void directHit(Character target) {
        PrintUtil.type(ColorUtil.boldBrightGreen("                                                          \n" +
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
            System.out.println("❌ Not enough Energy!");
            return;
        }

        int damage = attack * 2;
        int finalDamage = calculateDamage(target, damage);

        System.out.println("💥 Null used Direct Hit! Dealt " + finalDamage + " damage.");
        target.takeDamage(finalDamage);
    }

    // Skill 2 – Obliterate
    private void obliterate(Character target) {
        PrintUtil.type(ColorUtil.boldBrightGreen("                                                          \n" +
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
            System.out.println("❌ Not enough Energy!");
            return;
        }

        int damage = attack * 4;
        int finalDamage = calculateDamage(target, damage);

        System.out.println("🔥 Null used OBLITERATE! Dealt " + finalDamage + " damage.");
        target.takeDamage(finalDamage);
    }

    // Ultimate – World End
    private void worldEnd(Character target) {
        PrintUtil.type(ColorUtil.boldBrightGreen("                                                          \n" +
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
        int cost = 20;
        if (!consumeEnergy(cost)) {
            System.out.println("❌ Not enough Energy!");
            return;
        }

        int damage = attack * 10;
        int finalDamage = calculateDamage(target, damage);

        System.out.println("🌋 Null used WORLD END!!! Massive " + finalDamage + " damage!");
        target.takeDamage(finalDamage);
    }
}
