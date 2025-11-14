package enemies;

import characters.Character;

public abstract class Enemy extends Character{
    // Constructor
    public Enemy(String name, int hp, int defense, int attack) {
        super(name, hp, defense,attack);
    }

    // Show stats
    @Override
    public void displayStats() {
        System.out.println("\n======== Enemy Stats ========");

        System.out.printf("%-8s: %s%n", "Name", name);
        System.out.printf("%-8s: %d/%d%n", "HP", hp, maxHP);

        // Attack difference
        int atkDiff = attack - baseAttack;
        String atkLabel = (atkDiff >= 0) ? "Buff" : "Debuff";

        System.out.printf("%-8s: %d  (Base %d | %s %+d)%n",
                "Attack", attack, baseAttack, atkLabel, atkDiff);

        // Defense difference
        int defDiff = defense - baseDefense;
        String defLabel = (defDiff >= 0) ? "Buff" : "Debuff";

        System.out.printf("%-8s: %d  (Base %d | %s %+d)%n",
                "Defense", defense, baseDefense, defLabel, defDiff);

        System.out.println("=============================\n");
    }


    public abstract void dropLoot(Character player);
    public abstract int rewardExp();

}
