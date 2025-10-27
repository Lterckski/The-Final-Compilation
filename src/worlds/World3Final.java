package worlds;

import enemies.*;
import battle.Battle;
import characters.Character;
import story.ScenePrinter;
import utils.InputUtil;

import java.lang.reflect.Method;

public class World3Final {

    public void run(Character player) {
        ScenePrinter.title("The Final Twist — Betrayal");

        ScenePrinter.type(
                "Khai transforms, robes shredding into wings of smoke, staff splitting into a blade of pure void.\n" +
                        "The Stones float around him like chained stars.\n"
        );
        ScenePrinter.say("Khai", "\"You were never meant to go home. You were meant to be my successor... or my sacrifice.\"\n");
        ScenePrinter.effect("The tower shakes as your final battle begins.");
        InputUtil.pressEnterToContinue();

        ScenePrinter.type("""
                Shadows twist around the room, coalescing into forms of the fallen.
                Khai's laughter echoes, chilling your bones.
                """);
        ScenePrinter.type("🎯 Objective: Defeat Khai, the Void Ascendant!\n");
        InputUtil.pressEnterToContinue();
        ScenePrinter.line();

        Enemy finalBoss = new FinalBoss(); // Make sure FinalBoss class is properly defined
        Battle finalBattle = new Battle(player, finalBoss);

        finalBattle.startBattle();

        if (player.isAlive()) {
            ScenePrinter.line();
            ScenePrinter.type("""
                    🏆 Victory! Khai staggers, his form unraveling into smoke and stars.
                    The tower falls silent. The Stones hover gently before dissipating.
                    You have triumphed over the ultimate darkness.
                    """);
            InputUtil.pressEnterToContinue();
            ScenePrinter.line();
        } else {
            ScenePrinter.line();
            ScenePrinter.type("💀 Defeat... The world trembles as Khai's power engulfs you.");
            ScenePrinter.event("You have fallen. The Stones remain in darkness.");
            InputUtil.pressEnterToContinue();
        }
    }


}
