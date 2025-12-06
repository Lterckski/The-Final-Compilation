package battle;

import characters.Character;
import enemies.FinalBoss;
import utils.ColorUtil;
import utils.InputUtil;
import utils.PrintUtil;
import storyEngine.StoryEngine;
import events.ReviveTrial;


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
            System.out.println("[2] \uD83C\uDF92 Open Inventory");
            System.out.println("[3] \uD83E\uDDD1 Show Player Stats");
            System.out.println("[4] \uD83D\uDCD6 Show Player Skills Overview");
            System.out.println("[5] \uD83D\uDC79 Show Enemy Stats");
            System.out.println("[6] \uD83D\uDCDD Show Enemy Skills Overview");
            System.out.println("[7] ❌ Quit the Game");

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
                case 7 -> StoryEngine.quitGame();
                default -> System.out.println("❌ Invalid input! Please select a valid option.");
            }
        }
    }

    // ---------- HEALTH BAR UTIL ----------
    private String generateBar(int current, int max) {
        int length = 20;
        int filled = (int) Math.round((double) current / max * length);
        int empty = length - filled;
        StringBuilder bar = new StringBuilder();

        // add filled blocks
        for (int i = 0; i < filled; i++) bar.append("█");

        // add empty space
        for (int i = 0; i < empty; i++) bar.append("░");

        return bar.toString();
    }


    private void  displayBattleStats() {
        String playerHpBar = generateBar(player.getHp(), player.getMaxHP()); // Green
        String playerStaminaBar = generateBar(player.getEnergy(), player.getMaxEnergy()); // Gray
        String enemyHpBar = generateBar(enemy.getHp(), enemy.getMaxHP()); // Red

        // Top border
        System.out.println(ColorUtil.boldBrightCyan("┌────────────────────────────────────────────────────────────────────────────────────┐"));

// --- Player HP ---
        System.out.printf("  %-21s %-4s %s %s  ",
                ColorUtil.boldBrightGreen("Your HP"),
                ColorUtil.boldBrightGreen(playerHpBar),
                ColorUtil.boldBrightGreen(player.getHp() + "/" + player.getMaxHP()),
                "💚");

// --- Enemy HP ---
        System.out.printf("  %-22s %-4s %s %s%n",
                ColorUtil.boldBrightRed("Enemy HP"),
                ColorUtil.boldBrightRed(enemyHpBar),
                ColorUtil.boldBrightRed(enemy.getHp() + "/" + enemy.getMaxHP()),
                "❤️");

// --- Player Energy ---
        System.out.printf("  %-21s %-4s %s %s%n",
                ColorUtil.boldBrightWhite(player.getEnergyName()),
                ColorUtil.boldBrightWhite(playerStaminaBar),
                ColorUtil.boldBrightWhite(player.getEnergy() + "/" + player.getMaxEnergy()),
                player.getEnergyEmoji());

// --- Enemy Shield (if any) ---
        if (enemy instanceof FinalBoss fb && fb.getShield() > 0) {
            System.out.println(ColorUtil.boldBrightRed("🛡️ Enemy Shield Active: " + fb.getShield()));
        }

// Bottom border
        System.out.println(ColorUtil.boldBrightCyan("└────────────────────────────────────────────────────────────────────────────────────┘"));

    }

    public String worldDisplay(int worldLevel) {
        return switch (worldLevel) {
            case 1 -> """
┓ ┏┏┓┳┓┓ ┳┓ ┓
═══════════════ ┃┃┃┃┃┣┫┃ ┃┃ ┃ ═══════════════
┗┻┛┗┛┛┗┗┛┻┛ ┻
""";
            case 2 -> """
┓ ┏┏┓┳┓┓ ┳┓ ┏┓
═══════════════ ┃┃┃┃┃┣┫┃ ┃┃ ┏┛ ═══════════════
┗┻┛┗┛┛┗┗┛┻┛ ┗━
""";
            case 3 -> """
┓ ┏┏┓┳┓┓ ┳┓ ┏┓
 ┫┃┃┃┃┣┫┃ ┃┃  ┫
┗┛┻┛┗┛┛┗┗┛┻┛ ┗┛
""";
            default -> """
┓ ┏┏┓┳┓┓ ┳┓
═══════════════ ┃┃┃┃┃┣┫┃ ┃┃ ═══════════════
┗┻┛┗┛┛┗┗┛┻┛
""";
        };
    }


    private String centerText(String text, int width) {
        int padding = (width - text.length()) / 2;
        if (padding < 0) padding = 0; // avoid negative
        return " ".repeat(padding) + text;
    }

    // ---------- BATTLE LOOP ----------
    public void battleLoop() {
        PrintUtil.line();
        System.out.println();

        int consoleWidth = 80;
        int worldLevel = StoryEngine.getCurrWorldLevel();
        String worldAscii = worldDisplay(worldLevel);

// --- Center the ASCII art ---
        for (String line : worldAscii.split("\n")) {
            System.out.println(centerText(line, consoleWidth));
        }

// --- Battle start message ---
        String firstName = player.getName().split(" ")[0].toUpperCase();
        String battleText = "⚔️ BATTLE START! " + firstName + " VS " + enemy.getName().toUpperCase();
        System.out.println(centerText(battleText, consoleWidth));

// --- Centered horizontal line ---
        System.out.println(centerText("════════════════════════════════════════════════════════════════", consoleWidth));

// --- Wait for input ---
        InputUtil.pressEnterToContinue();

        while (player.isAlive() && enemy.isAlive()) {

            // -------- PLAYER TURN --------
            // Update buffs/debuffs before the player acts
            player.getEffects().updateAttackModifiers();
            player.getEffects().updateDefenseModifiers();

            System.out.println();
            displayBattleStats();

            System.out.println(ColorUtil.boldBrightGreen("── YOUR TURN ──"));

            if (player.getEffects().checkEffects()) {
                player.turn(enemy);
            }

            // Apply poison/burn etc. after action
            player.getEffects().updateDoTEffects();
            PrintUtil.line();
            InputUtil.pressEnterToContinue();

            if (!enemy.isAlive()) {
                //System.out.println("🔥 You defeated " + enemy.getName() + "!");
                break;
            }

            // -------- ENEMY TURN --------
            // Update buffs/debuffs before enemy acts
            enemy.getEffects().updateAttackModifiers();
            enemy.getEffects().updateDefenseModifiers();

            System.out.println(ColorUtil.boldBrightRed("\n── ENEMY TURN ──"));

            if (enemy.getEffects().checkEffects()) {
                PrintUtil.pause(800);
                enemy.turn(player);
            }

            // Apply DoT after enemy acts
            enemy.getEffects().updateDoTEffects();
            PrintUtil.line();
            InputUtil.pressEnterToContinue();

            if (!player.isAlive()) {
                if (player.getInventory().hasPhoenixSoulstone()) {
                    player.getInventory().usePhoenixSoulstone();
                    player.setHp(player.getMaxHP() / 2);
                    player.setEnergy(player.getMaxEnergy() / 2);

                    System.out.println("🕊️ The Phoenix Soulstone revives you!");
                    System.out.println("✨ You return with restored strength!");
                    System.out.println("💚 HP : " + player.getHp() + " | " + player.getEnergyEmoji() + " " + player.getEnergyName() + " : " + player.getEnergy());
                    continue;
                }

                if (player.hasUsedReviveTrial()) {
                    System.out.println("💀 You fall once more... there are no more second chances.");
                    gameOver();
                    return;
                }

                System.out.println("💀 You collapse, your vision fading...");
                boolean survived = ReviveTrial.run(player);

                if (survived) {
                    int revivedHp = player.getMaxHP() / 2;
                    int revivedEnergy = player.getMaxEnergy() / 2;

                    player.setHp(revivedHp);
                    player.setEnergy(revivedEnergy);
                    player.getEffects().resetAllEffects();
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
        PrintUtil.print("""
        💀 Darkness overwhelms you...
        The battlefield falls silent, your vision fades,
        and the echoes of your struggles vanish into the void.
        """);
        InputUtil.pressEnterToContinue();
        System.out.println("☠️ GAME OVER — Your story ends in shadow.");
        System.exit(0);
    }

}
