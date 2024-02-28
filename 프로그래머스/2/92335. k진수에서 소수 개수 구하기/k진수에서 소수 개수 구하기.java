class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        //n을 k진수로 변환한 후 0을 기준으로 분리하기
        String[] arr = Integer.toString(n,k).split("0");
        
        for(String s: arr){
            // s가 빈칸이거나 1이면 소수 검사할 필요 X
            if(s.equals("") || s.equals("1")) continue;
            
            // s가 소수면 answer++
            if(isPrimeNumber(Long.parseLong(s))) answer++;
        }
        return answer;
    }
    
    boolean isPrimeNumber(long num){
        for(int i=2; i<=(long)Math.sqrt(num); i++){
            if(num%i == 0) return false;
        }
        
        return true;
    }
}