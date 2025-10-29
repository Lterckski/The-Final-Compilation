package worlds;

import enemies.*;
import battle.Battle;
import characters.Character;
import utils.InputUtil;
import utils.PrintUtil;

public class World3Final {

    public void run(Character player) {
        PrintUtil.title("The Final Twist — Betrayal");

        PrintUtil.type(
                "Khai transforms, robes shredding into wings of smoke, staff splitting into a blade of pure void.\n" +
                        "The Stones float around him like chained stars.\n"
        );
        PrintUtil.say("Khai", "\"You were never meant to go home. You were meant to be my successor... or my sacrifice.\"\n");
        PrintUtil.effect("The tower shakes as your final battle begins.");
        InputUtil.pressEnterToContinue();

        PrintUtil.type("""
                Shadows twist around the room, coalescing into forms of the fallen.
                Khai's laughter echoes, chilling your bones.
                """);
        PrintUtil.type("🎯 Objective: Defeat Khai, the Void Ascendant!\n");
        InputUtil.pressEnterToContinue();
        PrintUtil.line();

        Enemy finalBoss = new FinalBoss();
        Battle finalBattle = new Battle(player, finalBoss);

        finalBattle.startBattle();

        PrintUtil.line();
        PrintUtil.type("""
                🏆 Victory! Khai staggers, his form unraveling into smoke and stars.
                The tower falls silent. The Stones hover gently before dissipating.
                You have triumphed over the ultimate darkness.
                """);
        InputUtil.pressEnterToContinue();
        PrintUtil.line();
        player.getEffects().resetAllEffects();
    }


}
