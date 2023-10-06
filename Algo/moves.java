package Algo;
import java.util.ArrayList;

class moves_initial{
    String p1="X",p2="O";
    int moves=0;
}

public class moves{
  
  
  class move_decide(this.moves){
    public String turn;
    if (this.moves%2==0){
      turn=p1;
    }
    else{
      turn=p2;
    }
    System.out.println("it is player %s's move",turn);
  }
}
