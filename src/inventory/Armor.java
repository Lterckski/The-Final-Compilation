package inventory;

import characters.Character;
import utils.RandomUtil;

public class Armor {
    private final String name;
    private final String rarity;
    private boolean isEquipped = false;

    private final int defBuff;

    private final boolean immuneDebuff;
    private final boolean immuneEffects;
    private final int reflectChance;
    private final int reflectPercent;

    public static final Armor LEATHER_GUARD = new Armor("Leather Guard", "⚪", 0, false, false, 0 ,0);
    public static final Armor IRON_VANGUARD = new Armor("Iron Vanguard", "🟢", 10, false, false, 0 ,0);
    public static final Armor AEGIS_MAIL = new Armor("Aegis Mail", "🔵", 25,true, false,0, 0);
    public static final Armor VANGUARD_ROBE = new Armor("Vanguard Robe", "🟣", 25, false, true, 0,0);
    public static final Armor SKYFORGE_PLATE = new Armor("Skyforge Plate", "🟣", 40, true, true , 20, 15);
    public static final Armor CELESTIAL_BATTLEGEAR = new Armor("Celestial Battlegear", "🟡", 50, true, true, 20 ,15);

    public Armor(String name, String rarity, int defBuff, boolean immuneDebuff, boolean immuneEffects, int reflectChance, int reflectPercent){
        this.name = name;
        this.rarity = rarity;
        this.defBuff = defBuff;
        this.immuneDebuff = immuneDebuff;
        this.immuneEffects = immuneEffects;
        this.reflectChance = reflectChance;
        this.reflectPercent = reflectPercent;
    }

    public String getName() { return name; }
    public int getDefBuff(){ return defBuff; }

    public boolean lootArmor() {
        System.out.println("Target has dropped an armor!");
        this.displayInfo();

        boolean pickUp = false;
        boolean validChoice;

        do {
            validChoice = true;
            System.out.println("Do you want to pick it up? (1 = Yes, 0 = No)");
            int choice = utils.InputUtil.scan.nextInt();
            utils.InputUtil.scan.nextLine();

            if (choice == 1) {
                pickUp = true;
            } else if (choice == 0) {

                boolean validConfirm  = true;
                do {
                    System.out.println("Are you sure you want to ignore the armor? (1 = Yes, 0 = No)");
                    int confirm = utils.InputUtil.scan.nextInt();
                    utils.InputUtil.scan.nextLine();

                    if (confirm == 1) {
                        System.out.println("You ignored the armor.");
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
        Armor currentlyEquipped = character.getInventory().getEquippedArmor();

        System.out.println("-----------------------------");

        if (currentlyEquipped == null) {
            character.setDefense(character.getDefense() + defBuff);
            isEquipped = true;
            character.getInventory().setEquippedArmor(this);
            System.out.println(name + " Equipped! Defense increased by " + defBuff +
                    ". Current DEF: " + character.getDefense());
        } else {
            currentlyEquipped.unequip(character);

            character.setDefense(character.getDefense() + defBuff);
            isEquipped = true;
            character.getInventory().setEquippedArmor(this);

            System.out.println("You upgraded your armor!");
            System.out.println(name + " Equipped! Defense increased by " +
                    (this.defBuff - currentlyEquipped.defBuff) +
                    ". Current DEF: " + character.getDefense());
        }
        System.out.println("-----------------------------");
    }


    public void unequip(Character character) {
        character.setDefense(character.getDefense() - defBuff);
        isEquipped = false;
    }

    public void displayInfo() {
        System.out.println("-----------------------------");
        System.out.println("🛡️ " + name + " [" + rarity + "]");
        System.out.println("+ " + defBuff + " DEF");

        // Immunities
        if(immuneDebuff) {
            System.out.println("✨ Immune to: (ATK ↓)⚔️ & (DEF ↓)🛡️ Debuffs");
        }
        if (immuneEffects) {
            System.out.println("✨ Immune to: Poison☠️, Burn🔥, and Bleed🩸");
        }

        if (reflectChance > 0) {
            System.out.println("🛡️ " + reflectChance + "% chance to reflect " + reflectPercent + "% damage back to attacker");
        }

        System.out.println("-----------------------------");
    }

    public boolean checkDebuffImmunity(){
        return immuneDebuff;
    }

    public boolean checkEffectsImmunity(){
        return immuneEffects;
    }

    public int checkReflectDamage(int damage){
        int reflectDamage = 0;

        if(RandomUtil.chance(reflectChance)){
            reflectDamage = (int) (damage * (reflectPercent / 100.0));
        }

        return reflectDamage;
    }
}
