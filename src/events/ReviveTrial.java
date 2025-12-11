package events;

import characters.Character;
import utils.InputUtil;
import utils.PrintUtil;
import utils.ColorUtil;

public class ReviveTrial {

    public static boolean run(Character player) {
        InputUtil.flushBuffer();

        PrintUtil.title("Necromancer's Java Trial");
        PrintUtil.print("""
            Your vision fades... the last strike echoes in your ears.
            As darkness closes in, a distorted whisper pierces the void:

            "Programmer... your story does not end unless your logic fails.
             Answer me, and reclaim your life."
            """);

        PrintUtil.line();
        System.out.println(ColorUtil.boldBrightRed("⏱ You have 10 seconds to answer!"));
        PrintUtil.line();

        System.out.println("What is the output of the following Java code?\n");
        System.out.println(ColorUtil.brightCyan("int x = 5;"));
        System.out.println(ColorUtil.brightCyan("System.out.println(x++ + ++x);"));
        System.out.println();
        System.out.println("[1] 10");
        System.out.println("[2] 11");
        System.out.println("[3] 12");
        System.out.println("[4] 13");
        PrintUtil.line();

        Integer answer = InputUtil.readWithTimeout(10);

        PrintUtil.line();

        if (answer == null) {
            printOutcome(ColorUtil.boldBrightRed("⏱ TOO SLOW.\nThe whisper fades:\n\"In both battle and code... hesitation is death.\""));
            return false;
        } else if (answer == 3) {
            printOutcome(ColorUtil.boldBrightGreen("✅ CORRECT.\nA warm surge pulses through your body as the voice mutters:\n\"You understand increments... you shall rise again.\""));
            return true;
        } else {
            printOutcome(ColorUtil.boldBrightRed("❌ INCORRECT.\nThe echo sighs:\n\"Study your operators, student. Not even death will debug your mistakes.\""));
            return false;
        }
    }

    private static void printOutcome(String message) {
        PrintUtil.print(message);
        InputUtil.pressEnterToContinue();
        PrintUtil.line();
    }
}