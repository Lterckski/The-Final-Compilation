package enemies;


import characters.Character;
import utils.ColorUtil;
import utils.PrintUtil;
import utils.RandomUtil;
import inventory.*;

public class World2Enemy3 extends Enemy{

    public World2Enemy3(){
        super("Blight Hound", 620, 13, 128);
    }

    public void corpseExplosion(Character target){
        PrintUtil.print(ColorUtil.boldBrightRed("                                                          \n" +
                "                           .                              \n" +
                "                           -                              \n" +
                "                           +                              \n" +
                "                           +:        .                    \n" +
                "                          .%#.   .  -                     \n" +
                "                   ..   . -*=#. .  +.   :                 \n" +
                "                .#.: =  :.--#@=  :+-  :                   \n" +
                "                . .: .=-.+:*@@%:+#*.   .                  \n" +
                "                  :=.::=*#%*@#*#%*..-.                    \n" +
                "                    .*#=*%%++.#+%%#=:  .++    .           \n" +
                "                     =-*##-+#%%-+%*-                      \n" +
                "            .......:=#%%*-+@@@@#-#%*=-:.                  \n" +
                "              .   :..-+**==#@@#==#%*=-.:.                 \n" +
                "                .:-=+=+@*#%=**-%%*%*:..                   \n" +
                "                  : .=**.+@@%@%##:=*-:                    \n" +
                "                +: ...*+-#%@@@@@@==*..  ..                \n" +
                "                   .  =::+@@%*@@#::+.                     \n" +
                "                       . =#@+-@@*                         \n" +
                "                 .       .*@-.@#=                         \n" +
                "                          *@  %#:       .                 \n" +
                "                         :%@  #@=                         \n" +
                "                          #%  +%-                         \n" +
                "                          +*  -#                          \n" +
                "                          =#  =#                          \n" +
                "                         .#*  -%-                         \n" +
                "                          .    .                          \n" +
                "                                                          "));
        System.out.println(ColorUtil.boldBrightRed("🐕 " + name + " used Corpse Explosion!"));
        PrintUtil.pause(800);
        if(target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        int damage = (int)RandomUtil.range(attack * 1.00, attack * 1.20);
        int reduced = calculateDamage(target, damage);

        System.out.println(ColorUtil.brightRed("→💔 Corpse Explosion hits for ")
                + ColorUtil.boldBrightWhite(String.valueOf(reduced))
                + ColorUtil.brightRed(" damage!"));
        PrintUtil.pause(800);
        target.takeDamage(reduced);


        //  Reflect check
        Armor equippedArmor = target.getInventory().getEquippedArmor();
        if (equippedArmor != null) {
            int reflectDamage = equippedArmor.checkReflectDamage(reduced);
            if (reflectDamage > 0) {
                System.out.println(ColorUtil.brightMagenta("🪞 " + equippedArmor.getName() + " reflected " + reflectDamage + " damage back to " + name + "!"));
                PrintUtil.pause(800);
                this.takeDamage(reflectDamage);
            }
        }

        // 30% chance to apply DEF debuff (check immunity first)
        if (RandomUtil.chance(30)) {
            if (equippedArmor != null && equippedArmor.checkDebuffImmunity()) {
                System.out.println(ColorUtil.brightMagenta("✨ " + target.getName() + " resisted Defense Down 🛡️↓ due to " + equippedArmor.getName() + "!"));
                PrintUtil.pause(800);
            } else {
                target.getEffects().applyDefenseDebuff(30, 2);
            }
        }
    }

    @Override
    public void displaySkills() {
        System.out.println();
        System.out.println(ColorUtil.boldBrightRed("┌─────────────────────────────────── 🐕‍🦺 BLIGHT HOUNDS SKILLS 🐕‍🦺 ─────────────────────────────────┐"));
        System.out.println(ColorUtil.boldBrightYellow("  💥 Skill – Corpse Explosion"));
        System.out.println(ColorUtil.red(" 📜 Description : The Blight Hounds cause corpses to explode, damaging and weakening their target."));
        System.out.println(ColorUtil.red(" 💥 Damage : (") + ColorUtil.boldBrightYellow((int)(attack * 1.00) + " — " + (int)(attack * 1.20)) + ColorUtil.red(")"));
        System.out.println(ColorUtil.red(" ✨ Effects :"));
        System.out.println(ColorUtil.red("    - 🛡️ 30% chance to reduce target’s DEF by 30% for 2 turns"));
        System.out.println(ColorUtil.boldBrightRed("└─────────────────────────────────────────────────────────────────────────────────────────────────┘"));
        System.out.println();
    }




    @Override
    public void turn(Character target) {
        corpseExplosion(target);
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
        return 383;
    }
}
