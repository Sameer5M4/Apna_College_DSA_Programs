public class sortedMatrix
{
    public static void main(String args[])
    {
        int matrix[][]={
            {10,20,30,40},
            {15,25,35,45},
            {27,29,37,48},
            {32,33,39,50}
        };
        int key=12;
        find(matrix,key);
    }
    public static void find(int[][] matrix,int key)
    {
        int i=0,j=matrix.length-1,count=0;
        while(i<matrix.length&&j>=0)
        {
        if(key==matrix[i][j])
        {
            // System.out.println("find at position :"+i+j);
            count++;
            return;
        }
        else if(key>matrix[i][j])
        {
          i++;
        }
        else
        j--;
       }
       System.out.println("count");
    }
    
}
