package characters;

import utils.RandomUtil;

public class Simon extends  Character{
    private static final int ARCANE_FLOW_RESTORE = 5;

    public Simon() {
        super("Simon Versace", 60, 2, 150, 15);
    }

    private void arcaneFlow(int damage) {
        if (damage > 0) {
            energy = Math.min(maxEnergy, energy + ARCANE_FLOW_RESTORE);
            System.out.println(name + " restores " + ARCANE_FLOW_RESTORE + " energy from Arcane Flow! (Energy: " + energy + "/" + maxEnergy + ")");
        }
    }

    public void fireball(Character target) {
        int cost = 15;
        if (!consumeEnergy(cost)) {
            System.out.println("Insufficient energy to cast Fireball!");
            return;
        }

        int damage = RandomUtil.range(25, 35);
        target.takeDamage(damage, target.getDefense());
        System.out.println(name + " casts Fireball on " + target.getName() + " for " + damage + " damage! (Energy: " + energy + "/" + maxEnergy + ")");
        arcaneFlow(damage);
    }

    public void icePrison(Character target) {
        int cost = 20;
        if (!consumeEnergy(cost)) {
            System.out.println("Insufficient energy to cast Ice Prison!");
            return;
        }

        int damage = RandomUtil.range(10, 15);
        target.takeDamage(damage, target.getDefense());
        System.out.println(name + " casts Ice Prison on " + target.getName() + " for " + damage + " damage! " + target.getName() + " is frozen for 1 turn! (Energy: " + energy + "/" + maxEnergy + ")");
        arcaneFlow(damage);
    }

    public void meteorStorm(Character... targets) {
        int cost = 40;
        if (!consumeEnergy(cost)) {
            System.out.println("Insufficient energy to cast Meteor Storm!");
            return;
        }

        for (Character target : targets) {
            int damage = RandomUtil.range(40, 60);
            target.takeDamage(damage, target.getDefense());
            System.out.println(name + " calls down Meteor Storm on " + target.getName() + " for " + damage + " damage!");
            arcaneFlow(damage);
        }

        System.out.println("Meteor Storm finished! (Energy: " + energy + "/" + maxEnergy + ")");
    }
     @Override
    public void showSkills() {
        System.out.println("Simon — Skills");
        System.out.println(" • Fireball (burst single-target)");
        System.out.println(" • Ice Prison (control + damage)");
        System.out.println(" • Meteor Storm (AoE devastation)");
        System.out.println(" Passive: Arcane Flow (restore energy on successful casts)");
    }

   @Override
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
}
