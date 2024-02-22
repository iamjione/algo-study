import java.util.*;

class Solution {
    
    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        List<String> dictionary = new ArrayList<>();
        boolean[] visited = new boolean[msg.length()];
        
        // 0번 인덱스 비워두기
        dictionary.add(null);
        // 1~26까지의 인덱스에 A~Z 저장
        for(int i=0; i<26; i++){
            dictionary.add(String.valueOf((char) (65+i)));
        }
        
        for(int i=0; i<msg.length(); i++){ // 시작 인덱스
            if(visited[i]) continue; // 이미 압축된 문자면 넘어가기
            
            for(int j=msg.length(); j>i; j--){ // 끝 인덱스
                String s = msg.substring(i,j);
                if(dictionary.contains(s)){
                    // 색인 번호 저장
                    answer.add(dictionary.indexOf(s)); 
                    
                    // 압축 완료 체크
                    for(int k=i; k<j; k++) visited[k] = true;
                    
                    // 마지막 글자인 경우 제외하고 사전 추가(w+c)
                    if(j<msg.length()-1) dictionary.add(s+msg.substring(j, j+1));
                    break;
                }
            }
        }
        
        return answer;
    }
}