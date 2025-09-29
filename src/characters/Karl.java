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
    @Override
    public void showSkills() {
        System.out.println("Karl — Skills");
        System.out.println(" • Piercing Arrow (armor-shred single shot)");
        System.out.println(" • Volley Storm (cone multi-shot)");
        System.out.println(" • Rain of a Thousand Arrows (area burst)");
        System.out.println(" Passive: Hunter’s Instinct (bonus vs low HP)");
    }

    @Override
public void showBackstory() {
    System.out.println("Karl Clover Dior IV was born and raised in the Forest of Silence, a place");
    System.out.println("where the air is thick with mist and danger lurks in every shadow.");
    System.out.println("His father, once a skilled archer, taught him the bow not as a weapon of");
    System.out.println("glory but as a means of survival against Rotfang Wolves, Carrion Bats, and");
    System.out.println("the twisted Dreadbark Treants that haunted their home.");
    System.out.println();
    System.out.println("The forest shaped Karl's instincts—quiet, patient, always watching—and his");
    System.out.println("arrows rarely missed their mark. When the silence deepened and the Hollow");
    System.out.println("Stag began to prowl, Karl realized that the forest itself had become");
    System.out.println("corrupted, demanding a hunter strong enough to fight back.");
    System.out.println();
    System.out.println("Now, with his father's teachings in his heart and the weight of his homeland");
    System.out.println("on his shoulders, Karl hunts not just for survival but to restore the balance");
    System.out.println("of the place he calls home.");
}
 }
