package characters;

import utils.ColorUtil;
import utils.InputUtil;
import utils.PrintUtil;
import utils.RandomUtil;

public class Simon extends Character {

    public Simon() { super("Simon Versace", "Mage", 60, 2, 120, 18); }

    @Override
    public void displaySkills() {
        System.out.println();
        System.out.println(ColorUtil.boldBrightCyan("┌────────────────────────────────────── 🔮 SIMON'S SKILLS 🔮 ───────────────────────────────────────┐"));

        // Passive
        System.out.println("  " + ColorUtil.boldBrightYellow("✨ Passive – Arcane Flow"));
        System.out.println("  " + ColorUtil.cyan("Restores ") + ColorUtil.boldBrightYellow("+5%") + ColorUtil.cyan(" of total 💧 Mana each turn.\n"));

        // Skill 1 – Fireball
        System.out.println("  " + ColorUtil.boldBrightYellow("🔥 Skill 1 – Fireball (💧 15 Mana)"));
        System.out.println("  " + ColorUtil.cyan("📜 Description: Conjures a blazing orb of fire and hurls it at an enemy."));
        System.out.println("  " + ColorUtil.cyan("💥 Damage: (") + ColorUtil.boldBrightYellow((int)(attack * 1.25) + " — " + (int)(attack * 1.55)) + ColorUtil.cyan(")"));
        System.out.println("  " + ColorUtil.cyan("⚡ Effects:"));
        System.out.println("    - " + ColorUtil.cyan("🔥 Applies Burn (1 turn)"));
        System.out.println("    - " + ColorUtil.cyan("🛡️ 30% chance to Weaken target (-20% ATK for 2 turns)\n"));

        // Skill 2 – Ice Prison
        System.out.println("  " + ColorUtil.boldBrightYellow("❄️ Skill 2 – Ice Prison (💧 25 Mana)"));
        System.out.println("  " + ColorUtil.cyan("📜 Description: Encases the target in solid ice, restricting movement and draining warmth."));
        System.out.println("  " + ColorUtil.cyan("💥 Damage: (") + ColorUtil.boldBrightYellow((int)(attack * 1.00) + " — " + (int)(attack * 1.25)) + ColorUtil.cyan(")"));
        System.out.println("  " + ColorUtil.cyan("⚡ Effects:"));
        System.out.println("    - " + ColorUtil.cyan("❄️ 30% chance to Freeze (target skips 1 turn)"));
        System.out.println("    - " + ColorUtil.cyan("🛡️ If frozen: reduces DEF by 15% for 1 turn\n"));

        // Ultimate – Meteor Storm
        System.out.println("  " + ColorUtil.boldBrightYellow("☄️ Ultimate – Meteor Storm (💧 40 Mana)"));
        System.out.println("  " + ColorUtil.cyan("📜 Description: Summons a storm of blazing meteors, striking the opponent multiple times."));
        System.out.println("  " + ColorUtil.cyan("💥 Damage: 5 hits, each dealing (") + ColorUtil.boldBrightYellow((int)(attack * 0.60) + " — " + (int)(attack * 0.90)) + ColorUtil.cyan(")"));
        System.out.println("  " + ColorUtil.cyan("⚡ Effects:"));
        System.out.println("    - " + ColorUtil.cyan("💪 Grants Strengthen (+20% ATK for 2 turns)"));
        System.out.println("    - " + ColorUtil.cyan("🔥 50% chance to apply Burn (2 turns)"));

        System.out.println(ColorUtil.boldBrightCyan("└───────────────────────────────────────────────────────────────────────────────────────────────────┘"));
        System.out.println();
    }

