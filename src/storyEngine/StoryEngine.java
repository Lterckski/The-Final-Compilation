package storyEngine;

import characters.*;
import characters.Character;
import inventory.Armor;
import inventory.Bow;
import inventory.Staff;
import inventory.Sword;
import utils.ColorUtil;
import utils.InputUtil;
import utils.PrintUtil;
import worlds.*;

import java.awt.*;

public class StoryEngine {

    private Character player;
    private static StoryEngine instance;
    private static int currWorldLevel = 1;

    public static int getCurrWorldLevel(){ return currWorldLevel; }

    public void start() {
        intro();
        Character player = chooseCharacter();

        World1 w1 = new World1();
        w1.run(player);

        transitionToWorld2();
        World2 w2 = new World2();
        w2.run(player);

        transitionToWorld3();
        World3 w3 = new World3();
        w3.run(player);

        World3Final finale = new World3Final();
        finale.run(player);

        Epilogue end = new Epilogue();
        end.run(player);
    }


    public static void loginScreen() {
        PrintUtil.hr();
        System.out.println("🖥 CODECHUM LOGIN 🖥");
        System.out.print("👤 Username: ");
        String username = InputUtil.scan.nextLine();  // Use scanLine() for strings

        System.out.print("🔑 Password: ");
        String password = InputUtil.scan.nextLine();  // Not hiding password, but still works

        PrintUtil.pause(700);
        System.out.println("\nLogging in...");
        PrintUtil.pause(1200);

        // Add extra dramatic effect
        System.out.println("Screen flickers...");
        PrintUtil.pause(900);
        System.out.println("Everything goes silent.");
        PrintUtil.pause(800);
        PrintUtil.hr();

        // After logging in, continue with the story
    }

    // ✅ Quit Game with Confirmation
    public static void quitGame() {
        while (true) {  // Loop until valid confirmation
            System.out.println("\nTo confirm exit, type exactly:");
            System.out.println("\"OBJECT ORIENTED PROGRAMMING\"");
            System.out.println("Or type exactly \"CANCEL\" to return to the game.");
            System.out.print("Enter input: ");

            try {
                String input = InputUtil.scan.nextLine();

                if (input.equals("OBJECT ORIENTED PROGRAMMING")) {  // ✅ Exact match required
                    System.out.println("\n=================================");
                    System.out.println("  Thank you for playing!");
                    System.out.println("  Your journey ends here...");
                    System.out.println("=================================\n");
                    System.exit(0);   // terminate program safely
                }
                else if (input.equals("CANCEL")) {  // ✅ Exact match required
                    System.out.println("Returning to game...");
                    break;  // safely return to game
                }
                else {
                    System.out.println("❌ Invalid input. Please type the exact phrase or CANCEL.\n");
                }

            } catch (Exception e) {
                System.out.println("❌ Input error detected. Exit cancelled for safety.\n");
            }
        }
    }

