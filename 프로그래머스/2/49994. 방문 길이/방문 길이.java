class Solution {
    
    int answer = 0;
    Direction[][] grid = new Direction[11][11];
    
    public int solution(String dirs) {
        
        char[] d = dirs.toCharArray();
        
        // 시작점 (5,5)
        int r = 5;
        int c = 5;
        grid[r][c] = new Direction();
        
        int nr, nc;
        for(char direction : d){
            nr = r;
            nc = c;
            switch (direction){
                case 'U':
                    nr++;
                    break;
                case 'D':
                    nr--;
                    break;
                case 'R':
                    nc ++;
                    break;
                case 'L':
                    nc--;
            }
            
            if(nr<0 || nr>10 || nc<0 || nc>10) continue; // 배열 범위 벗어난 경우
            
            // 배열이 null이면 초기화해주기
            if (grid[nr][nc] == null) {
                grid[nr][nc] = new Direction();
            }
            
            // grid[r][c]에서 grid[nr][nc]로 direction 방향으로 이동하는 거 기록하기
            updateDirection(r, c, nr, nc, direction);
            
            r = nr;
            c = nc;
        }
        
        return answer;
    }
    
    private void updateDirection(int r, int c, int nr, int nc, char direction) {
        switch (direction) {
            case 'U':
                if(!grid[r][c].U){
                    grid[r][c].U = true;
                    grid[nr][nc].D = true;
                    answer ++;
                }
                break;
            case 'D':
                if(!grid[r][c].D){
                    grid[r][c].D = true;
                    grid[nr][nc].U = true;
                    answer ++;
                }
                break;
            case 'R':
                if(!grid[r][c].R){
                    grid[r][c].R = true;
                    grid[nr][nc].L = true;
                    answer ++;
                }
                break;
            case 'L':
                if(!grid[r][c].L){
                    grid[r][c].L = true;
                    grid[nr][nc].R = true;
                    answer ++;
                }
                break;
        }
    }
    
    class Direction {
        boolean U;
        boolean D;
        boolean R;
        boolean L;
    }
    
}