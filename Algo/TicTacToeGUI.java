package Algo;

import javax.swing.*;
import java.awt.*;

public class TicTacToeGUI {
    private Grid board;
    private JButton[][] buttons;

    public void createAndShowGUI() {
        board = new Grid(3);
        JFrame frame = new JFrame("Tic-Tac-Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 3));

        buttons = new JButton[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 60));
                frame.add(buttons[i][j]);
                final int row = i;
                final int col = j;
                buttons[i][j].addActionListener(e -> onButtonClick(row, col));
            }
        }

        frame.pack();
        frame.setVisible(true);
    }

    private void onButtonClick(int row, int col) {
        if (board.canPlace(row, col)) {
            buttons[row][col].setText(board.getMarker());
            board.makeAMove(row, col);
            if (board.check4Win()) {
                JOptionPane.showMessageDialog(null, "yay you won");
                resetGame();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid move. Try again.");
        }
    }

    private void resetGame() {
        board = new Grid(3);
        for (JButton[] buttonRow : buttons) {
            for (JButton button : buttonRow) {
                button.setText("");
            }
        }
    }
}
