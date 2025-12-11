import battle.Battle;
import characters.*;
import characters.Character;
import enemies.*;
import events.MagicShop;
import events.PrefiEncounter;
import events.ReviveTrial;
import inventory.*;

import utils.ColorUtil;
import utils.InputUtil;
import utils.PrintUtil;
import worlds.World1;
import worlds.World3Final;

public class Tester {
    public static void main(String[] args) {

//      Kael kael = new Kael();
//        Karl karl = new Karl();
//       Simon simon = new Simon();
//       World1Enemy1 w1 = new World1Enemy1();
//        World1Enemy2 w2 = new World1Enemy2();
//
//        World1Miniboss1 enemy = new World1Miniboss1();
//        Null op = new Null();
//
//        w1.displayStats();
//        w2.displayStats();
//
//        kael.getInventory().openInventory();
//
//       /*
//       simon.displayStats();
//       kael.displayStats();
//       karl.displayStats();
//       op.displayStats();
//        */
//
//
//
//
//
//        Inventory inven = new Inventory(kael);
//        FinalBoss fb = new FinalBoss();
//
//
//
//
//
//        /*
//         kael.showStats();
//        kael.bladeRush(enemy);
//        System.out.println();
//        kael.guardBreaker(enemy);
//        System.out.println();
//        kael.eternalCrossSlash(enemy);
//        System.out.println();
//        kael.showStats();
//        enemy.showStats();
//         */
//        /*
//        karl.showStats();
//        karl.piercingArrow(enemy);
//        System.out.println();
//        karl.bullsEye(enemy);
//        System.out.println();
//        karl.rainOfAThousandArrows(enemy);
//        System.out.println();
//        karl.showStats();
//        enemy.showStats();
//         */
//        /*
//        simon.showStats();
//        simon.fireball(enemy);
//        System.out.println();
//        simon.icePrison(enemy);
//        System.out.println();
//        simon.meteorStorm(enemy);
//        simon.showStats();
//        enemy.showStats();
//        */
//        /*
//        Enemy1World1 mob = new Enemy1World1();
//        mob.showStats();
//        kael.showStats();
//        kael.bladeRush(mob);
//        System.out.println();
//        mob.savageHowl(kael);
//         */
//        /*
//        kael.showBackstory();
//        System.out.println();
//        kael.showSkills();
//        System.out.println();
//        karl.showBackstory();
//        System.out.println();
//        karl.showSkills();
//        System.out.println();
//        simon.showBackstory();
//        System.out.println();
//        simon.showSkills();
//        */


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

//
//        Enemy enemy1 = new World2Miniboss1();
//        Battle battle = new Battle(player,enemy1);
//        battle.startBattle();

        // --- Pre Final Encounter ---
        System.out.println();
        PrintUtil.effect("""
                As you advance deeper into the ruins, a cloaked figure materializes before you.
                
                "Before you face the Final Boss… prove your mastery of the pillars of OOP.
                Each question must be answered within time… and without error."
                
                Answer every question correctly to earn ONE legendary artifact.
                One mistake — and your trial ends immediately.
                """);

        PrintUtil.event("                                                                                                                    \n" +
                "                                                                                                                    \n" +
                "█████▄ █████▄  ██████         ██████ ██ ███  ██ ▄████▄ ██       █████▄ ▄████▄ ▄█████ ▄█████                         \n" +
                "██▄▄█▀ ██▄▄██▄ ██▄▄     ▄▄▄   ██▄▄   ██ ██ ▀▄██ ██▄▄██ ██       ██▄▄██ ██  ██ ▀▀▀▄▄▄ ▀▀▀▄▄▄                         \n" +
                "██     ██   ██ ██▄▄▄▄         ██     ██ ██   ██ ██  ██ ██████   ██▄▄█▀ ▀████▀ █████▀ █████▀                         \n" +
                "                                                                                                                    \n" +
                "                                                                                                                    \n" +
                "                                                                                                                    \n" +
                "█████▄  ▄████▄ ███  ██ ████▄  ▄████▄ ██▄  ▄██   ██████ ███  ██ ▄█████ ▄████▄ ██  ██ ███  ██ ██████ ██████ █████▄    \n" +
                "██▄▄██▄ ██▄▄██ ██ ▀▄██ ██  ██ ██  ██ ██ ▀▀ ██   ██▄▄   ██ ▀▄██ ██     ██  ██ ██  ██ ██ ▀▄██   ██   ██▄▄   ██▄▄██▄ ▀ \n" +
                "██   ██ ██  ██ ██   ██ ████▀  ▀████▀ ██    ██   ██▄▄▄▄ ██   ██ ▀█████ ▀████▀ ▀████▀ ██   ██   ██   ██▄▄▄▄ ██   ██ ▄ \n" +
                "                                                                                                                    ");

        PrintUtil.pause(1500);

        PrintUtil.event("                                                                                                                           \n" +
                "                                                                                                                           \n" +
                "▄█████ ██ █████▄    ██  ██ ▄████▄ ███  ██       ██████ ██  ██ ██████   ▄█████▄ ██  ██ ██████ █████▄  ██████ ███  ██ ██████ \n" +
                "▀▀▀▄▄▄ ██ ██▄▄██▄   ██▄▄██ ██  ██ ██ ▀▄██         ██   ██████ ██▄▄     ██ ▄ ██ ██  ██ ██▄▄   ██▄▄██▄ ██▄▄   ██ ▀▄██   ██   \n" +
                "█████▀ ██ ██   ██    ▀██▀  ▀████▀ ██   ██  ▄      ██   ██  ██ ██▄▄▄▄   ▀█████▀ ▀████▀ ██▄▄▄▄ ██   ██ ██▄▄▄▄ ██   ██   ██   \n" +
                "                                          ▀                                 ▀▀                                             ");

        PrintUtil.pause(1500);
        PrintUtil.objective("                                                          \n" +
                "                                                          \n" +
                "                        -*%@@@@@%=                        \n" +
                "                       +@@@%-=%@@@*.                      \n" +
                "                      :@@@@.   %@@@:                      \n" +
                "                              +@@@#.                      \n" +
                "                            +%@@@#.                       \n" +
                "                           %@@@#.                         \n" +
                "                          -@@@#                           \n" +
                "                                                          \n" +
                "                          -@@@%                           \n" +
                "                          :*##+                           \n" +
                "                                                          \n" +
                "                            @@                            \n" +
                "                           @@@@                           \n" +
                "                        .*%@@@@#-                         \n" +
                "                        *@@%%@%%#:                        \n" +
                "                       :#@@@@@@@%=                        \n" +
                "                       -@@@@@@@@@*.                       \n" +
                "                       +@@@@@@@@@%-                       \n" +
                "                      .#@@@@@@@@@@+                       \n" +
                "                      :@@@@@@@@@@@#.                      \n" +
                "                      =@@@@@@@@@@@@:                      \n" +
                "                      +@@@@@@@@@@@@=                      \n" +
                "                      *@@@@@@@@@@@@+                      \n" +
                "                      %@@@@@@@@@@@@#                      \n" +
                "                     .@@@@@@@@@@@@@%.                     \n" +
                "                     -@@@@@@@@@@@@@@:                     \n" +
                "                     +@@@@@@@@@@@@@@+                     \n" +
                "                   -*##%%%%%%######**+:                   \n" +
                "                                                          ");



        PrefiEncounter prefiEncounter = new PrefiEncounter();
        prefiEncounter.start(player);

        // --- Boss: the revelation ---
        System.out.println();
        System.out.println(ColorUtil.brightMagenta(
                "                 :*-                 \n" +
                        "                :%#+=                \n" +
                        "               :%@#+=-               \n" +
                        "              .%@@#+==+.             \n" +
                        "             :%%@@@%+==#.            \n" +
                        "            -@%%@@@@@#==%:           \n" +
                        "           =%%%@@@@@@@%=*@-          \n" +
                        "          +%%@@@@@@%###%%%%+         \n" +
                        "         *%#%%%%@@%%####%@#%+        \n" +
                        "        *%#@@@#%@@@@@@%%%@#*#+       \n" +
                        "      .*@@@@@@@@%%%@@@@@@@%**#+      \n" +
                        "     :*@@@@@@%@%#####%@@@@@%***=     \n" +
                        "    :#@@@%%%@@%%%%%%%%%@@@@@%***=    \n" +
                        "   :#@%%%%%@@@@@@@%%%%%%%@@@@@@#*=   \n" +
                        "   ++++***************************=  \n" +
                        "                                     \n" +
                        "                                     \n" +
                        "                                     "));
        PrintUtil.loot("At the summit, you see the Third Stone pulsing with violet light on an altar.");
        PrintUtil.pause(600);
        PrintUtil.loot("You reach out. The Stones unite—humming and pulling themselves closer together like a single heartbeat.");
        InputUtil.pressEnterToContinue();
        System.out.println();

        PrintUtil.effect("Then Khai the Gray steps forward, staff blazing.\n");
        PrintUtil.pause(800);
        PrintUtil.sayRed("Sir Khai", "\"Finally. \nYou’ve served well, my student. Who better to collect the stones of life than one who trusts their teacher?\"");
        PrintUtil.sayRed("Sir Khai", "\"I have guided you not to save this land—but to claim its power. \n" +
                "Because only the most skilled and pure can bring the stones together. I have been waiting for a student like you for a millenia. \n" +
                "I wish to bring chaos not only to this land, but also in the lands beyond. \n" +
                "The Necromancer you sought... The one who wants to bring chaos to all worlds... is ME!!!!!!!!!\"\n");

        PrintUtil.hr();


        World3Final finale = new World3Final();
        finale.run(player);

//
//        World1 world1 = new World1();
//        world1.run(player);

/*
        MagicShop magicShop = new MagicShop(player);



        enemy1.dropLoot(player);

        Enemy enemy2 = new World2Miniboss2();
//      Battle battle2 = new Battle(player, enemy2);
//      battle2.startBattle();

        enemy2.dropLoot(player);

        player.lootSoulShards(90);
        MagicShop shop = new MagicShop(player);
        shop.openShop();
*/
//        Enemy enemy3 = new FinalBoss();
//        Battle battle3 = new Battle(player, enemy3);
//
//        battle3.startBattle();
//
//
//       PrefiEncounter prefiEncounter = new PrefiEncounter();
//      prefiEncounter.start(player);


//        Enemy testEnemy1 = new World1Enemy1();
//        Battle testBattle1 = new Battle(player, testEnemy1);
//        testBattle1.startBattle();
//        testEnemy1.dropLoot(player);

//

////
////        World2 world2 = new World2();
////        world2.run(player);
////
////        World3 world3 = new World3();
////        world3.run(player);
//
//
//        Enemy testEnemy1 = new World1Enemy1();
//        Battle testBattle1 = new Battle(player, testEnemy1);
//
//        System.out.println();
//        PrintUtil.type(ColorUtil.boldBrightMagenta(("🎯 Objective: Defeat 3 Rotfang Wolves!\n").toUpperCase()));
//        testBattle1.startBattle();
//        testEnemy1.dropLoot(player);




    }
}