    public void showBackstory() {
        System.out.println();
        System.out.println(ColorUtil.boldBrightCyan("┌───────────────────────────── 📘 SIMON'S BACKSTORY 📘 ─────────────────────────────┐"));
        System.out.println(ColorUtil.brightYellow("  Simon Versace — a mage with an unshakable dream of becoming the most powerful"));
        System.out.println(ColorUtil.brightYellow("  sorcerer alive. From childhood, mana coursed naturally through"));
        System.out.println(ColorUtil.brightYellow("  his veins, earning him the title of prodigy in the whispers of others."));
        System.out.println(ColorUtil.brightYellow("  Yet beneath that promise of greatness, Simon was still just a boy—"));
        System.out.println(ColorUtil.brightYellow("  vulnerable, human, and plagued by a fear he could never quite conquer: spiders."));
        System.out.println();
        System.out.println(ColorUtil.brightYellow("  He hails from the Forest of Silence, a place where no birds sing and no"));
        System.out.println(ColorUtil.brightYellow("  wind dares stir the trees. The air is unnaturally still, as if the forest"));
        System.out.println(ColorUtil.brightYellow("  itself is holding its breath—an unsettling quiet that lingers in the minds"));
        System.out.println(ColorUtil.brightYellow("  of all who dwell there. Within its academy, Simon immersed himself in study,"));
        System.out.println(ColorUtil.brightYellow("  mastering theory and knowledge with ease. But soon, he discovered that wisdom"));
        System.out.println(ColorUtil.brightYellow("  confined to books was not enough to fulfill his ambitions."));
        System.out.println();
        System.out.println(ColorUtil.brightYellow("  If he truly wished to claim power, he would need more than learning—"));
        System.out.println(ColorUtil.brightYellow("  he would need experience."));
        System.out.println(ColorUtil.boldBrightCyan("└──────────────────────────────────────────────────────────────────────────────────┘"));
        System.out.println();
    }


    private void arcaneFlow() {
        int restored = (int)(maxEnergy * 0.05);
        int before = energy;
        this.restoreEnergy(restored);
        int after = energy;

        System.out.println(ColorUtil.brightMagenta("✨ Arcane Flow restores " + restored + " Mana! " + "(💧 " + before + " → " + after + ")"));
        PrintUtil.pause(800);
    }


    // Skill 1 – Fireball
    public void fireball(Character target) {
        PrintUtil.print(ColorUtil.boldBrightGreen("                                                          \n" +
                "                            %@*           :.              \n" +
                "                            -@@@+     :+-  .:             \n" +
                "              .+:           @@@@#.   :@%-...:.            \n" +
                "             :=:==.        -@@@@@@#*%+=-:-::.             \n" +
                "             .--=-.      :*%%@@@@@@@*-....-.              \n" +
                "                -+      -%@@%##**####=...::               \n" +
                "                 .=  .=%@@@@@@@@#=::..=-..                \n" +
                "                  -@@@@@@@*#@@@@@#.                       \n" +
                "                   .*%@@%:.%@@@@@@=                       \n" +
                "                     *#+  +@@@@@@@@-                      \n" +
                "                      -  =@@@%@@@@@@-                     \n" +
                "                      .-:%@@@@%%@@@@@*                    \n" +
                "                       .#@@@@@@%#@@@@@@#.                 \n" +
                "                       .#@@@@@@@@%@@@@@@@#:               \n" +
                "                       :%@@@@@@@@@@@@@@@@@@-              \n" +
                "                       -@@@@@@@@@@@@@@@@@*::              \n" +
                "                       *@@@@@@@@@@@@@@@@#=                \n" +
                "                     :#@@*===. -**-   *@%-                \n" +
                "                                                          "));
        int energyCost = 15;
        consumeEnergy(energyCost);

        System.out.println(ColorUtil.boldBrightGreen("🔥 You cast Fireball on " + target.getName() + " (💧-" + energyCost + " Mana)"));
        PrintUtil.pause(800);

        if (this.getEffects().checkConfuse()) return;

        int damage = (int) RandomUtil.range(attack * 1.25, attack * 1.55);
        int reduced = calculateDamage(target, damage);

        // Fireball
        System.out.println(
                ColorUtil.brightGreen("💔 Target is hit for ")
                        + ColorUtil.boldBrightWhite(String.valueOf(reduced))
                        + ColorUtil.brightGreen(" damage!")
        );

        PrintUtil.pause(800);
        target.takeDamage(reduced);

        // Apply Burn
        target.getEffects().applyBurn(1);

        // 30% chance to apply Weaken
        if (RandomUtil.chance(30)) {
            target.getEffects().applyAttackDebuff(20, 2);
        }
        arcaneFlow();

        this.getWeapon().applyEffects(this,target,reduced);

    }

