package worlds;

import enemies.*;
import inventory.Potions;
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
            System.out.println("🐺 Wolf " + i + " lunges at you!");
            battle1.startBattle();

            if (!enemy1.isAlive()) {
                System.out.println("✅ You have defeated Wolf " + i + "!");
                ScenePrinter.line();
                player.gainExp(enemy1.getExp());
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



        //TODO : ENEMY 2 : 2 SHADE SPRITES ENCOUNTERED

        //TODO : ENEMY 3 : 2 DREADBARK TREANTS ENCOUNTERED

        //TODO : ENEMY 4 : 4 CARRION BATS ENCOUNTERED


        ScenePrinter.event("An old tablet lies half-buried. Runes flicker like code. You feel energy stir.");
        player.restoreEnergy(30);
        System.out.println("Energy restored.\n");
        InputUtil.pressEnterToContinue();

        //TODO : ENEMY 5 : MIN-BOSS ENCOUNTERED (THE HOLLOW STAG)

        ScenePrinter.event("You claim the First Stone from a tree black with rot. Light bursts outward; the forest exhales.");
        InputUtil.pressEnterToContinue();
    }

}
