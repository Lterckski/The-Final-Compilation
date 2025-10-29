package battle;

import characters.Character;

import enemies.FinalBoss;
import story.ScenePrinter;
import utils.InputUtil;

public class Battle {
    private final Character player;
    private final Character enemy;

    public Battle(Character player, Character enemy){
        this.player = player;
        this.enemy = enemy;
    }

    public void startBattle(){
        preBattleOptions();
        battleLoop();
    }

    public void preBattleOptions() {
        boolean willFight = false;

        while(!willFight){
            ScenePrinter.line();
            System.out.println("What will you do?");
            System.out.println("1. Fight enemy");
            System.out.println("2. Open Inventory");
            System.out.println("3. Show Player Stats");
            System.out.println("4. Show Player Skills Overview");
            System.out.println("5. Show Enemy Stats");
            System.out.println("6. Show Enemy Skills Overview");

            System.out.print("Enter choice: ");
            int choice = InputUtil.scanInput();
            InputUtil.scan.nextLine();
            ScenePrinter.line();

            switch (choice){
                case 1 -> { System.out.println("⚔️ You chose to fight!"); willFight = true; }
                case 2 -> player.getInventory().openInventory();
                case 3 -> player.displayStats();
                case 4 -> player.displaySkills();
                case 5 -> enemy.displayStats();
                case 6 -> enemy.displaySkills();
                default -> System.out.println("❌ Invalid choice! Please select a valid option.");
            }
        }
    }

    public void battleLoop() {
        ScenePrinter.line();
        System.out.println();
        ScenePrinter.hr();
        String firstName = player.getName().split(" ")[0];
        System.out.println("⚔️ Battle Start! " + firstName + " vs " + enemy.getName());
        ScenePrinter.hr();

        while (player.isAlive() && enemy.isAlive()) {

            // -------- PLAYER TURN --------
            // Update buffs/debuffs before the player acts
            player.getEffects().updateAttackModifiers();
            player.getEffects().updateDefenseModifiers();

            if (player.getEffects().checkEffects()) {
                // --- PLAYER STATUS TRACKER ---
                System.out.println();
                ScenePrinter.line();
                System.out.println("💚 Your HP  : " + player.getHp() + "/" + player.getMaxHP() +
                        "   " + player.getEnergyEmoji() + " " + player.getEnergyName() + ": " + player.getEnergy() + "/" + player.getMaxEnergy());
                System.out.println("🖤 Enemy HP : " + enemy.getHp() + "/" + enemy.getMaxHP() +
                        ((enemy instanceof FinalBoss fb && fb.getShield() > 0) ? "   🛡️ Shield Active" : ""));


                ScenePrinter.line();

                System.out.println("-- Your Turn --");
                player.turn(enemy);
            } else {
                InputUtil.pressEnterToContinue();
            }

            // Apply poison/burn etc. after action
            player.getEffects().updateDoTEffects();
            ScenePrinter.line();

            if (!enemy.isAlive()) {
                //System.out.println("🔥 You defeated " + enemy.getName() + "!");
                break;
            }

            // -------- ENEMY TURN --------
            // Update buffs/debuffs before enemy acts
            enemy.getEffects().updateAttackModifiers();
            enemy.getEffects().updateDefenseModifiers();

            if (enemy.getEffects().checkEffects()) {
                System.out.println("\n-- Enemy Turn --");
                enemy.turn(player);
            }

            // Apply DoT after enemy acts
            enemy.getEffects().updateDoTEffects();
            InputUtil.pressEnterToContinue();
            ScenePrinter.line();
        }

        if (!player.isAlive()) {
            gameOver();
        }
    }

    public void gameOver() {
        ScenePrinter.line();
        System.out.println("⚔️ You have been defeated in battle...");
        ScenePrinter.type("""
            💀 Darkness overwhelms you...
            The battlefield falls silent, your vision fades,
            and the echoes of your struggles vanish into the void.
            """);
        InputUtil.pressEnterToContinue();
        System.out.println("☠️ GAME OVER — Your story ends in shadow.");
        System.exit(0);
    }


}