    // Skill 2 – Ice Prison
    public void icePrison(Character target) {
        PrintUtil.print(ColorUtil.boldBrightGreen("                                                          \n" +
                "                         ..                               \n" +
                "                        ...                               \n" +
                "                            %@*          ...              \n" +
                "                            -@@@+ ..  :*-  ..             \n" +
                "            ...+-          .@@@@#.   :%#:.....            \n" +
                "           ..-=:-=. .   ...-@@@@@@#*#........             \n" +
                "             .--=-.  ....:=##%@@@@@@=.:.:...              \n" +
                "                -+.     -%@@#*+++**#*....:.    ..         \n" +
                "               ..:+  .=%@@@@@@#%*-....-:..     ..         \n" +
                "            . ... -@@@@@@@*#@@@@@#.           ...         \n" +
                "           .....   .*%@@%:.%@@@@@@=           ..          \n" +
                "            ..       *#+  +@@@@@@@@-    ...  ..           \n" +
                "           ..         -  =@@@%@@@@@@-   ....              \n" +
                "           .          .--%@@@@%%@@@@@*  .  . ..           \n" +
                "               .:..    .#@@##@@%*@@@%#*=.   ...           \n" +
                "               .....   .#@#=%@@@@%*-::=@@#: .             \n" +
                "            ..  ..:.   :%@@@@@@@#+=*%@@@@@@=              \n" +
                "              .        -@@@*%@@@@@@@@@@@@*::              \n" +
                "                      .*@@@@@@@@@@@@@@@@#=                \n" +
                "                     :#@@*===. -+*-   *@%-                \n" +
                "                                                          "));
        int energyCost = 25;
        consumeEnergy(energyCost);

        System.out.println(ColorUtil.boldBrightGreen("❄️ You cast Ice Prison on " + target.getName() + " (💧-" + energyCost + " Mana)"));
        PrintUtil.pause(800);

        if (this.getEffects().checkConfuse()) return;

        int damage = (int) RandomUtil.range(attack * 1.00, attack * 1.25);
        int reduced = calculateDamage(target, damage);


        System.out.println(
                ColorUtil.brightGreen("💔 Target is hit for ")
                        + ColorUtil.boldBrightWhite(String.valueOf(reduced))
                        + ColorUtil.brightGreen(" damage!")
        );

        PrintUtil.pause(800);
        target.takeDamage(reduced);

        // 30% chance to Freeze
        if (RandomUtil.chance(50)) {
            target.getEffects().applyFreeze();
            // If frozen, apply DEF reduction
            target.getEffects().applyDefenseDebuff(15, 1);
        }
        arcaneFlow();

        this.getWeapon().applyEffects(this,target,reduced);
    }

    // Ultimate – Meteor Storm
    public void meteorStorm(Character target) {
        PrintUtil.print(ColorUtil.boldBrightGreen("                                                          \n" +
                "                        ..  :.  .. ..                     \n" +
                "                   .:.                  .:.               \n" +
                "                .                       ..                \n" +
                "                ..          %@*           :.              \n" +
                "                            -@@@+     :*-  .:             \n" +
                "          ::  .+:          .@@@@#.   :@%-...:..:          \n" +
                "             :=:==.        -@@@@@@#*%+=-:-:.. ..          \n" +
                "             .--+-.      :+%%@@@@@@@*-...:-.   .          \n" +
                "         ::     -+      -%@@%##**####=...::               \n" +
                "                 .=  .=%@@@@@@@@#=::..=-..    .:          \n" +
                "       .:.        -@@@@@@@*#@@@@@#.          ..:.         \n" +
                "       ..:         .*%@@%:.%@@@@@@=                       \n" +
                "                     *#+  +@@@@@@@@-        ..    :.      \n" +
                "            .:.       -  =@@@%@@@@@@-    ..               \n" +
                "       .:    .        .--%@@@@%%@@@@@*          .         \n" +
                "                       .#@@@@@@%*@@@@@@#.     .::         \n" +
                "           .:     .    .#@@@@@@@@%@@@@@@@#:   ..:         \n" +
                "           :.          :%@@@@@@@@@@@#:#@@@%=.             \n" +
                "                .    .:=@@@@@@%@@@@@@@@@@*--:.            \n" +
                "               ..   . .*@@@@@+#@@@@@@%%@=::.:.            \n" +
                "                   .:-#@%=-==..-**= .:-#%-                \n" +
                "                    ..      ...  .. ....                  \n" +
                "                                                          "));
        int energyCost = 40;
        consumeEnergy(energyCost);

        System.out.println(ColorUtil.boldBrightGreen("☄️ You unleash your ultimate: Meteor Storm (💧-" + energyCost + " Mana)!"));
        PrintUtil.pause(800);

        int totalDamage = 0;

        for (int i = 1; i <= 5; i++) {
            int damage = (int) RandomUtil.range(attack * 0.60, attack * 0.90);
            int reduced = calculateDamage(target, damage);

            // Check if target is confused
            if (this.getEffects().checkConfuse()) reduced = 0;
            totalDamage += reduced;

            System.out.println(
                    ColorUtil.brightGreen("→💥 Meteor " + i + " hits! 💔 Target is hit for ")
                            + ColorUtil.boldBrightWhite(String.valueOf(reduced))
                            + ColorUtil.brightGreen(" damage!")
            );

            PrintUtil.pause(800);
        }

        System.out.println(
                ColorUtil.brightGreen("☄️ Meteor Storm finished! Total damage dealt: ")
                        + ColorUtil.boldBrightWhite(String.valueOf(totalDamage))
        );

        PrintUtil.pause(800);
        target.takeDamage(totalDamage);

        // 50% chance to Burn
        if (RandomUtil.chance(50)) {
            target.getEffects().applyBurn(2);
        }

        arcaneFlow();

        this.getWeapon().applyEffects(this,target,totalDamage);
        this.getEffects().applyAttackBuff(20, 2);

        ultimateCounter = 3;
    }

