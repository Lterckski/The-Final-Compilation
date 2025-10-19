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
import worlds.World1;

public class StoryEngine {

    private Character player;

    public void start() {
        intro();
        Character player = chooseCharacter();

        World1 w1 = new World1();
        w1.run(player);

        transitionToWorld2();
    }

    // ---------- Scenes ----------
    private void intro() {
        System.out.println();
        ScenePrinter.hr();
        System.out.println("Backstory — The Exam That Never Began\n");
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

        ScenePrinter.hr();
        System.out.println("Welcome to The Final Compilation");
        ScenePrinter.hr();
    }

    private Character chooseCharacter() {
        Character player = null;

        do {
            ScenePrinter.line();
            System.out.println("1 - Kael Saint Laurent (Swordsman)");
            System.out.println("2 - Karl Clover Dior IV (Archer)");
            System.out.println("3 - Simon Versace (Mage)");
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
                        System.out.println("You selected " + player.getName() + " ⚔️!");
                        ((Kael) player).showBackstory();
                        player.getInventory().setEquippedWeapon(Sword.OLD_BROADSWORD);
                    }
                }
                case 2 -> {
                    Karl karl = new Karl();
                    if (characterMenu(karl)) {
                        player = karl;
                        ScenePrinter.line();
                        System.out.println("You selected " + player.getName() + " 🏹!");
                        ((Karl) player).showBackstory();
                        player.getInventory().setEquippedWeapon(Bow.WOODEN_BOW);
                    }
                }
                case 3 -> {
                    Simon simon = new Simon();
                    if (characterMenu(simon)) {
                        player = simon;
                        ScenePrinter.line();
                        System.out.println("You selected " + player.getName() + " 🔮!");
                        ((Simon) player).showBackstory();
                        player.getInventory().setEquippedWeapon(Staff.WOODEN_STAFF);
                    }
                }
                default -> System.out.println("❌ Invalid choice! Please select a valid option.");
            }
        } while (player == null);

        // Equip default armor
        player.getInventory().setEquippedArmor(Armor.LEATHER_GUARD);
        InputUtil.pressEnterToContinue();

        return player; // return the selected player
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
}
