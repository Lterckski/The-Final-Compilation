package events;

import characters.Character;
import utils.InputUtil;
import utils.PrintUtil;

public class ReviveTrial {

    public static boolean run(Character player) {

        PrintUtil.title("Necromancer's Java Trial");
        PrintUtil.type("""
                Your vision fades... the last strike echoes in your ears.
                As darkness closes in, a distorted whisper pierces the void:
                
                "Programmer... your story does not end unless your logic fails.
                 Answer me, and reclaim your life."
                """);

        PrintUtil.line();
        System.out.println("⏱ You have 10 seconds to answer!");
        PrintUtil.line();

        System.out.println("What is the output of the following Java code?\n");
        System.out.println("int x = 5;");
        System.out.println("System.out.println(x++ + ++x);");
        System.out.println();
        System.out.println("[1] 10");
        System.out.println("[2] 11");
        System.out.println("[3] 12");
        System.out.println("[4] 13");
        PrintUtil.line();
        System.out.print("Your answer (1-4): ");

        long start = System.currentTimeMillis();
        int answer = InputUtil.scanInput();
        long elapsed = System.currentTimeMillis() - start;

        boolean correct = (answer == 3);      // 5 + 7 = 12
        boolean withinTime = elapsed <= 10_000;

        PrintUtil.line();

        if (correct && withinTime) {
            PrintUtil.type("""
                    ✅ CORRECT.
                    A warm surge pulses through your body as the voice mutters:
                    "You understand increments... you shall rise again."
                    """);

            InputUtil.pressEnterToContinue();
            PrintUtil.line();
            return true;

        } else if (!withinTime) {
            PrintUtil.type("""
                    ⏱ TOO SLOW.
                    The whisper fades:
                    "In both battle and code... hesitation is death."
                    """);

        } else {
            PrintUtil.type("""
                    ❌ INCORRECT.
                    The echo sighs:
                    "Study your operators, student. Not even death will debug your mistakes."
                    """);
        }

        InputUtil.pressEnterToContinue();
        PrintUtil.line();
        return false;
    }
}
