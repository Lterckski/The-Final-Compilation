package characters;

import enemies.Enemy;
import enemies.FinalBoss;
import utils.ColorUtil;
import utils.InputUtil;
import utils.PrintUtil;
import utils.RandomUtil;

import java.awt.*;

public class Kael extends  Character{      // 15% crit chance

    public Kael() {
        super("Kael Saint Laurent", "Swordsman" ,100, 5, 100, 10);
    }

    @Override
    public void displaySkills() {
        System.out.println();
        System.out.println(ColorUtil.boldBrightCyan("┌────────────────────────────────────── ⚔️ KAEL'S SKILLS ⚔️ ───────────────────────────────────────┐"));

// Passive
        System.out.println("  " + ColorUtil.boldBrightYellow("✨ Passive – Blade Swift"));
        System.out.println("  " + ColorUtil.cyan("15% chance to deal a Critical Hit (") + ColorUtil.boldBrightYellow("×1.5") + ColorUtil.cyan(" damage)."));
        System.out.println("  " + ColorUtil.cyan("Effect: When a Critical Hit occurs, 🔋 Kael gains ") + ColorUtil.boldBrightYellow("+5%") + ColorUtil.cyan(" Stamina.\n"));

// Skill 1
        System.out.println("  " + ColorUtil.boldBrightYellow("🗡️ Skill 1 – Blade Rush (🔋 5 Stamina)"));
        System.out.println("  " + ColorUtil.cyan("📜 Description: A quick, fluid slash that catches the opponent off guard."));
        System.out.println("  " + ColorUtil.cyan("💥 Damage: (") + ColorUtil.boldBrightYellow((int)(attack * 1.15) + " — " + (int)(attack * 1.35)) + ColorUtil.cyan(")"));
        System.out.println("  " + ColorUtil.cyan("⚡ Effects:"));
        System.out.println("    - " + ColorUtil.cyan("💪 30% chance to apply Strengthen (+20% ATK for 2 turns)\n"));

// Skill 2
        System.out.println("  " + ColorUtil.boldBrightYellow("⚔️ Skill 2 – Piercing Slash (🔋 10 Stamina)"));
        System.out.println("  " + ColorUtil.cyan("📜 Description: A powerful, focused strike aimed to pierce enemy's armor."));
        System.out.println("  " + ColorUtil.cyan("💥 Damage: (") + ColorUtil.boldBrightYellow((int)(attack * 1.35) + " — " + (int)(attack * 1.55)) + ColorUtil.cyan(") — Ignores Defense"));
        System.out.println("  " + ColorUtil.cyan("⚡ Effects:"));
        System.out.println("    - " + ColorUtil.cyan("💫 30% chance to Stun (1 turn)\n"));

// Ultimate
        System.out.println("  " + ColorUtil.boldBrightYellow("✝️ Ultimate – Eternal Cross Slash (🔋 20 Stamina)"));
        System.out.println("  " + ColorUtil.cyan("📜 Description: Kael unleashes a flurry of crossing strikes infused with unyielding determination."));
        System.out.println("  " + ColorUtil.cyan("💥 Damage: 3 hits, each dealing (") + ColorUtil.boldBrightYellow((int)(attack * 1.40) + " — " + (int)(attack * 2.20)) + ColorUtil.cyan(")"));
        System.out.println("  " + ColorUtil.cyan("⚡ Effects:"));
        System.out.println("    - " + ColorUtil.cyan("🩸 Applies Bleed (10 damage per turn for 2 turns)"));
        System.out.println("    - " + ColorUtil.cyan("🛡️ Grants Fortified (+20% DEF for 2 turns)"));

        System.out.println(ColorUtil.boldBrightCyan("└───────────────────────────────────────────────────────────────────────────────────────────────────┘"));
        System.out.println();
    }

