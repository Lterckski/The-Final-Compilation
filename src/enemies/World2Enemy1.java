package enemies;


import characters.Character;
import utils.ColorUtil;
import utils.PrintUtil;
import utils.RandomUtil;
import inventory.*;

public class World2Enemy1 extends Enemy{
    public World2Enemy1(){
        super("Plague Vermin", 243, 13, 45);
    }

    public void plagueBite(Character target){
        System.out.println(ColorUtil.boldBrightRed("🐀 " + name + " used Plague Bite!"));
        PrintUtil.pause(800);
        if(target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        int damage = (int)RandomUtil.range(attack * 1.00, attack * 1.55);
        int reduced = calculateDamage(target, damage);

        System.out.println(ColorUtil.brightRed("→💔 Plague Bite hits for ")
                + ColorUtil.boldBrightWhite(String.valueOf(reduced))
                + ColorUtil.brightRed(" damage!"));
        PrintUtil.pause(800);
        target.takeDamage(reduced);



        // Armor reflect check
        Armor equippedArmor = target.getInventory().getEquippedArmor();
        if (equippedArmor != null) {
            int reflectDamage = equippedArmor.checkReflectDamage(reduced);
            if (reflectDamage > 0) {
                System.out.println(ColorUtil.brightMagenta("🪞 " + equippedArmor.getName() + " reflected " + reflectDamage + " damage back to " + name + "!"));
                PrintUtil.pause(800);
                this.takeDamage(reflectDamage);
            }
        }

        // Poison effect with immunity check
        if (equippedArmor != null && equippedArmor.checkEffectsImmunity()) {
            System.out.println(ColorUtil.brightMagenta("✨ " + target.getName() + " resisted Poison ☠️ due to " + equippedArmor.getName() + "!"));
            PrintUtil.pause(800);
        } else {
            target.getEffects().applyPoison(1);
        }
    }

    @Override
    public void displaySkills() {
        System.out.println();
        System.out.println(ColorUtil.boldBrightRed("┌──────────────────────────────── 🐀 PLAGUE VERMIN SKILLS 🐀 ────────────────────────────────┐"));
        System.out.println(ColorUtil.boldBrightYellow("  🦷 Skill – Plague Bite"));
        System.out.println(ColorUtil.red(" 📜 Description : The Plague Vermin bites viciously, infecting its target with deadly poison."));
        System.out.println(ColorUtil.red(" 💥 Damage : (") + ColorUtil.boldBrightYellow((int)(attack * 1.00) + " — " + (int)(attack * 1.55)) + ColorUtil.red(")"));
        System.out.println(ColorUtil.red(" ✨ Effects :"));
        System.out.println(ColorUtil.red("    - ☣️ Applies Poison for 1 turn"));
        System.out.println(ColorUtil.boldBrightRed("└────────────────────────────────────────────────────────────────────────────────────────────┘"));
        System.out.println();
    }




    @Override
    public void turn(Character target) {
        plagueBite(target);
    }

    @Override
    public void dropLoot(Character player){
        PrintUtil.pause(800);
        System.out.println();
        System.out.println(ColorUtil.boldBrightYellow("┬───────────────────────────────────┬"));
        System.out.println(ColorUtil.brightYellow("  🎁 You received:"));
        player.lootSoulShards(RandomUtil.range(2,3));
        player.getPotions().lootPotions(false);
        player.gainExp(rewardExp());
    }

    @Override
    public int rewardExp(){
        return RandomUtil.range(128,145);
    }
}
