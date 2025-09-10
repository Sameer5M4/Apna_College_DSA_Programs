public class trapingRainWater
{
    public static void main(String args[])
    {
        int height[]={4,2,0,6,3,2,5};
        int leftmax[]=new int[7];
        int rightmax[]=new int[7];
        leftmax[0]=height[0];
        for(int i=1;i<7;i++)
        {
            leftmax[i]=Math.max(leftmax[i-1],height[i]);
        }
        rightmax[6]=height[6];
        for(int i=5;i>=0;i--)
        {
            rightmax[i]=Math.max(rightmax[i+1],height[i]);
        }
        int min=0,sum=0;
        for(int i=0;i<7;i++)
        {
             min=Math.min(rightmax[i],leftmax[i]);
             sum+=min-height[i];   
        }
        System.out.println(sum);
    }
    
}
