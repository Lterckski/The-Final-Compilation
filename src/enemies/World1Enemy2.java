package enemies;

import characters.Character;
import inventory.Armor;
import utils.ColorUtil;
import utils.PrintUtil;
import utils.RandomUtil;

import java.awt.*;

public class World1Enemy2 extends Enemy {
    // Constructor
    public World1Enemy2() {
        super("Shade Sprites", 69, 6, 20);
    }

    // Skill: Trickster Strike (8–13 damage)
    public void tricksterStrike(Character target) {
        PrintUtil.type(ColorUtil.boldBrightRed("                                                          \n" +
                "                                      :=+=:               \n" +
                "               =#+-+#.              =%:  .+%*             \n" +
                "             .*+     #             :*      .##            \n" +
                "             =#.    -:     -*#+.   .#       -@-           \n" +
                "             +#.         *@@@@@@%:   .-:    -@-           \n" +
                "             :%*        *@@@@@@@@#.        .##.           \n" +
                "         --   .#@=     -@@::@% =@@=       -@%.            \n" +
                "      +%- .#@=  +@*    *@- :@@  +@#.    .%@*    =.-*.     \n" +
                "     -+     -%-  #@.  :@@=-%@@#.*@@:   :@%-        .+.    \n" +
                "     :=     .%+  #@   *@@@@=  @@@@@+   #@+         .+:    \n" +
                "       =-   -@= =%:  +@@@@@-  #@@@@@=  *@*  :#%%%*:*+     \n" +
                "           -@* -#. .%@@@@@@#  @@@@@@@%  @%-:#:   +@*      \n" +
                "          #@+  -. .@@@@@@@@@@@@@@@@@@@@  #%+-  .@+ #*     \n" +
                "        +@#.      #@@@@@@@@@@@@@@@@@@@@* .%*.  #@  :%:    \n" +
                "      :%@-       +@@@@@@@@@@@@@@@@@@@@@@: #+   *@- =%:    \n" +
                "     :%%.      -#@@@@@@@@@@@@@@@@@@@@@@@%-:     %@#@*     \n" +
                "     *@-  -@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#:    :@@%:     \n" +
                "     #@. .@@@#@@@@@@#@@@@@@@@@@@@@@@*@@@@@@@%= *@**@#.    \n" +
                "     *@= =+%- +#@@@@=@@@@@@@@@@@@@@@:%@@@@@@@@%=.  #@=    \n" +
                "     .#@*  --  -%@@@ @@@@@@@@@@@@@@@:-#@@@*.*@@@:  =@*    \n" +
                "       +@@*.   +@@@- @@@@@@@@@@@@@@@= :-@@= +=##+  +@*    \n" +
                "         +@@*  =@@:  @@@@@@@@@@@@@@@%   =@#.  =   :@@-    \n" +
                "      .:.  #@#: *@. -@@@@@@@@@@@@@@@@*   *%-     *@%=     \n" +
                "    :=. :%  #@*  #= #@@@@@@@@@@@@@@@@@*  *+   -#@@+       \n" +
                "    ::   ++ +@#. +..@@@@@@@@@@@@@@%%@@@= =  -%@@-         \n" +
                "         %- %@*    %@@%#@@@@@@@@@@@+%@@%   -@@=           \n" +
                "       -@= -@@-   #@@@#*@@@@@@@@@@@%:#@%  .#@+  #+.-#-    \n" +
                "      :%-  +@%: -%@@@%=@@@@@@@@@%@@@@.-@. .*@*  *   :*.   \n" +
                "      +@   .@@@@@@@@%:@@@@@@@@@@%*@@@@+ .: =@@:     :#.   \n" +
                "      :%#    .=#@@@+-@@@@@@@@@@@@*=%@@@%.  =@@=    -%=    \n" +
                "       .%@@##%@@@@= @@@@@@@@@@@@@@#:*@@@@@@@@%+*@@@%:     \n" +
                "          -*%@%%@@- +@@@@@@@@@@@@@@@%=-*%@@@@@%*:         \n" +
                "          .=**=-#@@@%#*=:-#@@@@#:=#%@@@@%-    .-=:        \n" +
                "         .    .*%@@@%#+-=#+ =%@@@@%*-  -#%@@%#-           \n" +
                "                                      :                   \n" +
                "                                                          "));
        System.out.println(ColorUtil.boldBrightRed("🧚 " + name + " attacks with Trickster Strike!"));
        PrintUtil.pause(800);
        if (target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        int damage = (int) RandomUtil.range(attack * 1.0, attack * 1.625);
        int reduced = calculateDamage(target, damage);

        System.out.println(ColorUtil.brightRed("→💔 Trickster Strike hits for ")
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

        if(RandomUtil.chance(30))
            target.getEffects().applyConfuse();

    }

    @Override
    public void displaySkills() {
        System.out.println();
        System.out.println(ColorUtil.boldBrightRed("┌─────────────────────────────── 👻 SHADE SPRITES SKILLS 👻 ──────────────────────────────┐"));
        System.out.println(ColorUtil.boldBrightYellow(" 👻 Skill – Trickster Strike"));
        System.out.println(ColorUtil.red(" 📜 Description : The Shade Sprites strike mischievously, leaving their target disoriented."));
        System.out.println(ColorUtil.red(" 💥 Damage : (") + ColorUtil.boldBrightYellow((int)(attack * 1.00) + " — " + (int)(attack * 1.625)) + ColorUtil.red(")"));
        System.out.println(ColorUtil.red(" ✨ Effects :"));
        System.out.println(ColorUtil.red("    - 30% chance to 😵 Confuse target"));
        System.out.println(ColorUtil.boldBrightRed("└─────────────────────────────────────────────────────────────────────────────────────────┘"));
        System.out.println();
    }


    @Override
    public void turn(Character target) {
        tricksterStrike(target);
    }

    @Override
    public void dropLoot(Character player){
        PrintUtil.pause(800);
        System.out.println();
        System.out.println(ColorUtil.boldBrightYellow("┬───────────────────────────────────┬"));
        System.out.println(ColorUtil.brightYellow("  🎁 You received:"));
        player.lootSoulShards(RandomUtil.range(1,2));
        player.getPotions().lootPotions(false);
        player.gainExp(rewardExp());
    }
    @Override
    public int rewardExp(){
        return RandomUtil.range(65,77);
    }
}
