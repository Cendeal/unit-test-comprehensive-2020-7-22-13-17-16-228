package game;

import java.util.Scanner;

public class GameApplication {
    private int time;
    private final int MAX_TIME = 6;
    private Validation validation;

    public GameApplication() {
        this.validation = new Validation();
        this.time = 0;
    }

    public void start() {
        GuessGame guessGame = new GuessGame(new GuessAnswerGenerator());

        System.out.println("Game start ["+this.MAX_TIME+" times]:");
        System.out.println("Please input your answer(use space to split every number[0-9]):");
        Scanner sc = new Scanner(System.in);

        while (this.time < this.MAX_TIME) {
            String input = sc.nextLine();
            String input_answer = input.replaceAll(" ", "");
            if (this.validation.isValid(input_answer)) {
                String result = guessGame.guess(input_answer);
                if (isWin(result)) {
                    System.out.println("You win!");
                    break;
                }
                System.out.println("[result]:" + result);
            } else {
                System.out.println("Wrong Input，Input again!");
            }
            this.time++;
            System.out.println(String.format("[tips]:You still have [%s] time(s).", this.MAX_TIME - this.time));
        }
        System.out.println(String.format("Answer should be [%s]", guessGame.getAnswer()));
        System.out.println("Game over!");
        System.out.println("Do you want to play again?(Y/N)");
        String again = sc.next();
        if ("Y".equals(again.toUpperCase())) {
            this.restart();
        }
    }

    private void restart() {
        this.time = 0;
        this.start();
    }

    private boolean isWin(String answer) {
        return this.time <= this.MAX_TIME && "4A0B".equals(answer);
    }

    public static void main(String[] args) {
        new GameApplication().start();
    }
}
