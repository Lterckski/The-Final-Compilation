package worlds;

import characters.Character;
import inventory.Weapon;
import inventory.Armor;
import inventory.LegendaryGear;
import utils.InputUtil;
import utils.PrintUtil;

public class PreFinalEncounter {

    public void start(Character player) {

        PrintUtil.title("🌩 PRE-FINAL BOSS RANDOM ENCOUNTER");

        PrintUtil.type("""
                As you advance deeper into the ruins, a cloaked figure materializes before you.

                "Before you face the Final Boss… prove your mastery of the pillars of OOP.
                 Each question must be answered within time… and without error."

                Answer every question correctly to earn ONE legendary artifact.
                One mistake — and your trial ends immediately.
                """);

        // TIMED QUESTION CHALLENGE
        boolean passed = OOPTrial.askQuestions();

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

        PrintUtil.type("""
                ✅ Impressive… you demonstrated complete command of OOP.

                The figure raises both hands.
                Two artifacts emerge from a burst of violet flame:
                """);

        Weapon legendaryWeapon = LegendaryGear.getLegendaryWeapon();
        Armor legendaryArmor = LegendaryGear.getLegendaryArmor();

        System.out.println("[1] Legendary Weapon: " + legendaryWeapon.getName());
        System.out.println("[2] Legendary Armor : " + legendaryArmor.getName());
        PrintUtil.line();


        System.out.print("Enter choice: ");
        int choice = InputUtil.scanInput();

        if (choice == 1) {
            player.getInventory().equipLegendaryWeapon(legendaryWeapon);

            PrintUtil.type("""
                    ⚔️ You grasp the Legendary Weapon.

                    The air hums with raw power as the armor dissolves into smoke.
                    """);
        } else {
            player.getInventory().equipLegendaryArmor(legendaryArmor);

            PrintUtil.type("""
                    🛡️ You choose the Legendary Armor.

                    A protective aura envelopes you as the weapon fades away.
                    """);
        }
    }
}
