import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        
        Stack<int[]> stack = new Stack<>(); // {가격, 인덱스} 넣을 스택
        for(int i=0; i<len; i++){
            if(stack.isEmpty() || stack.peek()[0]<=prices[i]){
                // 가격 떨어지지 않았으면 스택에 넣기
                stack.push(new int[]{prices[i], i});
            }else{
                // 가격 떨어졌으면 현재 가격보다 더 높은 가격들
                // 몇초동안 떨어지지 않았는지 answer에 저장 & 스택에서 제거
                while(!stack.isEmpty() && stack.peek()[0]>prices[i]){
                    answer[stack.peek()[1]] = i-stack.peek()[1];
                    stack.pop();
                }
                // 현재 가격 스택에 넣기
                stack.push(new int[]{prices[i], i});
            }
        }
        
        // 스택에 남아있는 가격들의 가격 떨어지지 않은 기간 answer에 저장
        while(!stack.isEmpty()){
            answer[stack.peek()[1]] = len-stack.peek()[1]-1;
            stack.pop();
        }
        
        return answer;
    }
}