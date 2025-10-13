package inventory;

import characters.Character;
import utils.InputUtil;

public abstract class Weapon {
    private final String name;
    private final String rarity;
    private boolean isEquipped = false;
    private final int atkBuff;

    public Weapon(String name, String rarity, int atkBuff){
        this.name = name;
        this.rarity = rarity;
        this.atkBuff = atkBuff;
    }

    public String getName() { return name; }
    public String getRarity() { return rarity; }
    public int getAtkBuff() { return atkBuff; }

    public abstract void displayInfo();
    public abstract boolean applyEffects(Character target, int damage);

    public boolean lootWeapon() {
        System.out.println("Target has dropped a weapon!");
        this.displayInfo();

        boolean pickUp = false;
        boolean validChoice;

        do {
            validChoice = true;
            System.out.println("Do you want to pick it up? (1 = Yes, 0 = No)");
            int choice = InputUtil.scan.nextInt();
            InputUtil.scan.nextLine();

            if (choice == 1) {
                pickUp = true;
            } else if (choice == 0) {
                // Confirm ignoring the weapon
                boolean validConfirm = true;
                do {
                    System.out.println("Are you sure you want to ignore the weapon? (1 = Yes, 0 = No)");
                    int confirm = InputUtil.scan.nextInt();
                    InputUtil.scan.nextLine();

                    if (confirm == 1) {
                        System.out.println("You ignored the weapon.");
                    } else if (confirm == 0) {
                        validChoice = false; // go back to pick up question
                    } else {
                        System.out.println("❌ Invalid input! Try again.");
                        validConfirm = false;
                    }
                } while (!validConfirm);

            } else {
                System.out.println("❌ Invalid input! Try again.");
                validChoice = false;
            }

        } while (!validChoice);

        return pickUp;
    }

    public void equip(Character character) {
        Weapon currentlyEquipped = character.getInventory().getEquippedWeapon();

        System.out.println("-----------------------------");

        if(currentlyEquipped == null){
            character.setAttack(character.getAttack() + atkBuff);
            isEquipped = true;
            character.getInventory().setEquippedWeapon(this);
            System.out.println(name + " Equipped! Attack increased by " + atkBuff +
                    ". Current ATK: " + character.getAttack());
        } else{
            currentlyEquipped.unequip(character);

            character.setAttack(character.getAttack() + atkBuff);
            isEquipped = true;
            character.getInventory().setEquippedWeapon(this);

            System.out.println("You upgraded your weapon!");
            System.out.println(name + " Equipped! Attack increased by " + (this.getAtkBuff() - currentlyEquipped.getAtkBuff()) +
                    ". Current ATK: " + character.getAttack());
        }
        System.out.println("-----------------------------");
    }

    public void unequip(Character character) {
        character.setAttack(character.getAttack() - atkBuff);
        isEquipped = false;
    }

}
