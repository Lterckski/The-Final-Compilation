package enemies;

import characters.Character;
import inventory.Armor;
import utils.RandomUtil;

public class World3Enemy3 extends Enemy {

    public World3Enemy3() { super("Obsidian Crusher", 1299, 53, 73); }

    public void magmaSlam(Character target) {
        System.out.println("🪨 " + name + " uses Magma Slam!");
        if(target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        int damage = (int)RandomUtil.range(attack * 1.00, attack * 1.20);
        int reduced = calculateDamage(target, damage);

        System.out.println("→💔 Magma Slam hits for " +  reduced + " damage!");
        target.takeDamage(reduced);

        // Armor reflect check
        Armor equippedArmor = target.getInventory().getEquippedArmor();
        if (equippedArmor != null) {
            int reflectDamage = equippedArmor.checkReflectDamage(reduced);
            if (reflectDamage > 0) {
                System.out.println("🪞 " + equippedArmor.getName() + " reflected " + reflectDamage + " damage back to " + name + "!");
                this.takeDamage(reflectDamage);
            }
        }

        if(RandomUtil.chance(30)) {
            target.getEffects().applyStun();
        }
    }

    @Override
    public void displaySkills() {
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
        player.getPotions().lootPotions();
    }

    @Override
    public int rewardExp(){
        return RandomUtil.range(1057,1107);
    }
}
