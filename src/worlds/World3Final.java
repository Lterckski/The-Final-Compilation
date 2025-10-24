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

        encounter(player, new FinalBoss());
    }

}
