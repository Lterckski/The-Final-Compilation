package enemies;

import characters.Character;
import utils.RandomUtil;

public class Enemy3World1 extends Enemy {
    // Constructor
    public Enemy3World1() {
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
        System.out.println("- 30% chance to Immobilize target\n");
    }

    @Override
    public void turn(Character target) {
        rootSnare(target);
    }
}
