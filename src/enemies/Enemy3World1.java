package enemies;

public class Enemy3World1 extends Enemy {
    // Constructor
    public Enemy3World1() {
        super("Dreadbark Treants", 79, 7); // HP = 79, DEF = 7
    }

    // Skill: Root Snare (6–9 damage, immobilize 1 turn)
    public int rootSnare() {
        int dmg = rand.nextInt(4) + 6; // generates 6–9
        System.out.println(name + " used Root Snare! Deals " + dmg + " damage and may immobilize for 1 turn.");
        return dmg;
    }
}
