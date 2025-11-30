package inventory;

import characters.Character;

public class LegendaryWeapon extends Weapon {

    public LegendaryWeapon() {
        super("Aetherblade", "🟣", 120);

        // legendary effects :P
        setLifestealPercent(25);
        setPoisonChance(10);
        setBleedChance(10);
        setStunChance(5);
        setFreezeChance(5);
        setEnergyPerAttack(-2);
        addEnchantment("Strike Twice", "25% chance to strike twice in one attack");
    }

    @Override
    public void applyEffects(Character player, Character enemy, int damage) {

        int heal = damage * getLifestealPercent() / 100;
        player.setHp(player.getHp() + heal);


    }

    @Override
    public void displayInfo() {
        System.out.println("🟣 Legendary Weapon: Aetherblade");
        System.out.println("ATK Buff: +" + getAtkBuff());
        System.out.println("Lifesteal: " + getLifestealPercent() + "%");
        System.out.println("Enchantments: " + getEnchantments());
    }
}
