package enemies;

import characters.Character;
import utils.RandomUtil;

public class Miniboss1World1 extends Enemy {
    // Constructor
    public Miniboss1World1() {
        super("The Hollow Stag", 211, 13); // HP = 211, DEF = 13
    }

    // Skill 1: Deathly Charge (47–56 damage, stun 1 turn)
    public void deathlyCharge(Character target) {
        int damage = RandomUtil.range(47, 56);
        int reduced = damage - target.getDefense();
        if (reduced < 0) reduced = 0;

        System.out.println("🦌 " + name + " used Deathly Charge on you for " + reduced + " damage! You are stunned for 1 turn!");
        target.takeDamage(reduced);
        // TODO: implement stun effect (status system needed)
    }

    // Skill 2: Blackened Howl (reduces target DEF by 20% for 2 turns)
    public void blackenedHowl(Enemy target) {
        double reduction = target.getDefense() * 0.2;
        int reducedDef = target.getDefense() - (int) reduction;
        System.out.println(name + " used Blackened Howl! " + target.getName() + "'s DEF reduced from " + target.getDefense() + " to " + reducedDef + " for 2 turns.");
        //target.defense = reducedDef; // temporarily reduce DEF
        // TODO: add duration tracking (restore DEF after 2 turns)
    }
}