    public void showBackstory() {
        System.out.println();
        System.out.println(ColorUtil.boldBrightCyan  ("┌───────────────────────────── 📘 KAEL'S BACKSTORY 📘 ─────────────────────────────┐"));
        System.out.println(ColorUtil.brightYellow("  Kael Saint Laurent was born in the shadow of the Black Castle, in a family that"));
        System.out.println(ColorUtil.brightYellow("  lived modestly within the crumbling Town of Decay. His childhood was"));
        System.out.println(ColorUtil.brightYellow("  marked by sickness in the streets and guards demanding bribes, yet Kael never"));
        System.out.println(ColorUtil.brightYellow("  let the rot of the world steal his spirit. He spent hours watching the castle"));
        System.out.println(ColorUtil.brightYellow("  soldiers train, imitating their sword movements with sticks until his hands"));
        System.out.println(ColorUtil.brightYellow("  blistered, slowly turning mimicry into skill."));
        System.out.println();
        System.out.println(ColorUtil.brightYellow("  Even as a child, he carried himself with the bearing of a leader. Kael would"));
        System.out.println(ColorUtil.brightYellow("  gather the other children of the town into ragtag games of knights and kings,"));
        System.out.println(ColorUtil.brightYellow("  but unlike the corrupted rulers above, he always played the protector—"));
        System.out.println(ColorUtil.brightYellow("  shielding his friends from imagined dangers. In a place where hope was rare,"));
        System.out.println(ColorUtil.brightYellow("  Kael's presence became a quiet anchor, hinting that even in the midst of"));
        System.out.println(ColorUtil.brightYellow("  decay, someone could rise to stand against the darkness."));
        System.out.println(ColorUtil.boldBrightCyan("└──────────────────────────────────────────────────────────────────────────────────┘"));
        System.out.println();
    }

    // Passive - Blade Swift
    private int bladeSwift(int damage) {
        if (RandomUtil.chance(15)) {
            System.out.println(ColorUtil.brightMagenta("⚡ Critical Hit! Blade Swift activated!"));
            PrintUtil.pause(800);
            damage = (int) (damage * 1.5);

            // Gain +5% of max energy (bonus adrenaline)
            int energyGained = (int)(maxEnergy * 0.05);
            energy += energyGained;
            if (energy > maxEnergy) energy = maxEnergy;
            System.out.println(ColorUtil.brightMagenta("✨ Gained +" + energyGained + " energy from precision! (" + energy + "/" + maxEnergy + ")"));
            PrintUtil.pause(800);
        }
        return damage;
    }

    // Skill 1 - Blade Rush
    public void bladeRush(Character target){
        PrintUtil.type(ColorUtil.boldBrightGreen("                                                          \n" +
                "                .........                                 \n" +
                "            .:-:.::-::...                                 \n" +
                "         ..:..::.                                         \n" +
                "        .:.::.                -@%-                        \n" +
                "       .: .:.                .#%#%*-.                     \n" +
                "       .:. ::.              .=@@*=:                       \n" +
                "        .:...--:..         :%@%%#@%-                      \n" +
                "          ..:::===--:. ..:*@##%#%%+.                      \n" +
                "                   .:=+*%%%###@@@@=                       \n" +
                "                      ....::-#@%@@%=.                     \n" +
                "                           .#@@@@@@@+.                    \n" +
                "                           :#@%@@#%@%=                    \n" +
                "                          :#@#:   .+%%.                   \n" +
                "                         :#@-.     -#%.                   \n" +
                "                        :*=.        -%:                   \n" +
                "                       .*%:         -%%#:                 \n" +
                "                                                          "));
        int energyCost = 5;
        if(!consumeEnergy(energyCost)){
            System.out.println(ColorUtil.boldBrightRed("❌ Not enough Stamina to use Blade Rush!"));
            PrintUtil.pause(800);
            return;
        }

        System.out.println(ColorUtil.boldBrightGreen("🗡️ You used Blade Rush on " + target.getName() + " (🔋-" + energyCost + " Stamina)"));
        PrintUtil.pause(800);

        if(this.getEffects().checkConfuse()) return;

        int damage = (int) RandomUtil.range(attack * 1.15,attack * 1.35);
        damage = bladeSwift(damage);
        int reduced = calculateDamage(target, damage);

        System.out.println(
                ColorUtil.brightGreen("💔 Target is hit for ") +
                        ColorUtil.boldBrightWhite(String.valueOf(reduced)) +
                        ColorUtil.brightGreen(" Damage!")
        );

        PrintUtil.pause(800);
        target.takeDamage(reduced);

        // 30% chance to apply Strengthen (+20% ATK for 2 turns)
        if (RandomUtil.chance(30)) {
            getEffects().applyAttackBuff(20, 2);
        }

        this.getWeapon().applyEffects(this,target,reduced);
    }

