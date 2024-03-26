import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        
        int start = 0;
        int end = k-1;
        int min = 200000001; // max의 최소값

        Deque<Integer> deque = new ArrayDeque<>(); // 연속된 k개의 징검다리 중 최대값 구하기 위한 덱 (가장 앞에 값이 항상 최대값)
        
        for(int i=0; i<stones.length; i++){
            // 범위 벗어난 인덱스 제거
            while(!deque.isEmpty() && deque.peek()<=i-k){
                deque.remove();
            }
            
            // 새로 추가한 디딤돌보다 숫자 작은 디딤돌의 인덱스 제거
            while(!deque.isEmpty() && stones[deque.peekLast()]<=stones[i]){
                deque.removeLast();
            }
            
            // 새로운 디딤돌의 인덱스 추가
            deque.addLast(i);
            
            // max의 최소값 갱신
            if(i<k-1) continue;
            if(stones[deque.peek()]<min) min = stones[deque.peek()];
        }
        
        return min;
    }
}