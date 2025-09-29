package characters;

import utils.RandomUtil;

public class Kael extends  Character{
    private static final double CRIT_CHANCE = 0.15;  //passive
    private static final double CRIT_MULTIPLIER = 2.0;

    public Kael() { super("Kael Saint Laurent", 100, 5, 60, 10); }

    // Passive - Blade Swift
    private int bladeSwift(int damage){
        if(RandomUtil.get().nextDouble() < CRIT_CHANCE){
            System.out.println("⚡ Critical Hit! Blade Swift activated!");
            return (int)(damage * CRIT_MULTIPLIER);
        }
        return damage;
    }

    // Skill 1 - Blade Rush
    public void bladeRush(Character target){
        int energyCost = 10;
        if(!consumeEnergy(energyCost)){
            System.out.println("Not enough energy to use Blade Rush!");
            return;
        }

        int damage = (int) RandomUtil.range(attack * 1.15,attack * 1.35);
        damage = bladeSwift(damage);

        System.out.println("\uD83D\uDDE1\uFE0F You used Blade Rush on " + target.getName() + " for " + damage + " damage! " +  "(Energy: " + energy + "/" + maxEnergy + ")");
        target.takeDamage(damage,target.getDefense());
    }

    // Skill 2 - Guard Breaker
    public void guardBreaker(Character target){
        int energyCost = 15;
        if(!consumeEnergy(energyCost)){
            System.out.println("Not enough energy to use Guard Breaker!");
            return;
        }

        int damage = (int) RandomUtil.range(attack * 1.35,attack * 1.55);
        damage = bladeSwift(damage);

        System.out.println("\uD83D\uDCA5 You used Guard Breaker on " + target.getName() +  " for " + damage + " pure damage! " +  "(Energy: " + energy + "/" + maxEnergy + ")");
        target.takeDamage(damage,0); // defense ignored
    }

    //Ultimate - Eternal Cross Slash
    public void eternalCrossSlash(Character target){
        int energyCost = 30;
        if (!consumeEnergy(energyCost)) {
            System.out.println("Not enough energy to use Eternal Cross Slash!");
            return;
        }

        int totalDamage = 0;
        System.out.println("✝\uFE0F You unleash your ultimate technique: Eternal Cross Slash!");

        for(int i = 0; i < 3; i++){
            int damage = (int) RandomUtil.range(attack * 0.85,attack * 1.10);
            damage = bladeSwift(damage);
            totalDamage += damage;

            System.out.println(" → Hit " + (i + 1) + ": You slashed " + target.getName() +  " for " + damage + " damage!");
            target.takeDamage(damage, target.getDefense());
        }

        System.out.println("Eternal Cross Slash finished! Total damage dealt: " + totalDamage + " (Energy: " + energy + "/" + maxEnergy + ")");
    }
}
