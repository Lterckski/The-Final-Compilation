package events;

import characters.Character;
import inventory.*;
import utils.ColorUtil;
import utils.InputUtil;
import utils.PrintUtil;

import java.util.Scanner;

public class PrefiEncounter {

    private static final int TIME_LIMIT = 30; // in seconds

    public void start(Character player) {
        // TIMED QUESTION CHALLENGE
        boolean passed = askQuestions();

        if (!passed) {
            PrintUtil.line();
            PrintUtil.type("""
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

    // --- LEGENDARY REWARD ---
    private void rewardLegendary(Character player) {
        System.out.println();
        System.out.println(ColorUtil.boldBrightYellow("────────────────────────────────────────────────────────────────────"));
        PrintUtil.type(ColorUtil.boldBrightYellow("""
            ✨ Impressive… you demonstrated complete command of OOP.

            The figure raises both hands.
            Two artifacts swirl into existence from a burst of violet fire..."""));
        System.out.println(ColorUtil.boldBrightYellow("────────────────────────────────────────────────────────────────────"));

        // Generate class-specific legendary weapon
        Weapon legendaryWeapon;
        switch (player.getClassType()) {
            case "Swordsman" -> legendaryWeapon = Sword.CELESTIAL_EDGE;
            case "Archer"    -> legendaryWeapon = Bow.GOLDEN_TALON;
            case "Mage"      -> legendaryWeapon = Staff.CHRONOMANCER_STAFF;
            default -> {
                PrintUtil.type("❌ ERROR: Unknown class type.");
                return;
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
            PrintUtil.line();

            System.out.printf("  %s[1]%s %s  %-20s %s%n",
                    ColorUtil.boldBrightGreen(""),
                    ColorUtil.RESET,
                    weaponEmoji,
                    ColorUtil.boldBrightYellow("Legendary Weapon : " + legendaryWeapon.getName()),
                    ""
            );

            System.out.printf("  %s[2]%s 🛡️  %-20s %s%n",
                    ColorUtil.boldBrightGreen(""),
                    ColorUtil.RESET,
                    ColorUtil.boldBrightYellow("Legendary Armor  : " + legendaryArmor.getName()),
                    ""
            );

            System.out.printf("  %s[3]%s ❌  %-20s%n",
                    ColorUtil.boldBrightGreen(""),
                    ColorUtil.RESET,
                    "Ignore and Walk away"
            );

            PrintUtil.line();
            System.out.print(ColorUtil.cyan("Enter choice: "));
            int choice = InputUtil.scanInput();

            if (choice == 3) {
                PrintUtil.type(ColorUtil.gray("""
                    You slowly back away from the relics...
                    The violet flames dim, disappointed.
                    """));
                return;
            }

            if (choice != 1 && choice != 2) {
                PrintUtil.type(ColorUtil.red("❌ Invalid choice. Try again.\n"));
                continue;
            }

            boolean choseWeapon = (choice == 1);

            // SUBMENU
            boolean confirming = true;

            while (confirming) {

                PrintUtil.line();
                System.out.println(ColorUtil.boldBrightYellow("You selected: ") +
                        ColorUtil.boldBrightCyan((choseWeapon ? legendaryWeapon.getName() : legendaryArmor.getName())));
                PrintUtil.line();

                System.out.println("  [1] 📃 " + ColorUtil.cyan("Display Info"));
                System.out.println("  [2] ✅ " + ColorUtil.green("Confirm Choice"));
                System.out.println("  [3] 🔙 " + ColorUtil.yellow("Back"));
                PrintUtil.line();

                System.out.print(ColorUtil.cyan("Enter choice: "));
                int confirmChoice = InputUtil.scanInput();

                switch (confirmChoice) {

                    case 1 -> {
                        // DISPLAY INFO
                        PrintUtil.line();
                        if (choseWeapon) legendaryWeapon.displayInfo();
                        else legendaryArmor.displayInfo();
                        PrintUtil.line();
                        InputUtil.pressEnterToContinue();
                    }

                    case 2 -> {
                        // CONFIRM SELECTION
                        if (choseWeapon) {
                            legendaryWeapon.equip(player);

                            PrintUtil.type(ColorUtil.boldBrightGreen("""
                                ⚔️ You grasp the Legendary Weapon...
                                It hums with ancient cosmic power.
                                """));

                            PrintUtil.pause(700);

                            PrintUtil.type(ColorUtil.boldBrightMagenta("""
                                🛡️ The Legendary Armor glows faintly...
                                its form crumbling into soft violet ashes—
                                drifting upward and fading into nothingness.
                                """));
                        } else {legendaryArmor.equip(player);

                            PrintUtil.type(ColorUtil.boldBrightGreen("""
                                🛡️ You claim the Legendary Armor.
                                A warm celestial aura reinforces your spirit...
                                """));

                            PrintUtil.pause(700);

                            PrintUtil.type(ColorUtil.boldBrightRed("""
                                ⚔️ The Legendary Weapon emits a final chime—
                                fractures form across its blade,
                                before it explodes into shimmering golden dust.
                                """));
                        }

                        PrintUtil.line();
                        return;
                    }

                    case 3 -> confirming = false;

                    default -> PrintUtil.type(ColorUtil.red("❌ Invalid option. Try again.\n"));
                }
            }
        }
    }

    private boolean askQuestions() {
        System.out.println();
        System.out.println(ColorUtil.boldBrightYellow("╔══════════════════════════════════════════════════════════════════════╗"));
        System.out.println(ColorUtil.boldBrightYellow("   🧠 OOP TRIAL – You must answer EACH question within 30 seconds!"));
        System.out.println(ColorUtil.boldBrightYellow("╚══════════════════════════════════════════════════════════════════════╝"));
        InputUtil.pressEnterToContinue();

        // Q1
        if (!askTimed(
                ColorUtil.cyan("""
                    \nQ1: Kael, Karl, and Simon share HP/Energy from the Character class.
                    Which OOP concept is this?

                      1. Polymorphism
                      2. Encapsulation
                      3. Inheritance
                      4. Abstraction
                    """),
                3
        )) return false;

        // Q2
        if (!askTimed(
                ColorUtil.cyan("""
                    \nQ2: Inventory prevents direct access to the item list; only methods modify it.
                    Which OOP concept is this?

                      1. Polymorphism
                      2. Encapsulation
                      3. Inheritance
                      4. Abstraction
                    """),
                2
        )) return false;

        // Q3
        if (!askTimed(
                ColorUtil.cyan("""
                    \nQ3: Kael.attack() and Simon.attack() behave differently,
                    overriding Character.attack().
                    Which OOP concept is this?

                      1. Abstraction
                      2. Polymorphism
                      3. Encapsulation
                      4. Inheritance
                    """),
                2
        )) return false;

        // Q4
        if (!askTimed(
                ColorUtil.cyan("""
                    \nQ4: Weapon is abstract, and Sword/Bow/Staff implement it differently,
                    but share the same interface.
                    Which OOP concept is this?

                      1. Encapsulation
                      2. Abstraction
                      3. Inheritance
                      4. Polymorphism
                    """),
                2
        )) return false;

        return true;
    }

    private boolean askTimed(String question, int correctAnswer) {
        PrintUtil.line();
        System.out.println(question);
        PrintUtil.line();

        System.out.println(ColorUtil.yellow("⏱ You have 30 seconds to answer!"));

        Integer answer = readWithTimeout(TIME_LIMIT);

        // TIMEOUT
        if (answer == null) {
            PrintUtil.line();
            PrintUtil.type(ColorUtil.red("""
                ⏱ TIME'S UP!

                The old master glares at you:
                "You must think faster to survive what comes next…"
                """));
            return false;
        }

        if (answer != correctAnswer) {
            PrintUtil.line();
            PrintUtil.type(ColorUtil.red("""
                ❌ WRONG ANSWER.

                The figure sighs:
                "Your fundamentals are weak. You are not yet worthy."
                """));
            return false;
        }

        PrintUtil.type(ColorUtil.green("✅ CORRECT!"));
        return true;
    }

    // ---------------- READ INPUT WITH TIMEOUT ----------------
    private Integer readWithTimeout(int seconds) {
        Scanner scanner = new Scanner(System.in);
        long startTime = System.currentTimeMillis();
        long endTime = startTime + seconds * 1000L;

        System.out.print(ColorUtil.cyan("Enter choice: "));

        while (System.currentTimeMillis() < endTime) {
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                try {
                    return Integer.parseInt(line);
                } catch (NumberFormatException e) {
                    System.out.print(ColorUtil.red("❌ Invalid input. Enter a number: "));
                }
            }

            try {
                Thread.sleep(50); // reduce CPU usage
            } catch (InterruptedException ignored) {}
        }

        return null; // TIMEOUT
    }
}
