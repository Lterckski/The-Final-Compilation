package enemies;

import characters.Character;
import utils.RandomUtil;

public class World3Enemy1 extends Enemy {

    public World3Enemy1() { super("Flame Revenant", 982, 44, 57); }

    public void emberBurst(Character target) {
        System.out.println("🔥 " + name + " unleashes Ember Burst!");
        if(target.getEffects().checkDodge()) return;

        int damage = (int)RandomUtil.range(attack * 1.00, attack * 1.35);
        int reduced = damage - target.getDefense();
        if (reduced < 0) reduced = 0;

        System.out.println("→ Ember Burst hits for " + reduced + " damage!");
        target.takeDamage(reduced);
        target.getEffects().applyBurn(2);
    }

    @Override
    public void displaySkills() {
        System.out.println("\n------- FLAME REVENANT SKILLS -------");
        System.out.println("Description: Flame Revenants hurl blazing fireballs from afar, burning anything in it's path.");
        System.out.println("Damage: (" + (int)(attack * 1.00) + " — " + (int)(attack * 1.35) + ")");
        System.out.println("Effects:");
        System.out.println("- Applies Burn for 2 turns");
        System.out.println("-------------------------------------");
    }

    @Override
    public void turn(Character target) { emberBurst(target); }

    @Override
    public void dropLoot(Character player){
        player.getPotions().lootPotions();
    }

    @Override
    public int rewardExp(){
        return RandomUtil.range(510,597);
    }
}
