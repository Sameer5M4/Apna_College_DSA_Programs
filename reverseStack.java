import java.util.*;
public class reverseStack 
{
    public static void main(String args[])
    {
        Stack<Integer> s=new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        reverse(s);
        print(s);
    }
    public static void reverse(Stack<Integer> s)
    {
        if(s.isEmpty())
        return;
        Integer ele=s.pop();
        reverse(s);
        bottom(s,ele);
    }
    public static void bottom(Stack<Integer> s,Integer ele)
    {
        if(s.isEmpty())
        {
            s.push(ele);
            return;
        }
        int top=s.pop();
        bottom(s,ele);
        s.push(top);
    }
    public static void print(Stack<Integer> s)
    {
        while(!s.isEmpty())
        System.out.println(s.pop()+" ");
    }
}
