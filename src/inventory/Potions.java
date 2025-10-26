package inventory;

import characters.Character;
import story.ScenePrinter;
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

    public void useNormalHealingPotion(){
        if(normalHealingPotions <= 0){
            System.out.println("❌ No Normal Healing Potions left!");
            return;
        }
        normalHealingPotions--;
        int healAmount = (int) (owner.getMaxHP() * 0.20);
        owner.heal(healAmount);
        System.out.println("💖✨ Used a Normal Healing Potion! Restored " + healAmount +  " (HP : " + owner.getHp() + "/" + owner.getMaxHP() + ")");
    }

    public void useFullHealingPotion(){
        if(fullHealingPotions <= 0){
            System.out.println("❌ No Full Healing Potions left!");
            return;
        }
        fullHealingPotions--;
        owner.heal(owner.getMaxHP());
        System.out.println("💖✨ Used a Full Healing Potion! Restored to max HP!" + " (HP : " + owner.getHp() + "/" + owner.getMaxHP() + ")");
    }

    public void useEnergyPotion() {
        if(energyPotions <= 0) {
            System.out.println("❌ No Energy Potions left!");
            return;
        }
        energyPotions--;
        int energyRestored = 30;  // amount restored
        owner.restoreEnergy(energyRestored);
        System.out.println("⚡✨ Used an Energy Potion! Restored " + energyRestored + " Energy (Energy: " + owner.getEnergy() + "/" + owner.getMaxEnergy() + ")");
    }

    public void lootPotions(){
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

        ScenePrinter.line();
        System.out.println("🎁 You received:");
        if(normalHealingPotionsCount > 0){
            System.out.println("❤️🧪 " + normalHealingPotionsCount + " Normal Healing Potion" + (normalHealingPotionsCount > 1 ? "s" : ""));
        }
        if(energyPotionsCount > 0){
            System.out.println("⚡🧪 " + energyPotionsCount + " Energy Potion" + (energyPotionsCount > 1 ? "s" : ""));
        }
        ScenePrinter.line();
    }

    public void lootFullHealthPotions(){
        int dropped = RandomUtil.range(1,2);
        fullHealingPotions += dropped;
        System.out.println("💖⚡ " + dropped + " Full Healing Potion" + (dropped > 1 ? "s" : ""));
    }

}
