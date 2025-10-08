package enemies;


import characters.Character;
import utils.RandomUtil;
import battle.Effects;

public class Enemy2World2 extends Enemy{
    public Enemy2World2(){
        super("Forsaken Cultist", 279, 27, 15);
    }

    public void shadowBolt(Character target){
        int damage = (int)RandomUtil.range(attack * 1.00, attack * 1.55);
        int reduced = damage - target.getDefense();
        if(reduced < 0) reduced = 0;

        System.out.println("🕯️ " + name + " casts Shadow Bolt!");
        if(target.getEffects().checkDodge()) return;

        System.out.println("→ Shadow Bolt hits for " + reduced + " damage!");
        target.takeDamage(reduced);

        if(RandomUtil.chance(30)){
            int debuffAmount = (int) Math.round(target.getAttack() * .15);
            target.getEffects().applyAttackDebuff(debuffAmount, 2);
            System.out.println("⚠️ " + target.getName() + " is weakened (ATK -15%)!");
        }
    }

    @Override
    public void showSkills() {
        System.out.println("\n------- FORSAKEN CULTISTS SKILLS -------");
        System.out.println("Skill – Shadow Bolt");
        System.out.println("Description: Cultists hurl dark bolts of energy, weakening their foe.");
        System.out.println("Damage: (" + (int)(attack * 1.00) + " — " + (int)(attack * 1.33) + ")");
        System.out.println("Effects:");
        System.out.println("- 30% chance to apply Weaken: reduces target’s ATK by 15% for 2 turns\n");
    }



    @Override
    public void turn(Character target) {
        System.out.println("\n-- Enemy Turn --");
        shadowBolt(target);
    }
}
