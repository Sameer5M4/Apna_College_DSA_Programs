import java.util.*;
public class subArraySum
 {
    public static void main(String arg[])
    {
        int arr[]={-2,-3,4,-1,-2,1,5,-3};
        int sum=0,maxi=0;
        // for(int i=0;i<arr.length;i++)
        // {
        //     sum=0;
        //     for(int j=i;j<arr.length;j++)
        //     {
        //         sum+=arr[j];
        //         maxi=Math.max(maxi,sum);
        //     }
            
        // }
        // System.out.println(maxi);
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if(sum<0)
            sum=0;
            maxi=Math.max(sum,maxi);
         
        }
        System.out.println(maxi);

    }
    
}


