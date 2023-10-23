import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo.Grid;

public class GamePanel extends JPanel {
    private final Grid board;
    private JButton[][] buttons;

    public GamePanel(Grid board) {
        this.board = board;
        int size = board.getSize();
        buttons = new JButton[size][size];

        setLayout(new GridLayout(size, size));

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                JButton button = new JButton();
                buttons[i][j] = button;
                button.setFont(new Font("Arial", Font.PLAIN, 40));
                button.addActionListener(new ButtonClickListener(i, j));
                add(button);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int size = board.getSize();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                buttons[i][j].setText(board.getGridValue(i, j));
            }
        }
    }

    private class ButtonClickListener implements ActionListener {
        private final int x;
        private final int y;

        public ButtonClickListener(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (board.canPlace(x, y)) {
                board.makeMove(x, y);
                repaint();

                // Check for a win or a draw here if needed
                // If the game is over, display a message or take appropriate actions
            } else {
                JOptionPane.showMessageDialog(GamePanel.this, "Invalid move!");
            }
        }
    }
}
