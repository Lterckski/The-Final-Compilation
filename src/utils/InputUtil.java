package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputUtil {
    // BufferedReader is thread-safe for checking .ready(), unlike Scanner
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void pressEnterToContinue() {
        PrintUtil.pause(800);
        System.out.print(ColorUtil.brightGray("[Press ENTER to continue]"));
        try {
            reader.readLine();
        } catch (Exception e) {
        }
    }

    public static int scanInput() {
        try {
            String input = reader.readLine();
            if (input == null) return 99;

            input = input.trim();
            if (input.isEmpty() || input.split("\\s+").length > 1) {
                return 99;
            }
            return Integer.parseInt(input);
        } catch (Exception e) {
            return 99;
        }
    }

    // This method replaces the thread-killing logic with a safe loop
    public static Integer readWithTimeout(int seconds) {
        System.out.print(ColorUtil.cyan("Enter choice: "));

        long startTime = System.currentTimeMillis();
        long timeoutMillis = seconds * 1000L;

        try {
            while (System.currentTimeMillis() - startTime < timeoutMillis) {
                // check if input is waiting WITHOUT pausing the code
                if (reader.ready()) {
                    String input = reader.readLine();
                    try {
                        return Integer.parseInt(input.trim());
                    } catch (NumberFormatException e) {
                        return null;
                    }
                }
                // wait 50ms before checking again to save CPU
                Thread.sleep(50);
            }
        } catch (Exception e) {
            return null;
        }

        System.out.println(ColorUtil.boldBrightRed("\n⏱ TIME'S UP!"));
        return null;
    }
}