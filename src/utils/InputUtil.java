package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import static utils.PrintUtil.pause;

public class InputUtil {
    // Single Scanner instance for the entire project
    public static final Scanner scan = new Scanner(System.in);

    public static void pressEnterToContinue() {
        PrintUtil.pause(800);
        System.out.print(ColorUtil.brightGray("[Press ENTER to continue]"));

        scan.nextLine();
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
            return 99;
        }
    }

    // ---------------- TIMED INPUT ----------------
    public static Integer readWithTimeout(int seconds) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long endTime = System.currentTimeMillis() + seconds * 1000L;

        System.out.print(ColorUtil.cyan("Enter choice: "));

        try {
            while (System.currentTimeMillis() < endTime) {
                if (reader.ready()) {  // input is available
                    String line = reader.readLine().trim();
                    try {
                        return Integer.parseInt(line);
                    } catch (NumberFormatException e) {
                        System.out.print(ColorUtil.red("❌ Invalid input. Enter a number: "));
                    }
                }
                pause(50); // small delay to avoid CPU hog
            }

            return null;
        } catch (Exception e) {
            return null;
        }
    }

}
