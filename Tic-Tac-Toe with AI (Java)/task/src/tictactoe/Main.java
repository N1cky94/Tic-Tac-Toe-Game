package tictactoe;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        while(!game.isFinished()) {
            game.nextTurn();
        }

        if (game.getCondition().equals(Condition.O_WIN)) {
            System.out.println("O wins");
        } else if (game.getCondition().equals(Condition.X_WIN)) {
            System.out.println("X wins");
        } else if (game.getCondition().equals(Condition.STALE)) {
            System.out.println("Draw");
        } else {
            System.out.println("Game not finished");
        }

    }
}
