package enemies;

import characters.Character;
import utils.RandomUtil;
import battle.Effects;

public class Miniboss2World2 extends Enemy {
    public Miniboss2World2() {
        super("The Corrupted King", 854, 32, 100);
    }

    public void crownOfDespair(Character target) {
        System.out.println("👑 " + name + " casts Crown of Despair!");
        int debuffAmount = (int) Math.round(target.getAttack() * 0.2);
        target.getEffects().applyAttackDebuff(debuffAmount, 2);
        System.out.println("⚠️ " + target.getName() + " is weakened (-20% ATK)!");
    }

    public void darkJudgement(Character target){
        if(target.getEffects().checkDodge()) return;

        int damage = (int)RandomUtil.range(attack * 1, attack * 1.15);
        int reduced = damage - target.getDefense();
        if(reduced < 0) reduced = 0;

        System.out.println("⚔️ " + name + " uses Dark Judgment!");
        System.out.println("→ Dark Judgment hits for " + reduced + " damage!");
    }

    public void kingsWrath(Character target){
        if(target.getEffects().checkDodge()) return;

        int damage = (int)RandomUtil.range(attack * 0.71, attack * 0.85);
        int reduced = damage - target.getDefense();
        if(reduced < 0) reduced = 0;

        System.out.println("🔥 " + name + " unleashes King's Wrath!");
        System.out.println("→ King's Wrath hits for " + reduced + " damage!");
        target.takeDamage(reduced);

        if(RandomUtil.chance(30)){
            target.getEffects().applyStun();
        }
    }

    @Override
    public void showSkills() {
        System.out.println("Skill 1 - Crown of Despair: Weaken (ATK -20%) 2 turns");
        System.out.println("Skill 2 - Dark Judgment: ATK × (1.00–1.15)");
        System.out.println("Skill 3 - King's Wrath: ATK × (0.71–0.85), 30% Stun");
    }

    @Override
    public void turn(Character target) {
        System.out.println("\n-- Boss Turn --");
        int roll = RandomUtil.range(1, 100);
        if (roll <= 30) crownOfDespair(target);
        else if (roll <= 60) darkJudgement(target);
        else kingsWrath(target);
    }
}
