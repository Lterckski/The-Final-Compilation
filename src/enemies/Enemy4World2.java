package enemies;

import characters.Character;
import utils.RandomUtil;
import battle.Effects;

public class Enemy4World2 extends Enemy{
    public Enemy4World2(){
        super("Ghoul Footmen", 369, 18, 25);
    }

    public void rottenCleave(Character target){
        int damage = (int)RandomUtil.range(attack * 1.00 , attack * 1.30);
        int reduced = damage - target.getDefense();
        if(reduced < 0) reduced = 0;

        System.out.println("🧟 " + name + " swings Rotten Cleave!");
        if(target.getEffects().checkDodge()) return;

        System.out.println("→ Rotten Cleave hits for " + reduced + " damage!");
        target.takeDamage(reduced);

        if(RandomUtil.chance(30)){
            target.getEffects().applyBleed(2);
            System.out.println("🩸 Bleeding is applied to " + target.getName() + " for " + 2 + " turns!");
        }
    }


    @Override
    public void showSkills() {
        System.out.println("Skill - Rotten Cleave: Damage ATK × (1.00–1.30), 30% Bleed (2 turns)");
    }

    @Override
    public void turn(Character target) {
        System.out.println("\n-- Enemy Turn --");
        rottenCleave(target);
    }
}
