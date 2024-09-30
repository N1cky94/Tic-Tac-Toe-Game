package tictactoe.games.board;

public class Coordinate {
    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        if (x < 1 || x > 3 || y < 1 || y > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            this.x = 0;
            this.y = 0;
            return;
        }

        this.x = x;
        this.y = y;
    }

    private Coordinate(int[] coordinateArray) {
        this(coordinateArray[0], coordinateArray[1]);
    }

    private Coordinate(String[] coordinateStringArray) {
        this(Integer.parseInt(coordinateStringArray[0]), Integer.parseInt(coordinateStringArray[1]));
    }

    public Coordinate(String coordinateString) {
        this(coordinateString.split(" "));
    }

    public int getRowCoordinate() {
        return x;
    }

    public int getColumnCoordinate() {
        return y;
    }

    public int getRowCoordinateAsArrayIndex(){
        return x - 1;
    }

    public int getColumnCoordinateAsArrayIndex() {
        return y - 1;
    }

    public String toString() {
        return "(%d, %d)".formatted(x, y);
    }
}
