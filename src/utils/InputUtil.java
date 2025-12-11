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

        // 1. Create a separate thread to handle the input
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // 2. Define the task: Wait for input and parse it
        Future<Integer> result = executor.submit(() -> {
            try {
                // This line BLOCKS until the user types something
                String input = scan.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                return null; // Invalid number
            } catch (Exception e) {
                return null;
            }
        });

        try {
            // 3. Wait for the result for a maximum of 'seconds'
            return result.get(seconds, TimeUnit.SECONDS);

        } catch (TimeoutException e) {
            // 4. Handle the timeout
            System.out.println(ColorUtil.boldBrightRed("\n⏱ TIME'S UP!"));
            result.cancel(true); // Stop waiting for the input
            return null;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        } finally {
            // 5. Clean up the thread
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