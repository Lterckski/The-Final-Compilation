package enemies;


import characters.Character;
import utils.PrintUtil;
import utils.RandomUtil;
import inventory.*;

public class World2Enemy2 extends Enemy{
    public World2Enemy2(){
        super("Forsaken Cultist", 279, 27, 50);
    }

    public void shadowBolt(Character target){
        System.out.println("🕯️ " + name + " casts Shadow Bolt!");
        PrintUtil.pause(800);
        if(target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        int damage = (int)RandomUtil.range(attack * 1.00, attack * 1.55);
        int reduced = calculateDamage(target, damage);

        System.out.println("→💔 Shadow Bolt hits for " + reduced + " damage!");
        PrintUtil.pause(800);
        target.takeDamage(reduced);

        //Reflect check
        Armor equippedArmor = target.getInventory().getEquippedArmor();
        if (equippedArmor != null) {
            int reflectDamage = equippedArmor.checkReflectDamage(reduced);
            if (reflectDamage > 0) {
                System.out.println("🪞 " + equippedArmor.getName() + " reflected " + reflectDamage + " damage back to " + name + "!");
                PrintUtil.pause(800);
                this.takeDamage(reflectDamage);
            }
        }

        // 30% chance to apply ATK debuff (check immunity first)
        if (RandomUtil.chance(30)) {
            if (equippedArmor != null && equippedArmor.checkEffectsImmunity()) {
                System.out.println("✨ " + target.getName() + " resisted Weaken 🪫 due to " + equippedArmor.getName() + "!");
                PrintUtil.pause(800);
            } else {
                target.getEffects().applyAttackDebuff(20, 2);
            }
        }
    }

    @Override
    public void displaySkills() {
        System.out.println("\n------- FORSAKEN CULTISTS SKILLS -------");
        System.out.println("Skill – Shadow Bolt");
        System.out.println("Description: Cultists hurl dark bolts of energy, weakening their foe.");
        System.out.println("Damage: (" + (int)(attack * 1.00) + " — " + (int)(attack * 1.33) + ")");
        System.out.println("Effects:");
        System.out.println("- 30% chance to apply Weaken: reduces target’s ATK by 20% for 2 turns");
        System.out.println("----------------------------------------");
    }

    @Override
    public void turn(Character target) {
        shadowBolt(target);
    }

    @Override
    public void dropLoot(Character player){
        player.gainExp(rewardExp());
        player.getPotions().lootPotions();
    }

    @Override
    public int rewardExp(){
        return RandomUtil.range(34,36);
    }
}
