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
        int damage = (int) RandomUtil.range(attack * 1.0, attack * 1.5);
        int reduced = damage - target.getDefense();
        if (reduced < 0) reduced = 0;

        System.out.println("🌳 " + name + " used Root Snare on you for " + reduced + " damage! You are immobilized for 1 turn!");
        target.takeDamage(reduced);
        // TODO: implement immobilize effect (status system needed)
        double chance = Math.random(); // generates a number between 0.0 and 1.0, 30% chance to immobilize target.
        if (chance < 0.30) {
            target.getEffects().applyImmobilize();
        }
    }

    @Override
    public void showSkills(){
        System.out.println("\nSkill — Root Snare (offensive): Damage 6–9, immobilize 1 turn");
    }

    @Override
    public void turn(Character target) {
        System.out.println("\n-- Enemy Turn --");
        rootSnare(target);
    }
}
