import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : d) pq.offer(n);
        
        while(!pq.isEmpty() && budget-pq.peek()>=0){
            budget -= pq.poll();
            answer++;
        }
        
        return answer;
    }
}