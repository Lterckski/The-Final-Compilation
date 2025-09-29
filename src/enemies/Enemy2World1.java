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
        System.out.println("🧚 " + name + " used Trickster Strike on you!");
        target.takeDamage(damage, target.getDefense());
    }
}
