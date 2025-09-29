package characters;

import utils.RandomUtil;

public class Simon extends  Character{

    public Simon() {
        super("Simon Versace", 60, 2, 150, 15);
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
        target.takeDamage(damage, target.getDefense());
        // Fireball
        System.out.println("🔥 You cast Fireball on " + target.getName() + " for " + damage + " dmg! (Energy: " + energy + "/" + maxEnergy + ")");
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
        target.takeDamage(damage, target.getDefense());
        System.out.println("❄️ You cast Ice Prison on " + target.getName() + " for " + damage + " dmg! " + target.getName() + " is frozen! (Energy: " + energy + "/" + maxEnergy + ")");
        arcaneFlow();
    }

    // Ultimate - Meteor Storm
    public void meteorStorm(Character target) {
        int cost = 40;
        if (!consumeEnergy(cost)) {
            System.out.println("Not enough energy to cast Meteor Storm!");
            return;
        }

        int damage = (int) RandomUtil.range(attack * 2.50 , attack * 3.50);
        target.takeDamage(damage, target.getDefense());
        System.out.println("☄️ You call Meteor Storm on " + target.getName() + " for " + damage + " dmg! (Energy: " + energy + "/" + maxEnergy + ")");
        arcaneFlow();
    }
}
