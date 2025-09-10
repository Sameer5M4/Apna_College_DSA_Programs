import java.util.*;
public class kurshkals 
{
    static class Edge implements Comparable<Edge>
    {
       int src;
       int des;
       int wt;
       Edge(int s,int d,int w)
       {
        this.src=s;
        this.des=d;
        this.wt=w;
       }
       @Override
       public int compareTo(Edge e2)
       {
        return this.wt-e2.wt;
       }
    }
    public static void create(ArrayList<Edge> edges)
    {
        edges.add(new Edge(0,1,10));
        edges.add(new Edge(0,2,15));
        edges.add(new Edge(0,3,30));
        edges.add(new Edge(1,3,40));
        edges.add(new Edge(2,3,50));
    }

    static int n=4;
    static int par[]=new int[4];
    static int rank[]=new int[4];

    public static void init()
    {
        for(int i=0;i<4;i++)
        par[i]=i;
    }

    public static int find(int ele)
    {
        if(par[ele]==ele)
        return ele;
        return par[ele]=find(par[ele]);
    }
    public static void union(int ele1,int ele2)
    {
        int par1=find(ele1);
        int par2=find(ele2);
        if(rank[par1]>=rank[par2])
        {
            par[par2]=par1;
            if(rank[par1]==rank[par2])
            rank[par1]+=1;
        }
        else
        {
            par[par1]=par2;
        }
    }
    public static void kurshkalsMST(ArrayList<Edge> edges,int v)
    {
        init();
        Collections.sort(edges);
        int count=0;
        int mstCost=0;
        for(int i=0;count<v-1;i++)
        {
            Edge e=edges.get(i);
            int sr=e.src;
            int d=e.des;
            int w=e.wt;
            int parA=find(sr);
            int parB=find(d);
            if(parA!=parB)
            {
                union(sr,d);
                mstCost+=w;
                count++;
            }
            
        }
        System.out.println(mstCost);

    }

    public static void main(String args[])
    {
      
        int v=4;
        ArrayList<Edge> edges=new ArrayList<>();
        create(edges);
        kurshkalsMST(edges,v);
    }
    
}
