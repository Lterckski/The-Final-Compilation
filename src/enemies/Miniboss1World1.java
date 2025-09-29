package enemies;

public class Miniboss1World1 extends Enemy {
    // Constructor
    public Miniboss1World1() {
        super("The Hollow Stag", 211, 13); // HP = 211, DEF = 13
    }

    // Skill 1: Deathly Charge (47–56 damage, stun 1 turn)
    public int deathlyCharge() {
        int dmg = rand.nextInt(10) + 47; // generates 47–56
        System.out.println(name + " used Deathly Charge! Deals " + dmg + " damage and may stun for 1 turn.");
        return dmg;
    }

    // Skill 2: Blackened Howl (reduces target DEF by 20% for 2 turns)
    public void blackenedHowl(Enemy target) {
        double reduction = target.getDefense() * 0.2;
        int reducedDef = target.getDefense() - (int) reduction;
        System.out.println(name + " used Blackened Howl! " + target.getName() +
                           "'s DEF reduced from " + target.getDefense() + " to " + reducedDef + " for 2 turns.");
        target.defense = reducedDef; // temporarily reduce DEF
    }
}
