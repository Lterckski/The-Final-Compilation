package characters;

import utils.RandomUtil;

public class Karl extends Character{

    public Karl() { super("Karl Clover Dior IV", 80, 3, 80, 12); }

    @Override
    public void showSkills() {
        System.out.println("\nKarl — Skills");
        System.out.println(" • Piercing Arrow (armor-shred single shot)");
        System.out.println(" • Volley Storm (cone multi-shot)");
        System.out.println(" • Rain of a Thousand Arrows (area burst)");
        System.out.println(" Passive: Hunter’s Instinct (bonus vs low HP)");
    }

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
        int reduced = damage - reducedDefense;
        if (reduced < 0) reduced = 0;

        System.out.println("\uD83C\uDFF9 You used Piercing Arrow on " + target.getName() +  " for " + reduced + " damage (30% defense ignored). " +  "(Energy: " + energy + "/" + maxEnergy + ")");
        target.takeDamage(reduced);
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

        int reduced = damage - target.getDefense();
        if (reduced < 0) reduced = 0;

        System.out.println("\uD83C\uDFAF\uD83D\uDD25 You used Bullseye on " + target.getName() + " for " + reduced + " critical damage! " + "(Energy: " + energy + "/" + maxEnergy + ")");
        target.takeDamage(reduced);
    }

    public void rainOfAThousandArrows(Character target){
        int energyCost = 35;
        if(!consumeEnergy(energyCost)){
            System.out.println("Not enough energy to Rain of a Thousand arrows!");
            return;
        }

        int totalDamage = 0;
        System.out.println("\uD83C\uDF27\uFE0F\uD83C\uDFF9 You unleash your ultimate: Rain of a Thousand Arrows!");

        int reduced = 0;
        for (int i = 0; i < 5; i++) {
            int damage = (int) RandomUtil.range(attack * 1.5, attack * 2.5);
            damage = hunterInstincts(damage, target);
            reduced = damage - target.getDefense();
            if (reduced < 0) reduced = 0;
            totalDamage += reduced;
            System.out.println(" → Arrow " + (i + 1) + " pierced " + target.getName() + " for " + reduced + " damage!");
        }

        System.out.println("Rain of a Thousand Arrows finished! Total damage dealt: " + totalDamage + " (Energy: " + energy + "/" + maxEnergy + ")");
        target.takeDamage(totalDamage);
    }

    @Override
    public void turn(Character target) {
        System.out.println("\n-- Your Turn --");

        System.out.println("(1) Skill 1  - Piercing Arrow");
        System.out.println("(2) Skill 2  - Bullseye");
        System.out.println("(3) Ultimate - Rain of A Thousand Arrows");
        System.out.print("Choose your action: ");

        int choice = utils.InputUtil.scan.nextInt();
        System.out.println("---------------");

        switch (choice) {
            case 1 -> piercingArrow(target);
            case 2 -> bullsEye(target);
            case 3 -> rainOfAThousandArrows(target);
            default -> System.out.println("❌ Invalid action! You missed your turn.");
        }
    }
}



