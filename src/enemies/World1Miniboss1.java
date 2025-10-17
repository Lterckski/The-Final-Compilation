package enemies;

import characters.Character;
import utils.RandomUtil;

public class World1Miniboss1 extends Enemy {
    // Constructor
    public World1Miniboss1() {
        super("The Hollow Stag", 211, 13, 47); // HP = 211, DEF = 13
    }


    // Skill 1: Deathly Charge (47–56 damage, stun 1 turn)
    public void deathlyCharge(Character target) {
        System.out.println("🦌 " + name + " charges with Deathly Charge!");
        if (target.getEffects().checkDodge()) return;

        int damage = (int) RandomUtil.range(attack, attack*1.2);
        int reduced = damage - target.getDefense();
        if (reduced < 0) reduced = 0;

        System.out.println("→ Deathly Charge hits for " + reduced + " damage!");
        target.takeDamage(reduced);

        //30% chance to stun
        if (RandomUtil.chance(30)) {
            target.getEffects().applyStun();
        }
    }

    // Skill 2: Blackened Howl (reduces target DEF by 20% for 2 turns)
    public void blackenedHowl(Character target) {
        System.out.println("🗣️ " + name + " unleashes Blackened Howl!");
        if (target.getEffects().checkDodge()) return;

        if (target.getArmor().checkDebuffImmunity()) {
            System.out.println("Target is immune to Fragile (DEF ↓)🛡️!");
        } else {
            target.getEffects().applyDefenseDebuff(20, 2);
        }
    }

    @Override
    public void showSkills() {
        System.out.println("\n------- THE HOLLOW STAG SKILLS -------");
        System.out.println("Skill 1 – Deathly Charge");
        System.out.println("Description: The Hollow Stag charges with deadly force, attempting to stun its foe.");
        System.out.println("Damage: (" + (int)(attack * 1.00) + " — " + (int)(attack * 1.20) + ")");
        System.out.println("Effects:");
        System.out.println("- 30% chance to Stun the target\n");

        System.out.println("Skill 2 – Blackened Howl");
        System.out.println("Description: The stag lets out a blackened howl, weakening its opponent's defenses.");
        System.out.println("Damage: —");
        System.out.println("Effects:");
        System.out.println("- Reduces target’s DEF by 20% for 2 turns");
        System.out.println("--------------------------------------");
    }


    @Override
    public void turn(Character target) {
        if(!target.getEffects().hasDefDebuff()){
            blackenedHowl(target);
        } else{
            deathlyCharge(target);
        }
    }

}
