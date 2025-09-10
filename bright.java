import java.util.*;
public class bright 
{
    static class Edge
    {
        int sr,des;
        Edge(int s,int d)
        {
           this.sr=s;
           this.des=d;
        }
    }
    public static void create(ArrayList<Edge> graph[],int v)
    {
        for(int i=0;i<v;i++)
        graph[i]=new ArrayList<Edge>();

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));


    }
    public static void targens(ArrayList<Edge> graph[],int v)
    {
        int dis[]=new int[v];
        int low[]=new int[v];
        boolean vis[]=new boolean[v];
        int time=0;
        for(int i=0;i<v;i++)
        {
            if(!vis[i])
            dfs(graph,dis,low,time,vis,i,-1);
        }

    }
    public static void dfs(ArrayList<Edge> graph[],int dis[],int low[],int time,boolean vis[],int cur,int par)
    {
        vis[cur]=true;
        low[cur]=dis[cur]=++time;
        for(int i=0;i<graph[cur].size();i++)
        {
          Edge e=graph[cur].get(i);
          int nei=e.des;
            if(par==nei)
            continue;
            else if(!vis[nei])
            {
                
                dfs(graph, dis, low, time, vis,nei,cur);
                low[cur]=Math.min(low[cur],low[nei]);
                if(dis[cur]<low[nei])
                System.out.println(cur+"------->"+nei);
            }
            else
            low[cur]=Math.min(low[cur],dis[nei]);
        }
        
    }
    public static void main(String args[])
    {
        @SuppressWarnings("Unchecked")
        ArrayList<Edge> graph[]=new ArrayList[6];
        create(graph,6);
        targens(graph,6);

    }
}
