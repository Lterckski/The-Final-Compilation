package enemies;


import characters.Character;
import utils.RandomUtil;
import inventory.*;

public class World2Enemy1 extends Enemy{
    public World2Enemy1(){
        super("Plague Vermin", 243, 13, 14);
    }

    public void plagueBite(Character target){
        System.out.println("🐀 " + name + " used Plague Bite!");
        if(target.getEffects().checkDodge()) return;

        int damage = (int)RandomUtil.range(attack * 1.00, attack * 1.55);
        int reduced = damage - target.getDefense();
        if(reduced < 0) reduced = 0;

        System.out.println("→ Plague Bite hits for " + reduced + " damage!");
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

        // Poison effect with immunity check
        if (equippedArmor != null && equippedArmor.checkEffectsImmunity()) {
            System.out.println("✨ " + target.getName() + " resisted Poison ☠️ due to " + equippedArmor.getName() + "!");
        } else {
            target.getEffects().applyPoison(1);
        }
    }

    @Override
    public void showSkills() {
        System.out.println("\n------- PLAGUE VERMIN SKILLS -------");
        System.out.println("Skill – Plague Bite");
        System.out.println("Description: The Plague Vermin bites viciously, infecting its target with deadly poison.");
        System.out.println("Damage: (" + (int)(attack * 1.00) + " — " + (int)(attack * 1.55) + ")");
        System.out.println("Effects:");
        System.out.println("- Applies Poison for 1 turn");
        System.out.println("------------------------------------");
    }

    @Override
    public void turn(Character target) {
        plagueBite(target);
    }

    @Override
    public void dropLoot(Character player){
        player.getPotions().lootPotions();
    }

}
