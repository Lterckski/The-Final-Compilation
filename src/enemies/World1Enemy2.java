package enemies;

import characters.Character;
import inventory.Armor;
import utils.PrintUtil;
import utils.RandomUtil;

public class World1Enemy2 extends Enemy {
    // Constructor
    public World1Enemy2() {
        super("Shade Sprites", 69, 6, 20);
    }

    // Skill: Trickster Strike (8–13 damage)
    public void tricksterStrike(Character target) {
        System.out.println("🧚 " + name + " attacks with Trickster Strike!");
        PrintUtil.pause(800);
        if (target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        int damage = (int) RandomUtil.range(attack * 1.0, attack * 1.625);
        int reduced = calculateDamage(target, damage);

        System.out.println("→💔 Trickster Strike hits for " + reduced + " damage!");
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

        if(RandomUtil.chance(30))
            target.getEffects().applyConfuse();

    }

    @Override
    public void displaySkills() {
        System.out.println("┌─────────────────────────────── 👻 SHADE SPRITES SKILLS 👻 ──────────────────────────────┐");
        System.out.println(" 🗡️ Skill     : Trickster Strike");
        System.out.println(" 📝 Description: The Shade Sprites strike mischievously, leaving their target disoriented.");
        System.out.println(" ⚔️ Damage    : (" + (int)(attack * 1.00) + " — " + (int)(attack * 1.625) + ")");
        System.out.println(" ✨ Effects   :");
        System.out.println(" - 30% chance to 😵 Confuse target");
        System.out.println("└─────────────────────────────────────────────────────────────────────────────────────────┘");
    }



    @Override
    public void turn(Character target) {
        tricksterStrike(target);
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
        return RandomUtil.range(38,40);
    }
}
