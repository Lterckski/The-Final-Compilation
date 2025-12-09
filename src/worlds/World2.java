package worlds;

import enemies.*;
import battle.Battle;
import characters.Character;
import events.MagicShop;
import utils.ColorUtil;
import utils.InputUtil;
import utils.PrintUtil;

public class World2 {

    public void run(Character player) {
        PrintUtil.pause(2000);
        System.out.println();
        PrintUtil.title("                                                                               ╦ ╦╔═╗╦═╗╦  ╔╦╗ ╔═╗ ");
        PrintUtil.title("╔═════════════════════════════════════════════════════════════════════════════ ║║║║ ║╠╦╝║   ║║ ╔═╝ ═════════════════════════════════════════════════════════════════════════╗");
        PrintUtil.title("                                                                               ╚╩╝╚═╝╩╚═╩═╝═╩╝ ╚═╝ \n");
        PrintUtil.title("░██████████░██     ░██ ░██████████    ░██████████  ░██████   ░██       ░██ ░███    ░██      ░██████   ░██████████   ░███████   ░██████████   ░██████     ░███    ░██     ░██ \n" +
                "    ░██    ░██     ░██ ░██                ░██     ░██   ░██  ░██       ░██ ░████   ░██     ░██   ░██  ░██           ░██   ░██  ░██          ░██   ░██   ░██░██    ░██   ░██  \n" +
                "    ░██    ░██     ░██ ░██                ░██    ░██     ░██ ░██  ░██  ░██ ░██░██  ░██    ░██     ░██ ░██           ░██    ░██ ░██         ░██         ░██  ░██    ░██ ░██   \n" +
                "    ░██    ░██████████ ░█████████         ░██    ░██     ░██ ░██ ░████ ░██ ░██ ░██ ░██    ░██     ░██ ░█████████    ░██    ░██ ░█████████  ░██        ░█████████    ░████    \n" +
                "    ░██    ░██     ░██ ░██                ░██    ░██     ░██ ░██░██ ░██░██ ░██  ░██░██    ░██     ░██ ░██           ░██    ░██ ░██         ░██        ░██    ░██     ░██     \n" +
                "    ░██    ░██     ░██ ░██                ░██     ░██   ░██  ░████   ░████ ░██   ░████     ░██   ░██  ░██           ░██   ░██  ░██          ░██   ░██ ░██    ░██     ░██     \n" +
                "    ░██    ░██     ░██ ░██████████        ░██      ░██████   ░███     ░███ ░██    ░███      ░██████   ░██           ░███████   ░██████████   ░██████  ░██    ░██     ░██     \n" +
                "                                                                                                                                                                             \n" +
                "                                                                                                                                                                             \n" +
                "                                                                                                                                                                             \n" +
                "                                                                           ░███    ░███    ░██ ░███████                                                                      \n" +
                "                                                                          ░██░██   ░████   ░██ ░██   ░██                                                                     \n" +
                "                                                                         ░██  ░██  ░██░██  ░██ ░██    ░██                                                                    \n" +
                "                                                                        ░█████████ ░██ ░██ ░██ ░██    ░██                                                                    \n" +
                "                                                                        ░██    ░██ ░██  ░██░██ ░██    ░██                                                                    \n" +
                "                                                                        ░██    ░██ ░██   ░████ ░██   ░██                                                                     \n" +
                "                                                                        ░██    ░██ ░██    ░███ ░███████                                                                      \n" +
                "                                                                                                                                                                             \n" +
                "                                                                                                                                                                             \n" +
                "                                                                                                                                                                             \n" +
                "   ░██████████░██     ░██ ░██████████    ░████████   ░██            ░███      ░██████  ░██     ░██      ░██████     ░███      ░██████   ░██████████░██         ░██████████   \n" +
                "       ░██    ░██     ░██ ░██            ░██    ░██  ░██           ░██░██    ░██   ░██ ░██    ░██      ░██   ░██   ░██░██    ░██   ░██      ░██    ░██         ░██           \n" +
                "       ░██    ░██     ░██ ░██            ░██    ░██  ░██          ░██  ░██  ░██        ░██   ░██      ░██         ░██  ░██  ░██             ░██    ░██         ░██           \n" +
                "       ░██    ░██████████ ░█████████     ░████████   ░██         ░█████████ ░██        ░███████       ░██        ░█████████  ░████████      ░██    ░██         ░█████████    \n" +
                "       ░██    ░██     ░██ ░██            ░██     ░██ ░██         ░██    ░██ ░██        ░██   ░██      ░██        ░██    ░██         ░██     ░██    ░██         ░██           \n" +
                "       ░██    ░██     ░██ ░██            ░██     ░██ ░██         ░██    ░██  ░██   ░██ ░██    ░██      ░██   ░██ ░██    ░██  ░██   ░██      ░██    ░██         ░██           \n" +
                "       ░██    ░██     ░██ ░██████████    ░█████████  ░██████████ ░██    ░██   ░██████  ░██     ░██      ░██████  ░██    ░██   ░██████       ░██    ░██████████ ░██████████   \n" +
                "                                                                                                                                                                             \n" +
                "                                                                                                                                                                               " +
                "                                                                                                                                                                             ");
        PrintUtil.title("╚═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
        InputUtil.pressEnterToContinue();
        System.out.println();

        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println();
        PrintUtil.story(
                """
                        As you make your way through the forest, you finally reach its edge and find that there lies a town.
                        Relief surges—until you get nearer and see the town closer.The place is diseased.
                        """
        );
        PrintUtil.sayGreen("Khai the Gray says, \"Children cough in alleys, merchants peddle spoiled goods, and hollow-eyed guards demand bribes.\"");
        System.out.println();
        PrintUtil.story("This town used to be the epitome of peace and unity. Now, every face tells the same story: something has poisoned this world.");

//        PrintUtil.sayGreen("\"The Stones,\" Khai murmurs. \"They are both a curse and a cure.\"\n");
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        InputUtil.pressEnterToContinue();

        // -------------------- Plague Vermins --------------------
        System.out.println();
        PrintUtil.line();
        PrintUtil.story("""
        🐀 The stench of rot fills the air.
        From the sewers, three Plague Vermins scuttle out—diseased, hissing, and hungry.
        Their claws drip with venomous filth.
        """);

        PrintUtil.pause(1500);
        System.out.println();
        PrintUtil.enemyEncounter("                  .                                       ");
        PrintUtil.enemyEncounter("                --.                                       ");
        PrintUtil.enemyEncounter("              .-++       ..                               ");
        PrintUtil.enemyEncounter("             -=:.     :==*#*+=-:      *%%*:               ");
        PrintUtil.enemyEncounter("             -*++.   :+%%%%%%#+-.    .*  .=*=             ");
        PrintUtil.enemyEncounter("              .+-  .= .+%%%%%%%*=.    *     -=.           ");
        PrintUtil.enemyEncounter("               .=.    -#%%%%%%@@%-  .+-      -.           ");
        PrintUtil.enemyEncounter("               .+%-.=+#@@@%@@@@@%*##%#=      .            ");
        PrintUtil.enemyEncounter("  .             .+. %%@@##@@@@@@@@@==:   ..               ");
        PrintUtil.enemyEncounter("  =-     =--..::..+ *@@*:+%@@%@%%@%-+..  :=:              ");
        PrintUtil.enemyEncounter("  .:=#-.*#%%+##+-.+ :#=.-#@%@%@%++++:.#.-#:::.  :*-:      ");
        PrintUtil.enemyEncounter("   .--=-.+%%@@@#-.-+ :..*@@@@%@@*:==::*=*@@@@%*:-*.:.     ");
        PrintUtil.enemyEncounter("   .-=:==. =@@%#- .+- .+@@@@@@@@*:=*-:+%@@@@%#%%#-*-+:    ");
        PrintUtil.enemyEncounter("   .=+.    .#@*:*-++*.+%@@@@@@@@#+-.-%@@@@@@%%@@%+.:-:    ");
        PrintUtil.enemyEncounter("           +%%#:=*%@#=*@@@@@@@@@@#:-+@@@@@@@@@@@@#+:.*=   ");
        PrintUtil.enemyEncounter("          -@@@%**:==.+=@@@@@@@@@@%=+:#@@@@@@@@@@@@-       ");
        PrintUtil.enemyEncounter("         :%=%#++.    =-*%**%@@@@@@+..%@@@@@@@@@@%-#       ");
        PrintUtil.enemyEncounter("     ..  :%:=::*+.....==#--:=.==##*:.#@@@@@@@@@@=.-..     ");
        PrintUtil.enemyEncounter("     :-:: -+=##+*--#%###+#%@=#%+*=#+*+@@%*#%%%@@ -:-.     ");
        PrintUtil.enemyEncounter("    .:=--.-#-=*%#%##%%@@%@@@@@@@@@%@#%@+*@@#-*%=+=+=..    ");
        PrintUtil.enemyEncounter("   ..-=+#@@@@@@@%@@@@@@@@@@@@@@@@@@@@@@@@@@@@%@@**=+-.    ");
        PrintUtil.enemyEncounter("      :=-+#%*@%%@@@@@@@@@@@@@@@@@@@@@@%@@@@@%%#-*--...    ");
        PrintUtil.enemyEncounter("      ..-.::+##**%%*++*#%%%%@##*#@@@%%%%%%*=+-:*::-.      ");
        PrintUtil.enemyEncounter("         --::=-:=++=**#*#+-=+%#*===+=:--+=-:--+:.--       ");
        PrintUtil.enemyEncounter("               . :-+=-:-===.+:  :==-=+=   :-:             ");
        PrintUtil.enemyEncounter("                   .          .:.                          ");
        System.out.println();

        PrintUtil.objective(("🎯 Objective: Defeat 3 Plague Vermins!"));
        PrintUtil.line();
        InputUtil.pressEnterToContinue();

        Enemy enemy1 = new World2Enemy1();
        Battle battle1 = new Battle(player, enemy1);

        System.out.println();
        enemy1.displaySkills();
        InputUtil.pressEnterToContinue();
        System.out.println();

        for(int i = 1; i <= 3; i++){
            System.out.println(ColorUtil.boldBrightRed("═══════════════════════════════════"));
            PrintUtil.enemyEncounter("🐀 Plague Vermin " + i + " lunges at you!");
            System.out.println(ColorUtil.boldBrightRed("═══════════════════════════════════"));
            InputUtil.pressEnterToContinue();

            battle1.startBattle();

            System.out.println();
            System.out.println(ColorUtil.boldBrightGreen("───────────────────────────────────────"));
            PrintUtil.enemyDefeated("✅ You have defeated Plague Vermin " + i + "!");
            System.out.println(ColorUtil.boldBrightGreen("───────────────────────────────────────"));
            enemy1.dropLoot(player);

            if (i < 3) { // reset for next vermin
                enemy1 = new World2Enemy1();
                battle1 = new Battle(player, enemy1);
            }
        }

        PrintUtil.objective(("🎯 Objective: Defeat 3 Plague Vermins! ✅ (3 / 3)"));
        System.out.println();
        PrintUtil.line();
        PrintUtil.victory("""
            🎉 Victory! The last of the Plague Vermin's collapses into the sludge.
            The foul air clears just enough for you to breathe again.
            """);
        PrintUtil.loot("You gain experience and claim the rewards from the grim battle.");
        PrintUtil.line();
        InputUtil.pressEnterToContinue();
        player.getEffects().resetAllEffects();

        // -------------------- Forsaken Cultists --------------------
        System.out.println();
        PrintUtil.line();
        PrintUtil.effect("You wander through the town's crumbling streets.");
        PrintUtil.effect("Townsfolk whisper rumors between coughs.");
        System.out.println();
        PrintUtil.story(
                "You can trade, gather rumors, and help townsfolk—small acts of kindness that might matter later.\n" +
                        "They tell you of the *Necromancer*, a phantom who rules from the shadows.\n" +
                        "His grip spreads from the Black Castle, where the Corrupted King hoards the Second Stone.\n"
        );
        InputUtil.pressEnterToContinue();

        PrintUtil.story("The townsfolk warn of zealots who worship decay itself...");
        System.out.println();
        PrintUtil.story("""
                In a ruined chapel, two Forsaken Cultists emerge,
                their eyes glowing with fanatic light as they chant forbidden rites.
                """);

        PrintUtil.pause(1500);
        System.out.println();
        PrintUtil.enemyEncounter("        . -                                                ");
        PrintUtil.enemyEncounter("       ==+#*   +@@*..                  :-.                 ");
        PrintUtil.enemyEncounter("       .+%++  -@@@@@@@@*.        .-+%@@@@@:                ");
        PrintUtil.enemyEncounter("         -#    *@@@@@@@@#       :%@@@@@@@@-                ");
        PrintUtil.enemyEncounter("         :*.   :=%@@@@@@@*.    :%@@@@@@@@*                 ");
        PrintUtil.enemyEncounter("         :.*     @@%@@@@@%#.  :%@@@@@@@:=.                 ");
        PrintUtil.enemyEncounter("         : *   .*@..=@@@@*#+  %*#@@@%*%:.                  ");
        PrintUtil.enemyEncounter("           #@%%#%+ :#@@@@%#+ .%#%@@@%#@*                   ");
        PrintUtil.enemyEncounter("            =.  - .#@@@@@@@=. *@@@@@@#-#-                  ");
        PrintUtil.enemyEncounter("            .*   :#%@@@@@@@%- #@@@@@@@*=@:                 ");
        PrintUtil.enemyEncounter("             -.  .+@@@@@@@@-  =@@@@@@@#:#@=                ");
        PrintUtil.enemyEncounter("             -=   %@@@@@@@@=  +@@@@@@@@-  -%*.             ");
        PrintUtil.enemyEncounter("             .-. -@@@@@@@@@=  +@@@@@@@@%     *%=.          ");
        PrintUtil.enemyEncounter("              =- -@@@@@@@@@+  *@@@@@@@@%                   ");
        PrintUtil.enemyEncounter("              .-..@@@@@@@@@*  *@@@@@@@@#                   ");
        PrintUtil.enemyEncounter("               +:.@@@@@@@@@#. %@@@@@@@@#                   ");
        PrintUtil.enemyEncounter("               .=.%@@@@@@@@#..#@@@@@@@@=                   ");
        PrintUtil.enemyEncounter("                *=@@@@@@@@@@=+@@@@@@@@@#                   ");
        PrintUtil.enemyEncounter("          :+*%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%*=.            ");
        PrintUtil.enemyEncounter("                   :--=--==+++==-----:    ..               ");
        System.out.println();

        PrintUtil.objective(("🎯 Objective: Defeat 2 Forsaken Cultists!"));
        PrintUtil.line();
        InputUtil.pressEnterToContinue();

        Enemy enemy2 = new World2Enemy2();
        Battle battle2 = new Battle(player, enemy2);

        System.out.println();
        enemy2.displaySkills();
        InputUtil.pressEnterToContinue();
        System.out.println();

        for (int i = 1; i <= 2; i++) {
            System.out.println(ColorUtil.boldBrightRed("═══════════════════════════════════════════════════"));
            PrintUtil.enemyEncounter("☠️ Forsaken Cultist " + i + " has began chanting a spell!");
            System.out.println(ColorUtil.boldBrightRed("═══════════════════════════════════════════════════"));
            InputUtil.pressEnterToContinue();

            battle2.startBattle();

            System.out.println();
            System.out.println(ColorUtil.boldBrightGreen("─────────────────────────────────────────"));
            PrintUtil.enemyDefeated("✅ You have defeated Forsaken Cultist " + i + "!");
            System.out.println(ColorUtil.boldBrightGreen("─────────────────────────────────────────"));
            enemy2.dropLoot(player);

            if (i < 2) {
                enemy2 = new World2Enemy2();
                battle2 = new Battle(player, enemy2);
            }
        }

        PrintUtil.objective(("🎯 Objective: Defeat 2 Forsaken Cultists! ✅ (2 / 2)"));
        System.out.println();
        PrintUtil.line();
        PrintUtil.victory("""
                🎉 Victory! The cultists’ chants fade into silence.
                The air still hums with dark energy, but you stand victorious.
                """);
        PrintUtil.loot("You gain experience and rewards from your victorious fight.");
        PrintUtil.line();
        InputUtil.pressEnterToContinue();
        player.getEffects().resetAllEffects();

        // -------------------- Blight Hounds --------------------
        System.out.println();
        PrintUtil.line();
        PrintUtil.effect("A low growl echoes from the halls ahead...");
        System.out.println();
        PrintUtil.story("""
                From the black mist, three Blight Hounds leap forth,
                their fangs glinting and bodies wrapped in poisonous clouds.
                """);

        PrintUtil.pause(1500);
        System.out.println();
        PrintUtil.enemyEncounter("                  -             .-=+-. ::      .:         ");
        PrintUtil.enemyEncounter("            .- ....=               :-*%%%@+..+%-.         ");
        PrintUtil.enemyEncounter("            :-*%@%@@%*             .::+%*#@@%@@%*=.       ");
        PrintUtil.enemyEncounter("     --    .*%@@@@@@@%#-::.           . -%@@@@@@@%%+.     ");
        PrintUtil.enemyEncounter("    =#:   +@@@%@@@@@@%@#-:-    ::=. :+@@@@@@@@@@@%@@=     ");
        PrintUtil.enemyEncounter("   ::   :%@@@%@%%@@@@%%@@#:   .+. .+#@@%%%*@@@@% :#*#.    ");
        PrintUtil.enemyEncounter("  .=  .**.@%:*@#%@#%--@@%-     .::..#@:.%%:=%-+#%-        ");
        PrintUtil.enemyEncounter("   :*+: =#= -%=:*@-@= .++:        +-  :*    ++.  =+       ");
        PrintUtil.enemyEncounter("        %:   =+. -@-%-.          ==    =*:   =*.          ");
        PrintUtil.enemyEncounter("        --     .  -*-:.                       .:.         ");
        PrintUtil.enemyEncounter("                                                          ");
        PrintUtil.enemyEncounter("                                      :.                  ");
        PrintUtil.enemyEncounter("                                 ..:+=#*-                 ");
        PrintUtil.enemyEncounter("                                 =+=+=+%=-=.              ");
        PrintUtil.enemyEncounter("                                 :+#%@@@@%*+-             ");
        PrintUtil.enemyEncounter("                        .--:   :.-*%@@@@@@@#- .           ");
        PrintUtil.enemyEncounter("                           +..#@%#@@@@@@@%@@*=%=.#%:      ");
        PrintUtil.enemyEncounter("                          :-:%%=%%%%@%%@%@@@@#*%%+#%-     ");
        PrintUtil.enemyEncounter("                         .+.*%=%@%%@%%%@%%@@@%#+.=*%#:    ");
        PrintUtil.enemyEncounter("                          =%@#+=@%#%%#@@%%@@@%%*=+@#*=    ");
        PrintUtil.enemyEncounter("                           :% @%%- *@%+. :**#*%.  +%#+    ");
        PrintUtil.enemyEncounter("                            #++:#- .%%:     +@-   .%%=    ");
        PrintUtil.enemyEncounter("                            =@: ++  :%%%-   =*.   .%*.    ");
        PrintUtil.enemyEncounter("                            :=: .+-  .##.         =*      ");
        PrintUtil.enemyEncounter("                                  -:   :*:       :=       ");
        PrintUtil.enemyEncounter("                                         .:.               ");
        PrintUtil.enemyEncounter("                                                          ");
        System.out.println();

        PrintUtil.objective(("🎯 Objective: Defeat 3 Blight Hounds!"));
        PrintUtil.line();
        InputUtil.pressEnterToContinue();

        Enemy enemy3 = new World2Enemy3();
        Battle battle3 = new Battle(player, enemy3);

        System.out.println();
        enemy3.displaySkills();
        InputUtil.pressEnterToContinue();
        System.out.println();

        for (int i = 1; i <= 3; i++) {
            System.out.println(ColorUtil.boldBrightRed("═════════════════════════════════════"));
            PrintUtil.enemyEncounter("🐕 Blight Hound " + i + " snarls and lunges!");
            System.out.println(ColorUtil.boldBrightRed("═════════════════════════════════════"));
            InputUtil.pressEnterToContinue();

            battle3.startBattle();

            System.out.println();
            System.out.println(ColorUtil.boldBrightGreen("───────────────────────────────────────"));
            PrintUtil.enemyDefeated("✅ You have defeated Blight Hound " + i + "!");
            System.out.println(ColorUtil.boldBrightGreen("───────────────────────────────────────"));
            enemy3.dropLoot(player);

            if (i < 3) {
                enemy3 = new World2Enemy3();
                battle3 = new Battle(player, enemy3);
            }
        }

        PrintUtil.objective(("🎯 Objective: Defeat 3 Blight Hounds! ✅ (3 / 3)"));
        System.out.println();
        PrintUtil.line();
        PrintUtil.victory("""
                🎉 Victory! The Blight Hounds are no more.
                The air still hums with dark energy, but you stand victorious.
                """);
        PrintUtil.loot("You gain experience and loot from the defeated enemies.");
        PrintUtil.line();
        InputUtil.pressEnterToContinue();
        player.getEffects().resetAllEffects();

        // -------------------- Ghoul Footmen --------------------
        System.out.println();
        PrintUtil.line();
        PrintUtil.title("THE BLACK CASTLE");
        System.out.println();

        PrintUtil.event("Thunder cracks as you push open the gates.");
        PrintUtil.effect("Once Honorable Knights are now found with cracked armor and bleeding eyes lurch from the darkness.");

        PrintUtil.story("""
                Two Ghoul Footmen emerge, dragging rusted blades.
                Their movements are jerky, puppets of a cruel master.
                """);

        PrintUtil.pause(1500);
        System.out.println();
        PrintUtil.enemyEncounter("                  .+.                                     ");
        PrintUtil.enemyEncounter("                   .*-+#-                                 ");
        PrintUtil.enemyEncounter("                .#%%@%*=                                  ");
        PrintUtil.enemyEncounter("    ..           :%@@+-#-                                 ");
        PrintUtil.enemyEncounter("    :=.           .#@%-.**.          -*-                  ");
        PrintUtil.enemyEncounter("  .=.=-              :-  -*:     .:.-@@#+: ::             ");
        PrintUtil.enemyEncounter("  :%@@@@*                  *%*  .=#@@@@@@%%%+:            ");
        PrintUtil.enemyEncounter("   +@%*#-                  +@@:.*@@@@@@@@@%*+#=-.         ");
        PrintUtil.enemyEncounter("   .+#:*=        =%*  .:   :@@*%@@@@@@%#@@@@@@#.          ");
        PrintUtil.enemyEncounter("     -=:#      .-%@@%**+-  .#@@@@@@@@@@%%@@@@@@-          ");
        PrintUtil.enemyEncounter("      . ==     .*@@@@@%###: :*@%#+#@@@@@@@@@@@@*          ");
        PrintUtil.enemyEncounter("       ..*.    :#@@@@@@@@@*.  -=. .*@@@@@@@%#@@%:         ");
        PrintUtil.enemyEncounter("         .*    .#@@@@@@@@%@#.  .  .#@@@%@%%@@@@@%:        ");
        PrintUtil.enemyEncounter("          ==   :#@%@@@@@@@%@%=   .*@@@@@@@@@@@@%#*:       ");
        PrintUtil.enemyEncounter("          =@%#%@@+:-@@@@@%%@@#-  -%@@@@@@@@@@@@%+:-       ");
        PrintUtil.enemyEncounter("           :+ :++..#@@@@@@@@@++..*@@@@@@@@@@@@@@=::.      ");
        PrintUtil.enemyEncounter("            -- .: +@@@@@@@@@%*-.:#@@@@@@@@@@@@@@@: .      ");
        PrintUtil.enemyEncounter("            .=.  -@@@@@@@@@@@*:.=@@@@@@@@@@@@@@@**+       ");
        PrintUtil.enemyEncounter("             -= .#@@@@@@@@@@@#+:%@@@@@@@@@@@@@@@*:..      ");
        PrintUtil.enemyEncounter("             .=:+@@@@@@@@@@@#+:.=@@%%@@@@@%@@%%+*+        ");
        PrintUtil.enemyEncounter("              -- *@@#@@@#%@@%+. :%@%-*#+@##@@@==  -       ");
        PrintUtil.enemyEncounter("               =::@% -**=:#@= . :%%: ..=-:.-%@: .  .      ");
        PrintUtil.enemyEncounter("               .=.%#   .. .%+   =@#:    .   +@+  :        ");
        PrintUtil.enemyEncounter("             .:.=+@@. .:+=:#@.:#@@%=+=--::. +@@-=.        ");
        PrintUtil.enemyEncounter("         ..-+#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%#=.     ");
        PrintUtil.enemyEncounter("             ..:-====+****##%%%%###*##**++-:::::.         ");
        PrintUtil.enemyEncounter("                                                          ");
        System.out.println();

        PrintUtil.objective(("🎯 Objective: Defeat 2 Ghoul Footmen!"));
        PrintUtil.line();
        InputUtil.pressEnterToContinue();

        Enemy enemy4 = new World2Enemy4();
        Battle battle4 = new Battle(player, enemy4);

        System.out.println();
        enemy4.displaySkills();
        InputUtil.pressEnterToContinue();
        System.out.println();

        for(int i = 1; i <= 2; i++){
            System.out.println(ColorUtil.boldBrightRed("════════════════════════════════════════"));
            PrintUtil.enemyEncounter("🪓 Ghoul Footman " + i + " staggers toward you!");
            System.out.println(ColorUtil.boldBrightRed("════════════════════════════════════════"));
            InputUtil.pressEnterToContinue();

            battle4.startBattle();

            System.out.println();
            System.out.println(ColorUtil.boldBrightGreen("───────────────────────────────────────"));
            PrintUtil.enemyDefeated("✅ You have defeated Ghoul Footman " + i + "!");
            System.out.println(ColorUtil.boldBrightGreen("───────────────────────────────────────"));
            enemy4.dropLoot(player);

            if (i < 2) {
                enemy4 = new World2Enemy4();
                battle4 = new Battle(player, enemy4);
            }
        }

        PrintUtil.objective(("🎯 Objective: Defeat 2 Ghoul Footmen! ✅ (2 / 2)"));
        System.out.println();
        PrintUtil.line();
        PrintUtil.victory("""
                🎉 Victory! The last ghoul crumbles into dust.
                You tighten your grip on your weapon, ready for whatever lies ahead.
                """);
        PrintUtil.loot("You gain experience and gather loot from your triumph.");
        PrintUtil.line();
        InputUtil.pressEnterToContinue();
        player.getEffects().resetAllEffects();

        // -------------------- Mini-Boss: The Black Jailer --------------------
        System.out.println();
        PrintUtil.event("                                                                                                            \n" +
                "                                                                                                            \n" +
                "██▄  ▄██ ▄▄ ▄▄  ▄▄ ▄▄ ▄▄▄▄   ▄▄▄   ▄▄▄▄  ▄▄▄▄   ██████ ▄▄  ▄▄  ▄▄▄▄  ▄▄▄  ▄▄ ▄▄ ▄▄  ▄▄ ▄▄▄▄▄▄ ▄▄▄▄▄ ▄▄▄▄    \n" +
                "██ ▀▀ ██ ██ ███▄██ ██ ██▄██ ██▀██ ███▄▄ ███▄▄   ██▄▄   ███▄██ ██▀▀▀ ██▀██ ██ ██ ███▄██   ██   ██▄▄  ██▄█▄ ▀ \n" +
                "██    ██ ██ ██ ▀██ ██ ██▄█▀ ▀███▀ ▄▄██▀ ▄▄██▀   ██▄▄▄▄ ██ ▀██ ▀████ ▀███▀ ▀███▀ ██ ▀██   ██   ██▄▄▄ ██ ██ ▄ \n" +
                "                                                                                                            ");
        PrintUtil.pause(1500);

        PrintUtil.event("                                                                                       \n" +
                "                                                                                       \n" +
                "██████ ▄▄ ▄▄ ▄▄▄▄▄   █████▄ ▄▄     ▄▄▄   ▄▄▄▄ ▄▄ ▄▄      ██  ▄▄▄  ▄▄ ▄▄    ▄▄▄▄▄ ▄▄▄▄  \n" +
                "  ██   ██▄██ ██▄▄    ██▄▄██ ██    ██▀██ ██▀▀▀ ██▄█▀      ██ ██▀██ ██ ██    ██▄▄  ██▄█▄ \n" +
                "  ██   ██ ██ ██▄▄▄   ██▄▄█▀ ██▄▄▄ ██▀██ ▀████ ██ ██   ████▀ ██▀██ ██ ██▄▄▄ ██▄▄▄ ██ ██ \n" +
                "                                                                                       ");

        PrintUtil.objective("═════════════════════════════════════════════════════════════════════════════════");
        System.out.println();
        PrintUtil.effect("""
               In the dungeons below, chains rattle.
               The Black Jailer steps from the shadows, dragging hooks and blades behind him.
                """);
        PrintUtil.objective("═════════════════════════════════════════════════════════════════════════════════");
        System.out.println();

        PrintUtil.pause(1500);
        System.out.println();
        PrintUtil.enemyEncounter("                                        :+#-              ");
        PrintUtil.enemyEncounter("                         .=. .+        .++=*-             ");
        PrintUtil.enemyEncounter("                         =#@%%#:        --.-.             ");
        PrintUtil.enemyEncounter("                          *%@#=         :*=-              ");
        PrintUtil.enemyEncounter("                     .+*=#%%#%%*+*:     .%#:              ");
        PrintUtil.enemyEncounter("                    %@@@%%%#%#%%%@@#.   .*+               ");
        PrintUtil.enemyEncounter("                   *@@@@%#@%%#%#%@@@+    +-               ");
        PrintUtil.enemyEncounter("                   #%#%#%%%@@%%%%#%%*   .+-               ");
        PrintUtil.enemyEncounter("                  =@%%@@@@@%@@%@@@%%%+:.=#=.              ");
        PrintUtil.enemyEncounter("                 *#@%%%@@@%@@@@%@@@@%@@%#%#:              ");
        PrintUtil.enemyEncounter("                :#%%%%@%##%%%%%##@@@%#*==#.               ");
        PrintUtil.enemyEncounter("                =%@@@@@%%%*#%#*#%%@@@@- .#.               ");
        PrintUtil.enemyEncounter("        *-+:   .*%#=@%%@#%%%@@#%*@@@@@@#-#                ");
        PrintUtil.enemyEncounter("     .+%@%@%*  :*%#%@%@%#%#%@@#%#%@@@@@@@%:               ");
        PrintUtil.enemyEncounter("     .+@@%@@#**+---@@@@%##%#@@@%#%@@@@@@@@@%*:           ");
        PrintUtil.enemyEncounter("       *@@%@@=    :@@%@%%%%%@@@%%@@@@@@@@@@@@@@#-        ");
        PrintUtil.enemyEncounter("       =%@@@@%=   =@@%%%@@@%@@@@@%#@@@@@@%#%%%#@@@+.      ");
        PrintUtil.enemyEncounter("       +@%%#@%+   -@@%@@@%%@@@%%@@%@@@@@@@#-...- .*%-     ");
        PrintUtil.enemyEncounter("       .=###+:    :@#%@@@%@@@%@%@@@@@@@@@@@@*.     .-:    ");
        PrintUtil.enemyEncounter("                   +@%%%#@@@@@@%%%%%@@@@@@@@@@*           ");
        PrintUtil.enemyEncounter("                    %%@@@@@@@@@%@@@@@##%@#  .-*=          ");
        PrintUtil.enemyEncounter("                     %@@@@*=###%%@@@@@@-#.    ..          ");
        PrintUtil.enemyEncounter("                    .@@#-*%-.#. :%@+ .-=%:                ");
        PrintUtil.enemyEncounter("                    +%%+   =-   :#%%-  .%                  ");
        PrintUtil.enemyEncounter("                  .%@@#-        .*#%@%::#                  ");
        PrintUtil.enemyEncounter("                   ::.             .::.                    ");
        System.out.println();

        PrintUtil.objective(("🎯 Objective: Defeat The Black Jailer!"));
        PrintUtil.line();
        InputUtil.pressEnterToContinue();

        Enemy miniBoss = new World2Miniboss1();
        Battle miniBattle = new Battle(player, miniBoss);

        System.out.println();
        miniBoss.displaySkills();
        InputUtil.pressEnterToContinue();
        System.out.println();

        miniBattle.startBattle();

        System.out.println();
        PrintUtil.objective(("🎯 Objective: Defeat The Black Jailer! ✅"));
        System.out.println();
        PrintUtil.line();
        PrintUtil.victory("""
                ✅🏆 Mini-Boss Defeated!
                The Black Jailer drops to his knees, his chains falling silent.
                You have triumphed over his tyranny.
                """);
        PrintUtil.loot("You gain rare loot and a surge of experience!");
        PrintUtil.line();
        miniBoss.dropLoot(player);
        InputUtil.pressEnterToContinue();
        PrintUtil.line();
        player.getEffects().resetAllEffects();

        // -------------------- Boss: The Corrupted King --------------------
        System.out.println();
        PrintUtil.event("                                                                                                            \n" +
                "                                                                                          \n" +
                "                                                                                          \n" +
                "█████▄ ▄████▄ ▄█████ ▄█████   ██████ ▄▄  ▄▄  ▄▄▄▄  ▄▄▄  ▄▄ ▄▄ ▄▄  ▄▄ ▄▄▄▄▄▄ ▄▄▄▄▄ ▄▄▄▄    \n" +
                "██▄▄██ ██  ██ ▀▀▀▄▄▄ ▀▀▀▄▄▄   ██▄▄   ███▄██ ██▀▀▀ ██▀██ ██ ██ ███▄██   ██   ██▄▄  ██▄█▄ ▀ \n" +
                "██▄▄█▀ ▀████▀ █████▀ █████▀   ██▄▄▄▄ ██ ▀██ ▀████ ▀███▀ ▀███▀ ██ ▀██   ██   ██▄▄▄ ██ ██ ▄ \n" +
                "                                                                                          ");
        PrintUtil.pause(1000);

        PrintUtil.event("                                                                                                                                                                     \n" +
                "                                                                                                                                                                     \n" +
                "██     ██  ██ ██████ ██  ██ ██████ █████▄        ██████ ██  ██ ██████   ▄█████ ▄████▄ █████▄  █████▄  ██  ██ █████▄ ██████ ██████ ████▄    ██ ▄█▀ ██ ███  ██  ▄████  \n" +
                "██     ██  ██   ██   ██████ ██▄▄   ██▄▄██▄         ██   ██████ ██▄▄     ██     ██  ██ ██▄▄██▄ ██▄▄██▄ ██  ██ ██▄▄█▀   ██   ██▄▄   ██  ██   ████   ██ ██ ▀▄██ ██  ▄▄▄ \n" +
                "██████ ▀████▀   ██   ██  ██ ██▄▄▄▄ ██   ██  ▄      ██   ██  ██ ██▄▄▄▄   ▀█████ ▀████▀ ██   ██ ██   ██ ▀████▀ ██       ██   ██▄▄▄▄ ████▀    ██ ▀█▄ ██ ██   ██  ▀███▀  \n" +
                "                                           ▀                                                                                                                         ");
        PrintUtil.pause(1500);

        PrintUtil.objective("════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println();
        PrintUtil.effect(
                "In the throne room, the King sits slumped—his crown fused to his skull. and on it, you see the second stone as its centerpiece.\n" +
                        "YOU DARE CHALLENGE MY AUTHORITY?! YOUR SKULL WILL BECOME BUT ANOTHER TROPHY IN MY HALLS."
        );
        System.out.println();
        PrintUtil.objective("════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println();

        PrintUtil.pause(1500);
        System.out.println();
        PrintUtil.enemyEncounter("@@@@@@@@@#+-:                               .-*#@@@@@@@@@@");
        PrintUtil.enemyEncounter("@@@@@@##@+                                      +%#%@@@@@@");
        PrintUtil.enemyEncounter("@@@@@##%%%.                  :                  %%###@@@@@");
        PrintUtil.enemyEncounter("@@@%+#%##%*                :.=-.               #@####+%@@@");
        PrintUtil.enemyEncounter("@@@@#%@##%@.               +%%*-              .%%##@%#@@@@");
        PrintUtil.enemyEncounter("@@%*:#@@%%@-               *#@#:              #@%#@@#-*%@@");
        PrintUtil.enemyEncounter("@@#- -%@%%@#           ..  -%@+    .          =@%#@@= -#@@");
        PrintUtil.enemyEncounter("@@%= .*@@#@.          .--: :#@= :=::           ##@@#. -#@@");
        PrintUtil.enemyEncounter("@@*.  =@@%#           .+%@%%%%%%@@*.           *#@@+   *@@");
        PrintUtil.enemyEncounter("@@+.  =@@%#           :%@@@%%@%%@@@=           +%@@+   +%@");
        PrintUtil.enemyEncounter("@@+. =@@@@@=.         .+####@@%#*+*- :        -%@@@@+  +@@");
        PrintUtil.enemyEncounter("@@+.  =@@@*.           -==*%#@##+:+-   -       *%@@+  .+@@");
        PrintUtil.enemyEncounter("@@+.  :%@%=         ..-#-:*=#@=*= +%=.-:       -%@@-  .+@@");
        PrintUtil.enemyEncounter("@@+.  .%@%-        ...**. :.#@-.. -#%-         :%@%:  .+@@");
        PrintUtil.enemyEncounter("@@+.  .%@%-      .-  .*- +@%%@#@%+:=*:.  .     :%@%:  .+@@");
        PrintUtil.enemyEncounter("@@+:  .%@%-       :::=*::+%@@@@@%*: *- :++:    :%@%:  -*@@");
        PrintUtil.enemyEncounter("@@+-  .%@#-          *+.+@@@@@@#%*.:##+:       :#@%: .-+%@");
        PrintUtil.enemyEncounter("@%+-  :%@#-          #:-#@@@@@@@%%*#%*         :#@@- .-+@@");
        PrintUtil.enemyEncounter("@@+-: :%@#-          ==-%@@@@@##%@@%:          :*@@=..-*@@");
        PrintUtil.enemyEncounter("@@+-. :%@%-           :*@@@@#%#@%%*-*:         :#@@+:.-*@@");
        PrintUtil.enemyEncounter("@@*=. :%@%= .:.      ..=*#%%%%#*#%*:           :%@%+-:-*@@");
        PrintUtil.enemyEncounter("@@*=-.-%@%= :-.        =%%@#@@@%+@=.           :%@@+---+@@");
        PrintUtil.enemyEncounter("@@*==-=@@%= .-.     .#@@%*#@@@%++@%:       .: .-%@#=-=+*@@");
        PrintUtil.enemyEncounter("@@#**-=#%%+ .:.   +@@@+*%#-+@*#--%%=       ::.:-##%+-*##@@");
        PrintUtil.enemyEncounter("@@#++-=###+:.::+@@@*- .*%+:-*=: :#%=       .: :-%@%*+###@@");
        PrintUtil.enemyEncounter("@@##*-+%@#+--*@@%=.   .*#:  =.   =@-    ..:--:-+%%#***%%@@");
        PrintUtil.enemyEncounter("@@%#%*#%%#+*@%*:      .*+   .    :#=    :..+=--+######*#@@");
        PrintUtil.enemyEncounter("@@@@###%#+#*=-----:   -%+        .#*..::----++*#%%@@%%@@@@");
        PrintUtil.enemyEncounter("@@@%@@%#%%@@%%#%#**==+%@*.     ..-#@#==+*%#%%%%%####@%%@@@");
        PrintUtil.enemyEncounter("@@@@@@@@@@@%@@@%%@@@@@@@@@@@%%@@@@@@@@@@@%@@@%@%@@@@@@*#@@");
        PrintUtil.enemyEncounter("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println();

        PrintUtil.objective(("🎯 Objective: Defeat The Corrupted King!"));
        PrintUtil.line();
        InputUtil.pressEnterToContinue();

        Enemy boss = new World2Miniboss2();
        Battle bossBattle = new Battle(player, boss);

        System.out.println();
        boss.displaySkills();
        InputUtil.pressEnterToContinue();
        System.out.println();

        bossBattle.startBattle();

        System.out.println();
        PrintUtil.objective(("🎯 Objective: Defeat The Corrupted King! ✅"));
        System.out.println();
        PrintUtil.line();
        PrintUtil.victory("""
                ✅👑 Final Victory! - Boss Defeated!
                The Corrupted King’s crown falls to the floor, echoing through the halls.
                The Darkness fades, and you stand as the savior of this cursed land.
                """);
        PrintUtil.loot("You gain immense experience and legendary loot!");
        PrintUtil.line();
        boss.dropLoot(player);
        InputUtil.pressEnterToContinue();
        PrintUtil.line();
        player.getEffects().resetAllEffects();

        //-------------------------------------------------
        System.out.println();
        PrintUtil.effect("The King's breath rattles. A faint glimmer of humanity returns to his eyes.");
        System.out.println();
        PrintUtil.sayRed("Corrupted King", "\"It's… It's you!!! NO!!!…\"");
        System.out.println();
        PrintUtil.effect("He screams with his dying breath as his body crumbles into dust, leaving only confusion of who he was referring to.");
        InputUtil.pressEnterToContinue();

        System.out.println(ColorUtil.brightCyan("                                     \n" +
                "                                     \n" +
                "                                     \n" +
                "          *%%##********+=+=          \n" +
                "        +%%@@@@@##**+=====**-        \n" +
                "      -%%%%@@@@@@@%*+====-+**+.      \n" +
                "    :%%%%%@@@@@@@@@@@@%*=-=****+.    \n" +
                "  .%%%%%%%@@@@@@@@@@@%#######****+   \n" +
                "  *%###%%@@%###%@@@@@%#####%%%%%%%+  \n" +
                "  *@%%%%@@@%##%@@@@@@%####%@%%%%%@+  \n" +
                "  *@@@@@@@@%##%@@@@@@%##%@@@@%%%@@+  \n" +
                "  *@@@@#%@@@@%@@@@@@@%%@@@@@@@%@@@+  \n" +
                "  *@@@%%##@@@@@@@@@@@@@@@@@@@@@@@@+  \n" +
                "  *@@%%%##%@%%##%@@@@@@@@@@@@@@@@@+  \n" +
                "  *@%%%%%#######%@@@@@@@@@@@@@@@@@+  \n" +
                "  *%%%%%%%#####%%@@@@@@@@@@@@@@@@@*  \n" +
                "   =%@@@@@#%@@@@@@@@@@@@@@%%@@@@%:   \n" +
                "     +@@@@%###%%@@%%@@@@@@%@@@%=     \n" +
                "       *@@%#######%%@@@@@@#%@=       \n" +
                "        .#@####%%%%%%%@@@%#*         \n" +
                "          :+*************+           \n" +
                "                                     \n" +
                "                                     "));

        PrintUtil.loot("You lift the Second Stone from his crown, feeling its dark energy pulse in your hands.");
        PrintUtil.pause(800);
        System.out.println();
        PrintUtil.effect("A cold wind sweeps through the empty halls, extinguishing every torch and whispering secrets of the past.");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        // ---------------------- MAGIC SHOP ------------------------
        System.out.println();
        PrintUtil.story("""
        As you take a step forward, a strange pull brushes against your soul.
        The world itself feels like it is shifting around you.
        """);

        //type slow
        PrintUtil.effect("""
        ✨ Something… or someone… is calling to you.
        """);
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        PrintUtil.effect("""
        🔮 A brilliant flash lights up the room!
        From the shattered shadows, a glowing arcane doorway forms before you.
        
        A calm, ancient voice echoes:
        "Hero of this land… you are granted *one chance* to reshape your fate."
        
        🏺 The **One-Time Magic Shop** has appeared.
        ❗ Once you close it… it will disappear forever.
        """);
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        MagicShop shop = new MagicShop(player);
        shop.openShop();

        PrintUtil.line();
        PrintUtil.effect("🌟 The glow of the Magic Shop fades, leaving only silence behind.");
        PrintUtil.effect("""
        The doorway vanishes as suddenly as it appeared,
        leaving you alone in the quiet halls of the castle.
        
        🌟 Whatever choices you made within… will echo in the battles to come.
        Your journey continues, hero. The fate of this land rests in your hands.
        """);
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        PrintUtil.effect("""
        The castle seems to hold its breath.
        The choices you've made, the treasures you've claimed…
        all will shape the path ahead.
        """);
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

    }
}