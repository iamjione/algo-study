import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int n : scoville){
            pq.offer(n);
        }
        
        int first, second;
        while(pq.peek() < K && pq.size() >= 2){
            answer++;
            
            first = pq.poll();
            second = pq.poll();
            
            pq.offer(first+second*2);
        }
        
        if(pq.peek() < K) return -1;
        else return answer;
    }
}