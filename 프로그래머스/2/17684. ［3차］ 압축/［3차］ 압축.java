import java.util.*;

class Solution {
    
    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dictionary = new HashMap<>();
        boolean[] visited = new boolean[msg.length()];
        
        // 사전에 A~Z 저장
        for(int i=1; i<=26; i++){
            dictionary.put(String.valueOf((char) (64+i)), i);
        }
        
        int idx = 27; // 사전 색인 번호
        for(int i=0; i<msg.length(); i++){ // 시작 인덱스
            if(visited[i]) continue; // 이미 압축된 문자면 넘어가기
            
            for(int j=msg.length(); j>i; j--){ // 끝 인덱스
                String s = msg.substring(i,j);
                if(dictionary.containsKey(s)){
                    // 색인 번호 저장
                    answer.add(dictionary.get(s)); 
                    
                    // 압축 완료 체크
                    for(int k=i; k<j; k++) visited[k] = true;
                    
                    // 마지막 글자인 경우 제외하고 사전 추가(w+c)
                    if(j<msg.length()-1) dictionary.put(s+msg.substring(j, j+1), idx++);
                    break;
                }
            }
        }
        
        return answer;
    }
}