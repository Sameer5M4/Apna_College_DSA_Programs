public class Subarray {

    public static void main(String args[])
    {
        int arr[]={-2,-3,-4,-1,-2,1,5,-3};
        sub(arr);
    }
    public static void sub(int arr[])
    {
        int cur=0,start=-1,end=-1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {   
            cur+=arr[i];
            if(cur<0)
            {
            cur=0;
            start=i;
            }
            if(cur>max)
            {
                max=cur;
                end=i;

            }
        }
        System.out.println("MAX :"+max+"i="+start+" j="+end);

    }

    
}
