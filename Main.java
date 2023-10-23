import algo.Grid;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Grid board = new Grid(3);

            JFrame frame = new JFrame("Tic Tac Toe");
            GamePanel gamePanel = new GamePanel(board);

            frame.add(gamePanel);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

            while (!board.check4Win() && !board.isBoardFull()) {
                // Handle game logic here if needed
                int player = board.whosTurn();
                System.out.println("Player " + player + "'s turn");
                board.printBoard();
                board.makeAMove();
            }

            // Handle game over logic here (display a message, etc.)
            if (board.check4Win()) {
                System.out.println("Player " + board.getOpponentPlayer() + " wins!");
            } else {
                System.out.println("It's a draw!");
            }
        });
    }
}

