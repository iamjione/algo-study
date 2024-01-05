import java.util.*;

public class Solution {
    public Stack<Integer> solution(int []arr) {
        int[] answer = {};
        
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        
        for(int i=1; i<arr.length; i++){
            if(stack.peek() != arr[i]){
                stack.push(arr[i]);
            }
        }

        return stack;
    }
}