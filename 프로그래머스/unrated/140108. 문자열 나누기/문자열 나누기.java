import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] c = s.toCharArray();
        int sameCnt = 0; // 첫 글자와 같은 글자가 나온 횟수(첫 글자 포함)
        int diffCnt = 0; // 첫 글자와 다른 글자가 나온 횟수
        
        int idx = 0;
        while(idx<c.length){
            char x = c[idx++]; // 첫 글자
            sameCnt++;
            
            while(idx<c.length && sameCnt != diffCnt){
                if(c[idx] == x) sameCnt++;
                else diffCnt++;
                
                if(sameCnt == diffCnt) {
                    answer++;
                    sameCnt = 0;
                    diffCnt = 0;
                }
                idx++;
            }
        }
        
        if(sameCnt != diffCnt) answer++;
        
        return answer;
    }
}