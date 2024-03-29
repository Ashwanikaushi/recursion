import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int chess[][]= new int[n][n];
        printNQueens(chess, "",0);
        
    }
    
    public static void printNQueens(int[][] chess, String asf, int row) {
        if(row == chess.length){
            System.out.println(asf+".");
            return;
        }
        for(int col=0; col<chess.length; col++){
        if(isSafe(chess,row, col) == true){
            chess[row][col]= 1; // place
            printNQueens(chess, asf+row+"-"+col+",",row+1);
            chess[row][col] = 0; // unplace
        }
        }
    }
    public static boolean isSafe(int chess[][], int row, int col){
        // vertical check
        for(int i=row-1,j=col; i>=0;i--){
            if(chess[i][j]==1){
                return false;
            }
        }
        // diagonal left check
       for(int i=row-1,j=col-1; i>=0 && j>=0;i--,j--){
            if(chess[i][j]==1){
                return false;
            }
        }
        // diagonal right check
        for(int i=row-1,j=col+1; i>=0 && j>=0;i--, j++){
            if(chess[i][j]==1){
                return false;
            }
        }
        return true;
    }
}