package worlds;

import enemies.*;
import battle.Battle;
import characters.Character;
import story.ScenePrinter;
import utils.InputUtil;

import java.lang.reflect.Method;

public class World3 {

    public void run(Character player) {
        ScenePrinter.title("World 3 — The Necromancer’s Tower in the Wasteland");

        ScenePrinter.type(
                "The land turns barren. Ash falls like snow. Rivers of molten fire carve through the black rock.\n" +
                        "At the center, rising higher than mountains, stands the Necromancer’s Tower.\n"
        );
        InputUtil.pressEnterToContinue();
        ScenePrinter.line();

        // -------------------- Flame Revenants --------------------
        ScenePrinter.line();
        ScenePrinter.type("""
                🔥 From the molten cracks below, Flame Revenants rise,
                their forms flickering with ember and hatred.
                """);

        ScenePrinter.type("🎯 Objective: Defeat 3 Flame Revenants!\n");
        InputUtil.pressEnterToContinue();
        ScenePrinter.line();

        Enemy enemy1 = new World3Enemy1();
        Battle battle1 = new Battle(player, enemy1);

        for (int i = 1; i <= 3; i++) {
            ScenePrinter.hr();
            System.out.println("🔥 Flame Revenant " + i + " emerges from the lava!");
            ScenePrinter.hr();

            battle1.startBattle();

            System.out.println("✅ You have defeated Flame Revenant " + i + "!");
            ScenePrinter.line();
            enemy1.dropLoot(player);

            if (i < 3) {
                enemy1 = new World3Enemy1();
                battle1 = new Battle(player, enemy1);
            }

        }

        ScenePrinter.line();
        ScenePrinter.type("""
                    🎉 Victory! The last revenant collapses into molten shards.
                    The lava around you cools slightly — a brief moment of calm.
                    """);
        ScenePrinter.loot("You gain experience and loot from the battle.\n");
        InputUtil.pressEnterToContinue();
        ScenePrinter.line();

        ScenePrinter.event("You steel yourself and begin the ascent.");
        ScenePrinter.effect("The air thickens with magic. Each step hums with a pulse from the Stones you carry.\n");
        InputUtil.pressEnterToContinue();

        ScenePrinter.event("From the darkness crawl soldiers of bone and beasts stitched from shadow.");
        InputUtil.pressEnterToContinue();

        // -------------------- Bone Warlocks --------------------
        ScenePrinter.effect("The ground trembles as sinister energy gathers.");
        ScenePrinter.type("""
                From the shadows, Bone Warlocks appear, chanting forbidden incantations.
                """);

        ScenePrinter.type("🎯 Objective: Defeat 2 Bone Warlocks!\n");
        InputUtil.pressEnterToContinue();
        ScenePrinter.line();

        Enemy enemy2 = new World3Enemy2();
        Battle battle2 = new Battle(player, enemy2);

        for (int i = 1; i <= 2; i++) {
            ScenePrinter.hr();
            System.out.println("💀 Bone Warlock " + i + " raises its staff, channeling dark fire!");
            ScenePrinter.hr();

            battle2.startBattle();

            System.out.println("✅ You have defeated Bone Warlock " + i + "!");
            ScenePrinter.line();
            enemy2.dropLoot(player);

            if (i < 2) {
                enemy2 = new World3Enemy2();
                battle2 = new Battle(player, enemy2);
            }
        }

        ScenePrinter.line();
        ScenePrinter.type("""
                    🎉 Victory! The Bone Warlocks crumble, their souls screaming into the void.
                    The heat intensifies — something greater stirs within the peaks.
                    """);
        ScenePrinter.loot("You gain experience and loot from your fiery victory.\n");
        InputUtil.pressEnterToContinue();
        ScenePrinter.line();


        // -------------------- Obsidian Crushers --------------------
        ScenePrinter.event("A deep rumble echoes through the caverns.");
        ScenePrinter.effect("Lava bursts upward, and massive shadows rise behind the flames.");

        ScenePrinter.type("""
                Obsidian Crushers emerge — molten giants forged from stone and fury.
                """);

        ScenePrinter.type("🎯 Objective: Defeat 2 Obsidian Crushers!\n");
        InputUtil.pressEnterToContinue();
        ScenePrinter.line();

        Enemy enemy3 = new World3Enemy3();
        Battle battle3 = new Battle(player, enemy3);

        for (int i = 1; i <= 2; i++) {
            ScenePrinter.hr();
            System.out.println("🪨 Obsidian Crusher " + i + " roars and slams the ground!");
            ScenePrinter.hr();

            battle3.startBattle();

            System.out.println("✅ You have defeated Obsidian Crusher " + i + "!");
            ScenePrinter.line();
            enemy3.dropLoot(player);

            if (i < 2) {
                enemy3 = new World3Enemy3();
                battle3 = new Battle(player, enemy3);
            }
        }

        ScenePrinter.line();
        ScenePrinter.type("""
                    🎉 Victory! The Crushers shatter, falling into the lava below.
                    The tremors subside — the way forward opens.
                    """);
        ScenePrinter.loot("You gain experience and loot from your battle.\n");
        InputUtil.pressEnterToContinue();
        ScenePrinter.line();

        ScenePrinter.event("Halfway up, you find a mural etched into obsidian.");
        ScenePrinter.type(
                "It shows a hooded figure holding three glowing stones, beneath a phrase in your own language:\n" +
                        "  'To teach is to control.'\n"
        );
        InputUtil.pressEnterToContinue();
        ScenePrinter.line();

        // -------------------- Soulflayer Gargoyles --------------------
        InputUtil.pressEnterToContinue();
        ScenePrinter.effect("A chilling wind cuts through the heat.");
        ScenePrinter.type("""
                From the shadows of molten stone, Soulflayer Gargoyles take flight.
                Their shrieks pierce the air, echoing through the infernal spires.
                """);

        ScenePrinter.type("🎯 Objective: Defeat 3 Soulflayer Gargoyles!\n");
        InputUtil.pressEnterToContinue();
        ScenePrinter.line();

        Enemy enemy4 = new World3Enemy4();
        Battle battle4 = new Battle(player, enemy4);

        for (int i = 1; i <= 3; i++) {
            ScenePrinter.hr();
            System.out.println("😈 Soulflayer Gargoyle " + i + " swoops down from above!");
            ScenePrinter.hr();

            battle4.startBattle();

            System.out.println("✅ You have defeated Soulflayer Gargoyle " + i + "!");
            ScenePrinter.line();
            enemy4.dropLoot(player);

            if (i < 3) {
                enemy4 = new World3Enemy4();
                battle4 = new Battle(player, enemy4);
            }
        }

        ScenePrinter.line();
        ScenePrinter.type("""
                    🎉 Victory! The last Gargoyle falls, shattering to dust midair.
                    Silence returns — save for the slow, rising heartbeat of the volcano.
                    """);
        ScenePrinter.loot("You gain experience and loot from your hard-fought battle.\n");
        InputUtil.pressEnterToContinue();
        ScenePrinter.line();


        // -------------------- MINIBOSS: ZYRRYL, THE TOWER WARDEN --------------------
        ScenePrinter.title("MINI-BOSS — Zyrryl, The Tower Warden");
        ScenePrinter.type("""
                As you reach the summit, molten light reveals a towering figure.
                Zyrryl, Warden of the Shattered Tower, stands armed with cursed steel.
                """);
        ScenePrinter.type("🎯 Objective: Defeat Zyrryl, The Tower Warden!\n");
        InputUtil.pressEnterToContinue();
        ScenePrinter.line();

        Enemy miniboss = new World3Miniboss1();
        Battle minibattle = new Battle(player, miniboss);
        minibattle.startBattle();

        ScenePrinter.line();
        ScenePrinter.type("""
                    🏆 Mini-Boss Defeated!
                    Zyrryl falls to one knee, his molten armor cracking apart.
                    You have shattered the guardian of flame.
                    """);
        ScenePrinter.loot("You gain rare loot and powerful rewards!\n");
        InputUtil.pressEnterToContinue();
        ScenePrinter.line();

        // TODO : PRE-FINAL RANDOM ENCOUNTER (ka luther ni)
        // --- Boss: the revelation ---
        ScenePrinter.title("BOSS — Sir Khai, the Necromancer");
        ScenePrinter.event("At the summit, the Third Stone pulses with violet light.");
        ScenePrinter.effect("You reach out. The Stones unite—humming like a single heartbeat.");
        ScenePrinter.event("Then Khai steps forward, staff blazing.\n");
        ScenePrinter.say("Sir Khai", "\"You’ve served well, student. Who better to collect the relics than one who trusts their teacher?\"");
        ScenePrinter.say("Sir Khai", "\"I guided you not to save this land—but to claim its power. The Necromancer you sought... is me.\"\n");



        ScenePrinter.hr();
    }

}
