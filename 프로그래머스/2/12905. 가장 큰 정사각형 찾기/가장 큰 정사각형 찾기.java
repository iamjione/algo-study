class Solution
{
    public int solution(int [][]board)
    {
        int max = 0;
        
        int r = board.length;
        int c = board[0].length;
        
        int[][] dp = new int[r][c];
        
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(board[i][j] == 0) continue;
                
                if(i==0 || j==0) dp[i][j] = 1;
                else dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) +1;
                max = Math.max(max, dp[i][j]);
            }
        }
        
        return max*max;
    }
}