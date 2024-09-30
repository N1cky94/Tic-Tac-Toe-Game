package tictactoe.games;

import tictactoe.Condition;

public class UserVsAiGame {
    private final Game game;
    private boolean userIsNext;

    public UserVsAiGame(boolean userFirst) {
        game = new Game();
        this.userIsNext = userFirst;
    }

    public void run() {
        while(!game.isFinished()) {
            this.nextTurn();
        }

        Condition gameCondition = game.getCondition();

        if (gameCondition.equals(Condition.O_WIN)) {
            System.out.println("O wins");
        } else if (gameCondition.equals(Condition.X_WIN)) {
            System.out.println("X wins");
        } else if (gameCondition.equals(Condition.STALE)) {
            System.out.println("Draw");
        } else {
            System.out.println("Game not finished");
        }
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