    // Skill 2 - Piercing Slash
    public void piercingSlash(Character target){
        PrintUtil.type(ColorUtil.boldBrightGreen("                                                          \n" +
                "                               ...                        \n" +
                "                              .=@@*.                      \n" +
                "                              :@@*+=:                     \n" +
                "                             -*@@%%=.                     \n" +
                "  ................         .=%@%##@%:                     \n" +
                "    ....................::-#%**%%%%=.                     \n" +
                "              ..........:+##%#*@@@@=.                     \n" +
                "                       ... . :@@@@@@+.                    \n" +
                "                             %@@@@@@@=.                   \n" +
                "                            =*@%++=*@%+                   \n" +
                "                           -#@+.    *%*                   \n" +
                "                          :%#.      -%#                   \n" +
                "                         -#-         =%:                  \n" +
                "                        .=*.         :=**:                \n" +
                "                                                          "));
        int energyCost = 10;
        if(!consumeEnergy(energyCost)){
            System.out.println(ColorUtil.boldBrightRed("❌ Not enough Stamina to use Piercing Slash!"));
            PrintUtil.pause(800);
            return;
        }

        System.out.println(ColorUtil.boldBrightGreen("⚔\uFE0F You used Piercing Slash on " + target.getName() + " (🔋-" + energyCost + " Stamina)"));
        PrintUtil.pause(800);

        if(this.getEffects().checkConfuse()) return;

        int damage = (int) RandomUtil.range(attack * 1.35,attack * 1.55);
        int reduced = bladeSwift(damage);

        System.out.println(
                ColorUtil.brightGreen("💔 Target is hit for ")
                        + ColorUtil.boldBrightWhite(String.valueOf(reduced))
                        + ColorUtil.brightGreen(" Pure Damage!")
        );

        PrintUtil.pause(800);
        target.takeDamage(reduced);

        // 30% chance to apply Stun (from the sheer impact)
        if (RandomUtil.chance(30)) {
            target.getEffects().applyStun();
            if (target instanceof FinalBoss fb) fb.applyStun();
        }

        this.getWeapon().applyEffects(this,target,reduced);
    }

    //Ultimate - Eternal Cross Slash
    public void eternalCrossSlash(Character target){
        PrintUtil.type(ColorUtil.boldBrightGreen("                                                          \n" +
                "                                ..:.                      \n" +
                "             .:--:   ::::::--:        :.                  \n" +
                "          .:.   .--.    ..   -=::::--- .                  \n" +
                "        :: . .:.      .: :::                              \n" +
                "       .  . :.       :::-.     +@@=                       \n" +
                "       . .  :.      .:::      -@%==:      ...             \n" +
                "       ...   ..     .:.      -#@%%#-     ..:::            \n" +
                "         :::..:-=-::::      =%%%#*%*      .:-::.          \n" +
                "             .:..:+*+=-:::-#%=*%%%%:     .::::::-         \n" +
                "                  ..   .=**##**%%@%:     ::-. ...:        \n" +
                "                   .         :@@%%@@=  .:.-.   :  :       \n" +
                "                             @@%@@%%@-:..:.    .: -       \n" +
                "                            =#@#==:*%-  ..     :. :.      \n" +
                "                        .  -#@:   ::   :   .:.:   .       \n" +
                "                          :+*::--.  :#*     :.   ..       \n" +
                "                        .:       ::. -%                   \n" +
                "                         ==...        -+=                 \n" +
                "                                                          "));
        int energyCost = 20;
        if (!consumeEnergy(energyCost)) {
            System.out.println(ColorUtil.boldBrightRed("❌ Not enough Stamina to use Eternal Cross Slash!"));
            PrintUtil.pause(800);
            return;
        }

        int totalDamage = 0;
        System.out.println(ColorUtil.boldBrightGreen("✝️ You unleash your ultimate technique: Eternal Cross Slash!" + " (🔋-" + energyCost + " Stamina)"));
        PrintUtil.pause(800);

        for(int i = 1; i <= 3; i++){
            int damage = (int) RandomUtil.range(attack * 1.40,attack * 2.20);
            damage = bladeSwift(damage);
            int reduced = calculateDamage(target, damage);

            if(this.getEffects().checkConfuse()) reduced = 0;
            totalDamage += reduced;

            System.out.println(
                    ColorUtil.brightGreen(" →🔪 Hit " + i + "! 💔 You slashed the Target for ")
                            + ColorUtil.boldBrightWhite(String.valueOf(reduced))
                            + ColorUtil.brightGreen(" damage!")
            );

            PrintUtil.pause(800);

        }

        System.out.println(
                ColorUtil.brightGreen("⚔️💥 Eternal Cross Slash finished! Total Damage dealt: ")
                        + ColorUtil.boldBrightWhite(String.valueOf(totalDamage))
        );

        PrintUtil.pause(800);

        target.takeDamage(totalDamage);
        target.getEffects().applyBleed(2);

        this.getWeapon().applyEffects(this,target,totalDamage);
        this.getEffects().applyDefenseBuff(20, 2);

        ultimateCounter = 3;
    }

