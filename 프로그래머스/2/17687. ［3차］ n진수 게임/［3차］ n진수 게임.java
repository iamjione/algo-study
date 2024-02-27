import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        
        int curr = 1; // 현재 순서
        int num = 0; // 현재 숫자
        while(sb.length()<t){
            String s = Integer.toString(num++, n).toUpperCase();
            for(int j=0; j<s.length(); j++){
                if(curr++ == p){
                    sb.append(s.charAt(j));
                    if(sb.length() == t) break;
                    p += m;
                }
            }
        }
        
        return sb.toString();
    }
}