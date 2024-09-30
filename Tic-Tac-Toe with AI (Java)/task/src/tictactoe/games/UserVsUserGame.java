package tictactoe.games;

public class UserVsUserGame {
    private final Game game;

    public UserVsUserGame() {
        this.game = new Game();
    }

    public void run() {
        while(game.isNotFinished()) {
            this.nextTurn();
        }

        game.printGameCondition();
    }

    public void nextTurn() {
        game.nextUserTurn();
    }
}
