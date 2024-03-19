import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long answer = 0;
        long start = 1;
        long end = (long)times[0]*n;
       
        while(start<=end) {
			long mid = (start+end)/2;
			
			long sum = 0;
			for(int time : times) {
				sum += (long)mid/time;
			}
			
            if(sum>=n) {
                answer = mid;
				end = mid-1;
			}else {
				start = mid+1;
            }
		}

        return answer;
    }
}