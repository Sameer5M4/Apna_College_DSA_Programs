import java.util.*;

public class CFWKS {
    static class pair implements Comparable<pair> {
        int s;
        int path;
        int stops;

        pair(int s, int path, int stops) {
            this.s = s;
            this.path = path;
            this.stops = stops;
        }

        public int compareTo(pair p) {
            return this.path - p.path; // Min-heap by cost
        }
    }

    static class edge {
        int src;
        int des;
        int wt;

        edge(int src, int des, int wt) {
            this.src = src;
            this.des = des;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<edge> graph[], int arr[][], int n) {
        for (int i = 0; i < n; i++) {
            int src = arr[i][0];
            int des = arr[i][1];
            int wt = arr[i][2];
            graph[src].add(new edge(src, des, wt));
        }
    }

    public static void dikstras(int arr[][], int n, int src, int k, int dest) {
        @SuppressWarnings("unchecked")
        ArrayList<edge> graph[] = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        createGraph(graph, arr, arr.length);

        int dis[] = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;

        PriorityQueue<pair> q = new PriorityQueue<>();
        q.add(new pair(src, 0, 0));

        while (!q.isEmpty()) {
            pair cur = q.remove();

            if (cur.s == dest) {
                System.out.println(cur.path);
                return;
            }

            if (cur.stops > k)
                continue;

            for (edge e : graph[cur.s]) {
                int v = e.des;
                int newCost = cur.path + e.wt;

                // We allow multiple paths to same node with different stops
                q.add(new pair(v, newCost, cur.stops + 1));
            }
        }

        System.out.println(-1);
    }

    public static void main(String args[]) {
        int arr[][] = {
            {0, 1, 2},
            {0, 1, 100},
            {1, 2, 100},
            {2, 0, 100},
            {1, 3, 600},
            {2, 3, 200},
        };
        int n = 4;
        dikstras(arr, n, 0, 2, 3); // src=0, dest=3, k=2
    }
}
