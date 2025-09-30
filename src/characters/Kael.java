package characters;

import utils.RandomUtil;

public class Kael extends  Character{
    private static final double CRIT_CHANCE = 0.15;  //passive
    private static final double CRIT_MULTIPLIER = 2.0;

    public Kael() { super("Kael Saint Laurent", 100, 5, 60, 10); }

    @Override
    public void showSkills() {
        System.out.println("\nKael — Skills");
        System.out.println(" • Blade Rush (single-target slash)");
        System.out.println(" • Guard Breaker (ignores defense)");
        System.out.println(" • Eternal Cross Slash (3-hit finisher)");
        System.out.println(" Passive: Blade Swift (crit chance)");
    }

    public void showBackstory() {
        System.out.println("Kael Saint Laurent was born in the shadow of the Black Castle, in a family");
        System.out.println("that lived modestly within the crumbling Town of Decay. His childhood was");
        System.out.println("marked by sickness in the streets and guards demanding bribes, yet Kael never");
        System.out.println("let the rot of the world steal his spirit. He spent hours watching the castle");
        System.out.println("soldiers train, imitating their sword movements with sticks until his hands");
        System.out.println("blistered, slowly turning mimicry into skill.");
        System.out.println();
        System.out.println("Even as a child, he carried himself with the bearing of a leader. Kael would");
        System.out.println("gather the other children of the town into ragtag games of knights and kings,");
        System.out.println("but unlike the corrupted rulers above, he always played the protector—");
        System.out.println("shielding his friends from imagined dangers. In a place where hope was rare,");
        System.out.println("Kael's presence became a quiet anchor, hinting that even in the midst of");
        System.out.println("decay, someone could rise to stand against the darkness.");
    }

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
        int reduced = damage - target.getDefense();
        if (reduced < 0) reduced = 0;

        System.out.println("\uD83D\uDDE1\uFE0F You used Blade Rush on " + target.getName() + " for " + reduced + " damage! " +  "(Energy: " + energy + "/" + maxEnergy + ")");
        target.takeDamage(reduced);
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
        int reduced = damage;

        System.out.println("\uD83D\uDCA5 You used Guard Breaker on " + target.getName() +  " for " + reduced + " pure damage! " +  "(Energy: " + energy + "/" + maxEnergy + ")");
        target.takeDamage(reduced); // defense ignored
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
            int reduced = damage - target.getDefense();
            if (reduced < 0) reduced = 0;
            totalDamage += reduced;

            System.out.println(" → Hit " + (i + 1) + ": You slashed " + target.getName() +  " for " + reduced + " damage!");
        }

        System.out.println("Eternal Cross Slash finished! Total damage dealt: " + totalDamage + " (Energy: " + energy + "/" + maxEnergy + ")");
        target.takeDamage(totalDamage);
    }

    @Override
    public void turn(Character target) {
        System.out.println("\n-- Your Turn --");

        System.out.println("(1) Skill 1  - Blade Rush");
        System.out.println("(2) Skill 2  - Guard Breaker");
        System.out.println("(3) Ultimate - Eternal Cross Slash");
        System.out.print("Choose your action: ");

        int choice = utils.InputUtil.scan.nextInt();
        System.out.println("---------------");

        switch (choice) {
            case 1 -> bladeRush(target);
            case 2 -> guardBreaker(target);
            case 3 -> eternalCrossSlash(target);
            default -> System.out.println("❌ Invalid action! You missed your turn.");
        }
    }
}
