package enemies;

import characters.Character;
import utils.RandomUtil;

public class Miniboss1World1 extends Enemy {
    // Constructor
    public Miniboss1World1() {
        super("The Hollow Stag", 211, 13, 47); // HP = 211, DEF = 13
    }

    // Skill 1: Deathly Charge (47–56 damage, stun 1 turn)
    public void deathlyCharge(Character target) {
        int damage = (int) RandomUtil.range(attack, attack*1.2);
        int reduced = damage - target.getDefense();
        if (reduced < 0) reduced = 0;

        System.out.println("🦌 " + name + " used Deathly Charge on you for " + reduced + " damage! You are stunned for 1 turn!");
        target.takeDamage(reduced);

        //30% chance to stun
        if (Math.random() < 0.30) {
            target.getEffects().applyStun();
        }
    }

    // Skill 2: Blackened Howl (reduces target DEF by 20% for 2 turns)
    public void blackenedHowl(Enemy target) {
        double reduction = target.getDefense() * 0.2;
        int reducedDef = target.getDefense() - (int) reduction;
        System.out.println(name + " used Blackened Howl! " + target.getName() + "'s DEF reduced from " + target.getDefense() + " to " + reducedDef + " for 2 turns.");
        int debuffAmount = (int) (target.getDefense() * 0.20);
        target.getEffects().applyDefenseDebuff(debuffAmount, 2); // 🛡️ Calculate 20% of the target's current DEF to use as the debuff amount
    }

    @Override
    public void showSkills(){
        System.out.println("\nSkill 1 — Deathly Charge: 47–56 dmg, stun 1 turn");
        System.out.println("Skill 2 — Blackened Howl: reduces target DEF by 20% for 2 turns");
    }

    @Override
    public void turn(Character target) {
        System.out.println("\n-- Enemy Turn --");
        deathlyCharge(target);
        // TODO: Implement a conditional AI logic so that it will only use skill 2 if target(player) doesn't have a DEF debuff
    }

}
