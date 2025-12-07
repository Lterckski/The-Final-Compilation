package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrintUtil {

    public static void pause(int milliseconds){
        try{
            Thread.sleep(milliseconds);
        } catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public static void hr() {
        System.out.println("═════════════════════════════════════");
    }

    public static void line() {
        System.out.println("─────────────────────────────────────");
    }

    public static void shortLine() {
        System.out.println("──────────────────");
    }

    public static void title(String t) {
        System.out.println(ColorUtil.boldBrightYellow(t));
    }

    public static void loot(String text) {
        pause(800);
        System.out.println(ColorUtil.boldBrightCyan("💎 " + text));
    }

    public static void event(String text) {
        pause(800);
        System.out.println(ColorUtil.boldBrightYellow(text));
    }

    public static void print(String block) {
        pause(800);
        System.out.println(block);
    }

    public static void enemyEncounter(String text){
        System.out.println(ColorUtil.boldBrightRed(text));
    }

    public static void enemyDefeated(String text){
        System.out.println(ColorUtil.boldBrightGreen(text.toUpperCase()));
    }

    public static void objective(String text) {
        System.out.println(ColorUtil.boldBrightMagenta(text.toUpperCase()));
    }

    public static void reward(String text) {
        System.out.println(ColorUtil.boldBrightYellow(text));
    }

    public static void victory(String text) {
        System.out.println(ColorUtil.boldBrightGreen(text));
    }

    public static void specialCyan(String text) {
        System.out.println(ColorUtil.boldBrightCyan(text));
    }

    public static void specialRed(String text) {
        System.out.println(ColorUtil.boldBrightCyan(text));
    }

    private static volatile boolean skip = false;

    public static void story(String text) {
        skip = false;
        String colored = ColorUtil.boldBrightWhite(text);

        Thread inputThread = new Thread(() -> {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                // Wait until user presses ENTER (line available)
                while (!br.ready()) {
                    Thread.sleep(30);
                }

                br.readLine(); // consume ENTER
                skip = true;

            } catch (Exception ignored) {}
        });

        inputThread.start();

        // Typewriter animation
        for (char c : colored.toCharArray()) {
            if (skip) {
                System.out.print(colored.substring(colored.indexOf(c))); // print remainder instantly
                System.out.println();
                return;
            }

            System.out.print(c);

            try {
                Thread.sleep(40);
            } catch (InterruptedException ignored) {}
        }

        pause(500);
        System.out.println();
    }

    public static void effect(String text) {
        skip = false;
        String colored = ColorUtil.boldBrightMagenta(text);

        Thread inputThread = new Thread(() -> {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                // Wait until user presses ENTER (line available)
                while (!br.ready()) {
                    Thread.sleep(30);
                }

                br.readLine(); // consume ENTER
                skip = true;

            } catch (Exception ignored) {}
        });

        inputThread.start();

        // Typewriter animation
        for (char c : colored.toCharArray()) {
            if (skip) {
                System.out.print(colored.substring(colored.indexOf(c))); // print remainder instantly
                System.out.println();
                return;
            }

            System.out.print(c);

            try {
                Thread.sleep(40);
            } catch (InterruptedException ignored) {}
        }

        pause(500);
        System.out.println();
    }

    public static void sayRed(String who, String line) {
        skip = false;
        String fullLine = ColorUtil.brightRed(who + ": " + line);

        pause(800); // initial pause before speaking

        Thread inputThread = new Thread(() -> {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                // Wait until user presses ENTER (line available)
                while (!br.ready()) {
                    Thread.sleep(30);
                }

                br.readLine(); // consume ENTER
                skip = true;

            } catch (Exception ignored) {
            }
        });

        inputThread.start();

        // Typewriter animation
        for (char c : fullLine.toCharArray()) {
            if (skip) {
                System.out.print(fullLine.substring(fullLine.indexOf(c))); // print remainder instantly
                System.out.println();
                return;
            }

            System.out.print(c);

            try {
                Thread.sleep(40);
            } catch (InterruptedException ignored) {
            }
        }

        System.out.println();
    }

    public static void sayCyan(String line) {
        skip = false;
        String fullLine = ColorUtil.brightCyan(line);

        pause(800); // initial pause before speaking

        Thread inputThread = new Thread(() -> {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                // Wait until user presses ENTER (line available)
                while (!br.ready()) {
                    Thread.sleep(30);
                }

                br.readLine(); // consume ENTER
                skip = true;

            } catch (Exception ignored) {
            }
        });

        inputThread.start();

        // Typewriter animation
        for (char c : fullLine.toCharArray()) {
            if (skip) {
                System.out.print(fullLine.substring(fullLine.indexOf(c))); // print remainder instantly
                System.out.println();
                return;
            }

            System.out.print(c);

            try {
                Thread.sleep(40);
            } catch (InterruptedException ignored) {
            }
        }

        System.out.println();
    }

}
