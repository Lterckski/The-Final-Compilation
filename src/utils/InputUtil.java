package utils;

import java.util.Scanner;

public class InputUtil {
    // Single Scanner instance for the entire project
    public static final Scanner scan = new Scanner(System.in);

    public static void pressEnterToContinue() {
        PrintUtil.pause(800);
        System.out.print("[Press ENTER to continue]");
        scan.nextLine();  // waits for user to press ENTER
    }

    public static int scanInput() {
        String input = scan.nextLine();
        try {
            // Split by whitespace; if more than one token, it's invalid
            String[] tokens = input.split("\\s+");
            if (tokens.length == 1) {
                return Integer.parseInt(tokens[0]);
            } else {
                return 99;
            }
        } catch (NumberFormatException e) {
            return 9;
        }
    }
}
