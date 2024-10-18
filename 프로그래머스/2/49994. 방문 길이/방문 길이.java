class Solution {
    public int solution(String dirs) {
        int answer = 0;

        boolean[][] visited = new boolean[121][121];
        
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        
        int r = 5, c = 5;
        
        char dir;
        int idx = 0;
        int nr, nc, curr, next;
        for(int i=0; i<dirs.length(); i++){
            dir = dirs.charAt(i);
            switch(dir){
                case 'U':
                    idx = 0;
                    break;
                case 'D':
                    idx = 1;
                    break;
                case 'L':
                    idx = 2;
                    break;
                case 'R':
                    idx = 3;
                    break;
            }
            
            nr = r + dr[idx];
            nc = c + dc[idx];
            
            if(nr < 0 || nr >= 11 || nc < 0 || nc >= 11) continue;
            
            curr = 11*r+c;
            next = 11*nr+nc;
            
            if (!visited[curr][next]) {
                answer++;
                
                visited[curr][next] = true;
                visited[next][curr] = true;
            }
            
            r = nr;
            c = nc;
        }
        
        return answer;
    }
}