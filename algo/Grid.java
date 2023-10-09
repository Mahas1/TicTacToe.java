package algo;

import java.util.ArrayList;
import java.util.*;

public class Grid {
    private final int size;
    private ArrayList<ArrayList<String>> grid;
    private static final String space = "　";
    private static final String pipe = "｜";
    private static final String hyphen = "ー";
    private final String horiz;
	private int turn=0;
	private int player=0;
	private String marker;

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
    
    	for(i=0;i<this.size;i++) {
    		int rows=countRowOccurrenceOf(this.marker, i);
    		int columns=countColumnOccurrenceOf(this.marker, i);

			if (rows==this.size || columns==this.size) {
    				return true;
    			}
    		}

    	int rDiag=countRightDiagonalOccurrenceOf(this.marker);
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
    
    public void makeAMove() {
    	System.out.println("enter index where u want to place marker");
    	Scanner sc = new Scanner(System.in);
    	int x=sc.nextInt();
        int y=sc.nextInt();
        
        //checkempty function call
        this.grid.get(x).set(y,this.marker);
        //checkforwin function call
    	 
    }

	
}
