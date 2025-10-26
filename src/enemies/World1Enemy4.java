package enemies;

import characters.Character;
import inventory.Armor;
import utils.RandomUtil;

public class World1Enemy4 extends Enemy {
    // Constructor
    public World1Enemy4() {
        super("Carrion Bats", 91, 8, 6);
    }

    // Skill: Screech (6–8 damage, chance to confuse 1 turn)
    public void screech(Character target) {
        System.out.println("🦇 " + name + " screeches loudly at the target!");
        if (target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        int damage = (int) RandomUtil.range(attack * 1.0, attack * 1.33);
        int reduced = calculateDamage(target, damage);

        System.out.println("→💔 Screech hits for " + reduced + " damage!");
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

        // 30% chance to apply Weaken (ATK debuff 20% for 2 turns) — check debuff immunity first
        if (RandomUtil.chance(30)) {
            if (equippedArmor != null && equippedArmor.checkDebuffImmunity()) {
                System.out.println("✨ " + target.getName() + " resisted Weaken 💢 due to " + equippedArmor.getName() + "!");
            } else {
                target.getEffects().applyAttackDebuff(20, 2);
            }
        }
    }

    @Override
    public void displaySkills(){
        System.out.println("\n------- CARRION BATS SKILLS -------");
        System.out.println("Skill – Screech");
        System.out.println("Description: The bats emit a piercing screech, unsettling their foe and lowering their attack.");
        System.out.println("Damage: (" + (int)(attack * 1.00) + " — " + (int)(attack * 1.33) + ")");
        System.out.println("Effects:");
        System.out.println("- 30% chance to apply Weaken: reduces target’s ATK by 20% for 2 turns");
        System.out.println("-----------------------------------");
    }

    @Override
    public void turn(Character target) {
        screech(target);
    }

    @Override
    public void dropLoot(Character player){
        player.getPotions().lootPotions();
    }

    @Override
    public int rewardExp(){
        return RandomUtil.range(37,40);
    }
}
