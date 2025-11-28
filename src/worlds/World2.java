package worlds;

import enemies.*;
import battle.Battle;
import characters.Character;
import utils.InputUtil;
import utils.PrintUtil;

public class World2 {

    public void run(Character player) {
        System.out.println();
        System.out.println("                                                   ╦ ╦╔═╗╦═╗╦  ╔╦╗ ");
        System.out.println("╔═════════════════════════════════════════════════ ║║║║ ║╠╦╝║   ║║   ══════════════════════════════════════════════════════════╗");
        System.out.println("                                                   ╚╩╝╚═╝╩╚═╩═╝═╩╝  ");





        System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
//        System.out.println("░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓██████▓▒░░▒▓███████▓▒░░▒▓█▓▒░      ░▒▓███████▓▒░       ░▒▓███████▓▒░  \n" +
//                "░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░             ░▒▓█▓▒░ \n" +
//                "░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░             ░▒▓█▓▒░ \n" +
//                "░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓███████▓▒░░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░       ░▒▓██████▓▒░  \n" +
//                "░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░        \n" +
//                "░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░        \n" +
//                " ░▒▓█████████████▓▒░ ░▒▓██████▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓████████▓▒░▒▓███████▓▒░       ░▒▓████████▓▒░ \n" +
//                "                                                                                              \n" +
//                "                                                                                              ");
//        PrintUtil.pause(1000);
//        System.out.println("████████ ██   ██ ███████     ████████  ██████  ██     ██ ███    ██      ██████  ███████     ██████  ███████  ██████  █████  ██    ██     \n" +
//                "   ██    ██   ██ ██             ██    ██    ██ ██     ██ ████   ██     ██    ██ ██          ██   ██ ██      ██      ██   ██  ██  ██      \n" +
//                "   ██    ███████ █████          ██    ██    ██ ██  █  ██ ██ ██  ██     ██    ██ █████       ██   ██ █████   ██      ███████   ████       \n" +
//                "   ██    ██   ██ ██             ██    ██    ██ ██ ███ ██ ██  ██ ██     ██    ██ ██          ██   ██ ██      ██      ██   ██    ██        \n" +
//                "   ██    ██   ██ ███████        ██     ██████   ███ ███  ██   ████      ██████  ██          ██████  ███████  ██████ ██   ██    ██        \n" +
//                "                                                                                                                                         \n" +
//                "                                                                                                                                         \n" +
//                " █████  ███    ██ ██████                                                                                                                 \n" +
//                "██   ██ ████   ██ ██   ██                                                                                                                \n" +
//                "███████ ██ ██  ██ ██   ██                                                                                                                \n" +
//                "██   ██ ██  ██ ██ ██   ██                                                                                                                \n" +
//                "██   ██ ██   ████ ██████                                                                                                                 \n" +
//                "                                                                                                                                         \n" +
//                "                                                                                                                                         \n" +
//                "████████ ██   ██ ███████     ██████  ██       █████   ██████ ██   ██      ██████  █████  ███████ ████████ ██      ███████                \n" +
//                "   ██    ██   ██ ██          ██   ██ ██      ██   ██ ██      ██  ██      ██      ██   ██ ██         ██    ██      ██                     \n" +
//                "   ██    ███████ █████       ██████  ██      ███████ ██      █████       ██      ███████ ███████    ██    ██      █████                  \n" +
//                "   ██    ██   ██ ██          ██   ██ ██      ██   ██ ██      ██  ██      ██      ██   ██      ██    ██    ██      ██                     \n" +
//                "   ██    ██   ██ ███████     ██████  ███████ ██   ██  ██████ ██   ██      ██████ ██   ██ ███████    ██    ███████ ███████                \n" +
//                "                                                                                                                                         \n" +
//                "                                                                                                                                         ");
        System.out.println("=======================================================================================================");
        System.out.println();
        PrintUtil.type(
                "Beyond the forest lies a town. Relief surges—until you step closer. The place is diseased.\n" +
                        "Children cough in alleys, merchants peddle spoiled goods, and hollow-eyed guards demand bribes.\n" +
                        "Every face tells the same story: something has poisoned this world.\n"
        );

        PrintUtil.say("Khai the Grey", "\"The Stones,\" he murmurs. \"They are both curse and cure.\"\n");
        System.out.println("========================================================================================================");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        // -------------------- Plague Vermins --------------------
        PrintUtil.line();
        PrintUtil.type("""
        🐀 The stench of rot fills the air.
        From the sewers, three Plague Vermins scuttle out—diseased, hissing, and hungry.
        Their claws drip with venomous filth.
        """);

        PrintUtil.type("🎯 Objective: Defeat 3 Plague Vermins!\n");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        Enemy enemy1 = new World2Enemy1();
        Battle battle1 = new Battle(player, enemy1);

        for(int i = 1; i <= 3; i++){
            PrintUtil.hr();
            System.out.println("🐀 Vermin " + i + " lunges at you!");
            PrintUtil.hr();

            battle1.startBattle();

            System.out.println("✅ You have defeated Vermin " + i + "!");
            PrintUtil.line();
            enemy1.dropLoot(player);

            if (i < 3) { // reset for next vermin
                enemy1 = new World2Enemy1();
                battle1 = new Battle(player, enemy1);
            }
        }

        PrintUtil.line();
        PrintUtil.type("""
            🎉 Victory! The last of the Plague Vermins collapses into the sludge.
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

        PrintUtil.type("🎯 Objective: Defeat 2 Forsaken Cultists!\n");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        Enemy enemy2 = new World2Enemy2();
        Battle battle2 = new Battle(player, enemy2);

        for (int i = 1; i <= 2; i++) {
            PrintUtil.hr();
            System.out.println("☠️ Forsaken Cultist " + i + " raises a cursed dagger!");
            PrintUtil.hr();

            battle2.startBattle();

            System.out.println("✅ You have defeated Cultist " + i + "!");
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
                From the black mist, two Blight Hounds leap forth,
                their fangs glinting and bodies wrapped in poisonous clouds.
                """);

        PrintUtil.type("🎯 Objective: Defeat 3 Blight Hounds!\n");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        Enemy enemy3 = new World2Enemy3();
        Battle battle3 = new Battle(player, enemy3);
        for (int i = 1; i <= 3; i++) {
            PrintUtil.hr();
            System.out.println("🐕 Blight Hound " + i + " snarls and lunges!");
            PrintUtil.hr();

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

        PrintUtil.type("🎯 Objective: Defeat 2 Ghoul Footmen!\n");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        Enemy enemy4 = new World2Enemy4();
        Battle battle4 = new Battle(player, enemy4);

        for(int i = 1; i <= 2; i++){
            PrintUtil.hr();
            System.out.println("🪓 Ghoul Footman " + i + " staggers toward you!");
            PrintUtil.hr();

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

        System.out.println("========================================================================");

        PrintUtil.type("""
                In the dungeons below, chains rattle.
                The Black Jailer steps from the shadows, dragging hooks and blades behind him.
                """);
        System.out.println("========================================================================");
        System.out.println();

        PrintUtil.type("🎯 Objective: Defeat The Black Jailer!\n");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        Enemy miniBoss = new World2Miniboss1();
        Battle miniBattle = new Battle(player, miniBoss);
        miniBattle.startBattle();

        PrintUtil.line();
        PrintUtil.type("""
                🏆 Mini-Boss Defeated!
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

        System.out.println("                                                                                                                    \n" +
                "                                                                                                                    \n" +
                "██████ ██  ██ ██████   ▄█████ ▄████▄ █████▄  █████▄  ██  ██ █████▄ ██████ ██████ ████▄    ██ ▄█▀ ██ ███  ██  ▄████  \n" +
                "  ██   ██████ ██▄▄     ██     ██  ██ ██▄▄██▄ ██▄▄██▄ ██  ██ ██▄▄█▀   ██   ██▄▄   ██  ██   ████   ██ ██ ▀▄██ ██  ▄▄▄ \n" +
                "  ██   ██  ██ ██▄▄▄▄   ▀█████ ▀████▀ ██   ██ ██   ██ ▀████▀ ██       ██   ██▄▄▄▄ ████▀    ██ ▀█▄ ██ ██   ██  ▀███▀  \n" +
                "                                                                                                                    ");

        System.out.println("===========================================================================");
        PrintUtil.type(
                "In the throne room, the King sits slumped—his crown fused to his skull.\n" +
                        "You battle him; each blow shakes the hall until, finally, he falls.\n"
        );
        System.out.println("===========================================================================");
        System.out.println();

        PrintUtil.type("🎯 Objective: Defeat The Corrupted King!\n");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        Enemy boss = new World2Miniboss2();
        Battle bossBattle = new Battle(player, boss);
        bossBattle.startBattle();

        PrintUtil.line();
        PrintUtil.type("""
                👑 Final Victory!
                The Crupted King’s crown falls to the floor, echoing through the halls.
                Darkness fades, and you stand as the savior of this cursed land.
                """);
        PrintUtil.loot("You gain immense experience and legendary loot!\n");
        boss.dropLoot(player);
        InputUtil.pressEnterToContinue();
        PrintUtil.line();
        player.getEffects().resetAllEffects();

        PrintUtil.effect("The King's breath rattles. His eyes regain a hint of clarity.");
        PrintUtil.say("Corrupted King", "\"The Necromancer… is not what he seems...\"");
        PrintUtil.event("His body turns to dust.");
        InputUtil.pressEnterToContinue();

        PrintUtil.event("You seize the Second Stone.");
        PrintUtil.effect("A dark wind howls through the castle, extinguishing every torch.");
        InputUtil.pressEnterToContinue();
    }
}