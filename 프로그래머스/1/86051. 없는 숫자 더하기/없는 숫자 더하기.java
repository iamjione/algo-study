import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        Set<Integer> set = new HashSet<>();
        
        for(int n : numbers){
            set.add(n);
        }
        
        for(int i=1; i<10; i++){
            if(!set.contains(i)) answer+= i;
        }
        
        return answer;
    }
}