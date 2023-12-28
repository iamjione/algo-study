import java.util.*;

public class Solution {
    public int solution(int n) {
        
        int answer = 0;
        
        int d = 100000000;
        
        while(n>0){
            if(n>=d){
                answer += n/d;
                n = n%d;
            }
            
            d /= 10;
        }
        
        return answer;
    }
}