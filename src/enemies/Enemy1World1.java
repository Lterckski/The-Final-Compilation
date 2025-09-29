package enemies;

public class Enemy1World1 extends Enemy {
    // Constructor
    public Enemy1World1() {
        super("Rotfang Wolves", 60, 5); // HP = 60, DEF = 5
    }

    // Skill: Savage Howl (10–15 damage)
    public int savageHowl() {
        int dmg = rand.nextInt(6) + 10; // generates 10–15
        System.out.println(name + " used Savage Howl! Deals " + dmg + " damage.");
        return dmg;
    }
}
