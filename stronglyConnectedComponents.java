import java.util.*;
public class stronglyConnectedComponents 
{
    static class Edge
    {
        int src,des;
        Edge(int s,int d)
        {
            this.src=s;
            this.des=d;
        }
    }
    public  static void create(ArrayList<Edge> graph[])
    {
        for(int i=0;i<graph.length;i++)
        {
          graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));
        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2,1));
        graph[3].add(new Edge(3,4));


    } 
    public static void topoSort(ArrayList<Edge> graph[],Stack<Integer> s,boolean[] vis,int cur)
    {
         vis[cur]=true;
         for(int i=0;i<graph[cur].size();i++)
         {
            Edge e=graph[cur].get(i);
            if(!vis[e.des])
            topoSort(graph, s, vis, e.des);
         }
         s.push(cur);    
    }
    public static void transpose(ArrayList<Edge> graph[],ArrayList<Edge> transGraph[])
    {
        for(int i=0;i<graph.length;i++)
        transGraph[i]=new ArrayList<Edge>();
          for(int i=0;i<5;i++)
          {
            for(int j=0;j<graph[i].size();j++)
            {
              Edge e=graph[i].get(j);

               transGraph[e.des].add(new Edge(e.des,e.src));
            }
          }
    }
    public static void backDfs(ArrayList<Edge>[] transGraph, int cur, boolean[] vis) {
        vis[cur] = true;
        System.out.print(cur + " ");
        for (Edge e : transGraph[cur]) {
            if (!vis[e.des]) {
                backDfs(transGraph, e.des, vis);
            }
        }
    }
    public static void kosaraju(ArrayList<Edge> graph[])
    {
        Stack<Integer> s=new Stack<>();
   
        boolean vis[]=new boolean[5];
        for(int i=0;i<graph.length;i++)
        {
           if(!vis[i])
           topoSort(graph,s,vis,i);
        }
        @SuppressWarnings("unchecked")
        ArrayList<Edge> transGraph[]=new ArrayList[5];
        transpose(graph,transGraph);
        boolean back[]=new boolean[5];
        while(!s.isEmpty())
        {
            int i=s.pop();
           if(!back[i])
           backDfs(transGraph,i,back);
           System.out.println();
        }
         
    }

    public static void main(String args[])
    {
        @SuppressWarnings("unchecked")
       ArrayList<Edge> graph[]=new ArrayList[5];
       create(graph);
       kosaraju(graph);    
    }
    
}
