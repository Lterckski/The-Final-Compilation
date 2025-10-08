package enemies;


import characters.Character;
import utils.RandomUtil;
import battle.Effects;

public class Enemy1World2 extends Enemy{
    public Enemy1World2(){
        super("Plague Vermin", 243, 13, 14);
    }

    public void plagueBite(Character target){

        if(target.getEffects().checkDodge()) return;

        int damage = (int)RandomUtil.range(attack * 1.00, attack * 1.55);
        int reduced = damage - target.getDefense();
        if(reduced < 0) reduced = 0;

        System.out.println("🐀 " + name + " used Plague Bite on " + target.getName() + "for " + reduced + "Damage!");
        target.getEffects().applyPoison(1);
    }

    @Override
    public void showSkills(){
        System.out.println("Skill - Plague Bite: Damage ATK × (1.00–1.55), Poison (1 turn)");
    }

    @Override
    public void turn(Character target) {
        System.out.println("\n-- Enemy Turn --");
        plagueBite(target);
    }
}
