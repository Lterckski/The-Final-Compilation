package enemies;

import characters.Character;
import inventory.Armor;
import utils.PrintUtil;
import utils.RandomUtil;

public class World3Enemy2 extends Enemy {

    public World3Enemy2() { super("Bone Warlock", 1129, 48, 85); }

    public void shadowBolt(Character target) {
        System.out.println("💀 " + name + " casts Shadow Bolt!");
        PrintUtil.pause(800);
        if (target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        int damage = (int) RandomUtil.range(attack * 1.00, attack * 1.25);
        int reduced = calculateDamage(target, damage);

        System.out.println("→💔 Shadow Bolt hits for " + reduced + " damage!");
        PrintUtil.pause(800);
        target.takeDamage(reduced);

        // Armor reflect check
        Armor equippedArmor = target.getInventory().getEquippedArmor();
        if (equippedArmor != null) {
            int reflectDamage = equippedArmor.checkReflectDamage(reduced);
            if (reflectDamage > 0) {
                System.out.println("🪞 " + equippedArmor.getName() + " reflected " + reflectDamage + " damage back to " + name + "!");
                PrintUtil.pause(800);
                this.takeDamage(reflectDamage);
            }
        }

        // 30% chance to apply Weaken (ATK debuff 30% for 2 turns) — check debuff immunity first
        if (RandomUtil.chance(30)) {
            if (equippedArmor != null && equippedArmor.checkEffectsImmunity()) {
                System.out.println("✨ " + target.getName() + " resisted Weaken 💢  due to " + equippedArmor.getName() + "!");
                PrintUtil.pause(800);
            } else {
                target.getEffects().applyAttackDebuff(30, 2);
            }
        }
    }

    @Override
    public void displaySkills() {
        System.out.println("┌───────────────────────────── 💀 BONE WARLOCK SKILLS 💀 ────────────────────────────┐");
        System.out.println(" 📝 Description : Bone Warlock casts Shadow Bolt, reducing the target's attack damage.");
        System.out.println(" 💥 Damage      : (" + (int)(attack * 1.00) + " — " + (int)(attack * 1.25) + ")");
        System.out.println(" ✨ Effects     :");
        System.out.println(" - ⚔️ 30% chance to apply ATK Debuff: reduces target's damage by 30%");
        System.out.println("└────────────────────────────────────────────────────────────────────────────────────┘");
    }



    @Override
    public void turn(Character target) { shadowBolt(target); }

    @Override
    public void dropLoot(Character player){
        player.gainExp(rewardExp());
        player.getPotions().lootPotions();
    }

    @Override
    public int rewardExp(){
        return RandomUtil.range(616,649);
    }
}
