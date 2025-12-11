package events;

import characters.Character;
import inventory.*;
import utils.ColorUtil;
import utils.InputUtil;
import utils.PrintUtil;

import static utils.PrintUtil.pause;

public class PrefiEncounter {

    private static final int TIME_LIMIT = 15; // seconds

    // ---------------- START ENCOUNTER ----------------
    public void start(Character player) {

        boolean passed = askQuestions();

        if (!passed) {
            PrintUtil.line();
            PrintUtil.print("""
                    ❌ The trial ends.

                    The figure's voice echoes:
                    "You lack the foundation required to wield true power."

                    No legendary artifacts will be granted.
                    You step forward… toward the Final Boss.
                    """);

            InputUtil.pressEnterToContinue();
            return;
        }

        rewardLegendary(player);

        InputUtil.pressEnterToContinue();
    }

    // ---------------- LEGENDARY REWARD ----------------
    private void rewardLegendary(Character player) {
        System.out.println();
        System.out.println(ColorUtil.boldBrightYellow("────────────────────────────────────────────────────────────────────"));
        PrintUtil.print(ColorUtil.boldBrightYellow("""
            ✨ Impressive… you demonstrated complete command of OOP.

            The figure raises both hands.
            Two artifacts swirl into existence from a burst of violet fire...
        """));
        System.out.println(ColorUtil.boldBrightYellow("────────────────────────────────────────────────────────────────────"));

        Weapon legendaryWeapon;

        // Determine weapon based on class
        switch (player.getClassType()) {
            case "Swordsman" -> legendaryWeapon = Sword.CELESTIAL_EDGE;
            case "Archer"    -> legendaryWeapon = Bow.GOLDEN_TALON;
            case "Mage"      -> legendaryWeapon = Staff.CHRONOMANCER_STAFF;
            default -> {
                legendaryWeapon = Staff.CHRONOMANCER_STAFF;
                return; // Should not happen
            }
        }

        Armor legendaryArmor = Armor.CELESTIAL_BATTLEGEAR;
        String weaponEmoji = switch (player.getClassType()) {
            case "Swordsman" -> "🗡️";
            case "Archer"    -> "🏹";
            case "Mage"      -> "🔮";
            default -> "⚔️";
        };

        while (true) {
            System.out.println();
            System.out.println(ColorUtil.boldBrightCyan("╔═════════════════════════════════════════════════════════════════╗"));
            System.out.println(ColorUtil.boldBrightCyan("               🟡 CHOOSE YOUR LEGENDARY ARTIFACT 🟡"));
            System.out.println(ColorUtil.boldBrightCyan("╚═════════════════════════════════════════════════════════════════╝"));

            // (I have hidden the ASCII art here to keep the code short,
            //  but your original ASCII art goes here unchanged)

            PrintUtil.line();

            System.out.printf("  %s[1]%s %s  %-20s%n",
                    ColorUtil.boldBrightGreen(""), ColorUtil.RESET, weaponEmoji,
                    ColorUtil.boldBrightYellow("Legendary Weapon : " + legendaryWeapon.getName()));

            System.out.printf("  %s[2]%s 🛡️  %-20s%n",
                    ColorUtil.boldBrightGreen(""), ColorUtil.RESET,
                    ColorUtil.boldBrightYellow("Legendary Armor  : " + legendaryArmor.getName()));

            System.out.printf("  %s[3]%s ❌  Ignore and Walk away%n",
                    ColorUtil.boldBrightGreen(""), ColorUtil.RESET);

            PrintUtil.line();

            // Ensure buffer is clean before asking for choice
            InputUtil.flushBuffer();
            System.out.print(ColorUtil.cyan("Enter choice: "));
            int choice = InputUtil.scanInput();

            if (choice == 3) {
                PrintUtil.print(ColorUtil.gray("""
                    You slowly back away from the relics...
                    The violet flames dim, disappointed.
                """));
                return;
            }

            if (choice != 1 && choice != 2) {
                PrintUtil.print(ColorUtil.red("❌ Invalid choice. Try again.\n"));
                continue;
            }

            boolean choseWeapon = (choice == 1);
            boolean confirming = true;

            while (confirming) {
                PrintUtil.line();
                System.out.println(ColorUtil.boldBrightYellow("You selected: ")
                        + ColorUtil.boldBrightCyan(choseWeapon ? legendaryWeapon.getName() : legendaryArmor.getName()));
                PrintUtil.line();

                System.out.println("  [1] 📃 " + ColorUtil.cyan("Display Info"));
                System.out.println("  [2] ✅ " + ColorUtil.green("Confirm Choice"));
                System.out.println("  [3] 🔙 " + ColorUtil.yellow("Back"));
                PrintUtil.line();

                System.out.println(ColorUtil.brightRed("(❌ Enchantments cannot be transferred)"));
                System.out.print(ColorUtil.cyan("Enter choice: "));

                InputUtil.flushBuffer();
                int confirmChoice = InputUtil.scanInput();

                switch (confirmChoice) {
                    case 1 -> {
                        PrintUtil.line();
                        if (choseWeapon) legendaryWeapon.displayInfo();
                        else legendaryArmor.displayInfo();
                        PrintUtil.line();
                        InputUtil.pressEnterToContinue();
                    }
                    case 2 -> {
                        if (choseWeapon) {
                            legendaryWeapon.equip(player);
                            PrintUtil.print(ColorUtil.boldBrightGreen("""
                            ⚔️ You grasp the Legendary Weapon...
                            It hums with ancient cosmic power."""));
                            pause(700);
                            PrintUtil.print(ColorUtil.boldBrightMagenta("""
                             🛡️ The Legendary Armor glows faintly...
                             its form crumbling into violet ashes."""));
                        } else {
                            legendaryArmor.equip(player);
                            PrintUtil.print(ColorUtil.boldBrightGreen("""
                            🛡️ You claim the Legendary Armor.
                            A warm celestial aura surrounds you..."""));
                            pause(700);
                            PrintUtil.print(ColorUtil.boldBrightRed("""
                            ⚔️ The Legendary Weapon emits a final chime—
                            then shatters into golden dust."""));
                        }
                        PrintUtil.line();
                        return;
                    }
                    case 3 -> confirming = false;
                    default -> PrintUtil.print(ColorUtil.red("❌ Invalid option.\n"));
                }
            }
        }
    }

