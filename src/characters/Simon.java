package characters;

import story.ScenePrinter;
import utils.RandomUtil;

public class Simon extends Character {

    public Simon() { super("Simon Versace", "Mage", 60, 2, 150, 15); }

    @Override
    public void displaySkills() {
        System.out.println("\n----------- SIMON'S SKILLS -----------");
        System.out.println("Passive – Arcane Flow");
        System.out.println("Restores +5% of total Energy each turn.\n");

        System.out.println("Skill 1 – Fireball (15 Energy)");
        System.out.println("Description: Conjures a blazing orb of fire and hurls it at an enemy.");
        System.out.println("Damage: (" + (int)(attack * 1.25) + " — " + (int)(attack * 1.55) + ")");
        System.out.println("Effects:");
        System.out.println("- Applies Burn for 1 turn");
        System.out.println("- 30% chance to Weaken target (-20% ATK for 2 turns)\n");

        System.out.println("Skill 2 – Ice Prison (20 Energy)");
        System.out.println("Description: Encases the target in solid ice, restricting movement and draining warmth.");
        System.out.println("Damage: (" + (int)(attack * 0.60) + " — " + (int)(attack * 0.90) + ")");
        System.out.println("Effects:");
        System.out.println("- 30% chance to Freeze (target skips 1 turn)");
        System.out.println("- If frozen, reduces DEF by 15% for 2 turns\n");

        System.out.println("Ultimate – Meteor Storm (40 Energy)");
        System.out.println("Description: Summons a storm of blazing meteors that rain destruction upon all enemies.");
        System.out.println("Damage: (" + (int)(attack * 2.50) + " — " + (int)(attack * 3.50) + ")");
        System.out.println("Effects:");
        System.out.println("- 50% chance to apply Burn for 2 turns");
        System.out.println("- Grants +20% ATK (Arcane Empowerment) for 2 turns");
        System.out.println("--------------------------------------");
    }

    public void showBackstory() {
        System.out.println("Simon Versace—a mage with an unshakable dream of becoming the most");
        System.out.println("powerful sorcerer alive. From childhood, mana coursed naturally through");
        System.out.println("his veins, earning him the title of prodigy in the whispers of others.");
        System.out.println("Yet beneath that promise of greatness, Simon was still just a boy—");
        System.out.println("vulnerable, human, and plagued by a fear he could never quite conquer: spiders.");
        System.out.println();
        System.out.println("He hails from the Forest of Silence, a place where no birds sing and no");
        System.out.println("wind dares stir the trees. The air is unnaturally still, as if the forest");
        System.out.println("itself is holding its breath—an unsettling quiet that lingers in the minds");
        System.out.println("of all who dwell there. Within its academy, Simon immersed himself in study,");
        System.out.println("mastering theory and knowledge with ease. But soon, he discovered that wisdom");
        System.out.println("confined to books was not enough to fulfill his ambitions.");
        System.out.println();
        System.out.println("If he truly wished to claim power, he would need more than learning—");
        System.out.println("he would need experience.");
    }

    private void arcaneFlow() {
        int restored = (int)(maxEnergy * 0.05);
        this.restoreEnergy(restored);

        System.out.println("✨ Arcane Flow restores " + restored + " energy! " + "(Energy: " + energy + "/" + maxEnergy + ")");
    }

    // Skill 1 – Fireball
    public void fireball(Character target) {
        int energyCost = 15;
        if (consumeEnergy(energyCost)) {
            System.out.println("Not enough energy to cast Fireball!");
            return;
        }

        int damage = (int) RandomUtil.range(attack * 1.25, attack * 1.55);
        int reduced = damage - target.getDefense();
        if (reduced < 0) reduced = 0;

        // Fireball
        System.out.println("🔥 You cast Fireball on " + target.getName() + " for " + reduced + " damage! (Energy: " + energy + "/" + maxEnergy + ")");
        target.takeDamage(reduced);

        getInventory().getEquippedWeapon().applyEffects(target, reduced);

        // Apply Burn
        target.getEffects().applyBurn(1);

        // 30% chance to apply Weaken
        if (RandomUtil.chance(30)) {
            target.getEffects().applyAttackDebuff(20, 2);
        }
        arcaneFlow();

    }

