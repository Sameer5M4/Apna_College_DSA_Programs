public class containerWithMostWater
{
    public static void main(String args[])
    {
        int arr[]={1,8,6,2,5,4,8,3,7};
        find(arr,arr.length);

    }
    public static void find(int arr[],int n)
    {
        int p1=0,p2=n-1,ans=0,most=0;
        while(p1<p2)
        {
            int min=Math.min(arr[p1],arr[p2]);
            ans=(p2-p1)*min;
            most=Math.max(ans,most);
            if(p1>p2)
            p2--;
            else
            p1++;

        }
        System.out.println(most);

    }
    
}
