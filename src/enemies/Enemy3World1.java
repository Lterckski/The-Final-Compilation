package enemies;

import characters.Character;
import utils.RandomUtil;

public class Enemy3World1 extends Enemy {
    // Constructor
    public Enemy3World1() {
        super("Dreadbark Treants", 79, 7); // HP = 79, DEF = 7
    }

    // Skill: Root Snare (6–9 damage, immobilize 1 turn)
    public void rootSnare(Character target) {
        int damage = RandomUtil.range(6, 9);
        int reduced = damage - target.getDefense();
        if (reduced < 0) reduced = 0;

        System.out.println("🌳 " + name + " used Root Snare on you for " + reduced + " damage! You are immobilized for 1 turn!");
        target.takeDamage(reduced);
        // TODO: implement immobilize effect (status system needed)
    }
}
