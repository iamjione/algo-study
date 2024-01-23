class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int sum, idx;
        for(int i=1; i<=n; i++){
            sum = 0;
            idx = i;
            
            while(sum<n){
                sum += idx++;
            }
            
            if(sum == n) answer++;
        }
        return answer;
    }
}