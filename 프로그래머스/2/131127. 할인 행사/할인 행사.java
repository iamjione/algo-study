import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        // 인덱스 i부터 10일간의 할인 품목 확인하기
        Map<String, Integer> map;
        boolean isDiscounted;
        for(int i=0; i<=discount.length-10; i++){
            map = new HashMap<>();
            for(int j=i; j<i+10; j++){
                if(map.containsKey(discount[j])){
                    map.replace(discount[j], map.get(discount[j])+1);
                } else {
                    map.put(discount[j], 1);
                }
            }
            
            isDiscounted = true; // 원하는 모든 항목을 할인 받았는지 여부
            for(int j=0; j<want.length; j++){
                if(!map.containsKey(want[j]) || map.get(want[j]) < number[j]) isDiscounted = false;
            }
            
            if(isDiscounted) answer++;
        }
        return answer;
    }
}