package enemies;

import characters.Character;
import utils.RandomUtil;

public class World2Miniboss1 extends Enemy{
    public World2Miniboss1(){
        super("The Black Jailer", 646, 27, 30);
    }

    public void shacklingChains(Character target){
        System.out.println("⛓️ " + name + " used Shackling Chains!");
        if(target.getEffects().checkDodge()) return;

        int damage = (int)RandomUtil.range(attack * 1.00, attack * 1.33);
        int reduced = damage - target.getDefense();
        if(reduced < 0) reduced = 0;

        System.out.println("→ Shackling Chains hits for " + reduced + " damage!");
        target.takeDamage(reduced);

        if(RandomUtil.chance(30)){
            target.getEffects().applyImmobilize();
        }
    }

    public void tormentingLash(Character target){
        System.out.println("🩸 " + name + " lashes with Tormenting Lash!");
        if(target.getEffects().checkDodge()) return;

        int damage = (int)RandomUtil.range(attack * 1.33, attack * 1.73);
        int reduced = damage - target.getDefense();
        if(reduced < 0) reduced = 0;

        System.out.println("→ Tormenting Lash hits for " + reduced + " damage!");
        target.takeDamage(reduced);

        target.getEffects().applyBleed(2);
    }


    @Override
    public void showSkills() {
        System.out.println("\n------- THE BLACK JAILER SKILLS -------");
        System.out.println("Skill 1 – Shackling Chains");
        System.out.println("Description: The Black Jailer swings his chains to bind and cripple his opponent.");
        System.out.println("Damage: (" + (int)(attack * 1.00) + " — " + (int)(attack * 1.33) + ")");
        System.out.println("Effects:");
        System.out.println("- 30% chance to Immobilize the target\n");

        System.out.println("Skill 2 – Tormenting Lash");
        System.out.println("Description: The Black Jailer lashes his whip, leaving his foe bleeding.");
        System.out.println("Damage: (" + (int)(attack * 1.33) + " — " + (int)(attack * 1.73) + ")");
        System.out.println("Effects:");
        System.out.println("- Applies Bleed for 2 turns");
        System.out.println("---------------------------------------");
    }



    @Override
    public void turn(Character target) {
        if (RandomUtil.chance(50)) shacklingChains(target);
        else tormentingLash(target);
    }
}
