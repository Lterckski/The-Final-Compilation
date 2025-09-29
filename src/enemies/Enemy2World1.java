package enemies;

public class Enemy2World1 extends Enemy {
    // Constructor
    public Enemy2World1() {
        super("Shade Sprites", 69, 6); // HP = 69, DEF = 6
    }

    // Skill: Trickster Strike (8–13 damage)
    public int tricksterStrike() {
        int dmg = rand.nextInt(6) + 8; // generates 8–13
        System.out.println(name + " used Trickster Strike! Deals " + dmg + " damage.");
        return dmg;
    }
}
