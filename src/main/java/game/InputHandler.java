package game;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public String input() {
        String content = scanner.nextLine();
        return cleanBlank(content);
    }

    public String cleanBlank(String content){
        return content.replaceAll(" ", "");
    }

    public String command() {
        return this.scanner.next();
    }

    public void close() {
        this.scanner.close();
    }
}
