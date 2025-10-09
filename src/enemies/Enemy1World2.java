package enemies;


import characters.Character;
import utils.RandomUtil;
import battle.Effects;

public class Enemy1World2 extends Enemy{
    public Enemy1World2(){
        super("Plague Vermin", 243, 13, 14);
    }

    public void plagueBite(Character target){
        System.out.println("🐀 " + name + " used Plague Bite!");
        if(target.getEffects().checkDodge()) return;

        int damage = (int)RandomUtil.range(attack * 1.00, attack * 1.55);
        int reduced = damage - target.getDefense();
        if(reduced < 0) reduced = 0;

        System.out.println("→ Plague Bite hits for " + reduced + " damage!");
        target.takeDamage(reduced);
        target.getEffects().applyPoison(1);
    }

    @Override
    public void showSkills() {
        System.out.println("\n------- PLAGUE VERMIN SKILLS -------");
        System.out.println("Skill – Plague Bite");
        System.out.println("Description: The Plague Vermin bites viciously, infecting its target with deadly poison.");
        System.out.println("Damage: (" + (int)(attack * 1.00) + " — " + (int)(attack * 1.55) + ")");
        System.out.println("Effects:");
        System.out.println("- Applies Poison for 1 turn\n");
    }

    @Override
    public void turn(Character target) {
        plagueBite(target);
    }
}
