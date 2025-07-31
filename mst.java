import java.util.*;
public class mst 
{
    static class edge{
        int s,d,w;
        edge(int s,int d,int w)
        {
            this.s=s;
            this.d=d;
            this.w=w;
        }
    }
    static class pair implements Comparable<pair>{
        int s;
        int path;
        pair(int s,int path)
        {
            this.s=s;
            this.path=path;
        }
        
        public int compareTo(pair p2)
        {
            return path-p2.path;
        }

    }
    public static void createGraph(int[][] arr, ArrayList<edge>[] graph) {
        for (int i=0;i<arr.length;i++) {
            int u = arr[i][0], v = arr[i][1], w = arr[i][2];
            graph[u].add(new edge(u, v, w));
            graph[v].add(new edge(v, u, w)); // Undirected
        }
    }
    public static void mst(int arr[][],int src)
    {
        int maxVertex = 0;
        for (int[] a : arr) {
            maxVertex = Math.max(maxVertex, Math.max(a[0], a[1]));
        }
        int n = maxVertex + 1;
        @SuppressWarnings("unchecked")
        ArrayList<edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        createGraph(arr, graph);
       boolean vis[]=new boolean[n];
       PriorityQueue<pair> pq=new PriorityQueue<>();
       pq.add(new pair(src,0));
       int finalCost=0;
       while(!pq.isEmpty())
       {
        pair ele=pq.remove();
        if(!vis[ele.s])
        {
            vis[ele.s]=true;
             finalCost+=ele.path;
             for (int i = 0; i < graph[ele.s].size(); i++) {
                edge e = graph[ele.s].get(i);
                if (!vis[e.d]) {
                    pq.add(new pair(e.d, e.w));
                }
            }
            
        }
       }
     System.out.println(finalCost);
       
    }
 
    public static void main(String args[])
    {
        int[][] arr = {
            {0, 1, 4},   // edge from node 0 to 1 with weight 4
            {0, 2, 3},   // edge from node 0 to 2 with weight 3
            {1, 2, 1},   // edge from node 1 to 2 with weight 1
            {1, 3, 2},   // edge from node 1 to 3 with weight 2
            {2, 3, 4},   // edge from node 2 to 3 with weight 4
            {3, 4, 2},   // edge from node 3 to 4 with weight 2
            {4, 5, 6}    // edge from node 4 to 5 with weight 6
        };
        mst(arr,0);
        
        
    }
}

