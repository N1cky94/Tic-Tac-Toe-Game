package tictactoe;

import java.util.Random;

import static java.lang.System.exit;

public class PlayingField {
    public static final int SIZE = 3;
    private final char[][] field = new char[SIZE][SIZE];

    public static PlayingField createFrom(String textRepresentation){
        if (!textRepresentation.matches("^[XO_]{9}$")) {
            System.out.println("Please provide a correct representation of the game board");
            return null;
        }

        textRepresentation = textRepresentation.replaceAll("_", " ");
        return new PlayingField(textRepresentation);
    }

    public static PlayingField createNewField() {
        return createFrom("_________");
    }

    private PlayingField() {

    }

    private PlayingField(String representation) {
        char[] intermediateField = representation.toCharArray();

        int[] validityCount = new int[] {0, 0};
        for (char sign : intermediateField) {
            if (sign == 'X') {
                validityCount[0]++;
            } else if (sign == 'O') {
                validityCount[1]++;
            }
        }

        int validityCountDelta = validityCount[0] - validityCount[1];
        if (Math.abs(validityCountDelta) > 1) {
            System.out.println("Playing field is not correct, game will reset!");
            exit(0);
        }

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                int intermediateCoordinate = (x * 3) + y;
                field[x][y] = intermediateField[intermediateCoordinate];
            }
        }
    }

    private int[] countFieldMarkers() {
        int[] markerCount = new int[] {0, 0};

        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                char marker = field[x][y];
                if (marker == 'X') {
                    markerCount[0]++;
                } else if (marker == 'O') {
                    markerCount[1]++;
                }
            }
        }

        return markerCount;
    }

    public boolean isFreeSpot(Coordinate coordinate) {
        return field[coordinate.getRowCoordinateAsArrayIndex()][coordinate.getColumnCoordinateAsArrayIndex()] == ' ';
    }

    public void makeMove(Coordinate coordinate) {
        if (isFreeSpot(coordinate)) {
            char marker = nextMarker();
            field[coordinate.getRowCoordinateAsArrayIndex()][coordinate.getColumnCoordinateAsArrayIndex()] = marker;
        }
    }

    public void makeRandomMove() {
        final Random random = new Random();
        Coordinate suggestedCoordinate;
        do {
            suggestedCoordinate = new Coordinate((random.nextInt(3) + 1), (random.nextInt(3) + 1));
        } while (!isFreeSpot(suggestedCoordinate));

        makeMove(suggestedCoordinate);
    }

    private char nextMarker() {
        int[] markers = countFieldMarkers();

        if (markers[0] == markers[1]) {
            return 'X';
        } else {
            return 'O';
        }
    }

    public Condition getGameCondition() {
        if (reachedWinCondition('X')) {
            return Condition.X_WIN;
        } else if (reachedWinCondition('O')) {
            return Condition.O_WIN;
        } else if (isFieldFull()) {
            return Condition.STALE;
        } else {
            return Condition.PLAYING;
        }
    }

    private boolean reachedWinCondition(char marker) {
        String row1 = "%s%s%s".formatted(field[0][0], field[0][1], field[0][2]);
        String row2 = "%s%s%s".formatted(field[1][0], field[1][1], field[1][2]);
        String row3 = "%s%s%s".formatted(field[2][0], field[2][1], field[2][2]);

        String column1 = "%s%s%s".formatted(field[0][0], field[1][0], field[2][0]);
        String column2 = "%s%s%s".formatted(field[0][1], field[1][1], field[2][1]);
        String column3 = "%s%s%s".formatted(field[0][2], field[1][2], field[2][2]);

        String cross1 = "%s%s%s".formatted(field[0][0], field[1][1], field[2][2]);
        String cross2 = "%s%s%s".formatted(field[0][2], field[1][1], field[2][0]);

        return row1.equals("%c%c%c".formatted(marker, marker, marker))    ||
                row2.equals("%c%c%c".formatted(marker, marker, marker))    ||
                row3.equals("%c%c%c".formatted(marker, marker, marker))    ||
                column1.equals("%c%c%c".formatted(marker, marker, marker)) ||
                column2.equals("%c%c%c".formatted(marker, marker, marker)) ||
                column3.equals("%c%c%c".formatted(marker, marker, marker)) ||
                cross1.equals("%c%c%c".formatted(marker, marker, marker))  ||
                cross2.equals("%c%c%c".formatted(marker, marker, marker));
    }

    private boolean isFieldFull() {
        for (char[] row : field) {
            for (char marker : row) {
                if (marker == ' ') {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("---------\n");
        for (char[] row : field) {
            builder.append("| ")
                    .append(row[0])
                    .append(" ")
                    .append(row[1])
                    .append(" ")
                    .append(row[2])
                    .append(" |\n");
        }

        return builder.append("---------").toString();
    }

}
