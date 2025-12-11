package worlds;

import enemies.*;
import battle.Battle;
import characters.Character;
import utils.ColorUtil;
import utils.InputUtil;
import utils.PrintUtil;
import utils.SoundUtil;

public class World1 {

    public void run(Character player) {
        SoundUtil.playLoop("worldbgm/world1_bgm.wav", 0.2f);
        // --- TITLE SEQUENCE ---
        PrintUtil.pause(1000);
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

        // --- STORY INTRO ---
        System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println();
        PrintUtil.story("""
                You wake up gasping for air. The world is drained of color.
                You are lying on a bed of gray moss in a dead forest. The trees are skeletal giants, stripped to bone-white wood.
                A cold mist coils around your ankles, and silence presses from every side—watching, waiting.
                """);
        PrintUtil.pause(2000);

        PrintUtil.effect("""
                A heavy bell tolls in the distance...
                "Dong... Dong..."
                """);
        PrintUtil.pause(1500);

        PrintUtil.story("""
                From the mist steps a figure cloaked in tattered robes. He leans heavily on a staff.
                As he lifts his hood, you jolt back—the face is familiar. It looks exactly like your professor, Khai.
                But his eyes are weary, holding the weight of centuries.
                """);

        PrintUtil.sayGreen("""        
                "Be calm, Traveler. In this realm, I am known as Khai the Gray."
                
                "We suffer because an evil Necromancer has corrupted these lands. He has drained the nature itself.
                We must find the Three Stones of Life that hold this reality together. Only then will your path home reveal itself."
                """);

        System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        InputUtil.pressEnterToContinue();

        // -------------------- Rotfang Wolves --------------------
        System.out.println();
        PrintUtil.line();
        PrintUtil.effect("Khai fades back into the mist. A low growl vibrates through the ground.");
        System.out.println();
        PrintUtil.pause(1000);

        PrintUtil.story("""
                ⚔️ Suddenly, shadows detach themselves from the tree line.
                Three Rotfang Wolves emerge! Their fur is matted with grime, and ribs show through rotting skin.
                Their glowing red eyes fixate on you. They do not hunt for food; they hunt to kill.
                """);

        PrintUtil.pause(1500);
        PrintUtil.enemyEncounter("                                                           ");
        PrintUtil.enemyEncounter("                                  *%#                      ");
        PrintUtil.enemyEncounter("                               *@@@@%                      ");
        PrintUtil.enemyEncounter("                               *@@@@#                      ");
        PrintUtil.enemyEncounter("                              %@@@@@@       %  %           ");
        PrintUtil.enemyEncounter("                           .%@@@@@@@#      .%@@%           ");
        PrintUtil.enemyEncounter("        +#-            =%@@@@@@@@@@@.     .@@@@%           ");
        PrintUtil.enemyEncounter("       =%@@@@#=:     #@@@@@@@@@@@@@* .=%@@@@%+           ");
        PrintUtil.enemyEncounter("      :+=@@@@@@@@@@##@@@@@@@@@@@@@%+%@@@@@@@@@%            ");
        PrintUtil.enemyEncounter("          +@@@@@@@%#*@@%%%#%*@@##*+%@@@@@@@@@@.            ");
        PrintUtil.enemyEncounter("            =@@@@*%@*@@*#@@. @% %%*%@*@###@#%:             ");
        PrintUtil.enemyEncounter("             #::*%@*%**=##*@=+% *#*#: @= -+.* ");
        PrintUtil.enemyEncounter("            --  =  #  +-++=  =% *=-  *.   +.-              ");
        PrintUtil.enemyEncounter("           --  .-  @ =:  +* @-=#:   * +:=              ");
        PrintUtil.pause(600);
        System.out.println();

        PrintUtil.objective(("🎯 Objective: Defeat 3 Rotfang Wolves!"));
        PrintUtil.line();
        SoundUtil.play("encounter/wolf_encounter.wav");
        InputUtil.pressEnterToContinue();

        Enemy enemy1 = new World1Enemy1();
        Battle battle1 = new Battle(player, enemy1);

        System.out.println();
        enemy1.displaySkills();
        InputUtil.pressEnterToContinue();
        System.out.println();

        for (int i = 1; i <= 3; i++) {
            System.out.println(ColorUtil.boldBrightRed("════════════════════════════════════════"));
            PrintUtil.enemyEncounter("🐺 Rotfang Wolf " + i + " lunges from the dark!");


            System.out.println(ColorUtil.boldBrightRed("═══════════════════════════════════════"));

            SoundUtil.play("attack/wolf_attack.wav");
            System.out.println(ColorUtil.boldBrightRed("════════════════════════════════════"));

            System.out.println(ColorUtil.boldBrightRed("════════════════════════════════════════"));

//            SoundUtil.play("attack/wolf_attack.wav");



            battle1.startBattle();

            System.out.println();
            System.out.println(ColorUtil.boldBrightGreen("─────────────────────────────────────────────────────────"));
            PrintUtil.enemyDefeated("✅ The wolf whimpers and dissolves into black smoke (" + i + "/3)");
            System.out.println(ColorUtil.boldBrightGreen("─────────────────────────────────────────────────────────"));
            enemy1.dropLoot(player);

            if (i < 3) { // reset for another wolf
                PrintUtil.pause(1000);
                System.out.println();
                PrintUtil.effect("Another wolf snarls and steps forward to take its place!");
                System.out.println();
                enemy1 = new World1Enemy1();
                battle1 = new Battle(player, enemy1);
            }
        }

        PrintUtil.objective(("🎯 Objective: Defeat 3 Rotfang Wolves! ✅ (3 / 3)"));
        System.out.println();
        PrintUtil.line();
        PrintUtil.victory("""
                🎉 Victory! The last of the Rotfang Wolves collapses.
                The adrenaline in your veins cools, but the forest feels no safer.
                """);
        PrintUtil.loot("You bandage your wounds and collect what little the wolves carried.");
        PrintUtil.line();
        SoundUtil.playLoop("worldbgm/world1_bgm.wav");
        InputUtil.pressEnterToContinue();
        player.getEffects().resetAllEffects();

        // -------------------- Shade Sprites --------------------
        System.out.println();
        PrintUtil.line();
        PrintUtil.effect("The path narrows. The mist becomes so thick you can barely see your hand in front of your face.");
        PrintUtil.pause(1500);

        System.out.println();
        PrintUtil.story("""
                🌫️ The air grows icy. The silence is broken by a sound like static,
                or perhaps whispering voices overlapping until they become noise.
                
                Shadows detach themselves from the trees. They twist and contort, forming vague, 
                human-like shapes that flicker in and out of existence.
                
                SHADE SPRITES.
                They are the lost souls of travelers who died in this woods, now jealous of your life.
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
            System.out.println(ColorUtil.boldBrightGreen("──────────────────────────────────────"));
            PrintUtil.enemyDefeated("✅ You dispelled Shade Sprite " + i + "! (" + i + "/2)");
            System.out.println(ColorUtil.boldBrightGreen("──────────────────────────────────────"));
            enemy2.dropLoot(player);

            if (i < 2) { // reset for another shade
                PrintUtil.pause(1000);
                System.out.println();
                PrintUtil.effect("The mist swirls violently as another soul screams into existence!");
                System.out.println();
                enemy2 = new World1Enemy2();
                battle2 = new Battle(player, enemy2);
            }
        }

        PrintUtil.objective(("🎯 Objective: Defeat 2 Shade Sprites! ✅ (2 / 2)"));
        System.out.println();
        PrintUtil.line();
        PrintUtil.victory("""
                🌌 With a final shriek, the sprites disperse like fog in the wind.
                The mist recedes, revealing faint lights hovering like stars among the trees.
                The whispering in your mind finally stops.
                """);
        PrintUtil.loot("You feel your strength returning after overcoming the darkness.");
        PrintUtil.line();
        SoundUtil.playLoop("worldbgm/world1_bgm.wav");
        InputUtil.pressEnterToContinue();
        player.getEffects().resetAllEffects();

        /// -------------------- Dreadbark Treants --------------------
        System.out.println();
        PrintUtil.line();
        PrintUtil.effect("You step over a massive tree root. Suddenly... the root moves beneath your feet.");
        PrintUtil.pause(1000);

        System.out.println();
        PrintUtil.story("""
                🌲 The earth heaves violently! What you thought were dead trees suddenly groan with the sound of snapping wood.
                
                Massive roots burst from the soil, thrashing like snakes. 
                Two DREADBARK TREANTS pull themselves free from the earth. 
                
                Corrupted by decay, their hollow eyes burn with green necrotic fire. 
                They raise massive, log-like arms to crush you.
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
        PrintUtil.enemyEncounter("    -%- - -*@%=:+*.=@@* : :%@%%%#: *:- +@%%%%.   .-     ");
        PrintUtil.enemyEncounter("    .*#-  .@@* :=.:*@%=  .   -+@@@- :=..%%%%@@.   ::     ");
        PrintUtil.enemyEncounter("     :.   @@@+  :  *@@* .-:      =@%@@@@=   -      ");
        PrintUtil.enemyEncounter("     .    @@#.     .%@#                 #@@%@%%%. .-      ");
        PrintUtil.enemyEncounter("        :%@#..     ..@@=              :*@@%@@@@@=:.-      ");
        PrintUtil.enemyEncounter("       :*@@* %@@=        -=. -*#@%@@@@@@*-.- --.  ");
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
            System.out.println(ColorUtil.boldBrightGreen("────────────────────────────────────────"));
            PrintUtil.enemyDefeated("✅ You felled Dreadbark Treant " + i + "! (" + i + "/2)");
            System.out.println(ColorUtil.boldBrightGreen("────────────────────────────────────────"));
            enemy3.dropLoot(player);

            if (i < 2) {
                PrintUtil.pause(1000);
                System.out.println();
                PrintUtil.effect("The ground quakes again! The second ancient giant lumbers forward.");
                System.out.println();
                enemy3 = new World1Enemy3();
                battle3 = new Battle(player, enemy3);
            }
        }

        PrintUtil.objective(("🎯 Objective: Defeat 2 Dreadbark Treants! ✅ (2 / 2)"));
        System.out.println();
        PrintUtil.line();
        PrintUtil.victory("""
                🍃 The massive Treants freeze. With a sound like a falling building, they collapse.
                Their bark crumbles into soil, and where they fall, small green sprouts rise from the ash.
                """);
        PrintUtil.loot("You emerge covered in dust, but victorious. Treasures fall from the decaying wood.");
        PrintUtil.line();
        SoundUtil.playLoop("worldbgm/world1_bgm.wav");
        InputUtil.pressEnterToContinue();
        player.getEffects().resetAllEffects();

        // -------------------- Carrion Bats --------------------
        System.out.println();
        PrintUtil.line();
        PrintUtil.effect("The canopy above darkens. A stench of rotting meat washes over you.");
        PrintUtil.pause(1000);

        System.out.println();
        PrintUtil.story("""
                🦇 A shrill screech pierces the silence!
                Four CARRION BATS, each the size of a man, dive-bomb from the dead branches above.
                
                Their wings slice through the fog and their fangs drip with venom.
                They circle like vultures, sensing your fatigue.
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
            System.out.println(ColorUtil.boldBrightGreen("──────────────────────────────────"));
            PrintUtil.enemyDefeated("✅ You slayed Carrion Bat " + i + "! (" + i + "/4)");
            System.out.println(ColorUtil.boldBrightGreen("──────────────────────────────────"));
            enemy4.dropLoot(player);

            if (i < 4) {
                PrintUtil.pause(800);
                System.out.println();
                PrintUtil.effect("Another screech echoes above—the swarm continues!");
                System.out.println();
                enemy4 = new World1Enemy4();
                battle4 = new Battle(player, enemy4);
            }
        }

        PrintUtil.objective(("🎯 Objective: Defeat 4 Carrion Bats! ✅ (4 / 4)"));
        System.out.println();
        PrintUtil.line();
        PrintUtil.victory("""
                💨 The last bat crashes into the ground.
                The forest grows quiet once more, and the stench of decay lifts into the cold wind.
                The path ahead is clear.
                """);
        PrintUtil.loot("You catch your breath. You feel stronger... and richer.");
        PrintUtil.line();
        SoundUtil.playLoop("worldbgm/world1_bgm.wav");
        InputUtil.pressEnterToContinue();
        player.getEffects().resetAllEffects();

        // -------------------- MINI-BOSS — THE HOLLOW STAG --------------------
        System.out.println();
        PrintUtil.line();
        PrintUtil.effect("The mist thins, revealing a clearing drenched in pale, ghostly moonlight.");
        PrintUtil.pause(1000);

        System.out.println();
        PrintUtil.story("""
                🌕 The trees twist around a great blackened oak.
                From behind it steps a massive stag, twelve feet tall at the shoulder.
                
                Its antlers are cracked and glow with faint white fire.
                Its eyes burn not with anger, but with an ancient, crushing sadness.
                """);

        PrintUtil.pause(1500);

        // Title Card
        PrintUtil.event("                                                                                                            \n" +
                "                                                                                                            \n" +
                "██▄  ▄██ ▄▄ ▄▄  ▄▄ ▄▄ ▄▄▄▄   ▄▄▄   ▄▄▄▄  ▄▄▄▄   ██████ ▄▄  ▄▄  ▄▄▄▄  ▄▄▄  ▄▄ ▄▄ ▄▄  ▄▄ ▄▄▄▄▄▄ ▄▄▄▄▄ ▄▄▄▄    \n" +
                "██ ▀▀ ██ ██ ███▄██ ██ ██▄██ ██▀██ ███▄▄ ███▄▄   ██▄▄   ███▄██ ██▀▀▀ ██▀██ ██ ██ ███▄██   ██   ██▄▄  ██▄█▄ ▀ \n" +
                "██    ██ ██ ██ ▀██ ██ ██▄█▀ ▀███▀ ▄▄██▀ ▄▄██▀   ██▄▄▄▄ ██ ▀██ ▀████ ▀███▀ ▀███▀ ██ ▀██   ██   ██▄▄▄ ██ ██ ▄ \n" +
                "                                                                                                            ");
        PrintUtil.pause(200);

        PrintUtil.event("                                                                                                   \n" +
                "                                                                                                   \n" +
                "   ██████ ██  ██ ██████   ██  ██ ▄████▄ ██     ██     ▄████▄ ██     ██   ▄█████ ██████ ▄████▄  ▄████  \n" +
                "     ██   ██████ ██▄▄     ██████ ██  ██ ██     ██     ██  ██ ██ ▄█▄ ██   ▀▀▀▄▄▄   ██   ██▄▄██ ██  ▄▄▄ \n" +
                "     ██   ██  ██ ██▄▄▄▄   ██  ██ ▀████▀ ██████ ██████ ▀████▀  ▀██▀██▀    █████▀   ██   ██  ██  ▀███▀  \n" +
                "                                                                                                   ");
        System.out.println();
        PrintUtil.pause(1000);

        PrintUtil.objective("═════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println();
        PrintUtil.effect("""
                Once a noble guardian of this forest, the Hollow Stag is now corrupted by the darkness.
                Its hooves scorch the ground. It lowers its head, seeking peace through battle.
                """);
        PrintUtil.sayGreen("\"Free him,\" Khai's voice echoes in your mind. \"Break the chains of the Necromancer.\"");
        System.out.println();
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
                "                :  @@@@@@@@@@@@%@@@@@@@@#* +        \n" +
                "                    *%@@@%@@%@@%@@@@@@@@==%+   .* \n" +
                "                    .@%@@@%@@@@%%%#%@@@@:   :--.          \n" +
                "                     =@@#- *@@*@@@%:*%@@+                 \n" +
                "                      %%:  *@#  -%@@: =@@* \n" +
                "                      +#.  +%-   -@+    *#                \n" +
                "                      =%.  -@   :%+     -%.               \n" +
                "                     .%@-  %@= +@#.     *@=               \n" +
                "                    .%@* =%@..+=.     :%%-               \n" +
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
                
                ✅🏆 MINI-BOSS DEFEATED!
                
                🌟 The Hollow Stag staggers. The white fire in its antlers flickers and dies.
                With one final, echoing cry, it collapses.
                The corruption fades from its eyes, replaced by a deep, soft brown.
                It dissolves into particles of pure light.
                """);
        PrintUtil.line();
        SoundUtil.playLoop("worldbgm/world1_bgm.wav");
        PrintUtil.pause(2000);

        miniboss.dropLoot(player);
        InputUtil.pressEnterToContinue();
        PrintUtil.line();
        player.getEffects().resetAllEffects();

        // --- THE FIRST STONE ---
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
                You reach out and grasp the light. It solidifies into the FIRST STONE.
                It pulses with quiet power, driving away the chill of the dead forest.
                """);

        PrintUtil.line();
        PrintUtil.pause(1500);
        System.out.println();
        PrintUtil.specialCyan("You have cleansed the forest. The path ahead glows faintly in the mist.");
        InputUtil.pressEnterToContinue();
    }
}