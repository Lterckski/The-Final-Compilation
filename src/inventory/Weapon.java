package inventory;

import characters.Character;
import enemies.Enemy;
import utils.ColorUtil;
import utils.InputUtil;
import utils.PrintUtil;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;


public abstract class Weapon {
    private final String name;
    private final String rarity;
    private boolean isEquipped = false;
    private final int atkBuff;
    private int lifestealPercent = 0;

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
        System.out.println(ColorUtil.boldBrightYellow("🎁 Enemy has dropped a weapon!"));
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

        // Epic weapon transfer logic
        if(currentlyEquipped != null && this.getRarity().equals("🟣")) {
            if(!currentlyEquipped.getEnchantments().isEmpty()) {
                System.out.println("Do you want to transfer enchantments from your current weapon? (Cost: 💠 20 Soul Shards)");

                boolean validChoice = false;
                while (!validChoice) {
                    System.out.print("1 = Yes, 0 = No: ");
                    int choice = InputUtil.scanInput();

                    if(choice == 1) {
                        validChoice = true;
                        if(character.getSoulShards() >= 20) {
                            character.subtractSoulShards(20);
                            this.transferEnchantmentsFrom(currentlyEquipped);
                            System.out.println(ColorUtil.boldBrightYellow("✅ Enchantments transferred to " + this.getName() + "! (💠 -20 Soul Shards)"));
                        } else {
                            System.out.println(ColorUtil.boldBrightRed("❌ Not enough Soul Shards!"));
                        }
                    } else if(choice == 0) {
                        validChoice = true;
                        System.out.println(ColorUtil.boldBrightRed("❌ You chose not to transfer enchantments."));
                    } else {
                        System.out.println(ColorUtil.brightRed("❌ Invalid input! Try again."));
                    }
                }
            }
        }

        // Equip weapon normally
        if(currentlyEquipped != null){
            currentlyEquipped.unequip(character);
        }

        // Equip new weapon
        isEquipped = true;
        character.getInventory().setEquippedWeapon(this);

        // Recalculate attack based on baseAttack + weapon buffs
        character.recalculateBuffs();

        // Calculate actual ATK increase for message
        int atkIncrease = (currentlyEquipped != null) ?
                (character.getWeapon().getAtkBuff() - currentlyEquipped.getAtkBuff())
                : character.getWeapon().getAtkBuff();

        System.out.println(ColorUtil.boldBrightYellow(
                "⚙\uFE0F " + this.getName() + " Equipped! ⬆\uFE0F Attack increased by " + atkIncrease +
                        ". ⚔\uFE0F Current ATK: " + character.getAttack()
        ));

        PrintUtil.line();
        PrintUtil.pause(800);
    }


    public void unequip(Character character) {
        character.setAttack(character.getAttack() - atkBuff);
        isEquipped = false;
    }

    public void transferEnchantmentsFrom(Weapon oldWeapon) {
        // Transfer all enchantments
        for (Map.Entry<String, String> enchant : oldWeapon.getEnchantments().entrySet()) {
            // Add the enchantment to this weapon
            this.addEnchantment(enchant.getKey(), enchant.getValue());
        }

        // Transfer any stats that are stored per weapon
        this.setAddLifestealPercent(this.getAddLifestealPercent() + oldWeapon.getAddLifestealPercent());
        this.setPoisonChance(this.getPoisonChance() + oldWeapon.getPoisonChance());
        this.setBleedChance(this.getBleedChance() + oldWeapon.getBleedChance());
        this.setStunChance(this.getStunChance() + oldWeapon.getStunChance());
        this.setFreezeChance(this.getFreezeChance() + oldWeapon.getFreezeChance());
        this.setEnergyPerAttack(this.getEnergyPerAttack() + oldWeapon.getEnergyPerAttack());
    }


}
