package enemies;

import characters.Character;
import utils.ColorUtil;
import utils.InputUtil;
import utils.PrintUtil;
import utils.RandomUtil;
import inventory.*;

import java.awt.*;

public class World2Miniboss2 extends Enemy {
    public World2Miniboss2() {
        super("Luther Von", 854, 32, 140);
    }

    public void crownOfDespair(Character target) {
        PrintUtil.type(ColorUtil.boldBrightRed("                                                          \n" +
                "                        ...:.. :.                         \n" +
                "                   :. .:.   ::::.. :..                    \n" +
                "                  :... .   ..:.  .:-.: .                  \n" +
                "               .. :: :-: .. .. ..:::..: :.:.              \n" +
                "              ..:..-:. ::::..  -.....:- ..::              \n" +
                "            ..:: .::. .:.           ::: ::..:.            \n" +
                "            .:.. : :        -=       . .:: :..            \n" +
                "           :  :.::    .=   -#%-   =.     .:.:..           \n" +
                "           .    :. +: .=-+-.##.:*-=:.:+ .:... ..          \n" +
                "         . :...:::  +.==#%%%*#%@%#+=.+  .:...:. :         \n" +
                "          ::. .: .  .#%%%%%#%%#%%%%%#:   ......           \n" +
                "         .: .::. ..  -%#*###**#####%-  ... .::.:          \n" +
                "          :  :.:.     %%#**#**#**#%%.  ::-.  :.:          \n" +
                "           ::....: .  =*%@%%##%%@%#=  . ::.-::            \n" +
                "           : ...:::...               ..:::.:.::           \n" +
                "            ..::.:.:.   ... .  ..  ..::..:.               \n" +
                "              :.. .:-:-. .: .-.. ..:::-  ...              \n" +
                "                 .:.::..::-: ..--:..: .. :                \n" +
                "                .::.....   ::..::...:.:. .                \n" +
                "                    -. :.    ...:...:.                    \n" +
                "                          .::::::.                        \n" +
                "                                                          "));
        System.out.println("👑 " + name + " casts Crown of Despair!");
        PrintUtil.pause(800);
        if(target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        // Check immunity to debuff
        Armor equippedArmor = target.getInventory().getEquippedArmor();
        if (equippedArmor != null && equippedArmor.checkDebuffImmunity()) {
            System.out.println("✨ " + target.getName() + " resisted Weaken 👑 due to " + equippedArmor.getName() + "!");
            PrintUtil.pause(800);
        } else{
            target.getEffects().applyAttackDebuff(20, 2);
        }
    }

    public void darkJudgement(Character target){
        PrintUtil.type(ColorUtil.boldBrightRed("                                                          \n" +
                "                          ::  ::                          \n" +
                "                         +@@-#@@*                         \n" +
                "                         -%@+%@%:                         \n" +
                "                           -+@-                           \n" +
                "                    +                                     \n" +
                "                    =*=     *%=       .#+                 \n" +
                "                     =:.   +%@%:      ++*                 \n" +
                "                     :#= .=#@@@+      :#                  \n" +
                "                      #%*%@%%%%%+     --                  \n" +
                "                     .@@%%@@@%@%%=    *                   \n" +
                "                     .%%%%%@@@@@%%*=-+#                   \n" +
                "                 .    +#@@%%@%%%%@@%%*=                   \n" +
                "                     .#@@@%%%@%%%%%%#*   .                \n" +
                "               -:   =%@@@%%@%@#%%%===+    .               \n" +
                "               -.  +%@@@@@@@@@%@@%*.::   .=               \n" +
                "              .+.  %@@@@%%@@@@%@@%%++  . :+               \n" +
                "               ++. = %@@%%@@%#@%@%%%+  ::#=               \n" +
                "               :*+..  -#@@%%@@%@@%#+:-:.%#                \n" +
                "              ..=%@+%.*#%@%@%%@%#%==*:*%%:.               \n" +
                "                =#@@@%%%%#%@@%####%@@@@%--                \n" +
                "               .-*%%###%%#%@%#@%%#%%%%%%+..               \n" +
                "                        :-:       .                       \n" +
                "                                                          "));
        System.out.println("⚔️ " + name + " uses Dark Judgment!");
        PrintUtil.pause(800);
        if(target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        int damage = (int)RandomUtil.range(attack * 1.0, attack * 1.15);
        int reduced = calculateDamage(target, damage);

        System.out.println(ColorUtil.brightRed("→💔 Dark Judgment hits for ")
                + ColorUtil.boldBrightWhite(String.valueOf(reduced))
                + ColorUtil.brightRed(" damage!"));
        PrintUtil.pause(800);
        target.takeDamage(reduced);


        //Reflect damage check
        Armor equippedArmor = target.getInventory().getEquippedArmor();
        if (equippedArmor != null) {
            int reflectDamage = equippedArmor.checkReflectDamage(reduced);
            if (reflectDamage > 0) {
                System.out.println("🪞 " + equippedArmor.getName() + " reflected " + reflectDamage + " damage back to " + name + "!");
                PrintUtil.pause(800);
                this.takeDamage(reflectDamage);
            }
        }
    }

    public void kingsWrath(Character target){
        System.out.println(ColorUtil.boldBrightRed("🔥 " + name + " unleashes King's Wrath!"));
        PrintUtil.pause(800);
        if(target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        int damage = (int)RandomUtil.range(attack * 0.71, attack * 0.85);
        int reduced = calculateDamage(target, damage);

        System.out.println(ColorUtil.brightRed("→💔 King's Wrath hits for ")
                + ColorUtil.boldBrightWhite(String.valueOf(reduced))
                + ColorUtil.brightRed(" damage!"));
        PrintUtil.pause(800);
        target.takeDamage(reduced);


        Armor equippedArmor = target.getInventory().getEquippedArmor();

        // Reflect damage check
        if (equippedArmor != null) {
            int reflectDamage = equippedArmor.checkReflectDamage(reduced);
            if (reflectDamage > 0) {
                System.out.println("🪞 " + equippedArmor.getName() + " reflected " + reflectDamage + " damage back to " + name + "!");
                PrintUtil.pause(800);
                this.takeDamage(reflectDamage);
            }
        }

        // chance to Stun
        if (RandomUtil.chance(30)) {
            target.getEffects().applyStun();
        }

    }

    @Override
    public void displaySkills() {
        System.out.println();
        System.out.println(ColorUtil.boldBrightRed("┌──────────────────────────── 👑 THE CORRUPTED KING SKILLS 👑 ──────────────────────────────┐"));

        // Skill 1
        System.out.println(ColorUtil.boldBrightYellow("  💀 Skill 1 – Crown of Despair"));
        System.out.println(ColorUtil.red(" 📜 Description : The Corrupted King raises his crown, instilling fear and weakening his foe."));
        System.out.println(ColorUtil.red(" 💥 Damage : —"));
        System.out.println(ColorUtil.red(" ✨ Effects :"));
        System.out.println(ColorUtil.red("    - ⚔️ Reduces hero’s ATK by 20% for 2 turns (Weaken)"));
        System.out.println();

        // Skill 2
        System.out.println(ColorUtil.boldBrightYellow("  🌑 Skill 2 – Dark Judgement"));
        System.out.println(ColorUtil.red(" 📜 Description : A shadowy strike that crushes the hero with dark energy."));
        System.out.println(ColorUtil.red(" 💥 Damage : (") + ColorUtil.boldBrightYellow((int)(attack * 1.0) + " — " + (int)(attack * 1.15)) + ColorUtil.red(")"));
        System.out.println(ColorUtil.red(" ✨ Effects : —"));
        System.out.println();

        // Skill 3
        System.out.println(ColorUtil.boldBrightYellow("  🔥 Ultimate – King’s Wrath"));
        System.out.println(ColorUtil.red(" 📜 Description : The Corrupted King unleashes a furious strike, overwhelming his enemy."));
        System.out.println(ColorUtil.red(" 💥 Damage : (") + ColorUtil.boldBrightYellow((int)(attack * 0.71) + " — " + (int)(attack * 0.85)) + ColorUtil.red(")"));
        System.out.println(ColorUtil.red(" ✨ Effects :"));
        System.out.println(ColorUtil.red("    - ⚡ 30% chance to Stun the target"));

        System.out.println(ColorUtil.boldBrightRed("└────────────────────────────────────────────────────────────────────────────────────────┘"));
        System.out.println();
    }



    @Override
    public void turn(Character target) {
        if(!target.getEffects().hasAtkDebuff()){
            if (RandomUtil.chance(50)) crownOfDespair(target);
            else darkJudgement(target);
        } else{
            if (RandomUtil.chance(66)) darkJudgement(target);
            else kingsWrath(target);
        }
    }

    @Override
    public void dropLoot(Character player){
        PrintUtil.pause(800);
        System.out.println();
        System.out.println(ColorUtil.boldBrightYellow("┬───────────────────────────────────┬"));
        System.out.println(ColorUtil.brightYellow("  🎁 You received:"));
        player.lootSoulShards(14);
        player.getPotions().lootPotions(true);
        player.gainExp(rewardExp());

        // Check the class type
        if (player.getClassType().equals("Swordsman")) {
            Sword twinstrikeBlade = Sword.TWINSTRIKE_BLADE;   // +15 ATK, 10% chance for 2nd attack
            Sword lifebondBlade = Sword.LIFEBOND_BLADE;    // +15 ATK, restores 3% HP of damage dealt

            System.out.println("1️⃣ " + twinstrikeBlade.getName() + " → +15 ATK, 10% chance for a second attack ⚡");
            PrintUtil.pause(800);
            System.out.println("2️⃣ " + lifebondBlade.getName() + " → +15 ATK, restores 3% HP of damage dealt 💖");
            PrintUtil.pause(800);
            System.out.print("\nChoose one to equip (1 or 2): ");

            int choice = InputUtil.scanInput();

            if (choice == 1) {
                twinstrikeBlade.equip(player);
                System.out.println("\n⚙\uFE0F You equipped " + twinstrikeBlade.getName() + "! The other weapon vanishes...");
                PrintUtil.pause(800);
            } else if (choice == 2) {
                lifebondBlade.equip(player);
                System.out.println("\n⚙\uFE0F You equipped " + lifebondBlade.getName() + "! The other weapon vanishes...");
                PrintUtil.pause(800);
            } else {
                System.out.println("\n❌ Invalid choice! Both weapons disappear...");
                PrintUtil.pause(800);
            }

        } else if (player.getClassType().equals("Archer")) {
            Bow twinshotBow = Bow.TWINSHOT_BOW;    // +15 ATK, 10% chance to attack twice
            Bow lifebloomBow = Bow.LIFEBLOOM_BOW;   // +15 ATK, restores 3% HP of damage dealt

            System.out.println("1️⃣ " + twinshotBow.getName() + " → +15 ATK, +10% chance to attack twice 🎯");
            PrintUtil.pause(800);
            System.out.println("2️⃣ " + lifebloomBow.getName() + " → +15 ATK, restores 3% HP of damage dealt 💖");
            PrintUtil.pause(800);
            System.out.print("\nChoose one to equip (1 or 2): ");

            int choice = InputUtil.scanInput();

            if (choice == 1) {
                twinshotBow.equip(player);
                System.out.println("\n⚙\uFE0F You equipped " + twinshotBow.getName() + "! The other weapon vanishes...");
                PrintUtil.pause(800);
            } else if (choice == 2) {
                lifebloomBow.equip(player);
                System.out.println("\n⚙\uFE0F You equipped " + lifebloomBow.getName() + "! The other weapon vanishes...");
                PrintUtil.pause(800);
            } else {
                System.out.println("\n❌ Invalid choice! Both weapons disappear...");
                PrintUtil.pause(800);
            }

        } else if (player.getClassType().equals("Mage")) {
            Staff mysticMindStaff = Staff.MYSTIC_MIND_STAFF; // +15 ATK, 30% chance to confuse
            Staff flameheartStaff = Staff.FLAMEHEART_STAFF;  // +15 ATK, restores 3% HP of damage dealt

            System.out.println("1️⃣ " + mysticMindStaff.getName() + " → +15 ATK, 30% chance to confuse enemy 🌀");
            PrintUtil.pause(800);
            System.out.println("2️⃣ " + flameheartStaff.getName() + " → +15 ATK, restores 3% HP of damage dealt 💖");
            PrintUtil.pause(800);
            System.out.print("\nChoose one to equip (1 or 2): ");

            int choice = InputUtil.scanInput();

            if (choice == 1) {
                mysticMindStaff.equip(player);
                System.out.println("The other weapon vanishes...");
                PrintUtil.pause(800);
            } else if (choice == 2) {
                flameheartStaff.equip(player);
                System.out.println("The other weapon vanishes...");
                PrintUtil.pause(800);
            } else {
                System.out.println("\n❌ Invalid choice. Both weapons disappear...");
                PrintUtil.pause(800);
            }
        }
    }

    @Override
    public int rewardExp(){
        return 5692;
    }
}
