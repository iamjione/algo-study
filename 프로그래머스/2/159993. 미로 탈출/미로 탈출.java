import java.util.*;

class Solution {
    
    boolean[][] map;
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};
    
    public int solution(String[] maps) {
        
        int n = maps.length;
        int m = maps[0].length();
        map = new boolean[n][m];
        
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] exit = new int[2];
        
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(maps[i].charAt(j)=='X'){
                    map[i][j] = false;
                }else{
                    map[i][j] = true;
                    
                    if(maps[i].charAt(j)=='S') {
                        start = new int[] {i, j};
                    }else if(maps[i].charAt(j)=='L'){
                        lever = new int[] {i, j};
                    }else if(maps[i].charAt(j)=='E'){
                        exit= new int[] {i, j};
                    }
                }
            }
        }
        
        int d1 = bfs(start, lever, n, m); // 시작점에서 레버 위치까지 최단거리 구하기
        if(d1==-1) return d1;
        
        int d2 = bfs(lever, exit, n, m); // 레버에서 출구까지 최단거리 구하기
        if(d2==-1) return d2;
        
        return d1+d2;
    }
    
    private int bfs(int[] start, int[] end, int n, int m){
        Queue<int[]> q = new ArrayDeque<>();
        int[][] visited = new int[n][m];
        
        q.offer(new int[] {start[0], start[1]});
        visited[start[0]][start[1]] = 1;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            int nr, nc;
            for(int i=0; i<4; i++){
                nr = curr[0]+dr[i];
                nc = curr[1]+dc[i];
                
                if(nr<0 || nr>=n || nc<0 || nc>=m) continue;
                
                // 지나갈 수 있는 길이고 아직 방문하지 않았으면 방문하기
                if(map[nr][nc] && visited[nr][nc]==0){
                    q.offer(new int[] {nr, nc});
                    visited[nr][nc] = visited[curr[0]][curr[1]]+1;
                    
                    // 목적지 도착했으면 이동거리 저장하고 탐색 끝내기
                    if(nr==end[0] && nc==end[1]){
                        return visited[nr][nc]-1;
                    }
                }
            }
        }
        return -1;
    }
}