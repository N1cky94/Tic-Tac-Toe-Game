package tictactoe.games;

public class UserVsAiGame {
    private final Game game;
    private boolean userIsNext;

    public UserVsAiGame(boolean userFirst) {
        game = new Game();
        this.userIsNext = userFirst;
    }

    public void run() {
        while(game.isNotFinished()) {
            this.nextTurn();
        }

        game.printGameCondition();
    }

    public void nextTurn() {
        if (userIsNext) {
            game.nextUserTurn();
            toggleUserIsNext();
        } else {
            game.nextAiTurn();
            toggleUserIsNext();
        }
    }

    private void toggleUserIsNext() {
        this.userIsNext = !userIsNext;
    }
}
