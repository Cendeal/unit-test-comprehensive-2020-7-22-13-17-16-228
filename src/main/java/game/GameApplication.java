package game;

import java.util.Locale;

public class GameApplication {
    private static final String WIN = "4A0B";
    private static final String CONTINUE = "Y";
    private int time;
    private final static int CHALLENGE = 6;
    private final Validation validation;
    private final InputHandler inputHandler;

    public GameApplication() {
        this.validation = new Validation();
        this.inputHandler = new InputHandler();
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

    public void start() {
        GuessGame guessGame = new GuessGame(new GuessAnswerGenerator());
        startGameTips();
        play(guessGame);
        gameOverOutPut(guessGame.getAnswer());
        String again = inputHandler.command();
        if (CONTINUE.equals(again.toUpperCase(Locale.ENGLISH))) {
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
        new GameApplication().start();
    }
}
