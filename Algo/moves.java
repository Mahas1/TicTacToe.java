package Algo;
import java.util.ArrayList;

public class moves{
  class moves_initial{
    String p1="X",p2="O";
    int moves=0;
  }
  
  class move_decide extends moves_initial{
    String turn;
    if (moves%2==0){
      turn=p1;
    }
    else{
    turn=p2;
    }
    System.out.println("it is player %s's move",turn);
  }
}
