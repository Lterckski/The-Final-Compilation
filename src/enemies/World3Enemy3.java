package enemies;

import characters.Character;
import utils.RandomUtil;

public class World3Enemy3 extends Enemy {

    public World3Enemy3() { super("Obsidian Crusher", 1299, 53, 73); }

    public void magmaSlam(Character target) {
        System.out.println("🪨 " + name + " uses Magma Slam!");
        if(target.getEffects().checkDodge()) return;

        int damage = (int)RandomUtil.range(attack * 1.00, attack * 1.20);
        int reduced = damage - target.getDefense();
        if(reduced < 0) reduced = 0;

        System.out.println("→ Magma Slam hits for " +  reduced + " damage!");
        target.takeDamage(reduced);

        if(RandomUtil.chance(30)) {
            target.getEffects().applyStun();
        }
    }

    @Override
    public void showSkills() {
        System.out.println("\n------- OBSIDIAN CRUSHER SKILLS -------");
        System.out.println("Description: Obsidian Crusher slams the ground with blazing magma, stunning its victims.");
        System.out.println("Damage: (" + (int)(attack * 1.00) + " — " + (int)(attack * 1.20) + ")");
        System.out.println("Effects:");
        System.out.println("- Chance to apply Stun to target");
        System.out.println("---------------------------------------");
    }

    @Override
    public void turn(Character target) { magmaSlam(target); }

    @Override
    public void dropLoot(Character player){
        player.getPotions().dropPotions();
    }
}
