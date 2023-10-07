package Algo;

import java.util.ArrayList;

public class Grid {
    private final int size;
    private ArrayList<ArrayList<String>> grid;
    private static final String space = "　";
    private static final String pipe = "｜";
    private static final String hyphen = "ー";
    private final String horiz;

    public Grid(int size) {
        this.size = size;
        this.grid = new ArrayList<>();
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
    			if (this.grid.get(i).get(j)==space){
    				ArrayList<Integer> sublst = new ArrayList<Integer>();
    				sublst.add(i);
    				sublst.add(j);
    				lst.add(sublst);		
    			}
    		}
    	}
    	return lst;
    }


    //errors still exist in this fxn, will update soon
    public boolean checkForWin() {
    	boolean win=false;
    	int flag=0,i,j;
    			
    	//row wise victory check
    	for(i=0;i<this.size;i++) {
    		for (j=0;j<this.size-1;j++) {
    			if ((this.grid[i][j]!=" ") and (this.grid[i][j]==this.grid[i][j+1]){
    				flag=1;
    			}
    			else {
    				flag=0;
    				break;
    			}
    		} 		
    	}
    	//column wise victory check
    	for(j=0;j<this.size;j++) {
    		for (i=0;i<this.size-1;i++) {
    			if ((this.grid[i][j]!=" ") and (this.grid[i][j]==this.grid[i+1][j]){
    				flag=1;
    			}
    			else {
    				flag=0;
    				break;
    			}
    		} 		
    	}
    	
    	if (flag==1) {
    		win=true;
    	}
    	
    	return win;
    	
    	
    }
}

