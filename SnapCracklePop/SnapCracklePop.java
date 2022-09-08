/*
* A class being used to play Snap, Crackle and Pop,
  a game where three people choose a number to define Snap, Crackle and Pop
  and then they say snap, crackle , snappop etc based on the round.
* @author Kanav Talwar
* @version 1.0
*/
public class SnapCracklePop{
   /**
   * Stores the values of Snap, Crackle and Pop
   */
   private int snap;
   private int crackle;
   private int pop;
   
   /**
   * The constructor takes in three ints,
   * which must be assigned to their instance variables and initialized.
   * @param s stores Snap
   * @param c stores Crackle
   * @param p stores Pop
   */
      
   public SnapCracklePop(int s,int c,int p){
      snap = s;
      crackle = c;
      pop = p;
   }
   
   /**
   * Helper method to return result for the round
   * @param rnd stores the round being played
   * @return the result of the round
   */ 
   
   private String playRound(int rnd){
      if(rnd%snap==0 && rnd%crackle==0 && rnd%pop==0){
         return "snapcracklepop";
      }else if(rnd%snap==0 && rnd%crackle==0){
         return "snapcrackle";
      }else if(rnd%snap==0 && rnd%pop==0){
         return "snappop";
      }else if(rnd%pop==0 && rnd%crackle==0){
         return "cracklepop";
      }else if(rnd%snap==0){
         return "snap";
      }else if(rnd%crackle==0){
         return "crackle";
      }else if(rnd%pop==0){
         return "pop";
      }else{
         return ""+rnd;
      }
   } 
   
   /**
   * This method plays the game, loops each round and checks what to print.
   * Calls the playRound() method
   * @param num sores the number or rounds to play
   * @return the entire string of answers for each round
   */ 
  
   int j=1;
   public String playGame(int num){
      if(num <1){
         return "";
      }else{
         System.out.print("Round "+j+": "+playRound(j));
         j++;
         num = num-1;
         System.out.println();
         return playGame(num);
      }
   }
   
   /**
   * Method to return the value given to Snap
   * @return snap
   */ 
   
   public int getSnap(){
      return snap;
   }
   
   /**
   * Method to return the value given to Crackle
   * @return crackle
   */ 
   
   public int getCrackle(){
      return crackle;
   }  
   
   /**
   * Method to return the value given to Pop
   * @return pop
   */ 
     
   public int getPop(){
      return pop;
   }
   
}