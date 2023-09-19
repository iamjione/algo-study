import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int[] cnt = new int[10000001];
        for(int i=0; i<tangerine.length; i++){
            cnt[tangerine[i]]++;
        }
        
        Arrays.sort(cnt);
        
        int idx = 10000000;
        while(k>0){
            k -= cnt[idx--];
            answer++;
        }
        
        return answer;
    }
}