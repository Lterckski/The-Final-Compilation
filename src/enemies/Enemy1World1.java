package enemies;

import characters.Character;
import utils.RandomUtil;

public class Enemy1World1 extends Enemy {
    // Constructor
    public Enemy1World1() { super("Rotfang Wolves", 60, 5); }

    // Skill: Savage Howl (10–15 damage)
    public void savageHowl(Character target) {
        int damage = RandomUtil.range(10, 15);
        int reduced = damage - target.getDefense();
        if (reduced < 0) reduced = 0;

        System.out.println("🐺 " + name + " used Savage Howl on you for " + reduced + " damage!");
        target.takeDamage(reduced);
    }
}
