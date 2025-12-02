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
        System.out.println("                                                                               ╦ ╦╔═╗╦═╗╦  ╔╦╗ ╔═╗ ");
        System.out.println("╔═════════════════════════════════════════════════════════════════════════════ ║║║║ ║╠╦╝║   ║║ ╔═╝ ═════════════════════════════════════════════════════════════════════════╗");
        System.out.println("                                                                               ╚╩╝╚═╝╩╚═╩═╝═╩╝ ╚═╝ \n");
        System.out.println("░██████████░██     ░██ ░██████████    ░██████████  ░██████   ░██       ░██ ░███    ░██      ░██████   ░██████████   ░███████   ░██████████   ░██████     ░███    ░██     ░██ \n" +
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
        System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
        System.out.println("=======================================================================================================");
        System.out.println();
        PrintUtil.type(
                "Beyond the forest lies a town. Relief surges—until you step closer. The place is diseased.\n" +
                        "Children cough in alleys, merchants peddle spoiled goods, and hollow-eyed guards demand bribes.\n" +
                        "Every face tells the same story: something has poisoned this world.\n"
        );

        PrintUtil.say("Khai the Grey", "\"The Stones,\" he murmurs. \"They are both a curse and a cure.\"\n");
        System.out.println("=======================================================================================================");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        // -------------------- Plague Vermins --------------------
        PrintUtil.line();
        PrintUtil.type("""
        🐀 The stench of rot fills the air.
        From the sewers, three Plague Vermins scuttle out—diseased, hissing, and hungry.
        Their claws drip with venomous filth.
        """);

        PrintUtil.pause(1500);
        System.out.println();
        System.out.println("                  .                                       ");
        System.out.println("                --.                                       ");
        System.out.println("              .-++       ..                               ");
        System.out.println("             -=:.     :==*#*+=-:      *%%*:               ");
        System.out.println("             -*++.   :+%%%%%%#+-.    .*  .=*=             ");
        System.out.println("              .+-  .= .+%%%%%%%*=.    *     -=.           ");
        System.out.println("               .=.    -#%%%%%%@@%-  .+-      -.           ");
        System.out.println("               .+%-.=+#@@@%@@@@@%*##%#=      .            ");
        System.out.println("  .             .+. %%@@##@@@@@@@@@==:   ..               ");
        System.out.println("  =-     =--..::..+ *@@*:+%@@%@%%@%-+..  :=:              ");
        System.out.println("  .:=#-.*#%%+##+-.+ :#=.-#@%@%@%++++:.#.-#:::.  :*-:      ");
        System.out.println("   .--=-.+%%@@@#-.-+ :..*@@@@%@@*:==::*=*@@@@%*:-*.:.     ");
        System.out.println("   .-=:==. =@@%#- .+- .+@@@@@@@@*:=*-:+%@@@@%#%%#-*-+:    ");
        System.out.println("   .=+.    .#@*:*-++*.+%@@@@@@@@#+-.-%@@@@@@%%@@%+.:-:    ");
        System.out.println("           +%%#:=*%@#=*@@@@@@@@@@#:-+@@@@@@@@@@@@#+:.*=   ");
        System.out.println("          -@@@%**:==.+=@@@@@@@@@@%=+:#@@@@@@@@@@@@-       ");
        System.out.println("         :%=%#++.    =-*%**%@@@@@@+..%@@@@@@@@@@%-#       ");
        System.out.println("     ..  :%:=::*+.....==#--:=.==##*:.#@@@@@@@@@@=.-..     ");
        System.out.println("     :-:: -+=##+*--#%###+#%@=#%+*=#+*+@@%*#%%%@@ -:-.     ");
        System.out.println("    .:=--.-#-=*%#%##%%@@%@@@@@@@@@%@#%@+*@@#-*%=+=+=..    ");
        System.out.println("   ..-=+#@@@@@@@%@@@@@@@@@@@@@@@@@@@@@@@@@@@@%@@**=+-.    ");
        System.out.println("      :=-+#%*@%%@@@@@@@@@@@@@@@@@@@@@@%@@@@@%%#-*--...    ");
        System.out.println("      ..-.::+##**%%*++*#%%%%@##*#@@@%%%%%%*=+-:*::-.      ");
        System.out.println("         --::=-:=++=**#*#+-=+%#*===+=:--+=-:--+:.--       ");
        System.out.println("               . :-+=-:-===.+:  :==-=+=   :-:             ");
        System.out.println("                   .          .:.                          ");
        System.out.println();

        PrintUtil.type(ColorUtil.boldBrightMagenta((("🎯 Objective: Defeat 3 Plague Vermins!").toUpperCase())));
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        Enemy enemy1 = new World2Enemy1();
        Battle battle1 = new Battle(player, enemy1);

        System.out.println();
        enemy1.displaySkills();
        InputUtil.pressEnterToContinue();
        System.out.println();

        for(int i = 1; i <= 3; i++){
            PrintUtil.hr();
            System.out.println("🐀 Plague Vermin " + i + " lunges at you!");
            PrintUtil.hr();
            InputUtil.pressEnterToContinue();

            battle1.startBattle();

            System.out.println("✅ You have defeated Plague Vermin " + i + "!");
            PrintUtil.line();
            enemy1.dropLoot(player);

            if (i < 3) { // reset for next vermin
                enemy1 = new World2Enemy1();
                battle1 = new Battle(player, enemy1);
            }
        }

        PrintUtil.line();
        PrintUtil.type("""
            🎉 Victory! The last of the Plague Vermin's collapses into the sludge.
            The foul air clears just enough for you to breathe again.
            """);
        PrintUtil.loot("You gain experience and loot from your hard-fought battle.\n");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();
        player.getEffects().resetAllEffects();

        // -------------------- Forsaken Cultists --------------------
        PrintUtil.event("You wander through the town's crumbling streets.");
        PrintUtil.effect("Townsfolk whisper rumors between coughs.");
        PrintUtil.type(
                "You can trade, gather rumors, and help townsfolk—small acts of kindness that might matter later.\n" +
                        "They tell you of the *Necromancer*, a phantom who rules from the shadows.\n" +
                        "His grip spreads from the Black Castle, where the Corrupted King hoards the Second Stone.\n"
        );
        InputUtil.pressEnterToContinue();

        PrintUtil.effect("The townsfolk warn of zealots who worship decay itself...");
        PrintUtil.type("""
                In a ruined chapel, two Forsaken Cultists emerge,
                their eyes glowing with fanatic light as they chant forbidden rites.
                """);

        PrintUtil.pause(1500);
        System.out.println();
        System.out.println("        . -                                                ");
        System.out.println("       ==+#*   +@@*..                  :-.                 ");
        System.out.println("       .+%++  -@@@@@@@@*.        .-+%@@@@@:                ");
        System.out.println("         -#    *@@@@@@@@#       :%@@@@@@@@-                ");
        System.out.println("         :*.   :=%@@@@@@@*.    :%@@@@@@@@*                 ");
        System.out.println("         :.*     @@%@@@@@%#.  :%@@@@@@@:=.                 ");
        System.out.println("         : *   .*@..=@@@@*#+  %*#@@@%*%:.                  ");
        System.out.println("           #@%%#%+ :#@@@@%#+ .%#%@@@%#@*                   ");
        System.out.println("            =.  - .#@@@@@@@=. *@@@@@@#-#-                  ");
        System.out.println("            .*   :#%@@@@@@@%- #@@@@@@@*=@:                 ");
        System.out.println("             -.  .+@@@@@@@@-  =@@@@@@@#:#@=                ");
        System.out.println("             -=   %@@@@@@@@=  +@@@@@@@@-  -%*.             ");
        System.out.println("             .-. -@@@@@@@@@=  +@@@@@@@@%     *%=.          ");
        System.out.println("              =- -@@@@@@@@@+  *@@@@@@@@%                   ");
        System.out.println("              .-..@@@@@@@@@*  *@@@@@@@@#                   ");
        System.out.println("               +:.@@@@@@@@@#. %@@@@@@@@#                   ");
        System.out.println("               .=.%@@@@@@@@#..#@@@@@@@@=                   ");
        System.out.println("                *=@@@@@@@@@@=+@@@@@@@@@#                   ");
        System.out.println("          :+*%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%*=.            ");
        System.out.println("                   :--=--==+++==-----:    ..               ");
        System.out.println();

        PrintUtil.type(ColorUtil.boldBrightMagenta((("🎯 Objective: Defeat 2 Forsaken Cultists!").toUpperCase())));
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        Enemy enemy2 = new World2Enemy2();
        Battle battle2 = new Battle(player, enemy2);

        System.out.println();
        enemy2.displaySkills();
        InputUtil.pressEnterToContinue();
        System.out.println();

        for (int i = 1; i <= 2; i++) {
            PrintUtil.hr();
            System.out.println("☠️ Forsaken Cultist " + i + " has began chanting a spell!");
            PrintUtil.hr();
            InputUtil.pressEnterToContinue();

            battle2.startBattle();

            System.out.println("✅ You have defeated Forsaken Cultist " + i + "!");
            PrintUtil.line();
            enemy2.dropLoot(player);

            if (i < 2) {
                enemy2 = new World2Enemy2();
                battle2 = new Battle(player, enemy2);
            }
        }

        PrintUtil.line();
        PrintUtil.type("""
                🎉 Victory! The cultists’ chants fade into silence.
                The air still hums with dark energy, but you stand victorious.
                """);
        PrintUtil.loot("You gain experience and loot from your grim battle.\n");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();
        player.getEffects().resetAllEffects();

        // -------------------- Blight Hounds --------------------
        PrintUtil.effect("A low growl echoes from the halls ahead...");
        PrintUtil.type("""
                From the black mist, three Blight Hounds leap forth,
                their fangs glinting and bodies wrapped in poisonous clouds.
                """);

        PrintUtil.pause(1500);
        System.out.println();
        System.out.println("                  -             .-=+-. ::      .:         ");
        System.out.println("            .- ....=               :-*%%%@+..+%-.         ");
        System.out.println("            :-*%@%@@%*             .::+%*#@@%@@%*=.       ");
        System.out.println("     --    .*%@@@@@@@%#-::.           . -%@@@@@@@%%+.     ");
        System.out.println("    =#:   +@@@%@@@@@@%@#-:-    ::=. :+@@@@@@@@@@@%@@=     ");
        System.out.println("   ::   :%@@@%@%%@@@@%%@@#:   .+. .+#@@%%%*@@@@% :#*#.    ");
        System.out.println("  .=  .**.@%:*@#%@#%--@@%-     .::..#@:.%%:=%-+#%-        ");
        System.out.println("   :*+: =#= -%=:*@-@= .++:        +-  :*    ++.  =+       ");
        System.out.println("        %:   =+. -@-%-.          ==    =*:   =*.          ");
        System.out.println("        --     .  -*-:.                       .:.         ");
        System.out.println("                                                          ");
        System.out.println("                                      :.                  ");
        System.out.println("                                 ..:+=#*-                 ");
        System.out.println("                                 =+=+=+%=-=.              ");
        System.out.println("                                 :+#%@@@@%*+-             ");
        System.out.println("                        .--:   :.-*%@@@@@@@#- .           ");
        System.out.println("                           +..#@%#@@@@@@@%@@*=%=.#%:      ");
        System.out.println("                          :-:%%=%%%%@%%@%@@@@#*%%+#%-     ");
        System.out.println("                         .+.*%=%@%%@%%%@%%@@@%#+.=*%#:    ");
        System.out.println("                          =%@#+=@%#%%#@@%%@@@%%*=+@#*=    ");
        System.out.println("                           :% @%%- *@%+. :**#*%.  +%#+    ");
        System.out.println("                            #++:#- .%%:     +@-   .%%=    ");
        System.out.println("                            =@: ++  :%%%-   =*.   .%*.    ");
        System.out.println("                            :=: .+-  .##.         =*      ");
        System.out.println("                                  -:   :*:       :=       ");
        System.out.println("                                         .:.               ");
        System.out.println("                                                          ");
        System.out.println();

        PrintUtil.type(ColorUtil.boldBrightMagenta((("🎯 Objective: Defeat 3 Blight Hounds!").toUpperCase())));
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        Enemy enemy3 = new World2Enemy3();
        Battle battle3 = new Battle(player, enemy3);

        System.out.println();
        enemy3.displaySkills();
        InputUtil.pressEnterToContinue();
        System.out.println();

        for (int i = 1; i <= 3; i++) {
            PrintUtil.hr();
            System.out.println("🐕 Blight Hound " + i + " snarls and lunges!");
            PrintUtil.hr();
            InputUtil.pressEnterToContinue();

            battle3.startBattle();

            System.out.println("✅ You have defeated Blight Hound " + i + "!");
            PrintUtil.line();
            enemy3.dropLoot(player);

            if (i < 3) {
                enemy3 = new World2Enemy3();
                battle3 = new Battle(player, enemy3);
            }
        }

        PrintUtil.line();
        PrintUtil.type("""
                🎉 Victory! The Blight Hounds are no more.
                The air still hums with dark energy, but you stand victorious.
                """);
        PrintUtil.loot("You gain experience and loot from your grim battle.\n");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();
        player.getEffects().resetAllEffects();

        // -------------------- Ghoul Footmen --------------------
        PrintUtil.title("THE BLACK CASTLE");
        PrintUtil.event("Thunder cracks as you push open the gates.");
        PrintUtil.effect("Knights with cracked armor and bleeding eyes lurch from the darkness.");

        PrintUtil.type("""
                Two Ghoul Footmen emerge, dragging rusted blades.
                Their movements are jerky, puppets of a cruel master.
                """);

        PrintUtil.pause(1500);
        System.out.println();
        System.out.println("                  .+.                                     ");
        System.out.println("                   .*-+#-                                 ");
        System.out.println("                .#%%@%*=                                  ");
        System.out.println("    ..           :%@@+-#-                                 ");
        System.out.println("    :=.           .#@%-.**.          -*-                  ");
        System.out.println("  .=.=-              :-  -*:     .:.-@@#+: ::             ");
        System.out.println("  :%@@@@*                  *%*  .=#@@@@@@%%%+:            ");
        System.out.println("   +@%*#-                  +@@:.*@@@@@@@@@%*+#=-.         ");
        System.out.println("   .+#:*=        =%*  .:   :@@*%@@@@@@%#@@@@@@#.          ");
        System.out.println("     -=:#      .-%@@%**+-  .#@@@@@@@@@@%%@@@@@@-          ");
        System.out.println("      . ==     .*@@@@@%###: :*@%#+#@@@@@@@@@@@@*          ");
        System.out.println("       ..*.    :#@@@@@@@@@*.  -=. .*@@@@@@@%#@@%:         ");
        System.out.println("         .*    .#@@@@@@@@%@#.  .  .#@@@%@%%@@@@@%:        ");
        System.out.println("          ==   :#@%@@@@@@@%@%=   .*@@@@@@@@@@@@%#*:       ");
        System.out.println("          =@%#%@@+:-@@@@@%%@@#-  -%@@@@@@@@@@@@%+:-       ");
        System.out.println("           :+ :++..#@@@@@@@@@++..*@@@@@@@@@@@@@@=::.      ");
        System.out.println("            -- .: +@@@@@@@@@%*-.:#@@@@@@@@@@@@@@@: .      ");
        System.out.println("            .=.  -@@@@@@@@@@@*:.=@@@@@@@@@@@@@@@**+       ");
        System.out.println("             -= .#@@@@@@@@@@@#+:%@@@@@@@@@@@@@@@*:..      ");
        System.out.println("             .=:+@@@@@@@@@@@#+:.=@@%%@@@@@%@@%%+*+        ");
        System.out.println("              -- *@@#@@@#%@@%+. :%@%-*#+@##@@@==  -       ");
        System.out.println("               =::@% -**=:#@= . :%%: ..=-:.-%@: .  .      ");
        System.out.println("               .=.%#   .. .%+   =@#:    .   +@+  :        ");
        System.out.println("             .:.=+@@. .:+=:#@.:#@@%=+=--::. +@@-=.        ");
        System.out.println("         ..-+#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%#=.     ");
        System.out.println("             ..:-====+****##%%%%###*##**++-:::::.         ");
        System.out.println("                                                          ");
        System.out.println();

        PrintUtil.type(ColorUtil.boldBrightMagenta((("🎯 Objective: Defeat 2 Ghoul Footmen!").toUpperCase())));
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        Enemy enemy4 = new World2Enemy4();
        Battle battle4 = new Battle(player, enemy4);

        System.out.println();
        enemy4.displaySkills();
        InputUtil.pressEnterToContinue();
        System.out.println();

        for(int i = 1; i <= 2; i++){
            PrintUtil.hr();
            System.out.println("🪓 Ghoul Footman " + i + " staggers toward you!");
            PrintUtil.hr();
            InputUtil.pressEnterToContinue();

            battle4.startBattle();

            System.out.println("✅ You have defeated Ghoul Footman " + i + "!");
            PrintUtil.line();
            enemy4.dropLoot(player);

            if (i < 2) {
                enemy4 = new World2Enemy4();
                battle4 = new Battle(player, enemy4);
            }
        }

        PrintUtil.line();
        PrintUtil.type("""
                🎉 Victory! The last ghoul crumbles into dust.
                You tighten your grip on your weapon, ready for whatever lies ahead.
                """);
        PrintUtil.loot("You gain experience and loot from your hard-fought battle.\n");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();
        player.getEffects().resetAllEffects();

        // -------------------- Mini-Boss: The Black Jailer --------------------
        PrintUtil.event("                                                                                                            \n" +
                "                                                                                                            \n" +
                "██▄  ▄██ ▄▄ ▄▄  ▄▄ ▄▄ ▄▄▄▄   ▄▄▄   ▄▄▄▄  ▄▄▄▄   ██████ ▄▄  ▄▄  ▄▄▄▄  ▄▄▄  ▄▄ ▄▄ ▄▄  ▄▄ ▄▄▄▄▄▄ ▄▄▄▄▄ ▄▄▄▄    \n" +
                "██ ▀▀ ██ ██ ███▄██ ██ ██▄██ ██▀██ ███▄▄ ███▄▄   ██▄▄   ███▄██ ██▀▀▀ ██▀██ ██ ██ ███▄██   ██   ██▄▄  ██▄█▄ ▀ \n" +
                "██    ██ ██ ██ ▀██ ██ ██▄█▀ ▀███▀ ▄▄██▀ ▄▄██▀   ██▄▄▄▄ ██ ▀██ ▀████ ▀███▀ ▀███▀ ██ ▀██   ██   ██▄▄▄ ██ ██ ▄ \n" +
                "                                                                                                            ");
        PrintUtil.pause(1500);

        System.out.println("                                                                                       \n" +
                "                                                                                       \n" +
                "██████ ▄▄ ▄▄ ▄▄▄▄▄   █████▄ ▄▄     ▄▄▄   ▄▄▄▄ ▄▄ ▄▄      ██  ▄▄▄  ▄▄ ▄▄    ▄▄▄▄▄ ▄▄▄▄  \n" +
                "  ██   ██▄██ ██▄▄    ██▄▄██ ██    ██▀██ ██▀▀▀ ██▄█▀      ██ ██▀██ ██ ██    ██▄▄  ██▄█▄ \n" +
                "  ██   ██ ██ ██▄▄▄   ██▄▄█▀ ██▄▄▄ ██▀██ ▀████ ██ ██   ████▀ ██▀██ ██ ██▄▄▄ ██▄▄▄ ██ ██ \n" +
                "                                                                                       ");

        System.out.println("========================================================================\n");

        PrintUtil.type("""
                In the dungeons below, chains rattle.
                The Black Jailer steps from the shadows, dragging hooks and blades behind him.
                """);
        System.out.println("========================================================================");
        System.out.println();

        PrintUtil.pause(1500);
        System.out.println();
        System.out.println("                                        :+#-              ");
        System.out.println("                         .=. .+        .++=*-             ");
        System.out.println("                         =#@%%#:        --.-.             ");
        System.out.println("                          *%@#=         :*=-              ");
        System.out.println("                     .+*=#%%#%%*+*:     .%#:              ");
        System.out.println("                    %@@@%%%#%#%%%@@#.   .*+               ");
        System.out.println("                   *@@@@%#@%%#%#%@@@+    +-               ");
        System.out.println("                   #%#%#%%%@@%%%%#%%*   .+-               ");
        System.out.println("                  =@%%@@@@@%@@%@@@%%%+:.=#=.              ");
        System.out.println("                 *#@%%%@@@%@@@@%@@@@%@@%#%#:              ");
        System.out.println("                :#%%%%@%##%%%%%##@@@%#*==#.               ");
        System.out.println("                =%@@@@@%%%*#%#*#%%@@@@- .#.               ");
        System.out.println("        *-+:   .*%#=@%%@#%%%@@#%*@@@@@@#-#                ");
        System.out.println("     .+%@%@%*  :*%#%@%@%#%#%@@#%#%@@@@@@@%:               ");
        System.out.println("     .+@@%@@#**+---@@@@%##%#@@@%#%@@@@@@@@@%*:           ");
        System.out.println("       *@@%@@=    :@@%@%%%%%@@@%%@@@@@@@@@@@@@@#-        ");
        System.out.println("       =%@@@@%=   =@@%%%@@@%@@@@@%#@@@@@@%#%%%#@@@+.      ");
        System.out.println("       +@%%#@%+   -@@%@@@%%@@@%%@@%@@@@@@@#-...- .*%-     ");
        System.out.println("       .=###+:    :@#%@@@%@@@%@%@@@@@@@@@@@@*.     .-:    ");
        System.out.println("                   +@%%%#@@@@@@%%%%%@@@@@@@@@@*           ");
        System.out.println("                    %%@@@@@@@@@%@@@@@##%@#  .-*=          ");
        System.out.println("                     %@@@@*=###%%@@@@@@-#.    ..          ");
        System.out.println("                    .@@#-*%-.#. :%@+ .-=%:                ");
        System.out.println("                    +%%+   =-   :#%%-  .%                  ");
        System.out.println("                  .%@@#-        .*#%@%::#                  ");
        System.out.println("                   ::.             .::.                    ");
        System.out.println();

        PrintUtil.type(ColorUtil.boldBrightMagenta((("🎯 Objective: Defeat The Black Jailer!").toUpperCase())));
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        Enemy miniBoss = new World2Miniboss1();
        Battle miniBattle = new Battle(player, miniBoss);

        System.out.println();
        miniBoss.displaySkills();
        InputUtil.pressEnterToContinue();
        System.out.println();

        miniBattle.startBattle();

        PrintUtil.line();
        PrintUtil.type("""
                ✅🏆 Mini-Boss Defeated!
                The Black Jailer drops to his knees, his chains falling silent.
                You have triumphed over his tyranny.
                """);
        PrintUtil.loot("You gain rare loot and a surge of experience!\n");
        miniBoss.dropLoot(player);
        InputUtil.pressEnterToContinue();
        PrintUtil.line();
        player.getEffects().resetAllEffects();

        // -------------------- Boss: The Corrupted King --------------------
        PrintUtil.event("                                                                                                            \n" +
                "                                                                                          \n" +
                "                                                                                          \n" +
                "█████▄ ▄████▄ ▄█████ ▄█████   ██████ ▄▄  ▄▄  ▄▄▄▄  ▄▄▄  ▄▄ ▄▄ ▄▄  ▄▄ ▄▄▄▄▄▄ ▄▄▄▄▄ ▄▄▄▄    \n" +
                "██▄▄██ ██  ██ ▀▀▀▄▄▄ ▀▀▀▄▄▄   ██▄▄   ███▄██ ██▀▀▀ ██▀██ ██ ██ ███▄██   ██   ██▄▄  ██▄█▄ ▀ \n" +
                "██▄▄█▀ ▀████▀ █████▀ █████▀   ██▄▄▄▄ ██ ▀██ ▀████ ▀███▀ ▀███▀ ██ ▀██   ██   ██▄▄▄ ██ ██ ▄ \n" +
                "                                                                                          ");
        PrintUtil.pause(1500);

        System.out.println("                                                                                                                                                                     \n" +
                "                                                                                                                                                                     \n" +
                "██     ██  ██ ██████ ██  ██ ██████ █████▄        ██████ ██  ██ ██████   ▄█████ ▄████▄ █████▄  █████▄  ██  ██ █████▄ ██████ ██████ ████▄    ██ ▄█▀ ██ ███  ██  ▄████  \n" +
                "██     ██  ██   ██   ██████ ██▄▄   ██▄▄██▄         ██   ██████ ██▄▄     ██     ██  ██ ██▄▄██▄ ██▄▄██▄ ██  ██ ██▄▄█▀   ██   ██▄▄   ██  ██   ████   ██ ██ ▀▄██ ██  ▄▄▄ \n" +
                "██████ ▀████▀   ██   ██  ██ ██▄▄▄▄ ██   ██  ▄      ██   ██  ██ ██▄▄▄▄   ▀█████ ▀████▀ ██   ██ ██   ██ ▀████▀ ██       ██   ██▄▄▄▄ ████▀    ██ ▀█▄ ██ ██   ██  ▀███▀  \n" +
                "                                           ▀                                                                                                                         ");

        System.out.println("===========================================================================");
        PrintUtil.type(
                "In the throne room, the King sits slumped—his crown fused to his skull.\n" +
                        "You battle him; each blow shakes the hall until, finally, he falls.\n"
        );
        System.out.println("===========================================================================");
        System.out.println();

        PrintUtil.pause(1500);
        System.out.println();
        System.out.println("@@@@@@@@@#+-:                               .-*#@@@@@@@@@@");
        System.out.println("@@@@@@##@+                                      +%#%@@@@@@");
        System.out.println("@@@@@##%%%.                  :                  %%###@@@@@");
        System.out.println("@@@%+#%##%*                :.=-.               #@####+%@@@");
        System.out.println("@@@@#%@##%@.               +%%*-              .%%##@%#@@@@");
        System.out.println("@@%*:#@@%%@-               *#@#:              #@%#@@#-*%@@");
        System.out.println("@@#- -%@%%@#           ..  -%@+    .          =@%#@@= -#@@");
        System.out.println("@@%= .*@@#@.          .--: :#@= :=::           ##@@#. -#@@");
        System.out.println("@@*.  =@@%#           .+%@%%%%%%@@*.           *#@@+   *@@");
        System.out.println("@@+.  =@@%#           :%@@@%%@%%@@@=           +%@@+   +%@");
        System.out.println("@@+. =@@@@@=.         .+####@@%#*+*- :        -%@@@@+  +@@");
        System.out.println("@@+.  =@@@*.           -==*%#@##+:+-   -       *%@@+  .+@@");
        System.out.println("@@+.  :%@%=         ..-#-:*=#@=*= +%=.-:       -%@@-  .+@@");
        System.out.println("@@+.  .%@%-        ...**. :.#@-.. -#%-         :%@%:  .+@@");
        System.out.println("@@+.  .%@%-      .-  .*- +@%%@#@%+:=*:.  .     :%@%:  .+@@");
        System.out.println("@@+:  .%@%-       :::=*::+%@@@@@%*: *- :++:    :%@%:  -*@@");
        System.out.println("@@+-  .%@#-          *+.+@@@@@@#%*.:##+:       :#@%: .-+%@");
        System.out.println("@%+-  :%@#-          #:-#@@@@@@@%%*#%*         :#@@- .-+@@");
        System.out.println("@@+-: :%@#-          ==-%@@@@@##%@@%:          :*@@=..-*@@");
        System.out.println("@@+-. :%@%-           :*@@@@#%#@%%*-*:         :#@@+:.-*@@");
        System.out.println("@@*=. :%@%= .:.      ..=*#%%%%#*#%*:           :%@%+-:-*@@");
        System.out.println("@@*=-.-%@%= :-.        =%%@#@@@%+@=.           :%@@+---+@@");
        System.out.println("@@*==-=@@%= .-.     .#@@%*#@@@%++@%:       .: .-%@#=-=+*@@");
        System.out.println("@@#**-=#%%+ .:.   +@@@+*%#-+@*#--%%=       ::.:-##%+-*##@@");
        System.out.println("@@#++-=###+:.::+@@@*- .*%+:-*=: :#%=       .: :-%@%*+###@@");
        System.out.println("@@##*-+%@#+--*@@%=.   .*#:  =.   =@-    ..:--:-+%%#***%%@@");
        System.out.println("@@%#%*#%%#+*@%*:      .*+   .    :#=    :..+=--+######*#@@");
        System.out.println("@@@@###%#+#*=-----:   -%+        .#*..::----++*#%%@@%%@@@@");
        System.out.println("@@@%@@%#%%@@%%#%#**==+%@*.     ..-#@#==+*%#%%%%%####@%%@@@");
        System.out.println("@@@@@@@@@@@%@@@%%@@@@@@@@@@@%%@@@@@@@@@@@%@@@%@%@@@@@@*#@@");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println();

        PrintUtil.type(ColorUtil.boldBrightMagenta((("🎯 Objective: Defeat The Corrupted King!").toUpperCase())));
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        Enemy boss = new World2Miniboss2();
        Battle bossBattle = new Battle(player, boss);

        System.out.println();
        boss.displaySkills();
        InputUtil.pressEnterToContinue();
        System.out.println();

        bossBattle.startBattle();

        PrintUtil.line();
        PrintUtil.type("""
                ✅👑 Final Victory! - Boss Defeated!
                The Corrupted King’s crown falls to the floor, echoing through the halls.
                Darkness fades, and you stand as the savior of this cursed land.
                """);
        PrintUtil.loot("You gain immense experience and legendary loot!\n");
        boss.dropLoot(player);
        InputUtil.pressEnterToContinue();
        PrintUtil.line();
        player.getEffects().resetAllEffects();

        //-------------------------------------------------
        PrintUtil.effect("The King's breath rattles. A faint glimmer of humanity returns to his eyes.");
        PrintUtil.say("Corrupted King", "\"The Necromancer… is not what he seems… choose wisely…\"");
        PrintUtil.event("With a final sigh, his body crumbles into dust, leaving only echoes of his warning.");
        InputUtil.pressEnterToContinue();

        PrintUtil.event("You lift the Second Stone, feeling its dark energy pulse in your hands.");
        PrintUtil.effect("A cold wind sweeps through the empty halls, extinguishing every torch and whispering secrets of the past.");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        // ---------------------- MAGIC SHOP ------------------------
        PrintUtil.type("""
        As you take a step forward, a strange pull brushes against your soul.
        The world itself feels like it is shifting around you.
        """);

        //type slow
        PrintUtil.type("""
        ✨ Something… or someone… is calling to you.
        """);
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        PrintUtil.type("""
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
        PrintUtil.type("""
        The doorway vanishes as suddenly as it appeared,
        leaving you alone in the quiet halls of the castle.
        
        🌟 Whatever choices you made within… will echo in the battles to come.
        Your journey continues, hero. The fate of this land rests in your hands.
        """);
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        PrintUtil.type("""
        The castle seems to hold its breath.
        The choices you've made, the treasures you've claimed…
        all will shape the path ahead.
        """);
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

    }
}