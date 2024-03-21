class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int len = triangle.length;
        int[][] dp = new int[len][len];
        
        dp[0][0] = triangle[0][0];
        for(int i=1; i<len; i++){
            dp[i][0] = triangle[i][0] + dp[i-1][0];
            for(int j=1; j<i; j++){
                dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j], dp[i-1][j-1]);
            }
            dp[i][i] = triangle[i][i] + dp[i-1][i-1];
        }
        
        for(int n : dp[len-1]){
            if(n>answer) answer = n;
        }
        
        return answer;
    }
}