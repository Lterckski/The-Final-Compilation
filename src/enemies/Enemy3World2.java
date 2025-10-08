package enemies;


import characters.Character;
import utils.RandomUtil;
import battle.Effects;

public class Enemy3World2 extends Enemy{

    public Enemy3World2(){
        super("Blight Hound", 321, 17, 13);
    }

    public void corpseExplosion(Character target){
        int damage = (int)RandomUtil.range(attack * 1.00, attack * 1.55);
        int reduced = damage - target.getDefense();
        if(reduced < 0) reduced = 0;

        System.out.println("🐕 " + name + " used Corpse Explosion!");
        if(target.getEffects().checkDodge()) return;

        System.out.println("→ Corpse Explosion hits for " + reduced + " damage!");
        target.takeDamage(reduced);

        if(RandomUtil.chance(30)){
            int debuffAmount = (int) Math.round(target.getDefense() * 0.3);
            target.getEffects().applyDefenseDebuff(debuffAmount, 2);
            System.out.println("🛡️ " + target.getName() + "'s DEF is reduced by 30%!");

        }
    }

    @Override
    public void showSkills() {
        System.out.println("\n------- BLIGHT HOUNDS SKILLS -------");
        System.out.println("Skill – Corpse Explosion");
        System.out.println("Description: The Blight Hounds cause corpses to explode, damaging and weakening their target.");
        System.out.println("Damage: (" + (int)(attack * 1.00) + " — " + (int)(attack * 1.55) + ")");
        System.out.println("Effects:");
        System.out.println("- 30% chance to reduce target’s DEF by 30% for 2 turns\n");
    }



    @Override
    public void turn(Character target) {
        System.out.println("\n-- Enemy Turn --");
        corpseExplosion(target);
    }
}
