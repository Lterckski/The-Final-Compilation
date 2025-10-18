package story;

import characters.Character;
import characters.Kael;
import characters.Karl;
import characters.Simon;
import utils.InputUtil;
import worlds.World1;

public class StoryEngine {

    private Character player;

    public void start() {
        intro();
        chooseHero();

        World1 w1 = new World1();
        w1.run(player);

        transitionToWorld2();
    }

    // ---------- Scenes ----------
    private void intro() {
        ScenePrinter.hr();
        System.out.println("Backstory — The Exam That Never Began\n");
        ScenePrinter.type(
                """
                        The lab hums with fluorescent light. You sit before the CodeChum login screen, nerves heavy but focus sharp.
                        Then the fans go silent, your classmates vanish, and the room feels hollow.
                        You type your credentials. The moment you press "Log in," the monitor ripples like water, \
                        and the world folds to black.
                        When you open your eyes, you're no longer in the lab.
                        """
        );
    }

    private void chooseHero() {
        ScenePrinter.hr();
        System.out.println("Choose your hero:\n");
        System.out.println("[1] Kael — relentless swordsman");
        System.out.println("[2] Karl — shielded striker");
        System.out.println("[3] Simon — arcane caster\n");

        int pick;
        while (true) {
            System.out.print("Enter choice (1-3): ");
            if (InputUtil.scan.hasNextInt()) {
                pick = InputUtil.scan.nextInt();
                InputUtil.scan.nextLine();
                if (pick >= 1 && pick <= 3) break;
            } else {
                InputUtil.scan.nextLine();
            }
            System.out.println("Invalid. Try again.");
        }

        switch (pick) {
            case 1: player = new Kael(); break;
            case 2: player = new Karl(); break;
            default: player = new Simon();
        }

        System.out.println("\nYou are " + player.getName() + ".\n");
        InputUtil.pressEnterToContinue();
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
