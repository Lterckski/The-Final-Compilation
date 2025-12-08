package enemies;

import characters.Character;
import inventory.Armor;
import utils.ColorUtil;
import utils.PrintUtil;
import utils.RandomUtil;

public class World3Enemy4 extends Enemy {

    public World3Enemy4() { super("Soulflayer Gargoyle", 1420, 48, 280); }

    public void soulScream(Character target) {
        PrintUtil.print(ColorUtil.boldBrightRed("                                                          \n" +
                "                                                          \n" +
                ".:-==+==-:.      -:                       ..              \n" +
                "####%%%%@@%###++*:                       --.              \n" +
                "+*####%%%%@%%#**:                        .=++***++#=#*+==:\n" +
                "#%###%%##%@%%%*:                          -****#+*=***++**\n" +
                "+*####%%%%#@@%+.                  .    .. .+*%%++******##*\n" +
                "*#*%###%%@%%@%=                        ....=#*++****######\n" +
                "##**###%%##%%#=               :+=:  .  .. .=+++*%%%###**++\n" +
                "++*###%###%%#**             =**%%-        :*%@%#%##%%##*+=\n" +
                "+*##%#*#*#%%*+#-          .+%##**=        +**%%%########*+\n" +
                "*###*+***#%%###*:       :==*%%%%#+-      =#*#%%%%##***####\n" +
                "%#**++++*#%#**###*:      .:*+*##*      :*##*#%#*###*++=+*%\n" +
                "#*++===**#%%@@%#*==##+==+=*#*##%#*---=*++*%%%%#+*###*++=+*\n" +
                "*-====+*##%###%%%%%@%+--+*+++*#%#**++#%%%@%%%#*++*%#*++=-+\n" +
                ".  :==+*#%#****##%@%@%%%%#+-:=#%*-=##%@%%#####*==*#%#=.   \n" +
                "     .=#%*+==++*#%%+*=#@@%#+=*%%#+*%%%%#*++*##*=-**#*.    \n" +
                "      =##-====+*#%#+-*@@@%##+++***%@*:*#++=+##=.   :-     \n" +
                "      :-.    .:+#=#@%%%%@%##%%%%%%%%@#%#=::=*=            \n" +
                "      .        =#=#%+*#%%@@@%#%%%@%%%@#*-.  .             \n" +
                "               =**#=  .+%#+%%#%%%%-  #%+*=                \n" +
                "               :+*:    :#+%%@@@@@#.    -#*-               \n" +
                "               -=+.    *%*%@@@@@@%*.     .+-              \n" +
                "               :#**++:=#=+%@@@@@%%==-    -*#-             \n" +
                "               :+*-  =*-=#%%#*@%##%*=-     +%-            \n" +
                "                +=+: #=*#%@=   *%##++*=    -=:            \n" +
                "                 .- -#**+#:      +%%+:#-                  \n" +
                "                    %####:         *@%%=.                 \n" +
                "                  :###%*.         +@@@@%.                 \n" +
                "                 #@@@%:          :%@@%-                   \n" +
                "                :%@@%.          .#@%-                     "));
        System.out.println(ColorUtil.boldBrightRed("😈 " + name + " lets out a deafening Soul Scream!"));
        PrintUtil.pause(800);
        if(target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        int damage = (int)RandomUtil.range(attack * 1.00, attack * 1.20);
        int reduced = calculateDamage(target, damage);

        System.out.println(ColorUtil.brightRed("→💔 Soul Scream hits for ")
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

        if(RandomUtil.chance(50))
            target.getEffects().applyConfuse();
    }

    @Override
    public void displaySkills() {
        System.out.println();
        System.out.println(ColorUtil.boldBrightRed("┌───────────────────────────── 🦇 SOULFLAYER GARGOYLE SKILLS 🦇 ────────────────────────────┐"));
        System.out.println(ColorUtil.boldBrightYellow("  🦇 Skill – Soul Scream"));
        System.out.println(ColorUtil.red(" 📜 Description : Soulflayer Gargoyle unleashes a soul-crushing scream, confusing its victim."));
        System.out.println(ColorUtil.red(" 💥 Damage : (") + ColorUtil.boldBrightYellow((int)(attack * 1.00) + " — " + (int)(attack * 1.20)) + ColorUtil.red(")"));
        System.out.println(ColorUtil.red(" ✨ Effects :"));
        System.out.println(ColorUtil.red("    - 😵 50% Chance to Confuse the target"));
        System.out.println(ColorUtil.boldBrightRed("└────────────────────────────────────────────────────────────────────────────────────────────┘"));
        System.out.println();
    }



    @Override
    public void turn(Character target) { soulScream(target); }

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
        return 3800;
    }
}
