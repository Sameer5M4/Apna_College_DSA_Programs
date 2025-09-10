public class BaySellStocks 
{
    public static void main(String args[])
    {
        int prices[]={7,1,5,3,6,4};

        int buy=prices[0],max=0;
        for(int i=1;i<prices.length;i++)
        {
            if(buy>prices[i])
            buy=prices[i];
            else
              {
                int profit=prices[i]-buy;
                max=Math.max(max,profit);

              }
        }
        System.out.println(max);

    }
    
}
