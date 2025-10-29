package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtil {
    // Single Scanner instance for the entire project
    public static final Scanner scan = new Scanner(System.in);

    public static void pressEnterToContinue() {
        System.out.print("[Press ENTER to continue]");
        scan.nextLine();  // waits for user to press ENTER
    }

    public static int scanInput(){
        while (true) {
            try {
                return scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("❌ Invalid input! Please enter a number: ");
                InputUtil.scan.nextLine(); // clear invalid input
            }
        }
    }
}
