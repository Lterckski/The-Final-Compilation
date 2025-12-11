package utils;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.*;

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

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Integer> result = executor.submit(() -> {
            try {
                StringBuilder sb = new StringBuilder();

                long start = System.currentTimeMillis();
                while (true) {

                    if (System.currentTimeMillis() - start > seconds * 1000) {
                        return null;
                    }

                    if (System.in.available() > 0) {
                        char c = (char) System.in.read();
                        if (c == '\n') break;
                        sb.append(c);
                    }
                }

                return Integer.parseInt(sb.toString().trim());
            } catch (Exception e) {
                return null;
            }
        });

        try {
            return result.get(seconds + 1, TimeUnit.SECONDS);
        } catch (Exception e) {
            result.cancel(true);
            return null;
        } finally {
            executor.shutdownNow();
        }
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