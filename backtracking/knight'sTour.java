import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
       Scanner scn = new Scanner(System.in);
       int n = scn.nextInt();
       int sr = scn.nextInt(), sc=scn.nextInt();
       printKnightsTour(new int[n][n],sr,sc,1);

    }

    public static void printKnightsTour(int[][] chess, int r, int c, int move) {
        if(r<0 || c<0 || r>= chess.length || c>=chess[0].length || chess[r][c] != 0){
            return;
        }
       if(move == chess.length*chess[0].length){
           chess[r][c]= move;
           displayBoard(chess);
           chess[r][c]= 0;
           return;
       } 
       chess[r][c]= move;
       printKnightsTour(chess,r-2,c+1,move+1);// pos 1
       printKnightsTour(chess,r-1,c+2,move+1);// pos 2
       printKnightsTour(chess,r+1,c+2,move+1);// pos 3
       printKnightsTour(chess,r+2,c+1,move+1);// pos 4
       printKnightsTour(chess,r+2,c-1,move+1);// pos 5
       printKnightsTour(chess,r+1,c-2,move+1);// pos 6
       printKnightsTour(chess,r-1,c-2,move+1);// pos 7
       printKnightsTour(chess,r-2,c-1,move+1);// pos 8
       chess[r][c]=0;

    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}