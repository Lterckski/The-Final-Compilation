package battle;

import characters.Character;
import enemies.FinalBoss;
import utils.InputUtil;
import utils.PrintUtil;
import storyEngine.StoryEngine;
import utils.JavaTrial;


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
            PrintUtil.line();
            System.out.println("What will you do?");
            System.out.println("[1] ⚔\uFE0F Fight enemy");
            System.out.println("[2] \uD83C\uDF92  Open Inventory");
            System.out.println("[3] \uD83E\uDDD1 Show Player Stats");
            System.out.println("[4] \uD83D\uDCD6 Show Player Skills Overview");
            System.out.println("[5] \uD83D\uDC79 Show Enemy Stats");
            System.out.println("[6] \uD83D\uDCDD Show Enemy Skills Overview");

            System.out.print("Enter choice: ");
            int choice = InputUtil.scanInput();
            PrintUtil.line();

            switch (choice){
                case 1 -> { System.out.println("⚔️ You chose to fight!"); willFight = true; }
                case 2 -> player.getInventory().openInventory();
                case 3 -> player.displayStats();
                case 4 -> player.displaySkills();
                case 5 -> enemy.displayStats();
                case 6 -> enemy.displaySkills();
                default -> System.out.println("❌ Invalid input! Please select a valid option.");
            }
        }
    }

    // ---------- HEALTH BAR UTIL ----------
    private String generateBar(int current, int max, int length, String colorCode) {
        int filled = (int) Math.round((double) current / max * length);
        int empty = length - filled;
        StringBuilder bar = new StringBuilder();
        bar.append(colorCode);
        for (int i = 0; i < filled; i++) bar.append("█");
        bar.append("\u001B[0m"); // reset color
        for (int i = 0; i < empty; i++) bar.append(" ");
        return bar.toString();
    }

    private void displayBattleStats() {
        String playerHpBar = generateBar(player.getHp(), player.getMaxHP(), 10, "\u001B[32m"); // Green
        String playerStaminaBar = generateBar(player.getEnergy(), player.getMaxEnergy(), 10, "\u001B[37m"); // Gray
        String enemyHpBar = generateBar(enemy.getHp(), enemy.getMaxHP(), 10, "\u001B[31m"); // Red

        // Top border
        System.out.println("┌─────────────────────────────────────────────────────────────────────────────────┐");

        // HP line
        System.out.printf("  💚 %-11s : [%s] %d/%d     ❤\uFE0F Enemy HP    : [%s] %d/%d%n",
                "Your HP", playerHpBar, player.getHp(), player.getMaxHP(),
                enemyHpBar, enemy.getHp(), enemy.getMaxHP());

        // Energy / Stamina line
        System.out.printf("  %s %-11s : [%s] %d/%d%n",
                player.getEnergyEmoji(), player.getEnergyName(), playerStaminaBar, player.getEnergy(), player.getMaxEnergy());

        // If enemy has shield
        if (enemy instanceof FinalBoss fb && fb.getShield() > 0) {
            System.out.printf("🛡️ Enemy Shield Active: %d%n", fb.getShield());
        }

        // Bottom border
        System.out.println("└─────────────────────────────────────────────────────────────────────────────────┘");
    }

    // ---------- BATTLE LOOP ----------
    public void battleLoop() {
        PrintUtil.line();
        System.out.println();
        int worldLevel = StoryEngine.getCurrWorldLevel();
        System.out.println("============== WORLD " + worldLevel + " ==============");
        String firstName = player.getName().split(" ")[0];
        System.out.println("⚔️ Battle Start! " + firstName + " vs " + enemy.getName());
        PrintUtil.hr();

        while (player.isAlive() && enemy.isAlive()) {

            // -------- PLAYER TURN --------
            // Update buffs/debuffs before the player acts
            player.getEffects().updateAttackModifiers();
            player.getEffects().updateDefenseModifiers();

            if (player.getEffects().checkEffects()) {
                // --- PLAYER STATUS TRACKER ---
                System.out.println();
                displayBattleStats();

                System.out.println("-- Your Turn --");
                player.turn(enemy);
            } else {
                InputUtil.pressEnterToContinue();
            }

            // Apply poison/burn etc. after action
            player.getEffects().updateDoTEffects();
            PrintUtil.line();

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
                PrintUtil.pause(800);
                enemy.turn(player);
            }

            // Apply DoT after enemy acts
            enemy.getEffects().updateDoTEffects();
            InputUtil.pressEnterToContinue();
            PrintUtil.line();

            if (!player.isAlive()) {
                if (player.hasUsedReviveTrial()) {
                    System.out.println("💀 You fall once more... there are no more second chances.");
                    gameOver();
                    return;
                }

                System.out.println("💀 You collapse, your vision fading...");
                boolean survived = JavaTrial.run(player);

                if (survived) {
                    int revivedHp = player.getMaxHP() / 2;
                    int revivedEnergy = player.getMaxEnergy() / 2;

                    player.setHp(revivedHp);
                    player.setEnergy(revivedEnergy);

                    player.setReviveUsed(true);

                    System.out.println("✨ Knowledge revives you!");
                    System.out.println("You are restored with 50% HP and 50% " + player.getEnergyName() + ".");
                    PrintUtil.line();
                } else{
                    System.out.println("❌ You failed Khai's Java Trial.");
                    System.out.println("Your journey ends here...");
                    gameOver();
                }
            }
        }

        if(!player.isAlive()){
            gameOver();
        }

    }

    public void gameOver() {
        PrintUtil.line();
        System.out.println("⚔️ You have been defeated in battle...");
        PrintUtil.type("""
        💀 Darkness overwhelms you...
        The battlefield falls silent, your vision fades,
        and the echoes of your struggles vanish into the void.
        """);
        InputUtil.pressEnterToContinue();
        System.out.println("☠️ GAME OVER — Your story ends in shadow.");
        System.exit(0);
    }


}
