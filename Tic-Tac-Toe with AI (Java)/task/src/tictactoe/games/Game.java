package tictactoe.games;

import tictactoe.Condition;
import tictactoe.Coordinate;
import tictactoe.KeyboardUtil;
import tictactoe.PlayingField;

public class Game {
    private final PlayingField board;

    public Game() {
        this.board = PlayingField.createNewField();
        System.out.println(this.board);
    }

    public boolean isFinished() {
        return switch (board.getGameCondition()) {
            case O_WIN, X_WIN, STALE -> true;
            default -> false;
        };
    }

    public Condition getCondition() {
        return board.getGameCondition();
    }

    public void printGameCondition() {
        Condition gameCondition = this.getCondition();

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

    void nextUserTurn() {
        String coordinateString = KeyboardUtil.askStringInput("Enter the coordinates: ");
        if (isValidCoordinate(coordinateString)) {
            Coordinate coordinate = new Coordinate(coordinateString);
            board.makeMove(coordinate);
            System.out.println(board);
        }
    }

    void nextAiTurn() {
        System.out.println("Making move level \"easy\"");
        board.makeRandomMove();
        System.out.println(board);
    }

    private boolean isValidCoordinate(String coordinate) {
        if (!coordinate.matches("^[1234567890 ]{3}$")) {
            System.out.println("You should enter numbers!");
            return false;
        } else if (!coordinate.matches("^[123 ]{3}$")) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }

        Coordinate coord = new Coordinate(coordinate);

        if (!board.isFreeSpot(coord)) {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }

        return true;
    }
}
