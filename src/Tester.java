import characters.Kael;
import characters.Karl;
import characters.testEnemy;
public class Tester {
    public static void main(String[] args){
        Kael kael = new Kael();
        testEnemy enemy = new testEnemy();
        Karl karl = new Karl();

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
        karl.showStats();
        enemy.showStats();

        
        
        
       
        karl.piercingArrow(enemy);
        System.out.println();

        karl.bullsEye(enemy);
        System.out.println();

        karl.rainOfAThousandArrow(enemy);
        System.out.println();

        karl.showStats();
        enemy.showStats();

        System.out.println();
        karl.rainOfAThousandArrow(enemy);
        System.out.println();

        karl.showStats();
    }
}
