import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        int len = progresses.length;
        
        Queue<Integer> q = new ArrayDeque<>(); // 기능 완료까지 걸리는 기간 저장할 큐
        
        int days;
        for(int i=0; i<len; i++){
            if((100-progresses[i])%speeds[i] > 0){
                days = (100-progresses[i])/speeds[i]+1;
            }else{
                days = (100-progresses[i])/speeds[i];
            }
            
            q.add(days);
        }
        
        List<Integer> answer = new LinkedList<>();
        
        int curr;
        int cnt;
        while(!q.isEmpty()){
            curr = q.poll();
            cnt = 1;
            
            while(!q.isEmpty() && q.peek()<=curr){
                q.poll();
                cnt++;
            }
            
            answer.add(cnt);
        }
        
        return answer;
    }
}