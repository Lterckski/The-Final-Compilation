package inventory;

import characters.Character;
import utils.InputUtil;

public class Inventory {

    private Weapon equippedWeapon;
    private Armor equippedArmor;
    private final Potions potions;

    public Inventory(Character owner) {
        this.potions = new Potions(owner);
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
            System.out.println("\n====================== Inventory ======================");
            System.out.println("Equipped Weapon         : " + (equippedWeapon != null ? equippedWeapon.getName() : "None"));
            System.out.println("Equipped Armor          : " + (equippedArmor != null ? equippedArmor.getName() : "None"));
            System.out.println("Normal Healing Potion   : " + potions.getNormalHealingPotions());
            System.out.println("Full Healing Potion     : " + potions.getFullHealingPotions());
            System.out.println("Energy Potion           : " + potions.getEnergyPotions());
            System.out.println("=======================================================");
            System.out.println("(1) Show Weapon Info");
            System.out.println("(2) Show Armor Info");
            System.out.println("(3) Use Normal Healing Potion");
            System.out.println("(4) Use Full Healing Potion");
            System.out.println("(5) Use Energy Potion");
            System.out.println("(6) Back");
            System.out.print("Choose an option: ");

            int choice = InputUtil.scan.nextInt();
            InputUtil.scan.nextLine();

            switch (choice) {
                case 1 -> {
                    if (equippedWeapon != null) equippedWeapon.displayInfo();
                    else System.out.println("No weapon equipped.");
                }
                case 2 -> {
                    if (equippedArmor != null) equippedArmor.displayInfo();
                    else System.out.println("No armor equipped.");
                }
                case 3 -> {
                    if (potions.getNormalHealingPotions() > 0) {
                        if (areYouSure()) potions.useNormalHealingPotion();
                    } else System.out.println("❌ No normal healing potions left!");
                }
                case 4 -> {
                    if (potions.getFullHealingPotions() > 0) {
                        if (areYouSure()) potions.useFullHealingPotion();
                    } else System.out.println("❌ No full healing potions left!");
                }
                case 5 -> {
                    if (potions.getEnergyPotions() > 0) {
                        if (areYouSure()) potions.useEnergyPotion();
                    } else System.out.println("❌ No energy potions left!");
                }
                case 6 -> exit = true;
                default -> System.out.println("❌ Invalid input! Try again.");
            }
        }
    }

    // --- Confirmation prompt ---
    private boolean areYouSure() {
        int confirm;

        do {
            System.out.println("Are you sure you want to use a potion? (1 = Yes, 0 = No)");
            confirm = InputUtil.scan.nextInt();
            InputUtil.scan.nextLine();

            if (confirm == 1) {
                break;
            } else if (confirm == 0) {
                System.out.println("Potion not used.");
            } else {
                System.out.println("❌ Invalid input! Try again.");
            }
        } while (confirm != 0);

        return confirm == 1;
    }
}
