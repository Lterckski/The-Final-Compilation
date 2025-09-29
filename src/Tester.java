import characters.Kael;
import characters.Karl;
import characters.Simon;
import characters.testEnemy;
import enemies.Enemy1World1;

public class Tester {
    public static void main(String[] args){
        Kael kael = new Kael();
        Karl karl = new Karl();
        Simon simon = new Simon();
        testEnemy enemy = new testEnemy();

        //enemy.showStats();

        /*
         kael.showStats();
        kael.bladeRush(enemy);
        System.out.println();
        kael.guardBreaker(enemy);
        System.out.println();
        kael.eternalCrossSlash(enemy);
        System.out.println();
        kael.showStats();
        enemy.showStats();
         */

        /*
        karl.showStats();
        karl.piercingArrow(enemy);
        System.out.println();
        karl.bullsEye(enemy);
        System.out.println();
        karl.rainOfAThousandArrows(enemy);
        System.out.println();
        karl.showStats();
        enemy.showStats();
         */

        /*
        simon.showStats();
        simon.fireball(enemy);
        System.out.println();
        simon.icePrison(enemy);
        System.out.println();
        simon.meteorStorm(enemy);
        simon.showStats();
        enemy.showStats();
        */

        Enemy1World1 mob = new Enemy1World1();
        mob.showStats();
        kael.showStats();
        kael.bladeRush(mob);
        System.out.println();
        mob.savageHowl(kael);

    }
}
