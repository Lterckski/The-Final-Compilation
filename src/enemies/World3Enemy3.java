package enemies;

import characters.Character;
import inventory.Armor;
import utils.ColorUtil;
import utils.PrintUtil;
import utils.RandomUtil;

public class World3Enemy3 extends Enemy {

    public World3Enemy3() { super("Obsidian Crusher", 1583, 48, 320); }

    public void magmaSlam(Character target) {
        PrintUtil.print(ColorUtil.boldBrightRed("                                                          \n" +
                "            . ::++++**+=-:..                              \n" +
                "        .   .-==+*- =-          .                         \n" +
                "      . :=%%#++-:..-+=-.                                  \n" +
                "     .+%*+--*#%#=++**==.  :*#=+-.  :---                   \n" +
                "     +%@##*+==-#%*#+**%%*==#%#+++##**+#%#*:               \n" +
                "    .*%@@%*%%#%%#*@%%#@%#*##%@%##%@#+#%@%%*=.             \n" +
                "     =%@@#@%@#%%##%@@@%%@@@@@@@@#+*#*%@%#%%@=             \n" +
                "      .*%@@%%*--: ::-.     %@@@%#+==+%=+#@@%*+-::         \n" +
                "         ..-:=+++: . .     =@@@@%%####*#%%@@%%+*+.        \n" +
                "         .:::=+++#+:.       +@%#*###%%%%. :%@%%#*+.       \n" +
                "               :::.:::.    .@@@%@%%@%@+   :=**%##%*=.     \n" +
                "                          :%#*%@%%%%@@+.      :#%%%#+     \n" +
                "                         +#*-=*@@@@@@@#+-=:      -%#-     \n" +
                "                      ..=#+*#**@@@@@@%%*==+:              \n" +
                "                      -+#*-=##%*  :#@@@@%##+-             \n" +
                "                    =**#%###%@+       =@@@%%%.            \n" +
                "             :     :%%%#@@@@+        =%%%@@@+    +.       \n" +
                "                   %@@@@@@@#         :@@@@@*              \n" +
                "             :.-.:%@@@@@@+        .:.=@@@@@=  ..::        \n" +
                "             .-#%%%%##%%+--:.=%@%==#@@@@@@@%%%@@-:        \n" +
                "          --*%%%@@@@#%@%#@%%@@%######%%%#*++==-=-.        \n" +
                "              .::=:.:: :-.    ..   ..                     \n" +
                "                                                          "));
        System.out.println(ColorUtil.boldBrightRed("🪨 " + name + " uses Magma Slam!"));
        PrintUtil.pause(800);
        if(target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        int damage = (int)RandomUtil.range(attack * 1.00, attack * 1.20);
        int reduced = calculateDamage(target, damage);

        System.out.println(ColorUtil.brightRed("→💔 Magma Slam hits for ")
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

        if(RandomUtil.chance(30)) {
            target.getEffects().applyStun();
        }
    }

    @Override
    public void displaySkills() {
        System.out.println();
        System.out.println(ColorUtil.boldBrightRed("┌──────────────────────────────── 🗿 OBSIDIAN CRUSHER SKILLS 🗿 ──────────────────────────────┐"));
        System.out.println(ColorUtil.boldBrightYellow("  🗿 Skill – Ground Slam"));
        System.out.println(ColorUtil.red(" 📜 Description : Obsidian Crusher slams the ground with blazing magma, stunning its victims."));
        System.out.println(ColorUtil.red(" 💥 Damage : (") + ColorUtil.boldBrightYellow((int)(attack * 1.00) + " — " + (int)(attack * 1.20)) + ColorUtil.red(")"));
        System.out.println(ColorUtil.red(" ✨ Effects :"));
        System.out.println(ColorUtil.red("    - ⚡ Chance to apply Stun to target"));
        System.out.println(ColorUtil.boldBrightRed("└────────────────────────────────────────────────────────────────────────────────────────────┘"));
        System.out.println();
    }



    @Override
    public void turn(Character target) { magmaSlam(target); }

    @Override
    public void dropLoot(Character player){
        PrintUtil.pause(800);
        System.out.println();
        System.out.println(ColorUtil.boldBrightYellow("┬───────────────────────────────────┬"));
        System.out.println(ColorUtil.brightYellow("  🎁 You received:"));
        player.lootSoulShards(RandomUtil.range(2,4));
        player.getPotions().lootPotions(false);
        player.gainExp(rewardExp());
    }

    @Override
    public int rewardExp(){
        return 1900;
    }
}
