package characters;

import enemies.FinalBoss;
import story.ScenePrinter;
import utils.RandomUtil;

public class Kael extends  Character{      // 15% crit chance

    public Kael() {
        super("Kael Saint Laurent", "Swordsman" ,100, 5, 60, 10);
    }

    @Override
    public void displaySkills() {
        System.out.println("\n----------- KAEL'S SKILLS -----------");
        // Passive
        System.out.println("Passive – Blade Swift");
        System.out.println("15% chance to deal a Critical Hit (×1.5 damage).");
        System.out.println("Effect: When a Critical Hit occurs, Kael gains +5% Energy.\n");

        // Skill 1
        System.out.println("Skill 1 – Blade Rush (10 Energy)");
        System.out.println("Description: A quick, fluid slash that catches the opponent off guard.");
        System.out.println("Damage: (" + (int)(attack * 1.15) + " — " + (int)(attack * 1.35) + ")");
        System.out.println("Effects:");
        System.out.println("- 30% chance to apply Strengthen (+20% ATK for 2 turns)\n");

        // Skill 2
        System.out.println("Skill 2 – Piercing Slash (15 Energy)");
        System.out.println("Description: A powerful, focused strike aimed to shatter enemy defenses.");
        System.out.println("Damage: (" + (int)(attack * 1.35) + " — " + (int)(attack * 1.55) + ") — Ignores Defense");
        System.out.println("Effects:");
        System.out.println("- 30% chance to Stun (1 turn)\n");

        // Ultimate
        System.out.println("Ultimate – Eternal Cross Slash (30 Energy)");
        System.out.println("Description: Kael unleashes a flurry of crossing strikes infused with unyielding determination.");
        System.out.println("Damage: 3 hits, each dealing (" + (int)(attack * 1.40) + " — " + (int)(attack * 2.20) + ")");
        System.out.println("Effects:");
        System.out.println("- Applies Bleed (10 damage per turn for 2 turns)");
        System.out.println("- Grants Fortified: (+20% DEF for 2 turns)");
        System.out.println("-------------------------------------");
    }

