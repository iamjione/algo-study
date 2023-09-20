import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int n = arr.length;
        int[] answer;
        if(n == 1){
            answer = new int[1];
            answer[0] = -1;
        } else{
            answer = new int[n-1];
            int min = Integer.MAX_VALUE;
            for(int i=0; i<n; i++){
                if(min>arr[i]) min = arr[i];
            }
            int idx = 0;
            for(int i=0; i<n; i++){
                if(arr[i]==min) continue;
                
                answer[idx++] = arr[i];
            }
        }
        return answer;
    }
}