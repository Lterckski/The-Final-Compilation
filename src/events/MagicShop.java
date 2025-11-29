package events;

import utils.InputUtil;
import utils.PrintUtil;
import characters.Character;

public class MagicShop {
    private final Character player;

    public MagicShop(Character player){
        this.player = player;
    }

    public void openShop() {
        boolean exit = false;

        while (!exit) {
            // Header
            System.out.println();
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                 ╔╦╗ ╔═╗ ╔═╗ ╦ ╔═╗   ╔═╗ ╦ ╦ ╔═╗ ╔═╗");
            System.out.println("                                 ║║║ ╠═╣ ║ ╦ ║ ║     ╚═╗ ╠═╣ ║ ║ ╠═╝");
            System.out.println("                                 ╩ ╩ ╩ ╩ ╚═╝ ╩ ╚═╝   ╚═╝ ╩ ╩ ╚═╝ ╩   ");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 💠 SOUL SHARDS : " + player.getSoulShards() +" <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
// Permanent Stat Upgrades
            System.out.println("╠══════════════════════════════════ 💎 PERMANENT STAT UPGRADES 💎 ══════════════════════════════╣");
            System.out.printf(" %5s%-3s %-33s %-42s 💠 %d%n", "[1]", " 💖", "Vitality Blessing", "+100 Max HP", 10);
            System.out.printf(" %5s%-3s %-33s %-42s 💠 %d%n", "[2]", " ⚔️", "Attack Infusion", "+8 ATK", 12);
            System.out.printf(" %5s%-3s %-33s %-42s 💠 %d%n", "[3]", " 🛡️", "Fortified Spirit", "+2 DEF", 10);

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

            System.out.printf(" %5s%-3s %-33s %-42s 💠 %d%n",
                    "[4]", " ⚡ ", "Soul Battery",
                    energyValue > 0 ? "+" + energyValue + energyLabel : " ❌",
                    8);


// Weapon/Armor Enchantments
            System.out.println("╠══════════════════════════════ 🌟 WEAPON / ARMOR ENCHANTMENTS 🌟 ══════════════════════════════╣");

            System.out.printf(" %5s%-3s %-30s %-45s 💠 %d%n", "[5]", " 🔥", "Flamebrand", "+10 Fire DMG " + xMark("Mage"), 28);
            System.out.printf(" %5s%-3s %-30s %-45s 💠 %d%n", "[6]", " ❄️", "Frost Arrow", "ATKs have 20% to Freeze " + xMark("Archer"), 28);
            System.out.printf(" %5s%-3s %-30s %-45s 💠 %d%n", "[7]", " ⚡ ", "Arc Surge", "+3 Energy per hit " + xMark("Mage"), 26);
            System.out.printf(" %5s%-3s %-30s %-45s 💠 %d%n", "[8]", " ☠️", "Venom Coating", "20% Poison chance" + xMark("Swordsman","Archer","Mage"), 32);
            System.out.printf(" %5s%-3s %-30s %-45s 💠 %d%n", "[9]", " 🩸", "Razor Edge", "+10% Bleed +10 Bleed DMG " + xMark("Swordsman", "Archer"), 28);
            System.out.printf(" %5s%-3s %-30s %-45s 💠 %d%n", "[10]", " 🛡️", "Fortified Plating", "Armor +6 DEF" + xMark("Swordsman","Archer","Mage"), 26);

// Potions
            System.out.println("╠══════════════════════════════════════════ 🧪 POTIONS 🧪 ══════════════════════════════════════╣");
            System.out.printf(" %5s%-3s %-38s %-37s 💠 %d%n", "[11]", " 🍃", "Normal Healing Potion", "1x", 6);
            System.out.printf(" %5s%-3s %-38s %-37s 💠 %d%n", "[12]", " 💞", "Full Healing Potion", "1x", 18);
            System.out.printf(" %5s%-3s %-38s %-37s 💠 %d%n", "[13]", " ⚡ ", "Energy Potion", "1x", 8);

// Special Item
            System.out.println("╠═══════════════════════════════════════ 🔮 SPECIAL ITEM 🔮 ════════════════════════════════════╣");
            System.out.printf(" %5s%-3s %-30s %-45s 💠 %d%n", "[14]", " 🕊️", "Phoenix Soulstone", "Revive once with 50% HP & Energy", 40);

// Exit
            System.out.println("╠═══════════════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.println("  [15] \uD83D\uDCDC Menu");
            System.out.println("   [0] ➜] Exit Shop");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════╝");

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
//                case 5 -> attemptPurchase(28, "Flamebrand", this::applyFlamebrand);
//                case 6 -> attemptPurchase(28, "Frost Arrow", this::applyFrostArrow);
//                case 7 -> attemptPurchase(26, "Arc Surge", this::applyArcSurge);
//                case 8 -> attemptPurchase(32, "Venom Coating", this::applyVenomCoating);
//                case 9 -> attemptPurchase(28, "Razor Edge", this::applyRazorEdge);
//                case 10 -> attemptPurchase(26, "Fortified Plating", this::applyFortifiedPlating);
//
//                // Potions
                case 11 -> normalHealingPotion("Normal Healing Potion", 6);
                case 12 -> fullHealingPotion("Full Healing Potion", 18);
                case 13 -> energyPotion("Energy Potion", 8);
//
//                // Special Item
                case 14 -> phoenixSoulstone("Phoenix Soulstone", 40);
                case 15 -> player.displayMenu(player);
                case 0 -> exit = confirmExit();
                default -> System.out.println("❌ Invalid input! Please select a valid option.");
            }
        }
    }

