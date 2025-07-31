import java.util.*;
public class Dikstras {
       static class pair implements Comparable<pair>
    {
        int s;
        int path;
        pair(int s,int path)
        {
            this.s=s;
            this.path=path;
        }
        @Override
        public int compareTo(pair p2){
        return this.path - p2.path;
        }
    }
    static class edge
    {
        int src;
        int des;
        int wt;
        edge (int src,int des,int wt)
        {
            this.src=src;
            this.des=des;
            this.wt=wt;
        }
    }
    public static void createGraph(ArrayList<edge> graph[],int arr[][],int n)
    {
  

        for(int i=0;i<n;i++)
        {
            int src=arr[i][0];
            int des=arr[i][1];
            int wt=arr[i][2];
            graph[src].add(new edge(src,des,wt));

        }

    }
    public static void main(String args[])
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
        dikstras(arr,n,0);
    }
    public static void dikstras(int arr[][],int n,int src)
    {
        @SuppressWarnings("unchecked")
        ArrayList<edge> graph[]=new ArrayList[n];
        for(int i=0;i<n;i++)
        graph[i]=new ArrayList<>();
        createGraph(graph,arr,arr.length);
        int dis[]=new int[n];
        for(int i=0;i<n;i++)
        {
            if(i!=src)
            dis[i]=Integer.MAX_VALUE;
        }
        boolean vis[]=new boolean[n];
        PriorityQueue<pair> q =new PriorityQueue<>();
        q.add(new pair(src,0));
       
         while(!q.isEmpty())
         {
             pair cur=q.remove();
            if(!vis[cur.s])
            {
                vis[cur.s]=true;
                 
                for(int i=0;i<graph[cur.s].size();i++)
                {
                    edge e=graph[cur.s].get(i);
                     int u=e.src;
                     int w=e.wt;
                     int v=e.des;
                     if(dis[u]+w<dis[v])
                     {
                        dis[v]=dis[u]+w;
                        q.add(new pair(v,dis[v]));
                     }
                   
                     
                }

            }
         
        

         }
         for(int i=0;i<n;i++)
         System.out.println(dis[i]);

    }




    
}