    // ---------------- OOP TRIAL QUESTIONS ----------------
    private boolean askQuestions() {
        System.out.println();
        System.out.println(ColorUtil.boldBrightYellow("╔══════════════════════════════════════════════════════════════════════╗"));
        System.out.println(ColorUtil.boldBrightYellow("   🧠 OOP TRIAL – You must answer EACH question within 15 seconds!"));
        System.out.println(ColorUtil.boldBrightYellow("╚══════════════════════════════════════════════════════════════════════╝"));
        InputUtil.pressEnterToContinue();

        // Flush before starting the quiz to prevent accidental answers
        InputUtil.flushBuffer();

        if (!askTimed(ColorUtil.cyan("""
                \nQ1: Kael, Karl, and Simon use the same attributes (HP, Level, Defense, etc.) defined in the Character class.
                Which OOP concept is this?

                  1. Polymorphism
                  2. Encapsulation
                  3. Inheritance
                  4. Abstraction
            """), 3)) return false;

        if (!askTimed(ColorUtil.cyan("""
                \nQ2: Inventory prevents direct access to the item list; only methods modify it.
                Which OOP concept is this?

                  1. Polymorphism
                  2. Encapsulation
                  3. Inheritance
                  4. Abstraction
            """), 2)) return false;

        if (!askTimed(ColorUtil.cyan("""
                \nQ3: The showBackstory() methods of Kael, Karl, and Simon override Character.showBackstory(), so calling them prints a unique backstory for each character.
                Which OOP concept is this?

                  1. Abstraction
                  2. Polymorphism
                  3. Encapsulation
                  4. Inheritance
            """), 2)) return false;

        if (!askTimed(ColorUtil.cyan("""
                \nQ4: Weapon is an abstract class. Sword, Bow, and Staff extend it and implement its methods differently, but all share the same abstract interface defined by Weapon.
                Which OOP concept is this?

                  1. Encapsulation
                  2. Abstraction
                  3. Inheritance
                  4. Polymorphism
            """), 2)) return false;

        return true;
    }

    // ---------------- TIMED QUESTION ----------------
    private boolean askTimed(String question, int correctAnswer) {
        PrintUtil.line();
        System.out.println(question);
        PrintUtil.line();

        System.out.println(ColorUtil.yellow("⏱ You have 15 seconds to answer!"));

        // Use the new SAFER timed method
        Integer answer = InputUtil.readWithTimeout(TIME_LIMIT);

        if (answer == null) { // timeout
            PrintUtil.line();
            System.out.println();
            PrintUtil.print(ColorUtil.boldBrightRed("""
                The old master glares at you:
                "You must think faster to survive what comes next…"
                """));

            // Flush buffer so "late" typing doesn't crash the next menu
            InputUtil.flushBuffer();
            return false;
        }

        if (answer != correctAnswer) { // wrong
            PrintUtil.line();
            PrintUtil.print(ColorUtil.red("""
            ❌ WRONG ANSWER.

            The figure sighs:
            "Your fundamentals are weak. You are not worthy of the treasures of legend."
            """));
            return false;
        }

        PrintUtil.print(ColorUtil.green("✅ CORRECT!"));
        return true;
    }
}