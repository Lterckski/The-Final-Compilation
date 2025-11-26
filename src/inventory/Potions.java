package inventory;

import characters.Character;
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
            PrintUtil.pause(800);
            return;
        }
        normalHealingPotions--;

        int oldHP = owner.getHp();
        int healAmount = (int) (owner.getMaxHP() * 0.20);
        owner.heal(healAmount);
        int newHP = owner.getHp();

        System.out.println("💖✨ Used a Normal Healing Potion! Restored "
                + healAmount + " HP (" + oldHP + " → " + newHP + ")");
        PrintUtil.pause(800);
    }

    public void useFullHealingPotion() {
        if (fullHealingPotions <= 0) {
            System.out.println("❌ No Full Healing Potions left!");
            PrintUtil.pause(800);
            return;
        }
        fullHealingPotions--;

        int oldHP = owner.getHp();
        owner.heal(owner.getMaxHP());
        int newHP = owner.getHp();

        System.out.println("💖✨ Used a Full Healing Potion! Fully restored HP! "
                + "(" + oldHP + " → " + newHP + ")");
        PrintUtil.pause(800);
    }

    public void useEnergyPotion() {
        if (energyPotions <= 0) {
            System.out.println("❌ No Energy Potions left!");
            PrintUtil.pause(800);
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

        System.out.println(energyEmoji + "✨ Used an Energy Potion! Restored "
                + energyRestored + " " + energyName + " ("
                + oldEnergy + " → " + newEnergy + ")");
        PrintUtil.pause(800);
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

        PrintUtil.line();
        System.out.println("🎁 You received:");
        PrintUtil.pause(800);

        if(normalHealingPotionsCount > 0){
            System.out.println("❤️🧪 " + normalHealingPotionsCount + " Normal Healing Potion" + (normalHealingPotionsCount > 1 ? "s" : ""));
            PrintUtil.pause(800);
        }
        if(energyPotionsCount > 0){
            System.out.println("⚡🧪 " + energyPotionsCount + " Energy Potion" + (energyPotionsCount > 1 ? "s" : ""));
            PrintUtil.pause(800);
        }
        PrintUtil.line();
    }

    public void addNormalHealingPotions(int amount) {
        if (amount <= 0) return;

        normalHealingPotions += amount;
        PrintUtil.line();
        System.out.println("🎁 Bonus reward: ❤️🧪 " + amount
                + " Healing Potion" + (amount > 1 ? "s" : "") + " added to your inventory!");
        PrintUtil.pause(800);
    }

    public void lootFullHealthPotions(){
        int dropped = RandomUtil.range(1,2);
        fullHealingPotions += dropped;
        System.out.println("💖⚡ " + dropped + " Full Healing Potion" + (dropped > 1 ? "s" : ""));
        PrintUtil.pause(800);
    }

}
