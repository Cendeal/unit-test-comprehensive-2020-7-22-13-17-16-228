package game;

import java.util.Locale;
import java.util.Scanner;

public class GameApplication {
    private static final String WIN = "4A0B";
    private static final String CONTINUE = "Y";
    private int time;
    private final static int CHALLENGE = 6;
    private final Validation validation;
    private final InputHandler inputHandler;
    private final AnswerGenerator answerGenerator;


    public GameApplication(InputHandler inputHandler, AnswerGenerator answerGenerator) {
        this.validation = new Validation();
        this.inputHandler = inputHandler;
        this.answerGenerator = answerGenerator;
        this.time = 0;
    }

    private void startGameTips() {
        System.out.println("Game start [" + CHALLENGE + " times]:");
        System.out.println("Please input your answer(use space to split every number[0-9]):");
    }

    private void gameOverOutPut(String answer) {
        System.out.println(String.format("Answer should be [%s]", answer));
        System.out.println("Game over!");
        System.out.println("Do you want to play again?(Y/N)");
    }

    private void play(GuessGame guessGame) {
        while (this.time < CHALLENGE) {
            String input = inputHandler.input();
            if (this.validation.isValid(input)) {
                String result = guessGame.guess(input);
                if (isWin(result)) {
                    System.out.println("You win!");
                    break;
                }
                System.out.println("[result]:" + result);
            } else {
                System.out.println("Wrong Input，Input again!");
            }
            this.time++;
            System.out.println(String.format("[tips]:You still have [%s] time(s).", CHALLENGE - this.time));
        }
    }

    private boolean wantTORestart() {
        return CONTINUE.equals(inputHandler.command().toUpperCase(Locale.ENGLISH));
    }

    public void start() {
        GuessGame guessGame = new GuessGame(this.answerGenerator);
        startGameTips();
        play(guessGame);
        gameOverOutPut(guessGame.getAnswer());
        if (wantTORestart()) {
            this.restart();
        }
        inputHandler.close();
    }

    private void restart() {
        this.time = 0;
        this.start();
    }

    private boolean isWin(String answer) {
        return this.time <= CHALLENGE && WIN.equals(answer);
    }

    public static void main(String[] args) {
        new GameApplication(new InputHandler(new Scanner(System.in)), new GuessAnswerGenerator()).start();
    }
}
