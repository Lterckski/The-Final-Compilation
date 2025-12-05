package enemies;

import characters.Character;
import inventory.Armor;
import inventory.Bow;
import inventory.Staff;
import inventory.Sword;
import utils.ColorUtil;
import utils.PrintUtil;
import utils.RandomUtil;

public class World1Miniboss1 extends Enemy {
    // Constructor
    public World1Miniboss1() {
        super("The Hollow Stag", 211, 13, 67);
    }

    // Skill 1: Deathly Charge (ATK × 1.00–1.20), 30% chance to Stun
    public void deathlyCharge(Character target) {
        PrintUtil.print(ColorUtil.boldBrightRed("                                                          \n" +
                "                                                          \n" +
                "                    :       .=                            \n" +
                "                     +       :+                           \n" +
                "                    -#      .#*                           \n" +
                "                 :*%=  :*#%@#.                            \n" +
                "                -#*  :%@#:                                \n" +
                "           -    +%= =%%*+*+.   -:                         \n" +
                "           %==%@%%%.%%@%+=*@#=*#.                         \n" +
                "            ..   +@@%@@@@@@===                            \n" +
                "               .+#%@@@%#%@@@@@=                           \n" +
                "                 :%@@@@@@@@@@@@%-                         \n" +
                "                 -%@@%%@@@@%@@@@%*.                       \n" +
                "                  :#%-@@@@@@%@@@@#:                       \n" +
                "                   :=+@@@@@@@@@@@%=                       \n" +
                "                 :@@#*%@@%@@@@@@@@-                       \n" +
                "                 .@=+#@%%@@@@%@@@@+          ::           \n" +
                "                 .%% *@#@%%%#@@@@@@#.       =@-           \n" +
                "                  .@%:@#+#@@@@@@@@@@@=      +@+           \n" +
                "                      =-   +@@@%@@@@@=       -            \n" +
                "                           #@%@%@@@@@%=      -            \n" +
                "                          .%@@@%@@@@+ *%.   =:            \n" +
                "                           %@@@*#@@@-   .==:              \n" +
                "                            .%@%:.#@@+                    \n" +
                "                              *%.  :%=                    \n" +
                "                             .@=   :%.                    \n" +
                "                            +@#.   *@:                    \n" +
                "                           -#*    +%#                     \n" +
                "                                                          "));
        System.out.println(ColorUtil.boldBrightRed("🦌 " + name + " charges with Deathly Charge!"));
        PrintUtil.pause(800);
        if (target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        int damage = (int) RandomUtil.range(attack * 1.00, attack * 1.20);
        int reduced = calculateDamage(target, damage);

        System.out.println(ColorUtil.brightRed("→💔 Deathly Charge hits for ")
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

        // 30% chance to stun
        if (RandomUtil.chance(30)) {
            target.getEffects().applyStun();
        }

    }

    // Skill 2: Blackened Howl (reduces target DEF by 20% for 2 turns)
    public void blackenedHowl(Character target) {
        PrintUtil.print(ColorUtil.boldBrightRed("                                                          \n" +
                "                                               .          \n" +
                "                                      .  :....:           \n" +
                "                   :           .:      :.... ....         \n" +
                "                   +         +-        -..  .  ::         \n" +
                "                 +-         #-         -.:.  . .:         \n" +
                "                +-          =#=::.     -... :.:. .        \n" +
                "                +=       .--::=+##=. :..:                 \n" +
                "                :*=-::-=+%%%%%%+=##*-::                   \n" +
                "                  :*###+:    .*%@%##*+                    \n" +
                "                            .#%@@@%%@+.                   \n" +
                "                           =%@%@@@@@%%:                   \n" +
                "                         -#@@@@@@@@%--                    \n" +
                "                        -%@@@@@@@@@@=                     \n" +
                "                       -%@@@@@@@@@%%#                     \n" +
                "              :+   :=+%@@@%@@@@@@@@%+                     \n" +
                "               =**#@@@@@@@@@@@%@@@@%-                     \n" +
                "                 *@@@@@@@@@@@@%@@@@@@%#.                  \n" +
                "                .#@%@@%@@@@@@@%@#.   -@:                  \n" +
                "                :%@@@*-@@@@*.  ##    -@-                  \n" +
                "              .*@@@@+ :%@@%.   %*   .#@                   \n" +
                "              :%+     +@=     +%=   -%.                   \n" +
                "              -%.      :%=    %*                          \n" +
                "              +@:       :%#.                              \n" +
                "             .+#+::--++=**++=+--:....                     \n" +
                "                        .                                 \n" +
                "                                                          "));
        System.out.println(ColorUtil.boldBrightRed("🗣️ " + name + " unleashes Blackened Howl!"));
        PrintUtil.pause(800);
        if (target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        Armor equippedArmor = target.getInventory().getEquippedArmor();
        if (equippedArmor != null && equippedArmor.checkDebuffImmunity()) {
            System.out.println(ColorUtil.brightMagenta("✨ " + target.getName() + " resisted Fragile 🛡️↓ due to " + equippedArmor.getName() + "!"));
            PrintUtil.pause(800);
        } else {
            target.getEffects().applyDefenseDebuff(20, 2);
        }
    }

    @Override
    public void displaySkills() {
        System.out.println();
        System.out.println(ColorUtil.boldBrightRed("┌──────────────────────────── 🦌 THE HOLLOW STAG SKILLS 🦌 ──────────────────────────────┐"));

        System.out.println(ColorUtil.boldBrightYellow("  ⚡ Skill 1 – Deathly Charge"));
        System.out.println(ColorUtil.red(" 📜 Description : The Hollow Stag charges with deadly force, attempting to stun its foe."));
        System.out.println(ColorUtil.red(" 💥 Damage : (") + ColorUtil.boldBrightYellow((int)(attack * 1.00) + " — " + (int)(attack * 1.20)) + ColorUtil.red(")"));
        System.out.println(ColorUtil.red(" ✨ Effects :"));
        System.out.println(ColorUtil.red("    - 30% chance to 😵 Stun the target"));
        System.out.println();

        // Skill 2
        System.out.println(ColorUtil.boldBrightYellow("  🌑 Skill 2 – Blackened Howl"));
        System.out.println(ColorUtil.red(" 📜 Description : The stag lets out a blackened howl, weakening its opponent's defenses."));
        System.out.println(ColorUtil.red(" 💥 Damage : —"));
        System.out.println(ColorUtil.red(" ✨ Effects :"));
        System.out.println(ColorUtil.red("    - Reduces target’s 🛡️ DEF by 20% for 2 turns"));

        System.out.println(ColorUtil.boldBrightRed("└────────────────────────────────────────────────────────────────────────────────────────┘"));
        System.out.println();
    }




    @Override
    public void turn(Character target) {
        // Prioritize debuff if not active, else use main attack
        if (!target.getEffects().hasDefDebuff()) {
            blackenedHowl(target);
        } else {
            deathlyCharge(target);
        }
    }

    @Override
    public void dropLoot(Character player) {
        PrintUtil.pause(800);
        System.out.println();
        System.out.println(ColorUtil.boldBrightYellow("┬───────────────────────────────────┬"));
        System.out.println(ColorUtil.brightYellow("  🎁 You received:"));
        player.lootSoulShards(10);
        player.getPotions().lootPotions(true);
        player.gainExp(rewardExp());

        if (player.getClassType().equals("Swordsman")) {
            Sword ironShortsword = Sword.IRON_SHORTSWORD;
            PrintUtil.type(ColorUtil.boldBrightGreen("                                                       \n" +
                    "                                                       \n" +
                    "                          .+.                          \n" +
                    "                          -@-                          \n" +
                    "                          -@=                          \n" +
                    "                          =@=                          \n" +
                    "                          =@+                          \n" +
                    "                          +@+                          \n" +
                    "                          +@+                          \n" +
                    "                          +@+                          \n" +
                    "                          +@*                          \n" +
                    "                          *@*                          \n" +
                    "                          *@*                          \n" +
                    "                          *%#                          \n" +
                    "                          #%#                          \n" +
                    "                          #%#                          \n" +
                    "                          #%#.                         \n" +
                    "                          %%%.                         \n" +
                    "                          %#%.                         \n" +
                    "                          %#%.                         \n" +
                    "                          %#%.                         \n" +
                    "                         .%#%:                         \n" +
                    "                     .:.::+%+::::.                     \n" +
                    "                          =@+                          \n" +
                    "                          =%+                          \n" +
                    "                          =@=                          \n" +
                    "                          :%-                          \n" +
                    "                          #@#                          \n" +
                    "                          .=.                          \n" +
                    "                                                       "));
            if (ironShortsword.lootWeapon()) {
                ironShortsword.equip(player);
            }
        } else if (player.getClassType().equals("Archer")) {
            Bow oakLongbow = Bow.OAK_LONGBOW;
            PrintUtil.type(ColorUtil.boldBrightGreen("                                                       \n" +
                    "                                                       \n" +
                    "                                                       \n" +
                    "                                                       \n" +
                    "                         -                             \n" +
                    "                        .#                             \n" +
                    "                        -#-                            \n" +
                    "                        . +*.                          \n" +
                    "                       :    =*:                        \n" +
                    "                      .       -#                       \n" +
                    "                      .        .*:                     \n" +
                    "                     .          -*                     \n" +
                    "                     .          :*.                    \n" +
                    "                    .           +@-                    \n" +
                    "                   .-          .@#-:                   \n" +
                    "                    :           ##:                    \n" +
                    "                     .          +%:                    \n" +
                    "                     .          :*.                    \n" +
                    "                     .          -*                     \n" +
                    "                      .        .#.                     \n" +
                    "                      .       =*                       \n" +
                    "                       :   .+*.                        \n" +
                    "                        : ++                           \n" +
                    "                        :#-                            \n" +
                    "                        .#                             \n" +
                    "                         -                             \n" +
                    "                                                       \n" +
                    "                                                       \n" +
                    "                                                       \n" +
                    "                                                       "));
            if (oakLongbow.lootWeapon()) {
                oakLongbow.equip(player);
            }
        } else if (player.getClassType().equals("Mage")) {
            Staff apprenticeStaff = Staff.APPRENTICE_STAFF;
            PrintUtil.type(ColorUtil.boldBrightGreen("                                                       \n" +
                    "                                                       \n" +
                    "                          :+.                          \n" +
                    "                          +@=                          \n" +
                    "                          =@-                          \n" +
                    "                          :%:                          \n" +
                    "                          :%:                          \n" +
                    "                          :%:                          \n" +
                    "                          :%:                          \n" +
                    "                          :%:                          \n" +
                    "                          :%:                          \n" +
                    "                          :%:                          \n" +
                    "                          :%:                          \n" +
                    "                          :%:                          \n" +
                    "                          :%:                          \n" +
                    "                          :%:                          \n" +
                    "                          :%:                          \n" +
                    "                          :%:                          \n" +
                    "                          :%:                          \n" +
                    "                          :%:                          \n" +
                    "                          :%:                          \n" +
                    "                          :%:                          \n" +
                    "                          :%:                          \n" +
                    "                          .=.                          \n" +
                    "                                                       \n" +
                    "                                                       "));
            if (apprenticeStaff.lootWeapon()) {
                apprenticeStaff.equip(player);
            }
        }
        PrintUtil.pause(800);

        Armor ironVanguard = Armor.IRON_VANGUARD;
        PrintUtil.type(ColorUtil.boldBrightGreen("                                                       \n" +
                "                                                       \n" +
                "                                                       \n" +
                "                     -#%###*###%#-                     \n" +
                "                     -=. .:-:. .=-                     \n" +
                "                     =:    :    :=                     \n" +
                "                    .*%%. -#- .%%*.                    \n" +
                "                   .%@@@@@@#@@@@@@#.                   \n" +
                "                    *@@@@@@%@@@@@@*                    \n" +
                "                    :%@@@@@@@@@@@%:                    \n" +
                "                     =#@@@@@@@@@%=                     \n" +
                "                     +#*%@@@@@%*#+                     \n" +
                "                    =@@#*+***+*#@@=                    \n" +
                "                   :@@#%#@@@@@#%#@@:                   \n" +
                "                   *@@%%@+=.=+%%%%@*                   \n" +
                "                   @@@@@*.   .*@@@@@                   \n" +
                "                   -+#%#=     =#%#+-                   \n" +
                "                                                       \n" +
                "                                                       "));
        if (ironVanguard.lootArmor()) {
            ironVanguard.equip(player);
        }
    }
    @Override
    public int rewardExp(){return 538;}
}
