import java.util.*;
import java.lang.Math;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        Queue<Integer> q = new ArrayDeque<>();
        for(int progress : progresses){
            q.offer(progress);
        }
        
        int day = 0;// q 가장 앞에 있는 기능의 배포 가능 일자
        int idx = 0;
        int cnt; // 배포할 수 있는 기능의 개수
        
        while(!q.isEmpty()){
            cnt = 0;
            
            day = (int)Math.ceil((double)(100 - q.peek()) / speeds[idx]);
            
            while(!q.isEmpty()){
                if(q.peek()+speeds[idx]*day>=100){
                    q.poll();
                    idx++;
                    cnt++;
                }else{
                    break;
                }
            }
            
            answer.add(cnt);
        }
        
        return answer;
    }
}