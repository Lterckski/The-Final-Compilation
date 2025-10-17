package enemies;

import characters.Character;

public abstract class Enemy extends Character{
    // Constructor
    public Enemy(String name, int hp, int defense, int attack) {
        super(name, hp, defense,attack);
    }

    // Show stats
    @Override
    public void showStats() {
        System.out.println("\n======== Enemy Stats ========");
        System.out.println("Name    : " + name);
        System.out.println("HP      : " + hp + "/" + maxHp);

        // Attack
        System.out.print("Attack  : " + baseAttack);
        if (attack > baseAttack) {
            System.out.print(" (+" + (attack - baseAttack) + ")");
        } else if (attack < baseAttack) {
            System.out.print(" (-" + (baseAttack - attack) + ")");
        }
        System.out.println();

        // Defense
        System.out.print("Defense : " + baseDefense);
        if (defense > baseDefense) {
            System.out.print(" (+" + (defense - baseDefense) + ")");
        } else if (defense < baseDefense) {
            System.out.print(" (-" + (baseDefense - defense) + ")");
        }
        System.out.println();

        System.out.println("=============================\n");
    }

    public abstract void dropLoot(Character player);

}
