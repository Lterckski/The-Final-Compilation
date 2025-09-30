package enemies;

import characters.Character;
import utils.RandomUtil;

public class Enemy2World1 extends Enemy {
    // Constructor
    public Enemy2World1() {
        super("Shade Sprites", 69, 6); // HP = 69, DEF = 6
    }

    // Skill: Trickster Strike (8–13 damage)
    public void tricksterStrike(Character target) {
        int damage = RandomUtil.range(8, 13);
        int reduced = damage - target.getDefense();
        if (reduced < 0) reduced = 0;

        System.out.println("🧚 " + name + " used Trickster Strike on you for " + reduced + " damage!");
        target.takeDamage(reduced);
    }

    @Override
    public void showSkills(){
        System.out.println("\nSkill — Trickster Strike (offensive): Damage 8–13");
    }

    @Override
    public void turn(Character target) {
        System.out.println("\n-- Enemy Turn --");
        tricksterStrike(target);
    }
}
