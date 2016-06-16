package recursion;

import java.util.Arrays;


public class PrintPath2D {


    public void print(int arr[][],int row, int col,int result[],int pos){
        if(row == arr.length-1 && col == arr[0].length-1){
            result[pos] = arr[row][col];
            System.out.println(Arrays.toString(result));
            return;
        }
        if(row >= arr.length || col >= arr[0].length || row < 0 || col < 0){
            return;
        }
        
        result[pos] = arr[row][col];
        print(arr,row,col+1,result,pos+1);
        print(arr,row+1,col,result,pos+1);
        print(arr,row,col-1,result,pos+1);
        print(arr,row-1,col,result,pos+1);
    }
    
    public static void main(String args[]){
        PrintPath2D pam = new PrintPath2D();
        int arr[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int result[] = new int[50];
        pam.print(arr, 0, 0, result,0);
    }
}