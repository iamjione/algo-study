import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int work : works) pq.offer(work);
        
        for(int i=0; i<n; i++){
            if(pq.peek()<=0) return 0;
            pq.offer(pq.poll()-1);
        }
        
        while(!pq.isEmpty()){
            answer += pq.peek()*pq.poll();
        }
        return answer;
    }
}