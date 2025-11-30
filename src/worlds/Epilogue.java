package worlds;

import characters.Character;
import utils.InputUtil;
import utils.PrintUtil;

public class Epilogue {

    public void run(Character player) {
        PrintUtil.title("▓█████  ██▓███   ██▓ ██▓     ▒█████    ▄████  █    ██ ▓█████ \n" +
                "▓█   ▀ ▓██░  ██▒▓██▒▓██▒    ▒██▒  ██▒ ██▒ ▀█▒ ██  ▓██▒▓█   ▀ \n" +
                "▒███   ▓██░ ██▓▒▒██▒▒██░    ▒██░  ██▒▒██░▄▄▄░▓██  ▒██░▒███   \n" +
                "▒▓█  ▄ ▒██▄█▓▒ ▒░██░▒██░    ▒██   ██░░▓█  ██▓▓▓█  ░██░▒▓█  ▄ \n" +
                "░▒████▒▒██▒ ░  ░░██░░██████▒░ ████▓▒░░▒▓███▀▒▒▒█████▓ ░▒████▒\n" +
                "░░ ▒░ ░▒▓▒░ ░  ░░▓  ░ ▒░▓  ░░ ▒░▒░▒░  ░▒   ▒ ░▒▓▒ ▒ ▒ ░░ ▒░ ░\n" +
                " ░ ░  ░░▒ ░      ▒ ░░ ░ ▒  ░  ░ ▒ ▒░   ░   ░ ░░▒░ ░ ░  ░ ░  ░\n" +
                "   ░   ░░        ▒ ░  ░ ░   ░ ░ ░ ▒  ░ ░   ░  ░░░ ░ ░    ░   \n" +
                "   ░  ░          ░      ░  ░    ░ ░        ░    ░        ░  ░\n" +
                "                                                             ");

        System.out.println();
        PrintUtil.pause(1500);
        System.out.println("▄▄▄█████▓ ██░ ██ ▓█████    ▓█████ ▒██   ██▒ ▄▄▄       ███▄ ▄███▓  ██████    ▄▄▄█████▓ ██▀███   █    ██ ▓█████     ▄████▄   ▒█████    ██████ ▄▄▄█████▓\n" +
                "▓  ██▒ ▓▒▓██░ ██▒▓█   ▀    ▓█   ▀ ▒▒ █ █ ▒░▒████▄    ▓██▒▀█▀ ██▒▒██    ▒    ▓  ██▒ ▓▒▓██ ▒ ██▒ ██  ▓██▒▓█   ▀    ▒██▀ ▀█  ▒██▒  ██▒▒██    ▒ ▓  ██▒ ▓▒\n" +
                "▒ ▓██░ ▒░▒██▀▀██░▒███      ▒███   ░░  █   ░▒██  ▀█▄  ▓██    ▓██░░ ▓██▄      ▒ ▓██░ ▒░▓██ ░▄█ ▒▓██  ▒██░▒███      ▒▓█    ▄ ▒██░  ██▒░ ▓██▄   ▒ ▓██░ ▒░\n" +
                "░ ▓██▓ ░ ░▓█ ░██ ▒▓█  ▄    ▒▓█  ▄  ░ █ █ ▒ ░██▄▄▄▄██ ▒██    ▒██   ▒   ██▒   ░ ▓██▓ ░ ▒██▀▀█▄  ▓▓█  ░██░▒▓█  ▄    ▒▓▓▄ ▄██▒▒██   ██░  ▒   ██▒░ ▓██▓ ░ \n" +
                "  ▒██▒ ░ ░▓█▒░██▓░▒████▒   ░▒████▒▒██▒ ▒██▒ ▓█   ▓██▒▒██▒   ░██▒▒██████▒▒     ▒██▒ ░ ░██▓ ▒██▒▒▒█████▓ ░▒████▒   ▒ ▓███▀ ░░ ████▓▒░▒██████▒▒  ▒██▒ ░ \n" +
                "  ▒ ░░    ▒ ░░▒░▒░░ ▒░ ░   ░░ ▒░ ░▒▒ ░ ░▓ ░ ▒▒   ▓▒█░░ ▒░   ░  ░▒ ▒▓▒ ▒ ░     ▒ ░░   ░ ▒▓ ░▒▓░░▒▓▒ ▒ ▒ ░░ ▒░ ░   ░ ░▒ ▒  ░░ ▒░▒░▒░ ▒ ▒▓▒ ▒ ░  ▒ ░░   \n" +
                "    ░     ▒ ░▒░ ░ ░ ░  ░    ░ ░  ░░░   ░▒ ░  ▒   ▒▒ ░░  ░      ░░ ░▒  ░ ░       ░      ░▒ ░ ▒░░░▒░ ░ ░  ░ ░  ░     ░  ▒     ░ ▒ ▒░ ░ ░▒  ░ ░    ░    \n" +
                "  ░       ░  ░░ ░   ░         ░    ░    ░    ░   ▒   ░      ░   ░  ░  ░       ░        ░░   ░  ░░░ ░ ░    ░      ░        ░ ░ ░ ▒  ░  ░  ░    ░      \n" +
                "          ░  ░  ░   ░  ░      ░  ░ ░    ░        ░  ░       ░         ░                 ░        ░        ░  ░   ░ ░          ░ ░        ░           \n" +
                "                                                                                                                 ░                                   ");
        System.out.println();
        PrintUtil.pause(1000);

        PrintUtil.type(
                "With your last strike, the tower collapses. The Stones shatter. Light swallows everything.\n\n" +
                        "You jolt awake. Back in the lab. The CodeChum login screen still waits.\n" +
                        "The timer blinks: 00:00:01. Not a single problem solved.\n\n" +
                        "You conquered a world, fought betrayal, toppled a king—\n" +
                        "but here, in reality, your exam hasn’t even started.\n\n" +
                        "And for a split second, when you glance at your professor across the room,\n" +
                        "you swear his eyes flash violet.\n"
        );

        InputUtil.pressEnterToContinue();
        System.out.println();
        System.out.println("▄▄▄█████▓ ██░ ██ ▓█████    ▓█████  ███▄    █ ▓█████▄         \n" +
                "▓  ██▒ ▓▒▓██░ ██▒▓█   ▀    ▓█   ▀  ██ ▀█   █ ▒██▀ ██▌        \n" +
                "▒ ▓██░ ▒░▒██▀▀██░▒███      ▒███   ▓██  ▀█ ██▒░██   █▌        \n" +
                "░ ▓██▓ ░ ░▓█ ░██ ▒▓█  ▄    ▒▓█  ▄ ▓██▒  ▐▌██▒░▓█▄   ▌        \n" +
                "  ▒██▒ ░ ░▓█▒░██▓░▒████▒   ░▒████▒▒██░   ▓██░░▒████▓     ██▓ \n" +
                "  ▒ ░░    ▒ ░░▒░▒░░ ▒░ ░   ░░ ▒░ ░░ ▒░   ▒ ▒  ▒▒▓  ▒     ▒▓▒ \n" +
                "    ░     ▒ ░▒░ ░ ░ ░  ░    ░ ░  ░░ ░░   ░ ▒░ ░ ▒  ▒     ░▒  \n" +
                "  ░       ░  ░░ ░   ░         ░      ░   ░ ░  ░ ░  ░     ░   \n" +
                "          ░  ░  ░   ░  ░      ░  ░         ░    ░         ░  \n" +
                "                                              ░           ░  \n");
    }
}
