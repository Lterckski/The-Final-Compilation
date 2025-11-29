package inventory;

import characters.Character;
import utils.InputUtil;
import utils.PrintUtil;

public class Inventory {

    private final Character player;
    private Weapon equippedWeapon;
    private Armor equippedArmor;
    private final Potions potions;
    private boolean hasPhoenixSoulstone = false;

    public Inventory(Character owner) {
        this.player = owner;
        this.potions = new Potions(owner);
    }

    // --- Getters and Setters ---
    public Weapon getEquippedWeapon() { return equippedWeapon; }
    public Armor getEquippedArmor() { return equippedArmor; }
    public Potions getPotions() { return potions; }

    public void setEquippedWeapon(Weapon weapon) { equippedWeapon = weapon; }
    public void setEquippedArmor(Armor armor) { equippedArmor = armor; }

    public boolean hasPhoenixSoulstone() {
        return hasPhoenixSoulstone;
    }
    public void acquirePhoenixSoulstone() {
        hasPhoenixSoulstone = true;
    }
    public void usePhoenixSoulstone() {
        hasPhoenixSoulstone = false;
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
            return "\u001B[32m" + bar + "\u001B[0m"; // red color for HP
        } else {
            return bar;
        }
    }

    // --- Inventory Menu ---
    public void openInventory() {
        boolean exit = false;

        while (!exit) {

            // INVENTORY HEADER
            System.out.println("┌───────────────🧰 INVENTORY───────────────┐");

            System.out.println(" 💚 HP       : " +
                    generateBar(player.getHp(), player.getMaxHP(), true) + " " +
                    player.getHp() + "/" + player.getMaxHP());

            System.out.println(" 🔋 " + player.getEnergyName() + "     : " +
                    generateBar(player.getEnergy(), player.getMaxEnergy(), false) + " " +
                    player.getEnergy() + "/" + player.getMaxEnergy());

            // EQUIPPED ITEMS
            System.out.println(" 🗡️ Equipped Weapon : " +
                    (equippedWeapon != null ? equippedWeapon.getName() : "No Weapon Equipped"));

            System.out.println(" 🛡️ Equipped Armor  : " +
                    (equippedArmor != null ? equippedArmor.getName() : "No Armor Equipped"));

            // POTIONS
            System.out.println(" 🍃 Normal Healing Potion : " + potions.getNormalHealingPotions());
            System.out.println(" 💞 Full Healing Potion   : " + potions.getFullHealingPotions());
            System.out.println(" ⚡ Energy Potion          : " + potions.getEnergyPotions());
            System.out.println(" 💠 Soul Shards           : " + player.getSoulShards());

            System.out.println("└───────────────────────────────────────────┘");


            // MENU
            PrintUtil.line();
            System.out.println("[1] ⚔️ Show Weapon Info");
            System.out.println("[2] 🛡️ Show Armor Info");
            System.out.println("[3] 🍃 Use Normal Healing Potion");
            System.out.println("[4] 💞 Use Full Healing Potion");
            System.out.println("[5] ⚡  Use Energy Potion");
            System.out.println("[0] 🔙 Back");
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
            default -> { return; }
        }

        if (current >= max) {
            System.out.println("💡 Already full! No potion needed.");
            return;
        }

        if (available <= 0) {
            System.out.println("❌ No potions of this type left!");
            return;
        }

        int amount = 0;
        while (true) {
            System.out.println("You have " + available + " potion(s).");
            System.out.print("How many do you want to use? ");
            amount = InputUtil.scanInput();
            if (amount > 0 && amount <= available) break;
            System.out.println("❌ Invalid amount! Please enter between 1 and " + available);
        }

        if (!areYouSure()) {
            System.out.println("Potion not used.");
            return;
        }

        for (int i = 0; i < amount; i++) {
            switch (type) {
                case "normal" -> {
                    if (player.getHp() < player.getMaxHP()) potions.useNormalHealingPotion();
                    else { System.out.println("💡 HP is full. Remaining potions not used."); break; }
                }
                case "full" -> {
                    if (player.getHp() < player.getMaxHP()) potions.useFullHealingPotion();
                    else { System.out.println("💡 HP is full. Remaining potions not used."); break; }
                }
                case "energy" -> {
                    if (player.getEnergy() < player.getMaxEnergy()) potions.useEnergyPotion();
                    else { System.out.println("💡 Energy is full. Remaining potions not used."); break; }
                }
            }
        }
    }

    // --- Confirmation prompt ---
    private boolean areYouSure() {
        int confirm;
        do {
            System.out.println("Are you sure you want to use a potion? (1 = Yes, 0 = No)");
            confirm = InputUtil.scanInput();
            if (confirm == 1) break;
            else if (confirm == 0) break;
            else System.out.println("❌ Invalid input! Try again.");
        } while (true);
        return confirm == 1;
    }


}
