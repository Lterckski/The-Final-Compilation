package utils;

public class ColorUtil {

    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";

    // Regular colors
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";
    private static final String WHITE = "\u001B[37m";
    private static final String GRAY = "\u001B[90m";

    // Bright colors
    private static final String BRIGHT_RED = "\u001B[91m";
    private static final String BRIGHT_GREEN = "\u001B[92m";
    private static final String BRIGHT_YELLOW = "\u001B[93m";
    private static final String BRIGHT_MAGENTA = "\u001B[95m";
    private static final String BRIGHT_CYAN = "\u001B[96m";
    private static final String BRIGHT_WHITE = "\u001B[97m";
    private static final String BRIGHT_GRAY = "\u001B[37m";

    // --- Methods for each color ---
    public static String red(String text) { return RED + text + RESET; }
    public static String green(String text) { return GREEN + text + RESET; }
    public static String yellow(String text) { return YELLOW + text + RESET; }
    public static String magenta(String text) { return MAGENTA + text + RESET; }
    public static String cyan(String text) { return CYAN + text + RESET; }
    public static String white(String text) { return WHITE + text + RESET; }
    public static String gray(String text) { return GRAY + text + RESET; }

    public static String brightRed(String text) { return BRIGHT_RED + text + RESET; }
    public static String brightGreen(String text) { return BRIGHT_GREEN + text + RESET; }
    public static String brightYellow(String text) { return BRIGHT_YELLOW + text + RESET; }
    public static String brightMagenta(String text) { return BRIGHT_MAGENTA + text + RESET; }
    public static String brightCyan(String text) { return BRIGHT_CYAN + text + RESET; }
    public static String brightWhite(String text) { return BRIGHT_WHITE + text + RESET; }
    public static String brightGray(String text) { return BRIGHT_GRAY + text + RESET; }

    // --- Bold methods for each color ---
    public static String boldRed(String text) { return BOLD + RED + text + RESET; }
    public static String boldGreen(String text) { return BOLD + GREEN + text + RESET; }
    public static String boldYellow(String text) { return BOLD + YELLOW + text + RESET; }
    public static String boldMagenta(String text) { return BOLD + MAGENTA + text + RESET; }
    public static String boldCyan(String text) { return BOLD + CYAN + text + RESET; }
    public static String boldWhite(String text) { return BOLD + WHITE + text + RESET; }
    public static String boldGray(String text) { return BOLD + GRAY + text + RESET; }

    public static String boldBrightRed(String text) { return BOLD + BRIGHT_RED + text + RESET; }
    public static String boldBrightGreen(String text) { return BOLD + BRIGHT_GREEN + text + RESET; }
    public static String boldBrightYellow(String text) { return BOLD + BRIGHT_YELLOW + text + RESET; }
    public static String boldBrightMagenta(String text) { return BOLD + BRIGHT_MAGENTA + text + RESET; }
    public static String boldBrightCyan(String text) { return BOLD + BRIGHT_CYAN + text + RESET; }
    public static String boldBrightWhite(String text) { return BOLD + BRIGHT_WHITE + text + RESET; }
    public static String boldBrightGray(String text) { return BOLD + BRIGHT_GRAY + text + RESET; }
}
