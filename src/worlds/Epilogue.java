package worlds;

import characters.Character;
import story.ScenePrinter;
import utils.InputUtil;

public class Epilogue {

    public void run(Character player) {
        ScenePrinter.title("Epilogue — The Exam’s True Cost");

        ScenePrinter.type(
                "With your last strike, the tower collapses. The Stones shatter. Light swallows everything.\n\n" +
                        "You jolt awake. Back in the lab. The CodeChum login screen still waits.\n" +
                        "The timer blinks: 00:00:01. Not a single problem solved.\n\n" +
                        "You conquered a world, fought betrayal, toppled a king—\n" +
                        "but here, in reality, your exam hasn’t even started.\n\n" +
                        "And for a split second, when you glance at your professor across the room,\n" +
                        "you swear his eyes flash violet.\n"
        );

        InputUtil.pressEnterToContinue();
        ScenePrinter.hr();
        ScenePrinter.type(">> The End <<\n");
    }
}
