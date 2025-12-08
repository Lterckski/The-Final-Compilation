package events;

import utils.ColorUtil;
import utils.InputUtil;
import utils.PrintUtil;
import characters.Character;

import java.awt.*;

public class MagicShop {
    private final Character player;

    private boolean boughtVitalSurge = false;
    private boolean boughtShockBind = false;
    private boolean boughtFrostArrow = false;
    private boolean boughtArcSurge = false;
    private boolean boughtVenomInfusion = false;
    private boolean boughtRazorEdge = false;
    private boolean boughtFortifiedPlating = false;

    public MagicShop(Character player){
        this.player = player;
    }

    public void openShop() {
        boolean exit = false;

        while (!exit) {
            // Header
            System.out.println();
            System.out.println(ColorUtil.boldBrightCyan("╔════════════════════════════════════════════════════════════════════════════════════════════════╗"));
            System.out.println(ColorUtil.boldBrightCyan("                            🛍️ ╔╦╗ ╔═╗ ╔═╗ ╦ ╔═╗   ╔═╗ ╦ ╦ ╔═╗ ╔═╗ 🛍️"));
            System.out.println(ColorUtil.boldBrightCyan("                            🔮 ║║║ ╠═╣ ║ ╦ ║ ║     ╚═╗ ╠═╣ ║ ║ ╠═╝ 🔮"));
            System.out.println(ColorUtil.boldBrightCyan("                            🛍️ ╩ ╩ ╩ ╩ ╚═╝ ╩ ╚═╝   ╚═╝ ╩ ╩ ╚═╝ ╩   🛍️"));
            System.out.println(ColorUtil.boldBrightCyan("╚════════════════════════════════════════════════════════════════════════════════════════════════╝"));

            System.out.println(ColorUtil.boldBrightYellow(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 💠 SOUL SHARDS : " + player.getSoulShards() + " <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n"));

            // Permanent Stat Upgrades
            System.out.println(ColorUtil.boldBrightCyan("├──────────────────────────────── 💎 PERMANENT STAT UPGRADES 💎 ────────────────────────────────┤"));
            System.out.printf(" %5s%-3s %-44s %-43s 💠 %s%n", ColorUtil.boldBrightCyan("[1]"), " 💖", ColorUtil.cyan("Vitality Blessing"), "+100 Max HP", ColorUtil.boldBrightYellow("10"));
            System.out.printf(" %5s%-3s %-44s %-43s 💠 %s%n", ColorUtil.boldBrightCyan("[2]"), " ⚔️", ColorUtil.cyan("Attack Infusion"), "+8 ATK", ColorUtil.boldBrightYellow("12"));
            System.out.printf(" %5s%-3s %-44s %-43s 💠 %s%n", ColorUtil.boldBrightCyan("[3]"), " 🛡️", ColorUtil.cyan("Fortified Spirit"), "+2 DEF", ColorUtil.boldBrightYellow("10"));

            // Dynamic Soul Battery based on class
            String energyLabel;
            int energyValue;

            switch (player.getClassType()) {
                case "Mage" -> {
                    energyLabel = " Mana";
                    energyValue = 15;
                }
                case "Archer" -> {
                    energyLabel = " Arrows";
                    energyValue = 0; // can't be applied
                }
                default -> { // Swordsman
                    energyLabel = " Stamina";
                    energyValue = 10;
                }
            }

            System.out.printf(" %5s%-3s %-45s %-42s 💠 %s%n",
                    ColorUtil.boldBrightCyan("[4]"), " ⚡ ", ColorUtil.cyan("Soul Battery"),
                    energyValue > 0 ? "+" + energyValue + energyLabel : " ❌",
                    ColorUtil.boldBrightYellow("8"));

            // Weapon/Armor Enchantments
            System.out.println(ColorUtil.boldBrightCyan("├────────────────────────────── 🌟 WEAPON / ARMOR ENCHANTMENTS 🌟 ──────────────────────────────┤"));
            System.out.printf(" %5s%-3s %-41s %-46s 💠 %s%n", ColorUtil.boldBrightCyan("[5]"), " 💖", ColorUtil.cyan("Vital Surge"), "+5% Lifesteal " + xMark("Swordsman", "Archer", "Mage"), ColorUtil.boldBrightYellow("28"));
            System.out.printf(" %5s%-3s %-41s %-46s 💠 %s%n", ColorUtil.boldBrightCyan("[6]"), " ⛓️", ColorUtil.cyan("Shock Bind"), "20% chance to Stun " + xMark("Swordsman"), ColorUtil.boldBrightYellow("30"));
            System.out.printf(" %5s%-3s %-41s %-46s 💠 %s%n", ColorUtil.boldBrightCyan("[7]"), " ❄️", ColorUtil.cyan("Frost Arrow"), "ATKs have 20% to Freeze " + xMark("Archer"), ColorUtil.boldBrightYellow("30"));
            System.out.printf(" %5s%-3s %-41s %-46s 💠 %s%n", ColorUtil.boldBrightCyan("[8]"), " ✨", ColorUtil.cyan("Arc Surge"), "+3 Energy per ATK " + xMark("Mage"), ColorUtil.boldBrightYellow("26"));
            System.out.printf(" %5s%-3s %-41s %-46s 💠 %s%n", ColorUtil.boldBrightCyan("[9]"), " ☠️", ColorUtil.cyan("Venom Infusion"), "20% Poison chance" + xMark("Swordsman","Archer","Mage"), ColorUtil.boldBrightYellow("30"));
            System.out.printf(" %5s%-3s %-41s %-46s 💠 %s%n", ColorUtil.boldBrightCyan("[10]"), " 🩸", ColorUtil.cyan("Razor Edge"), "+20% Bleed chance" + xMark("Swordsman", "Archer"), ColorUtil.boldBrightYellow("32"));
            System.out.printf(" %5s%-3s %-41s %-46s 💠 %s%n", ColorUtil.boldBrightCyan("[11]"), " 🛡️", ColorUtil.cyan("Fortified Plating"), "Armor +10 DEF" + xMark("Swordsman","Archer","Mage"), ColorUtil.boldBrightYellow("26"));

// Potions
            System.out.println(ColorUtil.boldBrightCyan("├──────────────────────────────────────── 🧪 POTIONS 🧪 ────────────────────────────────────────┤"));
            System.out.printf(" %5s%-3s %-46s %-41s 💠 %s%n", ColorUtil.boldBrightCyan("[12]"), " 🍃", ColorUtil.cyan("Normal Healing Potion"), "1x", ColorUtil.boldBrightYellow("6"));
            System.out.printf(" %5s%-3s %-46s %-41s 💠 %s%n", ColorUtil.boldBrightCyan("[13]"), " 💞", ColorUtil.cyan("Full Healing Potion"), "1x", ColorUtil.boldBrightYellow("18"));
            System.out.printf(" %5s%-3s %-46s %-41s 💠 %s%n", ColorUtil.boldBrightCyan("[14]"), " ⚡ ", ColorUtil.cyan("Energy Potion"), "1x", ColorUtil.boldBrightYellow("8"));

// Special Item
            System.out.println(ColorUtil.boldBrightCyan("├────────────────────────────────────── 🔮 SPECIAL ITEM 🔮 ──────────────────────────────────────┤"));
            System.out.printf(" %5s%-3s %-33s %-54s 💠 %s%n", ColorUtil.boldBrightCyan("[15]"), " 🕊️", ColorUtil.cyan("Phoenix Soulstone"), "Revive once with 50% HP & Energy", ColorUtil.boldBrightYellow("40"));

// Exit
            System.out.println(ColorUtil.boldBrightCyan("├────────────────────────────────────────────────────────────────────────────────────────────────┤"));
            System.out.println(ColorUtil.boldBrightCyan(" [16] ") + ColorUtil.cyan("📰 Menu"));
            System.out.println(ColorUtil.boldBrightCyan("  [0] ") + ColorUtil.cyan("➜] Exit Shop"));
            System.out.println(ColorUtil.boldBrightCyan("╚════════════════════════════════════════════════════════════════════════════════════════════════╝"));


            System.out.print("Enter item to purchase: ");
            int choice = InputUtil.scanInput();
            PrintUtil.line();

            switch (choice) {
                // Permanent Stat Upgrades
                case 1 -> vitalityBlessing("Vitality Blessing", 10);
                case 2 -> attackInfusion("Attack Infusion", 12);
                case 3 -> fortifiedSpirit("Fortified Spirit", 10);
                case 4 -> soulBattery("Soul Battery", 8);

                // Weapon / Armor Enchantments
                case 5 -> vitalSurge("Vital Surge", 28);
                case 6 -> shockBind("Shock Bind", 30);
                case 7 -> frostArrow("Frost Arrow", 30);
                case 8 -> arcSurge("Arc Surge", 26);
                case 9 -> venomInfusion("Venom Infusion", 30);
                case 10 -> razorEdge("Razor Edge", 32);
                case 11 -> fortifiedPlating("Fortified Plating", 26);

//                // Potions
                case 12 -> normalHealingPotion("Normal Healing Potion", 6);
                case 13 -> fullHealingPotion("Full Healing Potion", 18);
                case 14 -> energyPotion("Energy Potion", 8);
//
//                // Special Item
                case 15 -> phoenixSoulstone("Phoenix Soulstone", 40);
                case 16 -> player.displayMenu(player);
                case 0 -> exit = confirmExit();
                default -> System.out.println("❌ Invalid input! Please select a valid option.");
            }
        }
    }

    private String xMark (String... allowedClasses) {
        for (String allowed : allowedClasses) {
            if (player.getClassType().equalsIgnoreCase(allowed)) {
                return " ";   // allowed → no X mark
            }
        }
        return "❌";         // not allowed → show X
    }

    private boolean attemptPurchase(String name, int cost) {
        if (player.getSoulShards() < cost) {
            System.out.println("❌ Not enough Soul Shards to acquire " + name + "!");
            return false;
        }

        return confirmPurchase(name, cost);
    }
    //For Potions
    private boolean attemptPurchase(String name, int cost, int amount) {
        int totalCost = cost * amount;

        if (player.getSoulShards() < totalCost) {
            System.out.println("❌ Not enough Soul Shards to acquire " + amount + " " + name + "(s)!");
            return false;
        }
        return confirmPurchase(name, totalCost, amount);
    }

    private boolean confirmPurchase(String name, int cost) {
        int input;
        do {
            System.out.print("💠 " + name + " costs " + cost + " Soul Shards. Confirm purchase? (1 = Yes, 0 = No) : ");

            input = InputUtil.scanInput();
            if (input == 1) return true;
            if (input == 0) return false;
            System.out.println("❌ Invalid input! Enter 1 for Yes, 0 for No.");
        } while (true);
    }

    private boolean confirmPurchase(String name, int cost, int amount) {
        String itemName = (amount > 1) ? name + "s" : name;
        int input;
        do {
            System.out.print("💠 " + amount + " " + itemName + " costs " + cost + " Soul Shards. Confirm purchase? (1 = Yes, 0 = No) : ");

            input = InputUtil.scanInput();
            if (input == 1) return true;
            if (input == 0) return false;
            System.out.println("❌ Invalid input! Enter 1 for Yes, 0 for No.");
        } while (true);
    }

    private void vitalityBlessing(String name, int cost) {
        if (attemptPurchase(name, cost)) {
            player.subtractSoulShards(cost);

            int oldMaxHP = player.getMaxHP();
            player.setMaxHP(oldMaxHP + 100);

            PrintUtil.reward("💖 " + name + " applied! Max HP increased by 100. 💚 HP : " + oldMaxHP + " → " + player.getMaxHP()
                    + " (💠- " + cost + " Soul Shards)");
        }
        InputUtil.pressEnterToContinue();
    }

    private void attackInfusion(String name, int cost) {
        if (attemptPurchase(name, cost)) {
            player.subtractSoulShards(cost);

            int oldAtk = player.getAttack();
            player.setBaseAttack(player.getBaseAttack() + 8);
            player.recalculateBuffs(); // updates effective attack

            PrintUtil.reward("⚔️ " + name + " applied! ATK increased by 8. ⚔️ ATK : " + oldAtk + " → " + player.getAttack()
                    + " (💠- " + cost + " Soul Shards)");
        }
        InputUtil.pressEnterToContinue();
    }

    private void fortifiedSpirit(String name, int cost) {
        if (attemptPurchase(name, cost)) {
            player.subtractSoulShards(cost);

            int oldDef = player.getDefense();
            player.setBaseDefense(player.getBaseDefense() + 2);
            player.recalculateBuffs(); // updates effective defense

            PrintUtil.reward("🛡️ " + name + " applied! DEF increased by 2. 🛡️ DEF : " + oldDef + " → " + player.getDefense()
                    + " (💠- " + cost + " Soul Shards)");
        }
        InputUtil.pressEnterToContinue();
    }


    private void soulBattery(String name, int cost) {
        if (player.getClassType().equalsIgnoreCase("Archer")) {
            System.out.println("❌ " + name + " cannot be applied to Archers!");
            return;
        }

        if (attemptPurchase(name, cost)) {
            player.subtractSoulShards(cost);

            int energyIncrease = 0;
            switch (player.getClassType()) {
                case "Swordsman" -> energyIncrease = 10;
                case "Mage" -> energyIncrease = 15;
            }

            int oldMaxEnergy = player.getMaxEnergy();
            player.setMaxEnergy(oldMaxEnergy + energyIncrease);

            PrintUtil.reward("⚡ " + name + " applied! Max Energy increased by "
                    + energyIncrease + ". " + player.getEnergyEmoji() + " " + player.getEnergyName() + " : " + oldMaxEnergy + " → " + player.getMaxEnergy()
                    + " (💠- " + cost + " Soul Shards)");
        }
        InputUtil.pressEnterToContinue();
    }

    private void vitalSurge(String name, int cost) {
        if (boughtVitalSurge) {
            System.out.println(ColorUtil.boldBrightRed("❌ You have already acquired " + name + "!"));
            InputUtil.pressEnterToContinue();
            return;
        }

        if (attemptPurchase(name, cost)) {
            player.subtractSoulShards(cost);
            boughtVitalSurge = true;

            var weapon = player.getWeapon();
            int oldLifesteal = weapon.getLifestealPercent();
            weapon.setAddLifestealPercent(weapon.getAddLifestealPercent() + 5);

            player.getWeapon().addEnchantment(
                    "💖 Vital Surge",
                    "(+5% Lifesteal on attacks)"
            );

            PrintUtil.reward("💖 --" + weapon.getName() + "-- is now empowered with " + name
                    + "-- 💖 Lifesteal: " + oldLifesteal + "% → " + (weapon.getLifestealPercent()+ weapon.getAddLifestealPercent()) + "% "
                    + " (💠- " + cost + " Soul Shards)");

            InputUtil.pressEnterToContinue();
        }
    }

    private void shockBind(String name, int cost) {
        if (boughtShockBind) {
            System.out.println(ColorUtil.boldBrightRed("❌ You have already acquired " + name + "!"));
            InputUtil.pressEnterToContinue();
            return;
        }

        // Only Swordsman can apply
        if (!player.getClassType().equalsIgnoreCase("Swordsman")) {
            System.out.println(ColorUtil.boldBrightRed("❌ " + name + " can only be applied to Swords!"));
            InputUtil.pressEnterToContinue();
            return;
        }

        if (attemptPurchase(name, cost)) {
            player.subtractSoulShards(cost);
            boughtShockBind = true;

            var weapon = player.getWeapon();
            int oldChance = weapon.getStunChance(); // Make sure Sword class has this
            weapon.setStunChance(oldChance + 20); // 20% chance to stun

            player.getWeapon().addEnchantment(
                    "⛓️ Shockbind",
                    "(20% chance to stun enemies)"
            );

            PrintUtil.reward("⛓️ --" + weapon.getName() + "-- crackles with " + name + "! Stun chance: "
                    + weapon.getStunChance() + "% (💠- " + cost + " Soul Shards)");


            InputUtil.pressEnterToContinue();
        }
    }

    private void frostArrow(String name, int cost) {
        if (boughtFrostArrow) {
            System.out.println(ColorUtil.boldBrightRed("❌ You have already acquired " + name + "!"));
            InputUtil.pressEnterToContinue();
            return;
        }

        if (!player.getClassType().equalsIgnoreCase("Archer")) {
            System.out.println("❌ " + name + " can only be applied to Archers!");
            InputUtil.pressEnterToContinue();
            return;
        }

        if (attemptPurchase(name, cost)) {
            player.subtractSoulShards(cost);
            boughtFrostArrow = true;

            var weapon = player.getWeapon();
            int oldFreeze = weapon.getFreezeChance(); // Make sure Weapon class has this
            weapon.setFreezeChance(oldFreeze + 20);

            player.getWeapon().addEnchantment(
                    "❄️ Frost Arrow",
                    "(20% chance to Freeze target)"
            );

            PrintUtil.reward("❄️ --" + weapon.getName() + "-- is now enchanted with " + name + "! Freeze chance: "
                    + weapon.getFreezeChance() + "% (💠- " + cost + " Soul Shards)");

            InputUtil.pressEnterToContinue();
        }
    }

    private void arcSurge(String name, int cost) {
        if (boughtArcSurge) {
            System.out.println(ColorUtil.boldBrightRed("❌ You have already acquired " + name + "!"));
            InputUtil.pressEnterToContinue();
            return;
        }

        if (!player.getClassType().equalsIgnoreCase("Mage")) {
            System.out.println("❌ " + name + " can only be applied to Mages!");
            InputUtil.pressEnterToContinue();
            return;
        }

        if (attemptPurchase(name, cost)) {
            player.subtractSoulShards(cost);
            boughtArcSurge = true;

            var weapon = player.getWeapon();
            int oldEnergy = weapon.getEnergyPerAttack();
            weapon.setEnergyPerAttack(oldEnergy + 3);

            player.getWeapon().addEnchantment(
                    "✨ Arc Surge",
                    "(+3 Energy per attack)"
            );

            PrintUtil.reward("✨ --" + weapon.getName() + "-- is now infused with " + name
                    + "! +3 Energy per attack (💠- " + cost + " Soul Shards)");

            InputUtil.pressEnterToContinue();
        }
    }

    private void venomInfusion(String name, int cost) {
        if (boughtVenomInfusion) {
            System.out.println(ColorUtil.boldBrightRed("❌ You have already acquired " + name + "!"));
            InputUtil.pressEnterToContinue();
            return;
        }

        if (attemptPurchase(name, cost)) {
            player.subtractSoulShards(cost);
            boughtVenomInfusion = true;

            var weapon = player.getWeapon();
            int oldPoison = weapon.getPoisonChance(); // Weapon class must have this
            weapon.setPoisonChance(oldPoison + 20);

            player.getWeapon().addEnchantment(
                    "☠️ Venom Infusion",
                    "(20% chance to Poison target)"
            );

            PrintUtil.reward("☠️ --" + weapon.getName() + "-- is now laced with " + name + "! Poison chance: "
                    + weapon.getPoisonChance() + "% (💠- " + cost + " Soul Shards)");

            InputUtil.pressEnterToContinue();
        }
    }

    private void razorEdge(String name, int cost) {
        if (boughtRazorEdge) {
            System.out.println(ColorUtil.boldBrightRed("❌ You have already acquired " + name + "!"));
            InputUtil.pressEnterToContinue();
            return;
        }

        if (!player.getClassType().equalsIgnoreCase("Swordsman") && !player.getClassType().equalsIgnoreCase("Archer")) {
            System.out.println("❌ " + name + " can only be applied to Swordsmen or Archers!");
            InputUtil.pressEnterToContinue();
            return;
        }

        if (attemptPurchase(name, cost)) {
            player.subtractSoulShards(cost);
            boughtRazorEdge = true;

            var weapon = player.getWeapon();
            int oldBleed = weapon.getBleedChance(); // Weapon class must have this
            weapon.setBleedChance(oldBleed + 20);

            player.getWeapon().addEnchantment(
                    "🩸 Razor Edge",
                    "(20% chance to cause bleed damage)"
            );

            System.out.println("🩸 --" + weapon.getName() + "-- is now sharpened with " + name + "! Bleed chance: "
                    + weapon.getBleedChance() + "% (💠- " + cost + " Soul Shards)");

            InputUtil.pressEnterToContinue();
        }
    }

    private void fortifiedPlating(String name, int cost) {
        if (boughtFortifiedPlating) {
            System.out.println(ColorUtil.boldBrightRed("❌ You have already acquired " + name + "!"));
            InputUtil.pressEnterToContinue();
            return;
        }

        if (attemptPurchase(name, cost)) {
            player.subtractSoulShards(cost);
            boughtFortifiedPlating = true;

            var armor = player.getArmor();
            int oldDef = armor.getDefBuff();
            armor.setAddDefBuff(armor.getAddDefBuff() + 10);
            armor.setHasEnchantment(true);

            PrintUtil.reward("🛡️ --" + armor.getName() + "-- is reinforced with " + name + "! Armor DEF: "
                    + oldDef + " → " + (armor.getDefBuff() + armor.getAddDefBuff()) + " (💠- " + cost + " Soul Shards)");

            player.recalculateBuffs();
            InputUtil.pressEnterToContinue();
        }
    }

    private void normalHealingPotion(String name, int cost) {
        System.out.println("🍃 " + name + " costs " + cost + " Soul Shards each.");
        System.out.println("You have 💠 " + player.getSoulShards() + " Soul Shards.");

        int maxAffordable = player.getSoulShards() / cost;
        if (maxAffordable == 0) {
            System.out.println("❌ Not enough Soul Shards to acquire any " + name + "!");
            InputUtil.pressEnterToContinue();
            return;
        }

        System.out.print("How many do you want to acquire? (1 - " + maxAffordable + ") : ");
        int amount;
        while (true) {
            amount = InputUtil.scanInput();
            if(amount == 0) return;
            if (amount >= 1 && amount <= maxAffordable) break;
            System.out.println("❌ Invalid amount! Enter a number between 1 and " + maxAffordable + ".");
        }

        int totalCost = amount * cost;
        if (attemptPurchase(name, cost, amount)) {
            player.subtractSoulShards(totalCost);
            player.getPotions().acquireNormalHealingPotion(amount);

            PrintUtil.reward("🧪 " + name + " acquired! You gained " + amount + " potion" + (amount > 1 ? "s" : "") + "."
                    + " (💠- " + totalCost + " Soul Shards)");
        }

        InputUtil.pressEnterToContinue();
    }

    private void fullHealingPotion(String name, int cost) {
        System.out.println("💞 " + name + " costs " + cost + " Soul Shards each.");
        System.out.println("You have 💠 " + player.getSoulShards() + " Soul Shards.");

        int maxAffordable = player.getSoulShards() / cost;
        if (maxAffordable == 0) {
            System.out.println("❌ Not enough Soul Shards to acquire any " + name + "!");
            InputUtil.pressEnterToContinue();
            return;
        }

        System.out.print("How many do you want to acquire? (1 - " + maxAffordable + ") : ");
        int amount;
        while (true) {
            amount = InputUtil.scanInput();
            if(amount == 0) return;
            if (amount >= 1 && amount <= maxAffordable) break;
            System.out.println("❌ Invalid amount! Enter a number between 1 and " + maxAffordable + ".");
        }

        int totalCost = amount * cost;
        if (attemptPurchase(name, cost, amount)) {
            player.subtractSoulShards(totalCost);
            player.getPotions().acquireFullHealingPotion(amount);

            PrintUtil.reward("🧪 " + name + " acquired! You gained " + amount + " potion"
                    + (amount > 1 ? "s" : "") + "." + " (💠- " + totalCost + " Soul Shards)");
        }

        InputUtil.pressEnterToContinue();
    }

    private void energyPotion(String name, int cost) {
        System.out.println("⚡ " + name + " costs " + cost + " Soul Shards each.");
        System.out.println("You have 💠 " + player.getSoulShards() + " Soul Shards.");

        int maxAffordable = player.getSoulShards() / cost;
        if (maxAffordable == 0) {
            System.out.println("❌ Not enough Soul Shards to acquire any " + name + "!");
            InputUtil.pressEnterToContinue();
            return;
        }

        System.out.print("How many do you want to acquire? (1 - " + maxAffordable + ") : ");
        int amount;
        while (true) {
            amount = InputUtil.scanInput();
            if(amount == 0) return;
            if (amount >= 1 && amount <= maxAffordable) break;
            System.out.println("❌ Invalid amount! Enter a number between 1 and " + maxAffordable + ".");
        }

        int totalCost = amount * cost;
        if (attemptPurchase(name, cost, amount)) {
            player.subtractSoulShards(totalCost);
            player.getPotions().acquireEnergyPotion(amount);

            PrintUtil.reward("⚡ " + name + " acquired! You gained " + amount + " potion"
                    + (amount > 1 ? "s" : "") + "." + " (💠- " + totalCost + " Soul Shards)");
        }

        InputUtil.pressEnterToContinue();
    }

    private void phoenixSoulstone(String name, int cost) {
        // already owns one
        if (player.getInventory().hasPhoenixSoulstone()) {
            System.out.println("❌ You already have a Phoenix Soulstone!");
            InputUtil.pressEnterToContinue();
            return;
        }

        // confirm purchase using attemptPurchase()
        if (attemptPurchase(name, cost)) {
            player.subtractSoulShards(cost);
            player.getInventory().acquirePhoenixSoulstone();

            PrintUtil.reward("🕊️ Phoenix Soulstone acquired!");
        }

        InputUtil.pressEnterToContinue();
    }

    private boolean confirmExit() {
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("⚠️ This is a one-time opportunity! ⚠️");
        System.out.println("The Magic Shop will not appear again.");
        System.out.print("Are you sure you want to leave? (1 = Yes, 0 = No): ");

        int choice;
        while (true) {
            choice = InputUtil.scanInput();
            if (choice == 1 || choice == 0) break;
            System.out.print("❌ Invalid input! Enter 1 for Yes or 0 for No: ");
        }
        System.out.println("────────────────────────────────────────────────────────");

        return choice == 1;
    }

}
