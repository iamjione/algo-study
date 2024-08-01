import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        // 토핑 종류
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        // 토핑 개수
        int idx = topping.length-1;
        int[] type1 = new int[idx];
        int[] type2 = new int[idx];
        
        set1.add(topping[0]);
        type1[0] = 1;
        
        set2.add(topping[idx]);
        type2[idx-1] = 1;
        
        for(int i=1; i<idx; i++){
            if(set1.contains(topping[i])){
                type1[i] = type1[i-1];
            }else{
                set1.add(topping[i]);
                type1[i] = type1[i-1]+1;
            }
            
            if(set2.contains(topping[idx-i])){
                type2[idx-1-i] = type2[idx-i];
            }else{
                set2.add(topping[idx-i]);
                type2[idx-1-i] = type2[idx-i]+1;
            }
        }
        
        for(int i=0; i<idx; i++){
            if(type1[i] == type2[i]) answer++;
        }
        
        return answer;
    }
}