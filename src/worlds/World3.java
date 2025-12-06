package worlds;

import enemies.*;
import battle.Battle;
import characters.Character;
import events.PrefiEncounter;
import utils.ColorUtil;
import utils.InputUtil;
import utils.PrintUtil;


public class World3 {

    public void run(Character player) {
        PrintUtil.pause(2000);
        System.out.println();
        PrintUtil.title("                                                      ╦ ╦╔═╗╦═╗╦  ╔╦╗  ═╗");
        PrintUtil.title("╔════════════════════════════════════════════════════ ║║║║ ║╠╦╝║   ║║  ═╣ ═══════════════════════════════════════════════════════════╗");
        PrintUtil.title("                                                      ╚╩╝╚═╝╩╚═╩═╝═╩╝  ═╝\n");
        PrintUtil.title("████████╗██╗  ██╗███████╗    ███╗   ██╗███████╗ ██████╗██████╗  ██████╗ ███╗   ███╗ █████╗ ███╗   ██╗ ██████╗███████╗██████╗ ███████╗    \n" +
                "╚══██╔══╝██║  ██║██╔════╝    ████╗  ██║██╔════╝██╔════╝██╔══██╗██╔═══██╗████╗ ████║██╔══██╗████╗  ██║██╔════╝██╔════╝██╔══██╗██╔════╝    \n" +
                "   ██║   ███████║█████╗      ██╔██╗ ██║█████╗  ██║     ██████╔╝██║   ██║██╔████╔██║███████║██╔██╗ ██║██║     █████╗  ██████╔╝███████╗    \n" +
                "   ██║   ██╔══██║██╔══╝      ██║╚██╗██║██╔══╝  ██║     ██╔══██╗██║   ██║██║╚██╔╝██║██╔══██║██║╚██╗██║██║     ██╔══╝  ██╔══██╗╚════██║    \n" +
                "   ██║   ██║  ██║███████╗    ██║ ╚████║███████╗╚██████╗██║  ██║╚██████╔╝██║ ╚═╝ ██║██║  ██║██║ ╚████║╚██████╗███████╗██║  ██║███████║    \n" +
                "   ╚═╝   ╚═╝  ╚═╝╚══════╝    ╚═╝  ╚═══╝╚══════╝ ╚═════╝╚═╝  ╚═╝ ╚═════╝ ╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝ ╚═════╝╚══════╝╚═╝  ╚═╝╚══════╝    \n" +
                "                                                                                                                                         \n" +
                "                    ████████╗ ██████╗ ██╗    ██╗███████╗██████╗     ██╗███╗   ██╗    ████████╗██╗  ██╗███████╗                           \n" +
                "                    ╚══██╔══╝██╔═══██╗██║    ██║██╔════╝██╔══██╗    ██║████╗  ██║    ╚══██╔══╝██║  ██║██╔════╝                           \n" +
                "                       ██║   ██║   ██║██║ █╗ ██║█████╗  ██████╔╝    ██║██╔██╗ ██║       ██║   ███████║█████╗                             \n" +
                "                       ██║   ██║   ██║██║███╗██║██╔══╝  ██╔══██╗    ██║██║╚██╗██║       ██║   ██╔══██║██╔══╝                             \n" +
                "                       ██║   ╚██████╔╝╚███╔███╔╝███████╗██║  ██║    ██║██║ ╚████║       ██║   ██║  ██║███████╗                           \n" +
                "                       ╚═╝    ╚═════╝  ╚══╝╚══╝ ╚══════╝╚═╝  ╚═╝    ╚═╝╚═╝  ╚═══╝       ╚═╝   ╚═╝  ╚═╝╚══════╝                           \n" +
                "                                                                                                                                         \n" +
                "                            ██╗    ██╗ █████╗ ███████╗████████╗███████╗██╗      █████╗ ███╗   ██╗██████╗                                 \n" +
                "                            ██║    ██║██╔══██╗██╔════╝╚══██╔══╝██╔════╝██║     ██╔══██╗████╗  ██║██╔══██╗                                \n" +
                "                            ██║ █╗ ██║███████║███████╗   ██║   █████╗  ██║     ███████║██╔██╗ ██║██║  ██║                                \n" +
                "                            ██║███╗██║██╔══██║╚════██║   ██║   ██╔══╝  ██║     ██╔══██║██║╚██╗██║██║  ██║                                \n" +
                "                            ╚███╔███╔╝██║  ██║███████║   ██║   ███████╗███████╗██║  ██║██║ ╚████║██████╔╝                                \n" +
                "                             ╚══╝╚══╝ ╚═╝  ╚═╝╚══════╝   ╚═╝   ╚══════╝╚══════╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═════╝                                 \n" +
                "                                                                                                                                         ");
        PrintUtil.title("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");

        System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println();
        PrintUtil.story(
                            "You have been travelling for days. You have reached a land where not a even a glimmer of life can be seen.\n" +
                                    "The land has turned barren. Ash falls like snow. Rivers of molten fire carve through the black rock.\n" +
                        "At the center, rising higher than mountains, stands a tower larger than anything you have ever seen. " +
                                    "\nThe Necromancer’s Tower."
        );
        System.out.println();
        System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        // -------------------- Flame Revenants --------------------
        PrintUtil.line();
        PrintUtil.story("""
                🔥 From the molten cracks below, Flame Revenants rise,
                their forms flickering with ember and hatred.
                """);
        PrintUtil.pause(1500);

        PrintUtil.enemyEncounter("                                                          ");
        PrintUtil.enemyEncounter("                             :                            ");
        PrintUtil.enemyEncounter("                            :+*                           ");
        PrintUtil.enemyEncounter("             .:.          -:%#+--          .:.            ");
        PrintUtil.enemyEncounter("            :*+==-       -*+%@#+#-       -+=+*:           ");
        PrintUtil.enemyEncounter("           #@%###+       -#%%%%@#=       =##*%@#          ");
        PrintUtil.enemyEncounter("           -#%@@@@+.     +#%@@@%##=.   .+@@@@%#-          ");
        PrintUtil.enemyEncounter("            :%@@@*+%#: :**.:%@%- -%+ :*%++@@%%:           ");
        PrintUtil.enemyEncounter("           :%+-%@*:.%:.+#--*@@@#. :*::%.:*@%-+%-          ");
        PrintUtil.enemyEncounter("          .#**@@@@=:*=:*=:*@@#@@%::*==#:=@@@@*=%-         ");
        PrintUtil.enemyEncounter("        ::-+%@#--%@#:.==:*@%- .*@%-:: :#@%--#@%=..:-===-  ");
        PrintUtil.enemyEncounter("  =+=+-.  :@*. . .#@*= .*%+.    -#*. :=@#:   .+@:   :++*- ");
        PrintUtil.enemyEncounter(" :*++.     ##.-*===:#@-=@+.      =@*=@%.     .##          ");
        PrintUtil.enemyEncounter("           -*.--==.  :%@=         -%%:        *=          ");
        PrintUtil.enemyEncounter("         .**+:==:    .#%-         -%#.        +**:        ");
        PrintUtil.enemyEncounter("                     :              .:                    ");
        System.out.println();

        PrintUtil.objective(("🎯 Objective: Defeat 3 Flame Revenants!"));
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        Enemy enemy1 = new World3Enemy1();
        Battle battle1 = new Battle(player, enemy1);

        System.out.println();
        enemy1.displaySkills();
        InputUtil.pressEnterToContinue();
        System.out.println();

        for (int i = 1; i <= 3; i++) {
            PrintUtil.hr();
            PrintUtil.enemyEncounter("🔥 Flame Revenant " + i + " emerges from the lava!");
            PrintUtil.hr();
            InputUtil.pressEnterToContinue();

            battle1.startBattle();

            PrintUtil.enemyDefeated("✅ You have defeated Flame Revenant " + i + "!");
            PrintUtil.line();
            enemy1.dropLoot(player);

            if (i < 3) {
                enemy1 = new World3Enemy1();
                battle1 = new Battle(player, enemy1);
            }

        }

        PrintUtil.line();
        PrintUtil.victory("""
                    🎉 Victory! The last revenant collapses into molten shards.
                    The lava around you cools slightly — a brief moment of calm.
                    """);
        PrintUtil.loot("You gain experience and loot from the battle.\n");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();
        player.getEffects().resetAllEffects();


        PrintUtil.event("You steel yourself and begin the ascent.");
        PrintUtil.effect("The air thickens with magic. Each step hums with a pulse from the Stones you carry.");
        System.out.println();

        PrintUtil.effect("From the darkness crawl soldiers of bone and beasts stitched from shadow.");
        InputUtil.pressEnterToContinue();

        // -------------------- Bone Warlocks --------------------
        PrintUtil.effect("The ground trembles as sinister energy gathers.");
        PrintUtil.story("""
                From the shadows, Bone Warlocks appear, chanting forbidden incantations.
                """);

        PrintUtil.pause(1500);
        System.out.println("                                                          ");
        PrintUtil.enemyEncounter("   :..            .                                        ");
        PrintUtil.enemyEncounter("  .-+-.      .=: .:+                                       ");
        PrintUtil.enemyEncounter("  -*%*:      .*%%%%*                                       ");
        PrintUtil.enemyEncounter("   .*#:    -: .+%%= ..-                                    ");
        PrintUtil.enemyEncounter("    -*-    --#%@@@@%*-:                                    ");
        PrintUtil.enemyEncounter("     +=   =*@@@@@@@@@@+:                                  ");
        PrintUtil.enemyEncounter("      =:  .#@@@@@@@@@@+.                                  ");
        PrintUtil.enemyEncounter("     .#@::=%@@@@@@@@@%-         .-=::..@@*     :..        ");
        PrintUtil.enemyEncounter("      .**%@@%%@@@@@@@@@*.      .=+#%%@@@@@*:   =..:-:     ");
        PrintUtil.enemyEncounter("       -::++#@@@@@@@@#@%-      .+@@@@@@@@@#=. ...%=.::    ");
        PrintUtil.enemyEncounter("        + :=@@@@@@@@@**%=     -:#@@@@@@@@@@*:  ::..:      ");
        PrintUtil.enemyEncounter("        --:%@@@@@@@@@*-*+    =@@+.+%@@@@##%*:..:#=+:      ");
        PrintUtil.enemyEncounter("         #*=%@@@@@@@@%-+=   .#@+  -#@@%=. -%@%+-:         ");
        PrintUtil.enemyEncounter("       .:=+%@@@@@@@@@@*::   .@=  -%@@@@@#-  .              ");
        PrintUtil.enemyEncounter("         -@=#@@@@@@@@%++.   -@+ :#@@@@@@@@#-               ");
        PrintUtil.enemyEncounter("        ---#@@@@@@@%@@#:    =%.:#@@@@@@@@@@@#=            ");
        PrintUtil.enemyEncounter("       .. *%@@%%@@@%@@#+       +@@@%@@@%*#+%@#.           ");
        PrintUtil.enemyEncounter("         ..+@@+=##*+#@=:.     +@@***%%%* -+@%:            ");
        PrintUtil.enemyEncounter("     .. : ..#* ..+-..@-   :- -@%= :.-*=:  -#+     .       ");
        PrintUtil.enemyEncounter("       =-* -@* ::: :.@#:+@%+.@*  ::  .. . -@*.:.+=        ");
        PrintUtil.enemyEncounter("      .:%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%@@@@@@=.       ");
        PrintUtil.enemyEncounter("   :+#%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%#*:    ");
        PrintUtil.enemyEncounter("          :+.:-:-#+ :=#@@@@@@@@@@@@#=. =+-::.              ");
        PrintUtil.enemyEncounter("                       .::-=+=:.                           ");
        System.out.println();

        PrintUtil.objective(("🎯 Objective: Defeat 2 Bone Warlocks!"));
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        Enemy enemy2 = new World3Enemy2();
        Battle battle2 = new Battle(player, enemy2);

        System.out.println();
        enemy2.displaySkills();
        InputUtil.pressEnterToContinue();
        System.out.println();

        for (int i = 1; i <= 3; i++) {
            PrintUtil.hr();
            PrintUtil.enemyEncounter("💀 Bone Warlock " + i + " raises its staff, channeling dark magic!");
            PrintUtil.hr();
            InputUtil.pressEnterToContinue();

            battle2.startBattle();

            PrintUtil.enemyDefeated("✅ You have defeated Bone Warlock " + i + "!");
            PrintUtil.line();
            enemy2.dropLoot(player);

            if (i < 2) {
                enemy2 = new World3Enemy2();
                battle2 = new Battle(player, enemy2);
            }
        }

        PrintUtil.line();
        PrintUtil.victory("""
                    🎉 Victory! The Bone Warlocks crumble, their souls screaming into the void.
                    The heat intensifies — something greater stirs within the peaks.
                    """);
        PrintUtil.loot("You gain experience and loot from your fiery victory.\n");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();
        player.getEffects().resetAllEffects();

        // -------------------- Obsidian Crushers --------------------
        PrintUtil.effect("A deep rumble echoes through the caverns.");
        PrintUtil.effect("Lava bursts upward, and massive shadows rise behind the flames.");

        PrintUtil.story("""
                Obsidian Crushers emerge — molten giants forged from stone and fury.
                """);

        PrintUtil.pause(1500);
        PrintUtil.enemyEncounter("                 :  -               .  :      .*@-        ");
        PrintUtil.enemyEncounter("              ...*#%#=  :.      .:  *+#*=..   :%@@*:      ");
        PrintUtil.enemyEncounter("             .*@@@@@@#@@@-      =@@%#@@@@%+    -@@@%+.    ");
        PrintUtil.enemyEncounter("  .--.       -%@@@@@@@@@@#.    :#@@@@@@@@@%-:=*#-#@@#-    ");
        PrintUtil.enemyEncounter(" .%@@@%+.   :+%@@@@@@@@@@*:.  .:#@@@@@@@@@@%@%:   -:      ");
        PrintUtil.enemyEncounter("  .-+*##%#*%@@@#%@@@@@%#@@@+  -@@@%@@@@@@%%@#:            ");
        PrintUtil.enemyEncounter("          -+++*+#@@@@@-:%@%-   +%@#%@@@@%. .               ");
        PrintUtil.enemyEncounter("              .*@@@@@@@%@%:     .#@@@@@@@%=                ");
        PrintUtil.enemyEncounter("             -%@@@@@@@@@@#**.  +%@@@@@@@@@@#:              ");
        PrintUtil.enemyEncounter("           .=@@@@@@@@@@@%- .   .#@@@@@@@@@@@#+.           ");
        PrintUtil.enemyEncounter("      .==:.+@@@%-+@@**@@@*=   =#@@@#=@@#.=%@@@- :=+=.     ");
        PrintUtil.enemyEncounter("     :*%#=::@@@+  -*:.:%@@@= =@@@%- .*-  .*@@#. :*%%=     ");
        PrintUtil.enemyEncounter("   .:+#@@*:*%@@=   -   -@@@+ *@@@=       .=@@##=+%@%*:    ");
        PrintUtil.enemyEncounter("   .-*%@@@@@@@#=*+.  :%=:#@@#@@*+=**.  .*#+#@@@@@@@%*+:   ");
        PrintUtil.enemyEncounter("     :+%@@@@@@@@@@*%--=@@%@@@@@@@@*--+%#@@@@@@@@@@%*-.    ");
        PrintUtil.enemyEncounter("       :+*********+++#%*+*%%*****==#+-+===+++++====:      ");
        System.out.println();

        PrintUtil.objective(("🎯 Objective: Defeat 2 Obsidian Crushers!"));
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        Enemy enemy3 = new World3Enemy3();
        Battle battle3 = new Battle(player, enemy3);

        System.out.println();
        enemy3.displaySkills();
        InputUtil.pressEnterToContinue();
        System.out.println();

        for (int i = 1; i <= 2; i++) {
            PrintUtil.hr();
            PrintUtil.enemyEncounter("🪨 Obsidian Crusher " + i + " roars and slams the ground!");
            PrintUtil.hr();
            InputUtil.pressEnterToContinue();

            battle3.startBattle();

            PrintUtil.enemyDefeated("✅ You have defeated Obsidian Crusher " + i + "!");
            PrintUtil.line();
            enemy3.dropLoot(player);

            if (i < 2) {
                enemy3 = new World3Enemy3();
                battle3 = new Battle(player, enemy3);
            }
        }

        PrintUtil.line();
        PrintUtil.victory("""
                    🎉 Victory! The Crushers shatter, falling into the lava below.
                    The tremors subside — the way forward opens.
                    """);
        PrintUtil.loot("You gain experience and loot from your battle.\n");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();
        player.getEffects().resetAllEffects();


        PrintUtil.effect("Halfway up, you find a mural etched into obsidian.");
        PrintUtil.story(
                "It shows a hooded figure holding three glowing stones, beneath a phrase in your own language:\n" +
                        "  'To teach is to control.'");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        // -------------------- Soulflayer Gargoyles --------------------
        PrintUtil.effect("A chilling wind cuts through the heat.");
        PrintUtil.story("""
                From the shadows of molten stone, Soulflayer Gargoyles take flight.
                Their shrieks pierce the air, echoing through the infernal spires.
                """);

        PrintUtil.pause(1500);
        PrintUtil.enemyEncounter("          -%@@%#*:                      .+#%@@%-          ");
        PrintUtil.enemyEncounter("           .#@@@@@@#..-            ::.*@@@@@@%:           ");
        PrintUtil.enemyEncounter("           +@@@@@@@@@@#    .  .    *@@@@@@@@@@*           ");
        PrintUtil.enemyEncounter("            -#@@@@@@@@%-  .+  =:  -%@@@@@@@@%-            ");
        PrintUtil.enemyEncounter("              =@@@@@@@@@+..*@@#. =@@@@@@@@@+               ");
        PrintUtil.enemyEncounter("              ::.-*@@@@@@@@@@@@@@@@@@@@#-.::               ");
        PrintUtil.enemyEncounter("   -+:.            -#==#%@@@@@@@@@#==*=                    ");
        PrintUtil.enemyEncounter("   .#@@#-       .      :#%%@@@@%%#-  ...                   ");
        PrintUtil.enemyEncounter("  -#@@@@@*    -*:     -#= :#@@%- =#-  .#@@#+:              ");
        PrintUtil.enemyEncounter("   .+@@@@@#=:#@+.    :#=:-%@@@@@=.+#: :%@@@@@#-:  :-.     ");
        PrintUtil.enemyEncounter("    -%@@@@@+@@*=#*.   :-+#%=*@-%%- -.  -%@@@@@%.+@%-      ");
        PrintUtil.enemyEncounter("      .=@@@@@@@@@@#:  := ++:%- =*       +%@@@@@@@%:+-     ");
        PrintUtil.enemyEncounter("       :#%%@@@@*.:..   =%%+-.  .*#=.      .*@@@@@@@@@*.   ");
        PrintUtil.enemyEncounter("     .+%+:@@@*#%#%%+                        :%@@@@%-=-    ");
        PrintUtil.enemyEncounter("     .: .%@@@+.                           .*@@@#@%@+.     ");
        PrintUtil.enemyEncounter("         *@@*@#:                     .#= :%@@@*.+@%**+**. ");
        PrintUtil.enemyEncounter("     -+-.*@#**.                    =:  =%@@%=#@=  .==     ");
        PrintUtil.enemyEncounter("    :-  :@  .:-=.                  -#%@*  . =+.           ");
        PrintUtil.enemyEncounter("      ..-@#.                           ..                  ");
        System.out.println();

        PrintUtil.objective(("🎯 Objective: Defeat 3 Soulflayer Gargoyles!"));
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        Enemy enemy4 = new World3Enemy4();
        Battle battle4 = new Battle(player, enemy4);

        System.out.println();
        enemy4.displaySkills();
        InputUtil.pressEnterToContinue();
        System.out.println();

        for (int i = 1; i <= 4; i++) {
            PrintUtil.hr();
            PrintUtil.enemyEncounter("😈 Soulflayer Gargoyle " + i + " swoops down from above!");
            PrintUtil.hr();
            InputUtil.pressEnterToContinue();

            battle4.startBattle();

            PrintUtil.enemyDefeated("✅ You have defeated Soulflayer Gargoyle " + i + "!");
            PrintUtil.line();
            enemy4.dropLoot(player);

            if (i < 3) {
                enemy4 = new World3Enemy4();
                battle4 = new Battle(player, enemy4);
            }
        }

        PrintUtil.line();
        PrintUtil.victory("""
                    🎉 Victory! The last Gargoyle falls, shattering to dust midair.
                    Silence returns — save for the slow, rising heartbeat of the volcano.
                    """);
        PrintUtil.loot("You gain experience and loot from your hard-fought battle.\n");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();
        player.getEffects().resetAllEffects();

        // -------------------- MINIBOSS: ZYRRYL, THE TOWER WARDEN --------------------
        PrintUtil.event("                                                                                                            \n" +
                "                                                                                                            \n" +
                "██▄  ▄██ ▄▄ ▄▄  ▄▄ ▄▄ ▄▄▄▄   ▄▄▄   ▄▄▄▄  ▄▄▄▄   ██████ ▄▄  ▄▄  ▄▄▄▄  ▄▄▄  ▄▄ ▄▄ ▄▄  ▄▄ ▄▄▄▄▄▄ ▄▄▄▄▄ ▄▄▄▄    \n" +
                "██ ▀▀ ██ ██ ███▄██ ██ ██▄██ ██▀██ ███▄▄ ███▄▄   ██▄▄   ███▄██ ██▀▀▀ ██▀██ ██ ██ ███▄██   ██   ██▄▄  ██▄█▄ ▀ \n" +
                "██    ██ ██ ██ ▀██ ██ ██▄█▀ ▀███▀ ▄▄██▀ ▄▄██▀   ██▄▄▄▄ ██ ▀██ ▀████ ▀███▀ ▀███▀ ██ ▀██   ██   ██▄▄▄ ██ ██ ▄ \n" +
                "                                                                                                            ");
        PrintUtil.pause(1500);

        PrintUtil.event("                                                                                                                                           \n" +
                "                                                                                                                                           \n" +
                "██████ ▄▄ ▄▄ ▄▄▄▄  ▄▄▄▄  ▄▄ ▄▄ ▄▄          ██████ ▄▄ ▄▄ ▄▄▄▄▄   ██████ ▄▄▄  ▄▄   ▄▄ ▄▄▄▄▄ ▄▄▄▄    ██     ██  ▄▄▄  ▄▄▄▄  ▄▄▄▄  ▄▄▄▄▄ ▄▄  ▄▄ \n" +
                " ▄▄▀▀  ▀███▀ ██▄█▄ ██▄█▄ ▀███▀ ██            ██   ██▄██ ██▄▄      ██  ██▀██ ██ ▄ ██ ██▄▄  ██▄█▄   ██ ▄█▄ ██ ██▀██ ██▄█▄ ██▀██ ██▄▄  ███▄██ \n" +
                "██████   █   ██ ██ ██ ██   █   ██▄▄▄  ▄      ██   ██ ██ ██▄▄▄     ██  ▀███▀  ▀█▀█▀  ██▄▄▄ ██ ██    ▀██▀██▀  ██▀██ ██ ██ ████▀ ██▄▄▄ ██ ▀██ \n" +
                "                                     ▀                                                                                                     ");

        System.out.println();
        PrintUtil.objective("═══════════════════════════════════════════════════════════════════════════");
        System.out.println();
        PrintUtil.effect("""
                As you reach the summit, molten light reveals a towering figure.
                Zyrryl, Warden of the Shattered Tower, stands armed with cursed steel.
                """);
        System.out.println();
        PrintUtil.objective("═══════════════════════════════════════════════════════════════════════════");
        System.out.println();

        PrintUtil.pause(1500);
        PrintUtil.enemyEncounter("                                                       ..:");
        PrintUtil.enemyEncounter("                                                    =%#+-#");
        PrintUtil.enemyEncounter("                         -.     :               .+.:+@%%@@");
        PrintUtil.enemyEncounter("                    =.  =-.:   :-=         .=: :+#@@@%+=+-");
        PrintUtil.enemyEncounter("                    %: -%-+-:+-+=*. -     -%#**#-.:. ..   ");
        PrintUtil.enemyEncounter("    .              .@+::##=%@@@+#*..#.    =#=*##=+        ");
        PrintUtil.enemyEncounter("   :+.             .%@@@@@@@@@@@@#+#%.    :*@#*%*         ");
        PrintUtil.enemyEncounter("   -#-             :#@@@@@@@@@@@@@@@=    .#%=-.      :.   ");
        PrintUtil.enemyEncounter("   =%=            :%@@@@@@@@@@@@@@@@-   .+#:        .+-   ");
        PrintUtil.enemyEncounter("  .#@#:          :-=@@@@@@%%%@%%@@%#+  .**.     .   .*-   ");
        PrintUtil.enemyEncounter("  +#@+.  .      .+#@@#=*@@@@@@@%#@%+::#%=       :   :%*.  ");
        PrintUtil.enemyEncounter("  *@@#: .:   .. .#@@%. :*@@@@@%-.+@@@@@%:       :.  =@%:  ");
        PrintUtil.enemyEncounter(" :-@@#*:.:   ..  *@@+ :*#@@@@@@*=:::+*.        .:: .*@#=- ");
        PrintUtil.enemyEncounter(" #+@@@+.::  .:.  -@@. =#@@@@@@@@%*-+=      .  ..::.:*@@%+ ");
        PrintUtil.enemyEncounter(" %@@@@#-::. .:.  .#@#=#@@@@@@@@@@@@+.     .:  .::::-#@@@#=");
        PrintUtil.enemyEncounter(":@@@@@@%-:...::.  +@*#@@@@@@@@@@@@@@*.    ::. .::--#@%@@%-");
        PrintUtil.enemyEncounter(" -%@@%@+-::::::..  -#@@@@@@@@@@@@@@@@#.  ..:...::*=@@@@@@-");
        PrintUtil.enemyEncounter("  =@@@@@@---::::.  :%@@@@#+@@@@+*@@@@@%:*.::.::::*+@@@@@@*");
        PrintUtil.enemyEncounter("  *#=*@@@:++::::...:@@@@*:-%@@% . :%@@@@+.:::::::=%@@@+.  ");
        PrintUtil.enemyEncounter("      :%%@%+::::::+@@@@+  .%@##  =@@@@@%:::::::::%@@@@=   ");
        PrintUtil.enemyEncounter("      +@@@@%-::::#@@@%:   =**=-:*#@@@-.::::::::*:@@@%%#:  ");
        PrintUtil.enemyEncounter("      :+%@@@*::::%@@%:   +-:.-  .#@@*: ::::::::##@@#      ");
        PrintUtil.enemyEncounter("          @@#:::*@@=.. :+:  .     +@@=:::::.:-=#--=.    -@");
        PrintUtil.enemyEncounter("@#==           *@@#..:=#:         :%@@@+.    .+:     .*@@-");
        PrintUtil.enemyEncounter("@@@@@@%+-:. :.-%@@=. .....    ...:-#@@@@@%+.  ..:+##%@@@@@");
        PrintUtil.enemyEncounter("@@@@@@@@@@@@@@@@@@@@@@%##*=::=**#%@@@@@@@@@@@@@@@@@@@@@@@@@");
        PrintUtil.enemyEncounter("@@@@@@@@@@@@@@@%%#*+-:..-+*#%@@@@@@%%@@@@@@@@@@@@@@@@@*#@@");
        PrintUtil.enemyEncounter("@@@@@@@@@@@@@@@@@@@@@@%#+.     .:+**#@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println();

        PrintUtil.objective(("🎯 Objective: Defeat Zyrryl, The Tower Warden!"));
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        Enemy miniboss = new World3Miniboss1();
        Battle minibattle = new Battle(player, miniboss);

        System.out.println();
        miniboss.displaySkills();
        InputUtil.pressEnterToContinue();
        System.out.println();

        minibattle.startBattle();

        PrintUtil.line();
        PrintUtil.victory("""
                    ✅🏆 Mini-Boss Defeated!
                    Zyrryl falls to one knee, his molten armor cracking apart.
                    You have shattered the guardian of flame.
                    """);
        PrintUtil.loot("You gain rare loot and powerful rewards!\n");
        miniboss.dropLoot(player);
        InputUtil.pressEnterToContinue();
        PrintUtil.line();
        player.getEffects().resetAllEffects();

        // --- Pre Final Encounter ---
        PrintUtil.effect("""
                As you advance deeper into the ruins, a cloaked figure materializes before you.
                
                "Before you face the Final Boss… prove your mastery of the pillars of OOP.
                Each question must be answered within time… and without error."
                
                Answer every question correctly to earn ONE legendary artifact.
                One mistake — and your trial ends immediately.
                """);

        PrintUtil.event("                                                                                                                    \n" +
                "                                                                                                                    \n" +
                "█████▄ █████▄  ██████         ██████ ██ ███  ██ ▄████▄ ██       █████▄ ▄████▄ ▄█████ ▄█████                         \n" +
                "██▄▄█▀ ██▄▄██▄ ██▄▄     ▄▄▄   ██▄▄   ██ ██ ▀▄██ ██▄▄██ ██       ██▄▄██ ██  ██ ▀▀▀▄▄▄ ▀▀▀▄▄▄                         \n" +
                "██     ██   ██ ██▄▄▄▄         ██     ██ ██   ██ ██  ██ ██████   ██▄▄█▀ ▀████▀ █████▀ █████▀                         \n" +
                "                                                                                                                    \n" +
                "                                                                                                                    \n" +
                "                                                                                                                    \n" +
                "█████▄  ▄████▄ ███  ██ ████▄  ▄████▄ ██▄  ▄██   ██████ ███  ██ ▄█████ ▄████▄ ██  ██ ███  ██ ██████ ██████ █████▄    \n" +
                "██▄▄██▄ ██▄▄██ ██ ▀▄██ ██  ██ ██  ██ ██ ▀▀ ██   ██▄▄   ██ ▀▄██ ██     ██  ██ ██  ██ ██ ▀▄██   ██   ██▄▄   ██▄▄██▄ ▀ \n" +
                "██   ██ ██  ██ ██   ██ ████▀  ▀████▀ ██    ██   ██▄▄▄▄ ██   ██ ▀█████ ▀████▀ ▀████▀ ██   ██   ██   ██▄▄▄▄ ██   ██ ▄ \n" +
                "                                                                                                                    ");

        PrintUtil.pause(1500);

        PrintUtil.event("                                                                                                                           \n" +
                "                                                                                                                           \n" +
                "▄█████ ██ █████▄    ██  ██ ▄████▄ ███  ██       ██████ ██  ██ ██████   ▄█████▄ ██  ██ ██████ █████▄  ██████ ███  ██ ██████ \n" +
                "▀▀▀▄▄▄ ██ ██▄▄██▄   ██▄▄██ ██  ██ ██ ▀▄██         ██   ██████ ██▄▄     ██ ▄ ██ ██  ██ ██▄▄   ██▄▄██▄ ██▄▄   ██ ▀▄██   ██   \n" +
                "█████▀ ██ ██   ██    ▀██▀  ▀████▀ ██   ██  ▄      ██   ██  ██ ██▄▄▄▄   ▀█████▀ ▀████▀ ██▄▄▄▄ ██   ██ ██▄▄▄▄ ██   ██   ██   \n" +
                "                                          ▀                                 ▀▀                                             ");

        PrintUtil.pause(1500);
        PrintUtil.objective("                                                          \n" +
                "                                                          \n" +
                "                        -*%@@@@@%=                        \n" +
                "                       +@@@%-=%@@@*.                      \n" +
                "                      :@@@@.   %@@@:                      \n" +
                "                              +@@@#.                      \n" +
                "                            +%@@@#.                       \n" +
                "                           %@@@#.                         \n" +
                "                          -@@@#                           \n" +
                "                                                          \n" +
                "                          -@@@%                           \n" +
                "                          :*##+                           \n" +
                "                                                          \n" +
                "                            @@                            \n" +
                "                           @@@@                           \n" +
                "                        .*%@@@@#-                         \n" +
                "                        *@@%%@%%#:                        \n" +
                "                       :#@@@@@@@%=                        \n" +
                "                       -@@@@@@@@@*.                       \n" +
                "                       +@@@@@@@@@%-                       \n" +
                "                      .#@@@@@@@@@@+                       \n" +
                "                      :@@@@@@@@@@@#.                      \n" +
                "                      =@@@@@@@@@@@@:                      \n" +
                "                      +@@@@@@@@@@@@=                      \n" +
                "                      *@@@@@@@@@@@@+                      \n" +
                "                      %@@@@@@@@@@@@#                      \n" +
                "                     .@@@@@@@@@@@@@%.                     \n" +
                "                     -@@@@@@@@@@@@@@:                     \n" +
                "                     +@@@@@@@@@@@@@@+                     \n" +
                "                   -*##%%%%%%######**+:                   \n" +
                "                                                          ");

        PrefiEncounter prefiEncounter = new PrefiEncounter();
        prefiEncounter.start(player);

        // --- Boss: the revelation ---
        PrintUtil.title("BOSS — Sir Khai, the Necromancer");
        System.out.println(ColorUtil.brightMagenta("                                     \n" +
                "                                     \n" +
                "                                     \n" +
                "                                     \n" +
                "                 :*-                 \n" +
                "                :%#+=                \n" +
                "               :%@#+=-               \n" +
                "              .%@@#+==+.             \n" +
                "             :%%@@@%+==#.            \n" +
                "            -@%%@@@@@#==%:           \n" +
                "           =%%%@@@@@@@%=*@-          \n" +
                "          +%%@@@@@@%###%%%%+         \n" +
                "         *%#%%%%@@%%####%@#%+        \n" +
                "        *%#@@@#%@@@@@@%%%@#*#+       \n" +
                "      .*@@@@@@@@%%%@@@@@@@%**#+      \n" +
                "     :*@@@@@@%@%#####%@@@@@%***=     \n" +
                "    :#@@@%%%@@%%%%%%%%%@@@@@%***=    \n" +
                "   :#@%%%%%@@@@@@@%%%%%%%@@@@@@#*=   \n" +
                "   ++++***************************=  \n" +
                "                                     \n" +
                "                                     \n" +
                "                                     "));
        PrintUtil.loot("At the summit, you see the Third Stone pulsing with violet light on an altar.");
        PrintUtil.pause(600);
        PrintUtil.loot("You reach out. The Stones unite—humming and pulling themselves closer together like a single heartbeat.");
        PrintUtil.pause(600);
        System.out.println();

        PrintUtil.effect("Then Khai the Gray steps forward, staff blazing.\n");
        PrintUtil.pause(800);
        PrintUtil.say("Sir Khai", "\"Finally. \nYou’ve served well, my student. Who better to collect the stones of life than one who trusts their teacher?\"");
        PrintUtil.say("Sir Khai", "\"I have guided you not to save this land—but to claim its power. \n" +
                "Because only the most skilled and pure can bring the stones together. I have been waiting for a student like you for a millenia. \n" +
                "I wish to bring chaos not only to this land, but also in the lands beyond. \n" +
                "The Necromancer you sought... The one who wants to bring chaos to all worlds... is ME!!!!!!!!!\"\n");

        PrintUtil.hr();
    }
}