package utils;

import java.io.IOException;
import java.util.Scanner;

public class InputUtil {
    // Global Scanner object
    public static final Scanner scan = new Scanner(System.in);

    public static void pressEnterToContinue() {
        PrintUtil.pause(800);
        System.out.print(ColorUtil.brightGray("[Press ENTER to continue]"));
        try {
            scan.nextLine();
        } catch (Exception e) {
            // Ignored
        }
    }

    public static int scanInput() {
        try {
            // Check if there is actual input ready to be read to avoid blocking blindly
            // (Optional safety, but standard nextLine is fine here usually)
            String input = scan.nextLine().trim();
            if (input.isEmpty() || input.split("\\s+").length > 1) {
                return 99;
            }
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return 99;
        } catch (Exception e) {
            return 99;
        }
    }

    /**
     * Reads input with a timeout using a non-destructive polling loop.
     * This fixes the "IndexOutOfBoundsException" crash.
     */
    public static Integer readWithTimeout(int seconds) {
        System.out.print(ColorUtil.cyan("Enter choice: "));

        long startTime = System.currentTimeMillis();
        long timeoutMillis = seconds * 1000L;

        try {
            // Clear any old junk before starting the timer
            while (System.in.available() > 0) {
                scan.nextLine();
            }

            // Loop until time runs out
            while (System.currentTimeMillis() - startTime < timeoutMillis) {
                // System.in.available() returns > 0 only when the user has pressed ENTER
                if (System.in.available() > 0) {
                    String input = scan.nextLine().trim();
                    try {
                        return Integer.parseInt(input);
                    } catch (NumberFormatException e) {
                        return null; // Invalid number
                    }
                }
                // Small pause to save CPU power
                Thread.sleep(50);
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        // If loop finishes, time is up
        System.out.println(ColorUtil.boldBrightRed("\n⏱ TIME'S UP!"));
        return null;
    }

    public static void flushBuffer() {
        try {
            while (System.in.available() > 0) {
                scan.nextLine();
            }
        } catch (IOException e) {
            // Ignored
        }
    }
}