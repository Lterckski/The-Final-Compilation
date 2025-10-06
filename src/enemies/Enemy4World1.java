package enemies;

import characters.Character;
import utils.RandomUtil;

public class Enemy4World1 extends Enemy {
    // Constructor
    public Enemy4World1() {
        super("Carrion Bats", 91, 8, 6); // HP = 91, DEF = 8
    }

    // Skill: Screech (6–8 damage, chance to confuse 1 turn)
    public void screech(Character target) {
        int damage = (int) RandomUtil.range(attack, attack*1.4);
        int reduced = damage - target.getDefense();
        if (reduced < 0) reduced = 0;

        System.out.println("🦇 " + name + " used Screech on you for " + reduced + " damage! You may be confused for 1 turn!");
        target.takeDamage(reduced);
        // TODO: Apply confuse effect (requires status system)
    }

    @Override
    public void showSkills(){
        System.out.println("\nSkill — Screech: Damage 6–8, chance to confuse 1 turn");
    }

    @Override
    public void turn(Character target) {
        System.out.println("\n-- Enemy Turn --");
        screech(target);
    }
}
