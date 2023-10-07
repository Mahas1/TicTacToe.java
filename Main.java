package Algo;

import Algo.Grid;

public class Main {
    public static void main(String[] args) {
        Grid board = new Grid(3);
        board.printBoard();
        //i've added checkEmpty as a direct call here, later needs to be put inside the function for making a move?
        board.checkEmpty();
        board.checkForWin();
    }
}
