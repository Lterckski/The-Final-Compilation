package worlds;

import utils.InputUtil;
import utils.PrintUtil;

public class OOPTrial {

    private static final int TIME_LIMIT = 30_000; // 30 seconds

    public static boolean askQuestions() {
        PrintUtil.line();
        PrintUtil.type("🧠 OOP TRIAL – You must answer EACH question within 30 seconds!");
        PrintUtil.line();

        // Q1
        if (!askTimed(
                """
                Q1: Kael, Karl, and Simon share HP/Energy from the Character class.
                Which OOP concept is this?
                1. Polymorphism
                2. Encapsulation
                3. Inheritance
                4. Abstraction
                """,
                3
        )) return false;

        // Q2
        if (!askTimed(
                """
                Q2: Inventory prevents direct access to the item list; only methods modify it.
                Which OOP concept is this?
                1. Polymorphism
                2. Encapsulation
                3. Inheritance
                4. Abstraction
                """,
                2
        )) return false;

        // Q3
        if (!askTimed(
                """
                Q3: Kael.attack() and Simon.attack() behave differently,
                overriding Character.attack().
                Which OOP concept is this?
                1. Abstraction
                2. Polymorphism
                3. Encapsulation
                4. Inheritance
                """,
                2
        )) return false;

        // Q4
        if (!askTimed(
                """
                Q4: Weapon is abstract, and Sword/Bow/Staff implement it differently,
                but share the same interface.
                Which OOP concept is this?
                1. Encapsulation
                2. Abstraction
                3. Inheritance
                4. Polymorphism
                """,
                2
        )) return false;

        return true;
    }


    private static boolean askTimed(String question, int correctAnswer) {
        System.out.println(question);
        PrintUtil.line();

        System.out.println("⏱ You have 30 seconds to answer!");
        long start = System.currentTimeMillis();

        System.out.print("Enter choice: ");
        int answer = InputUtil.scanInput();
        long timeSpent = System.currentTimeMillis() - start;

        if (timeSpent > TIME_LIMIT) {
            PrintUtil.line();
            PrintUtil.type("""
                    ⏱ TIME'S UP!
                    The old master glares at you:
                    "You must think faster to survive what comes next…"
                    """);
            return false;
        }

        if (answer != correctAnswer) {
            PrintUtil.line();
            PrintUtil.type("""
                    ❌ WRONG ANSWER.
                    The figure sighs:
                    "Your fundamentals are weak. You are not yet worthy."
                    """);
            return false;
        }

        PrintUtil.type("✅ Correct!\n");
        return true;
    }
}
