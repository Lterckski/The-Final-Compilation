package enemies;


import characters.Character;
import utils.PrintUtil;
import utils.RandomUtil;
import inventory.*;

public class World2Enemy3 extends Enemy{

    public World2Enemy3(){
        super("Blight Hound", 321, 17, 55);
    }

    public void corpseExplosion(Character target){
        System.out.println("🐕 " + name + " used Corpse Explosion!");
        PrintUtil.pause(800);
        if(target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        int damage = (int)RandomUtil.range(attack * 1.00, attack * 1.55);
        int reduced = calculateDamage(target, damage);

        System.out.println("→💔 Corpse Explosion hits for " + reduced + " damage!");
        PrintUtil.pause(800);
        target.takeDamage(reduced);

        //  Reflect check
        Armor equippedArmor = target.getInventory().getEquippedArmor();
        if (equippedArmor != null) {
            int reflectDamage = equippedArmor.checkReflectDamage(reduced);
            if (reflectDamage > 0) {
                System.out.println("🪞 " + equippedArmor.getName() + " reflected " + reflectDamage + " damage back to " + name + "!");
                PrintUtil.pause(800);
                this.takeDamage(reflectDamage);
            }
        }

        // 30% chance to apply DEF debuff (check immunity first)
        if (RandomUtil.chance(30)) {
            if (equippedArmor != null && equippedArmor.checkDebuffImmunity()) {
                System.out.println("✨ " + target.getName() + " resisted Defense Down 🛡️↓ due to " + equippedArmor.getName() + "!");
                PrintUtil.pause(800);
            } else {
                target.getEffects().applyDefenseDebuff(30, 2);
            }
        }
    }

    @Override
    public void displaySkills() {
        System.out.println("┌────────────────────── 🐕‍🦺 BLIGHT HOUNDS SKILLS 🐕‍🦺 ──────────────────────────────┐");

        System.out.println(" 💥 Skill       : Corpse Explosion");
        System.out.println(" 📝 Description : The Blight Hounds cause corpses to explode, damaging and weakening their target.");
        System.out.println(" ⚔️ Damage     : (" + (int)(attack * 1.00) + " — " + (int)(attack * 1.55) + ")");
        System.out.println(" ✨ Effects    :");
        System.out.println(" - 🛡️ 30% chance to reduce target’s DEF by 30% for 2 turns");

        System.out.println("└────────────────────────────────────────────────────────────────────────────────────┘");
    }



    @Override
    public void turn(Character target) {
        corpseExplosion(target);
    }

    @Override
    public void dropLoot(Character player){
        player.gainExp(rewardExp());
        player.getPotions().lootPotions();
    }

    @Override
    public int rewardExp(){
        return RandomUtil.range(162,190);
    }
}
