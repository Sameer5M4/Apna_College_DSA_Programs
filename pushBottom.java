import java.util.*;
public class pushBottom {

    public static void main(String args[])
    {
        Stack<Integer> s=new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        int data=5;
        bottom(s,data);
        while(!s.isEmpty())
        System.out.println(s.pop());

    }
    public static void bottom(Stack<Integer> s,int data)
    {
        if(s.isEmpty())
        {
            s.push(data);
            return;
        }
        int top=s.pop();
        bottom(s,data);
        s.push(top);
    }
    
    
}
