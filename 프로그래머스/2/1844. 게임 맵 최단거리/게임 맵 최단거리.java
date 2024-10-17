import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        int[][] visited = new int[n][m];
        visited[n-1][m-1] = -1;
        
        int[][] d = {{1,0},{0,1},{-1,0},{0,-1}};
        
        Queue<int[]> q = new ArrayDeque<>();
        
        q.add(new int[] {0,0});
        visited[0][0] = 1;
        
        int[] curr;
        int nr, nc;
        while(!q.isEmpty()){
            curr = q.poll();
            
            for(int i=0; i<4; i++){
                nr = curr[0] + d[i][0];
                nc = curr[1] + d[i][1];
                
                if(nr<0 || nr>=n || nc<0 || nc>=m) continue;
                if(visited[nr][nc] > 0 || maps[nr][nc] == 0) continue;
                
                q.add(new int[] {nr,nc});
                visited[nr][nc] = visited[curr[0]][curr[1]]+1;
            }
        }
        
        return visited[n-1][m-1];
    }
}