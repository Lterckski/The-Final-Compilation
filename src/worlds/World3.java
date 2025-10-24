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

        ScenePrinter.event("You steel yourself and begin the ascent.");
        ScenePrinter.effect("The air thickens with magic. Each step hums with a pulse from the Stones you carry.\n");
        InputUtil.pressEnterToContinue();

        // --- Midway encounters ---
        ScenePrinter.event("From the darkness crawl soldiers of bone and beasts stitched from shadow.");
        encounter(player, new World3Enemy1());
        encounter(player, new World3Enemy2());
        InputUtil.pressEnterToContinue();

        // --- Discovery scene ---
        ScenePrinter.event("Halfway up, you find a mural etched into obsidian.");
        ScenePrinter.type(
                "It shows a hooded figure holding three glowing stones, beneath a phrase in your own language:\n" +
                        "  'To teach is to control.'\n"
        );
        InputUtil.pressEnterToContinue();

        // --- Boss: the revelation ---
        ScenePrinter.title("BOSS — Sir Khai, the Necromancer");
        ScenePrinter.event("At the summit, the Third Stone pulses with violet light.");
        ScenePrinter.effect("You reach out. The Stones unite—humming like a single heartbeat.");
        ScenePrinter.event("Then Khai steps forward, staff blazing.\n");
        ScenePrinter.say("Sir Khai", "\"You’ve served well, student. Who better to collect the relics than one who trusts their teacher?\"");
        ScenePrinter.say("Sir Khai", "\"I guided you not to save this land—but to claim its power. The Necromancer you sought... is me.\"\n");

        encounter(player, new World3Boss());

        // --- Ending scene ---
        ScenePrinter.title("EPILOGUE — The Third Stone");
        ScenePrinter.type(
                "As the dust settles, the tower crumbles around you.\n" +
                        "The Stones in your hands burn with energy—then fade to cold crystal.\n" +
                        "You look where Khai once stood. Only ashes remain.\n\n" +
                        "A distant voice whispers:\n" +
                        "  'Power is never given. Only passed on.'\n"
        );
        ScenePrinter.hr();
    }

}
