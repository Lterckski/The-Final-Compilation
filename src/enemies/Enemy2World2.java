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
        int minDamage = (int) (attack * 1.00);
        int maxDamage = (int) (attack * 1.33);

        System.out.println("Skill - Shadow Bolt: ( " + minDamage + " - " + maxDamage + " ) damage, 30% chance to Weaken (ATK -15%, 2 turns)");
    }


    @Override
    public void turn(Character target) {
        System.out.println("\n-- Enemy Turn --");
        shadowBolt(target);
    }
}
