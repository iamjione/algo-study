import java.util.*;

class Solution {

    public int[] solution(String[] gems) {
        int[] answer = {1, gems.length};
        
        // 보석 종류 세기
        Set<String> types = new HashSet<>();
        for(String gem : gems) types.add(gem);
        
        Map<String, Integer> map = new HashMap<>(); // 범위 내에 속한 보석,개수
        Set<String> set = new HashSet<>(); // 범위 내에 속한 보석 종류의 집합
        
        int start = 0;
        int end = 0;
        
        while(end<gems.length){
            map.put(gems[end], map.getOrDefault(gems[end], 0)+1);
            set.add(gems[end]);
            
            //현재 범위의 첫번째 보석이 범위 내에 또 있으면 범위 줄이기
            while(map.get(gems[start])>1){
                map.replace(gems[start], map.get(gems[start]) - 1);
                start++;
            }
            
            // 모든 보석을 포함하고 기존보다 짧은 구간이라면 answer 갱신
            if(set.size() == types.size() && end-start<answer[1]-answer[0]) {
                answer[0] = start + 1;
                answer[1] = end + 1;
            }
            
            end++;
        }
        
        return answer;
    }
    
}