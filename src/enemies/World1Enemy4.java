package enemies;

import characters.Character;
import inventory.Armor;
import utils.ColorUtil;
import utils.PrintUtil;
import utils.RandomUtil;

public class World1Enemy4 extends Enemy {
    // Constructor
    public World1Enemy4() {
        super("Carrion Bats", 81, 6, 25);
    }

    // Skill: Screech (6–8 damage, chance to confuse 1 turn)
    public void screech(Character target) {
        PrintUtil.print(ColorUtil.boldBrightRed("                                                          \n" +
                "                                                          \n" +
                "                                                          \n" +
                "         .*@@@@%*.                                        \n" +
                "            %@@@@@@@.                                     \n" +
                "            :@@@@@@@@@+:             .%@@@@@@%            \n" +
                "            #@@@@@@@@%@.          =@@@@@@@@.              \n" +
                "              +@@@@#%@@   @#*   +@#@@@%#%@                \n" +
                "               .@@*@@@@=  @@%@@@%##@@@@%=:  *%            \n" +
                "                @@@@@@@@+ :@@@*%@=*@@+   :@: =@           \n" +
                "                @@@@@@@@@@@@@@%+=%=@=  %* :@  *@          \n" +
                "                   :@@@@@@@@@@+@%    @  @. #+ -@          \n" +
                "                    -@@@@@@@@@##*   *# .@  %= =@          \n" +
                "                    :@@@@@@@@:        :@. ##  @-          \n" +
                "                  :%#%@@@@%              @=  @=           \n" +
                "                      @: :@                +@             \n" +
                "                     :                                    \n" +
                "                                                          \n" +
                "                                                          \n" +
                "                                                          "));
        System.out.println(ColorUtil.boldBrightRed("🦇 " + name + " screeches loudly at the target!"));

        PrintUtil.pause(800);
        if (target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        int damage = (int) RandomUtil.range(attack * 1.0, attack * 1.33);
        int reduced = calculateDamage(target, damage);

        System.out.println(ColorUtil.brightRed("→💔 Screech hits for ")
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

        // 30% chance to apply Weaken (ATK debuff 20% for 2 turns) — check debuff immunity first
        if (RandomUtil.chance(30)) {
            if (equippedArmor != null && equippedArmor.checkDebuffImmunity()) {
                System.out.println("✨ " + target.getName() + " resisted Weaken 💢 due to " + equippedArmor.getName() + "!");
                PrintUtil.pause(800);
            } else {
                target.getEffects().applyAttackDebuff(20, 2);
            }
        }
    }

    @Override
    public void displaySkills() {
        System.out.println();
        System.out.println(ColorUtil.boldBrightRed("┌──────────────────────────────────── 🦇 CARRION BATS SKILLS 🦇 ──────────────────────────────────┐"));
        System.out.println(ColorUtil.boldBrightYellow("  🗣️ Skill – Screech"));
        System.out.println(ColorUtil.red(" 📜 Description : The bats emit a piercing screech, unsettling their foe and lowering their attack."));
        System.out.println(ColorUtil.red(" 💥 Damage : (") + ColorUtil.boldBrightYellow((int)(attack * 1.00) + " — " + (int)(attack * 1.33)) + ColorUtil.red(")"));
        System.out.println(ColorUtil.red(" ✨ Effects :"));
        System.out.println(ColorUtil.red("    - 30% chance to 💢 Weaken: reduces target’s ATK by 20% for 2 turns"));
        System.out.println(ColorUtil.boldBrightRed("└─────────────────────────────────────────────────────────────────────────────────────────────────┘"));
        System.out.println();
    }



    @Override
    public void turn(Character target) {
        screech(target);
    }

    @Override
    public void dropLoot(Character player){
        PrintUtil.pause(800);
        System.out.println();
        System.out.println(ColorUtil.boldBrightYellow("┬───────────────────────────────────┬"));
        System.out.println(ColorUtil.brightYellow("  🎁 You received:"));
        player.lootSoulShards(1);
        player.getPotions().lootPotions(false);
        player.gainExp(rewardExp());
    }

    @Override
    public int rewardExp(){
        return RandomUtil.range(33,37);
    }
}
