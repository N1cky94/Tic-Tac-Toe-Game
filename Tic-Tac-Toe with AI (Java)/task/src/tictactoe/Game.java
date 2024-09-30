package tictactoe;

public class Game {
    private final PlayingField board;
    private boolean userPlaysNext = true;

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

    public void nextTurn() {
        if (userPlaysNext) {
            String coordinateString = KeyboardUtil.askStringInput("Enter the coordinates: ");
            if (isValidCoordinate(coordinateString)) {
                Coordinate coordinate = new Coordinate(coordinateString);
                board.makeMove(coordinate);
                System.out.println(board);
                userPlaysNext = false;
            }
        } else {
            System.out.println("Making move level \"easy\"");
            board.makeRandomMove();
            System.out.println(board);
            userPlaysNext = true;
        }
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
