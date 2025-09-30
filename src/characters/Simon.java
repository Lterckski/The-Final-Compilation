package characters;

import utils.RandomUtil;

public class Simon extends  Character{

    public Simon() { super("Simon Versace", 60, 2, 150, 15); }

    @Override
    public void showSkills() {
        System.out.println("\nSimon — Skills");
        System.out.println(" • Fireball (burst single-target)");
        System.out.println(" • Ice Prison (control + damage)");
        System.out.println(" • Meteor Storm (AoE devastation)");
        System.out.println(" Passive: Arcane Flow (restore energy on successful casts)");
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
        energy += restored;
        if (energy > maxEnergy) energy = maxEnergy;

        System.out.println("✨ Arcane Flow restores " + restored + " energy! " + "(Energy: " + energy + "/" + maxEnergy + ")");
    }

    // Skill 1 - Fireball
    public void fireball(Character target) {
        int cost = 15;
        if (!consumeEnergy(cost)) {
            System.out.println("Not enough energy to cast Fireball!");
            return;
        }

        int damage = (int) RandomUtil.range(attack * 1.25, attack * 1.55);
        int reduced = damage - target.getDefense();
        if (reduced < 0) reduced = 0;

        // Fireball
        System.out.println("🔥 You cast Fireball on " + target.getName() + " for " + reduced + " damage! (Energy: " + energy + "/" + maxEnergy + ")");
        target.takeDamage(reduced);
        arcaneFlow();
    }

    // Skill 2 - Ice Prison (Freeze not implemented)
    public void icePrison(Character target) {
        int cost = 20;
        if (!consumeEnergy(cost)) {
            System.out.println("Not enough energy to cast Ice Prison!");
            return;
        }

        int damage = (int) RandomUtil.range(attack * 0.60, attack * 0.90);
        int reduced = damage - target.getDefense();
        if (reduced < 0) reduced = 0;

        System.out.println("❄️ You cast Ice Prison on " + target.getName() + " for " + reduced + " damage! " + target.getName() + " is frozen! (Energy: " + energy + "/" + maxEnergy + ")");
        target.takeDamage(reduced);
        arcaneFlow();
        // TODO: Apply freeze for 1 turn
    }

    // Ultimate - Meteor Storm
    public void meteorStorm(Character target) {
        int cost = 40;
        if (!consumeEnergy(cost)) {
            System.out.println("Not enough energy to cast Meteor Storm!");
            return;
        }

        int damage = (int) RandomUtil.range(attack * 2.50 , attack * 3.50);
        int reduced = damage - target.getDefense();
        if (reduced < 0) reduced = 0;

        System.out.println("☄️ You call Meteor Storm on " + target.getName() + " for " + reduced + " damage! (Energy: " + energy + "/" + maxEnergy + ")");
        target.takeDamage(reduced);
        arcaneFlow();
    }

    @Override
    public void turn(Character target) {
        System.out.println("\n-- Your Turn --");

        System.out.println("(1) Skill 1  - Fireball");
        System.out.println("(2) Skill 2  - Ice Prison");
        System.out.println("(3) Ultimate - Meteor Storm");
        System.out.print("Choose your action: ");

        int choice = utils.InputUtil.scan.nextInt();
        System.out.println("---------------");

        switch (choice) {
            case 1 -> fireball(target);
            case 2 -> icePrison(target);
            case 3 -> meteorStorm(target);
            default -> System.out.println("❌ Invalid action! You missed your turn.");
        }
    }
}
