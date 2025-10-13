package inventory;

import characters.Character;

public class Inventory {
    private final Character owner;

    private Weapon equippedWeapon;
    private Armor equippedArmor;

    public Inventory(Character owner) {
        this.owner = owner;
    }

    public Weapon getEquippedWeapon(){ return equippedWeapon; }
    public Armor getEquippedArmor(){ return equippedArmor; }

    public void setEquippedWeapon(Weapon weapon){ equippedWeapon = weapon; }
    public void setEquippedArmor(Armor armor){ equippedArmor = armor; }

    public void openInventory() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n====================== Inventory ======================");
            System.out.println("Equipped Weapon         : " + owner.getInventory().getEquippedWeapon().getName());
            System.out.println("Equipped Armor          : " + owner.getInventory().getEquippedArmor().getName());
            System.out.println("Normal Healing Potion   : " + owner.getPotions().getNormalHealingPotions());
            System.out.println("Full Healing Potion     : " + owner.getPotions().getFullHealingPotions());
            System.out.println("Energy Potion           : " + owner.getPotions().getEnergyPotions());
            System.out.println("=======================================================");
            System.out.println("(1) Show Weapon Info");
            System.out.println("(2) Show Armor Info");
            System.out.println("(3) Use Normal Healing Potion");
            System.out.println("(4) Use Full Healing Potion");
            System.out.println("(5) Use Energy Potion");
            System.out.println("(6) Back");
            System.out.print("Choose an option: ");

            int choice = utils.InputUtil.scan.nextInt();
            utils.InputUtil.scan.nextLine();

            switch (choice) {
                case 1 -> {
                    if(equippedWeapon != null) equippedWeapon.displayInfo();
                    else System.out.println("No weapon equipped.");
                }
                case 2 -> {
                    if(equippedArmor != null) equippedArmor.displayInfo();
                    else System.out.println("No armor equipped.");
                }
                case 3 -> {
                    if (owner.getPotions().getNormalHealingPotions() > 0) {
                        if (areYouSure()) owner.getPotions().useNormalHealingPotion();
                    } else {
                        System.out.println("❌ No normal healing potions left!");
                    }
                }
                case 4 -> {
                    if (owner.getPotions().getFullHealingPotions() > 0) {
                        if (areYouSure()) owner.getPotions().useFullHealingPotion();
                    } else {
                        System.out.println("❌ No full healing potions left!");
                    }
                }
                case 5 -> {
                    if (owner.getPotions().getEnergyPotions() > 0) {
                        if (areYouSure()) owner.getPotions().useEnergyPotion();
                    } else {
                        System.out.println("❌ No energy potions left!");
                    }
                }
                case 6 -> exit = true;
                default -> System.out.println("❌ Invalid input! Try again.");
            }
        }
    }


    private boolean areYouSure(){
        int confirm;

        do {
            System.out.println("Are you sure you want to use a potion? (1 = Yes, 0 = No)");
            confirm = utils.InputUtil.scan.nextInt();
            utils.InputUtil.scan.nextLine();

            if (confirm == 1) {
                break;
            } else if (confirm == 0) {
                System.out.println("Potion not used.");
            } else {
                System.out.println("❌ Invalid input! Try again.");
            }
        } while(confirm != 0);

        return confirm == 1;
    }
}
