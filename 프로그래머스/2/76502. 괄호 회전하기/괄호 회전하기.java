import java.util.*;

class Solution {
    
    int answer = 0;
    char[] c;
    Stack<Character> stack;
    
    public int solution(String s) {
        c = s.toCharArray();
        
        for(int i=0; i<s.length(); i++){
            rotate(i);
        }
        
        return answer;
    }
    
    private void rotate(int n) {
        stack = new Stack<>();
        
        for(int i=n; i<c.length; i++){
            if(!check(c[i])) return;
        }
        
        for(int i=0; i<=n-1; i++){
            if(!check(c[i])) return;
        }
        
        if(stack.isEmpty()) answer++;
        
        return;
    }

    private boolean check(char c){
        if(c == '(' || c =='[' || c == '{'){
            stack.push(c);
        }else if(c == ')'){
            if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
            else return false;
        }else if(c == ']'){
            if(!stack.isEmpty() && stack.peek() == '[') stack.pop();
            else return false;
        }else{
            if(!stack.isEmpty() && stack.peek() == '{') stack.pop();
            else return false;
        }
        
        return true;
    }
}