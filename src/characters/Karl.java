package characters;

import utils.RandomUtil;

public class Karl extends Character {

    public Karl() { super("Karl Clover Dior IV", 80, 3, 80, 12); }

    // Passive - Hunter's Instinct
    private int hunterInstincts(int damage, Character target){
       double hpPercent = (double) target.getHp() / target.maxHp;

       if(hpPercent < 0.3){
           damage = (int) (damage * 1.2);
           System.out.println("\uD83C\uDFAF Hunter's Instinct activated! Extra damage dealt.");
       }
       return damage;
    }

    // Skill 1 - Piercing Arrow
    public void piercingArrow(Character target){
        int energyCost = 10;
        if(!consumeEnergy(energyCost)){
            System.out.println("Not enough energy to use Piercing Arrow!");
            return;
        }

        int damage = (int) RandomUtil.range(attack * 1.10, attack * 1.25);
        damage = hunterInstincts(damage, target);

        int reducedDefense = (int)(target.getDefense() * 0.7);

        System.out.println("\uD83C\uDFF9 You used Piercing Arrow on " + target.getName() +  " for " + damage + " damage (30% defense ignored). " +  "(Energy: " + energy + "/" + maxEnergy + ")");
        target.takeDamage(damage, reducedDefense);
    }

    // Skill 2 - Bullseye
    public void bullsEye(Character target){
        int energyCost = 20;
        if(!consumeEnergy(energyCost)){
            System.out.println("Not enough energy to use Bullseye!");
            return;
        }

        int damage = (int) RandomUtil.range(attack*1.25, attack*1.50);

        damage = (int) (damage * 1.1); // <-- applies 10% critical damage(always crit);
        damage = hunterInstincts(damage, target);

        System.out.println("\uD83C\uDFAF\uD83D\uDD25 You used Bullseye on " + target.getName() + " for " + damage + " critical damage! " + "(Energy: " + energy + "/" + maxEnergy + ")");
        target.takeDamage(damage, target.getDefense());
    }

        // Ultimate
       public void rainOfAThousandArrows(Character target){
        int energyCost = 35;
        if(!consumeEnergy(energyCost)){
            System.out.println("Not enough energy to Rain of a Thousand arrows!");
            return;
        }

        int totalDamage = 0;
        System.out.println("\uD83C\uDF27\uFE0F\uD83C\uDFF9 You unleash your ultimate: Rain of a Thousand Arrows!");

        for (int i = 0; i < 5; i++) {
            int damage = (int) RandomUtil.range(attack * 1.5, attack * 2.5);
            damage = hunterInstincts(damage, target);
            totalDamage += damage;

            target.takeDamage(damage, target.getDefense());
            System.out.println(" → Arrow " + (i + 1) + " pierced " + target.getName() + " for " + damage + " damage!");
        }

        System.out.println("Rain of a Thousand Arrows finished! Total damage dealt: " + totalDamage + " (Energy: " + energy + "/" + maxEnergy + ")");
       }
}