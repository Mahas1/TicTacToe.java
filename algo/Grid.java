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
	private ArrayList<ArrayList<Integer>> list;

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
    	this.list=lst;
    	return lst;
    }
    
    public boolean checkForWin() {
    	boolean win=false;
    	int flag=0,i,j;
    			
    	//row wise victory check
    	for(i=0;i<this.size-1;i++) {
    		for (j=0;j<this.size-2;j++) {
    			if ((this.grid.get(i).get(j)!=" ") && (this.grid.get(i).get(j)==this.grid.get(i).get(j+1))){
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
    			if ((this.grid.get(i).get(j)!=" ") && (this.grid.get(i).get(j)==this.grid.get(i+1).get(j))){
    				flag=1;
    			}
    			else {
    				flag=0;
    				break;
    			}
    		} 		
    	}
    	
    	//right digonal \ victory check
    	for(i=0;i<this.size-1;i++) {
    		if((this.grid.get(i).get(i)!=" ") && (this.grid.get(i).get(i+1)==this.grid.get(i+1).get(i+1))) {
    			flag=1;
    		}
    		else {
    			flag=0;
    			break;
    		}
    	}
    	
    	//left diagonal / victory check
    	j=this.size-1;
    	for (i=0;i<this.size-1;i++) {	
    			if ((this.grid.get(i).get(j)!=" ") && (this.grid.get(i).get(j)==this.grid.get(i+1).get(j-1))) {
    				flag=1;
    				j-=1;
    			}
    			else {
    				flag=0;
    				break;
    			}
    		
    	}
    	
    	if (flag==1) {
    		win=true;
    	}
    	
    	return win;
    	
    	
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
        
        //if (this.grid.get(x).get(y) in this.list)
    	 
    }

	
}