    // ---------- Scenes ----------
    private void intro() {
        PrintUtil.pause(1000);
        System.out.println();
        System.out.println();
        System.out.println("░▀█▀░█░█░█▀▀░░░█▀▀░█░█░█▀█░█▄█░░░▀█▀░█░█░█▀█░▀█▀░░░█▀█░█▀▀░█░█░█▀▀░█▀▄░░░█▀▄░█▀▀░█▀▀░█▀█░█▀█\n" +
                "░░█░░█▀█░█▀▀░░░█▀▀░▄▀▄░█▀█░█░█░░░░█░░█▀█░█▀█░░█░░░░█░█░█▀▀░▀▄▀░█▀▀░█▀▄░░░█▀▄░█▀▀░█░█░█▀█░█░█\n" +
                "░░▀░░▀░▀░▀▀▀░░░▀▀▀░▀░▀░▀░▀░▀░▀░░░░▀░░▀░▀░▀░▀░░▀░░░░▀░▀░▀▀▀░░▀░░▀▀▀░▀░▀░░░▀▀░░▀▀▀░▀▀▀░▀░▀░▀░▀");

        System.out.println();
        System.out.println("======================================================================================================================="); //theres a little delay here because of type
        InputUtil.pressEnterToContinue();

        System.out.println();
        PrintUtil.type(
                """
                💡 The lab hums with fluorescent light. You sit before the CodeChum login screen, 
                nerves heavy but focus sharp.
                You place your hands on the keyboard... ⌨️
                """
        );
        PrintUtil.type(
                "                                                            \n" +
                        "                                                            \n" +
                        "        :@@@@@@@@@@@@@@@@@@@@@@@@@@@%                       \n" +
                        "        -%                         -@                       \n" +
                        "        -%                         -@   #@@@@@@@@@-         \n" +
                        "        -%                         -@   @#......:@+         \n" +
                        "        -%                         -@   @@@@@@@@@@+         \n" +
                        "        -%                         -@   @#......:@+         \n" +
                        "        -%                         -@   @@@@@@@@@@+         \n" +
                        "        -%                         :@   @@@@@@@@@@+         \n" +
                        "        -%                         -@   @@@@@@@@@@+         \n" +
                        "        -@@@@@@@@@@@@@@@@@@@@@@@@@@@@   @@@@@@@@@@+         \n" +
                        "         ...........#@@@@-..........    @@@@@@@@@@+         \n" +
                        "                 +%@@@@@@@@#-           @@@@%+@@@@+         \n" +
                        "                  .-==++=-:             @@@@#-@@@@+         \n" +
                        "         :@#%%%%%%%#@#@#@%@##@#%%%%*.   @@@@@@@@@@+         \n" +
                        "        =@++#*#*%+#+#+*+#+#+#*#*##+-@:  @@@@@@@@@@+         \n" +
                        "       =@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  .:::::::::          \n" +
                        "                                                            \n" +
                        "                                                             "
        );

        PrintUtil.pause(1000);
        loginScreen(); // << Player actually logs in here

        PrintUtil.pause(1000);
        PrintUtil.type("                                                                              \n" +
                "                                                                              \n" +
                "                                                                              \n" +
                "              .::==@@@@@@@@@@@@@@@@@@@@@@@@@@@%                               \n" +
                "           .**..+##++:                     =@@*:.                             \n" +
                "             +-.+%%@-                        .=**---*@@@@@@@=                 \n" +
                "               ..:=@%%-                      .=*#:-+%#....:@+ -*=             \n" +
                "        .%%+   .:%%-::                       :@=.:@@@@@@@@@%%:    :.          \n" +
                "             .:..##=.                       :#+.@%@#......+=:.**+.            \n" +
                "         .=+=.   ..%:                        .-*@##@@@@@@@@@+                 \n" +
                "                ###=..                       :#. .@@@%==#@@@+                 \n" +
                "         .===.     %@@                     ....@@:*%%%@@@@@@+                 \n" +
                "           =.    .:%@@@@@@@@@@@@@@@@@@@@@@@%***==.@@@@@@@@@@*.   .::          \n" +
                "             @@@-.............#@@@@-........... ..@@@@@@@@@@+  --.            \n" +
                "                          .+@@@@@@@@@#-        :+=%@@@@*@@@@@*                \n" +
                "                          =**#==++=-:        :++ :%@@@#:@@@@+  ::.            \n" +
                "                 =++@%%%%%%%%#%#@#@#@##@#%#%%@%# .=@@@@@@@@@%:  ::.           \n" +
                "           .#= ..+%@**#*#*%+#+#+*+#+#+#*#*%%#%==::##@@@@@@@@%.                \n" +
                "           .--:.-#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@**::::::::::.                 \n" +
                "                                                                              \n" +
                "                                                                              ");

        PrintUtil.type(
                """
                The moment you press "Log in," the monitor ripples like water... 🌊
                The screen glitches... ⚡
                And the world folds to black. 🕳️
                
                When you open your eyes, you're no longer in the lab. 👁️
                """
        );
        PrintUtil.pause(1000);

        System.out.println("=======================================================================================================================");
        InputUtil.pressEnterToContinue();

        PrintUtil.pause(1000);
        System.out.println();
        System.out.println(" █     █░▓█████  ██▓     ▄████▄   ▒█████   ███▄ ▄███▓▓█████    ▄▄▄█████▓ ▒█████  \n" +
                "▓█░ █ ░█░▓█   ▀ ▓██▒    ▒██▀ ▀█  ▒██▒  ██▒▓██▒▀█▀ ██▒▓█   ▀    ▓  ██▒ ▓▒▒██▒  ██▒\n" +
                "▒█░ █ ░█ ▒███   ▒██░    ▒▓█    ▄ ▒██░  ██▒▓██    ▓██░▒███      ▒ ▓██░ ▒░▒██░  ██▒\n" +
                "░█░ █ ░█ ▒▓█  ▄ ▒██░    ▒▓▓▄ ▄██▒▒██   ██░▒██    ▒██ ▒▓█  ▄    ░ ▓██▓ ░ ▒██   ██░\n" +
                "░░██▒██▓ ░▒████▒░██████▒▒ ▓███▀ ░░ ████▓▒░▒██▒   ░██▒░▒████▒     ▒██▒ ░ ░ ████▓▒░\n" +
                "░ ▓░▒ ▒  ░░ ▒░ ░░ ▒░▓  ░░ ░▒ ▒  ░░ ▒░▒░▒░ ░ ▒░   ░  ░░░ ▒░ ░     ▒ ░░   ░ ▒░▒░▒░ \n" +
                "  ▒ ░ ░   ░ ░  ░░ ░ ▒  ░  ░  ▒     ░ ▒ ▒░ ░  ░      ░ ░ ░  ░       ░      ░ ▒ ▒░ \n" +
                "  ░   ░     ░     ░ ░   ░        ░ ░ ░ ▒  ░      ░      ░        ░      ░ ░ ░ ▒  \n" +
                "    ░       ░  ░    ░  ░░ ░          ░ ░         ░      ░  ░                ░ ░  \n" +
                "                        ░                                                        ");
        PrintUtil.pause
                (1500);
        System.out.println("     \n" +
                "     \n" +
                " ██▓ \n" +
                " ▒▓▒ \n" +
                " ░▒  \n" +
                " ░   \n" +
                "  ░  \n" +
                "  ░  ");
        PrintUtil.pause(1000);
        System.out.println("     \n" +
                "     \n" +
                " ██▓ \n" +
                " ▒▓▒ \n" +
                " ░▒  \n" +
                " ░   \n" +
                "  ░  \n" +
                "  ░  ");
        PrintUtil.pause(1000);
        System.out.println("     \n" +
                "     \n" +
                " ██▓ \n" +
                " ▒▓▒ \n" +
                " ░▒  \n" +
                " ░   \n" +
                "  ░  \n" +
                "  ░  ");
        PrintUtil.pause(1000);
        System.out.println();
        System.out.println();
        System.out.println("▄▄▄█████▓ ██░ ██ ▓█████      █████▒██▓ ███▄    █  ▄▄▄       ██▓        ▄████▄   ▒█████   ███▄ ▄███▓ ██▓███   ██▓ ██▓    ▄▄▄     ▄▄▄█████▓ ██▓ ▒█████   ███▄    █ \n" +
                "▓  ██▒ ▓▒▓██░ ██▒▓█   ▀    ▓██   ▒▓██▒ ██ ▀█   █ ▒████▄    ▓██▒       ▒██▀ ▀█  ▒██▒  ██▒▓██▒▀█▀ ██▒▓██░  ██▒▓██▒▓██▒   ▒████▄   ▓  ██▒ ▓▒▓██▒▒██▒  ██▒ ██ ▀█   █ \n" +
                "▒ ▓██░ ▒░▒██▀▀██░▒███      ▒████ ░▒██▒▓██  ▀█ ██▒▒██  ▀█▄  ▒██░       ▒▓█    ▄ ▒██░  ██▒▓██    ▓██░▓██░ ██▓▒▒██▒▒██░   ▒██  ▀█▄ ▒ ▓██░ ▒░▒██▒▒██░  ██▒▓██  ▀█ ██▒\n" +
                "░ ▓██▓ ░ ░▓█ ░██ ▒▓█  ▄    ░▓█▒  ░░██░▓██▒  ▐▌██▒░██▄▄▄▄██ ▒██░       ▒▓▓▄ ▄██▒▒██   ██░▒██    ▒██ ▒██▄█▓▒ ▒░██░▒██░   ░██▄▄▄▄██░ ▓██▓ ░ ░██░▒██   ██░▓██▒  ▐▌██▒\n" +
                "  ▒██▒ ░ ░▓█▒░██▓░▒████▒   ░▒█░   ░██░▒██░   ▓██░ ▓█   ▓██▒░██████▒   ▒ ▓███▀ ░░ ████▓▒░▒██▒   ░██▒▒██▒ ░  ░░██░░██████▒▓█   ▓██▒ ▒██▒ ░ ░██░░ ████▓▒░▒██░   ▓██░\n" +
                "  ▒ ░░    ▒ ░░▒░▒░░ ▒░ ░    ▒ ░   ░▓  ░ ▒░   ▒ ▒  ▒▒   ▓▒█░░ ▒░▓  ░   ░ ░▒ ▒  ░░ ▒░▒░▒░ ░ ▒░   ░  ░▒▓▒░ ░  ░░▓  ░ ▒░▓  ░▒▒   ▓▒█░ ▒ ░░   ░▓  ░ ▒░▒░▒░ ░ ▒░   ▒ ▒ \n" +
                "    ░     ▒ ░▒░ ░ ░ ░  ░    ░      ▒ ░░ ░░   ░ ▒░  ▒   ▒▒ ░░ ░ ▒  ░     ░  ▒     ░ ▒ ▒░ ░  ░      ░░▒ ░      ▒ ░░ ░ ▒  ░ ▒   ▒▒ ░   ░     ▒ ░  ░ ▒ ▒░ ░ ░░   ░ ▒░\n" +
                "  ░       ░  ░░ ░   ░       ░ ░    ▒ ░   ░   ░ ░   ░   ▒     ░ ░      ░        ░ ░ ░ ▒  ░      ░   ░░        ▒ ░  ░ ░    ░   ▒    ░       ▒ ░░ ░ ░ ▒     ░   ░ ░ \n" +
                "          ░  ░  ░   ░  ░           ░           ░       ░  ░    ░  ░   ░ ░          ░ ░         ░             ░      ░  ░     ░  ░         ░      ░ ░           ░ \n" +
                "                                                                      ░                                                                                          ");
        System.out.println();
        PrintUtil.pause(2000);
    }

