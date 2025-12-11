package utils;

import java.io.IOException;
import java.util.Scanner;

public class InputUtil {
    public static final Scanner scan = new Scanner(System.in);

    public static void pressEnterToContinue() {
        PrintUtil.pause(800);
        System.out.print(ColorUtil.brightGray("[Press ENTER to continue]"));
        try {
            scan.nextLine();
        } catch (Exception e) {
        }
    }

    public static int scanInput() {
        try {
            String input = scan.nextLine().trim();
            if (input.isEmpty() || input.split("\\s+").length > 1) {
                return 99;
            }
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return 99;
        }
    }

    public static Integer readWithTimeout(int seconds) {
        System.out.print(ColorUtil.cyan("Enter choice: "));

        long startTime = System.currentTimeMillis();
        long endTime = startTime + (seconds * 1000L);

        try {
            while (System.currentTimeMillis() < endTime) {
                if (System.in.available() > 0) {
                    String input = scan.nextLine().trim();
                    try {
                        return Integer.parseInt(input);
                    } catch (NumberFormatException e) {
                        System.out.println(ColorUtil.red("❌ Invalid input. Enter a number: "));
                        System.out.print(ColorUtil.cyan("Enter choice: "));
                    }
                }

                Thread.sleep(200);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(ColorUtil.boldBrightRed("\n⏱ TIME'S UP!"));
        return null;
    }

    public static void flushBuffer() {
        try {
            while (System.in.available() > 0) {
                scan.nextLine();
            }
        } catch (IOException e) {
        }
    }
}