import java.util.*;

class Solution
{
    public int solution(String s)
    {
        char[] c = s.toCharArray();
        Queue<Character> queue = new ArrayDeque<>();
        for(int i=0; i<c.length; i++) queue.add(c[i]);
        
        Stack<Character> stack = new Stack<>();
        
        while(!queue.isEmpty()){
            if(!stack.isEmpty() && stack.peek()==queue.peek()){
                stack.pop();
                queue.poll();
            }else{
                stack.add(queue.poll());
            }
        }
        if(stack.isEmpty()) return 1;
        else return 0;
    }
}