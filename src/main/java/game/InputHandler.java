package game;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public String input() {
        String content = scanner.nextLine();
        return content.replaceAll(" ", "");
    }

    public String command() {
        return this.scanner.next();
    }

    public void close() {
        this.scanner.close();
    }
}
