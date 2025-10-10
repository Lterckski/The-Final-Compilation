package enemies;

import characters.Character;
import utils.RandomUtil;

import java.util.Random;

public class Enemy4World1 extends Enemy {
    // Constructor
    public Enemy4World1() {
        super("Carrion Bats", 91, 8, 6);
    }

    // Skill: Screech (6–8 damage, chance to confuse 1 turn)
    public void screech(Character target) {
        System.out.println("🦇 " + name + " screeches loudly at the target!");
        if (target.getEffects().checkDodge()) return;

        int damage = (int) RandomUtil.range(attack * 1.0, attack * 1.33);
        int reduced = damage - target.getDefense();
        if (reduced < 0) reduced = 0;

        System.out.println("→ Screech hits for " + reduced + " damage!");
        target.takeDamage(reduced);

        if (RandomUtil.chance(30)) {
            target.getEffects().applyAttackDebuff(10, 2);
        }
    }

    @Override
    public void showSkills(){
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
}
