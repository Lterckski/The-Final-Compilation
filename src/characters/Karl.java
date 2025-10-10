package characters;

import utils.RandomUtil;

public class Karl extends Character{

    public Karl() { super("Karl Clover Dior IV", 80, 3, 80, 12); }

    @Override
    public void showSkills() {
        System.out.println("\n----------- KARL'S SKILLS -----------");
        System.out.println("Passive – Hunter’s Instinct");
        System.out.println("Deal +20% damage to enemies below 30% HP.\n");

        System.out.println("Skill 1 – Piercing Arrow (10 Energy)");
        System.out.println("Description: Fires an arrow that slices through armor and flesh alike.");
        System.out.println("Damage: (" + (int)(attack * 1.10) + " — " + (int)(attack * 1.25) + ")");
        System.out.println("Effects:");
        System.out.println("- Ignores 30% of the target’s Defense");
        System.out.println("- 30% chance to inflict Bleed (2 turns)\n");

        System.out.println("Skill 2 – Bullseye (20 Energy)");
        System.out.println("Description: Karl steadies his breath and fires a deadly precise shot.");
        System.out.println("Damage: (" + (int)(attack * 1.25) + " — " + (int)(attack * 1.50) + ")");
        System.out.println("Effects:");
        System.out.println("- Guaranteed Critical Hit (×1.5 multiplier)");
        System.out.println("- 30% chance to apply Weakness: reduce target’s DEF by 30% for 2 turns\n");

        System.out.println("Ultimate – Rain of a Thousand Arrows (35 Energy)");
        System.out.println("Description: Karl releases a rapid flurry of arrows, overwhelming his opponent with relentless strikes.");
        System.out.println("Damage: 5 hits, each dealing (" + (int)(attack * 1.50) + " — " + (int)(attack * 2.50) + ")");
        System.out.println("Effects:");
        System.out.println("- Grants Nimble after attack (increased dodge chance)");
        System.out.println("- Grants Strengthen (+20% ATK for 2 turns)");
        System.out.println("-------------------------------------");
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
        if(target.getEffects().checkConfuse()) return;

        int energyCost = 10;
        if(consumeEnergy(energyCost)){
            System.out.println("Not enough energy to use Piercing Arrow!");
            return;
        }

        int damage = (int) RandomUtil.range(attack * 1.10, attack * 1.25);
        damage = hunterInstincts(damage, target);

        int reducedDefense = (int)(target.getDefense() * 0.7);
        int reduced = damage - reducedDefense;
        if (reduced < 0) reduced = 0;

        System.out.println("\uD83C\uDFF9 You used Piercing Arrow on " + target.getName() +  " for " + reduced + " damage (30% defense ignored). " +  "(Energy: " + energy + "/" + maxEnergy + ")");
        if(!target.getEffects().checkDodge())
            target.takeDamage(reduced);

        if(RandomUtil.chance(30)){
            target.getEffects().applyBleed(2);
        }
    }

    // Skill 2 - Bullseye
    public void bullsEye(Character target){
        if(target.getEffects().checkConfuse()) return;

        int energyCost = 20;
        if(consumeEnergy(energyCost)){
            System.out.println("Not enough energy to use Bullseye!");
            return;
        }

        int damage = (int) RandomUtil.range(attack*1.25, attack*1.50);
        damage = (int) (damage * 1.5); // <-- applies 50% critical damage(always crit);
        damage = hunterInstincts(damage, target);

        int reduced = damage - target.getDefense();
        if (reduced < 0) reduced = 0;

        System.out.println("\uD83C\uDFAF\uD83D\uDD25 You used Bullseye on " + target.getName() + " for " + reduced + " critical damage! " + "(Energy: " + energy + "/" + maxEnergy + ")");
        target.takeDamage(reduced);

        if(RandomUtil.chance(30)){
            target.getEffects().applyDefenseDebuff(30, 2);
        }
    }

    public void rainOfAThousandArrows(Character target){
        int energyCost = 35;
        if(consumeEnergy(energyCost)){
            System.out.println("Not enough energy to Rain of a Thousand arrows!");
            return;
        }

        int totalDamage = 0;
        System.out.println("\uD83C\uDF27️\uD83C\uDFF9 You unleash your ultimate: Rain of a Thousand Arrows!");

        int reduced;
        for (int i = 0; i < 5; i++) {
            int damage = (int) RandomUtil.range(attack * 1.5, attack * 2.5);
            damage = hunterInstincts(damage, target);
            reduced = damage - target.getDefense();
            if (reduced < 0) reduced = 0;

            if(target.getEffects().checkConfuse()) reduced = 0;
            totalDamage += reduced;

            System.out.println(" → Arrow " + (i + 1) + " pierced " + target.getName() + " for " + reduced + " damage!");
        }

        System.out.println("Rain of a Thousand Arrows finished! Total damage dealt: " + totalDamage + " (Energy: " + energy + "/" + maxEnergy + ")");
        target.takeDamage(totalDamage);

        this.getEffects().applyNimble();
        this.getEffects().applyAttackBuff(20, 2+1);
        ultimateCounter = 3;
    }

    @Override
    public void turn(Character target) {
        boolean isValid = false;

        while (!isValid) {
            // If ultimate is on cooldown
            if (ultimateCounter > 0) {
                System.out.println("(1) Skill 1   -  Piercing Arrow");
                System.out.println("(2) Skill 2   -  Bullseye");
                System.out.println("(3) Ultimate  -  Rain of A Thousand Arrows ❌ (Available in " + ultimateCounter + " turns)");
                System.out.println("(4) Skip Turn -  Restore 10% of Max Energy");
                System.out.println("(5) Show Menu");
                System.out.print("Choose your action: ");

                int choice = utils.InputUtil.scan.nextInt();
                System.out.println("---------------");
                utils.InputUtil.scan.nextLine();

                switch (choice) {
                    case 1 -> { piercingArrow(target); isValid = true; ultimateCounter--; }
                    case 2 -> { bullsEye(target); isValid = true; ultimateCounter--; }
                    case 3 -> System.out.println("❌ Ultimate is on cooldown! Can only be used after " + ultimateCounter + " turns.");
                    case 4 -> { skipTurn(); isValid = true; ultimateCounter--; }
                    case 5 -> showMenu(this, target);
                    default -> { System.out.println("❌ Invalid action! You missed your turn."); isValid = true; ultimateCounter--; }
                }

            }
            // If ultimate is ready
            else {
                System.out.println("(1) Skill 1   -  Piercing Arrow");
                System.out.println("(2) Skill 2   -  Bullseye");
                System.out.println("(3) Ultimate  -  Rain of A Thousand Arrows");
                System.out.println("(4) Skip Turn -  Restore 10% of Max Energy");
                System.out.println("(5) Show Menu");
                System.out.print("Choose your action: ");

                int choice = utils.InputUtil.scan.nextInt();
                System.out.println("---------------");
                utils.InputUtil.scan.nextLine();

                switch (choice) {
                    case 1 -> { piercingArrow(target); isValid = true; }
                    case 2 -> { bullsEye(target); isValid = true; }
                    case 3 -> { rainOfAThousandArrows(target); ultimateCounter = 3; isValid = true; }
                    case 4 -> { skipTurn(); isValid = true; }
                    case 5 -> showMenu(this, target);
                    default -> { System.out.println("❌ Invalid action! You missed your turn."); isValid = true; }
                }
            }
        }
    }

}



