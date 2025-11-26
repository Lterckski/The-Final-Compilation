package enemies;

import characters.Character;
import inventory.Armor;
import utils.PrintUtil;
import utils.RandomUtil;

public class World3Enemy4 extends Enemy {

    public World3Enemy4() { super("Soulflayer Gargoyle", 1493, 58, 95); }

    public void soulScream(Character target) {
        System.out.println("😈 " + name + " lets out a deafening Soul Scream!");
        PrintUtil.pause(800);
        if(target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        int damage = (int)RandomUtil.range(attack * 1.00, attack * 1.20);
        int reduced = calculateDamage(target, damage);

        System.out.println("→💔 Soul Scream hits for " + reduced + " damage!");
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

        target.getEffects().applyConfuse();
    }

    @Override
    public void displaySkills() {
        System.out.println("\n💀🗿------- SOULFLAYER GARGOYLE SKILLS -------🗿💀");
        System.out.println("📝 Description: Soulflayer Gargoyle unleashes a soul-crushing scream, confusing its victim.");
        System.out.println("💥 Damage: (" + (int)(attack * 1.00) + " — " + (int)(attack * 1.20) + ")");
        System.out.println("✨ Effects:");
        System.out.println("- 😵 Confuses the target");
        System.out.println("------------------------------------------");
    }


    @Override
    public void turn(Character target) { soulScream(target); }

    @Override
    public void dropLoot(Character player){
        player.gainExp(rewardExp());
        player.getPotions().lootPotions();
    }

    @Override
    public int rewardExp(){
        return RandomUtil.range(596,647);
    }
}
