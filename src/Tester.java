import battle.Battle;
import characters.*;
import characters.Character;
import enemies.Enemy1World1;
import utils.InputUtil;

public class Tester {
    public static void main(String[] args) {
        /*
        Kael kael = new Kael();
        Karl karl = new Karl();
        Simon simon = new Simon();
        testEnemy enemy = new testEnemy();
        */
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
        /*
        Enemy1World1 mob = new Enemy1World1();
        mob.showStats();
        kael.showStats();
        kael.bladeRush(mob);
        System.out.println();
        mob.savageHowl(kael);
         */
        /*
        kael.showBackstory();
        System.out.println();
        kael.showSkills();
        System.out.println();
        karl.showBackstory();
        System.out.println();
        karl.showSkills();
        System.out.println();
        simon.showBackstory();
        System.out.println();
        simon.showSkills();
        */

        System.out.println("Welcome to The Final Compilation");

        System.out.println("-------------------------------------");
        System.out.println("1 - Kael Saint Laurent (Swordsman)");
        System.out.println("2 - Karl Clover Dior IV (Archer)");
        System.out.println("3 - Simon Versace (Mage)");
        System.out.println("4 - Test Character (ambot)");
        System.out.println("-------------------------------------");

        int choice;
        Character player = null;

        do {
            System.out.print("Select you character: ");
            choice = InputUtil.scan.nextInt();

            switch (choice) {
                case 1 -> {
                    player = new Kael();
                    System.out.println("You selected " + player.getName() + "!");
                    ((Kael) player).showBackstory();
                }
                case 2 -> {
                    player = new Karl();
                    System.out.println("You selected " + player.getName() + "!");
                    ((Karl) player).showBackstory();
                }
                case 3 -> {
                    player = new Simon();
                    System.out.println("You selected " + player.getName() + "!");
                    ((Simon) player).showBackstory();
                }
                case 4-> {
                    player = new TestCharacter();
                    System.out.println("You selected " + player.getName() + "!");
                }
                default -> System.out.println("❌ Invalid choice! Please select a valid option.");
            }
        } while (player == null);  // repeat until valid choice

        System.out.println("-------------------------------------");

        Character enemy1 = new Enemy1World1();
        Battle battle1 = new Battle(player, enemy1);

        System.out.println("ENEMY ENCOUNTERED!");
        battle1.startBattle();

        Character enemy2 = new Enemy1World1();
        Battle battle2 = new Battle(player, enemy2);

        System.out.println("ENEMY ENCOUNTERED!");
        battle2.startBattle();
    }
}