    public void showBackstory() {
        ScenePrinter.line();
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
    private int bladeSwift(int damage) {
        if (RandomUtil.chance(15)) {
            System.out.println("⚡ Critical Hit! Blade Swift activated!");
            damage = (int) (damage * 1.5);

            // Gain +5% of max energy (bonus adrenaline)
            int energyGained = (int)(maxEnergy * 0.05);
            energy += energyGained;
            if (energy > maxEnergy) energy = maxEnergy;
            System.out.println("✨ Gained +" + energyGained + " energy from precision! ("
                    + energy + "/" + maxEnergy + ")");
        }
        return damage;
    }

    // Helper method to trigger weapon effects
    private void triggerWeaponEffect(Character target, int damage) {
        if (this.getWeapon() != null && this.getWeapon().applyEffects(this, damage)) {
            System.out.println("⚡ Weapon effect activated! Extra hit triggered.");

            int extraDamage = (int) RandomUtil.range(damage * 0.20, damage * 0.40);

            System.out.println("🗡 Extra hit from weapon for " + extraDamage + " damage!");
            target.takeDamage(extraDamage);
        }
    }

    // Skill 1 - Blade Rush
    public void bladeRush(Character target){
        int energyCost = 10;
        if(!consumeEnergy(energyCost)){
            System.out.println("Not enough energy to use Blade Rush!");
            return;
        }

        System.out.println("🗡️ You used Blade Rush on " + target.getName() + " (⚡-" + energyCost + " Energy)");

        if(this.getEffects().checkConfuse()) return;

        int damage = (int) RandomUtil.range(attack * 1.15,attack * 1.35);
        damage = bladeSwift(damage);
        int reduced = calculateDamage(target, damage);

        System.out.println("💔 Target is hit for " + reduced + " Damage!");
        target.takeDamage(reduced);

        // 30% chance to apply Strengthen (+20% ATK for 2 turns)
        if (RandomUtil.chance(30)) {
            getEffects().applyAttackBuff(20, 2);
        }

        // Apply weapon effects via helper
        triggerWeaponEffect(target, reduced);
    }

    // Skill 2 - Piercing Slash
    public void piercingSlash(Character target){
        int energyCost = 15;
        if(!consumeEnergy(energyCost)){
            System.out.println("Not enough energy to use Piercing Slash!");
            return;
        }

        System.out.println("💥 You used Piercing Slash on " + target.getName() + " (⚡-" + energyCost + " Energy)");

        if(this.getEffects().checkConfuse()) return;

        int damage = (int) RandomUtil.range(attack * 1.35,attack * 1.55);
        int reduced = bladeSwift(damage);

        System.out.println("💔 Target is hit for " + reduced + " Pure Damage!");
        target.takeDamage(reduced);

        // 30% chance to apply Stun (from the sheer impact)
        if (RandomUtil.chance(30)) {
            target.getEffects().applyStun(); // existing
            if (target instanceof FinalBoss fb) fb.applyStun(); // remove shield if turn skipped
        }

        // Apply weapon effects via helper
        triggerWeaponEffect(target, reduced);
    }

    //Ultimate - Eternal Cross Slash
    public void eternalCrossSlash(Character target){
        int energyCost = 30;
        if (!consumeEnergy(energyCost)) {
            System.out.println("Not enough energy to use Eternal Cross Slash!");
            return;
        }

        int totalDamage = 0;
        System.out.println("✝️ You unleash your ultimate technique: Eternal Cross Slash!" + " (⚡-" + energyCost + " Energy)");

        for(int i = 1; i <= 3; i++){
            int damage = (int) RandomUtil.range(attack * 1.40,attack * 2.20);
            damage = bladeSwift(damage);
            int reduced = calculateDamage(target, damage);

            if(this.getEffects().checkConfuse()) reduced = 0;
            totalDamage += reduced;

            System.out.println(" →🔪 Hit " + i + "! 💔 You slashed the Target for " + reduced + " damage!");

            // Apply weapon effects via helper
            if(reduced > 0)
                triggerWeaponEffect(target, reduced);
        }

        System.out.println("⚔️💥 Eternal Cross Slash finished! Total Damage dealt: " + totalDamage);
        target.takeDamage(totalDamage);

        target.getEffects().applyBleed(2);
        this.getEffects().applyDefenseBuff(20, 2);
        ultimateCounter = 3;
    }

    @Override
    public void turn(Character target) {
        boolean isValid = false;

        while (!isValid) {
            // If ultimate is on cooldown
            if (ultimateCounter > 0) {
                System.out.println("(1) Skill 1   -  Blade Rush (⚡ 10 energy)");
                System.out.println("(2) Skill 2   -  Piercing Slash (⚡ 15 energy)");
                System.out.println("(3) Ultimate  -  Eternal Cross Slash (⚡ 30 energy) ❌ (Available in " + ultimateCounter + " turns)");
                System.out.println("(4) Skip Turn -  Restore 10% of Max Energy");
                System.out.println("(5) Show Menu");
                System.out.print("Choose your action: ");

                int choice = utils.InputUtil.scan.nextInt();
                utils.InputUtil.scan.nextLine();
                ScenePrinter.shortLine();

                switch (choice) {
                    case 1 -> { bladeRush(target); isValid = true; ultimateCounter--;}
                    case 2 -> { piercingSlash(target); isValid = true; ultimateCounter--;}
                    case 3 -> { System.out.println("❌ Ultimate is on cooldown! Can only be used after " + ultimateCounter + " turns."); ScenePrinter.line();}
                    case 4 -> { skipTurn(); isValid = true; ultimateCounter--;}
                    case 5 -> displayMenu(this, target);
                    default -> { System.out.println(" Invalid action! You missed your turn."); isValid = true; ultimateCounter--;}
                }

            }
            // If ultimate is ready
            else {
                System.out.println("(1) Skill 1   -  Blade Rush (⚡ 10 energy)");
                System.out.println("(2) Skill 2   -  Piercing Slash (⚡ 15 energy)");
                System.out.println("(3) Ultimate  -  Eternal Cross Slash (⚡ 30 energy)");
                System.out.println("(4) Skip Turn -  Restore 10% of Max Energy");
                System.out.println("(5) Show Menu");
                System.out.print("Choose your action: ");

                int choice = utils.InputUtil.scan.nextInt();
                utils.InputUtil.scan.nextLine();
                ScenePrinter.shortLine();

                switch (choice) {
                    case 1 -> { bladeRush(target); isValid = true; }
                    case 2 -> { piercingSlash(target); isValid = true; }
                    case 3 -> { eternalCrossSlash(target); isValid = true; }
                    case 4 -> { skipTurn(); isValid = true; }
                    case 5 -> displayMenu(this, target);
                    default -> { System.out.println(" Invalid action! You missed your turn."); isValid = true; }
                }
            }
        }
    }

}
