package tictactoe.utils;

import java.util.Scanner;

public class KeyboardUtil {
    public static final Scanner KEYBOARD = new Scanner(System.in);

    private static String askInput(String message) {
        System.out.print(message);
        return KEYBOARD.nextLine();
    }

    public static String askStringInput(String message) {
        return askInput(message);
    }

    public static int askIntInput(String message) {
        return Integer.parseInt(askInput(message));
    }
}
