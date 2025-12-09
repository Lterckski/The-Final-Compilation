package worlds;

import enemies.*;
import battle.Battle;
import characters.Character;
import utils.ColorUtil;
import utils.InputUtil;
import utils.PrintUtil;

public class World1 {

    public void run(Character player) {
        PrintUtil.pause(2000);
        System.out.println();
        PrintUtil.title("                                                                               ╦ ╦╔═╗╦═╗╦  ╔╦╗   ╗");
        PrintUtil.title("╔═════════════════════════════════════════════════════════════════════════════ ║║║║ ║╠╦╝║   ║║   ║ ════════════════════════════════════════════════════════════════════════════════════╗");
        PrintUtil.title("                                                                               ╚╩╝╚═╝╩╚═╩═╝═╩╝   ╩");
        System.out.println();
        PrintUtil.title(" ▄▀▀▀█▀▀▄  ▄▀▀▄ ▄▄   ▄▀▀█▄▄▄▄      ▄▀▀▀█▄    ▄▀▀▀▀▄   ▄▀▀▄▀▀▀▄  ▄▀▀█▄▄▄▄  ▄▀▀▀▀▄  ▄▀▀▀█▀▀▄      ▄▀▀▀▀▄   ▄▀▀▀█▄        ▄▀▀▀▀▄  ▄▀▀█▀▄   ▄▀▀▀▀▄     ▄▀▀█▄▄▄▄  ▄▀▀▄ ▀▄  ▄▀▄▄▄▄   ▄▀▀█▄▄▄▄ \n" +
                           "█    █  ▐ █  █   ▄▀ ▐  ▄▀   ▐     █  ▄▀  ▀▄ █      █ █   █   █ ▐  ▄▀   ▐ █ █   ▐ █    █  ▐     █      █ █  ▄▀  ▀▄     █ █   ▐ █   █  █ █    █     ▐  ▄▀   ▐ █  █ █ █ █ █    ▌ ▐  ▄▀   ▐ \n" +
                           "▐   █     ▐  █▄▄▄█    █▄▄▄▄▄      ▐ █▄▄▄▄   █      █ ▐  █▀▀█▀    █▄▄▄▄▄     ▀▄   ▐   █         █      █ ▐ █▄▄▄▄          ▀▄   ▐   █  ▐ ▐    █       █▄▄▄▄▄  ▐  █  ▀█ ▐ █        █▄▄▄▄▄  \n" +
                           "   █         █   █    █    ▌       █    ▐   ▀▄    ▄▀  ▄▀    █    █    ▌  ▀▄   █     █          ▀▄    ▄▀  █    ▐       ▀▄   █      █        █        █    ▌    █   █    █        █    ▌  \n" +
                           " ▄▀         ▄▀  ▄▀   ▄▀▄▄▄▄        █          ▀▀▀▀   █     █    ▄▀▄▄▄▄    █▀▀▀    ▄▀             ▀▀▀▀    █             █▀▀▀    ▄▀▀▀▀▀▄   ▄▀▄▄▄▄▄▄▀ ▄▀▄▄▄▄   ▄▀   █    ▄▀▄▄▄▄▀  ▄▀▄▄▄▄   \n" +
                           "█          █   █     █    ▐       █                  ▐     ▐    █    ▐    ▐      █                      █              ▐      █       █  █         █    ▐   █    ▐   █     ▐   █    ▐   \n" +
                           "▐          ▐   ▐     ▐            ▐                             ▐                ▐                      ▐                     ▐       ▐  ▐         ▐        ▐        ▐         ▐        ");
        System.out.println();
        PrintUtil.title("╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
        InputUtil.pressEnterToContinue();
        System.out.println();

        System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println();
        PrintUtil.story("""
                You wake up in a dead forest. Bark is gray, leaves crunch to ash, and a cold mist coils between skeletal trees.
                Silence presses from every side—watching, waiting.
                """);
        PrintUtil.sayGreen("""
                A voice: "Dong…"
                """);
        PrintUtil.story("""
                From the mist steps a robed figure—your but you realize this person looks like your professor, Khai...\s
                """);
        PrintUtil.sayGreen("""        
                "In this world, I am known as Khai the Gray, we suffer because an evil necromancer has corrupted these lands and we must find 
                the  three stones of life that hold this world together to defeat him." he says.   
                "Only then will your path home reveal itself."
                """);
        System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        InputUtil.pressEnterToContinue();

        // -------------------- Rotfang Wolves --------------------
        System.out.println();
        PrintUtil.line();
        PrintUtil.story("""
                ⚔️ Suddenly, the ground trembles as three Rotfang Wolves emerge from the shadows!
                Their glowing red eyes fixate on you, teeth bared and claws digging into the earth.
                Prepare yourself for a ferocious battle!
                """);

        PrintUtil.pause(1500);
        PrintUtil.enemyEncounter("                                                           ");
        PrintUtil.enemyEncounter("                                  *%#                      ");
        PrintUtil.enemyEncounter("                               *@@@@%                      ");
        PrintUtil.enemyEncounter("                               *@@@@#                      ");
        PrintUtil.enemyEncounter("                              %@@@@@@       %  %           ");
        PrintUtil.enemyEncounter("                           .%@@@@@@@#      .%@@%           ");
        PrintUtil.enemyEncounter("        +#-            =%@@@@@@@@@@@.     .@@@@%           ");
        PrintUtil.enemyEncounter("       =%@@@@#=:     #@@@@@@@@@@@@@*   .=%@@@@%+           ");
        PrintUtil.enemyEncounter("      :+=@@@@@@@@@@##@@@@@@@@@@@@@%+%@@@@@@@@@%            ");
        PrintUtil.enemyEncounter("          +@@@@@@@%#*@@%%%#%*@@##*+%@@@@@@@@@@.            ");
        PrintUtil.enemyEncounter("            =@@@@*%@*@@*#@@. @% %%*%@*@###@#%:             ");
        PrintUtil.enemyEncounter("             #::*%@*%**=##*@=+% *#*#: @= -+.*              ");
        PrintUtil.enemyEncounter("            --  =  #  +-++=  =% *=-  *.   +.-              ");
        PrintUtil.enemyEncounter("           --  .-  @ =:  +*   @-=#:   *   +:=              ");
        PrintUtil.pause(600);
        System.out.println();


        PrintUtil.objective(("🎯 Objective: Defeat 3 Rotfang Wolves!"));
        PrintUtil.line();
        InputUtil.pressEnterToContinue();

        Enemy enemy1 = new World1Enemy1();
        Battle battle1 = new Battle(player, enemy1);

        System.out.println();
        enemy1.displaySkills();
        InputUtil.pressEnterToContinue();
        System.out.println();

        for (int i = 1; i <= 3; i++) {
            System.out.println(ColorUtil.boldBrightRed("════════════════════════════════════"));
            PrintUtil.enemyEncounter("🐺 Rotfang Wolf " + i + " lunges at you!");
            System.out.println(ColorUtil.boldBrightRed("════════════════════════════════════"));

            battle1.startBattle();

            System.out.println();
            System.out.println(ColorUtil.boldBrightGreen("───────────────────────────────────────"));
            PrintUtil.enemyDefeated("✅ You have defeated Rotfang Wolf " + i + "!");
            System.out.println(ColorUtil.boldBrightGreen("───────────────────────────────────────"));
            enemy1.dropLoot(player);

            if (i < 3) { // reset for another wolf
                enemy1 = new World1Enemy1();
                battle1 = new Battle(player, enemy1);
            }
        }

        PrintUtil.objective(("🎯 Objective: Defeat 3 Rotfang Wolves! ✅ (3 / 3)"));
        System.out.println();
        PrintUtil.line();
        PrintUtil.victory("""
                🎉 Victory! The last of the Rotfang Wolves collapses to the ground.
                The forest falls silent, and you catch your breath, victorious.
                """);
        PrintUtil.loot("You emerge stronger, collecting experience and useful potions.");
        PrintUtil.line();
        InputUtil.pressEnterToContinue();
        player.getEffects().resetAllEffects();

        // -------------------- Shade Sprites --------------------
        System.out.println();
        PrintUtil.line();
        PrintUtil.story("""
                🌫️ The mist thickens... shadows twist into vague shapes.
                From the darkness, two Shade Sprites materialize — faint outlines of faces flickering in and out of sight.
                Their whispers echo through your mind like broken static.
                """);

        PrintUtil.pause(1500);
        System.out.println("                                                          ");
        PrintUtil.enemyEncounter("             .+@+.                                        ");
        PrintUtil.enemyEncounter("             -%@#:            :                           ");
        PrintUtil.enemyEncounter("            -@@@@%:           .+    .+@=     =:           ");
        PrintUtil.enemyEncounter("           .*@@@@@+        .:..+-:.-#@@@*:.::-.:=:.       ");
        PrintUtil.enemyEncounter("           -@@@@@@@:       ..+++#%@@@@@@@@@%*+*+          ");
        PrintUtil.enemyEncounter("          .%@@@@@@@#.     :.-*+*==#*#@@@***===--=:        ");
        PrintUtil.enemyEncounter("          =*#@@@@@+*-          :+=.-%@@@#::==.            ");
        PrintUtil.enemyEncounter("         :#-=@@@@@--#.        .+:.+@@@@@@%-.--            ");
        PrintUtil.enemyEncounter("          . =@@@@@: .          .=*@@@@@@@@@#+-.           ");
        PrintUtil.enemyEncounter("            =@@@@%:            :--%@@@@@@@#*=::           ");
        PrintUtil.enemyEncounter("            -%@@@%:            :.-+#@@@@@%=-:             ");
        PrintUtil.enemyEncounter("            :+%@@+:              ::-#@@@+--               ");
        PrintUtil.enemyEncounter("            .=*%#=.                .=%%%+.                ");
        PrintUtil.enemyEncounter("             :-*+-                  .-%+                  ");
        PrintUtil.enemyEncounter("              .=-.                   .+                   ");
        PrintUtil.enemyEncounter("              .-.                     .                   ");
        PrintUtil.enemyEncounter("               .                                          ");
        PrintUtil.enemyEncounter("                                                          ");
        System.out.println("                                                          ");

        PrintUtil.objective(("🎯 Objective: Defeat 2 Shade Sprites!"));
        PrintUtil.line();
        InputUtil.pressEnterToContinue();

        Enemy enemy2 = new World1Enemy2();
        Battle battle2 = new Battle(player, enemy2);

        System.out.println();
        enemy2.displaySkills();
        InputUtil.pressEnterToContinue();
        System.out.println();

        for (int i = 1; i <= 2; i++) {
            System.out.println(ColorUtil.boldBrightRed("═══════════════════════════════════════════════════════"));
            PrintUtil.enemyEncounter("👻 Shade Sprite " + i + " phases through the air toward you!");
            System.out.println(ColorUtil.boldBrightRed("═══════════════════════════════════════════════════════"));

            battle2.startBattle();

            System.out.println();
            System.out.println(ColorUtil.boldBrightGreen("────────────────────────────────────"));
            PrintUtil.enemyDefeated("✅ You dispelled Shade Sprite " + i + "!");
            System.out.println(ColorUtil.boldBrightGreen("────────────────────────────────────"));
            enemy2.dropLoot(player);

            if (i < 2) { // reset for another shade
                enemy2 = new World1Enemy2();
                battle2 = new Battle(player, enemy2);
            }
        }

        PrintUtil.objective(("🎯 Objective: Defeat 2 Shade Sprites! ✅ (2 / 2)"));
        System.out.println();
        PrintUtil.line();
        PrintUtil.victory("""
                🌌 Silence returns. The mist recedes, revealing faint lights hovering like stars among the trees.
                You feel your strength returning after overcoming the whispering darkness.
                """);
        PrintUtil.loot("Your victory rewards you with precious loot and experience!");
        PrintUtil.line();
        InputUtil.pressEnterToContinue();
        player.getEffects().resetAllEffects();

        // -------------------- Dreadbark Treants --------------------
        System.out.println();
        PrintUtil.line();
        PrintUtil.story("""
                🌲 The ground rumbles... massive roots burst from beneath your feet!
                From the fog rise two Dreadbark Treants — ancient trees corrupted by decay.
                Their hollow eyes glow with green fire as they creak and move toward you.
                """);

        PrintUtil.pause(1500);
        System.out.println();
        PrintUtil.enemyEncounter("            :+:    .=:                ...:+-:.            ");
        PrintUtil.enemyEncounter("           ==*::.::-+.:              .:=+*-:..-=:-        ");
        PrintUtil.enemyEncounter("          -=##*+#*=%=*-             .=+*=+##*#=-.-        ");
        PrintUtil.enemyEncounter("       ++=.:..-#%%#..  ::          .  -:*#@%#@%*. .       ");
        PrintUtil.enemyEncounter("       .-#:=*##%@@#+*===-            :-=.:#%@%-:.   :*-   ");
        PrintUtil.enemyEncounter("      :+*=@@@@@@%%%@@@#*-               :##@@%%.   -#%#-  ");
        PrintUtil.enemyEncounter("       --+@@@@@@%%%@@@*:             ::*@%%%%%%%-. :*#+.  ");
        PrintUtil.enemyEncounter("        :@@@#@@@@@@@%@#:            .-*@@@@%@@%@%-  :=.   ");
        PrintUtil.enemyEncounter("      ++@%-==#@@@@@# +%#=.        .:=#%*%+#@@@*%***-=-    ");
        PrintUtil.enemyEncounter("     :#@%= ::*%@@@@+..=@@=.           =#:.-%@*:=*:  :-    ");
        PrintUtil.enemyEncounter("    .-#@#- ..#@@@@@%= .*%#:           %# -#@@@+.*%-.:.    ");
        PrintUtil.enemyEncounter("     =%+..  .#@@@@@@#+*-:#*.        .:%: +%%@%#. =:##:    ");
        PrintUtil.enemyEncounter("     +@=   :=@@@@@@@@=.-*@@+         -+  =@%%%#. : :+.    ");
        PrintUtil.enemyEncounter("    .*%*= .=%@%=*%=@@%=  =%%#+-:.    =%: +@%#%#. . :=     ");
        PrintUtil.enemyEncounter("    -%- - -*@%=:+*.=@@*   : :%@%%%#: *:- +@%%%%.   .-     ");
        PrintUtil.enemyEncounter("    .*#-  .@@*  :=.:*@%=  .   -+@@@- :=..%%%%@@.   ::     ");
        PrintUtil.enemyEncounter("     :.   @@@+  :  *@@*        .-:      =@%@@@@=   -      ");
        PrintUtil.enemyEncounter("     .    @@#.     .%@#                 #@@%@%%%. .-      ");
        PrintUtil.enemyEncounter("        :%@#..     ..@@=              :*@@%@@@@@=:.-      ");
        PrintUtil.enemyEncounter("       :*@@*         %@@=        -=. -*#@%@@@@@@*-.- --.  ");
        PrintUtil.enemyEncounter("  : :#@@@@@@*:  .  -+@@@@@#+. .  -=-*@@@@@@@%@@@@%+#===.  ");
        PrintUtil.enemyEncounter("+*%@@@@@@@@@@@@@@@@@@@@@@@@@@@#*#%@@@@%@@@@@@@@@@@@@@@@%*+");
        PrintUtil.enemyEncounter("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        PrintUtil.enemyEncounter("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        PrintUtil.enemyEncounter("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*#@@");
        PrintUtil.enemyEncounter("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println();

        PrintUtil.objective(("🎯 Objective: Defeat 2 Dreadbark Treants!"));
        PrintUtil.line();
        InputUtil.pressEnterToContinue();

        Enemy enemy3 = new World1Enemy3();
        Battle battle3 = new Battle(player, enemy3);

        System.out.println();
        enemy3.displaySkills();
        InputUtil.pressEnterToContinue();
        System.out.println();

        for (int i = 1; i <= 2; i++) {
            System.out.println(ColorUtil.boldBrightRed("═════════════════════════════════════════════════════════"));
            PrintUtil.enemyEncounter("🌳 Dreadbark Treant " + i + " slams its massive arm down at you!");
            System.out.println(ColorUtil.boldBrightRed("═════════════════════════════════════════════════════════"));

            battle3.startBattle();

            System.out.println();
            System.out.println(ColorUtil.boldBrightGreen("─────────────────────────────────────"));
            PrintUtil.enemyDefeated("✅ You felled Dreadbark Treant " + i + "!");
            System.out.println(ColorUtil.boldBrightGreen("─────────────────────────────────────"));
            enemy3.dropLoot(player);

            if (i < 2) {
                enemy3 = new World1Enemy3();
                battle3 = new Battle(player, enemy3);
            }
        }

        PrintUtil.objective(("🎯 Objective: Defeat 2 Dreadbark Treants! ✅ ( 2 / 2)"));
        System.out.println();
        PrintUtil.line();
        PrintUtil.victory("""
                🍃 The Treants collapse, their bark crumbling into soil.
                Life stirs in the forest again — small sprouts rise where their bodies fell.
                """);
        PrintUtil.loot("Your triumph echoes through the battlefield as treasures fall into your hands.");
        PrintUtil.line();
        InputUtil.pressEnterToContinue();
        player.getEffects().resetAllEffects();

        // -------------------- Carrion Bats --------------------
        System.out.println();
        PrintUtil.line();
        PrintUtil.story("""
                🦇 A shrill screech pierces the silence!
                Four Carrion Bats dive from the canopy, their wings slicing through the fog.
                The air reeks of rot as they circle you, ready to strike.
                """);

        PrintUtil.pause(1500);
        System.out.println();
        PrintUtil.enemyEncounter("                         .-                                ");
        PrintUtil.enemyEncounter("                      .*@@-                                ");
        PrintUtil.enemyEncounter("                     -@@%-                                 ");
        PrintUtil.enemyEncounter("                  =*+@@*:                                 ");
        PrintUtil.enemyEncounter("          .+@@@@@@@@@%.                                    ");
        PrintUtil.enemyEncounter("         ..+##%#=-=%@+          .                          ");
        PrintUtil.enemyEncounter("                                :%%-                       ");
        PrintUtil.enemyEncounter("                                 -%@+                      ");
        PrintUtil.enemyEncounter("                                   =@@%::::.               ");
        PrintUtil.enemyEncounter("                    .-:            .#%**%@%%+.            ");
        PrintUtil.enemyEncounter("                     =@@*.                                 ");
        PrintUtil.enemyEncounter("                      -%@%=-:                              ");
        PrintUtil.enemyEncounter("                        .#@@%#%@@%#=                       ");
        PrintUtil.enemyEncounter("                         :#*-::+=:.                        ");
        PrintUtil.enemyEncounter("                                                          ");
        PrintUtil.enemyEncounter("                                     :%#:                  ");
        PrintUtil.enemyEncounter("                                       .+@@%#=.           ");
        PrintUtil.enemyEncounter("                                                          ");
        PrintUtil.enemyEncounter("                                                          ");
        System.out.println();

        PrintUtil.objective(("🎯 Objective: Defeat 4 Carrion Bats!"));
        PrintUtil.line();
        InputUtil.pressEnterToContinue();

        Enemy enemy4 = new World1Enemy4();
        Battle battle4 = new Battle(player, enemy4);

        System.out.println();
        enemy4.displaySkills();
        InputUtil.pressEnterToContinue();
        System.out.println();

        for (int i = 1; i <= 4; i++) {
            System.out.println(ColorUtil.boldBrightRed("═══════════════════════════════════════════"));
            PrintUtil.enemyEncounter("🦇 Carrion Bat " + i + " swoops down, fangs bared!");
            System.out.println(ColorUtil.boldBrightRed("═══════════════════════════════════════════"));

            battle4.startBattle();

            System.out.println();
            System.out.println(ColorUtil.boldBrightGreen("─────────────────────────────"));
            PrintUtil.enemyDefeated("✅ You slayed Carrion Bat " + i + "!");
            System.out.println(ColorUtil.boldBrightGreen("─────────────────────────────"));
            enemy4.dropLoot(player);

            if (i < 4) {
                enemy4 = new World1Enemy4();
                battle4 = new Battle(player, enemy4);
            }
        }

        PrintUtil.objective(("🎯 Objective: Defeat 4 Carrion Bats! ✅ ( 4 / 4)"));
        System.out.println();
        PrintUtil.line();
        PrintUtil.victory("""
                💨 The last bat crashes into the ground.
                The forest grows quiet once more, the stench of decay lifting into the cold wind.
                """);
        PrintUtil.loot("The battle ends. You feel stronger... and richer.");
        PrintUtil.line();
        InputUtil.pressEnterToContinue();
        player.getEffects().resetAllEffects();

        // -------------------- MINI-BOSS — THE HOLLOW STAG --------------------
        System.out.println();
        PrintUtil.line();
        PrintUtil.story("""
                🌕 The mist thins, revealing a clearing drenched in moonlight.
                The trees twist around a great blackened oak — and from behind it steps a massive stag.
                Its antlers are cracked and glowing faintly, its eyes burning with white fire.
                You feel an ancient sadness… and danger.
                """);
        PrintUtil.event("                                                                                                            \n" +
                "                                                                                                            \n" +
                "██▄  ▄██ ▄▄ ▄▄  ▄▄ ▄▄ ▄▄▄▄   ▄▄▄   ▄▄▄▄  ▄▄▄▄   ██████ ▄▄  ▄▄  ▄▄▄▄  ▄▄▄  ▄▄ ▄▄ ▄▄  ▄▄ ▄▄▄▄▄▄ ▄▄▄▄▄ ▄▄▄▄    \n" +
                "██ ▀▀ ██ ██ ███▄██ ██ ██▄██ ██▀██ ███▄▄ ███▄▄   ██▄▄   ███▄██ ██▀▀▀ ██▀██ ██ ██ ███▄██   ██   ██▄▄  ██▄█▄ ▀ \n" +
                "██    ██ ██ ██ ▀██ ██ ██▄█▀ ▀███▀ ▄▄██▀ ▄▄██▀   ██▄▄▄▄ ██ ▀██ ▀████ ▀███▀ ▀███▀ ██ ▀██   ██   ██▄▄▄ ██ ██ ▄ \n" +
                "                                                                                                            ");
        PrintUtil.pause(500);

        PrintUtil.event("                                                                                                   \n" +
                "                                                                                                   \n" +
                "   ██████ ██  ██ ██████   ██  ██ ▄████▄ ██     ██     ▄████▄ ██     ██   ▄█████ ██████ ▄████▄  ▄████  \n" +
                "     ██   ██████ ██▄▄     ██████ ██  ██ ██     ██     ██  ██ ██ ▄█▄ ██   ▀▀▀▄▄▄   ██   ██▄▄██ ██  ▄▄▄ \n" +
                "     ██   ██  ██ ██▄▄▄▄   ██  ██ ▀████▀ ██████ ██████ ▀████▀  ▀██▀██▀    █████▀   ██   ██  ██  ▀███▀  \n" +
                "                                                                                                   ");
        System.out.println();
        PrintUtil.pause(600);

        PrintUtil.objective("═════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println();
        PrintUtil.effect("""
                Once a noble guardian of this forest, the Hollow Stag is now corrupted by the same darkness that drains the land.
                Its hooves scorch the ground, and the forest holds its breath.
                Prepare yourself — this will be no ordinary fight.
                """);
        PrintUtil.objective("═════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println();
        PrintUtil.pause(1500);

        System.out.println();
        PrintUtil.enemyEncounter("                                                          \n" +
                "                          :                               \n" +
                "                -:         *:                             \n" +
                "                 *.        -#                             \n" +
                "                -%:       -%#.                            \n" +
                "             .=%#.   *%%%@%:                              \n" +
                "            +%*.  +%@@#- .                                \n" +
                "     .      %#= .*@@%        :=                           \n" +
                "    .-   :-+%%+ =%@%%%%%#-   -#                           \n" +
                "     +#+#%##%#%*#%@@#:--+%%@%#.                           \n" +
                "       -.   .#%@%%@@@@@%@@@%#%:                           \n" +
                "           =*#%@@@@%#%@@@@@@%#%%=                         \n" +
                "             -@@%%@@%@@@@@@%%%#@%-                        \n" +
                "             -@@@@@%@@@@@@@@%@%%@@#=::             =-     \n" +
                "             :*%@=%@@@@@@@@@@@@@@@@@@@@=         =%%:     \n" +
                "               =%- %@@@@@@@@@@@@@@@@@@@%.        =:       \n" +
                "                :  @@@@@@@@@@@@%@@@@@@@@#*       +        \n" +
                "                    *%@@@%@@%@@%@@@@@@@@==%+   .*         \n" +
                "                    .@%@@@%@@@@%%%#%@@@@:   :--.          \n" +
                "                     =@@#- *@@*@@@%:*%@@+                 \n" +
                "                      %%:  *@#  -%@@: =@@*                \n" +
                "                      +#.  +%-   -@+    *#                \n" +
                "                      =%.  -@   :%+     -%.               \n" +
                "                     .%@-  %@= +@#.     *@=               \n" +
                "                    .%@*  =%@..+=.     :%%-               \n" +
                "                         .-*+                             \n" +
                "                                                          ");
        System.out.println();

        PrintUtil.objective(("🎯 Objective: Defeat The Hollow Stag!"));
        PrintUtil.line();
        InputUtil.pressEnterToContinue();

        Enemy miniboss = new World1Miniboss1();
        Battle minibossBattle = new Battle(player, miniboss);

        System.out.println();
        miniboss.displaySkills();
        InputUtil.pressEnterToContinue();
        System.out.println();

        minibossBattle.startBattle();

        System.out.println();
        PrintUtil.objective(("🎯 Objective: Defeat The Hollow Stag! ✅"));
        System.out.println();
        PrintUtil.pause(1000);
        PrintUtil.line();
        PrintUtil.victory("""
                
                ✅🏆MINI-BOSS DEFEATED!
                🌟 The Hollow Stag staggers, its luminous eyes fading to black.
                With one final, echoing cry, it collapses to the ground. The forest trembles… then exhales.
                """);
        PrintUtil.line();
        PrintUtil.pause(1000);

        miniboss.dropLoot(player);
        InputUtil.pressEnterToContinue();
        PrintUtil.line();
        player.getEffects().resetAllEffects();

        System.out.println(ColorUtil.boldBrightYellow("                                     \n" +
                "                                     \n" +
                "                                     \n" +
                "                  =*:                \n" +
                "                .#@#+-               \n" +
                "               -%@@#++=              \n" +
                "              +@@@@#++++.            \n" +
                "             *@@@@@#+++++:           \n" +
                "           .*@@@@@@@%=====-          \n" +
                "          .*@@@@@@@@@%+--=*+         \n" +
                "         .+%%@@@@@@%#%%+--*@=        \n" +
                "         +#%%@@@@@@###@%*-+%%-       \n" +
                "        =##%%%%%@@%##%@@@#+%@%:      \n" +
                "       :#%%%%%%%@@@%%@@@@@%%@@#.     \n" +
                "      .*%%%@%%%%@@@@@@@@@@%+#@@=     \n" +
                "      -%%@@%%%%%%@@@@@@@@@%*+*%%.    \n" +
                "     .#@@@@%%%%%%%@@@@@@@@%####%=    \n" +
                "     .%@%%%%##%%@@@@@@@@@@%#####+.   \n" +
                "     .#%%%%%##%%@%%@@@@@@@%###%@+    \n" +
                "      +%##%%%%%%%%%%@@@@@@%%@@@@-    \n" +
                "      :####%####%%%@@@@@%%%@@@@+     \n" +
                "       :*##%%###%%%%%%%%%%@@@%+      \n" +
                "         =##%%%%%%%%%%%%%%@%*:       \n" +
                "           -*%@%%%%%%%%%%%*:         \n" +
                "              .-=+***+=-.            \n" +
                "                                     "));
        PrintUtil.loot("""
                You obtain the First Stone — pulsing with quiet power.
                The corruption fades, and the path ahead glows faintly in the mist.
                """);

        PrintUtil.line();
        PrintUtil.pause(1000);
        System.out.println();
        PrintUtil.specialCyan("You claim the First Stone from a tree black with rot. Light bursts outward; the forest exhales.");
        InputUtil.pressEnterToContinue();
    }
}