package enemies;

import characters.Character;
import inventory.Armor;
import utils.RandomUtil;

public class World1Enemy2 extends Enemy {
    // Constructor
    public World1Enemy2() {
        super("Shade Sprites", 69, 6, 8); // HP = 69, DEF = 6
    }

    // Skill: Trickster Strike (8–13 damage)
    public void tricksterStrike(Character target) {
        System.out.println("🧚 " + name + " attacks with Trickster Strike!");
        if (target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        int damage = (int) RandomUtil.range(attack * 1.0, attack * 1.625);
        int reduced = calculateDamage(target, damage);

        System.out.println("→💔 Trickster Strike hits for " + reduced + " damage!");
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

        target.getEffects().applyConfuse();

    }

    @Override
    public void displaySkills(){
        System.out.println("\n------- SHADE SPRITES SKILLS -------");
        System.out.println("Skill – Trickster Strike");
        System.out.println("Description: The Shade Sprites strike mischievously, leaving their target disoriented.");
        System.out.println("Damage: (" + (int)(attack * 1.00) + " — " + (int)(attack * 1.625) + ")");
        System.out.println("Effects:");
        System.out.println("- Applies Confuse to target");
        System.out.println("------------------------------------");
    }

    @Override
    public void turn(Character target) {
        tricksterStrike(target);
    }

    @Override
    public void dropLoot(Character player){
        player.getPotions().lootPotions();
    }
    @Override
    public int rewardExp(){
        return RandomUtil.range(38,40);
    }
}
