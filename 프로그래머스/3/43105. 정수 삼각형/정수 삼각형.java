class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int len = triangle.length;
        int[][] dp = new int[len][len];
        
        dp[0][0] = triangle[0][0];
        for(int i=1; i<len; i++){
            for(int j=0; j<i+1; j++){
                if(j==0) dp[i][j] = triangle[i][j] + dp[i-1][j];
                else if(j==i) dp[i][j] = triangle[i][j] + dp[i-1][j-1];
                else dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j], dp[i-1][j-1]);
            }
        }
        
        for(int n : dp[len-1]){
            if(n>answer) answer = n;
        }
        
        return answer;
    }
}