package enemies;

public class Enemy4World1 extends Enemy {
    // Constructor
    public Enemy4World1() {
        super("Carrion Bats", 91, 8); // HP = 91, DEF = 8
    }

    // Skill: Screech (6–8 damage, chance to confuse 1 turn)
    public int screech() {
        int dmg = rand.nextInt(3) + 6; // generates 6–8
        System.out.println(name + " used Screech! Deals " + dmg + " damage and may confuse for 1 turn.");
        return dmg;
    }
}
