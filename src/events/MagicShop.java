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
            System.out.println("                                   ╔╦╗╔═╗╔═╗╦╔═╗  ╔═╗╦ ╦╔═╗╔═╗");
            System.out.println("                                   ║║║╠═╣║ ╦║║    ╚═╗╠═╣║ ║╠═╝");
            System.out.println("                                   ╩ ╩╩ ╩╚═╝╩╚═╝  ╚═╝╩ ╩╚═╝╩   ");

// Permanent Stat Upgrades
            System.out.println("╠══════════════════════════════════ 💎 PERMANENT STAT UPGRADES 💎 ══════════════════════════════╣");
            System.out.printf(" %5s%-3s %-30s %-45s 💠 %d%n", "[1]", " 💖", "Vitality Blessing", "+100 Max HP", 10);
            System.out.printf(" %5s%-3s %-30s %-45s 💠 %d%n", "[2]", " ⚔️", "Attack Infusion", "+8 ATK", 12);
            System.out.printf(" %5s%-3s %-30s %-45s 💠 %d%n", "[3]", " 🛡️", "Fortified Spirit", "+2 DEF", 10);

// Dynamic Soul Battery based on class
            String energyLabel = player.getClassType().equalsIgnoreCase("Mage") ? " Mana" :
                    player.getClassType().equalsIgnoreCase("Archer") ? " Arrows" : " Stamina";
            int energyValue = player.getClassType().equalsIgnoreCase("Archer") ? 2 : 6;
            System.out.printf(" %5s%-3s %-30s %-45s 💠 %d%n", "[4]", " ⚡ ", "Soul Battery", "+" + energyValue + energyLabel, 8);

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
            System.out.printf(" %5s%-3s %-30s %-45s 💠 %d%n", "[11]", " 🍃", "Normal Healing Potion", "1x", 6);
            System.out.printf(" %5s%-3s %-30s %-45s 💠 %d%n", "[12]", " 💞", "Full Healing Potion", "1x", 10);
            System.out.printf(" %5s%-3s %-30s %-45s 💠 %d%n", "[13]", " ⚡ ", "Energy Potion", "1x", 8);

// Special Item
            System.out.println("╠═══════════════════════════════════════ 🔮 SPECIAL ITEM 🔮 ════════════════════════════════════╣");
            System.out.printf(" %5s%-3s %-30s %-45s 💠 %d%n", "[14]", " 🕊️", "Phoenix Soulstone", "Revive once with 50% HP & Energy", 40);

// Exit
            System.out.println("╠═══════════════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.println("  \uD83D\uDCDC [15] Menu");
            System.out.println("   ➜] [0] Exit Shop");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════╝");

            System.out.println("💠 Soul Shards : " + player.getSoulShards());
            System.out.print("Enter item to purchase: ");
            int choice = InputUtil.scanInput();
            PrintUtil.line();

//            switch (choice) {
//                // Permanent Stat Upgrades
//                case 1 -> attemptPurchase(10, "Vitality Blessing", () -> applyVitalityBlessing(100));
//                case 2 -> attemptPurchase(12, "Attack Infusion", () -> applyAttackInfusion(8));
//                case 3 -> attemptPurchase(10, "Fortified Spirit", () -> applyFortifiedSpirit(2));
//                case 4 -> attemptPurchase(8, "Soul Battery", () -> applySoulBattery(6));
//
//                // Weapon / Armor Enchantments
//                case 5 -> attemptPurchase(28, "Flamebrand", this::applyFlamebrand);
//                case 6 -> attemptPurchase(28, "Frost Arrow", this::applyFrostArrow);
//                case 7 -> attemptPurchase(26, "Arc Surge", this::applyArcSurge);
//                case 8 -> attemptPurchase(32, "Venom Coating", this::applyVenomCoating);
//                case 9 -> attemptPurchase(28, "Razor Edge", this::applyRazorEdge);
//                case 10 -> attemptPurchase(26, "Fortified Plating", this::applyFortifiedPlating);
//
//                // Potions
//                case 11 -> acquireNormalHealingPotion(1);
//                case 12 -> acquireFullHealingPotion(1);
//                case 13 -> acquireEnergyPotion(1);
//
//                // Special Item
//                case 14 -> acquirePhoenixSoulstone();
//
//                case 0 -> exit = true;
//                default -> System.out.println("❌ Invalid input! Please select a valid option.");
//            }
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



}