    private String xMark (String... allowedClasses) {
        for (String allowed : allowedClasses) {
            if (player.getClassType().equalsIgnoreCase(allowed)) {
                return "";   // allowed → no X mark
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

            System.out.println("💖 " + name + " applied! Max HP increased by 100. 💚 HP : " + oldMaxHP + " → " + player.getMaxHP()
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

            System.out.println("⚔️ " + name + " applied! ATK increased by 8. ⚔️ ATK : " + oldAtk + " → " + player.getAttack()
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

            System.out.println("🛡️ " + name + " applied! DEF increased by 2. 🛡️ DEF : " + oldDef + " → " + player.getDefense()
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

            System.out.println("⚡ " + name + " applied! Max Energy increased by "
                    + energyIncrease + ". " + player.getEnergyEmoji() + " " + player.getEnergyName() + " " + oldMaxEnergy + " → " + player.getMaxEnergy()
                    + " (💠- " + cost + " Soul Shards)");
        }
        InputUtil.pressEnterToContinue();
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
            if (amount >= 1 && amount <= maxAffordable) break;
            System.out.println("❌ Invalid amount! Enter a number between 1 and " + maxAffordable + ".");
        }

        int totalCost = amount * cost;
        if (attemptPurchase(name, cost, amount)) {
            player.subtractSoulShards(totalCost);
            player.getPotions().acquireNormalHealingPotion(amount);

            System.out.println("🧪 " + name + " acquired! You gained " + amount + " potion" + (amount > 1 ? "s" : "") + "."
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
            if (amount >= 1 && amount <= maxAffordable) break;
            System.out.println("❌ Invalid amount! Enter a number between 1 and " + maxAffordable + ".");
        }

        int totalCost = amount * cost;
        if (attemptPurchase(name, cost, amount)) {
            player.subtractSoulShards(totalCost);
            player.getPotions().acquireFullHealingPotion(amount);

            System.out.println("🧪 " + name + " acquired! You gained " + amount + " potion"
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
            if (amount >= 1 && amount <= maxAffordable) break;
            System.out.println("❌ Invalid amount! Enter a number between 1 and " + maxAffordable + ".");
        }

        int totalCost = amount * cost;
        if (attemptPurchase(name, cost, amount)) {
            player.subtractSoulShards(totalCost);
            player.getPotions().acquireEnergyPotion(amount);

            System.out.println("⚡ " + name + " acquired! You gained " + amount + " potion"
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

            System.out.println("🕊️ Phoenix Soulstone acquired!");
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
