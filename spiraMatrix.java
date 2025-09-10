// public class spiraMatrix {
//     public static void main(String args[])
//     {
//         int mat[][]={
//             {1,2,3,4},
//             {5,6,7,8},
//             {9,10,11,12},
//         };
//         int n=3;
//         for(int i=0;i<n/2+1;i++)
//         {
//             for(int j=i;j<n-i;j++)
//             System.out.print(mat[i][j]+" ");

//             for(int j=i+1;j<n-i;j++)
//             System.out.print(mat[j][n-i-1]+" ");

//             for(int j=n-i-2;j>=i;j--)
//             System.out.print(mat[n-i-1][j]+" ");

//             for(int j=n-i-2;j>i;j--)
//             System.out.print(mat[j][i]+" ");
//         }
//     }
// }


// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class spiraMatrix {
    public static void main(String[] args) {
        // int mat[][]={
        //     {1,2,3,4,5,0},
        //     {5,6,7,8,24,0},
        //     {9,10,11,12,23,0},
        //     {13,14,15,16,22,0},
        //     {17,18,19,20,21,0}
        // };
        // int m=mat[0].length,n=mat.length;
        // System.out.println(n+" "+m);
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int mat[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
              mat[i][j]=sc.nextInt();
            }
        }
        int startRow=0,startCol=0,endRow=n-1,endCol=m-1;
         while(startRow<=endRow && startCol<=endCol)
         {
                for(int j=startCol;j<=endCol;j++)
                System.out.print(mat[startRow][j]+" ");
                
                for(int j=startRow+1;j<=endRow;j++)
                System.out.print(mat[j][endCol]+" ");
                
                for(int j=endCol-1;j>=startCol;j--)
                { 
                    if(startRow==endRow)
                    break;
                System.out.print(mat[endRow][j]+" ");
                }
                
                for(int j=endRow-1;j>=startRow+1;j--)
                {
                    if(startCol==endCol)
                    return;
                System.out.print(mat[j][startCol]+" ");
                }
                
                startCol++;
                startRow++;
                endCol--;
                endRow--;   
         }
    }
}

