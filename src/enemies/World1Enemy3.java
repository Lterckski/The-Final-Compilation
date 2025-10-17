package enemies;

import characters.Character;
import inventory.Armor;
import utils.RandomUtil;

public class World1Enemy3 extends Enemy {
    // Constructor
    public World1Enemy3() {
        super("Dreadbark Treants", 79, 7, 6); // HP = 79, DEF = 7
    }

    // Skill: Root Snare (6–9 damage, immobilize 1 turn)
    public void rootSnare(Character target) {
        System.out.println("🌳 " + name + " strikes with Root Snare!");
        if (target.getEffects().checkDodge()) return;

        int damage = (int) RandomUtil.range(attack * 1.0, attack * 1.5);
        int reduced = damage - target.getDefense();
        if (reduced < 0) reduced = 0;

        System.out.println("→ Root Snare hits for " + reduced + " damage!");
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

        // 30% chance to Immobilize
        if (RandomUtil.chance(30)) {
            target.getEffects().applyImmobilize();
        }

    }

    @Override
    public void showSkills(){
        System.out.println("\n------- DREADBARK TREANTS SKILLS -------");
        System.out.println("Skill – Root Snare");
        System.out.println("Description: The Treants lash out with entangling roots, trying to trap their foe.");
        System.out.println("Damage: (" + (int)(attack * 1.00) + " — " + (int)(attack * 1.50) + ")");
        System.out.println("Effects:");
        System.out.println("- 30% chance to Immobilize target");
        System.out.println("----------------------------------------");
    }

    @Override
    public void turn(Character target) {
        rootSnare(target);
    }

    @Override
    public void dropLoot(Character player){
        player.getPotions().lootPotions();
    }

}
