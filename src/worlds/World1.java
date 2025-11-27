package worlds;

import enemies.*;
import battle.Battle;
import characters.Character;
import utils.InputUtil;
import utils.PrintUtil;

public class World1 {

    public void run(Character player) {
        System.out.println();
        System.out.println("░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓██████▓▒░░▒▓███████▓▒░░▒▓█▓▒░      ░▒▓███████▓▒░          ░▒▓█▓▒░ \n" +
                "░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░      ░▒▓████▓▒░ \n" +
                "░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░         ░▒▓█▓▒░ \n" +
                "░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓███████▓▒░░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░         ░▒▓█▓▒░ \n" +
                "░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░         ░▒▓█▓▒░ \n" +
                "░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░         ░▒▓█▓▒░ \n" +
                " ░▒▓█████████████▓▒░ ░▒▓██████▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓████████▓▒░▒▓███████▓▒░          ░▒▓█▓▒░ \n" +
                "                                                                                          \n" +
                "                                                                                          ");
        PrintUtil.pause(1000);
        System.out.println(" ▄▀▀▀█▀▀▄  ▄▀▀▄ ▄▄   ▄▀▀█▄▄▄▄      ▄▀▀▀█▄    ▄▀▀▀▀▄   ▄▀▀▄▀▀▀▄  ▄▀▀█▄▄▄▄  ▄▀▀▀▀▄  ▄▀▀▀█▀▀▄      ▄▀▀▀▀▄   ▄▀▀▀█▄        ▄▀▀▀▀▄  ▄▀▀█▀▄   ▄▀▀▀▀▄     ▄▀▀█▄▄▄▄  ▄▀▀▄ ▀▄  ▄▀▄▄▄▄   ▄▀▀█▄▄▄▄ \n" +
                "█    █  ▐ █  █   ▄▀ ▐  ▄▀   ▐     █  ▄▀  ▀▄ █      █ █   █   █ ▐  ▄▀   ▐ █ █   ▐ █    █  ▐     █      █ █  ▄▀  ▀▄     █ █   ▐ █   █  █ █    █     ▐  ▄▀   ▐ █  █ █ █ █ █    ▌ ▐  ▄▀   ▐ \n" +
                "▐   █     ▐  █▄▄▄█    █▄▄▄▄▄      ▐ █▄▄▄▄   █      █ ▐  █▀▀█▀    █▄▄▄▄▄     ▀▄   ▐   █         █      █ ▐ █▄▄▄▄          ▀▄   ▐   █  ▐ ▐    █       █▄▄▄▄▄  ▐  █  ▀█ ▐ █        █▄▄▄▄▄  \n" +
                "   █         █   █    █    ▌       █    ▐   ▀▄    ▄▀  ▄▀    █    █    ▌  ▀▄   █     █          ▀▄    ▄▀  █    ▐       ▀▄   █      █        █        █    ▌    █   █    █        █    ▌  \n" +
                " ▄▀         ▄▀  ▄▀   ▄▀▄▄▄▄        █          ▀▀▀▀   █     █    ▄▀▄▄▄▄    █▀▀▀    ▄▀             ▀▀▀▀    █             █▀▀▀    ▄▀▀▀▀▀▄   ▄▀▄▄▄▄▄▄▀ ▄▀▄▄▄▄   ▄▀   █    ▄▀▄▄▄▄▀  ▄▀▄▄▄▄   \n" +
                "█          █   █     █    ▐       █                  ▐     ▐    █    ▐    ▐      █                      █              ▐      █       █  █         █    ▐   █    ▐   █     ▐   █    ▐   \n" +
                "▐          ▐   ▐     ▐            ▐                             ▐                ▐                      ▐                     ▐       ▐  ▐         ▐        ▐        ▐         ▐        ");
        System.out.println("==================================================================================================================================================");
        System.out.println();
        PrintUtil.type("""
                You wake in a dead forest. Bark is gray, leaves crunch to ash, and a cold mist coils between skeletal trees.
                Silence presses from every side—watching, waiting.
                A voice: "Dong…"
                From the mist steps a robed figure—your professor, Khai the Grey. "Find the Three Stones," he says. "Only then will your path home reveal itself."
                """);
        System.out.println("==================================================================================================================================================");
        InputUtil.pressEnterToContinue();

        // -------------------- Rotfang Wolves --------------------

        PrintUtil.line();
        PrintUtil.type("""
                ⚔️ Suddenly, the ground trembles as three Rotfang Wolves emerge from the shadows!
                Their glowing red eyes fixate on you, teeth bared and claws digging into the earth.
                Prepare yourself for a ferocious battle!
                """);

        PrintUtil.type("🎯 Objective: Defeat 3 Rotfang Wolves!\n");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        Enemy enemy1 = new World1Enemy1();
        Battle battle1 = new Battle(player, enemy1);

        for (int i = 1; i <= 3; i++) {
            PrintUtil.hr();
            System.out.println("🐺 Rotfang Wolf " + i + " lunges at you!");
            PrintUtil.hr();

            battle1.startBattle();

            System.out.println("✅ You have defeated Wolf " + i + "!");
            PrintUtil.line();
            enemy1.dropLoot(player);

            if (i < 3) { // reset for another wolf
                enemy1 = new World1Enemy1();
                battle1 = new Battle(player, enemy1);
            }
        }

        PrintUtil.line();
        PrintUtil.type("""
                🎉 Victory! The last of the Rotfang Wolves collapses to the ground.
                The forest falls silent, and you catch your breath, victorious.
                """);
        PrintUtil.loot("You gain experience and loot from your hard-fought battle.\n");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();
        player.getEffects().resetAllEffects();

        // -------------------- Shade Sprites --------------------
        PrintUtil.line();
        PrintUtil.type("""
                🌫️ The mist thickens... shadows twist into vague shapes.
                From the darkness, two Shade Sprites materialize — faint outlines of faces flickering in and out of sight.
                Their whispers echo through your mind like broken static.
                """);
        PrintUtil.type("🎯 Objective: Defeat 2 Shade Sprites!\n");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        Enemy enemy2 = new World1Enemy2();
        Battle battle2 = new Battle(player, enemy2);

        for (int i = 1; i <= 2; i++) {
            PrintUtil.hr();
            System.out.println("👻 Shade Sprite " + i + " phases through the air toward you!");
            PrintUtil.hr();

            battle2.startBattle();

            System.out.println("✅ You dispelled Shade Sprite " + i + "!");
            PrintUtil.line();
            enemy2.dropLoot(player);

            if (i < 2) { // reset for another shade
                enemy2 = new World1Enemy2();
                battle2 = new Battle(player, enemy2);
            }
        }

        PrintUtil.line();
        PrintUtil.type("""
                🌌 Silence returns. The mist recedes, revealing faint lights hovering like stars among the trees.
                You feel your strength returning after overcoming the whispering darkness.
                """);
        PrintUtil.loot("You gain ethereal dust and experience from the fallen spirits.\n");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();
        player.getEffects().resetAllEffects();

        // -------------------- Dreadbark Treants --------------------
        PrintUtil.line();
        PrintUtil.type("""
                🌲 The ground rumbles... massive roots burst from beneath your feet!
                From the fog rise two Dreadbark Treants — ancient trees corrupted by decay.
                Their hollow eyes glow with green fire as they creak and move toward you.
                """);
        PrintUtil.type("🎯 Objective: Defeat 2 Dreadbark Treants!\n");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        Enemy enemy3 = new World1Enemy3();
        Battle battle3 = new Battle(player, enemy3);

        for (int i = 1; i <= 2; i++) {
            PrintUtil.hr();
            System.out.println("🌳 Dreadbark Treant " + i + " slams its massive arm down at you!");
            PrintUtil.hr();

            battle3.startBattle();

            System.out.println("✅ You felled Dreadbark Treant " + i + "!");
            PrintUtil.line();
            enemy3.dropLoot(player);

            if (i < 2) {
                enemy3 = new World1Enemy3();
                battle3 = new Battle(player, enemy3);
            }
        }

        PrintUtil.line();
        PrintUtil.type("""
                🍃 The Treants collapse, their bark crumbling into soil.
                Life stirs in the forest again — small sprouts rise where their bodies fell.
                """);
        PrintUtil.loot("You gain wooden fragments and experience.\n");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();
        player.getEffects().resetAllEffects();

        // -------------------- Carrion Bats --------------------
        PrintUtil.line();
        PrintUtil.type("""
                🦇 A shrill screech pierces the silence!
                Four Carrion Bats dive from the canopy, their wings slicing through the fog.
                The air reeks of rot as they circle you, ready to strike.
                """);
        PrintUtil.type("🎯 Objective: Defeat 4 Carrion Bats!\n");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        Enemy enemy4 = new World1Enemy4();
        Battle battle4 = new Battle(player, enemy4);

        for (int i = 1; i <= 4; i++) {
            PrintUtil.hr();
            System.out.println("🦇 Carrion Bat " + i + " swoops down, fangs bared!");
            PrintUtil.hr();

            battle4.startBattle();

            System.out.println("✅ You slayed Carrion Bat " + i + "!");
            PrintUtil.line();
            enemy4.dropLoot(player);

            if (i < 4) {
                enemy4 = new World1Enemy4();
                battle4 = new Battle(player, enemy4);
            }
        }

        PrintUtil.line();
        PrintUtil.type("""
                💨 The last bat crashes into the ground.
                The forest grows quiet once more, the stench of decay lifting into the cold wind.
                """);
        PrintUtil.loot("You gain torn wings and experience.\n");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();
        player.getEffects().resetAllEffects();

        // -------------------- MINI-BOSS — THE HOLLOW STAG --------------------
        PrintUtil.line();
        PrintUtil.type("""
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
        PrintUtil.pause(1500);

        System.out.println("                                                                                                   \n" +
                "                                                                                                   \n" +
                "██████ ██  ██ ██████   ██  ██ ▄████▄ ██     ██     ▄████▄ ██     ██   ▄█████ ██████ ▄████▄  ▄████  \n" +
                "  ██   ██████ ██▄▄     ██████ ██  ██ ██     ██     ██  ██ ██ ▄█▄ ██   ▀▀▀▄▄▄   ██   ██▄▄██ ██  ▄▄▄ \n" +
                "  ██   ██  ██ ██▄▄▄▄   ██  ██ ▀████▀ ██████ ██████ ▀████▀  ▀██▀██▀    █████▀   ██   ██  ██  ▀███▀  \n" +
                "                                                                                                   ");
        System.out.println();

        System.out.println("=================================================================================================================");
        PrintUtil.type("""
                Once a noble guardian of this forest, the Hollow Stag is now corrupted by the same darkness that drains the land.
                Its hooves scorch the ground, and the forest holds its breath.
                Prepare yourself — this will be no ordinary fight.
                """);
        System.out.println("=================================================================================================================");
        System.out.println();

        PrintUtil.type("🎯 Objective: Defeat The Hollow Stag!\n");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        Enemy miniboss = new World1Miniboss1();
        Battle minibossBattle = new Battle(player, miniboss);

        miniboss.displaySkills();
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        minibossBattle.startBattle();

        PrintUtil.line();
        PrintUtil.type("""
                🌟 The Hollow Stag staggers, its luminous eyes fading to black.
                With one final, echoing cry, it collapses to the ground. The forest trembles… then exhales.
                """);
        PrintUtil.loot("""
                You obtain the First Stone — pulsing with quiet power.
                The corruption fades, and the path ahead glows faintly in the mist.
                """);
        miniboss.dropLoot(player);
        InputUtil.pressEnterToContinue();
        PrintUtil.line();
        player.getEffects().resetAllEffects();

        PrintUtil.event("You claim the First Stone from a tree black with rot. Light bursts outward; the forest exhales.");
        InputUtil.pressEnterToContinue();
    }
}