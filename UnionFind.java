public class UnionFind {
    public static int find(int ele,int par[])
    {
            if(par[ele]==ele)
             return ele;

            ele=par[ele];
                
            return par[ele]=find(ele,par);
            
          
    }
    public static void union(int ele1,int ele2,int[] parent,int[] rank)
    {
        int ele1Parent= find(ele1,parent);
        int ele2Parent= find(ele2,parent);

        if(rank[ele1Parent]>=rank[ele2Parent])
        {
            parent[ele2Parent]=ele1Parent;
            if(rank[ele1Parent]==rank[ele2Parent])  
            rank[ele1Parent]+=1;

        }
        else
        {
            parent[ele1Parent]=ele2Parent;
        }

    }
    public static void main(String[] args)
    {
        int n=7;
        int parent[]=new int[n+1];
        int rank[]=new int[n+1];
        for(int i=0;i<n;i++)
        {
        parent[i]=i;
        rank[i]=0;
        }
        union(1,3,parent,rank);
        System.out.println(find(3,parent));
        union(2,3,parent,rank);
        union(3,6,parent,rank);
        union(1,4,parent,rank);
        System.out.println(find(4,parent));
        union(1,5,parent,rank);
        System.out.print("Parents : ");
        for(int i=0;i<n;i++)
        {
         System.out.print(parent[i]+" ");
        }

        System.out.println("Rank : ");

        for(int i=0;i<n;i++)
        {
         System.out.print(rank[i]+" ");
        }



    }
    
}
