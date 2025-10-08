package enemies;

import characters.Character;
import utils.RandomUtil;
import battle.Effects;

public class Miniboss1World2 extends Enemy{
    public Miniboss1World2(){
        super("The Black Jailer", 646, 27, 30);
    }

    public void shacklingChains(Character target){
        int damage = (int)RandomUtil.range(attack * 1.00, attack * 1.33);
        int reduced = damage - target.getDefense();
        if(reduced < 0) reduced = 0;

        System.out.println("⛓️ " + name + " used Shackling Chains!");
        if(target.getEffects().checkDodge()) return;

        System.out.println("→ Shackling Chains hits for " + reduced + " damage!");
        target.takeDamage(reduced);

        if(RandomUtil.chance(30)){
            target.getEffects().applyImmobilize();
        }
    }

    public void tormentingLash(Character target){
        int damage = (int)RandomUtil.range(attack * 1.33, attack * 1.73);
        int reduced = damage - target.getDefense();
        if(reduced < 0) reduced = 0;

        System.out.println("🩸 " + name + " lashes with Tormenting Lash!");
        if(target.getEffects().checkDodge()) return;

        System.out.println("→ Tormenting Lash hits for " + reduced + " damage!");
        target.takeDamage(reduced);

        target.getEffects().applyBleed(2);
    }


    @Override
    public void showSkills() {
        int minDamage1 = (int) (attack * 1.00);
        int maxDamage1 = (int) (attack * 1.33);
        int minDamage2 = (int) (attack * 1.33);
        int maxDamage2 = (int) (attack * 1.73);

        System.out.println("Skill 1 - Shackling Chains: ( " + minDamage1 + " - " + maxDamage1 + " ) damage, 30% chance to Immobilize");
        System.out.println("Skill 2 - Tormenting Lash: ( " + minDamage2 + " - " + maxDamage2 + " ) damage, applies Bleed (2 turns)");
    }


    @Override
    public void turn(Character target) {
        System.out.println("\n-- Mini-Boss Turn --");
        if (RandomUtil.chance(50)) shacklingChains(target);
        else tormentingLash(target);
    }
}
