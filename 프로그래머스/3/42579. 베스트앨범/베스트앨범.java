import java.util.*;

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        int len = genres.length;
        
        // 장르 인덱스 지정
        Map<String, Integer> index = new HashMap<>();
        int idx = 0;
        for(String genre : genres){
            if(!index.containsKey(genre)){
                index.put(genre, idx++);
            }
        }
        
        Map<String, Integer> total = new HashMap<>(); // 장르별 총 재생 횟수 저장

        ArrayList<int[]>[] list = new ArrayList[len]; // 장르별 재생횟수, 고유 번호 저장
        for(int i=0; i<len; i++) {
            list[i] = new ArrayList<int[]>();
        }
        
        for(int i=0; i<genres.length; i++){
            // 장르별 총 재생 횟수 저장
            total.put(genres[i], total.getOrDefault(genres[i], 0)+plays[i]);
            
            // 재생 횟수, 고유 번호 저장
            list[index.get(genres[i])].add(new int[] {plays[i], i});    
        }
        
        // 재생 횟수 기준으로 장르 내림차순 정렬
        List<String> keySet = new ArrayList<>(total.keySet());
        keySet.sort((o1, o2) -> total.get(o2).compareTo(total.get(o1)));

        for (String key : keySet) {
            // 재생 횟수 기준 정렬
            Collections.sort(list[index.get(key)], (a, b) -> Integer.compare(b[0], a[0]));
            // 가장 많이 재생된 노래의 고유 번호 answer에 추가
            answer.add(list[index.get(key)].get(0)[1]);
            // 두번째 노래가 있으면 두번째로 많이 재생된 노래의 고유 번호 answer에 추가
            if(list[index.get(key)].size()>=2) answer.add(list[index.get(key)].get(1)[1]); 
        }
        
        return answer;
    }
}