    // Skill 2 – Ice Prison
    public void icePrison(Character target) {
        int energyCost = 20;
        if (consumeEnergy(energyCost)) {
            System.out.println("Not enough energy to cast Ice Prison!");
            return;
        }

        int damage = (int) RandomUtil.range(attack * 0.60, attack * 0.90);
        int reduced = damage - target.getDefense();
        if (reduced < 0) reduced = 0;

        System.out.println("❄️ You cast Ice Prison on " + target.getName() + " for " + reduced + " damage! (Energy: " + energy + "/" + maxEnergy + ")");
        target.takeDamage(reduced);

        getInventory().getEquippedWeapon().applyEffects(target, reduced);

        // 30% chance to Freeze
        if (RandomUtil.chance(30)) {
            target.getEffects().applyFreeze();
            // If frozen, apply DEF reduction
            target.getEffects().applyDefenseDebuff(15, 2);
        }
        arcaneFlow();

    }

    // Ultimate – Meteor Storm
    public void meteorStorm(Character target) {
        int energyCost = 40;
        if (consumeEnergy(energyCost)) {
            System.out.println("Not enough energy to cast Meteor Storm!");
            return;
        }

        int damage = (int) RandomUtil.range(attack * 2.50, attack * 3.50);
        int reduced = damage - target.getDefense();
        if (reduced < 0) reduced = 0;

        System.out.println("☄️ You unleash Meteor Storm on " + target.getName() + " for " + reduced + " damage! (Energy: " + energy + "/" + maxEnergy + ")");
        target.takeDamage(reduced);

        getInventory().getEquippedWeapon().applyEffects(target, reduced);

        // 50% chance to Burn
        if (RandomUtil.chance(50)) {
            target.getEffects().applyBurn(2);
        }

        // Apply ATK buff to Simon
        this.getEffects().applyAttackBuff(20, 2);
        arcaneFlow();
        ultimateCounter = 3;
    }

    @Override
    public void turn(Character target) {
        boolean isValid = false;

        while (!isValid) {
            // If ultimate is on cooldown
            if (ultimateCounter > 0) {
                System.out.println("(1) Skill 1   -  Fireball");
                System.out.println("(2) Skill 2   -  Ice Prison");
                System.out.println("(3) Ultimate  -  Meteor Storm ❌ (Available in " + ultimateCounter + " turns)");
                System.out.println("(4) Skip Turn -  Restore 10% of Max Energy");
                System.out.println("(0) Show Menu");
                System.out.print("Choose your action: ");

                int choice = utils.InputUtil.scan.nextInt();
                utils.InputUtil.scan.nextLine();
                System.out.println("---------------");

                switch (choice) {
                    case 1 -> { fireball(target); isValid = true; ultimateCounter--; }
                    case 2 -> { icePrison(target); isValid = true; ultimateCounter--; }
                    case 3 -> System.out.println("❌ Ultimate is on cooldown! Can only be used after " + ultimateCounter + " turns.");
                    case 4 -> { skipTurn(); isValid = true; ultimateCounter--; }
                    case 5 -> displayMenu(this, target); // doesn’t consume the turn
                    default -> { System.out.println("❌ Invalid action! You missed your turn."); isValid = true; ultimateCounter--; }
                }

            }
            // If ultimate is ready
            else {
                ScenePrinter.shortLine();
                System.out.println("(1) Skill 1   -  Fireball");
                System.out.println("(2) Skill 2   -  Ice Prison");
                System.out.println("(3) Ultimate  -  Meteor Storm");
                System.out.println("(4) Skip Turn -  Restore 10% of Max Energy");
                System.out.println("(5) Show Menu");
                System.out.print("Choose your action: ");

                int choice = utils.InputUtil.scan.nextInt();
                utils.InputUtil.scan.nextLine();
                ScenePrinter.shortLine();

                switch (choice) {
                    case 1 -> { fireball(target); isValid = true; }
                    case 2 -> { icePrison(target); isValid = true; }
                    case 3 -> { meteorStorm(target); ultimateCounter = 3; isValid = true; }
                    case 4 -> { skipTurn(); isValid = true; }
                    case 5 -> displayMenu(this, target); // doesn’t consume the turn
                    default -> { System.out.println("❌ Invalid action! You missed your turn."); isValid = true; }
                }
            }
        }
    }


}
