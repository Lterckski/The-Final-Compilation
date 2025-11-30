package enemies;

import characters.Character;
import inventory.Armor;
import utils.PrintUtil;
import utils.RandomUtil;

public class World1Enemy3 extends Enemy {
    // Constructor
    public World1Enemy3() {
        super("Dreadbark Treants", 76, 7, 25);
    }

    // Skill: Root Snare (6–9 damage, immobilize 1 turn)
    public void rootSnare(Character target) {
        System.out.println("🌳 " + name + " strikes with Root Snare!");
        PrintUtil.pause(800);
        if (target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        int damage = (int) RandomUtil.range(attack * 1.0, attack * 1.5);
        int reduced = calculateDamage(target, damage);

        System.out.println("→💔 Root Snare hits for " + reduced + " damage!");
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

        // 30% chance to Immobilize
        if (RandomUtil.chance(30)) {
            target.getEffects().applyImmobilize();
        }

    }

    @Override
    public void displaySkills() {
        System.out.println();
        System.out.println("┌────────────────────────── 🌳 DREADBARK TREANTS SKILLS 🌳 ────────────────────────────┐");
        System.out.println(" 🪓 Skill     : Root Snare");
        System.out.println(" 📝 Description: The Treants lash out with entangling roots, trying to trap their foe.");
        System.out.println(" ⚔️ Damage    : (" + (int)(attack * 1.00) + " — " + (int)(attack * 1.50) + ")");
        System.out.println(" ✨ Effects   :");
        System.out.println(" - 30% chance to 🌿 Immobilize target");
        System.out.println("└──────────────────────────────────────────────────────────────────────────────────────┘");
        System.out.println();
    }



    @Override
    public void turn(Character target) {
        rootSnare(target);
    }

    @Override
    public void dropLoot(Character player){
        PrintUtil.pause(800);
        System.out.println("┬───────────────────────────────────┬");
        System.out.println("  🎁 You received:");
        player.lootSoulShards(RandomUtil.range(1,2));
        player.getPotions().lootPotions(false);
        player.gainExp(rewardExp());
    }

    @Override
    public int rewardExp(){
        return RandomUtil.range(65,71);
    }
}