    @Override
    public void turn(Character target) {
        boolean isValid = false;

        while (!isValid) {
            // If ultimate is on cooldown
            if (ultimateCounter > 0) {
                System.out.println(ColorUtil.boldBrightGreen("[1]") + " " + ColorUtil.green("⚔️ Skill 1   -  Blade Rush (🔋 5 Stamina)"));
                System.out.println(ColorUtil.boldBrightGreen("[2]") + " " + ColorUtil.green("🛡️ Skill 2   -  Piercing Slash (🔋 10 Stamina)"));
                System.out.println(ColorUtil.boldBrightGreen("[3]") + " " + ColorUtil.green("✨ Ultimate  -  Eternal Cross Slash (🔋 20 Stamina) ")
                        + ColorUtil.red("❌ (Available in " + ultimateCounter + " turns)"));
                System.out.println(ColorUtil.boldBrightGreen("[4]") + " " + ColorUtil.green("\uD83D\uDEE1\uFE0F Skip Turn -  Restore 10% of Max HP and 20 Stamina"));
                System.out.println(ColorUtil.boldBrightGreen("[5]") + " " + ColorUtil.green("📜 Show Menu"));
                System.out.print(ColorUtil.boldBrightWhite("Choose your action: "));

                int choice = InputUtil.scanInput();
                PrintUtil.shortLine();

                switch (choice) {
                    case 1 -> { bladeRush(target); isValid = true; ultimateCounter--; }
                    case 2 -> { piercingSlash(target); isValid = true; ultimateCounter--; }
                    case 3 -> {
                        System.out.println(ColorUtil.red("❌ Ultimate is on cooldown! Can only be used after " + ultimateCounter + " turns."));
                        PrintUtil.line();
                    }
                    case 4 -> { skipTurn(); isValid = true; ultimateCounter--; }
                    case 5 -> displayMenu(this, target);
                    default -> {
                        System.out.println(ColorUtil.boldBrightRed("❌ Invalid action! You missed your turn."));
                        PrintUtil.pause(800);
                        isValid = true;
                        ultimateCounter--;
                    }
                }

            } else { // Ultimate ready
                System.out.println(ColorUtil.boldBrightGreen("[1]") + " " + ColorUtil.green("⚔️ Skill 1   -  Blade Rush (🔋 5 Stamina)"));
                System.out.println(ColorUtil.boldBrightGreen("[2]") + " " + ColorUtil.green("🛡️ Skill 2   -  Piercing Slash (🔋 10 Stamina)"));
                System.out.println(ColorUtil.boldBrightGreen("[3]") + " " + ColorUtil.green("✨ Ultimate  -  Eternal Cross Slash (🔋 20 Stamina)"));
                System.out.println(ColorUtil.boldBrightGreen("[4]") + " " + ColorUtil.green("\uD83D\uDEE1\uFE0F Skip Turn -  Restore 10% of Max HP and 20 Stamina"));
                System.out.println(ColorUtil.boldBrightGreen("[5]") + " " + ColorUtil.green("📜 Show Menu"));
                System.out.print(ColorUtil.boldBrightWhite("Choose your action: "));

                int choice = InputUtil.scanInput();
                PrintUtil.shortLine();

                switch (choice) {
                    case 1 -> { bladeRush(target); isValid = true; }
                    case 2 -> { piercingSlash(target); isValid = true; }
                    case 3 -> { eternalCrossSlash(target); isValid = true; }
                    case 4 -> { skipTurn(); isValid = true; }
                    case 5 -> displayMenu(this, target);
                    default -> {
                        System.out.println(ColorUtil.boldBrightRed("❌ Invalid action! You missed your turn."));
                        PrintUtil.pause(800);
                        isValid = true;
                    }
                }
            }
        }
    }


}
