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
}
