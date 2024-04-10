class Solution {
    
    int answer = 0;
    boolean[][] board;
    int[] dr = {-1,1,0,0,-1,-1,1,1};
    int[] dc = {0,0,-1,1,-1,1,-1,1};
    
    public int solution(int n) {
        
        board = new boolean[n][n];
        arrange(0, n);
        
        return answer;
    }
    
    private void arrange(int cnt, int n){
        if(cnt == n){
            answer++;
            return;
        }
        
        for(int i=0; i<n; i++){
            if(available(cnt, i, n)){
                board[cnt][i] = true;
                arrange(cnt+1, n);
                board[cnt][i] = false;
            }
        }
    }
    
    // 8방 탐색해서 (r,c)가 공격 당하지 않는 위치인지 확인
    private boolean available(int r, int c, int n){
        int nr, nc;
        for(int i=0; i<8; i++){
            for(int j=1; j<=n; j++){
                nr = r+dr[i]*j;
                nc = c+dc[i]*j;
            
                if(nr<0 || nr>=n || nc<0 || nc>=n) continue;
            
                if(board[nr][nc]) return false;
            }
        }
        
        return true;
    }
}