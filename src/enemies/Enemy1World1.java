package enemies;

import characters.Character;
import utils.RandomUtil;

public class Enemy1World1 extends Enemy {
    // Constructor
    public Enemy1World1() { super("Rotfang Wolves", 60, 5, 10); }

    // Skill: Savage Howl (10–15 damage)
    public void savageHowl(Character target) {
        int damage = (int) RandomUtil.range(attack, attack*1.5);
        int reduced = damage - target.getDefense();
        if (reduced < 0) reduced = 0;

        System.out.println("🐺 " + name + " used Savage Howl on you for " + reduced + " damage!");
        target.takeDamage(reduced);
    }

    @Override
    public void showSkills(){
        System.out.println("\nSkill - Savage Howl (offensive): Damage 10–15");
    }

    @Override
    public void turn(Character target) {
        System.out.println("\n-- Enemy Turn --");
        savageHowl(target);
    }
}
