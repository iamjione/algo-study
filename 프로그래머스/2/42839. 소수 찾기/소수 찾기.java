import java.util.*;

class Solution {
    
    int[] number;
    Set<Integer> set = new HashSet<>();
    int n;
    boolean[] visited;
    
    public int solution(String numbers) {
        n = numbers.length();
        number = new int[n];
        
        for(int i=0; i<n; i++){
            number[i] = numbers.charAt(i)-'0';
        }
        
        for(int i=0; i<n; i++){
            visited = new boolean[n];
            makeNumber(i,-1,0);
        }
        
        return set.size();
    }
    
    /*
    * len : 최종적으로 만들 숫자의 자리수 - 1
    * curr: 현재 만든 숫자의 자리수 - 1
    * num : 만들어진 숫자 
    **/
    public void makeNumber(int len, int curr, int num){
        if(len==curr){
            if(isPrime(num)){
                set.add(num);
            }
            return;
        }
        
        for(int i=0; i<n; i++){
            if(visited[i]) continue;
            
            visited[i] = true;
            makeNumber(len, curr+1, num+number[i]*(int)Math.pow(10,curr+1));
            visited[i] = false;
        }
        
    }
    
    public boolean isPrime(int n) {
        if(n<=1) return false;
        
        for (int i = 2; i<=(int)Math.sqrt(n); i++) {
            if (n % i == 0) return false;
	    }
        
	    return true;
    }
}