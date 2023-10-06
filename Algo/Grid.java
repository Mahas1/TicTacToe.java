package Algo;

import java.util.ArrayList;

public class Grid {
    private int size;
    private ArrayList<ArrayList<String>> grid;
    private static final String space = "　";
    private static final String pipe = "｜";
    private static final String hyphen = "ー";
    private final String horiz;

    public Grid(int size) {
        this.size = size;
        this.grid = new ArrayList<>();
         this.horiz = new String(new char[size*2-1]).replace("\0", this.hyphen);

        // populate the board with emptiness
        for (int i=0; i<size; i++) {
            ArrayList<String> temp = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                temp.add(this.space);
            }
            this.grid.add(temp);
        }

    }

    public void printBoard() {
        for (int i=0; i<size-1; i++) {
            System.out.println(String.join(this.pipe, grid.get(i)));
            System.out.println(this.horiz);
        }
        System.out.println(String.join(this.pipe, grid.get(this.size-1)));
    }

}
