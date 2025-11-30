package enemies;

import characters.Character;
import inventory.Armor;
import utils.PrintUtil;
import utils.RandomUtil;

public class World3Enemy3 extends Enemy {

    public World3Enemy3() { super("Obsidian Crusher", 1299, 53, 90); }

    public void magmaSlam(Character target) {
        System.out.println("🪨 " + name + " uses Magma Slam!");
        PrintUtil.pause(800);
        if(target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        int damage = (int)RandomUtil.range(attack * 1.00, attack * 1.20);
        int reduced = calculateDamage(target, damage);

        System.out.println("→💔 Magma Slam hits for " +  reduced + " damage!");
        PrintUtil.pause(800);
        target.takeDamage(reduced);

        // Armor reflect check
        Armor equippedArmor = target.getInventory().getEquippedArmor();
        if (equippedArmor != null) {
            int reflectDamage = equippedArmor.checkReflectDamage(reduced);
            if (reflectDamage > 0) {
                System.out.println("🪞 " + equippedArmor.getName() + " reflected " + reflectDamage + " damage back to " + name + "!");
                PrintUtil.pause(800);
                this.takeDamage(reflectDamage);
            }
        }

        if(RandomUtil.chance(30)) {
            target.getEffects().applyStun();
        }
    }

    @Override
    public void displaySkills() {
        System.out.println();
        System.out.println("┌──────────────────────────────── 🗿 OBSIDIAN CRUSHER SKILLS 🗿 ──────────────────────────────┐");
        System.out.println(" 📝 Description : Obsidian Crusher slams the ground with blazing magma, stunning its victims.");
        System.out.println(" 💥 Damage      : (" + (int)(attack * 1.00) + " — " + (int)(attack * 1.20) + ")");
        System.out.println(" ✨ Effects     :");
        System.out.println(" - ⚡ Chance to apply Stun to target");
        System.out.println("└────────────────────────────────────────────────────────────────────────────────────────────┘");
        System.out.println();
    }



    @Override
    public void turn(Character target) { magmaSlam(target); }

    @Override
    public void dropLoot(Character player){
        PrintUtil.pause(800);
        System.out.println("┬───────────────────────────────────┬");
        System.out.println("  🎁 You received:");
        player.lootSoulShards(RandomUtil.range(2,4));
        player.getPotions().lootPotions(false);
        player.gainExp(rewardExp());
    }

    @Override
    public int rewardExp(){
        return RandomUtil.range(1057,1107);
    }
}
