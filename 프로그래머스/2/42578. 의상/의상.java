import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        // Key: 의상 종류, Value: 의상의 개수
        Map<String, Integer> map = new HashMap<>();
        
        // 의상 종류 저장할 Set
        Set<String> set = new HashSet<>();
        
        for(int i=0; i<clothes.length; i++){
            // map에 해당 의상 종류가 이미 있으면 Value값을 +1해주고
            // 없다면 value를 1로 map 에 추가함
            String type = clothes[i][1];
            if(map.containsKey(type)){
                map.replace(type, map.get(type)+1);
            } else{
                map.put(type,1);
            }
            
            // 의상 종류 set에 저장
            set.add(type);
        }
        
        // set을 순회하면서 각 의상 종류의 개수 +1 만큼을 곱해줌
        for(String type : set){
            answer *= map.get(type)+1;
        }
        
        // 최종적으로 -1을 해주면 조합의 수가 나옴
        return answer-1;
    }
}