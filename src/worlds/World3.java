package worlds;

import enemies.*;
import battle.Battle;
import characters.Character;
import events.PrefiEncounter;
import utils.ColorUtil;
import utils.InputUtil;
import utils.PrintUtil;
import utils.SoundUtil;


public class World3 {

    public void run(Character player) {
        SoundUtil.playLoop("worldbgm/world3_bgm.wav", 0.2f);
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
        InputUtil.pressEnterToContinue();
        System.out.println();

        // --- STORY INTRO ---
        System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println();
        PrintUtil.story("""
                You have been travelling for days, leaving the green world far behind.
                You have reached a land where not even a glimmer of life can survive.
                
                The earth here has turned to black glass. Ash falls like snow, coating your armor in gray dust.
                Rivers of molten fire carve through the rock, lighting the underbelly of the dark clouds.
                """);

        PrintUtil.pause(2000);

        PrintUtil.story("""
                At the center of this desolation, rising higher than the mountains...
                Stands a spire of twisted obsidian, piercing the storm itself.
                """);

        PrintUtil.pause(1000);
        PrintUtil.effect("THE NECROMANCER'S TOWER.");

        PrintUtil.sayGreen("""
                "We are here," Khai whispers, his voice barely audible over the roaring wind.
                "The source of the rot. The end of the path."
                """);

        System.out.println();
        System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        // -------------------- Flame Revenants --------------------
        System.out.println();
        PrintUtil.line();
        PrintUtil.effect("The ground beneath you becomes uncomfortably hot. The cracks in the rock begin to glow.");
        PrintUtil.pause(1000);

        PrintUtil.story("""
                🔥 Molten magma bubbles to the surface!
                From the fire, shape-less forms pull themselves together.
                
                FLAME REVENANTS rise, their bodies flickering with ember and hatred.
                They scream without mouths, a sound like burning timber.
                """);
        PrintUtil.pause(1500);

        PrintUtil.enemyEncounter("                                                          ");
        PrintUtil.enemyEncounter("                             :                            ");
        PrintUtil.enemyEncounter("                            :+* ");
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
        PrintUtil.line();
        InputUtil.pressEnterToContinue();

        Enemy enemy1 = new World3Enemy1();
        Battle battle1 = new Battle(player, enemy1);

        System.out.println();
        enemy1.displaySkills();
        InputUtil.pressEnterToContinue();
        System.out.println();

        for (int i = 1; i <= 3; i++) {
            System.out.println(ColorUtil.boldBrightRed("════════════════════════════════════════════════════"));
            PrintUtil.enemyEncounter("🔥 Flame Revenant " + i + " erupts from the lava pool!");
            System.out.println(ColorUtil.boldBrightRed("════════════════════════════════════════════════════"));
            InputUtil.pressEnterToContinue();

            battle1.startBattle();

            System.out.println();
            System.out.println(ColorUtil.boldBrightGreen("───────────────────────────────────────"));
            PrintUtil.enemyDefeated("✅ You extinguished Flame Revenant " + i + "! (" + i + "/3)");
            System.out.println(ColorUtil.boldBrightGreen("───────────────────────────────────────"));
            enemy1.dropLoot(player);

            if (i < 3) {
                PrintUtil.pause(800);
                System.out.println();
                PrintUtil.effect("The heat intensifies... another revenant forms from the ash!");
                System.out.println();
                enemy1 = new World3Enemy1();
                battle1 = new Battle(player, enemy1);
            }

        }

        PrintUtil.objective(("🎯 Objective: Defeat 3 Flame Revenants! ✅ (3 / 3)"));
        System.out.println();
        PrintUtil.line();
        PrintUtil.victory("""
            🎉 Victory! The last revenant collapses into cooling slag.
            The lava around you hardens slightly — a brief moment of calm in the inferno.
            """);
        PrintUtil.loot("Experience flows into you. You gather the spoils before the heat returns.");
        PrintUtil.line();
        SoundUtil.playLoop("worldbgm/world3_bgm.wav", 0.2f);
        InputUtil.pressEnterToContinue();
        player.getEffects().resetAllEffects();

        // --- TRANSITION TO ASCENT ---
        System.out.println();
        PrintUtil.event("You steel yourself and look up at the Tower.");
        PrintUtil.story("""
                You begin the ascent. The air thickens with suffocating magic.
                Each step you take hums with a pulse from the Stones you carry, as if they are calling out.
                """);
        System.out.println();

        PrintUtil.effect("From the darkness of the lower levels... soldiers of bone and beasts of shadow begin to crawl.");
        InputUtil.pressEnterToContinue();

        // -------------------- Bone Warlocks --------------------
        System.out.println();
        PrintUtil.line();
        PrintUtil.effect("The air grows cold, despite the rivers of lava flowing nearby.");
        PrintUtil.effect("A hollow chanting fills the chamber, vibrating in your bones.");
        PrintUtil.pause(1000);

        PrintUtil.story("""
                From the shadows of the obsidian pillars, figures draped in tattered robes emerge.
                BONE WARLOCKS.
                
                They raise staffs made of spine and skull, chanting forbidden incantations
                to twist the very life force from your body.
                """);

        PrintUtil.pause(1500);
        System.out.println("                                                          ");
        PrintUtil.enemyEncounter("   :..            .                                        ");
        PrintUtil.enemyEncounter("  .-+-.      .=: .:+                                       ");
        PrintUtil.enemyEncounter("  -*%*:      .*%%%%* ");
        PrintUtil.enemyEncounter("   .*#:    -: .+%%= ..-                                    ");
        PrintUtil.enemyEncounter("    -*-    --#%@@@@%*-:                                    ");
        PrintUtil.enemyEncounter("     +=   =*@@@@@@@@@@+:                                  ");
        PrintUtil.enemyEncounter("      =:  .#@@@@@@@@@@+.                                  ");
        PrintUtil.enemyEncounter("     .#@::=%@@@@@@@@@%-         .-=::..@@* :..        ");
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
        PrintUtil.enemyEncounter("       =-* -@* ::: :.@#:+@%+.@* ::  .. . -@*.:.+=        ");
        PrintUtil.enemyEncounter("      .:%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%@@@@@@=.       ");
        PrintUtil.enemyEncounter("   :+#%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%#*:    ");
        PrintUtil.enemyEncounter("          :+.:-:-#+ :=#@@@@@@@@@@@@#=. =+-::.              ");
        PrintUtil.enemyEncounter("                       .::-=+=:.                           ");
        System.out.println();

        PrintUtil.objective(("🎯 Objective: Defeat 3 Bone Warlocks!"));
        PrintUtil.line();
        InputUtil.pressEnterToContinue();

        Enemy enemy2 = new World3Enemy2();
        Battle battle2 = new Battle(player, enemy2);

        System.out.println();
        enemy2.displaySkills();
        InputUtil.pressEnterToContinue();
        System.out.println();

        for (int i = 1; i <= 3; i++) {
            System.out.println(ColorUtil.boldBrightRed("═════════════════════════════════════════════════════════════"));
            PrintUtil.enemyEncounter("💀 Bone Warlock " + i + " raises its staff, channeling dark magic!");
            System.out.println(ColorUtil.boldBrightRed("═════════════════════════════════════════════════════════════"));
            InputUtil.pressEnterToContinue();

            battle2.startBattle();

            System.out.println();
            System.out.println(ColorUtil.boldBrightGreen("────────────────────────────────────────"));
            PrintUtil.enemyDefeated("✅ You shattered the bones of Warlock " + i + "! (" + i + "/3)");
            System.out.println(ColorUtil.boldBrightGreen("────────────────────────────────────────"));
            enemy2.dropLoot(player);

            if (i < 3) {
                PrintUtil.pause(800);
                System.out.println();
                PrintUtil.effect("Another warlock steps over the remains of his kin, chanting louder!");
                System.out.println();
                enemy2 = new World3Enemy2();
                battle2 = new Battle(player, enemy2);
            }
        }

        PrintUtil.objective(("🎯 Objective: Defeat 3 Bone Warlocks! ✅ (3 / 3)"));
        System.out.println();
        PrintUtil.line();
        PrintUtil.victory("""
            🎉 Victory! The Bone Warlocks crumble into dust, their souls screaming into the void.
            The chanting ceases, but the silence that follows is even more unsettling.
            """);
        PrintUtil.loot("You find ancient runes and potions among the pile of bones.");
        PrintUtil.line();
        SoundUtil.playLoop("worldbgm/world3_bgm.wav", 0.2f);
        InputUtil.pressEnterToContinue();
        player.getEffects().resetAllEffects();

        // -------------------- Obsidian Crushers --------------------
        System.out.println();
        PrintUtil.line();
        PrintUtil.effect("A deep, rhythmic thumping echoes through the cavern. Boom... Boom...");
        PrintUtil.effect("Lava geysers burst upward, spraying molten rock against the walls.");
        PrintUtil.pause(1000);

        PrintUtil.story("""
                Massive shadows rise from behind the curtain of fire.
                OBSIDIAN CRUSHERS emerge — molten giants forged from living stone and fury.
                
                Their skin is black rock, their veins flow with lava, and they look at you as nothing more than dust to be swept away.
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
        PrintUtil.line();
        InputUtil.pressEnterToContinue();

        Enemy enemy3 = new World3Enemy3();
        Battle battle3 = new Battle(player, enemy3);

        System.out.println();
        enemy3.displaySkills();
        InputUtil.pressEnterToContinue();
        System.out.println();

        for (int i = 1; i <= 2; i++) {
            System.out.println(ColorUtil.boldBrightRed("══════════════════════════════════════════════════════════════════"));
            PrintUtil.enemyEncounter("🪨 Obsidian Crusher " + i + " roars and slams its fists into the ground!");
            System.out.println(ColorUtil.boldBrightRed("══════════════════════════════════════════════════════════════════"));
            InputUtil.pressEnterToContinue();

            battle3.startBattle();

            System.out.println();
            System.out.println(ColorUtil.boldBrightGreen("─────────────────────────────────────────"));
            PrintUtil.enemyDefeated("✅ You crumbled Obsidian Crusher " + i + " into rubble! (" + i + "/2)");
            System.out.println(ColorUtil.boldBrightGreen("─────────────────────────────────────────"));
            enemy3.dropLoot(player);

            if (i < 2) {
                PrintUtil.pause(1000);
                System.out.println();
                PrintUtil.effect("The ground shakes violently! The second giant charges through the debris.");
                System.out.println();
                enemy3 = new World3Enemy3();
                battle3 = new Battle(player, enemy3);
            }
        }

        PrintUtil.objective(("🎯 Objective: Defeat 2 Obsidian Crushers! ✅ (2 / 2)"));
        System.out.println();
        PrintUtil.line();
        PrintUtil.victory("""
            🎉 Victory! The colossal Crushers shatter, their pieces falling into the lava below with a hiss.
            The tremors subside — the way forward opens.
            """);
        PrintUtil.loot("You catch your breath. Your victory rewards you with experience and potions.");
        PrintUtil.line();
        InputUtil.pressEnterToContinue();
        player.getEffects().resetAllEffects();

        // --- THE MURAL DISCOVERY ---
        System.out.println();
        PrintUtil.effect("Halfway up the winding stairs, you find something etched into the obsidian wall.");
        PrintUtil.pause(1000);

        System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        PrintUtil.story("""
                It is a mural, ancient and jagged.
                It shows a hooded figure holding three glowing stones high above a kneeling crowd.
                
                Beneath it, carved in a language that looks chillingly familiar, is a single phrase:
                """);

        PrintUtil.sayRed("Unknown Carving", "\"TO TEACH IS TO CONTROL.\"");
        System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");

        System.out.println();
        PrintUtil.effect("A shiver runs down your spine that has nothing to do with the cold.");
        InputUtil.pressEnterToContinue();

        // -------------------- Soulflayer Gargoyles --------------------
        System.out.println();
        PrintUtil.line();
        PrintUtil.effect("You climb higher into the spire. The air grows thin and impossibly cold.");
        PrintUtil.effect("Perched on the obsidian ledges above, grim stone statues watch your ascent.");
        PrintUtil.pause(1000);

        PrintUtil.story("""
                Suddenly, stone cracks with a sharp snap!
                The statues shed their rocky skin and shriek as they dive into the void.
                
                SOULFLAYER GARGOYLES take flight.
                Their wings block out the red lightning, and their eyes burn with hunger for the living.
                """);

        PrintUtil.pause(1500);
        PrintUtil.enemyEncounter("          -%@@%#*:                      .+#%@@%-          ");
        PrintUtil.enemyEncounter("           .#@@@@@@#..-            ::.*@@@@@@%:           ");
        PrintUtil.enemyEncounter("           +@@@@@@@@@@#    .  .    *@@@@@@@@@@* ");
        PrintUtil.enemyEncounter("            -#@@@@@@@@%-  .+  =:  -%@@@@@@@@%-            ");
        PrintUtil.enemyEncounter("              =@@@@@@@@@+..*@@#. =@@@@@@@@@+               ");
        PrintUtil.enemyEncounter("              ::.-*@@@@@@@@@@@@@@@@@@@@#-.::               ");
        PrintUtil.enemyEncounter("   -+:.            -#==#%@@@@@@@@@#==*=                    ");
        PrintUtil.enemyEncounter("   .#@@#-       .      :#%%@@@@%%#-  ...                   ");
        PrintUtil.enemyEncounter("  -#@@@@@* -*:     -#= :#@@%- =#-  .#@@#+:              ");
        PrintUtil.enemyEncounter("   .+@@@@@#=:#@+.    :#=:-%@@@@@=.+#: :%@@@@@#-:  :-.     ");
        PrintUtil.enemyEncounter("    -%@@@@@+@@*=#*.   :-+#%=*@-%%- -.  -%@@@@@%.+@%-      ");
        PrintUtil.enemyEncounter("      .=@@@@@@@@@@#:  := ++:%- =* +%@@@@@@@%:+-     ");
        PrintUtil.enemyEncounter("       :#%%@@@@*.:..   =%%+-.  .*#=.      .*@@@@@@@@@*.   ");
        PrintUtil.enemyEncounter("     .+%+:@@@*#%#%%+                        :%@@@@%-=-    ");
        PrintUtil.enemyEncounter("     .: .%@@@+.                           .*@@@#@%@+.     ");
        PrintUtil.enemyEncounter("         *@@*@#:                     .#= :%@@@*.+@%**+**. ");
        PrintUtil.enemyEncounter("     -+-.*@#**.                    =:  =%@@%=#@=  .==     ");
        PrintUtil.enemyEncounter("    :-  :@  .:-=.                  -#%@* . =+.           ");
        PrintUtil.enemyEncounter("      ..-@#.                           ..                  ");
        System.out.println();

        PrintUtil.objective(("🎯 Objective: Defeat 3 Soulflayer Gargoyles!"));
        PrintUtil.line();
        InputUtil.pressEnterToContinue();

        Enemy enemy4 = new World3Enemy4();
        Battle battle4 = new Battle(player, enemy4);

        System.out.println();
        enemy4.displaySkills();
        InputUtil.pressEnterToContinue();
        System.out.println();

        for (int i = 1; i <= 3; i++) {
            System.out.println(ColorUtil.boldBrightRed("══════════════════════════════════════════════════════════════════"));
            PrintUtil.enemyEncounter("😈 Soulflayer Gargoyle " + i + " swoops down, talons screeching against stone!");
            System.out.println(ColorUtil.boldBrightRed("══════════════════════════════════════════════════════════════════"));
            InputUtil.pressEnterToContinue();

            battle4.startBattle();

            System.out.println();
            System.out.println(ColorUtil.boldBrightGreen("────────────────────────────────────────────"));
            PrintUtil.enemyDefeated("✅ You clipped the wings of Gargoyle " + i + "! (" + i + "/3)");
            System.out.println(ColorUtil.boldBrightGreen("────────────────────────────────────────────"));
            enemy4.dropLoot(player);

            if (i < 3) {
                PrintUtil.pause(800);
                System.out.println();
                PrintUtil.effect("Another shadow dives from the rafters!");
                System.out.println();
                enemy4 = new World3Enemy4();
                battle4 = new Battle(player, enemy4);
            }
        }

        PrintUtil.objective(("🎯 Objective: Defeat 3 Soulflayer Gargoyles! ✅ (3 / 3)"));
        System.out.println();
        PrintUtil.line();
        PrintUtil.victory("""
            🎉 Victory! The last Gargoyle falls, shattering to dust midair.
            The shrieking stops. The path to the inner sanctum is clear.
            """);
        PrintUtil.loot("You catch your breath and prepare for the dangers above.");
        PrintUtil.line();
        SoundUtil.playLoop("worldbgm/world3_bgm.wav", 0.2f);
        InputUtil.pressEnterToContinue();
        player.getEffects().resetAllEffects();

        // -------------------- MINIBOSS: ZYRRYL, THE TOWER WARDEN --------------------
        System.out.println();
        PrintUtil.line();
        PrintUtil.effect("You reach the penultimate landing. The heat here is unbearable.");
        PrintUtil.effect("The stone beneath your boots is soft, almost melting.");
        PrintUtil.pause(1000);

        // --- TITLE CARD ---
        System.out.println();
        PrintUtil.event("                                                                                                            \n" +
                "                                                                                                            \n" +
                "██▄  ▄██ ▄▄ ▄▄  ▄▄ ▄▄ ▄▄▄▄   ▄▄▄   ▄▄▄▄  ▄▄▄▄   ██████ ▄▄  ▄▄  ▄▄▄▄  ▄▄▄  ▄▄ ▄▄ ▄▄  ▄▄ ▄▄▄▄▄▄ ▄▄▄▄▄ ▄▄▄▄    \n" +
                "██ ▀▀ ██ ██ ███▄██ ██ ██▄██ ██▀██ ███▄▄ ███▄▄   ██▄▄   ███▄██ ██▀▀▀ ██▀██ ██ ██ ███▄██   ██   ██▄▄  ██▄█▄ ▀ \n" +
                "██    ██ ██ ██ ▀██ ██ ██▄█▀ ▀███▀ ▄▄██▀ ▄▄██▀   ██▄▄▄▄ ██ ▀██ ▀████ ▀███▀ ▀███▀ ██ ▀██   ██   ██▄▄▄ ██ ██ ▄ \n" +
                "                                                                                                            ");
        PrintUtil.pause(500);

        PrintUtil.event("                                                                                                                                           \n" +
                "                                                                                                                                           \n" +
                "██████ ▄▄ ▄▄ ▄▄▄▄  ▄▄▄▄  ▄▄ ▄▄ ▄▄          ██████ ▄▄ ▄▄ ▄▄▄▄▄   ██████ ▄▄▄  ▄▄   ▄▄ ▄▄▄▄▄ ▄▄▄▄    ██     ██  ▄▄▄  ▄▄▄▄  ▄▄▄▄  ▄▄▄▄▄ ▄▄  ▄▄ \n" +
                " ▄▄▀▀  ▀███▀ ██▄█▄ ██▄█▄ ▀███▀ ██            ██   ██▄██ ██▄▄      ██  ██▀██ ██ ▄ ██ ██▄▄  ██▄█▄   ██ ▄█▄ ██ ██▀██ ██▄█▄ ██▀██ ██▄▄  ███▄██ \n" +
                "██████   █   ██ ██ ██ ██   █   ██▄▄▄  ▄      ██   ██ ██ ██▄▄▄     ██  ▀███▀  ▀█▀█▀  ██▄▄▄ ██ ██    ▀██▀██▀  ██▀██ ██ ██ ████▀ ██▄▄▄ ██ ▀██ \n" +
                "                                     ▀                                                                                                     ");
        PrintUtil.pause(1000);

        System.out.println();
        PrintUtil.objective("═══════════════════════════════════════════════════════════════════════════");
        System.out.println();
        PrintUtil.story("""
                A towering figure steps from the magma falls blocking the path.
                ZYRRYL, Warden of the Shattered Tower.
                
                His armor is forged from cursed steel and hardened lava.
                He drags a massive greatsword that glows white-hot.
                """);
        PrintUtil.objective("═══════════════════════════════════════════════════════════════════════════");
        System.out.println();

        PrintUtil.pause(1500);
        PrintUtil.enemyEncounter("                                                       ..:");
        PrintUtil.enemyEncounter("                                                    =%#+-#");
        PrintUtil.enemyEncounter("                         -.     :               .+.:+@%%@@");
        PrintUtil.enemyEncounter("                    =.  =-.:   :-=         .=: :+#@@@%+=+-");
        PrintUtil.enemyEncounter("                    %: -%-+-:+-+=*. -     -%#**#-.:. ..   ");
        PrintUtil.enemyEncounter("    .              .@+::##=%@@@+#*..#.    =#=*##=+        ");
        PrintUtil.enemyEncounter("   :+.             .%@@@@@@@@@@@@#+#%.    :*@#*%* ");
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

        System.out.println();
        PrintUtil.objective(("🎯 Objective: Defeat Zyrryl, The Tower Warden!"));
        PrintUtil.line();
        InputUtil.pressEnterToContinue();

        Enemy miniboss = new World3Miniboss1();
        Battle minibattle = new Battle(player, miniboss);

        System.out.println();
        miniboss.displaySkills();
        InputUtil.pressEnterToContinue();
        System.out.println();

        minibattle.startBattle();

        System.out.println();
        PrintUtil.objective(("🎯 Objective: Defeat Zyrryl, The Tower Warden! ✅"));
        System.out.println();
        PrintUtil.line();
        PrintUtil.victory("""
            ✅🏆 MINI-BOSS DEFEATED!
            
            With a sound like a collapsing mountain, Zyrryl falls.
            His molten armor cracks apart, the light within fading to cold, dead stone.
            """);
        PrintUtil.loot("You claim powerful artifacts from the fallen titan.");
        PrintUtil.line();
        miniboss.dropLoot(player);
        InputUtil.pressEnterToContinue();
        System.out.println();
        SoundUtil.playLoop("worldbgm/world3_bgm.wav", 0.2f);
        PrintUtil.line();
        player.getEffects().resetAllEffects();

        // -------------------- PRE-FINAL ENCOUNTER --------------------
        System.out.println();
        PrintUtil.line();
        PrintUtil.effect("As you advance toward the inner sanctum, the air grows still.");
        PrintUtil.effect("A cloaked figure materializes before you, blocking the path.");
        PrintUtil.pause(1000);

        PrintUtil.story("""
                "Before you face the Final Boss… prove your mastery of the pillars of OOP.
                Power without knowledge is chaos.
                
                Each question must be answered within time… and without error.
                Answer correctly to earn a LEGENDARY ARTIFACT.
                One mistake — and your trial ends immediately."
                """);

        PrintUtil.pause(1500);

        // --- TITLE ART: PRE-FINAL ENCOUNTER ---
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

        // --- MYSTERIOUS QUESTION MARK ---
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

        // --- SUCCESS TRANSITION ---
        System.out.println();
        PrintUtil.effect("The air hums as your final answer locks into place.");
        PrintUtil.pause(1000);
        InputUtil.pressEnterToContinue();

        // --- THE REVELATION ---
        System.out.println();
        PrintUtil.line();
        PrintUtil.effect("The spectral figure vanishes. The path to the summit is open.");
        PrintUtil.pause(1500);

        System.out.println(ColorUtil.brightMagenta(
                "                 :*-                 \n" +
                        "                                  :%#+=                \n" +
                        "                                 :%@#+=-               \n" +
                        "                                .%@@#+==+.             \n" +
                        "                               :%%@@@%+==#.            \n" +
                        "                              -@%%@@@@@#==%:           \n" +
                        "                             =%%%@@@@@@@%=*@-          \n" +
                        "                            +%%@@@@@@%###%%%%+         \n" +
                        "                           *%#%%%%@@%%####%@#%+        \n" +
                        "                          *%#@@@#%@@@@@@%%%@#*#+       \n" +
                        "                        .*@@@@@@@@%%%@@@@@@@%**#+      \n" +
                        "                       :*@@@@@@%@%#####%@@@@@%***=     \n" +
                        "                      :#@@@%%%@@%%%%%%%%%@@@@@%***=    \n" +
                        "                     :#@%%%%%@@@@@@@%%%%%%%@@@@@@#*=   \n" +
                        "                     ++++***************************=  \n" +
                        "                                                       \n" +
                        "                                     "));

        PrintUtil.loot("At the summit, lying on a pedestal of bone, is the THIRD STONE.");
        PrintUtil.loot("It pulses with a violent violet light.");
        PrintUtil.pause(1000);

        PrintUtil.story("""
                You reach out.
                As your fingers brush the stone, the other two fly from your pack.
                
                The Three Stones unite—humming and pulling themselves closer together like a single heartbeat.
                The power is overwhelming. It is not healing... it is consuming.
                """);

        InputUtil.pressEnterToContinue();
        System.out.println();

        // --- KHAI'S BETRAYAL ---
        PrintUtil.effect("Slow clapping echoes from the shadows.");
        PrintUtil.pause(1000);

        PrintUtil.story("Khai the Gray steps forward. His staff is no longer wood—it is blazing with chaotic energy.");
        PrintUtil.pause(1500);

        PrintUtil.sayRed("Sir Khai", "\"Finally.\"");
        PrintUtil.pause(1000);

        PrintUtil.sayRed("Sir Khai", """
                "You’ve served well, my student.
                Who better to collect the Stones of Life than one who trusts their teacher blindly?"
                """);

        PrintUtil.pause(2000);

        PrintUtil.sayRed("Sir Khai", """
                "I have guided you not to save this land... but to claim its power.
                Only the most skilled and pure could bring the stones together.
                I have been waiting for a vessel like you for a millennium."
                """);

        PrintUtil.pause(2000);

        System.out.println();
        PrintUtil.effect("The air around him turns black. His weary eyes are gone, replaced by burning voids.");
        System.out.println();

        PrintUtil.sayRed("Sir Khai", """
                "I wish to bring chaos not only to this land, but to all lands beyond.
                
                The Necromancer you sought... The one who brings the end of worlds..."
                """);

        PrintUtil.pause(1500);

        System.out.println(ColorUtil.boldBrightRed("""
                
                      "IS ME!!!!!!!!!"
                
                """));

        PrintUtil.hr();
        InputUtil.pressEnterToContinue();
    }
}
