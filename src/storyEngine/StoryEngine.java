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

        System.exit(0);
    }


    public static void loginScreen() {
        PrintUtil.hr();
        PrintUtil.specialCyan("🖥 CODECHUM LOGIN 🖥");
        String username = "";
        while (username.isBlank()) {
            System.out.print("👤 Username: ");
            username = InputUtil.scan.nextLine();

            if (username.isBlank()) {
                System.out.println(ColorUtil.boldBrightRed("❌ Username cannot be empty!"));
            }
        }

        String password = "";
        while (password.isBlank()) {
            System.out.print("🔑 Password: ");
            password = InputUtil.scan.nextLine();

            if (password.isBlank()) {
                System.out.println(ColorUtil.boldBrightRed("❌ Password cannot be empty!"));
            }
        }

        PrintUtil.pause(700);
        PrintUtil.story("\nLogging in...");
        PrintUtil.pause(1200);

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
                    System.out.println();
                    System.out.println("═════════════════════════════════");
                    System.out.println("     Thank you for playing!");
                    System.out.println("    Your journey ends here...");
                    System.out.println("═════════════════════════════════");
                    System.out.println();
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
        PrintUtil.title("╔═══════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println();
        PrintUtil.title("      ░▀█▀░█░█░█▀▀░░░█▀▀░█░█░█▀█░█▄█░░░▀█▀░█░█░█▀█░▀█▀░░░█▀█░█▀▀░█░█░█▀▀░█▀▄░░░█▀▄░█▀▀░█▀▀░█▀█░█▀█\n" +
                           "      ░░█░░█▀█░█▀▀░░░█▀▀░▄▀▄░█▀█░█░█░░░░█░░█▀█░█▀█░░█░░░░█░█░█▀▀░▀▄▀░█▀▀░█▀▄░░░█▀▄░█▀▀░█░█░█▀█░█░█\n" +
                           "      ░░▀░░▀░▀░▀▀▀░░░▀▀▀░▀░▀░▀░▀░▀░▀░░░░▀░░▀░▀░▀░▀░░▀░░░░▀░▀░▀▀▀░░▀░░▀▀▀░▀░▀░░░▀▀░░▀▀▀░▀▀▀░▀░▀░▀░▀");

        System.out.println();
        PrintUtil.title("╚═══════════════════════════════════════════════════════════════════════════════════════════════════════╝");
        InputUtil.pressEnterToContinue();

        System.out.println();
        PrintUtil.story(
                """
                💡 It's just another tuesday, you come in for your java examination. You walk in,
                and Professor Khai greets you warmly as you sit before the CodeChum login screen, 
                nerves heavy now knowing if you're ready but focus remains sharp.
                You place your hands on the keyboard and login... L10X17W.... ⌨️
                """
        );
        PrintUtil.specialCyan(
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

        int start = -1;
        while (start != 1) {
            // ASCII box with centered title
            System.out.println();
            PrintUtil.specialCyan("╔═════════════════════════════════════════════════╗");
            PrintUtil.specialCyan("           OOP1 Final Exam Batch 1 - G1       ");
            PrintUtil.specialCyan("     0 / 100                        01:00:00     ");
            PrintUtil.specialCyan("  Overall Score                Activity closes in");
            PrintUtil.specialCyan("╚═════════════════════════════════════════════════╝");
            System.out.println();

            System.out.println("Enter " + ColorUtil.boldBrightGreen("1") + " to START the exam");
            System.out.println("Enter 0 to cancel");
            System.out.print("START : ");

            start = InputUtil.scanInput();

            if (start == 0) {
                System.out.println();
                PrintUtil.story("You back out. The exam screen fades away...");
                PrintUtil.pause(800);
                System.exit(0);
            }

            if (start != 1) {
                System.out.println(ColorUtil.boldBrightRed("❌ Invalid choice! Please enter 1 to start."));
            }
        }

        System.out.println();
        PrintUtil.pause(1500);
        PrintUtil.story("Screen flickers...");
        PrintUtil.pause(900);
        PrintUtil.story("Everything goes silent.");
        PrintUtil.pause(800);
        PrintUtil.hr();

        PrintUtil.pause(1000);
        PrintUtil.specialCyan("                                                                              \n" +
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

        PrintUtil.story(
                """
                The moment you press "Start", the monitor ripples like water... 🌊
                The screen glitches... ⚡
                And the world turns to black as the room seems to wrap around you. 🕳️
                
                When come to your senses, you're no longer in the lab. You wake up in an unfamiliar place.👁️
                """
        );

        PrintUtil.pause(2000);
        System.out.println();
        PrintUtil.title(" █     █░▓█████  ██▓     ▄████▄   ▒█████   ███▄ ▄███▓▓█████    ▄▄▄█████▓ ▒█████  \n" +
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
        PrintUtil.title("     \n" +
                "     \n" +
                " ██▓ \n" +
                " ▒▓▒ \n" +
                " ░▒  \n" +
                " ░   \n" +
                "  ░  \n" +
                "  ░  ");
        PrintUtil.pause(1000);
        PrintUtil.title("     \n" +
                "     \n" +
                " ██▓ \n" +
                " ▒▓▒ \n" +
                " ░▒  \n" +
                " ░   \n" +
                "  ░  \n" +
                "  ░  ");
        PrintUtil.pause(1000);
        PrintUtil.title("     \n" +
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
        PrintUtil.title("▄▄▄█████▓ ██░ ██ ▓█████      █████▒██▓ ███▄    █  ▄▄▄       ██▓        ▄████▄   ▒█████   ███▄ ▄███▓ ██▓███   ██▓ ██▓    ▄▄▄     ▄▄▄█████▓ ██▓ ▒█████   ███▄    █ \n" +
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
            PrintUtil.specialCyan("[1] ⚔\uFE0F Kael Saint Laurent (Swordsman)");
            PrintUtil.specialCyan("[2] \uD83C\uDFF9 Karl Clover Dior IV (Archer)");
            PrintUtil.specialCyan("[3] \uD83C\uDF1F Simon Versace (Mage)");
            PrintUtil.specialCyan("[4] \uD83D\uDC68\u200D\uD83D\uDCBB Null (Test Mage)");
            PrintUtil.line();

            System.out.print("Select your character: ");
            int choice = InputUtil.scanInput();

            switch (choice) {
                case 1 -> {
                    Kael kael = new Kael();
                    if (characterMenu(kael)) {
                        player = kael;

                        System.out.println();
                        System.out.println(ColorUtil.boldBrightCyan("┌────────────────────────────────────────────────────────────────┐"));
                        System.out.println(ColorUtil.boldBrightCyan("  ⚔️ You have chosen " + player.getName().toUpperCase() + ", the valiant Swordsman! "));
                        System.out.println(ColorUtil.boldBrightCyan("└────────────────────────────────────────────────────────────────┘"));

                        PrintUtil.pause(1000);
                        System.out.println();
                        PrintUtil.specialCyan("        ▄█   ▄█▄    ▄████████    ▄████████   ▄█            ");
                        PrintUtil.specialCyan("       ███ ▄███▀   ███    ███   ███    ███  ███            ");
                        PrintUtil.specialCyan("       ███▐██▀     ███    ███   ███    █▀   ███            ");
                        PrintUtil.specialCyan("       ▄█████▀      ███    ███  ▄███▄▄▄     ███            ");
                        PrintUtil.specialCyan("      ▀▀█████▄    ▀███████████ ▀▀███▀▀▀     ███            ");
                        PrintUtil.specialCyan("       ███▐██▄     ███    ███   ███    █▄   ███            ");
                        PrintUtil.specialCyan("       ███ ▀███▄   ███    ███   ███    ███  ███▌    ▄      ");
                        PrintUtil.specialCyan("       ███   ▀█▀   ███    █▀    ██████████  █████▄▄██      ");
                        PrintUtil.specialCyan("       ▀                                    ▀              ");


                        PrintUtil.pause(1000);
                        PrintUtil.specialCyan("                                                          ");
                        PrintUtil.specialCyan("                             .                            ");
                        PrintUtil.specialCyan("     .                      *#@*:                         ");
                        PrintUtil.specialCyan("      =*                  -%@#  =#                        ");
                        PrintUtil.specialCyan("        =@=                #@@##*                         ");
                        PrintUtil.specialCyan("           +%-           =@@@@@@@=                        ");
                        PrintUtil.specialCyan("              +%=       :%@@@%%@@@@:                      ");
                        PrintUtil.specialCyan("                -#*+# :%%+#@@@@@%@@@@@*=:                 ");
                        PrintUtil.specialCyan("                   #*@*::*%@@@@@@@@@@@@@%#=               ");
                        PrintUtil.specialCyan("                       ++-#@@%@@@@@@@@@@@@@@@@*:          ");
                        PrintUtil.specialCyan("                        =%@@@%@@@@@@@@@@@@@@@@@@@%.       ");
                        PrintUtil.specialCyan("                       #@@@@@@@@%%@@@@@@@@@@@@#=.:%+      ");
                        PrintUtil.specialCyan("                      %@@@@@@@@@@@%@@@@@@@@@%##.          ");
                        PrintUtil.specialCyan("                     =@@@@@@@@@@%@@@@@@@@@@@@.            ");
                        PrintUtil.specialCyan("                      @@@@@@@@@@@@@@@@%%#@#:              ");
                        PrintUtil.specialCyan("                      @#  =. %@-:+@@%@%    .:.            ");
                        PrintUtil.specialCyan("                      @=        . +@=                     ");
                        PrintUtil.specialCyan("                     *@=           :%                     ");
                        PrintUtil.specialCyan("                .%@@@@@@%#*-        ##                    ");
                        PrintUtil.specialCyan("                  #@@@@@@@@@@@@@@@@@@@@%                  ");
                        PrintUtil.specialCyan("                 :*@@@@@@@@@@@@@@@@@@@@@@*                ");
                        PrintUtil.specialCyan("                    :-==++*******++=-:.                   ");
                        System.out.println();
                        PrintUtil.pause(1500);

                        kael.showBackstory();
                        InputUtil.pressEnterToContinue();

                        PrintUtil.line();
                        PrintUtil.effect("✨ The gods bestow upon you your starting gear...");
                        PrintUtil.pause(800);
                        player.getInventory().setEquippedWeapon(Sword.OLD_BROADSWORD);
                        player.getInventory().setEquippedArmor(Armor.LEATHER_GUARD);

                        System.out.println(ColorUtil.boldBrightYellow("🗡️ *The --" + player.getInventory().getEquippedWeapon().getName() + "-- rests firmly in your grasp, its blade marked by the scars of past battles.*"));
                        PrintUtil.pause(800);
                        System.out.println(ColorUtil.boldBrightYellow("🛡️ *The --" + player.getInventory().getEquippedArmor().getName() + "-- fits perfectly, worn yet dependable — a true warrior’s first defense.*"));
                        PrintUtil.pause(800);
                        PrintUtil.effect("⚡ Strength surges through your veins as your journey begins...");
                        PrintUtil.line();
                    }

                }
                case 2 -> {
                    Karl karl = new Karl();
                    if (characterMenu(karl)) {
                        player = karl;

                        System.out.println();
                        System.out.println(ColorUtil.boldBrightCyan("┌──────────────────────────────────────────────────────────────────┐"));
                        System.out.println(ColorUtil.boldBrightCyan("  🏹 You have chosen " + player.getName() .toUpperCase()+ ", the sharp-eyed Archer! "));
                        System.out.println(ColorUtil.boldBrightCyan("└──────────────────────────────────────────────────────────────────┘"));

                        PrintUtil.pause(1000);
                        System.out.println();
                        PrintUtil.specialCyan("          ▄█   ▄█▄    ▄████████    ▄████████   ▄█            ");
                        PrintUtil.specialCyan("         ███ ▄███▀   ███    ███   ███    ███  ███            ");
                        PrintUtil.specialCyan("         ███▐██▀     ███    ███   ███    ███  ███            ");
                        PrintUtil.specialCyan("        ▄█████▀      ███    ███  ▄███▄▄▄▄██▀  ███            ");
                        PrintUtil.specialCyan("        ▀▀█████▄    ▀███████████ ▀▀███▀▀▀▀▀   ███            ");
                        PrintUtil.specialCyan("          ███▐██▄     ███    ███ ▀███████████ ███            ");
                        PrintUtil.specialCyan("          ███ ▀███▄   ███    ███   ███    ███ ███▌    ▄      ");
                        PrintUtil.specialCyan("          ███   ▀█▀   ███    █▀    ███    ███ █████▄▄██      ");
                        PrintUtil.specialCyan("          ▀                                   ▀              ");

                        PrintUtil.pause(1000);
                        PrintUtil.specialCyan("                                    +                        ");
                        PrintUtil.specialCyan("                                      +  -                   ");
                        PrintUtil.specialCyan("                                         +- .:               ");
                        PrintUtil.specialCyan("                         =-  *@@+      .  +- . .             ");
                        PrintUtil.specialCyan("                         :-  #%#@:        +:    .            ");
                        PrintUtil.specialCyan("                         .*%%@#%#*        .     .  .         ");
                        PrintUtil.specialCyan("              :.:     .##%%%@%#*#%%@@@%#+-%*    ...          ");
                        PrintUtil.specialCyan("               ::.       %@@@@%#%%=       .     :            ");
                        PrintUtil.specialCyan("                 .     +@@@@%%@@#%%:      ==    .            ");
                        PrintUtil.specialCyan("                     +@@@@@@%%@@%#@*    . =-  .              ");
                        PrintUtil.specialCyan("                  -#@@@@@@@%%%%%###@+     -                  ");
                        PrintUtil.specialCyan("                +%@@@@@@@@@%%%@@@%%#@#  .                    ");
                        PrintUtil.specialCyan("              =%@@@@@@@@@@%@%%%@%#@%%@#*                     ");
                        PrintUtil.specialCyan("             *#@@@@@@@@@@@%%@%@@%%%%#%@@%*                   ");
                        PrintUtil.specialCyan("            +##@@@@@@@@@@%@@@%@@@%@@#%@@@@#-                 ");
                        PrintUtil.specialCyan("            -#    #@@@@@%@@@@%@@@%@@@@@@@@@#+                ");
                        PrintUtil.specialCyan("             -    #@@@@@%@@@%%@#%%@@@@@@@@%#*                ");
                        PrintUtil.specialCyan("                   -%@%=#@@@%%@@#%%@@@@@    *                ");
                        PrintUtil.specialCyan("                        %#.=@@%%    %=                       ");
                        PrintUtil.specialCyan("                       -%.          -%                       ");
                        PrintUtil.specialCyan("                    :=+@@@@@@@@@@@@@@@@*+-                   ");
                        PrintUtil.specialCyan("                 =%@@@%%@@@@@@@@@@@@@@@%@@%#-                ");
                        PrintUtil.specialCyan("                      .:=#%%%##%%%##*=:.                     ");
                        System.out.println();
                        PrintUtil.pause(1500);

                        karl.showBackstory();
                        InputUtil.pressEnterToContinue();

                        PrintUtil.line();
                        PrintUtil.effect("🌬️ The winds whisper and bless you with your starting equipment...");
                        PrintUtil.pause(800);
                        player.getInventory().setEquippedWeapon(Bow.WOODEN_BOW);
                        player.getInventory().setEquippedArmor(Armor.LEATHER_GUARD);

                        System.out.println(ColorUtil.boldBrightYellow("🏹 *The --" + player.getInventory().getEquippedWeapon().getName() + "-- hums softly as you draw the string — eager to strike true.*"));
                        PrintUtil.pause(800);
                        System.out.println(ColorUtil.boldBrightYellow("🛡️ *The --" + player.getInventory().getEquippedArmor().getName() + "-- wraps around you lightly, offering freedom and silent agility.*"));
                        PrintUtil.pause(800);
                        System.out.println(ColorUtil.boldBrightYellow("✨ *You are granted a --Magic Quiver--, filled with arrows that regenerate through ancient magic.*"));
                        PrintUtil.pause(800);
                        PrintUtil.effect("🌿 The forest seems to watch over you as your path unfolds...");
                        PrintUtil.line();
                    }
                }
                case 3 -> {
                    Simon simon = new Simon();
                    if (characterMenu(simon)) {
                        player = simon;

                        System.out.println();
                        System.out.println(ColorUtil.boldBrightCyan("┌───────────────────────────────────────────────────────────────┐"));
                        System.out.println(ColorUtil.boldBrightCyan("        🧙‍♂️ You have chosen " + player.getName().toUpperCase() + ", the wise Mage! "));
                        System.out.println(ColorUtil.boldBrightCyan("└───────────────────────────────────────────────────────────────┘"));

                        PrintUtil.pause(1000);
                        System.out.println();
                        PrintUtil.specialCyan("        ▄████████  ▄█    ▄▄▄▄███▄▄▄▄    ▄██████▄  ███▄▄▄▄    ");
                        PrintUtil.specialCyan("       ███    ███ ███  ▄██▀▀▀███▀▀▀██▄ ███    ███ ███▀▀▀██▄  ");
                        PrintUtil.specialCyan("       ███    █▀  ███▌ ███   ███   ███ ███    ███ ███   ███  ");
                        PrintUtil.specialCyan("       ███        ███▌ ███   ███   ███ ███    ███ ███   ███  ");
                        PrintUtil.specialCyan("      ▀███████████ ███▌ ███   ███   ███ ███    ███ ███   ███ ");
                        PrintUtil.specialCyan("               ███ ███  ███   ███   ███ ███    ███ ███   ███ ");
                        PrintUtil.specialCyan("        ▄█    ███ ███  ███   ███   ███ ███    ███ ███   ███  ");
                        PrintUtil.specialCyan("      ▄████████▀  █▀    ▀█   ███   █▀   ▀██████▀   ▀█   █▀   ");

                        PrintUtil.pause(1000);
                        PrintUtil.specialCyan("\n                         .                                ");
                        PrintUtil.specialCyan("                          -@*                              ");
                        PrintUtil.specialCyan("                           %@*                             ");
                        PrintUtil.specialCyan("                         .*##+.                            ");
                        PrintUtil.specialCyan("             :         =%@@%####=                          ");
                        PrintUtil.specialCyan("         = @#=:          *%%@@*          .-                ");
                        PrintUtil.specialCyan("          -*-+         :#%##@##*       .=.                ");
                        PrintUtil.specialCyan("             +        *%%%+#%-@%%*.  .#%-                  ");
                        PrintUtil.specialCyan("             ::      *####%%%%#%@@%%@++                    ");
                        PrintUtil.specialCyan("              :     +#@@%@@@@@@%@#%@@#@.                   ");
                        PrintUtil.specialCyan("               +=+%@@@@%%@@@@%%%@@%.:*%                    ");
                        PrintUtil.specialCyan("               =##@@@%%%%#******#@@%                       ");
                        PrintUtil.specialCyan("                -##@*@%#*#%#%*+%%@@@%                      ");
                        PrintUtil.specialCyan("                 =+:.%#%@%%%@+@##%@@@@+                    ");
                        PrintUtil.specialCyan("                  . *@%#@%@@@#%%%%@@@@@#:                  ");
                        PrintUtil.specialCyan("                  - @@@%@@%@@@@@@@@@@@@@@#+-               ");
                        PrintUtil.specialCyan("                   #@@%@@@#@@%@@@@@@@@@@@@@%#              ");
                        PrintUtil.specialCyan("                    @@#@@@@*@@@@@@%%@@%@@@@@%@-            ");
                        PrintUtil.specialCyan("                    @@#@@@@@#%@@%@@##@@@#%+..*@            ");
                        PrintUtil.specialCyan("                    #@*@@@@@@#@@@@#%%=%@%@:   #            ");
                        PrintUtil.specialCyan("                     =%@@@@@@@*@@@%#=@@-      :            ");
                        PrintUtil.specialCyan("                      *@@@@@@@@%##@@@@@#+                  ");
                        PrintUtil.specialCyan("                      @@@@@@@@@@@@@@@%%%:                  ");
                        PrintUtil.specialCyan("                      #@*+#=.-##+ -@#                      ");
                        PrintUtil.specialCyan("                 :=+####%@@@@@@@@@%%%##*+=-                ");
                        System.out.println();
                        PrintUtil.pause(1500);

                        simon.showBackstory();
                        InputUtil.pressEnterToContinue();

                        PrintUtil.line();
                        PrintUtil.effect("✨ The arcane forces converge to gift you ancient relics of power...");
                        PrintUtil.pause(800);
                        player.getInventory().setEquippedWeapon(Staff.WOODEN_STAFF);
                        player.getInventory().setEquippedArmor(Armor.LEATHER_GUARD);
                        System.out.println(ColorUtil.boldBrightYellow("🔮 *The --" + player.getInventory().getEquippedWeapon().getName() + "-- pulses faintly, whispering secrets of forgotten spells.*"));
                        PrintUtil.pause(800);
                        System.out.println(ColorUtil.boldBrightYellow("🛡️ *The --" + player.getInventory().getEquippedArmor().getName() + "-- shimmers with faint runes — fragile, yet brimming with arcane energy.*"));
                        PrintUtil.pause(800);
                        PrintUtil.effect("💫 Magic stirs in the air around you as your journey begins...");
                        PrintUtil.line();
                    }
                }
                case 4 -> {
                    Null test = new Null();
                    if (characterMenu(test)) {
                        player = test;

                        System.out.println();
                        System.out.println(ColorUtil.boldBrightCyan("┌──────────────────────────────────────────────────────────────────┐"));
                        System.out.println(ColorUtil.boldBrightCyan("       🧙‍♂️ You have chosen " + player.getName().toUpperCase() + ", the Overpowered Test Mage! "));
                        System.out.println(ColorUtil.boldBrightCyan("└──────────────────────────────────────────────────────────────────┘"));
                        System.out.println();

                        PrintUtil.pause(1000);
                        PrintUtil.specialCyan("                 ███▄▄▄▄   ███    █▄   ▄█        ▄█       ");
                        PrintUtil.specialCyan("                ███▀▀▀██▄ ███    ███ ███       ███       ");
                        PrintUtil.specialCyan("                ███   ███ ███    ███ ███       ███       ");
                        PrintUtil.specialCyan("                ███   ███ ███    ███ ███       ███       ");
                        PrintUtil.specialCyan("                ███   ███ ███    ███ ███       ███       ");
                        PrintUtil.specialCyan("                ███   ███ ███    ███ ███       ███       ");
                        PrintUtil.specialCyan("                ███   ███ ███    ███ ███▌    ▄ ███▌    ▄ ");
                        PrintUtil.specialCyan("                 ▀█   █▀  ████████▀  █████▄▄██ █████▄▄██ ");
                        PrintUtil.specialCyan("                             ▀         ▀          ");

                        PrintUtil.pause(1000);
                        PrintUtil.specialCyan("                                                                          \n" +
                                "                                                           \n" +
                                "                   .=:                             :-.            \n" +
                                "                   -@%%%#*+-.               .-+*##%%@-            \n" +
                                "                   -%**#####%**@%%%%##%%%%++###*###%@-            \n" +
                                "                   -@%%#####%**%#+=+*##%@@+*%####%%%@-            \n" +
                                "           .%#-    -@%@%##%##**%%###%%#%%@++%%%%%%%%@-     .+%#.  \n" +
                                "           :%%%%%*..+#%@@@%#%**%%%%@@@@#%%++%%%%@@%*+..+%%%%%%%:  \n" +
                                "           :%%#=*#@*%%%%%%##+:-+=+%@@@@%==::+#%%##%%%*###*+##%%:  \n" +
                                "           :%%#+*%@*%%#+*####+*##%@@@@@@%#++###%%##%%*%%###%%%%:  \n" +
                                "           :%%%#*%%*%###%@@%%+*@@@@@@@@@@@%###%@@###%*%%%%%%%%%:  \n" +
                                "           :%%#%%+#*%%%%%%@@#%@@@@@@@@@@@@@@%#@@#*##%*%%###*##%:  \n" +
                                "            =+++***=#####*%@@@@#%@@@@@@@@%#@@@@#*####+*****+++=   \n" +
                                "           .+*+=-::.......:%@#:.*@@@@@@@@=.-#@*......             \n" +
                                "           :@@@@%#*##%@%*%%%#%##%@@@@@@@@##%@%%@%###%@-           \n" +
                                "           :@@@@@@@%%%%@%%%%%%%%@@@@@@@@@@%@@@@@@@@%@@%.          \n" +
                                "           :@@@@@@@@@@@@@@@@@%%%%@@@@@@@@@@@@@%%%@@@@@@#==-:.     \n" +
                                "           :@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%=-----=%@@@@@@@@*-.    \n" +
                                "           :@@@@@@@@@@@@=     :%@@@%:.#@@@@=     .%@@@@@@@#       \n" +
                                "           :@@@@@@@@@@#:      *@@@#.   =@@@%.    .%@@@@@@%        \n" +
                                "           :@@@@@@@@@*       :@@@*      -@@@+    .%@@@@@@.        \n" +
                                "           :@@@@@@@@@+       #@@#.       +@@%    .%@@@@@+         \n" +
                                "           :@@@@@@@@@+       @@@=        -@@@:   .%@@@@@+         \n" +
                                "           :@@@@@@@@@+      -@@#.         *@@=   .%@@@%@+         \n" +
                                "           :@@@@@@@@@*:     +@@*          =%@#   .%@@@@%+         \n" +
                                "           :@@@@@@@@@@@*.   *@#:          .*@#   .%@%@%@%:        \n" +
                                "           :@@@@@@@@%%%%%%%#@@%#*+*######%#%%@#*#####@@@#%.       \n" +
                                "        .:=*@@@@%@@@@%%%%%@@@##********#####%@@@##*#%%%#@@%%@%*+-:\n" +
                                "        @@@@@@@@%%@@@%%%#%%%%#**+++++***++*#%%%%#*####*#%%%%@@%@@@\n" +
                                "        @@@@@@@@@@@@@@@@@@@%%%#####**##%##%%%%%%%%%####%%%@@@%**@@\n" +
                                "        @@@@@@@@@@@@@@@@@@@@@@@@%%%%@%@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
                        System.out.println();
                        PrintUtil.pause(1500);

                        PrintUtil.line();
                        System.out.println(ColorUtil.brightRed("⚡ *This Test Mage is fully powered — ready to blaze through the game!*"));
                        PrintUtil.pause(600);

                        PrintUtil.effect("✨ The arcane forces converge to gift you ancient relics of power...");
                        PrintUtil.pause(600);
                        player.getInventory().setEquippedWeapon(Staff.WOODEN_STAFF);
                        player.getInventory().setEquippedArmor(Armor.LEATHER_GUARD);

                        System.out.println(ColorUtil.boldBrightYellow("🔮 *The --" + player.getInventory().getEquippedWeapon().getName() + "-- pulses faintly, whispering secrets of forgotten spells.*"));
                        PrintUtil.pause(600);
                        System.out.println(ColorUtil.boldBrightYellow("🛡️ *The --" + player.getInventory().getEquippedArmor().getName() + "-- shimmers with faint runes — fragile, yet brimming with arcane energy.*"));
                        PrintUtil.pause(600);
                        System.out.println(ColorUtil.brightMagenta("💫 *All spells are amplified, cooldowns are minimal — you are unstoppable!*"));
                        PrintUtil.pause(600);
                        PrintUtil.effect("🌌 *Use this character to quickly test events, mechanics, or navigate the game world.*");
                        PrintUtil.line();
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
        System.out.println();

        PrintUtil.story("""
            Sir Khai's staff strikes the scorched earth. The forest around you shudders—its colors slowly returning.
            The corruption fades, leaving behind faint sparks of life glowing in the air.
            A path begins to part through the settling ash, leading into a wall of fog and distant thunder.
            """);

        PrintUtil.sayGreen("""
            "This forest is saved. Life is beautiful," Sir Khai murmurs.
            "But our journey is far from over. Two more Stones remain… and darkness gathers ahead."
            """);

        InputUtil.pressEnterToContinue();
    }



    private void transitionToWorld3() {
        currWorldLevel = 3;
        System.out.println();

        PrintUtil.story("""
            Sir Khai’s staff ignites with a silver flame as the Second Stone vibrates in your grasp.
            Thunder rumbles across a storm-choked horizon, where the sky seems to twist unnaturally.
            The air grows colder—heavier—as if something ancient is waking beneath the clouds.
            """);

        PrintUtil.sayGreen("""
            "The final trial awaits," Khai says quietly.
            "Beyond that storm lies a realm where even light cannot survive… and where the last Stone is kept."
            """);

        InputUtil.pressEnterToContinue();
    }

}