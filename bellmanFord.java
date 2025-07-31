import java.util.*;
public class bellmanFord 
{
    static class edge
    {
        int s,d,w;
        edge(int s,int d,int w)
        {
            this.s=s;
            this.d=d;
            this.w=w;
        }
    }
    static void createGraph(int arr[][],ArrayList<edge> graph[],int n)
    {
        for(int i=0;i<n;i++)
        {
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<n;i++)
        {
            int s=arr[i][0];
            int d=arr[i][1];
            int w=arr[i][2];
            graph[s].add(new edge(s,d,w));
          }
    }
    public static void bellmanFord(int arr[][],int src)
    {
        int n=arr.length;
        ArrayList<edge> graph[]=new ArrayList[n];
        createGraph(arr,graph,n);
        int dis[]=new int[n];
        for(int i=0;i<n;i++)
        {
            if(i!=src)
            dis[i]=Integer.MAX_VALUE;
        }  
         for(int i=0;i<n-1;i++)
         {
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<graph[j].size();k++)
                {
                    edge e=graph[j].get(k);
                    int s=e.s;
                    int d=e.d;
                    int w=e.w;
                    if(dis[s]!=Integer.MAX_VALUE&& dis[s]+w<dis[d])
                     dis[d]=dis[s]+w;
                }
            }
         }
         for(int i=0;i<n;i++)
         {
            System.out.print(dis[i]+" ");
         }


    }
    public static void main(String[] args)
    {
        int arr[][]={   {0, 1, 2},
        {0, 2, 4},
        {1, 2, 1},
        {1, 3, 7},
        {2, 4, 3},
        {3, 5, 1},
        {4, 3, 2},
        {4, 5, 5}};
        int n=6;
        bellmanFord(arr,0);
    }
    
}
