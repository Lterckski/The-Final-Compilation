package utils;

import java.util.Scanner;

public class InputUtil {
    // Single Scanner instance for the entire project
    public static final Scanner scan = new Scanner(System.in);

    public static void pressEnterToContinue() {
        System.out.println("[Press ENTER to continue]");
        scan.nextLine();  // waits for user to press ENTER
    }
}
