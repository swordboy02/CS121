import java.util.*;
class TicTacToe{
   static Scanner sc = new Scanner(System.in);
   static String[][] board= new String[3][3];
   public static void main(String[] args){
      for(int i = 0;i<3;i++){
         for(int j=0;j<3;j++){
            board[i][j] =(" ");
         }
      }
      Intro();
      int cnt = 0;
      while(cnt<9){
         if(cnt%2 == 0){
            System.out.println("Where would you like to play \"X\" ?");
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a<1||a>3||b<1||b>3){
               System.out.println("Invalid Input Please Enter In Range\n\n");
               continue;
            }
            if(board[a-1][b-1].equals(" ") == false){
               System.out.println("Please enter value in another location\n\n");
               continue;
            }
            board[a-1][b-1] = "X";
            printboard();
            if(winCheck()){
               System.out.println("Congrats Player 1! You Won!");
               break;
            }
            cnt++;
         }
         else if(cnt%2 !=0){
            System.out.println("Where would you like to play \"O\" ?");
            int a1 = sc.nextInt();
            int b1 = sc.nextInt();
            if(a1<1||a1>3||b1<1||b1>3){
               System.out.println("Invalid Input Please Enter In Range\n\n");
               continue;
            }
            if(board[a1-1][b1-1].equals(" ") == false){
               System.out.println("Please enter value in another location\n\n");
               continue;
            }
            board[a1-1][b1-1] = "O";
            printboard();
            if(winCheck()){
               System.out.println("Congrats Player 2! You Won!");
               break;
            }
            cnt++;
         }
      }
      if(cnt == 9){
         System.out.println("You Tied!");
      }
   }
   static void printboard(){
      for(int i = 0;i<3;i++){
         for(int j=0;j<3;j++){
            System.out.print(" [ "+board[i][j]+" ] ");
         }
         System.out.println();
      }
   
   }
   static void Intro(){
      System.out.print("Welcome to Tic Tac Toe!\n");
      System.out.print("Rules:\n");
      System.out.print("The game is played on a grid that's 3 squares by 3 squares.\n");
      System.out.print("Player 1 is \"X\" and Player 2 is \"O\".\nPlayers take turns putting their marks in empty squares.\n");
      System.out.print("Players can choose the nine grids from (1 1) to (3 3)\n");
      System.out.print("The first player to get 3 of their marks in a row (up, down, across, or diagonally) is the winner!\n\n");
      printboard();
      
   }
   static boolean winCheck(){
      if(board[0][0].equals(board[0][1]) && board[0][0].equals(board[0][2]) && (board[0][0].equals(" ") == false)){
         return true;
      }else if(board[1][0].equals(board[1][1]) && board[1][0].equals(board[1][2]) && (board[1][0].equals(" ") == false)){
         return true;
      }else if(board[2][0].equals(board[2][1]) && board[2][0].equals(board[2][2]) && (board[2][0].equals(" ") == false)){
         return true;
      }else if(board[0][0].equals(board[1][0]) && board[0][0].equals(board[2][0]) && (board[0][0].equals(" ") == false)){
         return true;
      }else if(board[0][1].equals(board[1][1]) && board[0][1].equals(board[2][1]) && (board[0][1].equals(" ") == false)){
         return true;
      }else if(board[0][2].equals(board[1][2]) && board[0][2].equals(board[2][2]) && (board[0][2].equals(" ") == false)){
         return true;
      }else if(board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) && (board[0][0].equals(" ") == false)){
         return true;
      }else if(board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]) && (board[0][2].equals(" ") == false)){
         return true;
      }else{
         return false;
      }
   }
}
