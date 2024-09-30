package tictactoe.games;

public class AiVsAiGame {
    private final Game game;

    public AiVsAiGame() {
        this.game = new Game();
    }

    public void run() {
        while(game.isNotFinished()) {
            this.nextTurn();
        }

        game.printGameCondition();
    }

    public void nextTurn() {
        game.nextAiTurn();
    }
}
