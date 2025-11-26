package enemies;

import characters.Character;
import utils.PrintUtil;
import utils.RandomUtil;

public class PreFinalBoss extends Enemy {

    public PreFinalBoss() {
        super("Echo of the Necromancer", 2200, 70, 120);
    }


    public void voidSlash(Character target) {
        System.out.println("🌑 " + name + " unleashes a crackling Void Slash!");
        PrintUtil.pause(800);


        if (target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        int damage = (int) RandomUtil.range(attack * 1.10, attack * 1.35);
        int reduced = calculateDamage(target, damage);

        System.out.println("→💥 Void Slash hits for " + reduced + " damage!");
        PrintUtil.pause(800);
        target.takeDamage(reduced);
        target.displayHp();
    }

    @Override
    public void displaySkills() {
        System.out.println("\n------- ECHO OF THE NECROMANCER SKILLS -------");
        System.out.println("Skill – Void Slash");
        System.out.println("Description: A concentrated slash of void energy that cuts through your defenses.");
        System.out.println("Damage: (" + (int)(attack * 1.10) + " — " + (int)(attack * 1.35) + ")");
        System.out.println("Effects:");
        System.out.println("- Standard physical damage, scales with attack.");
        System.out.println("----------------------------------------------");
    }

    @Override
    public void turn(Character target) {
        voidSlash(target);
    }

    @Override
    public void dropLoot(Character player) {
        player.gainExp(rewardExp());
        player.getPotions().lootPotions();
    }

    @Override
    public int rewardExp() {
        return RandomUtil.range(1500, 2000);
    }
}
