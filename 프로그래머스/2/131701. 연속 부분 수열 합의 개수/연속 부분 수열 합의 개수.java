import java.util.*;

class Solution {
    
    Set<Integer> set = new HashSet<>();
    
    public int solution(int[] elements) {
        
        for(int i=0; i<elements.length; i++){ // 시작 인덱스
            for(int j=1; j<=elements.length; j++){ // 부분 수열 크기
                makeSum(i,j, elements);
            }
        }

        return set.size();
    }
    
    private void makeSum(int start, int size, int[] elements){
        int sum = 0;
        for(int i=start; i<start+size; i++){
            if(i>=elements.length) sum += elements[i-elements.length];
            else sum += elements[i];
        }
        
        set.add(sum);
    }
}