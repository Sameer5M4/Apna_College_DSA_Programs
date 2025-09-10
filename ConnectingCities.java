import java.util.*;
public class ConnectingCities {

    static class pair implements Comparable<pair>
    {
        int v,cost;
        pair(int v,int c)
        {
            this.v=v;
            this.cost=c;

        }
        @Override
        public int compareTo(pair p2)
        {
        return this.cost-p2.cost;
        }
    }
    public static void ConnectingCities(int arr[][],int v)
    {
        int n=arr.length;
        @SuppressWarnings("unchecked")

        boolean vis[]=new boolean[n];

        PriorityQueue<pair> pq=new PriorityQueue<>();
        pq.add(new pair(v,0));
        int finalCost=0;
        while(!pq.isEmpty())
        {
            pair e=pq.remove();

            if(!vis[e.v])
            {
                   vis[e.v]=true;   
                   finalCost+=e.cost;
                   for(int i=0;i<arr[e.v].length;i++)
                   {
                    if(arr[e.v][i]!=0)
                    pq.add(new pair(i,arr[e.v][i]));
                   }
            }
        }
        System.out.println("total cost :"+finalCost);
    }
    public static void main(String[] args)
    {
        int arr[][]={
            {0,1,2,3,5},
            {1,0,5,0,7},
            {2,5,0,6,0},
            {3,0,6,0,0},
            {5,7,0,0,0}
        };
        ConnectingCities(arr, 0);
    }

    
}
