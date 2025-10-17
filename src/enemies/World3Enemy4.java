package enemies;

import characters.Character;
import utils.RandomUtil;

public class World3Enemy4 extends Enemy {

    public World3Enemy4() { super("Soulflayer Gargoyle", 1493, 58, 46); }

    public void soulScream(Character target) {
        System.out.println("😈 " + name + " lets out a deafening Soul Scream!");
        if(target.getEffects().checkDodge()) return;

        int damage = (int)RandomUtil.range(attack * 1.00, attack * 1.20);
        int reduced = damage - target.getDefense();
        if(reduced < 0) reduced = 0;

        System.out.println("→ Soul Scream hits for " + reduced + " damage!");
        target.takeDamage(reduced);

        if(RandomUtil.chance(30)) {
            target.getEffects().applyConfuse();
        }
    }

    @Override
    public void showSkills() {
        System.out.println("\n------- SOULFLAYER GARGOYLE SKILLS -------");
        System.out.println("Description: Soulflayer Gargoyle unleashes a soul crushing scream, confusing it's victim.");
        System.out.println("Damage: (" + (int)(attack * 1.00) + " — " + (int)(attack * 1.20) + ")");
        System.out.println("Effects:");
        System.out.println("- Chance to apply Confused to target");
        System.out.println("------------------------------------------");
    }

    @Override
    public void turn(Character target) { soulScream(target); }

    @Override
    public void dropLoot(Character player){
        player.getPotions().lootPotions();
    }
}
