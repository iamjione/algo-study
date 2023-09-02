import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        int n = players.length;
        for(int i=0; i<n; i++){
            map.put(players[i], i); // key: 선수 이름, value: 순위
        }
        for(int i=0; i<callings.length; i++){
            int curr = map.get(callings[i]); // 이름 불린 선수의 기존 순위
            map.replace(callings[i], curr-1); // 이름 불린 선수 순위 올리기
            map.replace(players[curr-1], curr); // 추월 당한 선수 순위 내리기
            
            // players 배열에서 순서 변경
            players[curr] = players[curr-1];
            players[curr-1] = callings[i];
        }
       
        return players;
    }
}