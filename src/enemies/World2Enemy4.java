package enemies;

import characters.Character;
import utils.PrintUtil;
import utils.RandomUtil;
import inventory.*;

public class World2Enemy4 extends Enemy{
    public World2Enemy4(){
        super("Ghoul Footmen", 369, 18, 60);
    }

    public void rottenCleave(Character target){
        System.out.println("🧟 " + name + " swings Rotten Cleave!");
        PrintUtil.pause(800);
        if(target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        int damage = (int)RandomUtil.range(attack * 1.00 , attack * 1.30);
        int reduced = calculateDamage(target, damage);

        System.out.println("→💔 Rotten Cleave hits for " + reduced + " damage!");
        PrintUtil.pause(800);
        target.takeDamage(reduced);

        // Reflect check
        Armor equippedArmor = target.getInventory().getEquippedArmor();
        if (equippedArmor != null) {
            int reflectDamage = equippedArmor.checkReflectDamage(reduced);
            if (reflectDamage > 0) {
                System.out.println("🪞 " + equippedArmor.getName() + " reflected " + reflectDamage + " damage back to " + name + "!");
                PrintUtil.pause(800);
                this.takeDamage(reflectDamage);
            }
        }
        // 30% chance to apply Bleed — check armor immunity first
        if (RandomUtil.chance(30)) {
            if (equippedArmor != null && equippedArmor.checkEffectsImmunity()) {
                System.out.println("✨ " + target.getName() + " resisted Bleed 🩸 due to " + equippedArmor.getName() + "!");
                PrintUtil.pause(800);
            } else {
                target.getEffects().applyBleed(2);
            }
        }
    }


    @Override
    public void displaySkills() {
        System.out.println();
        System.out.println("┌─────────────────────────────── 🧟‍♂️ GHOUL FOOTMEN SKILLS 🧟‍♂️ ────────────────────────────────┐");
        System.out.println(" ⚔️ Skill       : Rotten Cleave");
        System.out.println(" 📝 Description : The Ghoul Footman slashes with a putrid blade, spreading disease and pain.");
        System.out.println(" 💥 Damage     : (" + (int)(attack * 1.00) + " — " + (int)(attack * 1.30) + ")");
        System.out.println(" ✨ Effects    :");
        System.out.println(" - 🩸 30% chance to inflict Bleed for 2 turns");
        System.out.println("└────────────────────────────────────────────────────────────────────────────────────────────┘");
        System.out.println();
    }



    @Override
    public void turn(Character target) {
        rottenCleave(target);
    }

    @Override
    public void dropLoot(Character player){
        PrintUtil.pause(800);
        System.out.println("┬───────────────────────────────────┬");
        System.out.println("  🎁 You received:");
        player.lootSoulShards(RandomUtil.range(2,3));
        player.getPotions().lootPotions(false);
        player.gainExp(rewardExp());
    }

    @Override
    public int rewardExp(){
        return RandomUtil.range(304,311);
    }
}