    private Character chooseCharacter() {
        Character player = null;

        do {
            PrintUtil.line();
            System.out.println("[1] ⚔\uFE0F Kael Saint Laurent (Swordsman)");
            System.out.println("[2] \uD83C\uDFF9 Karl Clover Dior IV (Archer)");
            System.out.println("[3] \uD83C\uDF1F Simon Versace (Mage)");
            System.out.println("[4] \uD83D\uDC68\u200D\uD83D\uDCBB Null (Test Mage)");
            PrintUtil.line();

            System.out.print("Select your character: ");
            int choice = InputUtil.scanInput();

            switch (choice) {
                case 1 -> {
                    Kael kael = new Kael();
                    if (characterMenu(kael)) {
                        player = kael;

                        System.out.println(ColorUtil.boldBrightCyan("┌────────────────────────────────────────────────────────────────┐"));
                        System.out.println(ColorUtil.boldBrightCyan("  ⚔️ You have chosen " + player.getName().toUpperCase() + ", the valiant Swordsman! "));
                        System.out.println(ColorUtil.boldBrightCyan("└────────────────────────────────────────────────────────────────┘"));

                        kael.showBackstory();
                        InputUtil.pressEnterToContinue();

                        System.out.println(ColorUtil.boldBrightMagenta("✨ The gods bestow upon you your starting gear..."));
                        player.getInventory().setEquippedWeapon(Sword.OLD_BROADSWORD);
                        player.getInventory().setEquippedArmor(Armor.LEATHER_GUARD);

                        System.out.println(ColorUtil.boldBrightYellow("🗡️ *The --" + player.getInventory().getEquippedWeapon().getName() + "-- rests firmly in your grasp, its blade marked by the scars of past battles.*"));
                        System.out.println(ColorUtil.boldBrightYellow("🛡️ *The --" + player.getInventory().getEquippedArmor().getName() + "-- fits perfectly, worn yet dependable — a true warrior’s first defense.*"));
                        System.out.println(ColorUtil.brightMagenta("⚡ Strength surges through your veins as your journey begins..."));
                        PrintUtil.line();
                        InputUtil.pressEnterToContinue();

                        PrintUtil.pause(1000);
                        System.out.println();
                        System.out.println("        ▄█   ▄█▄    ▄████████    ▄████████   ▄█            ");
                        System.out.println("       ███ ▄███▀   ███    ███   ███    ███  ███            ");
                        System.out.println("       ███▐██▀     ███    ███   ███    █▀   ███            ");
                        System.out.println("       ▄█████▀      ███    ███  ▄███▄▄▄     ███            ");
                        System.out.println("      ▀▀█████▄    ▀███████████ ▀▀███▀▀▀     ███            ");
                        System.out.println("       ███▐██▄     ███    ███   ███    █▄   ███            ");
                        System.out.println("       ███ ▀███▄   ███    ███   ███    ███  ███▌    ▄      ");
                        System.out.println("       ███   ▀█▀   ███    █▀    ██████████  █████▄▄██      ");
                        System.out.println("       ▀                                    ▀              ");


                        PrintUtil.pause(1000);
                        System.out.println("                                                          ");
                        System.out.println("                             .                            ");
                        System.out.println("     .                      *#@*:                         ");
                        System.out.println("      =*                  -%@#  =#                        ");
                        System.out.println("        =@=                #@@##*                         ");
                        System.out.println("           +%-           =@@@@@@@=                        ");
                        System.out.println("              +%=       :%@@@%%@@@@:                      ");
                        System.out.println("                -#*+# :%%+#@@@@@%@@@@@*=:                 ");
                        System.out.println("                   #*@*::*%@@@@@@@@@@@@@%#=               ");
                        System.out.println("                       ++-#@@%@@@@@@@@@@@@@@@@*:          ");
                        System.out.println("                        =%@@@%@@@@@@@@@@@@@@@@@@@%.       ");
                        System.out.println("                       #@@@@@@@@%%@@@@@@@@@@@@#=.:%+      ");
                        System.out.println("                      %@@@@@@@@@@@%@@@@@@@@@%##.          ");
                        System.out.println("                     =@@@@@@@@@@%@@@@@@@@@@@@.            ");
                        System.out.println("                      @@@@@@@@@@@@@@@@%%#@#:              ");
                        System.out.println("                      @#  =. %@-:+@@%@%    .:.            ");
                        System.out.println("                      @=        . +@=                     ");
                        System.out.println("                     *@=           :%                     ");
                        System.out.println("                .%@@@@@@%#*-        ##                    ");
                        System.out.println("                  #@@@@@@@@@@@@@@@@@@@@%                  ");
                        System.out.println("                 :*@@@@@@@@@@@@@@@@@@@@@@*                ");
                        System.out.println("                    :-==++*******++=-:.                   ");
                        System.out.println("                                                          ");
                        System.out.println();
                    }

                }
                case 2 -> {
                    Karl karl = new Karl();
                    if (characterMenu(karl)) {
                        player = karl;

                        System.out.println(ColorUtil.boldBrightCyan("┌──────────────────────────────────────────────────────────────────┐"));
                        System.out.println(ColorUtil.boldBrightCyan("  🏹 You have chosen " + player.getName() .toUpperCase()+ ", the sharp-eyed Archer! "));
                        System.out.println(ColorUtil.boldBrightCyan("└──────────────────────────────────────────────────────────────────┘"));

                        karl.showBackstory();
                        InputUtil.pressEnterToContinue();

                        System.out.println(ColorUtil.boldBrightMagenta("🌬️ The winds whisper and bless you with your starting equipment..."));
                        player.getInventory().setEquippedWeapon(Bow.WOODEN_BOW);
                        player.getInventory().setEquippedArmor(Armor.LEATHER_GUARD);

                        System.out.println(ColorUtil.boldBrightYellow("🏹 *The --" + player.getInventory().getEquippedWeapon().getName() + "-- hums softly as you draw the string — eager to strike true.*"));
                        System.out.println(ColorUtil.boldBrightYellow("🛡️ *The --" + player.getInventory().getEquippedArmor().getName() + "-- wraps around you lightly, offering freedom and silent agility.*"));
                        System.out.println(ColorUtil.boldBrightYellow("✨ *You are granted a --Magic Quiver--, filled with arrows that regenerate through ancient magic.*"));
                        System.out.println(ColorUtil.brightMagenta("🌿 The forest seems to watch over you as your path unfolds..."));
                        PrintUtil.line();
                        InputUtil.pressEnterToContinue();

                        PrintUtil.pause(1000);
                        System.out.println();
                        System.out.println("       ▄█   ▄█▄    ▄████████    ▄████████   ▄█            ");
                        System.out.println("      ███ ▄███▀   ███    ███   ███    ███  ███            ");
                        System.out.println("      ███▐██▀     ███    ███   ███    ███  ███            ");
                        System.out.println("     ▄█████▀      ███    ███  ▄███▄▄▄▄██▀  ███            ");
                        System.out.println("     ▀▀█████▄    ▀███████████ ▀▀███▀▀▀▀▀   ███            ");
                        System.out.println("       ███▐██▄     ███    ███ ▀███████████ ███            ");
                        System.out.println("       ███ ▀███▄   ███    ███   ███    ███ ███▌    ▄      ");
                        System.out.println("       ███   ▀█▀   ███    █▀    ███    ███ █████▄▄██      ");
                        System.out.println("       ▀                                   ▀              ");

                        PrintUtil.pause(1000);
                        System.out.println("                                 +                        ");
                        System.out.println("                                   +  -                   ");
                        System.out.println("                                      +- .:               ");
                        System.out.println("                      =-  *@@+      .  +- . .             ");
                        System.out.println("                      :-  #%#@:        +:    .            ");
                        System.out.println("                      .*%%@#%#*        .     .  .         ");
                        System.out.println("           :.:     .##%%%@%#*#%%@@@%#+-%*    ...          ");
                        System.out.println("            ::.       %@@@@%#%%=       .     :            ");
                        System.out.println("              .     +@@@@%%@@#%%:      ==    .            ");
                        System.out.println("                  +@@@@@@%%@@%#@*    . =-  .              ");
                        System.out.println("               -#@@@@@@@%%%%%###@+     -                  ");
                        System.out.println("             +%@@@@@@@@@%%%@@@%%#@#  .                    ");
                        System.out.println("           =%@@@@@@@@@@%@%%%@%#@%%@#*                     ");
                        System.out.println("          *#@@@@@@@@@@@%%@%@@%%%%#%@@%*                   ");
                        System.out.println("         +##@@@@@@@@@@%@@@%@@@%@@#%@@@@#-                 ");
                        System.out.println("         -#    #@@@@@%@@@@%@@@%@@@@@@@@@#+                ");
                        System.out.println("          -    #@@@@@%@@@%%@#%%@@@@@@@@%#*                ");
                        System.out.println("                -%@%=#@@@%%@@#%%@@@@@    *                ");
                        System.out.println("                     %#.=@@%%    %=                       ");
                        System.out.println("                    -%.          -%                       ");
                        System.out.println("                 :=+@@@@@@@@@@@@@@@@*+-                   ");
                        System.out.println("              =%@@@%%@@@@@@@@@@@@@@@%@@%#-                ");
                        System.out.println("                   .:=#%%%##%%%##*=:.                     ");
                        System.out.println();

                    }
                }
                case 3 -> {
                    Simon simon = new Simon();
                    if (characterMenu(simon)) {
                        player = simon;

                        System.out.println(ColorUtil.boldBrightCyan("┌───────────────────────────────────────────────────────────────┐"));
                        System.out.println(ColorUtil.boldBrightCyan("        🧙‍♂️ You have chosen " + player.getName().toUpperCase() + ", the wise Mage! "));
                        System.out.println(ColorUtil.boldBrightCyan("└───────────────────────────────────────────────────────────────┘"));

                        simon.showBackstory();
                        InputUtil.pressEnterToContinue();

                        System.out.println(ColorUtil.boldBrightMagenta("✨ The arcane forces converge to gift you ancient relics of power..."));
                        player.getInventory().setEquippedWeapon(Staff.WOODEN_STAFF);
                        player.getInventory().setEquippedArmor(Armor.LEATHER_GUARD);
                        System.out.println(ColorUtil.boldBrightYellow("🔮 *The --" + player.getInventory().getEquippedWeapon().getName() + "-- pulses faintly, whispering secrets of forgotten spells.*"));
                        System.out.println(ColorUtil.boldBrightYellow("🛡️ *The --" + player.getInventory().getEquippedArmor().getName() + "-- shimmers with faint runes — fragile, yet brimming with arcane energy.*"));
                        System.out.println(ColorUtil.brightMagenta("💫 Magic stirs in the air around you as your journey begins..."));
                        PrintUtil.line();
                        InputUtil.pressEnterToContinue();

                        PrintUtil.pause(1000);
                        System.out.println();
                        System.out.println("        ▄████████  ▄█    ▄▄▄▄███▄▄▄▄    ▄██████▄  ███▄▄▄▄    ");
                        System.out.println("       ███    ███ ███  ▄██▀▀▀███▀▀▀██▄ ███    ███ ███▀▀▀██▄  ");
                        System.out.println("       ███    █▀  ███▌ ███   ███   ███ ███    ███ ███   ███  ");
                        System.out.println("       ███        ███▌ ███   ███   ███ ███    ███ ███   ███  ");
                        System.out.println("      ▀███████████ ███▌ ███   ███   ███ ███    ███ ███   ███ ");
                        System.out.println("               ███ ███  ███   ███   ███ ███    ███ ███   ███ ");
                        System.out.println("        ▄█    ███ ███  ███   ███   ███ ███    ███ ███   ███  ");
                        System.out.println("      ▄████████▀  █▀    ▀█   ███   █▀   ▀██████▀   ▀█   █▀   ");

                        PrintUtil.pause(1000);
                        System.out.println("                         .                                ");
                        System.out.println("                          -@*                              ");
                        System.out.println("                           %@*                             ");
                        System.out.println("                         .*##+.                            ");
                        System.out.println("             :         =%@@%####=                          ");
                        System.out.println("         = @#=:          *%%@@*          .-                ");
                        System.out.println("          -*-+         :#%##@##*       .=.                ");
                        System.out.println("             +        *%%%+#%-@%%*.  .#%-                  ");
                        System.out.println("             ::      *####%%%%#%@@%%@++                    ");
                        System.out.println("              :     +#@@%@@@@@@%@#%@@#@.                   ");
                        System.out.println("               +=+%@@@@%%@@@@%%%@@%.:*%                    ");
                        System.out.println("               =##@@@%%%%#******#@@%                       ");
                        System.out.println("                -##@*@%#*#%#%*+%%@@@%                      ");
                        System.out.println("                 =+:.%#%@%%%@+@##%@@@@+                    ");
                        System.out.println("                  . *@%#@%@@@#%%%%@@@@@#:                  ");
                        System.out.println("                  - @@@%@@%@@@@@@@@@@@@@@#+-               ");
                        System.out.println("                   #@@%@@@#@@%@@@@@@@@@@@@@%#              ");
                        System.out.println("                    @@#@@@@*@@@@@@%%@@%@@@@@%@-            ");
                        System.out.println("                    @@#@@@@@#%@@%@@##@@@#%+..*@            ");
                        System.out.println("                    #@*@@@@@@#@@@@#%%=%@%@:   #            ");
                        System.out.println("                     =%@@@@@@@*@@@%#=@@-      :            ");
                        System.out.println("                      *@@@@@@@@%##@@@@@#+                  ");
                        System.out.println("                      @@@@@@@@@@@@@@@%%%:                  ");
                        System.out.println("                      #@*+#=.-##+ -@#                      ");
                        System.out.println("                 :=+####%@@@@@@@@@%%%##*+=-                ");
                        System.out.println();

                    }
                }
                case 4 -> {
                    Null test = new Null();
                    if (characterMenu(test)) {
                        player = test;
                        System.out.println(ColorUtil.boldBrightCyan("┌──────────────────────────────────────────────────────────────────┐"));
                        System.out.println(ColorUtil.boldBrightCyan("  🧙‍♂️ You have chosen " + player.getName().toUpperCase() + ", the Overpowered Test Mage! "));
                        System.out.println(ColorUtil.boldBrightCyan("└──────────────────────────────────────────────────────────────────┘"));

                        System.out.println(ColorUtil.brightRed("⚡ *This Test Mage is fully powered — ready to blaze through the game!*"));

                        System.out.println(ColorUtil.boldBrightMagenta("✨ The arcane forces converge to gift you ancient relics of power..."));
                        player.getInventory().setEquippedWeapon(Staff.WOODEN_STAFF);
                        player.getInventory().setEquippedArmor(Armor.LEATHER_GUARD);

                        System.out.println(ColorUtil.boldBrightYellow("🔮 *The --" + player.getInventory().getEquippedWeapon().getName() + "-- pulses faintly, whispering secrets of forgotten spells.*"));
                        System.out.println(ColorUtil.boldBrightYellow("🛡️ *The --" + player.getInventory().getEquippedArmor().getName() + "-- shimmers with faint runes — fragile, yet brimming with arcane energy.*"));
                        System.out.println(ColorUtil.brightMagenta("💫 *All spells are amplified, cooldowns are minimal — you are unstoppable!*"));
                        System.out.println(ColorUtil.brightRed("🌌 *Use this character to quickly test events, mechanics, or navigate the game world.*"));
                        PrintUtil.line();
                        InputUtil.pressEnterToContinue();

                        PrintUtil.pause(1000);
                        System.out.println("                     ███▄▄▄▄   ███    █▄   ▄█        ▄█       ");
                        System.out.println("                    ███▀▀▀██▄ ███    ███ ███       ███       ");
                        System.out.println("                    ███   ███ ███    ███ ███       ███       ");
                        System.out.println("                    ███   ███ ███    ███ ███       ███       ");
                        System.out.println("                    ███   ███ ███    ███ ███       ███       ");
                        System.out.println("                    ███   ███ ███    ███ ███       ███       ");
                        System.out.println("                    ███   ███ ███    ███ ███▌    ▄ ███▌    ▄ ");
                        System.out.println("                     ▀█   █▀  ████████▀  █████▄▄██ █████▄▄██ ");
                        System.out.println("                                 ▀         ▀          ");

                        PrintUtil.pause(1000);
                        PrintUtil.type("                                                                          \n" +
                                "                                                           \n" +
                                "                         .=:                             :-.            \n" +
                                "                         -@%%%#*+-.               .-+*##%%@-            \n" +
                                "                         -%**#####%**@%%%%##%%%%++###*###%@-            \n" +
                                "                         -@%%#####%**%#+=+*##%@@+*%####%%%@-            \n" +
                                "                 .%#-    -@%@%##%##**%%###%%#%%@++%%%%%%%%@-     .+%#.  \n" +
                                "                 :%%%%%*..+#%@@@%#%**%%%%@@@@#%%++%%%%@@%*+..+%%%%%%%:  \n" +
                                "                 :%%#=*#@*%%%%%%##+:-+=+%@@@@%==::+#%%##%%%*###*+##%%:  \n" +
                                "                 :%%#+*%@*%%#+*####+*##%@@@@@@%#++###%%##%%*%%###%%%%:  \n" +
                                "                 :%%%#*%%*%###%@@%%+*@@@@@@@@@@@%###%@@###%*%%%%%%%%%:  \n" +
                                "                 :%%#%%+#*%%%%%%@@#%@@@@@@@@@@@@@@%#@@#*##%*%%###*##%:  \n" +
                                "                  =+++***=#####*%@@@@#%@@@@@@@@%#@@@@#*####+*****+++=   \n" +
                                "                 .+*+=-::.......:%@#:.*@@@@@@@@=.-#@*......             \n" +
                                "                 :@@@@%#*##%@%*%%%#%##%@@@@@@@@##%@%%@%###%@-           \n" +
                                "                 :@@@@@@@%%%%@%%%%%%%%@@@@@@@@@@%@@@@@@@@%@@%.          \n" +
                                "                 :@@@@@@@@@@@@@@@@@%%%%@@@@@@@@@@@@@%%%@@@@@@#==-:.     \n" +
                                "                 :@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%=-----=%@@@@@@@@*-.    \n" +
                                "                 :@@@@@@@@@@@@=     :%@@@%:.#@@@@=     .%@@@@@@@#       \n" +
                                "                 :@@@@@@@@@@#:      *@@@#.   =@@@%.    .%@@@@@@%        \n" +
                                "                 :@@@@@@@@@*       :@@@*      -@@@+    .%@@@@@@.        \n" +
                                "                 :@@@@@@@@@+       #@@#.       +@@%    .%@@@@@+         \n" +
                                "                 :@@@@@@@@@+       @@@=        -@@@:   .%@@@@@+         \n" +
                                "                 :@@@@@@@@@+      -@@#.         *@@=   .%@@@%@+         \n" +
                                "                 :@@@@@@@@@*:     +@@*          =%@#   .%@@@@%+         \n" +
                                "                 :@@@@@@@@@@@*.   *@#:          .*@#   .%@%@%@%:        \n" +
                                "                 :@@@@@@@@%%%%%%%#@@%#*+*######%#%%@#*#####@@@#%.       \n" +
                                "              .:=*@@@@%@@@@%%%%%@@@##********#####%@@@##*#%%%#@@%%@%*+-:\n" +
                                "              @@@@@@@@%%@@@%%%#%%%%#**+++++***++*#%%%%#*####*#%%%%@@%@@@\n" +
                                "              @@@@@@@@@@@@@@@@@@@%%%#####**##%##%%%%%%%%%####%%%@@@%**@@\n" +
                                "              @@@@@@@@@@@@@@@@@@@@@@@@%%%%@%@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
                        System.out.print("\n");


                    }
                }
                default -> System.out.println("❌ Invalid choice! Please select a valid option.");
            }
        } while (player == null);

        InputUtil.pressEnterToContinue();
        return player;
    }

    private boolean characterMenu(Character character) {
        while (true) {
            PrintUtil.line();
            System.out.println("What would you like to do?");
            System.out.println("[1] \uD83E\uDDD1 Show Character Stats");
            System.out.println("[2] \uD83D\uDCD6 Show Character Skills");
            System.out.println("[3] ✅ Confirm Character");
            System.out.println("[0] \uD83D\uDD19 Back");

            System.out.print("Enter choice: ");
            int choice = InputUtil.scanInput();
            PrintUtil.line();

            switch (choice) {
                case 1 -> character.displayStats();
                case 2 -> character.displaySkills();
                case 3 -> { return true; }
                case 0 -> { return false; }
                default -> System.out.println(ColorUtil.boldBrightRed("❌ Invalid Input! Please select a valid option."));
            }
        }
    }

    private void transitionToWorld2() {
        currWorldLevel = 2;
        PrintUtil.type(
                "Sir Khai's staff strikes the ground. \"Two stones remain,\" he intones.\n" +
                        "A path opens through the ash—down into fog and distant thunder.\n"
        );
        System.out.println("[Checkpoint reached]\n");
    }


    private void transitionToWorld3() {
        currWorldLevel = 3;
        PrintUtil.type(
                "Sir Khai’s staff flares once more. The Second Stone trembles in your hand.\n" +
                        "Far off, lightning pierces a storm-swallowed horizon.\n" +
                        "He turns to you. \"The final trial awaits—where light cannot reach.\"\n"
        );
        System.out.println("[Checkpoint reached]\n");
    }
}