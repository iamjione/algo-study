import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : scoville){
            pq.add(num);
        }
        
        int n, m, mix;
        while(pq.size()>1){
            n = pq.poll(); // 가장 안 매운 음식의 스코빌 지수
            if(n<K){
                m = pq.poll(); // 두번째로 안 매운 음식의 스코빌 지수
                mix = n + m*2; // n과 m을 섞은 음식의 스코빌 지수
                answer++;
                pq.add(mix);// mix를 우선순위 큐에 추가
            }else{
                break;
            }
        }
        
        if(pq.peek()>=K) return answer;
        else return -1;
    }
}