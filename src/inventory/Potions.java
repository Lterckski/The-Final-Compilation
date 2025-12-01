package inventory;

import characters.Character;
import utils.ColorUtil;
import utils.InputUtil;
import utils.PrintUtil;
import utils.RandomUtil;

public class Potions {
    private final Character owner;
    private int normalHealingPotions = 0;   // restores +20 HP
    private int fullHealingPotions = 0;     // restores max HP
    private int energyPotions = 0;

    public Potions(Character owner) {
        this.owner = owner;
    }

    public int getNormalHealingPotions(){ return normalHealingPotions; }
    public int getFullHealingPotions(){ return fullHealingPotions; }
    public int getEnergyPotions(){ return energyPotions; }

    public void useNormalHealingPotion() {
        if (normalHealingPotions <= 0) {
            System.out.println("❌ No Normal Healing Potions left!");
            return;
        }
        normalHealingPotions--;

        int oldHP = owner.getHp();
        int healAmount = (int) (owner.getMaxHP() * 0.15);
        owner.heal(healAmount);
        int newHP = owner.getHp();

        System.out.println(ColorUtil.boldBrightGreen("💖✨ Used a Normal Healing Potion! Restored " + healAmount + " HP (" + oldHP + " → " + newHP + ")"));
    }

    public void useFullHealingPotion() {
        if (fullHealingPotions <= 0) {
            System.out.println("❌ No Full Healing Potions left!");
            return;
        }
        fullHealingPotions--;

        int oldHP = owner.getHp();
        owner.heal(owner.getMaxHP());
        int newHP = owner.getHp();

        System.out.println(ColorUtil.boldBrightGreen("💖✨ Used a Full Healing Potion! Fully restored HP! " + "(" + oldHP + " → " + newHP + ")"));
    }

    public void useEnergyPotion() {
        if (energyPotions <= 0) {
            System.out.println("❌ No Energy Potions left!");
            return;
        }

        energyPotions--;

        String energyName = owner.getEnergyName();
        String energyEmoji = owner.getEnergyEmoji();
        int oldEnergy = owner.getEnergy();
        int energyRestored = 0;

        switch (owner.getClassType()) {
            case "Swordsman" -> energyRestored = 30;
            case "Archer" -> energyRestored = 8;
            case "Mage" -> energyRestored = 40;
        }

        owner.restoreEnergy(energyRestored);
        int newEnergy = owner.getEnergy();

        System.out.println(ColorUtil.boldBrightGreen("✨ Used an Energy Potion! Restored " + energyRestored + " " + energyName + " (" + oldEnergy + " → " + newEnergy + ")"));
    }

    public void lootPotions(boolean willDropFullHealingPotions){
        int totalDrops = RandomUtil.range(1, 3);
        int normalHealingPotionsCount = 0;
        int energyPotionsCount = 0;

        for(int i = 0; i < totalDrops; i++){
            if(RandomUtil.chance(50)){
                normalHealingPotionsCount++;
                normalHealingPotions++;
            } else{
                energyPotionsCount++;
                energyPotions++;
            }
        }

        if(normalHealingPotionsCount > 0){
            System.out.println(ColorUtil.brightYellow("  🍃 " + normalHealingPotionsCount + " Normal Healing Potion" + (normalHealingPotionsCount > 1 ? "s" : "")));
        }
        if(energyPotionsCount > 0){
            System.out.println(ColorUtil.brightYellow("   ⚡ " + energyPotionsCount + " Energy Potion" + (energyPotionsCount > 1 ? "s" : "")));
        }

        if(willDropFullHealingPotions){
            int dropped = RandomUtil.range(1,2);
            fullHealingPotions += dropped;
            System.out.println(ColorUtil.brightYellow("  💞 " + dropped + " Full Healing Potion" + (dropped > 1 ? "s" : "")));
        }

    }

    public void acquireNormalHealingPotion(int amount){
        normalHealingPotions += amount;
    }
    public void acquireFullHealingPotion(int amount){
        fullHealingPotions += amount;
    }
    public void acquireEnergyPotion(int amount){
        energyPotions += amount;
    }
}
