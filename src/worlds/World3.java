package worlds;

import enemies.*;
import battle.Battle;
import characters.Character;
import utils.InputUtil;
import utils.PrintUtil;

public class World3 {

    public void run(Character player) {
        PrintUtil.title("World 3 — The Necromancer’s Tower in the Wasteland");

        PrintUtil.type(
                "The land turns barren. Ash falls like snow. Rivers of molten fire carve through the black rock.\n" +
                        "At the center, rising higher than mountains, stands the Necromancer’s Tower.\n"
        );
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        // -------------------- Flame Revenants --------------------
        PrintUtil.line();
        PrintUtil.type("""
                🔥 From the molten cracks below, Flame Revenants rise,
                their forms flickering with ember and hatred.
                """);

        PrintUtil.type("🎯 Objective: Defeat 3 Flame Revenants!\n");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        Enemy enemy1 = new World3Enemy1();
        Battle battle1 = new Battle(player, enemy1);

        for (int i = 1; i <= 3; i++) {
            PrintUtil.hr();
            System.out.println("🔥 Flame Revenant " + i + " emerges from the lava!");
            PrintUtil.hr();

            battle1.startBattle();

            System.out.println("✅ You have defeated Flame Revenant " + i + "!");
            PrintUtil.line();
            enemy1.dropLoot(player);

            if (i < 3) {
                enemy1 = new World3Enemy1();
                battle1 = new Battle(player, enemy1);
            }

        }

        PrintUtil.line();
        PrintUtil.type("""
                    🎉 Victory! The last revenant collapses into molten shards.
                    The lava around you cools slightly — a brief moment of calm.
                    """);
        PrintUtil.loot("You gain experience and loot from the battle.\n");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();
        player.getEffects().resetAllEffects();


        PrintUtil.event("You steel yourself and begin the ascent.");
        PrintUtil.effect("The air thickens with magic. Each step hums with a pulse from the Stones you carry.\n");
        InputUtil.pressEnterToContinue();

        PrintUtil.event("From the darkness crawl soldiers of bone and beasts stitched from shadow.");
        InputUtil.pressEnterToContinue();

        // -------------------- Bone Warlocks --------------------
        PrintUtil.effect("The ground trembles as sinister energy gathers.");
        PrintUtil.type("""
                From the shadows, Bone Warlocks appear, chanting forbidden incantations.
                """);

        PrintUtil.type("🎯 Objective: Defeat 2 Bone Warlocks!\n");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        Enemy enemy2 = new World3Enemy2();
        Battle battle2 = new Battle(player, enemy2);

        for (int i = 1; i <= 2; i++) {
            PrintUtil.hr();
            System.out.println("💀 Bone Warlock " + i + " raises its staff, channeling dark fire!");
            PrintUtil.hr();

            battle2.startBattle();

            System.out.println("✅ You have defeated Bone Warlock " + i + "!");
            PrintUtil.line();
            enemy2.dropLoot(player);

            if (i < 2) {
                enemy2 = new World3Enemy2();
                battle2 = new Battle(player, enemy2);
            }
        }

        PrintUtil.line();
        PrintUtil.type("""
                    🎉 Victory! The Bone Warlocks crumble, their souls screaming into the void.
                    The heat intensifies — something greater stirs within the peaks.
                    """);
        PrintUtil.loot("You gain experience and loot from your fiery victory.\n");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();
        player.getEffects().resetAllEffects();

        // -------------------- Obsidian Crushers --------------------
        PrintUtil.event("A deep rumble echoes through the caverns.");
        PrintUtil.effect("Lava bursts upward, and massive shadows rise behind the flames.");

        PrintUtil.type("""
                Obsidian Crushers emerge — molten giants forged from stone and fury.
                """);

        PrintUtil.type("🎯 Objective: Defeat 2 Obsidian Crushers!\n");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        Enemy enemy3 = new World3Enemy3();
        Battle battle3 = new Battle(player, enemy3);

        for (int i = 1; i <= 2; i++) {
            PrintUtil.hr();
            System.out.println("🪨 Obsidian Crusher " + i + " roars and slams the ground!");
            PrintUtil.hr();

            battle3.startBattle();

            System.out.println("✅ You have defeated Obsidian Crusher " + i + "!");
            PrintUtil.line();
            enemy3.dropLoot(player);

            if (i < 2) {
                enemy3 = new World3Enemy3();
                battle3 = new Battle(player, enemy3);
            }
        }

        PrintUtil.line();
        PrintUtil.type("""
                    🎉 Victory! The Crushers shatter, falling into the lava below.
                    The tremors subside — the way forward opens.
                    """);
        PrintUtil.loot("You gain experience and loot from your battle.\n");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();
        player.getEffects().resetAllEffects();


        PrintUtil.event("Halfway up, you find a mural etched into obsidian.");
        PrintUtil.type(
                "It shows a hooded figure holding three glowing stones, beneath a phrase in your own language:\n" +
                        "  'To teach is to control.'\n"
        );
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        // -------------------- Soulflayer Gargoyles --------------------
        InputUtil.pressEnterToContinue();
        PrintUtil.effect("A chilling wind cuts through the heat.");
        PrintUtil.type("""
                From the shadows of molten stone, Soulflayer Gargoyles take flight.
                Their shrieks pierce the air, echoing through the infernal spires.
                """);

        PrintUtil.type("🎯 Objective: Defeat 3 Soulflayer Gargoyles!\n");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        Enemy enemy4 = new World3Enemy4();
        Battle battle4 = new Battle(player, enemy4);

        for (int i = 1; i <= 3; i++) {
            PrintUtil.hr();
            System.out.println("😈 Soulflayer Gargoyle " + i + " swoops down from above!");
            PrintUtil.hr();

            battle4.startBattle();

            System.out.println("✅ You have defeated Soulflayer Gargoyle " + i + "!");
            PrintUtil.line();
            enemy4.dropLoot(player);

            if (i < 3) {
                enemy4 = new World3Enemy4();
                battle4 = new Battle(player, enemy4);
            }
        }

        PrintUtil.line();
        PrintUtil.type("""
                    🎉 Victory! The last Gargoyle falls, shattering to dust midair.
                    Silence returns — save for the slow, rising heartbeat of the volcano.
                    """);
        PrintUtil.loot("You gain experience and loot from your hard-fought battle.\n");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();
        player.getEffects().resetAllEffects();

        // -------------------- MINIBOSS: ZYRRYL, THE TOWER WARDEN --------------------
        PrintUtil.title("MINI-BOSS — Zyrryl, The Tower Warden");
        PrintUtil.type("""
                As you reach the summit, molten light reveals a towering figure.
                Zyrryl, Warden of the Shattered Tower, stands armed with cursed steel.
                """);
        PrintUtil.type("🎯 Objective: Defeat Zyrryl, The Tower Warden!\n");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        Enemy miniboss = new World3Miniboss1();
        Battle minibattle = new Battle(player, miniboss);
        minibattle.startBattle();

        PrintUtil.line();
        PrintUtil.type("""
                    🏆 Mini-Boss Defeated!
                    Zyrryl falls to one knee, his molten armor cracking apart.
                    You have shattered the guardian of flame.
                    """);
        PrintUtil.loot("You gain rare loot and powerful rewards!\n");
        miniboss.dropLoot(player);
        InputUtil.pressEnterToContinue();
        PrintUtil.line();
        player.getEffects().resetAllEffects();

        // TODO : PRE-FINAL RANDOM ENCOUNTER (ka luther ni)
        // --- Boss: the revelation ---
        PrintUtil.title("BOSS — Sir Khai, the Necromancer");
        PrintUtil.event("At the summit, the Third Stone pulses with violet light.");
        PrintUtil.effect("You reach out. The Stones unite—humming like a single heartbeat.");
        PrintUtil.event("Then Khai steps forward, staff blazing.\n");
        PrintUtil.say("Sir Khai", "\"You’ve served well, student. Who better to collect the relics than one who trusts their teacher?\"");
        PrintUtil.say("Sir Khai", "\"I guided you not to save this land—but to claim its power. The Necromancer you sought... is me.\"\n");



        PrintUtil.hr();
    }

}
