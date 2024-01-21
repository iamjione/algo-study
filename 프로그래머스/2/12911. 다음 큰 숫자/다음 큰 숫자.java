class Solution {
    public int solution(int n) {
        int cnt = countOnes(n);        
        int answer = findNextBiggerNumber(n,cnt);

        return answer;
    }
    
    private int countOnes(int n){
        int cnt = 0;
        
        while (n != 0) {
            cnt += n & 1; // 가장 오른쪽 비트가 1이면 카운트
            n = n >>> 1; // 오른쪽으로 1만큼 시프트
        }
        
        return cnt;
    }
    
    private int findNextBiggerNumber(int n, int cnt){
        boolean isFound = false;
        
        while(!isFound){
            if(countOnes(++n) == cnt){
                isFound = true;
            }
        }
        
        return n;
    }
}