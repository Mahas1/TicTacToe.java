package Algo;

import java.util.*;

public class Grid {
    private final int size;
    private ArrayList<ArrayList<String>> grid;
    private static final String space = " ";
    private static final String pipe = "|";
    private static final String hyphen = "-";
    private static final String marker_x = "X";
    private static final String marker_o = "O";

    private final String horiz;
    private int turn = 0;
    private String player;
    private String marker = marker_x;

    public Grid(int size) {
        this.size = size;
        this.grid = new ArrayList<ArrayList<String>>();

        // create the horizontal line 2*size-1 characters long
        StringBuilder horizontalBuilder = new StringBuilder();
        for (int i = 0; i < size * 2 - 1; i++) {
            horizontalBuilder.append(hyphen);
        }
        this.horiz = horizontalBuilder.toString();

        // populate the board with emptiness
        for (int i = 0; i < size; i++) {
            ArrayList<String> temp = new ArrayList<String>();
            for (int j = 0; j < size; j++) {
                temp.add(space);
            }
            this.grid.add(temp);
        }
    }

    public void printBoard() {
        for (int i = 0; i < size - 1; i++) {
            System.out.println(join(grid.get(i), pipe));
            System.out.println(this.horiz);
        }
        System.out.println(join(grid.get(size - 1), pipe));
    }

    private String join(ArrayList<String> list, String delimiter) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                sb.append(delimiter);
            }
            sb.append(list.get(i));
        }
        return sb.toString();
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

	

	public boolean canPlace(int x, int y) {
		if (x >= this.size || y >= this.size) {
			return false;
		}
        return this.grid.get(x).get(y).equals(space);
	}

    public void makeAMove(int x,int y) {
    	
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
    
    public String whosTurn() {

    	if(this.turn%2==0) {
    		System.out.println("it is player 1's turn");
    		
    		this.marker="X";
    	}
    	else {
    		System.out.println("it is player 2's turn");
    		
    		this.marker="O";
    	}
    	
    	return this.player;
    	
    }
    
    public String getMarker() {
        return this.marker;
    }
   
	public String getPlayer() {
		return this.player;
	}
    

}
