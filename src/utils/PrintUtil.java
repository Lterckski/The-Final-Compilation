package utils;

public class PrintUtil {

    public static void hr() {
        System.out.println("=====================================");
    }

    public static void line() {
        System.out.println("-------------------------------------");
    }

    public static void shortLine() {
        System.out.println("------------------");
    }

    public static void title(String t) {
        hr();
        System.out.println(t.toUpperCase());
        System.out.println();
    }

    public static void loot(String text) {
        System.out.println("💎 " + text);
    }

    public static void say(String who, String line) {
        System.out.println(who + ": " + line);
    }


    public static void event(String text) {
        System.out.println("» " + text + "\n");
    }


    public static void effect(String text) {
        System.out.println("* " + text + "\n");
    }


    public static void type(String block) {
        System.out.println(block);
    }

    public static void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
