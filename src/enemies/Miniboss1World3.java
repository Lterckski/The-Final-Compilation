package enemies;

import characters.Character;
import utils.RandomUtil;

public class Miniboss1World3 extends Enemy {

    public Miniboss1World3() { super("The Tower Warden", 3455, 88, 173); }

    public void graveCleaver(Character target) {
        System.out.println("🤺 " + name + " used Grave Cleaver!");
        if(target.getEffects().checkDodge()) return;

        int damage = (int)RandomUtil.range(attack * 1.00, attack * 1.15);

        System.out.println("→ Grave Cleaver hits for " + damage + " damage!");
        target.takeDamage(damage);
    }

    public void boneShield() {
        System.out.println("🛡️ " + name + " used Bone Shield!");

        System.out.println("→ Bone Shield increases defense of " + name + " by +50 for 2 turns!");

        getEffects().applyDefenseBuff(50, 2);
    }

    @Override
    public void showSkills() {
        System.out.println("\n------- THE TOWER WARDEN SKILLS -------");
        System.out.println("Skill 1 – Grave Cleaver");
        System.out.println("Description: The Tower Warden performs a deathly slash. Inflicting pure damage to it's victims.");
        System.out.println("Damage: (" + (int)(attack * 1.00) + " — " + (int)(attack * 1.15) + ")");
        System.out.println("Effects:");
        System.out.println("- Inflicts pure damage. Ignoring defense");

        System.out.println("Skill 2 – Bone Shield");
        System.out.println("Description: The Tower Warden Raises it's shield to increase it's defenses by 50.");
        System.out.println("Damage: –");
        System.out.println("Effects:");
        System.out.println("- Increases" + name + " defense by 50");
        System.out.println("------------------------------------");
    }

    @Override
    public void turn(Character target) {
        if(this.getEffects().getDefBuffTurnsLeft() == 0) {
            boneShield();
        } else {
            graveCleaver(target);
        }
    }
}
