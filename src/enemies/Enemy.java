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
        System.out.println("Defense : " + defense);
        System.out.println("Attack  : " + attack);
        System.out.println("=============================\n");
    }
}
