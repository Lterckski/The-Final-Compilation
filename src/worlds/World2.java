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
                "                                                                           ░███    ░███    ░██ ░███████                                                                      \n" +
                "                                                                          ░██░██   ░████   ░██ ░██   ░██                                                                     \n" +
                "                                                                         ░██  ░██  ░██░██  ░██ ░██    ░██                                                                    \n" +
                "                                                                        ░█████████ ░██ ░██ ░██ ░██    ░██                                                                    \n" +
                "                                                                        ░██    ░██ ░██  ░██░██ ░██    ░██                                                                    \n" +
                "                                                                        ░██    ░██ ░██   ░████ ░██   ░██                                                                     \n" +
                "                                                                        ░██    ░██ ░██    ░███ ░███████                                                                      \n" +
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

        // --- STORY INTRO ---
        System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println();
        PrintUtil.story("""
                You emerge from the forest's edge, gasping as the clean air turns heavy and sour.
                Ahead lies a town, huddled against the gray sky.
                Relief surges for a moment—until the wind changes. It carries the copper scent of blood and the sickly sweet smell of rot.
                """);

        PrintUtil.pause(2000);

        PrintUtil.story("""
                You walk through the broken gates. The mud is thick and black.
                This place is diseased. The buildings lean like dying men, and the silence is broken only by wet, hacking coughs.
                """);

        PrintUtil.pause(1500);

        PrintUtil.sayGreen("""
                Khai stops, his face twisting in grief.
                "Look at them," he whispers.
                "Children cough in alleys, merchants peddle spoiled goods, and hollow-eyed guards demand bribes just to look the other way."
                """);

        PrintUtil.story("""
                "This town used to be the epitome of peace and unity," Khai continues, gripping his staff.
                "Now, every face tells the same story: something has poisoned the very heart of this world."
                """);

        System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        InputUtil.pressEnterToContinue();

        // -------------------- Plague Vermins --------------------
        System.out.println();
        PrintUtil.line();
        PrintUtil.effect("A scratching sound echoes from the gutters. The shadows near your feet begin to move.");
        PrintUtil.pause(1000);

        PrintUtil.story("""
                🐀 The stench of rot suddenly intensifies.
                From the sewers and piles of filth, three PLAGUE VERMINS scuttle out.
                
                They are the size of dogs, hairless and covered in weeping sores.
                They hiss, their yellow teeth bared, claws dripping with venomous filth.
                """);

        PrintUtil.pause(1500);
        System.out.println();
        PrintUtil.enemyEncounter("                  .                                       ");
        PrintUtil.enemyEncounter("                --.                                       ");
        PrintUtil.enemyEncounter("              .-++       ..                               ");
        PrintUtil.enemyEncounter("             -=:.     :==*#*+=-:      *%%*:               ");
        PrintUtil.enemyEncounter("             -*++.   :+%%%%%%#+-.    .* .=*=             ");
        PrintUtil.enemyEncounter("              .+-  .= .+%%%%%%%*=.    * -=.           ");
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
            System.out.println(ColorUtil.boldBrightRed("════════════════════════════════════════════════════"));
            PrintUtil.enemyEncounter("🐀 Plague Vermin " + i + " lunges, teeth snapping!");
            System.out.println(ColorUtil.boldBrightRed("════════════════════════════════════════════════════"));

            battle1.startBattle();

            System.out.println();
            System.out.println(ColorUtil.boldBrightGreen("───────────────────────────────────────"));
            PrintUtil.enemyDefeated("✅ You have crushed Plague Vermin " + i + "! (" + i + "/3)");
            System.out.println(ColorUtil.boldBrightGreen("───────────────────────────────────────"));
            enemy1.dropLoot(player);

            if (i < 3) { // reset for next vermin
                PrintUtil.pause(800);
                System.out.println();
                PrintUtil.effect("More scratching... another vermin crawls from the muck!");
                System.out.println();
                enemy1 = new World2Enemy1();
                battle1 = new Battle(player, enemy1);
            }
        }

        PrintUtil.objective(("🎯 Objective: Defeat 3 Plague Vermins! ✅ (3 / 3)"));
        System.out.println();
        PrintUtil.line();
        PrintUtil.victory("""
            🎉 Victory! The last of the Plague Vermins collapses into the sludge.
            The foul air clears just enough for you to breathe again, but the town remains silent.
            """);
        PrintUtil.loot("You wipe the filth from your blade and claim your rewards.");
        PrintUtil.line();
        InputUtil.pressEnterToContinue();
        player.getEffects().resetAllEffects();

        // -------------------- Forsaken Cultists --------------------
        System.out.println();
        PrintUtil.line();
        PrintUtil.effect("You wander through the town's crumbling streets. The air is thick with despair.");
        PrintUtil.pause(1000);

        System.out.println();
        PrintUtil.story("""
                You stop to help a beggar, offering a small kindness in a cruel world.
                He grabs your wrist, his eyes wide with fear.
                """);

        PrintUtil.sayGreen("""
                "Beware the Black Castle," he rasps. "The Corrupted King hoards the Second Stone there."
                "But the real master... is the Necromancer. He is a phantom who rules from the shadows."
                """);

        PrintUtil.pause(2000);

        PrintUtil.story("""
                Following the beggar's warning, you investigate a ruined chapel at the edge of town.
                Inside, the air hums with dark energy.
                
                Two FORSAKEN CULTISTS stand before a defiled altar.
                They turn slowly, their eyes glowing with fanatic light as they chant forbidden rites.
                """);

        PrintUtil.pause(1500);
        System.out.println();
        PrintUtil.enemyEncounter("        . -                                                ");
        PrintUtil.enemyEncounter("       ==+#* +@@*..                  :-.                 ");
        PrintUtil.enemyEncounter("       .+%++  -@@@@@@@@*.        .-+%@@@@@:                ");
        PrintUtil.enemyEncounter("         -#    *@@@@@@@@#       :%@@@@@@@@-                ");
        PrintUtil.enemyEncounter("         :*.   :=%@@@@@@@*.    :%@@@@@@@@* ");
        PrintUtil.enemyEncounter("         :.* @@%@@@@@%#.  :%@@@@@@@:=.                 ");
        PrintUtil.enemyEncounter("         : * .*@..=@@@@*#+  %*#@@@%*%:.                  ");
        PrintUtil.enemyEncounter("           #@%%#%+ :#@@@@%#+ .%#%@@@%#@* ");
        PrintUtil.enemyEncounter("            =.  - .#@@@@@@@=. *@@@@@@#-#-                  ");
        PrintUtil.enemyEncounter("            .* :#%@@@@@@@%- #@@@@@@@*=@:                 ");
        PrintUtil.enemyEncounter("             -.  .+@@@@@@@@-  =@@@@@@@#:#@=                ");
        PrintUtil.enemyEncounter("             -=   %@@@@@@@@=  +@@@@@@@@-  -%*.             ");
        PrintUtil.enemyEncounter("             .-. -@@@@@@@@@=  +@@@@@@@@%     *%=.          ");
        PrintUtil.enemyEncounter("              =- -@@@@@@@@@+  *@@@@@@@@%                   ");
        PrintUtil.enemyEncounter("              .-..@@@@@@@@@* *@@@@@@@@#                   ");
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
            PrintUtil.enemyEncounter("☠️ Forsaken Cultist " + i + " screams a curse and attacks!");
            System.out.println(ColorUtil.boldBrightRed("═══════════════════════════════════════════════════"));
            InputUtil.pressEnterToContinue();

            battle2.startBattle();

            System.out.println();
            System.out.println(ColorUtil.boldBrightGreen("─────────────────────────────────────────"));
            PrintUtil.enemyDefeated("✅ You silenced Forsaken Cultist " + i + "! (" + i + "/2)");
            System.out.println(ColorUtil.boldBrightGreen("─────────────────────────────────────────"));
            enemy2.dropLoot(player);

            if (i < 2) {
                PrintUtil.pause(1000);
                System.out.println();
                PrintUtil.effect("The second cultist roars in fury, the dark energy around him intensifying!");
                System.out.println();
                enemy2 = new World2Enemy2();
                battle2 = new Battle(player, enemy2);
            }
        }

        PrintUtil.objective(("🎯 Objective: Defeat 2 Forsaken Cultists! ✅ (2 / 2)"));
        System.out.println();
        PrintUtil.line();
        PrintUtil.victory("""
                🎉 Victory! The cultists’ chants fade into silence.
                The oppressive weight in the chapel lifts, though the altar remains stained with corruption.
                """);
        PrintUtil.loot("You search the robes of the fallen zealots and find useful items.");
        PrintUtil.line();
        InputUtil.pressEnterToContinue();
        player.getEffects().resetAllEffects();

        // -------------------- Blight Hounds --------------------
        System.out.println();
        PrintUtil.line();
        PrintUtil.effect("You leave the ruined chapel and head toward the castle outskirts. The air grows heavy with sulfur.");
        PrintUtil.pause(1000);

        System.out.println();
        PrintUtil.story("""
                A low, wet growl echoes from the fog ahead.
                Green toxic fumes swirl around your legs, burning your skin.
                
                From the black mist, three BLIGHT HOUNDS leap forth!
                Their fur is gone, replaced by callous skin, and their fangs drip with poisonous sludge.
                """);

        PrintUtil.pause(1500);
        System.out.println();
        PrintUtil.enemyEncounter("                  -             .-=+-. ::      .:         ");
        PrintUtil.enemyEncounter("            .- ....=               :-*%%%@+..+%-.         ");
        PrintUtil.enemyEncounter("            :-*%@%@@%* .::+%*#@@%@@%*=.       ");
        PrintUtil.enemyEncounter("     --    .*%@@@@@@@%#-::.           . -%@@@@@@@%%+.     ");
        PrintUtil.enemyEncounter("    =#:   +@@@%@@@@@@%@#-:-    ::=. :+@@@@@@@@@@@%@@=     ");
        PrintUtil.enemyEncounter("   ::   :%@@@%@%%@@@@%%@@#:   .+. .+#@@%%%*@@@@% :#*#.    ");
        PrintUtil.enemyEncounter("  .=  .**.@%:*@#%@#%--@@%-     .::..#@:.%%:=%-+#%-        ");
        PrintUtil.enemyEncounter("   :*+: =#= -%=:*@-@= .++:        +-  :* ++.  =+       ");
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
        PrintUtil.enemyEncounter("                            :=: .+-  .##.         =* ");
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
            System.out.println(ColorUtil.boldBrightRed("══════════════════════════════════════════════════"));
            PrintUtil.enemyEncounter("🐕 Blight Hound " + i + " snaps its jaws and lunges!");
            System.out.println(ColorUtil.boldBrightRed("══════════════════════════════════════════════════"));
            InputUtil.pressEnterToContinue();

            battle3.startBattle();

            System.out.println();
            System.out.println(ColorUtil.boldBrightGreen("───────────────────────────────────────"));
            PrintUtil.enemyDefeated("✅ You have put down Blight Hound " + i + "! (" + i + "/3)");
            System.out.println(ColorUtil.boldBrightGreen("───────────────────────────────────────"));
            enemy3.dropLoot(player);

            if (i < 3) {
                PrintUtil.pause(800);
                System.out.println();
                PrintUtil.effect("Another hound bursts through the poisonous cloud!");
                System.out.println();
                enemy3 = new World2Enemy3();
                battle3 = new Battle(player, enemy3);
            }
        }

        PrintUtil.objective(("🎯 Objective: Defeat 3 Blight Hounds! ✅ (3 / 3)"));
        System.out.println();
        PrintUtil.line();
        PrintUtil.victory("""
                🎉 Victory! The pack is silenced.
                The hounds dissolve into puddles of toxic sludge, clearing the way forward.
                """);
        PrintUtil.loot("You step over the remains, gathering strength for the battle ahead.");
        PrintUtil.line();
        InputUtil.pressEnterToContinue();
        player.getEffects().resetAllEffects();

        // -------------------- Ghoul Footmen --------------------
        System.out.println();
        PrintUtil.line();
        PrintUtil.effect("You stand before the towering iron gates. The metal is cold to the touch.");
        PrintUtil.pause(1000);

        System.out.println();
        PrintUtil.title("THE BLACK CASTLE");
        System.out.println();
        PrintUtil.pause(1000);

        PrintUtil.event("Thunder cracks overhead as you push open the heavy gates.");
        PrintUtil.pause(1000);

        PrintUtil.story("""
                Inside, the halls are silent except for the scrape of metal on stone.
                Figures lurch from the darkness—once honorable knights, now twisted by the plague.
                
                Two GHOUL FOOTMEN emerge.
                Their armor is cracked, their eyes bleed darkness, and they drag rusted blades behind them.
                """);

        PrintUtil.pause(1500);
        System.out.println();
        PrintUtil.enemyEncounter("                  .+.                                     ");
        PrintUtil.enemyEncounter("                   .*-+#-                                 ");
        PrintUtil.enemyEncounter("                .#%%@%*=                                  ");
        PrintUtil.enemyEncounter("    ..           :%@@+-#-                                 ");
        PrintUtil.enemyEncounter("    :=.           .#@%-.**.          -*-                  ");
        PrintUtil.enemyEncounter("  .=.=-              :-  -*:     .:.-@@#+: ::             ");
        PrintUtil.enemyEncounter("  :%@@@@* *%* .=#@@@@@@%%%+:            ");
        PrintUtil.enemyEncounter("   +@%*#-                  +@@:.*@@@@@@@@@%*+#=-.         ");
        PrintUtil.enemyEncounter("   .+#:*=        =%* .:   :@@*%@@@@@@%#@@@@@@#.          ");
        PrintUtil.enemyEncounter("     -=:#      .-%@@%**+-  .#@@@@@@@@@@%%@@@@@@-          ");
        PrintUtil.enemyEncounter("      . ==     .*@@@@@%###: :*@%#+#@@@@@@@@@@@@* ");
        PrintUtil.enemyEncounter("       ..*.    :#@@@@@@@@@*.  -=. .*@@@@@@@%#@@%:         ");
        PrintUtil.enemyEncounter("         .* .#@@@@@@@@%@#.  .  .#@@@%@%%@@@@@%:        ");
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
            System.out.println(ColorUtil.boldBrightRed("═════════════════════════════════════════════════════════"));
            PrintUtil.enemyEncounter("🪓 Ghoul Footman " + i + " raises a rusty axe and staggers forward!");
            System.out.println(ColorUtil.boldBrightRed("═════════════════════════════════════════════════════════"));
            InputUtil.pressEnterToContinue();

            battle4.startBattle();

            System.out.println();
            System.out.println(ColorUtil.boldBrightGreen("───────────────────────────────────────"));
            PrintUtil.enemyDefeated("✅ You have laid Ghoul Footman " + i + " to rest! (" + i + "/2)");
            System.out.println(ColorUtil.boldBrightGreen("───────────────────────────────────────"));
            enemy4.dropLoot(player);

            if (i < 2) {
                PrintUtil.pause(1000);
                System.out.println();
                PrintUtil.effect("The second guard drags his blade across the stone floor, approaching slowly.");
                System.out.println();
                enemy4 = new World2Enemy4();
                battle4 = new Battle(player, enemy4);
            }
        }

        PrintUtil.objective(("🎯 Objective: Defeat 2 Ghoul Footmen! ✅ (2 / 2)"));
        System.out.println();
        PrintUtil.line();
        PrintUtil.victory("""
                🎉 Victory! The armor clatters to the floor, empty.
                The knights are at peace, but the master of the castle still waits.
                """);
        PrintUtil.loot("You scavenge what you can from the fallen guards.");
        PrintUtil.line();
        InputUtil.pressEnterToContinue();
        player.getEffects().resetAllEffects();

        // -------------------- Mini-Boss: The Black Jailer --------------------
        System.out.println();
        PrintUtil.line();
        PrintUtil.effect("You descend into the castle's damp underbelly. The air grows cold.");
        PrintUtil.effect("The sound of dripping water is drowned out by the heavy dragging of iron.");
        PrintUtil.pause(1500);

        // --- TITLE SEQUENCE ---
        System.out.println();
        PrintUtil.event("                                                                                                            \n" +
                "                                                                                                            \n" +
                "██▄  ▄██ ▄▄ ▄▄  ▄▄ ▄▄ ▄▄▄▄   ▄▄▄   ▄▄▄▄  ▄▄▄▄   ██████ ▄▄  ▄▄  ▄▄▄▄  ▄▄▄  ▄▄ ▄▄ ▄▄  ▄▄ ▄▄▄▄▄▄ ▄▄▄▄▄ ▄▄▄▄    \n" +
                "██ ▀▀ ██ ██ ███▄██ ██ ██▄██ ██▀██ ███▄▄ ███▄▄   ██▄▄   ███▄██ ██▀▀▀ ██▀██ ██ ██ ███▄██   ██   ██▄▄  ██▄█▄ ▀ \n" +
                "██    ██ ██ ██ ▀██ ██ ██▄█▀ ▀███▀ ▄▄██▀ ▄▄██▀   ██▄▄▄▄ ██ ▀██ ▀████ ▀███▀ ▀███▀ ██ ▀██   ██   ██▄▄▄ ██ ██ ▄ \n" +
                "                                                                                                            ");
        PrintUtil.pause(500);

        PrintUtil.event("                                                                                       \n" +
                "                                                                                       \n" +
                "          ██████ ▄▄ ▄▄ ▄▄▄▄▄   █████▄ ▄▄     ▄▄▄   ▄▄▄▄ ▄▄ ▄▄      ██  ▄▄▄  ▄▄ ▄▄    ▄▄▄▄▄ ▄▄▄▄  \n" +
                "            ██   ██▄██ ██▄▄    ██▄▄██ ██    ██▀██ ██▀▀▀ ██▄█▀      ██ ██▀██ ██ ██    ██▄▄  ██▄█▄ \n" +
                "            ██   ██ ██ ██▄▄▄   ██▄▄█▀ ██▄▄▄ ██▀██ ▀████ ██ ██   ████▀ ██▀██ ██ ██▄▄▄ ██▄▄▄ ██ ██ \n" +
                "                                                                                       ");

        System.out.println();
        PrintUtil.pause(1000);

        PrintUtil.objective("═════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println();
        PrintUtil.effect("""
               "Clank... Drag... Clank..."
               
               In the flickering torchlight, a massive figure blocks the path.
               The Black Jailer steps from the shadows, his face hidden behind an iron mask.
               He drags meat hooks and rusted blades behind him, stained with the blood of the innocent.
                """);
        PrintUtil.objective("═════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
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
        PrintUtil.enemyEncounter("                   #%#%#%%%@@%%%%#%%* .+-               ");
        PrintUtil.enemyEncounter("                  =@%%@@@@@%@@%@@@%%%+:.=#=.              ");
        PrintUtil.enemyEncounter("                 *#@%%%@@@%@@@@%@@@@%@@%#%#:              ");
        PrintUtil.enemyEncounter("                :#%%%%@%##%%%%%##@@@%#*==#.               ");
        PrintUtil.enemyEncounter("                =%@@@@@%%%*#%#*#%%@@@@- .#.               ");
        PrintUtil.enemyEncounter("        *-+:   .*%#=@%%@#%%%@@#%*@@@@@@#-#                ");
        PrintUtil.enemyEncounter("     .+%@%@%* :*%#%@%@%#%#%@@#%#%@@@@@@@%:               ");
        PrintUtil.enemyEncounter("     .+@@%@@#**+---@@@@%##%#@@@%#%@@@@@@@@@%*:           ");
        PrintUtil.enemyEncounter("       *@@%@@=    :@@%@%%%%%@@@%%@@@@@@@@@@@@@@#-        ");
        PrintUtil.enemyEncounter("       =%@@@@%=   =@@%%%@@@%@@@@@%#@@@@@@%#%%%#@@@+.      ");
        PrintUtil.enemyEncounter("       +@%%#@%+   -@@%@@@%%@@@%%@@%@@@@@@@#-...- .*%-     ");
        PrintUtil.enemyEncounter("       .=###+:    :@#%@@@%@@@%@%@@@@@@@@@@@@*.     .-:    ");
        PrintUtil.enemyEncounter("                   +@%%%#@@@@@@%%%%%@@@@@@@@@@* ");
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
                ✅🏆 MINI-BOSS DEFEATED!
                
                The Black Jailer drops to his knees, his iron mask falling away to reveal nothing but ash.
                The chains that bound the dungeon fall silent. You have broken his tyranny.
                """);
        PrintUtil.loot("You find a key on the Jailer's belt and a surge of new power.");
        PrintUtil.line();
        miniBoss.dropLoot(player);
        InputUtil.pressEnterToContinue();
        PrintUtil.line();
        player.getEffects().resetAllEffects();

        // -------------------- Boss: The Corrupted King --------------------
        System.out.println();
        PrintUtil.line();
        PrintUtil.effect("You ascend the spiral staircase. The air grows thin and smells of ancient dust.");
        PrintUtil.effect("At the top, the massive doors to the Throne Room stand slightly ajar.");
        PrintUtil.pause(1500);

        // --- BOSS TITLE CARD ---
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
        PrintUtil.pause(2000);

        PrintUtil.objective("════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println();
        PrintUtil.story("""
                In the center of the room, on a throne of jagged iron, sits the King.
                He is slumped forward, his body fused to the chair by the corruption.
                
                Embedded in his rusted crown, pulsating with a sickly green light, is the SECOND STONE.
                """);

        PrintUtil.pause(1000);

        PrintUtil.effect("The King slowly lifts his head. His eyes are hollow voids.");
        System.out.println(ColorUtil.boldBrightRed("""
                
                "YOU DARE CHALLENGE MY AUTHORITY?!"
                
                "YOUR SKULL WILL BECOME BUT ANOTHER TROPHY IN MY HALLS!"
                """));

        System.out.println();
        PrintUtil.objective("════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println();

        PrintUtil.pause(1500);
        System.out.println();
        PrintUtil.enemyEncounter("@@@@@@@@@#+-:                               .-*#@@@@@@@@@@");
        PrintUtil.enemyEncounter("@@@@@@##@+                                      +%#%@@@@@@");
        PrintUtil.enemyEncounter("@@@@@##%%%.                  :                  %%###@@@@@");
        PrintUtil.enemyEncounter("@@@%+#%##%* :.=-.               #@####+%@@@");
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
        PrintUtil.enemyEncounter("@%+-  :%@#-          #:-#@@@@@@@%%*#%* :#@@- .-+@@");
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
                ✅🏆 FINAL VICTORY - BOSS DEFEATED!
                
                The King screams as the corruption is torn from his body.
                He crumbles into dust, leaving only his rusted crown on the throne...
                And the stone pulsing within it.
                """);
        PrintUtil.line();
        PrintUtil.pause(2000);

        boss.dropLoot(player);
        InputUtil.pressEnterToContinue();
        player.getEffects().resetAllEffects();

        //-------------------------------------------------
        System.out.println();
        PrintUtil.effect("The King's breath rattles. A faint glimmer of humanity returns to his hollow eyes.");
        PrintUtil.pause(1500);

        System.out.println();
        PrintUtil.sayRed("Corrupted King", "\"It's… It's you!!! NO!!!…\"");

        PrintUtil.pause(1000);
        System.out.println();
        PrintUtil.effect("He screams with his dying breath as his body crumbles into dust.");
        PrintUtil.effect("He leaves behind only a pile of ash... and confusion about who he was referring to.");
        InputUtil.pressEnterToContinue();

        // --- THE SECOND STONE ---
        System.out.println(ColorUtil.brightCyan("                                     \n" +
                "                                                             \n" +
                "                                                             \n" +
                "                                  *%%##********+=+=          \n" +
                "                                +%%@@@@@##**+=====**-        \n" +
                "                              -%%%%@@@@@@@%*+====-+**+.      \n" +
                "                            :%%%%%@@@@@@@@@@@@%*=-=****+.    \n" +
                "                          .%%%%%%%@@@@@@@@@@@%#######****+   \n" +
                "                          *%###%%@@%###%@@@@@%#####%%%%%%%+  \n" +
                "                          *@%%%%@@@%##%@@@@@@%####%@%%%%%@+  \n" +
                "                          *@@@@@@@@%##%@@@@@@%##%@@@@%%%@@+  \n" +
                "                          *@@@@#%@@@@%@@@@@@@%%@@@@@@@%@@@+  \n" +
                "                          *@@@%%##@@@@@@@@@@@@@@@@@@@@@@@@+  \n" +
                "                          *@@%%%##%@%%##%@@@@@@@@@@@@@@@@@+  \n" +
                "                          *@%%%%%#######%@@@@@@@@@@@@@@@@@+  \n" +
                "                          *%%%%%%%#####%%@@@@@@@@@@@@@@@@@* \n" +
                "                           =%@@@@@#%@@@@@@@@@@@@@@%%@@@@%:   \n" +
                "                             +@@@@%###%%@@%%@@@@@@%@@@%=     \n" +
                "                               *@@%#######%%@@@@@@#%@=       \n" +
                "                                .#@####%%%%%%%@@@%#* \n" +
                "                                  :+*************+           \n" +
                "                                                             \n" +
                "                                                             "));

        PrintUtil.loot("You lift the SECOND STONE from the ash, feeling its dark energy pulse in your hands.");
        PrintUtil.pause(1000);

        System.out.println();
        PrintUtil.effect("A cold wind sweeps through the empty halls, extinguishing every torch.");
        PrintUtil.effect("The room is plunged into silence... whispering secrets of the past.");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        // ---------------------- MAGIC SHOP ------------------------
        System.out.println();
        PrintUtil.story("""
                As you take a step forward, a strange pull brushes against your soul.
                The world itself feels like it is shifting around you.
                """);
        PrintUtil.pause(1500);

        PrintUtil.effect("✨ Something… or someone… is calling to you.");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        System.out.println(ColorUtil.boldBrightMagenta("🔮 A BRILLIANT FLASH LIGHTS UP THE ROOM!"));
        PrintUtil.pause(800);

        PrintUtil.story("""
                From the shattered shadows, a glowing arcane doorway forms before you.
                
                A calm, ancient voice echoes:
                "Hero of this land… you are granted *one chance* to reshape your fate."
                """);

        System.out.println("════════════════════════════════════════════════════════════════════════════");
        PrintUtil.title("🏺 THE MYSTIC MERCHANT APPEARS");
        System.out.println("════════════════════════════════════════════════════════════════════════════");
        System.out.println();
        PrintUtil.sayGreen("""
                "I appear only to those who have conquered great darkness," the merchant says.
                "Stock up now. Once you leave, I will vanish forever."
                """);

        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        // --- SHOP LOGIC ---
        MagicShop shop = new MagicShop(player);
        shop.openShop();

        // --- POST SHOP ---
        PrintUtil.line();
        PrintUtil.effect("🌟 The glow of the Magic Shop fades, leaving only silence behind.");
        PrintUtil.story("""
                The doorway vanishes as suddenly as it appeared,
                leaving you alone in the quiet halls of the castle.
                
                Whatever choices you made within… will echo in the battles to come.
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
