import java.util.*;

class Solution {
    boolean solution(String s) {

        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i); // s를 괄호 하나씩 분리
            
            if(c == '('){
                // 여는 괄호는 스택에 넣어줌
                stack.push(c);
            }else{
                // 닫는 괄호가 나온 경우 스택에 여는 괄호가 있으면 없애주고
                // 스택이 비어있으면 올바르지 않은 괄호이므로 false 리턴
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    return false;
                }
            }
            
        }
        
        if(stack.isEmpty()) return true;
        else return false; // 스택에 괄호가 남아있으면 올바르지 않은 괄호
    }
}