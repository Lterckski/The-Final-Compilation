package enemies;

import characters.Character;
import utils.RandomUtil;

public class Enemy4World1 extends Enemy {
    // Constructor
    public Enemy4World1() {
        super("Carrion Bats", 91, 8); // HP = 91, DEF = 8
    }

    // Skill: Screech (6–8 damage, chance to confuse 1 turn)
    public void screech(Character target) {
        int damage = RandomUtil.range(6, 8);
        System.out.println("🦇 " + name + " used Screech on you! You may be confused for 1 turn!");
        target.takeDamage(damage, target.getDefense());
        // TODO: Apply confuse effect (requires status system)
    }
}
