package story;

import characters.Character;
import characters.Kael;
import characters.Karl;
import characters.Simon;
import inventory.Armor;
import inventory.Bow;
import inventory.Staff;
import inventory.Sword;
import utils.InputUtil;
import worlds.*;

public class StoryEngine {

    private Character player;

    public void start() {
        intro();
        Character player = chooseCharacter();

        World1 w1 = new World1();
        w1.run(player);

        transitionToWorld2();
        World2 w2 = new World2();
        w2.run(player);

        transitionToWorld3();
        World3 w3 = new World3();
        w3.run(player);

        World3Final finale = new World3Final();
        finale.run(player);

        Epilogue end = new Epilogue();
        end.run(player);
    }

    // ---------- Scenes ----------
    private void intro() {
        System.out.println();
        ScenePrinter.hr();
        System.out.println("Backstory — The Exam That Never Began");
        ScenePrinter.hr();

        ScenePrinter.type(
                """
                        The lab hums with fluorescent light. You sit before the CodeChum login screen, nerves heavy but focus sharp.
                        Then the fans go silent, your classmates vanish, and the room feels hollow.
                        You type your credentials. The moment you press "Log in," the monitor ripples like water, \
                        and the world folds to black.
                        When you open your eyes, you're no longer in the lab.
                        """
        );
        InputUtil.pressEnterToContinue();

        System.out.println();
        ScenePrinter.hr();
        System.out.println("WELCOME TO THE FINAL COMPILATION...");
        ScenePrinter.hr();
        System.out.println();
    }

    private characters.Character chooseCharacter() {
        characters.Character player = null;

        do {
            ScenePrinter.line();
            System.out.println("(1) Kael Saint Laurent (Swordsman)");
            System.out.println("(2) Karl Clover Dior IV (Archer)");
            System.out.println("(3) Simon Versace (Mage)");
            ScenePrinter.line();

            System.out.print("Select your character: ");
            int choice = InputUtil.scan.nextInt();
            InputUtil.scan.nextLine();

            switch (choice) {
                case 1 -> {
                    Kael kael = new Kael();
                    if (characterMenu(kael)) {
                        player = kael;
                        ScenePrinter.line();
                        System.out.println("⚔️ You have chosen " + player.getName() + ", the valiant Swordsman!");
                        ((Kael) player).showBackstory();
                        ScenePrinter.line();
                        System.out.println("✨ The gods bestow upon you your starting gear...");
                        player.getInventory().setEquippedWeapon(Sword.OLD_BROADSWORD);
                        player.getInventory().setEquippedArmor(Armor.LEATHER_GUARD);
                        System.out.println("🗡️ *The --" + player.getInventory().getEquippedWeapon().getName() + "-- rests firmly in your grasp, its blade marked by the scars of past battles.*");
                        System.out.println("🛡️ *The --" + player.getInventory().getEquippedArmor().getName() + "-- fits perfectly, worn yet dependable — a true warrior’s first defense.*");
                        System.out.println("⚡ Strength surges through your veins as your journey begins...");
                        ScenePrinter.line();
                    }
                }
                case 2 -> {
                    Karl karl = new Karl();
                    if (characterMenu(karl)) {
                        player = karl;
                        ScenePrinter.line();
                        System.out.println("🏹 You have chosen " + player.getName() + ", the sharp-eyed Archer!");
                        ((Karl) player).showBackstory();
                        ScenePrinter.line();
                        System.out.println("🌬️ The winds whisper and bless you with your starting equipment...");
                        player.getInventory().setEquippedWeapon(Bow.WOODEN_BOW);
                        player.getInventory().setEquippedArmor(Armor.LEATHER_GUARD);
                        System.out.println("🏹 *The --" + player.getInventory().getEquippedWeapon().getName() + "-- hums softly as you draw the string — eager to strike true.*");
                        System.out.println("🛡️ *The --" + player.getInventory().getEquippedArmor().getName() + "-- wraps around you lightly, offering freedom and silent agility.*");
                        System.out.println("🌿 The forest seems to watch over you as your path unfolds...");
                        ScenePrinter.line();
                    }
                }
                case 3 -> {
                    Simon simon = new Simon();
                    if (characterMenu(simon)) {
                        player = simon;
                        ScenePrinter.line();
                        System.out.println("🧙‍♂️ You have chosen " + player.getName() + ", the wise Mage!");
                        ((Simon) player).showBackstory();
                        ScenePrinter.line();
                        System.out.println("✨ The arcane forces converge to gift you ancient relics of power...");
                        player.getInventory().setEquippedWeapon(Staff.WOODEN_STAFF);
                        player.getInventory().setEquippedArmor(Armor.LEATHER_GUARD);
                        System.out.println("🔮 *The --" + player.getInventory().getEquippedWeapon().getName() + "-- pulses faintly, whispering secrets of forgotten spells.*");
                        System.out.println("🛡️ *The --" + player.getInventory().getEquippedArmor().getName() + "-- shimmers with faint runes — fragile, yet brimming with arcane energy.*");
                        System.out.println("💫 Magic stirs in the air around you as your journey begins...");
                        ScenePrinter.line();
                    }
                }
                default -> System.out.println("❌ Invalid choice! Please select a valid option.");
            }
        } while (player == null);

        InputUtil.pressEnterToContinue();
        return player;
    }



    private boolean characterMenu(Character character) {
        while (true) {
            ScenePrinter.line();
            System.out.println("What would you like to do?");
            System.out.println("1 - Show Character Stats");
            System.out.println("2 - Show Character Skills");
            System.out.println("3 - Confirm Character");
            System.out.println("0 - Back");

            System.out.print("Enter choice: ");
            int choice = InputUtil.scan.nextInt();
            InputUtil.scan.nextLine();
            ScenePrinter.line();

            switch (choice) {
                case 1 -> character.displayStats();
                case 2 -> character.displaySkills();
                case 3 -> { return true; }
                case 0 -> { return false; }
                default -> System.out.println("❌ Invalid choice! Please select a valid option.");
            }
        }
    }


    private void transitionToWorld2() {
        ScenePrinter.title("Transition — Toward World 2");
        ScenePrinter.type(
                "Sir Khai's staff strikes the ground. \"Two stones remain,\" he intones.\n" +
                        "A path opens through the ash—down into fog and distant thunder.\n"
        );
        System.out.println("[Checkpoint reached]\n");
    }


    private void transitionToWorld3() {
        ScenePrinter.title("Transition — Toward World 3");
        ScenePrinter.type(
                "Sir Khai’s staff flares once more. The Second Stone trembles in your hand.\n" +
                        "Far off, lightning pierces a storm-swallowed horizon.\n" +
                        "He turns to you. \"The final trial awaits—where light cannot reach.\"\n"
        );
        System.out.println("[Checkpoint reached]\n");
    }

}
