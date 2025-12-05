package inventory;

import characters.Character;
import enemies.Enemy;
import utils.ColorUtil;
import utils.InputUtil;
import utils.PrintUtil;

import java.util.HashMap;
import java.util.Map;


public abstract class Weapon {
    private final String name;
    private final String rarity;
    private boolean isEquipped = false;
    private final int atkBuff;
    private int lifestealPercent = 0;

    private int addAtkBuff = 0;
    private int addLifestealPercent = 0;

    private int poisonChance = 0;
    private int bleedChance = 0;
    private int stunChance = 0;
    private int freezeChance = 0;
    private int energyPerAttack = 0;

    private final Map<String, String> enchantments = new HashMap<>();

    public Weapon(String name, String rarity, int atkBuff){
        this.name = name;
        this.rarity = rarity;
        this.atkBuff = atkBuff;
    }

    public String getName() { return name; }
    public String getRarity() { return rarity; }
    public int getAtkBuff() { return atkBuff; }

    public int getPoisonChance() {
        return poisonChance;
    }

    public void setPoisonChance(int poisonChance) {
        this.poisonChance = poisonChance;
    }

    public int getBleedChance() {
        return bleedChance;
    }

    public void setBleedChance(int bleedChance) {
        this.bleedChance = bleedChance;
    }

    public int getStunChance() {
        return stunChance;
    }

    public void setStunChance(int stunChance) {
        this.stunChance = stunChance;
    }

    public int getFreezeChance() {
        return freezeChance;
    }

    public void setFreezeChance(int freezeChance) {
        this.freezeChance = freezeChance;
    }

    public int getEnergyPerAttack() {
        return energyPerAttack;
    }

    public void setEnergyPerAttack(int energyPerAttack) {
        this.energyPerAttack = energyPerAttack;
    }

    public int getLifestealPercent() {
        return lifestealPercent;
    }

    public void setLifestealPercent(int lifestealPercent) {
        this.lifestealPercent = lifestealPercent;
    }

    public void addEnchantment(String name, String description) {
        enchantments.put(name, description);
    }

    public int getAddLifestealPercent() {
        return addLifestealPercent;
    }

    public void setAddLifestealPercent(int addLifestealPercent) {
        this.addLifestealPercent = addLifestealPercent;
    }

    public int getAddAtkBuff() {
        return addAtkBuff;
    }

    public void setAddAtkBuff(int addAtkBuff) {
        this.addAtkBuff = addAtkBuff;
    }

    public Map<String, String> getEnchantments() {
        return enchantments;
    }

    public String getWeaponEmoji(Character player) {
        String classType = player.getClassType();

        return switch (classType) {
            case "Swordsman" -> "🗡️";
            case "Archer" -> "🏹";
            case "Mage" -> "🔮";
            default -> "⚔️"; // default weapon emoji
        };
    }

    public abstract void applyEffects(Character player, Character enemy, int damage);
    public abstract void displayInfo();

    public boolean lootWeapon() {
        System.out.println(ColorUtil.boldBrightYellow("\n🎁 Enemy has dropped a weapon!"));
        PrintUtil.pause(800);
        this.displayInfo();

        boolean pickUp = false;
        boolean validChoice;

        do {
            validChoice = true;
            System.out.print("Do you want to pick it up? (1 = Yes, 0 = No): ");
            int choice = InputUtil.scanInput();

            if (choice == 1) {
                pickUp = true;
            } else if (choice == 0) {
                // Confirm ignoring the weapon
                boolean validConfirm = true;
                do {
                    System.out.print("Are you sure you want to ignore the weapon? (1 = Yes, 0 = No): ");
                    int confirm = InputUtil.scanInput();

                    if (confirm == 1) {
                        System.out.println(ColorUtil.boldBrightRed("You ignored the weapon..."));
                    } else if (confirm == 0) {
                        validChoice = false; // go back to pick up question
                    } else {
                        System.out.println(ColorUtil.boldBrightRed("❌ Invalid input! Try again."));
                        validConfirm = false;
                    }
                } while (!validConfirm);

            } else {
                System.out.println(ColorUtil.boldBrightRed("❌ Invalid input! Try again."));
                validChoice = false;
            }

        } while (!validChoice);

        return pickUp;
    }

    public void equip(Character character) {
        Weapon currentlyEquipped = character.getInventory().getEquippedWeapon();

        PrintUtil.line();

        if(currentlyEquipped == null){
            character.setAttack(character.getAttack() + atkBuff);
            isEquipped = true;
            character.getInventory().setEquippedWeapon(this);
            System.out.println(ColorUtil.boldBrightYellow("⚙\uFE0F " + name + " Equipped! ⬆\uFE0F Attack increased by " + atkBuff + ". ⚔\uFE0F Current ATK: " + character.getAttack()));
        } else{
            currentlyEquipped.unequip(character);

            character.setAttack(character.getAttack() + atkBuff);
            isEquipped = true;
            character.getInventory().setEquippedWeapon(this);

            System.out.println("You upgraded your weapon!");
            PrintUtil.pause(800);
            System.out.println(ColorUtil.boldBrightYellow("⚙\uFE0F " + name + " Equipped! ⬆\uFE0F Attack increased by " + (this.getAtkBuff() - currentlyEquipped.getAtkBuff()) + ". ⚔\uFE0F Current ATK: " + character.getAttack()));
        }
        PrintUtil.line();
        PrintUtil.pause(800);
    }

    public void unequip(Character character) {
        character.setAttack(character.getAttack() - atkBuff);
        isEquipped = false;
    }

}
