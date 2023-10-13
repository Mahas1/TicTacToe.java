package algo;

import java.util.ArrayList;
import java.util.*;

public class Grid {
    private final int size;
    private ArrayList<ArrayList<String>> grid;
    private static final String space = "　";
    private static final String pipe = "｜";
    private static final String hyphen = "ー";
	private static final String marker_x = "ｘ";
	private static final String marker_o = "ｏ";

    private final String horiz;
	private int turn=0;
	private int player=0;
	private String marker = marker_x;

    public Grid(int size) {
        this.size = size;
        this.grid = new ArrayList<>();

		// create the horizontal line 2*size-1 characters long
		this.horiz = new String(new char[size*2-1]).replace("\0", hyphen);

        // populate the board with emptiness
        for (int i=0; i<size; i++) {
            ArrayList<String> temp = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                temp.add(space);
            }
            this.grid.add(temp);
        }


    }

    public void printBoard() {
        for (int i=0; i<size-1; i++) {
            System.out.println(String.join(pipe, grid.get(i)));
            System.out.println(this.horiz);
        }
        System.out.println(String.join(pipe, grid.get(this.size-1)));
    }

    
    public ArrayList<ArrayList<Integer>> checkEmpty() {
    	int i,j;
    	ArrayList<ArrayList<Integer>> lst = new ArrayList<ArrayList<Integer>>();
    	
    	for(i=0;i<this.size;i++) {
    		for(j=0;j<this.size;j++) {
    			if (this.grid
						.get(i)
						.get(j)
						.equals(space)
				){
    				ArrayList<Integer> sublst = new ArrayList<Integer>();
    				sublst.add(i);
    				sublst.add(j);
    				lst.add(sublst);		
    			}
    		}
    	}
    	return lst;
    }
    
    //counts number of occurrences of players piece, opponents piece and spaces for given row id
    public int countRowOccurrenceOf(String piece, int rowID) {
    	int count=0;

    	for(int i=0;i<this.size;i++) {
			if ((this.grid.get(rowID).get(i)).equals(piece)) {
				count += 1;
			}
		}
    	return count;
    }
    
    
   
  //counts number of occurrences of a piece
    public int countColumnOccurrenceOf(String piece, int colID) {
		int count=0;
    	for(int i=0;i<this.size;i++) {
    		if ((this.grid.get(i).get(colID)).equals(piece)) {
    			count+=1;
    		}

    	}

    	return count;
    }
    
    public int countRightDiagonalOccurrenceOf(String piece) {
    	int count=0;
    	for(int i=0;i<this.size;i++) {
    		if(this.grid.get(i).get(i).equals(piece)) {
    			count+=1;
    		}
    	}

    	return count;
    	
    }
    
    public int countLeftDiagonalOccurrenceOf(String piece) {
    	int countPiece = 0;

		for (int i=0;i<this.size;i++) {
    		if(this.grid.get(i).get(this.size-i-1).equals(piece)) {
        		countPiece+=1;
        	}
    	}
    	return countPiece;
    }
    
    public boolean check4Win(){
    	int i;
		String to_check = Objects.equals(this.marker, marker_x) ? marker_o : marker_x;

    	for(i=0;i<this.size;i++) {

    		int rows=countRowOccurrenceOf(to_check, i);
    		int columns=countColumnOccurrenceOf(to_check, i);

			if (rows==this.size || columns==this.size) {
    				return true;
    			}
    		}

    	int rDiag=countRightDiagonalOccurrenceOf(to_check);
    	int lDiag=countLeftDiagonalOccurrenceOf(this.marker);
    	for(int j=0;j<2;j++) {
			if((rDiag == this.size) || (lDiag == this.size)){
				return true;
			}
		}
    	return false;
    	
    }

	//seeing whos turn it is to play
    public int whosTurn() {

    	if(this.turn%2==0) {
    		System.out.println("it is player 1's turn");
    		this.player=1;
    		this.marker="X";
    	}
    	else {
    		System.out.println("it is player 2's turn");
    		this.player=2;
    		this.marker="O";
    	}
    	
    	return this.player;
    	
    }

	public boolean canPlace(int x, int y) {
		if (x >= this.size || y >= this.size) {
			return false;
		}
        return this.grid.get(x).get(y).equals(space);
	}

    public void makeAMove() {
    	System.out.printf("enter index where u want to place marker (%s)\n", this.marker);
    	Scanner sc = new Scanner(System.in);
    	int x=sc.nextInt();
        int y=sc.nextInt();
        
        //checkempty function call
		if (canPlace(x,y)) {
			this.grid.get(x).set(y, this.marker);
            if (this.marker.equals(marker_x)) {
                this.marker = marker_o;
            } else {
				this.marker = marker_x;
			}
        }
		else {
			System.out.println("invalid move");
		}
    }

	
}
