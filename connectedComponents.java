
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0) 
        {
          int n=sc.nextInt();
          int m=sc.nextInt();
          ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
          for(int i=0;i<=n;i++)
          graph.add(new ArrayList<>());
          boolean vis[]=new boolean[n+1];
          Arrays.fill(vis,false);
          int count=0;
          for(int i=1;i<=m;i++)
          {
            int s=sc.nextInt();
            int d=sc.nextInt();
            graph.get(s).add(d);
            graph.get(d).add(s);
          }
          for(int i=1;i<=n;i++)
          {
            if(!vis[i])
            {
              count++;
              dfs(graph,i,vis);
            }
          }
          System.out.println(count);

        }
       
     }
     public static void dfs(ArrayList<ArrayList<Integer>> graph,int i,boolean vis[])
     {
        vis[i]=true;
        for(int x :graph.get(i))
        {
          if(!vis[x])
            dfs(graph,x,vis);
        }

     }
}