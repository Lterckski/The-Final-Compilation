package worlds;

import inventory.Potions;
import battle.Battle;
import characters.Character;
import enemies.World1Enemy1;
import enemies.World1Enemy2;
import enemies.World1Miniboss1;
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


        encounter(player, new World1Enemy1());
        lootBreak(player);

        encounter(player, new World1Enemy2());
        lootBreak(player);


        ScenePrinter.event("An old tablet lies half-buried. Runes flicker like code. You feel energy stir.");
        player.restoreEnergy(30);
        System.out.println("Energy restored.\n");
        InputUtil.pressEnterToContinue();


        ScenePrinter.title("MINIBOSS — Rotfang Wolves");
        encounter(player, new World1Miniboss1());

        ScenePrinter.event("You claim the First Stone from a tree black with rot. Light bursts outward; the forest exhales.");
        InputUtil.pressEnterToContinue();
    }

    private void encounter(Character player, Character enemy) {
        ScenePrinter.hr();
        System.out.println("An enemy appears: " + enemy.getName());
        new Battle(player, enemy).battleLoop();
    }

    private void lootBreak(Character player) {
        ScenePrinter.loot("You search the remains...");




        InputUtil.pressEnterToContinue();
    }
}
