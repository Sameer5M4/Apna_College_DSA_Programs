/* 
      (5)
0 ---------- 1
            / \
    (1)    /   \ (3)
          /     \
        2 --------3
        |    (1)
    (2) |
        |
        4 

        */
import java.util.*;

public class AdjacetcyList{

    static class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void main(String args[]) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++)
            graph[i] = new ArrayList<>();

        graph[0].add(new Edge(0, 1, 5));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));
        graph[1].add(new Edge(1,0,5));
        graph[2].add(new Edge(2,4,2));
        graph[1].add(new Edge(2,3,1));
        System.out.println("BFS traversal");
        BFS(graph,0);
        System.out.println("DFS traversal ");
        boolean[] visited=new boolean[V];
        DFS(graph,0,visited);

  
    } 
     public static void BFS(ArrayList<Edge>[] graph,int src )
     {
        boolean[] visited=new boolean[5];
        Arrays.fill(visited,false);
        Queue<Integer> q=new LinkedList<>();
        q.add(src);

        while(!q.isEmpty())
        {
            int curr =q.remove();

            if(!visited[curr])
            {
               System.out.println(curr+" ");
               visited[curr]=true;
               for(Edge x :graph[curr])
               {
                 q.add(x.dest);
               }

            }
        }     

     }
     public static void DFS(ArrayList<Edge>[] graph,int curr,boolean visited[])
     {
          visited[curr]=true;
          System.out.println(curr+" ");
          for(Edge e:graph[curr ])
          {
            if(!visited[e.dest])
            {
                DFS(graph,e.dest,visited);
            }
          }


     }
} 

