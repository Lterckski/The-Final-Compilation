package enemies;


import characters.Character;
import utils.ColorUtil;
import utils.PrintUtil;
import utils.RandomUtil;
import inventory.*;

public class World2Enemy2 extends Enemy{
    public World2Enemy2(){
        super("Forsaken Cultist", 580, 14, 116);
    }

    public void shadowBolt(Character target){
        PrintUtil.print(ColorUtil.boldBrightRed("                                                          \n" +
                "                                                          \n" +
                "                           +@@@#                          \n" +
                "                          -@@@%                           \n" +
                "                         .#@@@                            \n" +
                "                         *@@@@@@@*                        \n" +
                "                        =@@@%@@@*                         \n" +
                "                            @@@*                          \n" +
                "                           #@@*                           \n" +
                "                          +@@+                            \n" +
                "                         =@@%*%@@*                        \n" +
                "                        -%@@%%@@#.                        \n" +
                "                        -:   #@%.                         \n" +
                "                            =@@:                          \n" +
                "                           .@@-                           \n" +
                "                           #@-                            \n" +
                "                          +@%+*#=                         \n" +
                "                         -%%*=@#                          \n" +
                "                    :        =@:    .                     \n" +
                "                     -:      @=   -:                      \n" +
                "                      -+.:. -*  .+-.                      \n" +
                "                    .= =%###%##*%+  ::                    \n" +
                "          .....::::::-*%@%@%@@#%@@@*-=:::::.....          \n" +
                "                    :=+*+#@@@@@@*-::--=---:-:             \n" +
                "            .::      :+=:   #  . ..+*.                    \n" +
                "                .:--:      =  :        :---:.             \n" +
                "                          ..   .                          \n" +
                "                                                          "));
        System.out.println(ColorUtil.boldBrightRed("🕯️ " + name + " casts Shadow Bolt!"));
        PrintUtil.pause(800);
        if(target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        int damage = (int)RandomUtil.range(attack * 1.00, attack * 1.20);
        int reduced = calculateDamage(target, damage);

        System.out.println(ColorUtil.brightRed("→💔 Shadow Bolt hits for ")
                + ColorUtil.boldBrightWhite(String.valueOf(reduced))
                + ColorUtil.brightRed(" damage!"));
        PrintUtil.pause(800);
        target.takeDamage(reduced);


        //Reflect check
        Armor equippedArmor = target.getInventory().getEquippedArmor();
        if (equippedArmor != null) {
            int reflectDamage = equippedArmor.checkReflectDamage(reduced);
            if (reflectDamage > 0) {
                System.out.println(ColorUtil.brightMagenta("🪞 " + equippedArmor.getName() + " reflected " + reflectDamage + " damage back to " + name + "!"));
                PrintUtil.pause(800);
                this.takeDamage(reflectDamage);
            }
        }

        // 30% chance to apply ATK debuff (check immunity first)
        if (RandomUtil.chance(30)) {
            if (equippedArmor != null && equippedArmor.checkEffectsImmunity()) {
                System.out.println(ColorUtil.brightMagenta("✨ " + target.getName() + " resisted Weaken 🪫 due to " + equippedArmor.getName() + "!"));
                PrintUtil.pause(800);
            } else {
                target.getEffects().applyAttackDebuff(20, 2);
            }
        }
    }

    @Override
    public void displaySkills() {
        System.out.println();
        System.out.println(ColorUtil.boldBrightRed("┌────────────────────── 🔮 FORSAKEN CULTISTS SKILLS 🔮 ───────────────────────┐"));
        System.out.println(ColorUtil.boldBrightYellow("  ⚡ Skill – Shadow Bolt"));
        System.out.println(ColorUtil.red(" 📜 Description : Cultists hurl dark bolts of energy, weakening their foe."));
        System.out.println(ColorUtil.red(" 💥 Damage : (") + ColorUtil.boldBrightYellow((int)(attack * 1.00) + " — " + (int)(attack * 1.20)) + ColorUtil.red(")"));
        System.out.println(ColorUtil.red(" ✨ Effects :"));
        System.out.println(ColorUtil.red("    - 💀 30% chance to apply Weaken: reduces target’s ATK by 20% for 2 turns"));
        System.out.println(ColorUtil.boldBrightRed("└─────────────────────────────────────────────────────────────────────────────┘"));
        System.out.println();
    }



    @Override
    public void turn(Character target) {
        shadowBolt(target);
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
    public int rewardExp(){ return 233;}
}
