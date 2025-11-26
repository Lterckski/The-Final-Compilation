package inventory;

import characters.Character;
import utils.InputUtil;
import utils.PrintUtil;

public class Inventory {

    private final Character player;
    private Weapon equippedWeapon;
    private Armor equippedArmor;
    private final Potions potions;

    public Inventory(Character owner) {
        this.player = owner;
        this.potions = new Potions(owner);
    }

    // --- Helpers for UI formatting ---
    private void printRow(String content) {
        int totalWidth = 57;  // total width inside the box
        int visibleLength = getVisibleLength(content);
        int padding = totalWidth - visibleLength;
        System.out.println("║ " + content + " ".repeat(Math.max(0, padding)) + "║");
    }

    // --- Counts visible characters ignoring ANSI codes ---
    private int getVisibleLength(String text) {
        return text.replaceAll("\u001B\\[[;\\d]*m", "").length();
    }

    // --- Generates a bar (red for HP, default for others) ---
    private String generateBar(int current, int max, boolean isHp) {
        int totalBars = 10;
        int filledBars = (int) ((double) current / max * totalBars);

        String bar = "[" +
                "█".repeat(filledBars) +
                " ".repeat(totalBars - filledBars) +
                "]";

        if (isHp) {
            return "\u001B[31m" + bar + "\u001B[0m"; // red color for HP
        } else {
            return bar;
        }
    }

    // --- Getters and Setters ---
    public Weapon getEquippedWeapon() { return equippedWeapon; }
    public Armor getEquippedArmor() { return equippedArmor; }
    public Potions getPotions() { return potions; }

    public void setEquippedWeapon(Weapon weapon) { equippedWeapon = weapon; }
    public void setEquippedArmor(Armor armor) { equippedArmor = armor; }

    // --- Inventory Menu ---
    public void openInventory() {
        boolean exit = false;

        while (!exit) {

            // BOX HEADER
            System.out.println("╔══════════════════════════════════════════════════════════╗");
            printRow("🧰 INVENTORY");
            System.out.println("╠══════════════════════════════════════════════════════════╣");

            // HP + Energy Bars
            printRow("💚 HP       : " +
                    generateBar(player.getHp(), player.getMaxHP(), true) + " " +
                    player.getHp() + "/" + player.getMaxHP());

            printRow("🔋 " + player.getEnergyName() + "  : " +
                    generateBar(player.getEnergy(), player.getMaxEnergy(), false) + " " +
                    player.getEnergy() + "/" + player.getMaxEnergy());

            System.out.println("╠══════════════════════════════════════════════════════════╣");

            // EQUIPPED ITEMS
            printRow("🗡️  Equipped Weapon : " +
                    (equippedWeapon != null ? equippedWeapon.getName() : "No Weapon Equipped"));

            printRow("🛡️  Equipped Armor  : " +
                    (equippedArmor != null ? equippedArmor.getName() : "No Armor Equipped"));

            System.out.println("╠══════════════════════════════════════════════════════════╣");

            // POTIONS
            printRow("🍃 Normal Healing Potion : " + potions.getNormalHealingPotions());
            printRow("💞 Full Healing Potion   : " + potions.getFullHealingPotions());
            printRow("⚡ Energy Potion         : " + potions.getEnergyPotions());

            System.out.println("╚══════════════════════════════════════════════════════════╝");

            // MENU
            PrintUtil.line();
            System.out.println("(1) Show Weapon Info");
            System.out.println("(2) Show Armor Info");
            System.out.println("(3) Use Normal Healing Potion");
            System.out.println("(4) Use Full Healing Potion");
            System.out.println("(5) Use Energy Potion");
            System.out.println("(0) Back");
            System.out.print("Choose an option: ");

            int choice = InputUtil.scanInput();
            PrintUtil.line();

            switch (choice) {

                case 1 -> {
                    if (equippedWeapon != null) equippedWeapon.displayInfo();
                    else System.out.println("❌ No weapon equipped!");
                }

                case 2 -> {
                    if (equippedArmor != null) equippedArmor.displayInfo();
                    else System.out.println("❌ No armor equipped!");
                }

                case 3 -> usePotion("normal");
                case 4 -> usePotion("full");
                case 5 -> usePotion("energy");

                case 0 -> exit = true;

                default -> System.out.println("❌ Invalid input! Try again.");
            }
        }
    }

    // --- Potion Handling ---
    private void usePotion(String type) {
        int current, max, available;

        switch (type) {
            case "normal" -> {
                current = player.getHp();
                max = player.getMaxHP();
                available = potions.getNormalHealingPotions();
            }
            case "full" -> {
                current = player.getHp();
                max = player.getMaxHP();
                available = potions.getFullHealingPotions();
            }
            case "energy" -> {
                current = player.getEnergy();
                max = player.getMaxEnergy();
                available = potions.getEnergyPotions();
            }
            default -> {
                return;
            }
        }

        if (current >= max) {
            System.out.println("💡 Already full! No potion needed.");
            return;
        }

        if (available <= 0) {
            System.out.println("❌ No potions of this type left!");
            return;
        }

        System.out.println("You have " + available + " potions.");
        System.out.print("How many do you want to use? ");

        int amount = InputUtil.scanInput();
        if (amount <= 0 || amount > available) {
            System.out.println("❌ Invalid amount!");
            return;
        }

        if (!areYouSure()) return;

        for (int i = 0; i < amount; i++) {
            switch (type) {
                case "normal" -> potions.useNormalHealingPotion();
                case "full" -> potions.useFullHealingPotion();
                case "energy" -> potions.useEnergyPotion();
            }
        }
    }

    // --- Confirmation prompt ---
    private boolean areYouSure() {
        System.out.println("Are you sure you want to use the potion? (1 = Yes, 0 = No)");
        int confirm = InputUtil.scanInput();
        return confirm == 1;
    }


}
