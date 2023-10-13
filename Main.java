import algo.Grid;

public class Main {
    public static void main(String[] args) {
        Grid board = new Grid(3);
        while (!board.check4Win()) {
            board.printBoard();
            board.makeAMove();
            // switch places
        }
        board.printBoard();
        System.out.println("Game over!");
    }
}
