package worlds;

import enemies.*;
import battle.Battle;
import characters.Character;
import story.ScenePrinter;
import utils.InputUtil;

public class World1 {

    public void run(Character player) {
        ScenePrinter.title("WORLD 1 — The Forest of Silence");
        ScenePrinter.type("""
                You wake in a dead forest. Bark is gray, leaves crunch to ash, and a cold mist coils between skeletal trees.
                Silence presses from every side—watching, waiting.
                A voice: "Dong… / Dai…"
                From the mist steps a robed figure—your professor, Sir Khai. "Find the Three Stones," he says. "Only then will your path home reveal itself."
                """);
        InputUtil.pressEnterToContinue();

        // ENEMY 1 : 3 ROTFANG WOLVES ENCOUNTERED
        Enemy enemy1 = new World1Enemy1();
        Battle battle1 = new Battle(player, enemy1);

        ScenePrinter.line();
        ScenePrinter.type("""
                ⚔️ Suddenly, the ground trembles as three Rotfang Wolves emerge from the shadows!
                Their glowing red eyes fixate on you, teeth bared and claws digging into the earth.
                Prepare yourself for a ferocious battle!
                """);

        ScenePrinter.type("🎯 Objective: Defeat 3 Rotfang Wolves!\n");
        InputUtil.pressEnterToContinue();
        ScenePrinter.line();

        for (int i = 1; i <= 3; i++) {
            ScenePrinter.hr();
            System.out.println("🐺 Wolf " + i + " lunges at you!");
            ScenePrinter.hr();

            battle1.startBattle();

            if (!enemy1.isAlive()) {
                System.out.println("✅ You have defeated Wolf " + i + "!");
                ScenePrinter.line();
                enemy1.dropLoot(player);

                if (i < 3) { // reset for another wolf
                    enemy1 = new World1Enemy1();
                    battle1 = new Battle(player, enemy1);
                }
            }
        }

        if(player.isAlive()){
            ScenePrinter.line();
            ScenePrinter.type("""
                🎉 Victory! The last of the Rotfang Wolves collapses to the ground.
                The forest falls silent, and you catch your breath, victorious.
                """);
            ScenePrinter.loot("You gain experience and loot from your hard-fought battle.\n");
            InputUtil.pressEnterToContinue();
            ScenePrinter.line();
        }


        // ENEMY 2 : 2 SHADE SPRITES ENCOUNTERED
        Enemy enemy2 = new World1Enemy2();
        Battle battle2 = new Battle(player, enemy2);

        ScenePrinter.line();
        ScenePrinter.type("""
                🌫️ The mist thickens... shadows twist into vague shapes.
                From the darkness, two Shade Sprites materialize — faint outlines of faces flickering in and out of sight.
                Their whispers echo through your mind like broken static.
                """);
        ScenePrinter.type("🎯 Objective: Defeat 2 Shade Sprites!\n");
        InputUtil.pressEnterToContinue();
        ScenePrinter.line();

        for (int i = 1; i <= 2; i++) {
            ScenePrinter.hr();
            System.out.println("👻 Shade Sprite " + i + " phases through the air toward you!");
            ScenePrinter.hr();

            battle2.startBattle();

            if (!enemy2.isAlive()) {
                System.out.println("✅ You dispelled Shade Sprite " + i + "!");
                ScenePrinter.line();
                enemy2.dropLoot(player);

                if (i < 2) { // reset for another shade
                    enemy2 = new World1Enemy2();
                    battle2 = new Battle(player, enemy2);
                }
            }
        }

        if (player.isAlive()) {
            ScenePrinter.line();
            ScenePrinter.type("""
                    🌌 Silence returns. The mist recedes, revealing faint lights hovering like stars among the trees.
                    You feel your strength returning after overcoming the whispering darkness.
                    """);
            ScenePrinter.loot("You gain ethereal dust and experience from the fallen spirits.\n");
            InputUtil.pressEnterToContinue();
            ScenePrinter.line();
        }


        // ENEMY 3 : 2 DREADBARK TREANTS ENCOUNTERED
        Enemy enemy3 = new World1Enemy3();
        Battle battle3 = new Battle(player, enemy3);

        ScenePrinter.line();
        ScenePrinter.type("""
                🌲 The ground rumbles... massive roots burst from beneath your feet!
                From the fog rise two Dreadbark Treants — ancient trees corrupted by decay.
                Their hollow eyes glow with green fire as they creak and move toward you.
                """);
        ScenePrinter.type("🎯 Objective: Defeat 2 Dreadbark Treants!\n");
        InputUtil.pressEnterToContinue();
        ScenePrinter.line();

        for (int i = 1; i <= 2; i++) {
            ScenePrinter.hr();
            System.out.println("🌳 Dreadbark Treant " + i + " slams its massive arm down at you!");
            ScenePrinter.hr();

            battle3.startBattle();

            if (!enemy3.isAlive()) {
                System.out.println("✅ You felled Dreadbark Treant " + i + "!");
                ScenePrinter.line();
                enemy3.dropLoot(player);

                if (i < 2) {
                    enemy3 = new World1Enemy3();
                    battle3 = new Battle(player, enemy3);
                }
            }
        }

        if (player.isAlive()) {
            ScenePrinter.line();
            ScenePrinter.type("""
                    🍃 The Treants collapse, their bark crumbling into soil.
                    Life stirs in the forest again — small sprouts rise where their bodies fell.
                    """);
            ScenePrinter.loot("You gain wooden fragments and experience.\n");
            InputUtil.pressEnterToContinue();
            ScenePrinter.line();
        }


        // ENEMY 4 : 4 CARRION BATS ENCOUNTERED
        Enemy enemy4 = new World1Enemy4();
        Battle battle4 = new Battle(player, enemy4);

        ScenePrinter.line();
        ScenePrinter.type("""
                🦇 A shrill screech pierces the silence!
                Four Carrion Bats dive from the canopy, their wings slicing through the fog.
                The air reeks of rot as they circle you, ready to strike.
                """);
        ScenePrinter.type("🎯 Objective: Defeat 4 Carrion Bats!\n");
        InputUtil.pressEnterToContinue();
        ScenePrinter.line();

        for (int i = 1; i <= 4; i++) {
            ScenePrinter.hr();
            System.out.println("🦇 Carrion Bat " + i + " swoops down, fangs bared!");
            ScenePrinter.hr();

            battle4.startBattle();

            if (!enemy4.isAlive()) {
                System.out.println("✅ You slayed Carrion Bat " + i + "!");
                ScenePrinter.line();
                enemy4.dropLoot(player);

                if (i < 4) {
                    enemy4 = new World1Enemy4();
                    battle4 = new Battle(player, enemy4);
                }
            }
        }

        if (player.isAlive()) {
            ScenePrinter.line();
            ScenePrinter.type("""
                    💨 The last bat crashes into the ground.
                    The forest grows quiet once more, the stench of decay lifting into the cold wind.
                    """);
            ScenePrinter.loot("You gain torn wings and experience.\n");
            InputUtil.pressEnterToContinue();
            ScenePrinter.line();
        }


        ScenePrinter.event("An old tablet lies half-buried. Runes flicker like code. You feel energy stir.");
        player.restoreEnergy(30);
        System.out.println("Energy restored.\n");
        InputUtil.pressEnterToContinue();


        // ENEMY 5 : MINI-BOSS — THE HOLLOW STAG
        Enemy miniboss = new World1Miniboss1();
        Battle minibossBattle = new Battle(player, miniboss);

        ScenePrinter.line();
        ScenePrinter.type("""
                🌕 The mist thins, revealing a clearing drenched in moonlight.
                The trees twist around a great blackened oak — and from behind it steps a massive stag.
                Its antlers are cracked and glowing faintly, its eyes burning with white fire.
                You feel an ancient sadness… and danger.
                """);
        ScenePrinter.event("🦌 MINI-BOSS ENCOUNTER: The Hollow Stag");
        ScenePrinter.type("""
                Once a noble guardian of this forest, the Hollow Stag is now corrupted by the same darkness that drains the land.
                Its hooves scorch the ground, and the forest holds its breath.
                Prepare yourself — this will be no ordinary fight.
                """);
        InputUtil.pressEnterToContinue();
        ScenePrinter.line();

        miniboss.displaySkills();
        InputUtil.pressEnterToContinue();
        ScenePrinter.line();

        minibossBattle.startBattle();

        if (player.isAlive() && !miniboss.isAlive()) {
            ScenePrinter.line();
            ScenePrinter.type("""
                    🌟 The Hollow Stag staggers, its luminous eyes fading to black.
                    With one final, echoing cry, it collapses to the ground. The forest trembles… then exhales.
                    Leaves flutter as light begins to return to the trees.
                    """);
            ScenePrinter.loot("""
                    You obtain the First Stone — pulsing with quiet power.
                    The corruption fades, and the path ahead glows faintly in the mist.
                    """);
            miniboss.dropLoot(player);
            InputUtil.pressEnterToContinue();
            ScenePrinter.line();
        } else if (!player.isAlive()) {
            ScenePrinter.type("""
                    💀 You fall before the Hollow Stag...
                    Its roar echoes across the dying forest as the darkness closes in.
                    """);
        }

        ScenePrinter.event("You claim the First Stone from a tree black with rot. Light bursts outward; the forest exhales.");
        InputUtil.pressEnterToContinue();
    }

}
