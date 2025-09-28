import characters.Kael;
import characters.Karl;
import characters.Simon;
import characters.testEnemy;

public class Tester {
    public static void main(String[] args){
        Kael kael = new Kael();
        testEnemy enemy = new testEnemy();

        kael.showStats();
        enemy.showStats();

        kael.bladeRush(enemy);
        System.out.println();
        kael.guardBreaker(enemy);
        System.out.println();
        kael.eternalCrossSlash(enemy);
        System.out.println();

        kael.showStats();
        enemy.showStats();

        System.out.println();
        kael.eternalCrossSlash(enemy);
        System.out.println();

        kael.showStats();
    }
}
