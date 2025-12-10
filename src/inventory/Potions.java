package inventory;

import characters.Character;
import utils.ColorUtil;
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
        int actualRestored = newHP - oldHP;

        System.out.println(ColorUtil.boldBrightGreen(
                "💖✨ Used a Normal Healing Potion! Restored "
                        + actualRestored + " HP (" + oldHP + " → " + newHP + ")"
        ));
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
        int actualRestored = newHP - oldHP;

        System.out.println(ColorUtil.boldBrightGreen(
                "💖✨ Used a Full Healing Potion! Restored "
                        + actualRestored + " HP (" + oldHP + " → " + newHP + ")"
        ));
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
        int restore = switch (owner.getClassType()) {
            case "Swordsman" -> 30;
            case "Archer"    -> 6;
            case "Mage"      -> 40;
            default -> 0;
        };

        owner.restoreEnergy(restore);

        int newEnergy = owner.getEnergy();
        int actualRestored = newEnergy - oldEnergy;

        System.out.println(ColorUtil.boldBrightGreen(
                "✨ Used an Energy Potion! Restored "
                        + actualRestored + " " + energyName + " (" + oldEnergy + " → " + newEnergy + ")"
        ));
    }

    public void lootPotions(boolean isMiniBoss){
        int totalDrops;

        if(isMiniBoss){
            totalDrops = RandomUtil.range(4,8);
        } else{
            if(RandomUtil.chance(70))
                totalDrops = RandomUtil.range(1, 3);
            else
                totalDrops = 0;
        }


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

        if(isMiniBoss){
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
