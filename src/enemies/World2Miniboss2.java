package enemies;

import characters.Character;
import utils.RandomUtil;

public class World2Miniboss2 extends Enemy {
    public World2Miniboss2() {
        super("The Corrupted King", 854, 32, 100);
    }

    public void crownOfDespair(Character target) {
        System.out.println("👑 " + name + " casts Crown of Despair!");
        if(target.getEffects().checkDodge()) return;

        target.getEffects().applyAttackDebuff(20, 2);
    }

    public void darkJudgement(Character target){
        System.out.println("⚔️ " + name + " uses Dark Judgment!");
        if(target.getEffects().checkDodge()) return;

        int damage = (int)RandomUtil.range(attack * 1.0, attack * 1.15);
        int reduced = damage - target.getDefense();
        if(reduced < 0) reduced = 0;

        System.out.println("→ Dark Judgment hits for " + reduced + " damage!");
        target.takeDamage(reduced);
    }

    public void kingsWrath(Character target){
        System.out.println("🔥 " + name + " unleashes King's Wrath!");
        if(target.getEffects().checkDodge()) return;

        int damage = (int)RandomUtil.range(attack * 0.71, attack * 0.85);
        int reduced = damage - target.getDefense();
        if(reduced < 0) reduced = 0;

        System.out.println("→ King's Wrath hits for " + reduced + " damage!");
        target.takeDamage(reduced);

        if(RandomUtil.chance(30)){
            target.getEffects().applyStun();
        }
    }

    @Override
    public void showSkills() {
        System.out.println("\n------- THE CORRUPTED KING SKILLS -------");
        System.out.println("Skill 1 – Crown of Despair");
        System.out.println("Description: The Corrupted King raises his crown, instilling fear and weakening his foe.");
        System.out.println("Damage: —");
        System.out.println("Effects:");
        System.out.println("- Reduces hero’s ATK by 20% for 2 turns (Weaken)\n");

        System.out.println("Skill 2 – Dark Judgement");
        System.out.println("Description: A shadowy strike that crushes the hero with dark energy.");
        System.out.println("Damage: (" + (int)(attack * 1.0) + " — " + (int)(attack * 1.15) + ")");
        System.out.println("Effects: —\n");

        System.out.println("Skill 3 – King’s Wrath");
        System.out.println("Description: The Corrupted King unleashes a furious strike, overwhelming his enemy.");
        System.out.println("Damage: (" + (int)(attack * 0.71) + " — " + (int)(attack * 0.85) + ")");
        System.out.println("Effects:");
        System.out.println("- 30% chance to Stun the target");
        System.out.println("-----------------------------------------");
    }



    @Override
    public void turn(Character target) {
        if(!target.getEffects().hasAtkDebuff()){
            crownOfDespair(target);
        } else{
            if (RandomUtil.chance(66)) darkJudgement(target);
            else kingsWrath(target);
        }
    }
}
