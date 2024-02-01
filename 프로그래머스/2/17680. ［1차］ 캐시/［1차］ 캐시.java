import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        LinkedList<String> cacheData = new LinkedList<>();
        
        for(int i=0; i<cities.length; i++){
            String city = cities[i].toLowerCase();
            if(cacheData.contains(city)){
                // cache hit인 경우 cache hit인 데이터 맨 뒤로 이동
                answer += 1;
                cacheData.remove(city);
                cacheData.addLast(city);
            }else {
                // cache miss인 경우 데이터 추가
                // 캐시 가득 찬 경우 제일 앞에 있는 값 제거
                answer += 5;
                cacheData.addLast(city);
                if(cacheData.size()>cacheSize) cacheData.removeFirst();
            }
        }
        
        return answer;
    }
}