package enemies;

import characters.Character;
import utils.RandomUtil;

public class Enemy2World3 extends Enemy {

    public Enemy2World3() { super("Bone Warlock", 1129, 48, 56); }

    public void shadowBolt(Character target) {
        System.out.println("💀 " + name + " casts Shadow Bolt!");
        if(target.getEffects().checkDodge()) return;

        int damage = (int)RandomUtil.range(attack * 1.00, attack * 1.25);
        int reduced = damage - target.getDefense();
        if(reduced < 0) reduced = 0;

        System.out.println("→ Shadow Bolt hits for " + reduced + " damage!");
        target.takeDamage(reduced);
        target.getEffects().applyAttackBuff(30, 30);
    }

    @Override
    public void showSkills() {
        System.out.println("\n------- BONE WARLOCK SKILLS -------");
        System.out.println("Description: Bone Warlock will cast Shadow Bolt, reducing attack damage of the victim.");
        System.out.println("Damage: (" + (int)(attack * 1.00) + " — " + (int)(attack * 1.25) + ")");
        System.out.println("Effects:");
        System.out.println("- Chance to apply attack debuff for 30% reduces damage of 30%");
        System.out.println("------------------------------------");
    }

    @Override
    public void turn(Character target) { shadowBolt(target); }
}
