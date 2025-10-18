package story;

public class ScenePrinter {

    public static void hr() {
        System.out.println("\n==============================\n");
    }

    public static void title(String t) {
        hr();
        System.out.println(t.toUpperCase());
        System.out.println();
    }

    public static void event(String text) {
        System.out.println("» " + text + "\n");
    }

    public static void loot(String text) {
        System.out.println("💎 " + text + "\n");
    }

    public static void type(String block) {

        System.out.println(block);
    }
}
