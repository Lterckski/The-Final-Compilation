import battle.Battle;
import characters.*;
import characters.Character;
import enemies.*;

import inventory.Armor;
import inventory.Staff;
import inventory.Sword;
import inventory.Bow;
import utils.InputUtil;
import utils.PrintUtil;

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
        PrintUtil.pause(1000);

        System.out.println("-------------------------------------");
        System.out.println("1 - Kael Saint Laurent (Swordsman)");
        System.out.println("2 - Karl Clover Dior IV (Archer)");
        System.out.println("3 - Simon Versace (Mage)");
        System.out.println("4 - Null (Test)");
        System.out.println("-------------------------------------");

        int choice;
        Character player = null;

        do {
            System.out.print("Select your character: ");
            choice = InputUtil.scanInput();

            switch (choice) {
                case 1 -> {
                    player = new Kael();
                    System.out.println("You selected " + player.getName() + "!");
                    ((Kael) player).showBackstory();
                    player.getInventory().setEquippedWeapon(Sword.OLD_BROADSWORD);
                }
                case 2 -> {
                    player = new Karl();
                    System.out.println("You selected " + player.getName() + "!");
                    ((Karl) player).showBackstory();
                    player.getInventory().setEquippedWeapon(Bow.WOODEN_BOW);
                }
                case 3 -> {
                    player = new Simon();
                    System.out.println("You selected " + player.getName() + "!");
                    ((Simon) player).showBackstory();
                    player.getInventory().setEquippedWeapon(Staff.WOODEN_STAFF);
                }
                case 4 -> {
                    player = new Null();
                    System.out.println("You selected " + player.getName() + "!");
                    player.getInventory().setEquippedWeapon(Staff.WOODEN_STAFF);
                }
                default -> System.out.println("❌ Invalid input! Please select a valid option.");
            }
        } while (player == null);  // repeat until valid choice
        player.getInventory().setEquippedArmor(Armor.LEATHER_GUARD);

        Enemy testEnemy1 = new World3Miniboss1();
        Battle testBattle1 = new Battle(player, testEnemy1);
        testBattle1.startBattle();
        testEnemy1.dropLoot(player);

        Enemy testEnemy2 = new World2Miniboss2();
        Battle testBattle2 = new Battle(player, testEnemy2);
        testBattle2.startBattle();
        testEnemy2.dropLoot(player);


    }
}