    @Override
    public void turn(Character target) {
        boolean isValid = false;

        while (!isValid) {
            // Display skills
            System.out.println(ColorUtil.boldBrightGreen("[1]") + " " + ColorUtil.green("🔥 Skill 1   -  Fireball (💧 15 Mana)"));
            System.out.println(ColorUtil.boldBrightGreen("[2]") + " " + ColorUtil.green("❄️ Skill 2   -  Ice Prison (💧 25 Mana)"));
            System.out.println(ColorUtil.boldBrightGreen("[3]") + " " + ColorUtil.green("🌋 Ultimate  -  Meteor Storm (💧 40 Mana)"
                    + (ultimateCounter > 0 ? " " + ColorUtil.boldBrightRed("❌ Cooldown: " + ultimateCounter + " turn/s") : "")));
            System.out.println(ColorUtil.boldBrightGreen("[4]") + " " + ColorUtil.green("\uD83D\uDEE1\uFE0F Skip Turn -  Restore 10% of Max HP and 20 Mana"));
            System.out.println(ColorUtil.boldBrightGreen("[5]") + " " + ColorUtil.green("📜 Show Menu"));
            System.out.print(ColorUtil.boldBrightWhite("Choose your action: "));

            int choice = InputUtil.scanInput();
            PrintUtil.shortLine();

            switch (choice) {
                case 1 -> {
                    if (energy >= 15) {
                        fireball(target);
                        isValid = true;
                        ultimateCounter--;
                    } else {
                        System.out.println(ColorUtil.boldBrightRed("❌ Not enough Mana to cast Fireball! Choose again."));
                        PrintUtil.shortLine();
                    }
                }
                case 2 -> {
                    if (energy >= 25) {
                        icePrison(target);
                        isValid = true;
                        ultimateCounter--;
                    } else {
                        System.out.println(ColorUtil.boldBrightRed("❌ Not enough Mana to cast Ice Prison! Choose again."));
                        PrintUtil.shortLine();
                    }
                }
                case 3 -> {
                    if (ultimateCounter > 0) {
                        System.out.println(ColorUtil.boldBrightRed("❌ Ultimate is on cooldown! Can only be used after " + ultimateCounter + " turn/s."));
                        PrintUtil.shortLine();
                    } else if (energy >= 40) {
                        meteorStorm(target);
                        isValid = true;
                    } else {
                        System.out.println(ColorUtil.boldBrightRed("❌ Not enough Mana to cast Meteor Storm! Choose again."));
                        PrintUtil.shortLine();
                    }
                }
                case 4 -> {
                    skipTurn();
                    isValid = true;
                    ultimateCounter--;
                }
                case 5 -> displayMenu(this, target); // does not consume turn
                default -> {
                    System.out.println(ColorUtil.boldBrightRed("❌ Invalid action! Try again."));
                    PrintUtil.shortLine();
                }
            }
        }
    }


}
