import java.lang.StringBuilder;

class Solution {
    public String solution(String s, int n) {
        char[] arr = s.toCharArray();
        
        StringBuilder sb = new StringBuilder();

        for(char c: arr) {
            if(c==' '){ // 공백
                sb.append(" ");
            }else if(c<=90){ // 대문자
                if(c+n<=90) sb.append((char) (c+n));
                else sb.append((char) (c+n-26));
            }else{ // 소문자
                if(c+n<=122) sb.append((char) (c+n));
                else sb.append((char) (c+n-26));
            }
        }
        return sb.toString();
    }
}
