import java.util.ArrayList;

public class isMonotonic {
    public static void main(String args[])
    {
           ArrayList<Integer> arr=new ArrayList<>();
           arr.add(1);
           arr.add(2);
           arr.add(1);
           arr.add(4);
           arr.add(5);
           if(isMonotonic(arr))
           System.out.println("yes ");
           else
           System.out.println("NO");
    }
    public static boolean isMonotonic(ArrayList<Integer> A) {
    boolean inc = true;
    boolean dec = true;
    for (int i=0; i<A.size()-1; i++) {
    if (A.get(i) > A.get(i+1))
    inc = false;
    if (A.get(i) < A.get(i+1))
    dec = false;
    }
    return inc || dec;
    }
    
}
