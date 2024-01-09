import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
            int start = commands[i][0]-1;
            int end = commands[i][1];
            int k = commands[i][2];
            
            int[] arr = new int[end-start];
            for(int j=0; j<arr.length; j++){
                arr[j] = array[start++];
            }
            
            Arrays.sort(arr);
            
            answer[i] = arr[k-1];
        }
        
        return answer;
    }
}