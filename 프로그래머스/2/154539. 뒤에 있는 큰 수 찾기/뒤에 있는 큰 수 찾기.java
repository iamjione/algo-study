import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        
        Stack<Integer> stack = new Stack<>();
        
        stack.push(0);
        
        for(int i=1; i<len; i++){
            // 스택에 numbers[i] 보다 작은 값을 갖는 인덱스가 있다면
            // 스택에서 빼주고 그 인덱스에 해당하는 answer에 numbers[i] 저장
            while(!stack.isEmpty() && numbers[stack.peek()]<numbers[i]){
                answer[stack.pop()] = numbers[i];
            }
            
            // 스택에 인덱스 i 넣기
            stack.push(i);
        }
        
        // 스택에 남아있는 인덱스는 뒤에 있는 큰 수가 없는 인덱스이므로
        // 스택에서 하나씩 빼면서 answer에 -1 저장하기
        while(!stack.isEmpty()){
            answer[stack.pop()] = -1;
        }
        
        return answer;
    }
}