package characters;

import utils.RandomUtil;

public class Karl extends Character {

    public Karl() {
        super("Karl Clover Dior IV", 80, 3, 80, 12);
    }

    // Passive
    private int applyHunterInstincts(int baseDamage, Character enemy){
       double hpPercent = (double) enemy.getHp() / enemy.maxHp;

       if(hpPercent < 0.3){
        baseDamage*=1.2;
        System.out.println("Hunter's Instinct activated!. Extra damage dealt.");
       }
       return baseDamage;
    }
    

    // Skill 1
    public void piercingArrow(Character enemy){
        int energyCost = 10;
        if(!consumeEnergy(energyCost)){
            System.out.println("Not enough energy to use Peircing Arrow!");
            return;
        }
        
        double multiplier = RandomUtil.range(1.10, 1.25);
        int rawDamage = (int) (attack * multiplier);
        rawDamage = applyHunterInstincts(rawDamage, enemy);

        int reducedDefense = (int) (enemy.getDefense() * 0.7);

        System.out.println(name + " used Peircing Arrow! Damage: " + rawDamage);
        enemy.takeDamage(rawDamage, reducedDefense);

        
    }
    
    // Skill 2
    public void bullsEye(Character enemy){
        int energyCost = 20;
        if(!consumeEnergy(energyCost)){
            System.out.println("Not enough energy to use Bullseye!");
            return;
        }

        double multiplier = RandomUtil.range(1.25, 1.50);
        int rawDamage = (int) (attack * multiplier);

        rawDamage*=1.1; // <-- applies 10% critical damage(always crit);
        rawDamage = applyHunterInstincts(rawDamage, enemy);

        System.out.println(name + " used Bullseye! Damage: " + rawDamage);
        enemy.takeDamage(rawDamage, enemy.getDefense());
    }


        // Ultimate
       public void rainOfAThousandArrow(Character enemy){
        int energyCost = 35;
        if(!consumeEnergy(energyCost)){
            System.out.println("Not enough energy to Rain of a Thousand arrows!");
            return;
        }

        System.out.println(name  + " unleashed Rain Of a Thousand Arrows!");

        for(int i= 0 ; i < 5; i++){
            double multiplier = RandomUtil.range(1.5, 2.5);
            int rawDamage = (int)(attack * multiplier);
            rawDamage = applyHunterInstincts(rawDamage, enemy);
            System.out.println("Hit " + (i+1) +": " + rawDamage + " damage!");
            enemy.takeDamage(rawDamage, enemy.getDefense());
           
        }
       }
    
}