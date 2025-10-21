package enemies;

import characters.Character;
import inventory.Armor;
import inventory.Bow;
import inventory.Staff;
import inventory.Sword;
import utils.RandomUtil;

public class World1Miniboss1 extends Enemy {
    // Constructor
    public World1Miniboss1() {
        super("The Hollow Stag", 211, 13, 47); // HP = 211, DEF = 13, ATK = 47
    }

    // Skill 1: Deathly Charge (ATK × 1.00–1.20), 30% chance to Stun
    public void deathlyCharge(Character target) {
        System.out.println("🦌 " + name + " charges with Deathly Charge!");
        if (target.getEffects().checkDodge()) return;

        int damage = (int) RandomUtil.range(attack * 1.00, attack * 1.20);
        int reduced = damage - target.getDefense();
        if (reduced < 0) reduced = 0;

        System.out.println("→💔 Deathly Charge hits for " + reduced + " damage!");
        target.takeDamage(reduced);

        // Armor reflect check
        Armor equippedArmor = target.getInventory().getEquippedArmor();
        if (equippedArmor != null) {
            int reflectDamage = equippedArmor.checkReflectDamage(reduced);
            if (reflectDamage > 0) {
                System.out.println("🪞 " + equippedArmor.getName() + " reflected " + reflectDamage + " damage back to " + name + "!");
                this.takeDamage(reflectDamage);
            }
        }

        // 30% chance to stun
        if (RandomUtil.chance(30)) {
            target.getEffects().applyStun();
        }

    }

    // Skill 2: Blackened Howl (reduces target DEF by 20% for 2 turns)
    public void blackenedHowl(Character target) {
        System.out.println("🗣️ " + name + " unleashes Blackened Howl!");
        if (target.getEffects().checkDodge()) return;

        Armor equippedArmor = target.getInventory().getEquippedArmor();
        if (equippedArmor != null && equippedArmor.checkDebuffImmunity()) {
            System.out.println("✨ " + target.getName() + " resisted Fragile 🛡️↓ due to " + equippedArmor.getName() + "!");
        } else {
            target.getEffects().applyDefenseDebuff(20, 2);
        }
    }

    @Override
    public void displaySkills() {
        System.out.println("\n------- THE HOLLOW STAG SKILLS -------");
        System.out.println("Skill 1 – Deathly Charge");
        System.out.println("Description: The Hollow Stag charges with deadly force, attempting to stun its foe.");
        System.out.println("Damage: (" + (int)(attack * 1.00) + " — " + (int)(attack * 1.20) + ")");
        System.out.println("Effects:");
        System.out.println("- 30% chance to Stun the target\n");

        System.out.println("Skill 2 – Blackened Howl");
        System.out.println("Description: The stag lets out a blackened howl, weakening its opponent's defenses.");
        System.out.println("Damage: —");
        System.out.println("Effects:");
        System.out.println("- Reduces target’s DEF by 20% for 2 turns");
        System.out.println("--------------------------------------");
    }

    @Override
    public void turn(Character target) {
        // Prioritize debuff if not active, else use main attack
        if (!target.getEffects().hasDefDebuff()) {
            blackenedHowl(target);
        } else {
            deathlyCharge(target);
        }
    }

    @Override
    public void dropLoot(Character player) {
        player.getPotions().lootPotions();
        player.getPotions().lootFullHealthPotions();

        System.out.println("\n🎁 You obtained a Common Weapon!");
        if (player.getClassType().equals("Swordsman")) {
            Sword ironShortsword = Sword.IRON_SHORTSWORD;
            if (ironShortsword.lootWeapon()) {
                ironShortsword.equip(player);
            }
        } else if (player.getClassType().equals("Bow")) {
            Bow oakLongbow = Bow.OAK_LONGBOW;
            if (oakLongbow.lootWeapon()) {
                oakLongbow.equip(player);
            }
        } else if (player.getClassType().equals("Mage")) {
            Staff apprenticeStaff = Staff.APPRENTICE_STAFF;
            if (apprenticeStaff.lootWeapon()) {
                apprenticeStaff.equip(player);
            }
        }

        System.out.println("\n🎁 You obtained a Common Armor!");
        Armor ironVanguard = Armor.IRON_VANGUARD;
        if (ironVanguard.lootArmor()) {
            ironVanguard.equip(player);
        }
    }
    @Override
    public int rewardExp(){return 616;}
}
