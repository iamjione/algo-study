import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        long start = 1;
        long end = (long)times[times.length-1] * n;
        long mid, cnt;
        
        while(start <= end){
            mid = (start+end)/2;
            
            cnt = 0; // mid시간 동안 입국 심사 받을 수 있는 사람 수
            for(int time : times){
                cnt += (long)mid/time;
            }
            
            if(cnt >= n){
                answer = mid;
                end = mid-1;  
            }else{
                start = mid+1;
            }
        }
        
        return answer;
    }
}