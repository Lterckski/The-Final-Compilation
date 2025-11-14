package enemies;

import characters.Character;
import utils.InputUtil;
import utils.PrintUtil;
import utils.RandomUtil;
import inventory.*;

public class World2Miniboss1 extends Enemy{
    public World2Miniboss1(){
        super("The Black Jailer", 646, 27, 120);
    }

    public void shacklingChains(Character target){
        System.out.println("⛓️ " + name + " used Shackling Chains!");
        PrintUtil.pause(800);
        if(target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        int damage = (int)RandomUtil.range(attack * 1.00, attack * 1.33);
        int reduced = calculateDamage(target, damage);

        System.out.println("→💔 Shackling Chains hits for " + reduced + " damage!");
        PrintUtil.pause(800);
        target.takeDamage(reduced);

        // Reflect damage check
        Armor equippedArmor = target.getInventory().getEquippedArmor();
        if (equippedArmor != null) {
            int reflectDamage = equippedArmor.checkReflectDamage(reduced);
            if (reflectDamage > 0) {
                System.out.println("🪞 " + equippedArmor.getName() + " reflected " + reflectDamage + " damage back to " + name + "!");
                PrintUtil.pause(800);
                this.takeDamage(reflectDamage);
            }
        }

        // 30% chance to apply Immobilize
        if (RandomUtil.chance(30)) {
            target.getEffects().applyImmobilize();
        }

    }

    public void tormentingLash(Character target){
        System.out.println("🩸 " + name + " lashes with Tormenting Lash!");
        PrintUtil.pause(800);
        if(target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        int damage = (int)RandomUtil.range(attack * 1.33, attack * 1.73);
        int reduced = calculateDamage(target, damage);

        System.out.println("→💔 Tormenting Lash hits for " + reduced + " damage!");
        PrintUtil.pause(800);
        target.takeDamage(reduced);

        // Reflect damage check
        Armor equippedArmor = target.getInventory().getEquippedArmor();
        if (equippedArmor != null) {
            int reflectDamage = equippedArmor.checkReflectDamage(reduced);
            if (reflectDamage > 0) {
                System.out.println("🪞 " + equippedArmor.getName() + " reflected " + reflectDamage + " damage back to " + name + "!");
                PrintUtil.pause(800);
                this.takeDamage(reflectDamage);
            }
        }

        // Bleed — check immunity
        if (equippedArmor != null && equippedArmor.checkEffectsImmunity()) {
            System.out.println("✨ " + target.getName() + " resisted Bleed 🩸 due to " + equippedArmor.getName() + "!");
            PrintUtil.pause(800);
        } else {
            target.getEffects().applyBleed(2);
        }
    }


    @Override
    public void displaySkills() {
        System.out.println("\n------- THE BLACK JAILER SKILLS -------");
        System.out.println("Skill 1 – Shackling Chains");
        System.out.println("Description: The Black Jailer swings his chains to bind and cripple his opponent.");
        System.out.println("Damage: (" + (int)(attack * 1.00) + " — " + (int)(attack * 1.33) + ")");
        System.out.println("Effects:");
        System.out.println("- 30% chance to Immobilize the target\n");

        System.out.println("Skill 2 – Tormenting Lash");
        System.out.println("Description: The Black Jailer lashes his whip, leaving his foe bleeding.");
        System.out.println("Damage: (" + (int)(attack * 1.33) + " — " + (int)(attack * 1.73) + ")");
        System.out.println("Effects:");
        System.out.println("- 30% chance to inflict Bleed for 2 turns");
        System.out.println("---------------------------------------");
    }

    @Override
    public void turn(Character target) {
        if (RandomUtil.chance(50)) shacklingChains(target);
        else tormentingLash(target);
    }

    @Override
    public void dropLoot(Character player){
        player.gainExp(rewardExp());
        player.getPotions().lootPotions();
        player.getPotions().lootFullHealthPotions();

        Armor aegisMail = Armor.AEGIS_MAIL;         // +25 DEF, immune to debuff ↓
        Armor vanguardRobe = Armor.VANGUARD_ROBE;   // +25 DEF, immune to status effects

        System.out.println("\n🎁 You obtained 2 Rare Armors!");
        PrintUtil.pause(800);

        System.out.println("1️⃣ " + aegisMail.getName() + " → +25 DEF 🛡️, immune to ATK⬇️ & DEF⬇️");
        PrintUtil.pause(800);
        System.out.println("2️⃣ " + vanguardRobe.getName() + " → +25 DEF 🛡️, immune to Poison ☠️, Burn 🔥, Bleed 🩸");
        PrintUtil.pause(800);
        System.out.print("\nChoose one to equip (1 or 2): ");

        int choice = InputUtil.scanInput();
        utils.InputUtil.scan.nextLine();

        if (choice == 1) {
            aegisMail.equip(player);
            System.out.println("\nThe other armor fades away...");
            PrintUtil.pause(800);
        } else if (choice == 2) {
            vanguardRobe.equip(player);
            System.out.println("\nThe other armor fades away...");
            PrintUtil.pause(800);
        } else {
            System.out.println("\n❌ Invalid choice! Both armors vanish into the mist...");
            PrintUtil.pause(800);
        }
    }

    @Override
    public int rewardExp(){
        return 1833;
    }
}
